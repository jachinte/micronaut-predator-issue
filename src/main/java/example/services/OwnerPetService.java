package example.services;

import example.domain.Owner;
import example.domain.OwnerPet;
import example.domain.Pet;

public interface OwnerPetService {

    OwnerPet save(Owner owner, Pet pet);

}
