package com.polgun.stringstatistics.dto;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class ResponseDto {
    private List<String> alerts = new LinkedList<>();
}
