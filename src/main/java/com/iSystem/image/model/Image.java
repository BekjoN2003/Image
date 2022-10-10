package com.iSystem.image.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = ("images"))
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = ("path"))
    private String path;
    @Column(name = ("type"))
    private String type;
    @Column(name = ("size"))
    private Long size;
    @Column(name = ("url"))
    private String URL;
    @Column(name = ("token"))
    private String token;
    @Column(name = ("created_at"))
    private LocalDateTime createdDate;
}