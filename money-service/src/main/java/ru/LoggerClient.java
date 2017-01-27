package ru;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * Created by d.kudryashov on 27.01.2017.
 */
@Headers("Accept: application/json")
public interface LoggerClient {

    @RequestLine("GET /logger?text={text}")
    void log(@Param("text") String text);

}
