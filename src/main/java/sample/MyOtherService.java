package sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyOtherService {
    private static final Logger LOG = LoggerFactory.getLogger(MyOtherService.class);
    public void useDto(MyDto dto) {
        LOG.info("use {}", dto);
    }
}
