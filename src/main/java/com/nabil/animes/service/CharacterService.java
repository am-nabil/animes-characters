package com.nabil.animes.service;

import com.nabil.animes.model.Character;

public interface CharacterService {
    Character findCharacterById(int id);
    void addCharacter(Character character);
}
