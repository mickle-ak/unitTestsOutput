package de.adesso.ai.unittests.unittestsoutput;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Service1 implements IService {

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public List<String> add(List<String> a, List<String> b) {
        List<String> result = new ArrayList<>(a);
        result.addAll(b);
        return result;
    }

    @Override
    public void error(String message) throws IllegalStateException {
        throw new IllegalStateException(message);
    }
}
