package sample;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class MyService3 {
    private Gson mapper;
    private MyOtherService myOtherService;

    MyService3(Gson mapper, MyOtherService myOtherService) {
        this.mapper = mapper;
        this.myOtherService = myOtherService;
    }

    void useData(String json) {
        try {
            var dto = mapper.fromJson(json, MyValue.class);
            myOtherService.useValue(dto);
        } catch (JsonSyntaxException e) {
            throw new RuntimeException(e);
        }
    }

}
