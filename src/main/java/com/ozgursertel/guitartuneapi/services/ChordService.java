package com.ozgursertel.guitartuneapi.services;

import com.ozgursertel.guitartuneapi.entity.Chord;
import com.ozgursertel.guitartuneapi.entity.Scale;
import com.ozgursertel.guitartuneapi.repository.ChordRepository;
import com.ozgursertel.guitartuneapi.repository.ScaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
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

    public Optional<Chord> findChord(String string) throws UnsupportedEncodingException {
        String encoded = URLEncoder.encode(string, StandardCharsets.UTF_8.toString());
        return chordRepository.findByNameOrShorthand(string);
    }

    public List<Chord> findChordsWithSameBaseNote(String string) throws  UnsupportedEncodingException{
        String encoded = URLEncoder.encode(string, StandardCharsets.UTF_8.toString());
        return chordRepository.findChordsByBaseNote(string);
    }

    public Optional<Chord> findChordById(Integer id) {
        return chordRepository.findById(id);
    }

    public void deleteChordByID(Integer id){
        chordRepository.deleteById(id);
    }

    public Chord addChordToScale(Chord chord, Scale scale) {
        chord.getScales().add(scale);
        return chordRepository.save(chord);
    }

    public List<Chord> findAllChords() {
        return chordRepository.findAll();
    }
}
