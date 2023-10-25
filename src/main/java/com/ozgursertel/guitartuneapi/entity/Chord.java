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
    @Column(name = "aliasname")
    private String aliasName;
    @Column(name = "basenote1")
    private String basenote1;
    @Column(name = "basenote2")
    private String basenote2;
    @Column(name = "basenote3")
    private String basenote3;
    @Column(name = "basenotealiasname")
    private String basenotealiasname;

    public String getAliasName() {
        return aliasName;
    }

    public String getBasenote1() {
        return basenote1;
    }

    public String getBasenote2() {
        return basenote2;
    }

    public String getBasenote3() {
        return basenote3;
    }

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

    public String getBasenotealiasname() {
        return basenotealiasname;
    }

}
