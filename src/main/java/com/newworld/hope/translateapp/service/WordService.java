package com.newworld.hope.translateapp.service;

import com.newworld.hope.translateapp.entity.Word;
import com.newworld.hope.translateapp.model.WordCreateModel;
import com.newworld.hope.translateapp.model.WordModel;
import com.newworld.hope.translateapp.repository.WordRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WordService {
    private static final String UNKNOWN = "UNKNOWN";

    private final WordRepository wordRepository;

    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
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

    public WordModel getWordByPropertyName(String propertyName) {
        return wordRepository.getWordByPropertyName(propertyName)
                .map(WordService::mapToWordModel)
                .orElse(createEmptyWordModel());
    }

    public List<WordModel> getWordsByPropertyName(String propertyName) {
        return wordRepository.getWordsByPropertyName(propertyName)
                .parallelStream()
                .map(WordService::mapToWordModel)
                .collect(Collectors.toList());
    }

    public WordModel createWord(WordCreateModel createModel) {
        Word word = new Word();
        word.setText(createModel.getText());
        word.setDescription(createModel.getDescription());
        word.setPropertyName(createModel.getPropertyName());
        wordRepository.createWord(word);

        return wordRepository.getWordById(word.getId()).map(WordService::mapToWordModel)
                .orElse(createEmptyWordModel());
    }

    public WordModel updateWordById(long id, WordCreateModel createModel) {
        Word persistedWord = wordRepository.getWordById(id)
                .orElseThrow(EntityNotFoundException::new);

        persistedWord.setText(createModel.getText());
        persistedWord.setDescription(createModel.getDescription());
        persistedWord.setPropertyName(createModel.getPropertyName());
        wordRepository.updateWordById(persistedWord);

        return mapToWordModel(persistedWord);
    }

    public void deleteWordById(long id) {
        wordRepository.deleteWordById(id);
    }

    public void deleteWordByPropertyName(String propertyName) {
        wordRepository.deleteWordByPropertyName(propertyName);
    }

    private static WordModel mapToWordModel(Word word) {
        return new WordModel(word.getId(), word.getText(), word.getDescription(), word.getPropertyName());
    }

    private static WordModel createEmptyWordModel() {
        return new WordModel(0, UNKNOWN, UNKNOWN, UNKNOWN);
    }

}
