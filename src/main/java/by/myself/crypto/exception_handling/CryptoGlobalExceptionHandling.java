package by.myself.crypto.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CryptoGlobalExceptionHandling {

    @ExceptionHandler
    ResponseEntity<CryptoIncorrectData> handleException(NoSuchCryptoException exception) {
        CryptoIncorrectData restaurantIncorrectData = new CryptoIncorrectData();
        restaurantIncorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(restaurantIncorrectData, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CryptoIncorrectData> handleException(Exception exception) {
        CryptoIncorrectData restaurantIncorrectData = new CryptoIncorrectData();
        restaurantIncorrectData.setInfo(exception.getMessage());

        return new ResponseEntity<>(restaurantIncorrectData, HttpStatus.BAD_REQUEST);
    }
}
