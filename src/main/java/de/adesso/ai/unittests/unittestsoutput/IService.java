package de.adesso.ai.unittests.unittestsoutput;

import java.util.List;

public interface IService {
    int add(int a, int b);

    List<String> add(List<String> a, List<String> b);

    void error(String message) throws IllegalStateException;
}
