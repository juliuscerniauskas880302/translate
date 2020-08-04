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
public class WordServiceImpl implements WordService{
    private static final String UNKNOWN = "UNKNOWN";

    private final WordRepository wordRepository;

    public WordServiceImpl(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public List<WordModel> getAllWords() {
        return wordRepository.getAllWords()
                .parallelStream()
                .map(WordServiceImpl::mapToWordModel)
                .collect(Collectors.toList());
    }

    public List<WordModel> getWordsByPropertyName(final String propertyName) {
        return wordRepository.getWordsByPropertyName(propertyName)
                .parallelStream()
                .map(WordServiceImpl::mapToWordModel)
                .collect(Collectors.toList());
    }

    public WordModel getWordByPropertyName(final String propertyName) {
        return wordRepository.getWordByPropertyName(propertyName)
                .map(WordServiceImpl::mapToWordModel)
                .orElse(createEmptyWordModel());
    }

    public WordModel getWordById(final long id) {
        return wordRepository.getWordById(id)
                .map(WordServiceImpl::mapToWordModel)
                .orElse(createEmptyWordModel());
    }

    public WordModel createWord(final WordCreateModel createModel) {
        Word word = new Word();
        word.setText(createModel.getText());
        word.setDescription(createModel.getDescription());
        word.setPropertyName(createModel.getPropertyName());
        wordRepository.createWord(word);

        return wordRepository.getWordById(word.getId()).map(WordServiceImpl::mapToWordModel)
                .orElse(createEmptyWordModel());
    }

    public WordModel updateWordById(final long id, final WordCreateModel createModel) {
        Word persistedWord = wordRepository.getWordById(id)
                .orElseThrow(EntityNotFoundException::new);

        persistedWord.setText(createModel.getText());
        persistedWord.setDescription(createModel.getDescription());
        persistedWord.setPropertyName(createModel.getPropertyName());
        wordRepository.updateWordById(persistedWord);

        return mapToWordModel(persistedWord);
    }

    public void deleteWordById(final long id) {
        wordRepository.deleteWordById(id);
    }

    public void deleteWordByPropertyName(final String propertyName) {
        wordRepository.deleteWordByPropertyName(propertyName);
    }

    private static WordModel mapToWordModel(Word word) {
        return new WordModel(word.getId(), word.getText(), word.getDescription(), word.getPropertyName());
    }

    private static WordModel createEmptyWordModel() {
        return new WordModel(0, UNKNOWN, UNKNOWN, UNKNOWN);
    }

}
