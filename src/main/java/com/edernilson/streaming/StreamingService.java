package com.edernilson.streaming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 15/12/2023, sexta-feira
 */
@Service
public class StreamingService {
    
    private static final String FORMAT = "classpath:videos/%s.mp4";
    
    @Autowired
    private ResourceLoader resourceLoader;
    
    public Mono<Resource> getVideo(String title) {
        return Mono.fromSupplier(() -> resourceLoader.getResource(String.format(FORMAT, title)));
        
    }
}