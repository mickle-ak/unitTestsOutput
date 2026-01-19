package de.adesso.ai.unittests.unittestsoutput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class Service2Test extends AbstractIServiceTest {

    @Autowired
    private Service2 service;

    @Override
    protected IService service() {
        return service;
    }


}