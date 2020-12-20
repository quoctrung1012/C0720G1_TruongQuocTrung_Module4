package ccom.codegym.controller;

import ccom.codegym.entity.Note;
import ccom.codegym.entity.NoteType;
import ccom.codegym.service.note.NoteService;
import ccom.codegym.service.note_type.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;
    @Autowired
    private NoteTypeService noteTypeService;

    @ModelAttribute("noteTypeList")
    public List<NoteType> noteTypeList(){
        return noteTypeService.findAll();
    }
    @GetMapping("/listNote")
    public String listNote(Principal principal,
                           Model model, @PageableDefault(size = 3) Pageable pageable, @RequestParam Optional<String> input){
        String inputCheck = "";
        if (!input.isPresent()) {
            model.addAttribute("noteList", this.noteService.findPageAll(pageable));
        } else {
            inputCheck = input.get();
            model.addAttribute("noteList", this.noteService.searchByName(inputCheck, pageable));
        }
        model.addAttribute("inputCheck", inputCheck);
        return "note/index";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("note", new Note());
        return "note/create";
    }
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Note note, BindingResult bindingResult, RedirectAttributes attributes) {
        //Duplicate(note, bindingResult);
        if (bindingResult.hasErrors()) {
            return "note/create";
        }
        noteService.save(note);
        attributes.addFlashAttribute("success", "Saved note successfully!");
        return "redirect:/note/listNote";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("note", noteService.findById(id));
        return "note/edit";
    }
    @PostMapping("/update")
    public String update(@Valid @ModelAttribute Note note, BindingResult bindingResult, RedirectAttributes attributes) {
       // Duplicate(note, bindingResult);
        if (bindingResult.hasErrors()) {
            return "note/edit";
        }
        noteService.save(note);
        attributes.addFlashAttribute("success", "Modified note successfully!");
        return "redirect:/note/listNote";
    }
//    @GetMapping("/{id}/delete")
//    public String remove(@PathVariable Long id, Model model) {
//        model.addAttribute("note", noteService.findById(id));
//        return "note/delete";
//    }
//    @PostMapping("/delete")
//    public String delete(Note note, RedirectAttributes attributes) {
//        noteService.remove(note.getId());
//        attributes.addFlashAttribute("success", "Removed note successfully!");
//        return "redirect:/note/listNote";
//    }
    @GetMapping("{id}/view")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("note", noteService.findById(id));
        return "note/view";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam Long deleteID, RedirectAttributes redirectAttributes){
        noteService.remove(deleteID);
        redirectAttributes.addFlashAttribute("success", "Removed note successfully!");
        return "redirect:/customers";
    }
}
