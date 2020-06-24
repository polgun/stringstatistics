package com.polgun.stringstatistics.controller.impl;

import com.polgun.stringstatistics.controller.StringStatisticsController;
import com.polgun.stringstatistics.dto.ResponseDto;
import com.polgun.stringstatistics.dto.StatisticResponseDto;
import com.polgun.stringstatistics.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class StringStatisticsControllerImpl implements StringStatisticsController {
    private final StatisticService statisticService;

    @PostMapping("load-strings")
    public ResponseEntity<ResponseDto> loadStrings(@RequestBody List<String> strings) {
        return statisticService.loadStrings(strings);
    }

    @GetMapping("get-statistics")
    public ResponseEntity<StatisticResponseDto> getStatistics() {
        return statisticService.getStatistics();
    }

    @GetMapping("clear")
    public ResponseEntity<ResponseDto> clear() {
        return statisticService.clear();
    }
}
