package com.fxipp.example.shardingjdbc.config;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 自定义分片规则
 * @author fangxi
 * @date 2020/2/28
 */
public class DefaultPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

    /**
     * @param availableTargetNames 可用的数据表, order_1, order_2
     * @param shardingValue 当前的分片值，根据id分片就是id
     */
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
        Long id = shardingValue.getValue();
        // 根据id的hash值和表的数量规则分片
        int mode = Math.abs(id.hashCode() % availableTargetNames.size());
        List<String> tables = new ArrayList<>(availableTargetNames);
        return tables.get(mode);
    }

}
