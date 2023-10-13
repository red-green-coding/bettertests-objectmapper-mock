package sample;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class MyService3 {
    private ObjectMapper mapper = new ObjectMapper();
    private MyOtherService myOtherService;

    MyService3(MyOtherService myOtherService) {
        this.myOtherService = myOtherService;
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
