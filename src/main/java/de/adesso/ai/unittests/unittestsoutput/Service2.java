package de.adesso.ai.unittests.unittestsoutput;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Service2 implements IService {
    private final Service1 service1;

    @Override
    public int add(int a, int b) { return service1.add(a, b); }

    @Override
    public List<String> add(List<String> a, List<String> b) { return service1.add(a, b); }

    @Override
    public void error(String message) throws IllegalStateException { service1.error(message); }
}
