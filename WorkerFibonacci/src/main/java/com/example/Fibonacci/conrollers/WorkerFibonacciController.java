package com.example.Fibonacci.conrollers;

import com.example.Fibonacci.domain.FibonacciNumber;
import com.example.Fibonacci.domain.FibonacciNumberRepository;
import com.example.Fibonacci.domain.WorkerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;


@RestController
@RequestMapping("worker")
public class WorkerFibonacciController {
    private static final double SQRT5 = Math.sqrt(5);
    private static final double PHI = (SQRT5 + 1) / 2;


    @Autowired
    private FibonacciNumberRepository fibonacciNumberRepository;


    @GetMapping(value = "increment")
    @Transactional
    public WorkerResponse increment() {

        String host = getHost();

        WorkerResponse response = new WorkerResponse(false, host, 0, BigInteger.valueOf(0));
        FibonacciNumber fibonacciNumber = fibonacciNumberRepository.getFibonacciNumber();

        int number = fibonacciNumber.getNumber() + 1;
        BigInteger newValue = calculateFibonacci(number);

        if ( newValue.compareTo(BigInteger.valueOf(0)) < 0) {
            return response;
        }

        fibonacciNumber.setValue(newValue);
        fibonacciNumber.setNumber(number);

        fibonacciNumberRepository.save(fibonacciNumber);

        response.setSuccess(true);
        response.setValue(newValue);
        response.setNumber(number);

        return response;
    }

    private BigInteger calculateFibonacci(int number) {
        if (number == 1 || number == 2) {
            return BigInteger.valueOf(1);
        }

        Double newValue = Math.pow(PHI, number) / SQRT5 + 0.5;

        if (Math.abs(newValue - newValue.intValue()) > 1){
            return BigInteger.valueOf(-1);
        }

        return BigInteger.valueOf(newValue.longValue());
    }

    private String getHost (){
        String host;
        try{
            host = InetAddress.getLocalHost().toString();
        }
        catch (UnknownHostException ex){
            host = "Unknown host";
        }

        return host;
    }
}
