package org.example.rentacar.core.utils.results;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class ExceptionResult<T> { //ExceptionResult<T> sınıfı, bir hata veya istisna durumunu temsil eden bir veri yapısıdır
    private LocalDateTime timestamp;
    private String type;
    private T message;

    public ExceptionResult(String type, T message) {
        this.timestamp = LocalDateTime.now();
        this.type = type;
        this.message = message;
    }
}
