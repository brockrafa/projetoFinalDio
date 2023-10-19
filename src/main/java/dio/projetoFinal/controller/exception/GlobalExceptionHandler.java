package dio.projetoFinal.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handlenotFound(NoSuchElementException notFound){
        return new ResponseEntity<>("Não foi possivel encontrar o proprietario com o ID informado", HttpStatus.NOT_FOUND);
    }
}
