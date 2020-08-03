package com.newworld.hope.translateapp.service;

import com.newworld.hope.translateapp.entity.Translation;
import com.newworld.hope.translateapp.model.TranslationCreateModel;
import com.newworld.hope.translateapp.model.TranslationModel;
import com.newworld.hope.translateapp.repository.TranslationRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TranslationService {
    private static final String UNKNOWN = "UNKNOWN";

    private TranslationRepository translationRepository;

    public TranslationService(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }

    public List<TranslationModel> getAll() {
        return translationRepository.getAll()
                .parallelStream()
                .map(TranslationService::mapToTranslationModel)
                .collect(Collectors.toList());
    }

    public List<TranslationModel> getAllByCountryCode(final String countryCode) {
        return translationRepository.getAllByCountryCode(countryCode)
                .parallelStream()
                .map(TranslationService::mapToTranslationModel)
                .collect(Collectors.toList());
    }

    public List<TranslationModel> getAllTByWordId(final long wordId) {
        return translationRepository.getAllTByWordId(wordId)
                .parallelStream()
                .map(TranslationService::mapToTranslationModel)
                .collect(Collectors.toList());
    }

    public TranslationModel getById(final long id) {
        return translationRepository.getById(id)
                .map(TranslationService::mapToTranslationModel)
                .orElse(createEmptyTranslationModel());
    }

    public TranslationModel getByWordIdAndCountryCode(final long wordId, final String countryCode) {
        return translationRepository.getByWordIdAndCountryCode(wordId, countryCode)
                .map(TranslationService::mapToTranslationModel)
                .orElse(createEmptyTranslationModel());
    }

    public TranslationModel updateTranslation(final long translationId, final TranslationCreateModel createModel) {
        Translation persistedTranslation = translationRepository.getById(translationId)
                .orElseThrow(EntityNotFoundException::new);

        persistedTranslation.setWordId(createModel.getWordId());
        persistedTranslation.setTranslation(createModel.getTranslation());
        persistedTranslation.setCountryCode(createModel.getCountryCode());
        translationRepository.updateTranslation(persistedTranslation);

        return mapToTranslationModel(persistedTranslation);
    }

    public void deleteTranslationById(final long translationId) {
        translationRepository.deleteTranslation(translationId);
    }

    public TranslationModel createTranslation(TranslationCreateModel createModel) {
        Translation translation = new Translation();
        translation.setWordId(createModel.getWordId());
        translation.setTranslation(createModel.getTranslation());
        translation.setCountryCode(createModel.getCountryCode());
        translationRepository.createTranslation(translation);

        return translationRepository.getById(translation.getId())
                .map(TranslationService::mapToTranslationModel)
                .orElse(createEmptyTranslationModel());
    }

    private static TranslationModel mapToTranslationModel(Translation translation) {
        TranslationModel translationModel = new TranslationModel();
        translationModel.setId(translation.getId());
        translationModel.setWordId(translation.getWordId());
        translationModel.setCountryCode(translation.getCountryCode());
        translationModel.setTranslation(translation.getTranslation());
        return translationModel;
    }

    private static TranslationModel createEmptyTranslationModel() {
        return new TranslationModel(0, 0, UNKNOWN, UNKNOWN);
    }

}
