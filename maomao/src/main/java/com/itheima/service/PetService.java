package com.itheima.service;

import com.itheima.pojo.Pet;

import java.util.List;

public interface PetService {
    Pet searchPet(int id);

    void addPet(Pet pet);

    void modifyPet(Pet pet);

    void deletePet(int id);

   List<Pet> searchCorrPet(int state);
}
