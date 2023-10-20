package com.ozgursertel.guitartuneapi.repository;

import com.ozgursertel.guitartuneapi.entity.Chord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChordRepository extends JpaRepository<Chord,Integer> {
    Optional<Chord> findByShorthand(String shorthand);
    Optional<Chord> findByName(String name);
    Optional<Chord> findByNameAndType(String name,String type);

    @Query("SELECT c FROM Chord c WHERE c.shorthand = :string OR c.name = :string")
    Optional<Chord> findByNameOrShorthand(String string);
}
