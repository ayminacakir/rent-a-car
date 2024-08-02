package org.example.rentacar.adapters;

import org.example.rentacar.business.abstracts.PosService;
import org.example.rentacar.common.constants.Messages;
import org.example.rentacar.core.exceptions.BusinessException;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class FakePosServiceAdapter implements PosService {
    @Override
    public void pay() {
        boolean isPaymentSuccessful = new Random().nextBoolean();
        if (!isPaymentSuccessful)
            throw new BusinessException(Messages.Payment.Failed);
    }
}
