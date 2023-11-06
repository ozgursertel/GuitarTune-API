package com.ozgursertel.guitartuneapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
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

    @JsonIgnore
    @ManyToMany(mappedBy = "chords",fetch = FetchType.LAZY)
    private Set<Scale> scales;
}
