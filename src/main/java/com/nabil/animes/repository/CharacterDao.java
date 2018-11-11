package com.nabil.animes.repository;

import com.nabil.animes.model.Character;

public interface CharacterDao {
    Character findById(int id);

    void addCharacter(Character character);
}
