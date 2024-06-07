package com.taaesan.demo.service;

import java.util.Optional;

public interface DemoService {

    String hello();
    public Optional<Integer[]> findTwoSum(Integer[] numbers, int target);
}
