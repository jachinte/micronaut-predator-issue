package example.services;

import example.domain.Owner;
import example.domain.OwnerPet;
import example.domain.OwnerPetKey;
import example.domain.Pet;
import example.repositories.OwnerPetRepository;
import javax.inject.Singleton;

@Singleton
public class OwnerPetServiceImpl implements OwnerPetService {

    private final OwnerPetRepository associations;

    public OwnerPetServiceImpl(final OwnerPetRepository associations) {
        this.associations = associations;
    }

    @Override
    public OwnerPet save(final Owner owner, final Pet pet) {
        return this.associations.save(new OwnerPet(new OwnerPetKey(owner, pet)));
    }

}
