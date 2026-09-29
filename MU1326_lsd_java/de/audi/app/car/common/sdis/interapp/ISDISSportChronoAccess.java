/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.sdis.interapp;

import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCData;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCHeader;

public interface ISDISSportChronoAccess {
    default public SCData[] requestRecordData(long l, long l2) {
    }

    default public void setRecord(int n) {
    }

    default public SCData[] requestTrackData(int n) {
    }

    default public int initTrackTransfer(SCHeader sCHeader, String string) {
    }

    default public int setTrackData(int n, SCData[] sCDataArray, int n2) {
    }
}

