package com.newworld.hope.translateapp.service;

import com.newworld.hope.translateapp.entity.Word;
import com.newworld.hope.translateapp.model.WordCreateModel;
import com.newworld.hope.translateapp.model.WordModel;
import com.newworld.hope.translateapp.repository.WordRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WordService {
    private static final String UNKNOWN = "UNKNOWN";

    private final WordRepository wordRepository;

    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public String getTextById(long id) {
        return wordRepository.getWordById(id)
                .map(Word::getText)
                .orElse(UNKNOWN);
    }

    public WordModel getWordById(long id) {
        return wordRepository.getWordById(id)
                .map(WordService::mapToWordModel)
                .orElse(createEmptyWordModel());
    }

    public List<WordModel> getAllWords() {
        return wordRepository.getAllWords()
                .parallelStream()
                .map(WordService::mapToWordModel)
                .collect(Collectors.toList());
    }

    public WordModel getWordByIdAndLocale(long id, String locale) {
        return wordRepository.getWordByIdAndLocale(id, locale)
                .map(WordService::mapToWordModel).orElse(createEmptyWordModel());
    }

    public List<WordModel> getAllWordsByLocale(String locale) {
        return wordRepository.getAllWordsByLocale(locale)
                .parallelStream()
                .map(WordService::mapToWordModel)
                .collect(Collectors.toList());
    }

    public void createWord(WordCreateModel createModel) {
        Word word = new Word();
        word.setText(createModel.getText());
        word.setDescription(createModel.getDescription());
        word.setLocale(createModel.getLocale());
        wordRepository.createWord(word);
    }

    public void updateWordById(long id, WordCreateModel createModel) {
        Word word = new Word();
        word.setId(id);
        word.setText(createModel.getText());
        word.setDescription(createModel.getDescription());
        word.setLocale(createModel.getLocale());
        wordRepository.updateWordById(word);
    }

    private static WordModel mapToWordModel(Word word) {
        return new WordModel(word.getId(), word.getText(), word.getDescription(), word.getLocale());
    }

    private static WordModel createEmptyWordModel() {
        return new WordModel(0, UNKNOWN, UNKNOWN, UNKNOWN);
    }

}
