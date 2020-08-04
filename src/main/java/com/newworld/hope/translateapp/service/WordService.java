package com.newworld.hope.translateapp.service;

import com.newworld.hope.translateapp.model.WordCreateModel;
import com.newworld.hope.translateapp.model.WordModel;

import java.util.List;

public interface WordService {
    List<WordModel> getAllWords();

    WordModel getWordById(long id);

    WordModel getWordByPropertyName(String propertyName);

    List<WordModel> getWordsByPropertyName(String propertyName);

    WordModel createWord(WordCreateModel createModel);

    WordModel updateWordById(long id, WordCreateModel createModel);

    void deleteWordById(long id);

    void deleteWordByPropertyName(String propertyName);
}
