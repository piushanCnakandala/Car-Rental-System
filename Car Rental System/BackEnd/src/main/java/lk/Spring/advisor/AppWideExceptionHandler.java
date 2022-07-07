package lk.Spring.advisor;

import lk.Spring.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestControllerAdvice
@CrossOrigin
public class AppWideExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({Exception.class})
    public ResponseUtil  exceptionHandler(Exception e){
        return new ResponseUtil(500,e.getMessage(),null);
    }
}
