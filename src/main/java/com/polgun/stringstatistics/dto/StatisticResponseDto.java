package com.polgun.stringstatistics.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class StatisticResponseDto extends ResponseDto {
    /**
     * List of {@link StringCountDto}.
     */
    List<StringCountDto> statistics;

    /**
     * Avergae string length.
     */
    Double averageLength;
}
