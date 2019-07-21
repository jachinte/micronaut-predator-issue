package example;

import javax.inject.Singleton;
import io.micronaut.runtime.Micronaut;

@Singleton
public class Application {
    public static void main(String[] args) {
        Micronaut.run(Application.class);
    }
}