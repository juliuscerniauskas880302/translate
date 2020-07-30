package com.newworld.hope.translateapp.repository;

import com.newworld.hope.translateapp.entity.Word;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface WordRepository {

    @Select("SELECT * FROM words WHERE id = #{id}")
    Optional<Word> getWordById(@Param("id") long id);

    @Select("SELECT * FROM words")
    List<Word> getAllWords();

    @Select("SELECT * FROM words WHERE id = #{id} AND locale = #{locale}")
    Optional<Word> getWordByIdAndLocale(@Param("id") long id, @Param("locale") String locale);

    @Select("SELECT * FROM words WHERE locale = #{locale}")
    List<Word> getAllWordsByLocale(@Param("locale") String locale);

    @Insert("INSERT INTO words(text, description, locale) values(#{text}, #{description}, #{locale})")
    @SelectKey(statement = "call identity()", keyProperty = "id", before = false, resultType = Long.class)
    void createWord(Word word);

    @Update("UPDATE words SET text = #{text}, description = #{description}, locale = #{locale} WHERE id = #{id}")
    void updateWordById(Word word);

}
