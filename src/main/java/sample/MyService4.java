package sample;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class MyService4 {
    private Gson mapper = new Gson();
    private MyOtherService myOtherService;

    MyService4(MyOtherService myOtherService) {
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
