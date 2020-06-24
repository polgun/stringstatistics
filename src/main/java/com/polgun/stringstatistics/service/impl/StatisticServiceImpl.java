package com.polgun.stringstatistics.service.impl;

import com.polgun.stringstatistics.dto.ResponseDto;
import com.polgun.stringstatistics.dto.StatisticResponseDto;
import com.polgun.stringstatistics.dto.StringCountDto;
import com.polgun.stringstatistics.model.CounterInfo;
import com.polgun.stringstatistics.service.StatisticService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class StatisticServiceImpl implements StatisticService {
    private final static Map<String, CounterInfo> STRING_STATISTICS = new LinkedHashMap<>();
    private final static ResponseEntity<ResponseDto> OK = new ResponseEntity<>(new ResponseDto(), HttpStatus.OK);

    @Override
    public ResponseEntity<ResponseDto> loadStrings(@Nullable List<String> strings) {
        if (strings == null) {
            log.info("Empty strings received.");
            return OK;
        }
        strings.forEach(this::save);
        return OK;
    }

    @Override
    public ResponseEntity<ResponseDto> clear() {
        clearMap();
        return OK;
    }

    private void save(String s) {
        if (s == null) {
            log.info("Skipping null");
            return;
        }
        STRING_STATISTICS.compute(s, (k, v) -> v == null ? new CounterInfo(0L) : v).increment();
    }

    /**
     * Retrieves statistics sorted descending.
     *
     * @return sorted by occurency frequiency list
     */
    private List<StringCountDto> getSortedStatistics() {
        return STRING_STATISTICS.entrySet()
                .stream()
                .sorted(Map.Entry.<String, CounterInfo>comparingByValue().reversed())
                .map(entry -> new StringCountDto(entry.getKey(), entry.getValue().getCount()))
                .collect(Collectors.toList());
    }

    /**
     * Counts average not unique string length.
     *
     * @param counters list of strings
     * @return
     */
    private Double countAverage(List<StringCountDto> counters) {
        long sum = 0;
        long count = 0;
        for (StringCountDto counter : counters) {
            sum += counter.getCount() * counter.getString().length();
            count += counter.getCount();
        }
        return (double) sum / count;
    }

    @Override
    public ResponseEntity<StatisticResponseDto> getStatistics() {
        StatisticResponseDto result = new StatisticResponseDto();
        List<StringCountDto> counters = getSortedStatistics();
        boolean isEmpty = CollectionUtils.isEmpty(counters);
        result.setStatistics(isEmpty ? null : counters);
        result.setAverageLength(isEmpty ? 0 : countAverage(counters));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Removes all elements from the map.
     */
    void clearMap() {
        STRING_STATISTICS.clear();
    }
}
