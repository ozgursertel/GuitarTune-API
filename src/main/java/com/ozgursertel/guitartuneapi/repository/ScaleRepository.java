package com.ozgursertel.guitartuneapi.repository;

import com.ozgursertel.guitartuneapi.entity.Chord;
import com.ozgursertel.guitartuneapi.entity.Scale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ScaleRepository extends JpaRepository<Scale,Integer> {

    @Query(value = "SELECT s FROM Scale s WHERE s.name = :string OR s.aliasname = :string")
    Optional<Scale> findByNameOrAliasname(String string);

}
