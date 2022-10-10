package com.iSystem.image.imageDto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImageDto {
    private Integer id;
    @NotBlank(message = ("id not null or not empty"))
    private String url;
    @NotBlank(message = ("id not null or not empty"))
    private String path;
    @NotBlank(message = ("id not null or not empty"))
    private Long size;
    @NotBlank(message = ("id not null or not empty"))
    private String type; //png, jpg
    @NotBlank(message = ("id not null or not empty"))
    private String  token;
}
