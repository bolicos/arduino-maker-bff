package com.github.analuciabolico.arduinomakerbff.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "classes")
public class Block {
    @Id
    private String id;
    private String name;
    private String code;
    private String include;
    private String type;
    private Integer quantity;
}