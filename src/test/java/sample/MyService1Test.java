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
    MyOtherService myOtherService;

    @Mock
    ObjectMapper mapper;

    @Test
    void canConsumeJson() throws Exception {
        var data = """
                {"name" "MyName", "yearOfBirth": 1974"}
                """;

        Mockito.doReturn(new MyDto("MyName", 1973)).when(mapper).readValue(data, MyDto.class);

        myService.useData(data);

        Mockito.verify(myOtherService).useDto(Mockito.argThat(arg -> arg.name().equals("MyName")));
    }
}
