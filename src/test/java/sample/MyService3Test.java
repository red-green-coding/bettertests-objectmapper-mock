package sample;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MyService3Test {

    @InjectMocks
    MyService3 myService;

    @Mock
    MyOtherService myOtherService;


    @Test
    void canConsumeJson() throws Exception {
        var data = """
                {"name": "MyName", "yearOfBirth": 1974"}
                """;

        myService.useData(data);

        Mockito.verify(myOtherService).useDto(Mockito.argThat(arg -> arg.name().equals("MyName")));
    }
}
