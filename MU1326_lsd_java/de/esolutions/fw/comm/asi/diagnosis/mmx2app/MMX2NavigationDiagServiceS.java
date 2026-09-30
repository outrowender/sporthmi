/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sApplicationSoftwareVersionNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sHardwareNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sHardwareVersionNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sRoutineResponse;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSerialNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSparePartNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSubsystemState;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSystemName;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2NavigationDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sActiveNavDB;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sGPSNoSatellite;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sGPSOffroad;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCalibrationState;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCorrectedDirection;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCorrectedPosition;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCountryRegionVersion;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sVersionsNavDB;
import de.esolutions.fw.comm.core.method.MethodException;

public interface MMX2NavigationDiagServiceS {
    public void responseErrorNavigation(sClientResponseError var1, MMX2NavigationDiagServiceReply var2) throws MethodException;

    public void responseSubsystemState(sSubsystemState var1, MMX2NavigationDiagServiceReply var2) throws MethodException;

    public void responseVersionsNavDB(sVersionsNavDB var1, MMX2NavigationDiagServiceReply var2) throws MethodException;

    public void responseActiveNavDB(sActiveNavDB var1, MMX2NavigationDiagServiceReply var2) throws MethodException;

    public void responseGPSNoSatellite(sGPSNoSatellite var1, MMX2NavigationDiagServiceReply var2) throws MethodException;

    public void responseGPSOffroad(sGPSOffroad var1, MMX2NavigationDiagServiceReply var2) throws MethodException;

    public void responseNavCalibrationState(sNavCalibrationState var1, MMX2NavigationDiagServiceReply var2) throws MethodException;

    public void responseNavCorrectedPosition(sNavCorrectedPosition var1, MMX2NavigationDiagServiceReply var2) throws MethodException;

    public void responseNavCorrectedDirection(sNavCorrectedDirection var1, MMX2NavigationDiagServiceReply var2) throws MethodException;

    public void responseResetCalibration(sRoutineResponse var1, MMX2NavigationDiagServiceReply var2) throws MethodException;

    public void responseSparePartNumberNavDB(sSparePartNumber var1, MMX2NavigationDiagServiceReply var2) throws MethodException;

    public void responseApplicationSoftwareVersionNumberNavDB(sApplicationSoftwareVersionNumber var1, MMX2NavigationDiagServiceReply var2) throws MethodException;

    public void responseHardwareNumberNavDB(sHardwareNumber var1, MMX2NavigationDiagServiceReply var2) throws MethodException;

    public void responseHardwareVersionNumberNavDB(sHardwareVersionNumber var1, MMX2NavigationDiagServiceReply var2) throws MethodException;

    public void responseSerialNumberNavDB(sSerialNumber var1, MMX2NavigationDiagServiceReply var2) throws MethodException;

    public void responseSystemNameNavDB(sSystemName var1, MMX2NavigationDiagServiceReply var2) throws MethodException;

    public void responseCountryRegionVersion(sNavCountryRegionVersion var1, MMX2NavigationDiagServiceReply var2) throws MethodException;
}

