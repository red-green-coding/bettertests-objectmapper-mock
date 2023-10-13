package sample;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class MyService1 {
    private ObjectMapper mapper;
    private MyOtherService myOtherService;

    MyService1(MyOtherService myOtherService, ObjectMapper mapper) {
        this.myOtherService = myOtherService;
        this.mapper = mapper;
    }

    void useData(String json) {
        try {
            var dto = mapper.readValue(json, MyDto.class);
            myOtherService.useDto(dto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
