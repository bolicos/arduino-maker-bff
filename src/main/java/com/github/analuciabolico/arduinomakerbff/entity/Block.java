package com.github.analuciabolico.arduinomakerbff.entity;

import lombok.AllArgsConstructor;  
import lombok.Data;  
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "blocks")
@AllArgsConstructor  
@NoArgsConstructor  
public class Block {
    @Id
    private String id;
    private String name;
    private String description;
}