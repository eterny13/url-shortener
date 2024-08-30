/*
 * This file is generated by jOOQ.
 */
package com.example.generated.db.tables.records;


import com.example.generated.db.tables.FlywaySchemaHistory;
import com.example.generated.db.tables.interfaces.IFlywaySchemaHistory;

import java.time.LocalDateTime;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class FlywaySchemaHistoryRecord extends UpdatableRecordImpl<FlywaySchemaHistoryRecord> implements IFlywaySchemaHistory {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for
     * <code>urlShortener.flyway_schema_history.installed_rank</code>.
     */
    @Override
    public void setInstalledRank(Integer value) {
        set(0, value);
    }

    /**
     * Getter for
     * <code>urlShortener.flyway_schema_history.installed_rank</code>.
     */
    @Override
    public Integer getInstalledRank() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>urlShortener.flyway_schema_history.version</code>.
     */
    @Override
    public void setVersion(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>urlShortener.flyway_schema_history.version</code>.
     */
    @Override
    public String getVersion() {
        return (String) get(1);
    }

    /**
     * Setter for <code>urlShortener.flyway_schema_history.description</code>.
     */
    @Override
    public void setDescription(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>urlShortener.flyway_schema_history.description</code>.
     */
    @Override
    public String getDescription() {
        return (String) get(2);
    }

    /**
     * Setter for <code>urlShortener.flyway_schema_history.type</code>.
     */
    @Override
    public void setType(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>urlShortener.flyway_schema_history.type</code>.
     */
    @Override
    public String getType() {
        return (String) get(3);
    }

    /**
     * Setter for <code>urlShortener.flyway_schema_history.script</code>.
     */
    @Override
    public void setScript(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>urlShortener.flyway_schema_history.script</code>.
     */
    @Override
    public String getScript() {
        return (String) get(4);
    }

    /**
     * Setter for <code>urlShortener.flyway_schema_history.checksum</code>.
     */
    @Override
    public void setChecksum(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>urlShortener.flyway_schema_history.checksum</code>.
     */
    @Override
    public Integer getChecksum() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>urlShortener.flyway_schema_history.installed_by</code>.
     */
    @Override
    public void setInstalledBy(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>urlShortener.flyway_schema_history.installed_by</code>.
     */
    @Override
    public String getInstalledBy() {
        return (String) get(6);
    }

    /**
     * Setter for <code>urlShortener.flyway_schema_history.installed_on</code>.
     */
    @Override
    public void setInstalledOn(LocalDateTime value) {
        set(7, value);
    }

    /**
     * Getter for <code>urlShortener.flyway_schema_history.installed_on</code>.
     */
    @Override
    public LocalDateTime getInstalledOn() {
        return (LocalDateTime) get(7);
    }

    /**
     * Setter for
     * <code>urlShortener.flyway_schema_history.execution_time</code>.
     */
    @Override
    public void setExecutionTime(Integer value) {
        set(8, value);
    }

    /**
     * Getter for
     * <code>urlShortener.flyway_schema_history.execution_time</code>.
     */
    @Override
    public Integer getExecutionTime() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>urlShortener.flyway_schema_history.success</code>.
     */
    @Override
    public void setSuccess(Byte value) {
        set(9, value);
    }

    /**
     * Getter for <code>urlShortener.flyway_schema_history.success</code>.
     */
    @Override
    public Byte getSuccess() {
        return (Byte) get(9);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IFlywaySchemaHistory from) {
        setInstalledRank(from.getInstalledRank());
        setVersion(from.getVersion());
        setDescription(from.getDescription());
        setType(from.getType());
        setScript(from.getScript());
        setChecksum(from.getChecksum());
        setInstalledBy(from.getInstalledBy());
        setInstalledOn(from.getInstalledOn());
        setExecutionTime(from.getExecutionTime());
        setSuccess(from.getSuccess());
        resetChangedOnNotNull();
    }

    @Override
    public <E extends IFlywaySchemaHistory> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached FlywaySchemaHistoryRecord
     */
    public FlywaySchemaHistoryRecord() {
        super(FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY);
    }

    /**
     * Create a detached, initialised FlywaySchemaHistoryRecord
     */
    public FlywaySchemaHistoryRecord(Integer installedRank, String version, String description, String type, String script, Integer checksum, String installedBy, LocalDateTime installedOn, Integer executionTime, Byte success) {
        super(FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY);

        setInstalledRank(installedRank);
        setVersion(version);
        setDescription(description);
        setType(type);
        setScript(script);
        setChecksum(checksum);
        setInstalledBy(installedBy);
        setInstalledOn(installedOn);
        setExecutionTime(executionTime);
        setSuccess(success);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised FlywaySchemaHistoryRecord
     */
    public FlywaySchemaHistoryRecord(com.example.generated.db.tables.pojos.FlywaySchemaHistory value) {
        super(FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY);

        if (value != null) {
            setInstalledRank(value.getInstalledRank());
            setVersion(value.getVersion());
            setDescription(value.getDescription());
            setType(value.getType());
            setScript(value.getScript());
            setChecksum(value.getChecksum());
            setInstalledBy(value.getInstalledBy());
            setInstalledOn(value.getInstalledOn());
            setExecutionTime(value.getExecutionTime());
            setSuccess(value.getSuccess());
            resetChangedOnNotNull();
        }
    }
}
