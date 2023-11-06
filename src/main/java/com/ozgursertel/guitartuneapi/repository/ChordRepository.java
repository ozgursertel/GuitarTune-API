package com.ozgursertel.guitartuneapi.repository;

import com.ozgursertel.guitartuneapi.entity.Chord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChordRepository extends JpaRepository<Chord,Integer> {

    @Query("SELECT c FROM Chord c WHERE c.basenote1 = :baseNote OR c.basenotealiasname = :baseNote")
    List<Chord> findChordsByBaseNote(String baseNote);


    @Query("SELECT c FROM Chord c WHERE c.name = :string OR c.shorthand = :string OR c.aliasName = :string")
    Optional<Chord> findByNameOrShorthand(String string);

    Chord findByName(String name);

}
