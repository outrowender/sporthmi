/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.sportchrono;

import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCData;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCHeader;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncCarSportChronoC {
    public void requestRecordData(long var1, long var3) throws MethodException;

    public void setRecord(int var1) throws MethodException;

    public void requestTrackData(int var1) throws MethodException;

    public void initTrackTransfer(SCHeader var1, String var2) throws MethodException;

    public void setTrackData(int var1, SCData[] var2, int var3) throws MethodException;

    public void setReferenceLap(int var1) throws MethodException;

    public void requestReferenceLapData(int var1) throws MethodException;

    public void saveReferenceLap(int var1, short var2) throws MethodException;

    public void setNotification() throws MethodException;

    public void setNotification(long var1) throws MethodException;

    public void setNotification(long[] var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void clearNotification(long var1) throws MethodException;

    public void clearNotification(long[] var1) throws MethodException;
}

