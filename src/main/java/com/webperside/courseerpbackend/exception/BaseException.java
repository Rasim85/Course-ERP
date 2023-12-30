package com.webperside.courseerpbackend.exception;

import com.webperside.courseerpbackend.models.enums.response.ResponseMessage;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Map;

import static com.webperside.courseerpbackend.models.enums.response.ErrorResponseMessages.NOT_FOUND;
import static com.webperside.courseerpbackend.models.enums.response.ErrorResponseMessages.UNEXPECTED;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseException extends RuntimeException {

    ResponseMessage responseMessage;
    NotFoundExceptionType notFoundData;

    @Override
    public String getMessage() {
        return responseMessage.message();
    }

    public static BaseException of(ResponseMessage responseMessage) {
        return BaseException.builder()
                .responseMessage(responseMessage)
                .build();
    }

    public static BaseException notFound(String target, String field, String value) {
        return BaseException.builder()
                .responseMessage(NOT_FOUND)
                .notFoundData(NotFoundExceptionType.of(target, Map.of(field, value)))
                .build();
    }


    public static BaseException unexpected() {
        return of(UNEXPECTED);


    }
}