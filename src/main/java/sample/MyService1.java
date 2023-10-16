package sample;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class MyService1 {
    private ObjectMapper mapper;
    private CollaboratorService collaboratorService;

    MyService1(CollaboratorService collaboratorService, ObjectMapper mapper) {
        this.collaboratorService = collaboratorService;
        this.mapper = mapper;
    }

    void useData(String json) {
        try {
            var dto = mapper.readValue(json, MyValue.class);
            collaboratorService.useValue(dto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
