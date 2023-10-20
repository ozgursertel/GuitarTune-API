package com.ozgursertel.guitartuneapi.controller;

import com.ozgursertel.guitartuneapi.entity.Chord;
import com.ozgursertel.guitartuneapi.services.ChordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/chords")
public class ChordController {

   @Autowired
    private ChordService chordService;

    @PostMapping("/add")
    public ResponseEntity<Chord> addChord(@RequestBody Chord chord){
        return ResponseEntity.ok(chordService.saveChord(chord));
    }

    @GetMapping
    public ResponseEntity<Optional<Chord>> findChord(@RequestParam String chord){
        return ResponseEntity.ok(chordService.findChord(chord));
    }

}