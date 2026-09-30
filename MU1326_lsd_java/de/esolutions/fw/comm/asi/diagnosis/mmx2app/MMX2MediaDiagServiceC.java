/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sApplicationSoftwareVersionNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSerialNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSparePartNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSubsystemState;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSystemName;
import de.esolutions.fw.comm.asi.diagnosis.media.sActiveMediaSourceState;
import de.esolutions.fw.comm.asi.diagnosis.media.sDTCPState;
import de.esolutions.fw.comm.asi.diagnosis.media.sMediaDBVersion;
import de.esolutions.fw.comm.asi.diagnosis.media.sMediaRegionCodes;
import de.esolutions.fw.comm.asi.diagnosis.media.sMediaTypeOpticalDrive;
import de.esolutions.fw.comm.asi.diagnosis.media.sPmlState;
import de.esolutions.fw.comm.asi.diagnosis.media.sUsbOvercurrent;
import de.esolutions.fw.comm.core.method.MethodException;

public interface MMX2MediaDiagServiceC {
    public void responseErrorMedia(sClientResponseError var1) throws MethodException;

    public void responseSubsystemState(sSubsystemState var1) throws MethodException;

    public void responseMediaDBVersion(sMediaDBVersion var1) throws MethodException;

    public void responseActiveMediaSourceState(sActiveMediaSourceState var1) throws MethodException;

    public void responseMediaRegionCodes(sMediaRegionCodes var1) throws MethodException;

    public void responseMediaTypeOpticalDrive(sMediaTypeOpticalDrive var1) throws MethodException;

    public void responseUsbOvercurrent(sUsbOvercurrent var1) throws MethodException;

    public void responsePmlState(sPmlState var1) throws MethodException;

    public void responseSparePartNumberMediaDB(sSparePartNumber var1) throws MethodException;

    public void responseApplicationSoftwareVersionNumberMediaDB(sApplicationSoftwareVersionNumber var1) throws MethodException;

    public void responseSerialNumberMediaDB(sSerialNumber var1) throws MethodException;

    public void responseSystemNameMediaDB(sSystemName var1) throws MethodException;

    public void responseStatusUSBCommunication(long var1, int var3) throws MethodException;

    public void responseUSBHubIdentification(long var1, short[] var3) throws MethodException;

    public void responseDTCPEncryptionState(long var1, sDTCPState[] var3) throws MethodException;

    public void responseDTCPKeytypeMMX(long var1, int var3) throws MethodException;

    public void responseDTCPSRMInfo(long var1, short var3, int var4, int var5) throws MethodException;
}

