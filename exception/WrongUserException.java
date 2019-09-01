package exam.exception;

import java.io.IOException;

public class WrongUserException extends IOException {
    public WrongUserException(String message) {
        super(message);
    }
}
