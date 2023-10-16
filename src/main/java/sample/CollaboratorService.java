package sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CollaboratorService {
    private static final Logger LOG = LoggerFactory.getLogger(CollaboratorService.class);
    public void useValue(MyValue dto) {
        LOG.info("use {}", dto);
    }
}
