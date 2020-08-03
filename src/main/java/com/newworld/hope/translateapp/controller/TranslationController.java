package com.newworld.hope.translateapp.controller;

import com.newworld.hope.translateapp.model.TranslationCreateModel;
import com.newworld.hope.translateapp.model.TranslationModel;
import com.newworld.hope.translateapp.service.TranslationServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/translations")
public class TranslationController {

    private TranslationServiceImpl translationServiceImpl;

    public TranslationController(TranslationServiceImpl translationServiceImpl) {
        this.translationServiceImpl = translationServiceImpl;
    }

    @GetMapping(produces = "application/json")
    public List<TranslationModel> getAllTranslations() {
        return translationServiceImpl.getAll();
    }

    @GetMapping("/country/{countryCode}")
    public List<TranslationModel> getByCountryCode(@PathVariable("countryCode") final String countryCode) {
        return translationServiceImpl.getAllByCountryCode(countryCode);
    }

    @GetMapping("/wordId/{wordId}")
    public List<TranslationModel> getAllByWordId(@PathVariable("wordId") final long wordId) {
        return translationServiceImpl.getAllTByWordId(wordId);
    }

    @GetMapping("/id/{id}")
    public TranslationModel getById(@PathVariable("id") final long id) {
        return translationServiceImpl.getById(id);
    }

    @GetMapping("/word_id_country_code/{wordId}/{countryCode}")
    public TranslationModel getByWordIdAndCountryCode(@PathVariable final long wordId, @PathVariable final String countryCode) {
        return translationServiceImpl.getByWordIdAndCountryCode(wordId, countryCode);
    }

    @PostMapping()
    public TranslationModel createTranslation(@RequestBody final TranslationCreateModel translationCreateModel) {
        return translationServiceImpl.createTranslation(translationCreateModel);
    }

    @PutMapping("/{id}")
    public TranslationModel updateTranslationById(@PathVariable final long id, @RequestBody final TranslationCreateModel translationCreateModel) {
        return translationServiceImpl.updateTranslation(id, translationCreateModel);
    }

    @DeleteMapping("/{id}")
    public void deleteTranslationById(@PathVariable final long id) {
        translationServiceImpl.deleteTranslationById(id);
    }

}
