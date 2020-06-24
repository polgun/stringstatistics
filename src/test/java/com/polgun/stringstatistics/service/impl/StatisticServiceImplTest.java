package com.polgun.stringstatistics.service.impl;

import com.polgun.stringstatistics.dto.StatisticResponseDto;
import org.junit.Assert;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class StatisticServiceImplTest {
    @InjectMocks
    StatisticServiceImpl statisticService;

    @ParameterizedTest
    @NullAndEmptySource
    void getStatisticsEmptyStringsTest(List<String> strings) {
        statisticService.clearMap();
        statisticService.loadStrings(strings);
        Assert.assertEquals(statisticService.getStatistics().getBody(),
                new StatisticResponseDto(null, 0d));
    }

    @ParameterizedTest
    @ArgumentsSource(StatisticServiceArgumentsProvider.class)
    void getStatisticsTest(List<String> strings, StatisticResponseDto expectedResponse) {
        statisticService.clearMap();
        statisticService.loadStrings(strings);
        Assert.assertEquals(expectedResponse, statisticService.getStatistics().getBody());
    }
}