package example.services;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

@MicronautTest
final class PetServiceTest {

    private static final String EXISTING_OWNER = "Fred";

    private final PetService pets;

    PetServiceTest(final PetService pets) {
        this.pets = pets;
    }

    @Test
    void testRegisterPetWithExistingOwnerShouldNotThrowException() {
        final String name = "New pet";
        this.pets.register(name, PetServiceTest.EXISTING_OWNER);
    }

}
