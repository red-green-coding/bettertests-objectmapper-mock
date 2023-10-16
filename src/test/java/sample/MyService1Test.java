package sample;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MyService1Test {

    @InjectMocks
    MyService1 myService;

    @Mock
    CollaboratorService collaboratorService;

    @Mock
    ObjectMapper mapper;

    @Test
    void canConsumeJson() throws Exception {
        var data = """
                {"Name" "MyName", "yearOfBirth": "1973"}
                """;

        Mockito.doReturn(new MyValue("MyName", 1973))
                .when(mapper).readValue(data, MyValue.class);

        myService.useData(data);

        Mockito.verify(collaboratorService)
                .useValue(Mockito.argThat(arg -> arg.name().equals("MyName")));
    }
}
