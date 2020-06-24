package com.polgun.stringstatistics.service.impl;

import com.google.common.collect.ImmutableList;
import com.polgun.stringstatistics.dto.StatisticResponseDto;
import com.polgun.stringstatistics.dto.StringCountDto;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class StatisticServiceArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {

        return Stream.of(
                arguments(Collections.singletonList("one"),
                        new StatisticResponseDto(
                                ImmutableList.of(
                                        new StringCountDto("one", 1L)),
                                3d)),
                arguments(Arrays.asList("one", "two", "three"),
                        new StatisticResponseDto(
                                ImmutableList.of(
                                        new StringCountDto("one", 1L),
                                        new StringCountDto("two", 1L),
                                        new StringCountDto("three", 1L)),
                                (double) 11 / 3)),
                arguments(Arrays.asList("one", "two", "one", "one", "two", "three"),
                        new StatisticResponseDto(
                                ImmutableList.of(
                                        new StringCountDto("one", 3L),
                                        new StringCountDto("two", 2L),
                                        new StringCountDto("three", 1L)),
                                (double) 20 / 6))
        );
    }
}