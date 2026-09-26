/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rsdb;

public interface IRSDBResult {
    public static final int RESULT_ACTIVE_STATION;
    public static final int RESULT_STATION_LIST;
    public static final int RESULT_MEMORY_LIST;

    default public void resultAvailable() {
    }
}

