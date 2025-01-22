package Haluta.example.demo.exception;

import Haluta.example.demo.constant.errormessage.ErrorMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class IllegalArgumentException extends Exception{
    private final ErrorMessage err;

    public IllegalArgumentException(ErrorMessage err) {
        super(err.getMessage());
        this.err = err;
    }
    // Constructor với thông điệp tùy chỉnh
    public IllegalArgumentException(ErrorMessage err, String message) {
        super(message);
        this.err = err;
    }
}
