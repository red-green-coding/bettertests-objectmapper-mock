package sample;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class MyService3 {
    private Gson mapper;
    private CollaboratorService collaboratorService;

    MyService3(Gson mapper, CollaboratorService collaboratorService) {
        this.mapper = mapper;
        this.collaboratorService = collaboratorService;
    }

    void useData(String json) {
        try {
            var dto = mapper.fromJson(json, MyValue.class);
            collaboratorService.useValue(dto);
        } catch (JsonSyntaxException e) {
            throw new RuntimeException(e);
        }
    }

}
