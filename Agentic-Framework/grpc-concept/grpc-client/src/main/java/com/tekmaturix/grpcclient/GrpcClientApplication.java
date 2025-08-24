package com.tekmaturix.grpcclient;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import helloworld.GreeterGrpc;
import helloworld.Helloworld;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@SpringBootApplication
@EnableScheduling
public class GrpcClientApplication {

    private final AtomicInteger counter = new AtomicInteger(1);

    public static void main(String[] args) {
        SpringApplication.run(GrpcClientApplication.class, args);
    }

    @Scheduled(fixedRate = 5000) // Every 5 seconds
    public void callGrpcServer() {
        String name = "JavaClient-" + counter.getAndIncrement();

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);

        Helloworld.HelloRequest request = Helloworld.HelloRequest.newBuilder()
                .setName(name)
                .build();

        Helloworld.HelloReply response = stub.sayHello(request);
        System.out.println("Response from sidecar: " + response.getMessage());

        channel.shutdown();
    }
}

