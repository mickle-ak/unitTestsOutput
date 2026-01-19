package de.adesso.ai.unittests.unittestsoutput;


class Service1Test extends AbstractIServiceTest {

    private final Service1 service = new Service1();

    @Override
    protected IService service() {
        return service;
    }
}