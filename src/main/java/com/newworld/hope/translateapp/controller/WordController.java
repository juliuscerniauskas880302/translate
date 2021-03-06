package com.newworld.hope.translateapp.controller;

import com.newworld.hope.translateapp.model.WordCreateModel;
import com.newworld.hope.translateapp.model.WordModel;
import com.newworld.hope.translateapp.service.WordService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/words")
public class WordController {

    private final WordService wordService;

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "Bearer JWT Token", paramType = "header")
    })
    @GetMapping()
    public List<WordModel> getAllWords() {
        return wordService.getAllWords();
    }

    @GetMapping("/all/{propertyName}")
    public List<WordModel> getWordsByPropertyName(@PathVariable("propertyName") final String propertyName) {
        return wordService.getWordsByPropertyName(propertyName);
    }

    @GetMapping("/one/{propertyName}")
    public WordModel getWordByPropertyName(@PathVariable("propertyName") final String propertyName) {
        return wordService.getWordByPropertyName(propertyName);
    }

    @GetMapping("/{id}")
    public WordModel getWordById(@PathVariable("id") final long id) {
        return wordService.getWordById(id);
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public WordModel createWord(@RequestBody final WordCreateModel createModel) {
        return wordService.createWord(createModel);
    }

    @PutMapping("/{id}")
    public void updateWordById(@PathVariable("id") final long id, @RequestBody final WordCreateModel createModel) {
        wordService.updateWordById(id, createModel);
    }

    @Delete("/id/{id}")
    public void deleteWordById(@PathVariable("id") final long id) {
        wordService.deleteWordById(id);
    }

    @Delete("/property/{propertyName}")
    public void deleteWordByPropertyName(@PathVariable("propertyName") final String propertyName) {
        wordService.deleteWordByPropertyName(propertyName);
    }

}
