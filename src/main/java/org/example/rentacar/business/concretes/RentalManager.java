package org.example.rentacar.business.concretes;

import org.example.rentacar.abstracts.RentalRepository;
import org.example.rentacar.business.abstracts.CarService;
import org.example.rentacar.business.abstracts.InvoiceService;
import org.example.rentacar.business.abstracts.PaymentService;
import org.example.rentacar.business.abstracts.RentalService;
import org.example.rentacar.business.dto.requests.create.CreateInvoiceRequest;
import org.example.rentacar.business.dto.requests.create.CreateRentalRequest;
import org.example.rentacar.business.dto.requests.update.UpdateRentalRequest;
import org.example.rentacar.business.dto.responses.create.CreateRentalResponse;
import org.example.rentacar.business.dto.responses.get.Car.GetCarResponse;
import org.example.rentacar.business.dto.responses.get.Rental.GetAllRentalsResponse;
import org.example.rentacar.business.dto.responses.get.Rental.GetRentalResponse;
import org.example.rentacar.business.dto.responses.update.UpdateRentalResponse;
import org.example.rentacar.business.rules.RentalBusinessRules;
import org.example.rentacar.common.dto.CreateRentalPaymentRequest;
import org.example.rentacar.entities.concretes.Rental;
import org.example.rentacar.entities.enums.State;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class RentalManager implements RentalService {
    private final RentalRepository repository;
    private final ModelMapper mapper;
    private final CarService carService;
    private final PaymentService paymentService;
    private final InvoiceService invoiceService;
    private final RentalBusinessRules rules;

    @Override
    public List<GetAllRentalsResponse> getAll() {
        List<Rental> rentals = repository.findAll();

        return rentals
                .stream()
                .map(rental -> mapper.map(rental, GetAllRentalsResponse.class))
                .toList();
    }

    @Override
    public GetRentalResponse getById(int id) {
        rules.checkIfRentalExists(id);
        Rental rental = repository.findById(id).orElseThrow();

        return mapper.map(rental, GetRentalResponse.class);
    }

    @Override
    public CreateRentalResponse add(CreateRentalRequest request) {
        rules.checkIfCarAvailable(carService.getById(request.getCarId()).getState());
        Rental rental = mapper.map(request, Rental.class);
        rental.setId(0);
        rental.setTotalPrice(getTotalPrice(rental));
        rental.setStartDate(LocalDateTime.now());

        //Payment Create
        CreateRentalPaymentRequest paymentRequest = new CreateRentalPaymentRequest();
        mapper.map(request.getPaymentRequest(), paymentRequest);
        paymentRequest.setPrice(getTotalPrice(rental));
        paymentService.processRentalPayment(paymentRequest);

        repository.save(rental);
        carService.changeState(rental.getCar().getId(), State.RENTED);

        //Invoice Create
        CreateInvoiceRequest invoiceRequest = new CreateInvoiceRequest();
        createInvoiceRequest(request, invoiceRequest, rental);
        invoiceService.add(invoiceRequest);

        return mapper.map(rental, CreateRentalResponse.class);
    }


    @Override
    public UpdateRentalResponse update(int id, UpdateRentalRequest request) {
        rules.checkIfRentalExists(id);
        Rental rental = mapper.map(request, Rental.class);
        rental.setId(id);
        rental.setTotalPrice(getTotalPrice(rental));
        repository.save(rental);
        return mapper.map(rental, UpdateRentalResponse.class);
    }

    @Override
    public void delete(int id) {
        rules.checkIfRentalExists(id);
        int carId = repository.findById(id).get().getCar().getId();
        carService.changeState(carId, State.AVAILABLE);
        repository.deleteById(id);
    }


    public double getTotalPrice(Rental rental) {
        return rental.getDailyPrice() * rental.getRentedForDays();
    }

    private void createInvoiceRequest(CreateRentalRequest request, CreateInvoiceRequest invoiceRequest, Rental rental) {
        GetCarResponse car = carService.getById(request.getCarId());

        invoiceRequest.setRentedAt(rental.getStartDate());
        invoiceRequest.setModelNAme(car.getModelName());
        invoiceRequest.setBrandName(car.getModelBrandName());
        invoiceRequest.setDailyPrice(request.getDailyPrice());
        invoiceRequest.setPlate(car.getPlate());
        invoiceRequest.setCardHolder(request.getPaymentRequest().getCardHolder());
        invoiceRequest.setModelYear(car.getModelYear());
        invoiceRequest.setRentedForDays(request.getRentedForDays());
    }
}

