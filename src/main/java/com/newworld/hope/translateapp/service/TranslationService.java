package com.newworld.hope.translateapp.service;

import com.newworld.hope.translateapp.model.TranslationCreateModel;
import com.newworld.hope.translateapp.model.TranslationModel;

import java.util.List;

public interface TranslationService {
    List<TranslationModel> getAll();

    List<TranslationModel> getAllByCountryCode(String countryCode);

    List<TranslationModel> getAllTByWordId(long wordId);

    TranslationModel getById(long id);

    TranslationModel getByWordIdAndCountryCode(long wordId, String countryCode);

    TranslationModel createTranslation(TranslationCreateModel translationCreateModel);

    TranslationModel updateTranslation(long translationId, TranslationCreateModel createModel);

    void deleteTranslationById(long translationId);
}
