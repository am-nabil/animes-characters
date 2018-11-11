package com.nabil.animes.service;

import com.nabil.animes.model.Character;
import com.nabil.animes.repository.CharacterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    public CharacterDao characterDao;

    @Override
    public Character findCharacterById(int id) {
        return characterDao.findById(id);
    }

    @Override
    public void addCharacter(Character character) {
        characterDao.addCharacter(character);
    }

}
