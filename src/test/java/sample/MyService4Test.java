package sample;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MyService4Test {

    @InjectMocks
    MyService4 myService;

    @Mock
    CollaboratorService collaboratorService;


    @Test
    void canConsumeJson() throws Exception {
        var data = """
                {"name": "MyName", "yearOfBirth": 1973}
                """;

        myService.useData(data);

        Mockito.verify(collaboratorService)
                .useValue(Mockito.argThat(arg -> arg.name().equals("MyName")));
    }
}
