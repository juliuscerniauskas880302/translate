package com.newworld.hope.translateapp.controller;

import com.newworld.hope.translateapp.model.WordCreateModel;
import com.newworld.hope.translateapp.model.WordModel;
import com.newworld.hope.translateapp.service.WordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/words")
public class WordController {

    private final WordService wordService;

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping()
    public List<WordModel> getAllWords() {
        return wordService.getAllWords();
    }

    @GetMapping("/all/{locale}")
    public List<WordModel> getAllWordsByLocale(@PathVariable String locale) {
        return wordService.getAllWordsByLocale(locale);
    }

    @GetMapping("/{id}/{locale}")
    public WordModel getWordByIdAndLocale(@PathVariable long id, @PathVariable String locale) {
        return wordService.getWordByIdAndLocale(id, locale);
    }

    @GetMapping("/{id}")
    public WordModel getWordById(@PathVariable long id) {
        return wordService.getWordById(id);
    }

    @PostMapping()
    public void createWord(@RequestBody final WordCreateModel createModel) {
        wordService.createWord(createModel);
    }

    @PutMapping("/{id}")
    public void updateWordById(@PathVariable("id") final long id, @RequestBody final WordCreateModel createModel) {
        wordService.updateWordById(id, createModel);
    }

}
