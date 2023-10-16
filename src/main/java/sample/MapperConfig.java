package sample;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MapperConfig {

    private static ObjectMapper MAPPER = new ObjectMapper();
    static ObjectMapper configuredMapper() {
        return MAPPER;
    }
}
