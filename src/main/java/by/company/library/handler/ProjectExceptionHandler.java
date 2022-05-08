package by.company.library.handler;

import by.company.library.domain.error.ApiError;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/*import org.springframework.security.core.userdetails.UsernameNotFoundException;*/
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ProjectExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
    protected ResponseEntity<Object> handleEntityNotFound(IllegalArgumentException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiError apiError = new ApiError(status, LocalDateTime.now(), ex.getMessage());
        apiError.setMessage(ex.getMessage());
        return super.handleExceptionInternal(ex, apiError, headers, status, request);
    }

/*
    @ExceptionHandler(UsernameNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(UsernameNotFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiError apiError = new ApiError(status, LocalDateTime.now(), ex.getMessage());
        apiError.setMessage(ex.getMessage());
        return super.handleExceptionInternal(ex, apiError, headers, status, request);
    }
*/

}
