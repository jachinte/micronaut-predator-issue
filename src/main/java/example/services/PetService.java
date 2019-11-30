package example.services;

import example.domain.Pet;

public interface PetService {

    Pet register(String petName, String ownerName);

}
