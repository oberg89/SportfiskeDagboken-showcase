package se.anglerlog.showcase.common;

import java.time.Instant;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(ApiException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    Map<String, Object> handle(ApiException exception) {
        return Map.of("code", "INVALID_SESSION", "message", exception.getMessage(), "timestamp", Instant.now().toString());
    }
}
