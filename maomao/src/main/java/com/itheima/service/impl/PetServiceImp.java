package com.itheima.service.impl;

import com.itheima.mapper.PetMapper;
import com.itheima.pojo.Pet;
import com.itheima.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImp implements PetService {
    @Autowired
    private PetMapper petMapper;

    @Override
    public Pet searchPet(int id) {
        return petMapper.searchPet(id);
    }

    @Override
    public void addPet(Pet pet) {
      petMapper.addPet(pet);
    }

    @Override
    public void modifyPet(Pet pet) {
        petMapper.modifyPet(pet);
    }

    @Override
    public void deletePet(int id) {
        petMapper.deletePet(id);
    }

    @Override
    public List<Pet> searchCorrPet(int  state) {
        return petMapper.searchCorrPet(state);
    }
}
