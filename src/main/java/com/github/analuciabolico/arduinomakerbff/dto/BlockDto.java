package com.github.analuciabolico.arduinomakerbff.dto;

import com.github.analuciabolico.arduinomakerbff.entity.Block;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlockDto {
    private String id;
    private String name;
    private String description;

    public static Block dtoToEntity(final BlockDto blockDto) {
        return new Block(blockDto.id, blockDto.name, blockDto.description);
    }

    public static BlockDto entityToDto(final Block block) {
        return new BlockDto(block.getId(), block.getName(), block.getDescription());
    }

}
