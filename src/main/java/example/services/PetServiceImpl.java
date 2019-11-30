package example.services;

import example.domain.Owner;
import example.domain.Pet;
import example.repositories.OwnerRepository;
import example.repositories.PetRepository;
import java.util.Optional;
import javax.inject.Singleton;

@Singleton
public class PetServiceImpl implements PetService {

    private final PetRepository pets;

    private final OwnerRepository owners;

    public PetServiceImpl(final PetRepository pets, final OwnerRepository owners) {
        this.pets = pets;
        this.owners = owners;
    }

    @Override
    public Pet register(final String petName, final String ownerName) {
        final Optional<Owner> owner = this.owners.findByName(ownerName);
        if (!owner.isPresent()) {
            throw new IllegalArgumentException("The owner does not exist");
        }
        return this.pets.save(new Pet(petName, owner.get()));
    }

}
