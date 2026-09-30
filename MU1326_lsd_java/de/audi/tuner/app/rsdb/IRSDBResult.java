/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rsdb;

public interface IRSDBResult {
    public static final int RESULT_ACTIVE_STATION = 1;
    public static final int RESULT_STATION_LIST = 2;
    public static final int RESULT_MEMORY_LIST = 3;

    public void resultAvailable();
}

