package com.polgun.stringstatistics.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CounterInfo implements Comparable<CounterInfo> {
    private Long count;

    @Override
    public int compareTo(CounterInfo o) {
        return count.compareTo(o.count);
    }

    public void increment() {
        this.count++;
    }
}
