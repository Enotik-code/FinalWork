package com.company.interfaces;

import java.util.HashMap;
import java.util.Map;

public interface MapInterface {
    Map<Long, String> productMap = new HashMap<>();

    void addProduct(Long id, String name);
    void updateProduct();
    void readProduct();
    void deleteProduct();
    void findProduct();
}
