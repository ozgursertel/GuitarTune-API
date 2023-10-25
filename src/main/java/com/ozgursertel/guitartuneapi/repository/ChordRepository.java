package com.ozgursertel.guitartuneapi.repository;

import com.ozgursertel.guitartuneapi.entity.Chord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChordRepository extends JpaRepository<Chord,Integer> {

    @Query(value = "SELECT * FROM chords c WHERE c.basenote1 = :baseNote OR c.basenotealiasname = :baseNote",nativeQuery = true)
    List<Chord> findChordsByBaseNote(String baseNote);

    @Query(value = "SELECT * FROM chords c WHERE c.shorthand = :string OR c.name = :string OR c.aliasname = :string",nativeQuery = true)
    Optional<Chord> findByNameOrShorthandOrAliasname(String string);
}
