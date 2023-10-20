package com.ozgursertel.guitartuneapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chords")
public class Chord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chordID")
    private int chordId;
    @Column(name = "name")
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ChordType type;
    @Column(name = "diagramUrl")
    private String diagramUrl;
    @Column(name = "shorthand")
    private String shorthand;
    @Column(name = "description")
    private String description;

    public int getChordId() {
        return chordId;
    }

    public String getName() {
        return name;
    }

    public ChordType getType() {
        return type;
    }

    public String getDiagramUrl() {
        return diagramUrl;
    }

    public String getShorthand() {
        return shorthand;
    }

    public String getDescription() {
        return description;
    }
}
