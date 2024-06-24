package com.sumant.learning.spring3_3sbomdemo;

import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportRuntimeHints;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
@ImportRuntimeHints(Spring33SbomDemoApplication.Hints.class)
public class Spring33SbomDemoApplication {

    static class Hints implements RuntimeHintsRegistrar {

        @Override
        public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
            hints.resources().registerResource(new ClassPathResource("META-INF/sbom/application.cdx.json"));
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Spring33SbomDemoApplication.class, args);
    }

}
