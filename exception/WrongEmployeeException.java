package exam.exception;

import java.io.IOException;

public class WrongEmployeeException extends IOException {
    public WrongEmployeeException(String message) {
        super(message);
    }
}
