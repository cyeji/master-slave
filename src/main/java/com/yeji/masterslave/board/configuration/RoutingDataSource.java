package com.yeji.masterslave.board.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class RoutingDataSource extends AbstractRoutingDataSource {

    private final int numberOfSlaves;
    private final AtomicInteger counter = new AtomicInteger(0);

    public RoutingDataSource(int numberOfSlaves) {
        this.numberOfSlaves = numberOfSlaves;
    }

    @Override
    protected Object determineCurrentLookupKey() {
        if (TransactionSynchronizationManager.isCurrentTransactionReadOnly()) {
            int index = counter.getAndIncrement() % numberOfSlaves;
            DataBaseReplica replica = DataBaseReplica.values()[index + 1];
            log.debug("Using slave data source : " + replica);
            return replica;
        } else {
            log.debug("Using master data source : ");
            return DataBaseReplica.MASTER;
        }
    }

}
