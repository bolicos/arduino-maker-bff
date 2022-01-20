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
    private String code;
    private String include;
    private String type;
    private Integer quantity;

    public static Block dtoToEntity(final BlockDto blockDto) {
        return new Block(blockDto.id, blockDto.name, blockDto.code, blockDto.include, blockDto.type, blockDto.quantity);
    }

    public static BlockDto entityToDto(final Block block) {
        return new BlockDto(
            block.getId(), block.getName(), block.getCode(), block.getInclude(), block.getType(), block.getQuantity());
    }

}
