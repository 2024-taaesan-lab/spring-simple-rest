package com.taaesan.demo.controller;

import com.taaesan.demo.service.DemoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class DemoControllerTest {

    @InjectMocks
    private DemoController demoController;

    @Mock
    private DemoService demoService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

    }

    @Test
    void hello() {

        //Mock
        Mockito.when(demoService.hello()).thenReturn("hello");

        //When
        String hello = demoController.hello();

        //Then
        assertEquals(hello, "hello");
    }

    @Test
    void findTwoSum() {

        FindTwoSumDTO findTwoSumDTO = new FindTwoSumDTO();
        findTwoSumDTO.setNumbers(new Integer[]{1, 2, 3, 5, 7});
        findTwoSumDTO.setTarget(5);

        //Mock
        Mockito.when(demoService.findTwoSum(new Integer[]{1, 2, 3, 5, 7}, 5)).thenReturn(new Integer[]{1, 2});

        ResponseEntity<Integer[]> twoSum = demoController.findTwoSum(findTwoSumDTO);

        assertArrayEquals(new Integer[]{1, 2}, twoSum.getBody());

    }
}