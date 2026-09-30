/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.sportchrono;

import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.RecordingRange;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCData;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCHeader;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCRefLapData;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCRefLapHeader;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.TransferState;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncCarSportChronoReply {
    public static final String IPL_COMM_UUID = "38295c72-4d73-4857-919d-548f4e0abbdd";
    public static final String IPL_COMM_INTERFACE_KEY = "98008024-b4e6-5a1f-8cf9-1c1a2dc9dad6";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.1.00";
    public static final String IPL_COMM_MODULE_VERSION = "2.0.00";

    public void responseRecordData(SCData[] var1, int var2) throws MethodException;

    public void responseTrackData(int var1, SCData[] var2, int var3) throws MethodException;

    public void responseInitTrackTransfer(int var1, int var2) throws MethodException;

    public void responseSetTrackData(int var1, int var2) throws MethodException;

    public void responseSetReferenceLap(int var1, int var2) throws MethodException;

    public void responseReferenceLapData(int var1, SCRefLapData[] var2, int var3) throws MethodException;

    public void responseSaveReferenceLap(int var1) throws MethodException;

    public void updateASIVersion(String var1, boolean var2) throws MethodException;

    public void updateRequestIDs(short[] var1, boolean var2) throws MethodException;

    public void updateReplyIDs(short[] var1, boolean var2) throws MethodException;

    public void updateSCVisibilityState(int var1, boolean var2) throws MethodException;

    public void updateActiveRecord(SCHeader var1, boolean var2) throws MethodException;

    public void updateActiveRecordData(SCData var1, boolean var2) throws MethodException;

    public void updateRecordMode(int var1, boolean var2) throws MethodException;

    public void updateTrackList(SCHeader[] var1, boolean var2) throws MethodException;

    public void updateTransferState(TransferState var1, boolean var2) throws MethodException;

    public void updateRecordingTime(long var1, boolean var3) throws MethodException;

    public void updateRecordingRange(RecordingRange var1, boolean var2) throws MethodException;

    public void updateSelectedReferenceLapUid(int var1, boolean var2) throws MethodException;

    public void updateReferenceLapList(SCRefLapHeader[] var1, boolean var2) throws MethodException;
}

