package com.ozgursertel.guitartuneapi.services;

import com.ozgursertel.guitartuneapi.entity.Chord;
import com.ozgursertel.guitartuneapi.entity.Scale;
import com.ozgursertel.guitartuneapi.repository.ScaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ScaleService {
    @Autowired
    private final ScaleRepository scaleRepository;
    public Scale addScale(Scale scale){
        return scaleRepository.save(scale);
    }

    public Optional<Scale> findScale(String string){
        return scaleRepository.findByNameOrAliasname(string);
    }

    public Optional<Scale> findScaleById(int id){
        return scaleRepository.findById(id);
    }

    public String deleteScaleById(int id){
        scaleRepository.deleteById(id);
        return "Scale with " + id + " deleted";
    }

    public Scale addChordToScale(Chord c, Scale s) {
        s.getChords().add(c);
        return scaleRepository.save(s);
    }

}
