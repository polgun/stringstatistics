package com.polgun.stringstatistics.controller;

import com.polgun.stringstatistics.dto.ResponseDto;
import com.polgun.stringstatistics.dto.StatisticResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = {"String statistics API"})
@SwaggerDefinition(tags = {
        @Tag(name = "String statistics API", description = "API used to add strings to map, clear map and count statistics")
})
public interface StringStatisticsController {
    @ApiOperation("Load list of strings into map")
    ResponseEntity<ResponseDto> loadStrings(@RequestBody List<String> strings);
    @ApiOperation("Get sorted statistics about string occurences and average string length")
    ResponseEntity<StatisticResponseDto> getStatistics();
    @ApiOperation("Clear all elements from the map")
    ResponseEntity<ResponseDto> clear();
}
