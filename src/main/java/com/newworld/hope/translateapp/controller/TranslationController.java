package com.newworld.hope.translateapp.controller;

import com.newworld.hope.translateapp.model.TranslationCreateModel;
import com.newworld.hope.translateapp.model.TranslationModel;
import com.newworld.hope.translateapp.service.TranslationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/translations")
public class TranslationController {

    private TranslationService translationService;

    public TranslationController(TranslationService translationService) {
        this.translationService = translationService;
    }

    @GetMapping(produces = "application/json")
    public List<TranslationModel> getAllTranslations() {
        return translationService.getAll();
    }

    @GetMapping("/country/{countryCode}")
    public List<TranslationModel> getByCountryCode(@PathVariable("countryCode") final String countryCode) {
        return translationService.getAllByCountryCode(countryCode);
    }

    @GetMapping("/wordId/{wordId}")
    public List<TranslationModel> getAllByWordId(@PathVariable("wordId") final long wordId) {
        return translationService.getAllTByWordId(wordId);
    }

    @GetMapping("/id/{id}")
    public TranslationModel getById(@PathVariable("id") final long id) {
        return translationService.getById(id);
    }

    @GetMapping("/word_id_country_code/{wordId}/{countryCode}")
    public TranslationModel getByWordIdAndCountryCode(@PathVariable final long wordId, @PathVariable final String countryCode) {
        return translationService.getByWordIdAndCountryCode(wordId, countryCode);
    }

    @PostMapping()
    public TranslationModel createTranslation(@RequestBody final TranslationCreateModel translationCreateModel) {
        return translationService.createTranslation(translationCreateModel);
    }

    @PutMapping("/{id}")
    public TranslationModel updateTranslationById(@PathVariable final long id, @RequestBody final TranslationCreateModel translationCreateModel) {
        return translationService.updateTranslation(id, translationCreateModel);
    }

    @DeleteMapping("/{id}")
    public void deleteTranslationById(@PathVariable final long id) {
        translationService.deleteTranslationById(id);
    }

}
