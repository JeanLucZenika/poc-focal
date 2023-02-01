/*
 * Copyright (c) Coveo Solutions Inc.
 */
package com.coveo.globalauroradatabase.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Map;
import java.util.Objects;

import static com.coveo.globalauroradatabase.datasource.GlobalClusterAwareTransactionSynchronization.GLOBAL_CLUSTER_DATA_SOURCE_TYPE_KEY;
@Profile("postgres")
public class GlobalClusterRoutingDataSource extends AbstractRoutingDataSource
{
    private final HikariDataSource primaryDataSource;
    private final HikariDataSource secondaryDataSource;

    public GlobalClusterRoutingDataSource(HikariDataSource primary, HikariDataSource secondary)
    {
        primaryDataSource = Objects.requireNonNull(primary);
        secondaryDataSource = Objects.requireNonNull(secondary);

        Map<Object, Object> dataSources = Map.of(DataSourceType.PRIMARY, primary, DataSourceType.SECONDARY, secondary);
        super.setTargetDataSources(dataSources);
        super.setDefaultTargetDataSource(primary);
    }

    public HikariDataSource getPrimaryDataSource()
    {
        return primaryDataSource;
    }

    public HikariDataSource getSecondaryDataSource()
    {
        return secondaryDataSource;
    }

    @Override
    protected Object determineCurrentLookupKey()
    {
        return TransactionSynchronizationManager.getResource(GLOBAL_CLUSTER_DATA_SOURCE_TYPE_KEY);
    }

    public enum DataSourceType
    {
        PRIMARY, SECONDARY
    }
}
