package spm.spring.world.model;

import lombok.Value;

/**
 * Use of LAMBOK
 *
 * @param <T>
 */

@Value
public class ResponseModel<T> {
    private int statusCode;
    private String responseMessage;
    private T data;
}
