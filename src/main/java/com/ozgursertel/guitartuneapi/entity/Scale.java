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
@Table(name = "scales")
public class Scale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scaleID")
    private int scaleId;
    @Column(name = "name")
    private String name;
    @Column(name ="type")
    @Enumerated(EnumType.STRING)
    private ScaleType type;
    @Column(name = "diagram_url")
    private String diagramUrl;
    @Column(name = "description")
    private String description;
    @Column(name = "basenote")
    private String basenote;
    @Column(name = "relatedminor")
    private String relatedMinor;

    @JsonIgnore
    @Column(name = "aliasname")
    private String aliasname;
    @JsonIgnore
    @Column(name = "basenotealiasname")
    private String baseNoteAliasName;
    @JsonIgnore
    @Column(name = "relatedminoraliasname")
    private String relatedMinorAliasName;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "scale_chord_relations_tbl",
            joinColumns = {
                @JoinColumn(name = "sID",referencedColumnName = "scaleID")
                },
            inverseJoinColumns = {
                @JoinColumn(name = "cID",referencedColumnName = "chordID")
            }
    )
    private Set<Chord> chords;

}
