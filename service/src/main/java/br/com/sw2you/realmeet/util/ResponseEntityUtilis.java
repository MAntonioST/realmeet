package br.com.sw2you.realmeet.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public final class ResponseEntityUtilis {

    private ResponseEntityUtilis(){}

    public static <T> ResponseEntity<T> ok(T body){
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

}
