package com.nabil.animes.controllers;

import com.nabil.animes.exceptions.ResourceNotFoundException;
import com.nabil.animes.model.Character;
import com.nabil.animes.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView search(){
        ModelAndView mav = new ModelAndView("search");
        mav.addObject("character", new Character());
        return mav;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView register(){
        ModelAndView mav = new ModelAndView("add");
        mav.addObject("character", new Character());
        return mav;
    }

    @RequestMapping(value = "/searchProcess", method = RequestMethod.POST)
    public ModelAndView searchProcess(@ModelAttribute("character") Character character, Model model) {
        ModelAndView mav;
        try {
            Character characterRes = characterService.findCharacterById(character.getId());
            if (null == characterRes) {
                throw new ResourceNotFoundException();
            }
            model.addAttribute("character", characterRes);
            mav = new ModelAndView("characterinfo");
            mav.addObject("character", characterRes);
            mav.addObject("message", "Character successfully retrieved !!");
        } catch (ResourceNotFoundException e) {
            mav = new ModelAndView("search");
            mav.addObject("message", "Unknown character with id : "+character.getId());
        } catch (Exception e) {
            mav = new ModelAndView("search");
            mav.addObject("message", "Failed to retrieve !!! ");
        }
        return mav;
    }

    @RequestMapping(value = "/addProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(@ModelAttribute("character") Character character, Model model) {
        ModelAndView mav;
        try{
            characterService.addCharacter(character);
            model.addAttribute("character", character);
            mav = new ModelAndView("characterinfo");
            mav.addObject("character", character);
            mav.addObject("message", "Successfully added!!");
        } catch (Exception e) {
            mav = new ModelAndView("add");
            mav.addObject("message", "Failed to register!!");
        }
        return mav;
    }



}