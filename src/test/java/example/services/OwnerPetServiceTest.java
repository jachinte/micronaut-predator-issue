package example.services;

import example.domain.Owner;
import example.domain.Pet;
import example.repositories.OwnerRepository;
import example.repositories.PetRepository;
import io.micronaut.test.annotation.MicronautTest;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@MicronautTest
final class OwnerPetServiceTest {

    private static final String OWNER_NAME = "Fred";

    private static final String PET_NAME = "Dino";

    private final OwnerPetService associations;

    private final OwnerRepository owners;

    private final PetRepository pets;

    OwnerPetServiceTest(final OwnerPetService associations, final OwnerRepository owners,
        final PetRepository pets) {
        this.associations = associations;
        this.owners = owners;
        this.pets = pets;
    }

    @Test
    void test() {
        final Optional<Owner> owner = this.owners.findByName(OwnerPetServiceTest.OWNER_NAME);
        final Optional<Pet> pet = this.pets.findByName(OwnerPetServiceTest.PET_NAME);
        Assertions.assertAll(
            () -> Assertions.assertTrue(owner.isPresent()),
            () -> Assertions.assertTrue(pet.isPresent())
        );
        this.associations.save(owner.get(), pet.get());
    }

}
