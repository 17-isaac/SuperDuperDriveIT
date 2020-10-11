package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import com.udacity.jwdnd.course1.cloudstorage.model.Users;
import com.udacity.jwdnd.course1.cloudstorage.services.NotesSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

public class NoteController {
    @Autowired
    private NotesSerivce notesService;

    @RequestMapping(value = "/add-note", method = RequestMethod.POST)
    public ModelAndView addNote(@ModelAttribute("SpringWeb") Notes note, HttpSession session, ModelMap model){
        Users user = (Users) session.getAttribute("user");
        if (!ObjectUtils.isEmpty(note.getNoteId)){
            notesService.update(note);
        } else {
            notesService.save(note, user.getUserid());
        }
        model.addAttribute("noteAdded","Notes save/update successfully!!");
        return new ModelAndView("redirect:/", model);
    }

    @RequestMapping(value = "/delete-note/{noteid}")
    public ModelAndView deleteNote(@PathVariable("noteid") Integer noteid, HttpSession session, ModelMap model){
        Users user = (Users) session.getAttribute("user");
        notesService.deleteById(noteid);
        model.addAttribute("notes", notesService.getAllByUserid(user.getUserid()));
        model.addAttribute("Notes Deleted successfully!!");
        return new ModelAndView("redirect:/", model);
    }
}
