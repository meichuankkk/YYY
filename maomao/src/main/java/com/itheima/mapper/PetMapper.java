package com.itheima.mapper;

import com.itheima.pojo.Pet;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PetMapper {

    Pet searchPet(int id);

    void addPet(Pet pet);

    void modifyPet(Pet pet);

    void deletePet(int id);

    List<Pet> searchCorrPet(int state);
}
