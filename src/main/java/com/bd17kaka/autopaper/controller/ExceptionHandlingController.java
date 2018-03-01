package com.bd17kaka.autopaper.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bd17kaka.autopaper.vo.Response;

/**
 * Created by Administrator on 2017/3/13.
 */
//@RestControllerAdvice
public class ExceptionHandlingController extends ResponseEntityExceptionHandler{
    @ExceptionHandler({SQLException.class,DataAccessException.class})
    public String databaseError() {
        // Nothing to do.  Returns the logical view name of an error page, passed
        // to the view-resolver(s) in usual way.
        // Note that the exception is NOT available to this view (it is not added
        // to the model) but see "Extending ExceptionHandlerExceptionResolver"
        // below.
        return "databaseError";
    }

    @ExceptionHandler({Exception.class})
    public String fileUploadError(HttpServletRequest req, Exception e) {
        Response<Object> response = new Response<>();
        response.fail(e.getMessage());
//        return new ResponseEntity<Response<Object>>(response, HttpStatus.OK);
        return e.getMessage();
    }
}
