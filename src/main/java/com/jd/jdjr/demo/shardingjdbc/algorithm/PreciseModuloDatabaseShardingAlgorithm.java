package com.jd.jdjr.demo.shardingjdbc.algorithm;

import io.shardingsphere.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.Collection;

public final class PreciseModuloDatabaseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

    @Override
    public String doSharding(final Collection<String> availableTargetNames, final PreciseShardingValue<Long> shardingValue) {
        for (String each : availableTargetNames) {
            if (each.endsWith((shardingValue.getValue()%(2*2)) / 2 + "")) {
                return each;
            }
        }
        throw new UnsupportedOperationException();
    }
}
