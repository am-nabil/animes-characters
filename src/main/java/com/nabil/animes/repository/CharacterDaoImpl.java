package com.nabil.animes.repository;

import com.nabil.animes.model.Character;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository(value = "userDao")
@Transactional
public class CharacterDaoImpl implements CharacterDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Character findById(int id) {
        return sessionFactory.getCurrentSession().get(Character.class, id);
    }

    @Override
    public void addCharacter(Character character) {
        sessionFactory.getCurrentSession().persist(character);
    }
}
