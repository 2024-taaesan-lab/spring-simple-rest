package com.taaesan.demo.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class DemoServiceImpl implements DemoService{
    @Override
    public String hello() {
        return "hello";
    }

    @Override
    public Optional<Integer[]> findTwoSum(Integer[] numbers, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (indexMap.containsKey(complement)) {
                return Optional.of(new Integer[]{indexMap.get(complement), i});
            }
            indexMap.put(numbers[i], i);
        }
        return Optional.empty();
    }
}
