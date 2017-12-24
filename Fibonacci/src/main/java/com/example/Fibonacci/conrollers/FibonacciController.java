package com.example.Fibonacci.conrollers;

import com.example.Fibonacci.domain.FibonacciNumber;
import com.example.Fibonacci.domain.FibonacciNumberRepository;
import com.example.Fibonacci.domain.WorkerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.sql.Wrapper;
import java.util.Collections;
import java.util.Map;


@RestController
@RequestMapping("fibonacci")
public class FibonacciController {
    @Value("${docker.worker.url}")
    private String workerUrl;

    @Autowired
    private FibonacciNumberRepository fibonacciNumberRepository;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "getFibonacci", method = RequestMethod.GET)
    public FibonacciNumber getFibonacci() {
        return fibonacciNumberRepository.findOne(1);
    }


    @RequestMapping(value = "clear", method = RequestMethod.GET)
    public Map<String, Boolean>  clearFibonacci() {
        fibonacciNumberRepository.deleteAll();
        FibonacciNumber first = new FibonacciNumber(1, 1, BigInteger.valueOf(1) );
        fibonacciNumberRepository.save(first);
        return Collections.singletonMap("success", true);
    }

    @RequestMapping(value = "increment", method = RequestMethod.GET)
    public WorkerResponse increment (){
        //Boolean result = restTemplate.execute("http://worker:4142/worker/increment", HttpMethod.GET, null);
        String url = workerUrl + "/worker/increment";
        ResponseEntity<WorkerResponse> result = restTemplate.exchange(url , HttpMethod.GET, null, WorkerResponse.class);
        return result.getBody();
    }
}
