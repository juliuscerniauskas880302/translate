package com.newworld.hope.translateapp.repository;

import com.newworld.hope.translateapp.entity.Translation;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TranslationRepository {

    @Results(id = "translation", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "wordId", column = "word_id"),
            @Result(property = "countryCode", column = "country_code"),
            @Result(property = "translation", column = "translation"),
    })
    @Select("SELECT * FROM translations")
    List<Translation> getAll();

    @Results(id = "translation", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "wordId", column = "word_id"),
            @Result(property = "countryCode", column = "country_code"),
            @Result(property = "translation", column = "translation"),
    })
    @Select("SELECT * FROM translations WHERE country_code = #{countryCode}")
    List<Translation> getAllByCountryCode(@Param("countryCode") final String countryCode);

    @Results(id = "translation", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "wordId", column = "word_id"),
            @Result(property = "countryCode", column = "country_code"),
            @Result(property = "translation", column = "translation"),
    })
    @Select("SELECt * FROM translations WHERE word_id = #{wordId}")
    List<Translation> getAllTByWordId(@Param("wordId") final long wordId);

    @Results(id = "translation", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "wordId", column = "word_id"),
            @Result(property = "countryCode", column = "country_code"),
            @Result(property = "translation", column = "translation"),
    })
    @Select("SELECT * FROM translations WHERE id = #{id}")
    Optional<Translation> getById(@Param("id") final long id);

    @Results(id = "translation", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "wordId", column = "word_id"),
            @Result(property = "countryCode", column = "country_code"),
            @Result(property = "translation", column = "translation"),
    })
    @Select("SELECT * FROM translations WHERE word_id = #{wordId} AND country_code = #{countryCode}")
    Optional<Translation> getByWordIdAndCountryCode(@Param("wordId") final long wordId,
                                                    @Param("countryCode") final String countryCode);

    @Insert("INSERT INTO translations(word_id, country_code, translation) " +
            "VALUES(#{wordId}, #{countryCode}, #{translation})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void createTranslation(final Translation translation);

    @Update("UPDATE translations " +
            "SET word_id = #{wordId}, country_code = #{countryCode}, translation = #{translation} " +
            "WHERE id = #{id}")
    void updateTranslation(final Translation translation);

    @Delete("DELETE * FROM translations WHERE id = #{id}")
    void deleteTranslation(final long id);

}