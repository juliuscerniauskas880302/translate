package com.newworld.hope.translateapp.controller;

import com.newworld.hope.translateapp.model.WordCreateModel;
import com.newworld.hope.translateapp.model.WordModel;
import com.newworld.hope.translateapp.service.WordServiceImpl;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/words")
public class WordController {

    private final WordServiceImpl wordServiceImpl;

    public WordController(WordServiceImpl wordServiceImpl) {
        this.wordServiceImpl = wordServiceImpl;
    }

    @GetMapping()
    public List<WordModel> getAllWords() {
        return wordServiceImpl.getAllWords();
    }

    @GetMapping("/all/{propertyName}")
    public List<WordModel> getWordsByPropertyName(@PathVariable("propertyName") final String propertyName) {
        return wordServiceImpl.getWordsByPropertyName(propertyName);
    }

    @GetMapping("/one/{propertyName}")
    public WordModel getWordByPropertyName(@PathVariable("propertyName") final String propertyName) {
        return wordServiceImpl.getWordByPropertyName(propertyName);
    }

    @GetMapping("/{id}")
    public WordModel getWordById(@PathVariable("id") final long id) {
        return wordServiceImpl.getWordById(id);
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public WordModel createWord(@RequestBody final WordCreateModel createModel) {
        return wordServiceImpl.createWord(createModel);
    }

    @PutMapping("/{id}")
    public void updateWordById(@PathVariable("id") final long id, @RequestBody final WordCreateModel createModel) {
        wordServiceImpl.updateWordById(id, createModel);
    }

    @Delete("/id/{id}")
    public void deleteWordById(@PathVariable("id") final long id) {
        wordServiceImpl.deleteWordById(id);
    }

    @Delete("/property/{propertyName}")
    public void deleteWordByPropertyName(@PathVariable("propertyName") final String propertyName) {
        wordServiceImpl.deleteWordByPropertyName(propertyName);
    }

}
