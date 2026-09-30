/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.sdis.interapp;

import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCData;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCHeader;

public interface ISDISSportChronoAccess {
    public SCData[] requestRecordData(long var1, long var3);

    public void setRecord(int var1);

    public SCData[] requestTrackData(int var1);

    public int initTrackTransfer(SCHeader var1, String var2);

    public int setTrackData(int var1, SCData[] var2, int var3);
}

