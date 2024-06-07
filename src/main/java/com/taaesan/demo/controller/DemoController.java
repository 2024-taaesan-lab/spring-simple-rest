package com.taaesan.demo.controller;

import com.taaesan.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("demo")
public class DemoController {

    private DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }


    @GetMapping("/")
    public String hello(){
        return demoService.hello();
    }

    @PostMapping("/findTwoSum")
    public ResponseEntity<Integer[]> findTwoSum(@RequestBody FindTwoSumDTO findTwoSumDTO) {
        Optional<Integer[]> result = demoService.findTwoSum(findTwoSumDTO.getNumbers(), findTwoSumDTO.getTarget());
        return result.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).body(null));
    }
}
