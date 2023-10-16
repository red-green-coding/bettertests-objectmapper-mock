package sample;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class MyService4 {
    private Gson mapper = new Gson();
    private CollaboratorService collaboratorService;

    MyService4(CollaboratorService collaboratorService) {
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
