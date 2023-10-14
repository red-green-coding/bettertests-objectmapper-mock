package sample;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MyService3Test {

    @InjectMocks
    MyService3 myService;

    @Mock
    MyOtherService myOtherService;

    @Spy
    ObjectMapper mapper;

    @Test
    void canConsumeJson() throws Exception {
        var data = """
                {"Name": "MyName", "yearOfBirth": "1973"}
                """;

        myService.useData(data);

        Mockito.verify(myOtherService)
                .useValue(Mockito.argThat(arg -> arg.name().equals("MyName")));
    }
}
