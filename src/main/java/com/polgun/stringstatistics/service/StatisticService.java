package com.polgun.stringstatistics.service;

import com.polgun.stringstatistics.dto.ResponseDto;
import com.polgun.stringstatistics.dto.StatisticResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Service for storing strings in memory and calculating statistics.
 */
public interface StatisticService {
    /**
     * Load strings into STRING_STATISTICS map.
     *
     * @param strings list of strings
     * @return response entity
     */
    ResponseEntity<ResponseDto> loadStrings(List<String> strings);

    /**
     * Clears statistics.
     *
     * @return response entity
     */
    ResponseEntity<ResponseDto> clear();

    /**
     * Calculates statistics.
     *
     * @return response entity
     */
    ResponseEntity<StatisticResponseDto> getStatistics();
}
