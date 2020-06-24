package com.polgun.stringstatistics.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StringCountDto {
    /**
     * String occurence.
     */
    String string;

    /**
     * Number of occurences.
     */
    Long count;
}
