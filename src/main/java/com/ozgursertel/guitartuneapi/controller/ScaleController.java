package com.ozgursertel.guitartuneapi.controller;

import com.ozgursertel.guitartuneapi.entity.Chord;
import com.ozgursertel.guitartuneapi.entity.Scale;
import com.ozgursertel.guitartuneapi.services.ChordService;
import com.ozgursertel.guitartuneapi.services.ScaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/scales")
public class ScaleController {
    @Autowired
    private ScaleService scaleService;
    @Autowired
    private ChordService chordService;

    @PostMapping("/add")
    public ResponseEntity<Scale> addScale(@RequestBody Scale scale){
        return ResponseEntity.ok(scaleService.addScale(scale));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteScaleById(@RequestParam int id){
        return ResponseEntity.ok(scaleService.deleteScaleById(id));
    }

    @GetMapping
    public ResponseEntity<Optional<Scale>> findScale(@RequestParam String scale){
        return ResponseEntity.ok(scaleService.findScale(scale));
    }

    @PutMapping("/chordtoscale")
    public ResponseEntity<Scale> addChordToScale(@RequestParam String chord,@RequestParam String scale) throws UnsupportedEncodingException {
        Chord c  = chordService.findChord(chord).get();
        Scale s  = scaleService.findScale(scale).get();
        return ResponseEntity.ok(scaleService.addChordToScale(c,s));
    }



}
