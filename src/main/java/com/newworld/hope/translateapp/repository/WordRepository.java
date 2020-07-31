package com.newworld.hope.translateapp.repository;

import com.newworld.hope.translateapp.entity.Word;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface WordRepository {

    @Select("SELECT * FROM words")
    List<Word> getAllWords();

    @Select("SELECT * FROM words " +
            "WHERE property_name " +
            "LIKE '%'#{propertyName}'%'")
    List<Word> getWordsByPropertyName(@Param("propertyName") final String propertyName);

    @Select("SELECT * FROM words " +
            "WHERE id = #{id}")
    Optional<Word> getWordById(@Param("id") final long id);

    @Select("SELECT * FROM words " +
            "WHERE property_name = #{propertyName}")
    Optional<Word> getWordByPropertyName(@Param("propertyName") final String propertyName);

    @Insert("INSERT INTO words(text, description, property_name) " +
            "values(#{text}, #{description}, #{propertyName})")
    @SelectKey(statement = "call identity()", keyProperty = "id", before = false, resultType = Long.class)
    void createWord(final Word word);

    @Update("UPDATE words " +
            "SET text = #{text}, description = #{description}, property_name = #{propertyName} " +
            "WHERE id = #{id}")
    void updateWordById(final Word word);

    @Delete("DELETE * FROM words " +
            "WHERE id = #{id}")
    void deleteWordById(@Param("id") final long id);

    @Delete("DELETE * FROM words " +
            "WHERE property_name = #{propertyName}")
    void deleteWordByPropertyName(@Param("propertyName") final String propertyName);

}
