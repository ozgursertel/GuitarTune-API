package com.ozgursertel.guitartuneapi.services;

import com.ozgursertel.guitartuneapi.entity.Chord;
import com.ozgursertel.guitartuneapi.repository.ChordRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ChordService {

    @Autowired
    private final ChordRepository chordRepository;

    public Chord saveChord(Chord chord){
        chordRepository.save(chord);
        return chord;
    }

    public Optional<Chord> findChord(String string){
        return chordRepository.findByNameOrShorthand(string);
    }

}
