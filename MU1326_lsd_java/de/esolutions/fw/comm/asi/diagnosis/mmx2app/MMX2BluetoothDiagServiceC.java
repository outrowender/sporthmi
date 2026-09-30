/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sBluetoothDeviceName;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sBluetoothDevices;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sBluetoothMAC;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sBluetoothState;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sConnectedBtDevice;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sConnectedBtDevices;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sLastPairedBtDevices;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sPairedBtDevices;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sRoutineResponse;
import de.esolutions.fw.comm.core.method.MethodException;

public interface MMX2BluetoothDiagServiceC {
    public void responseErrorBluetooth(sClientResponseError var1) throws MethodException;

    public void responseBluetoothState(sBluetoothState var1) throws MethodException;

    public void responseBluetoothMAC(sBluetoothMAC var1) throws MethodException;

    public void responseBluetoothDevices(sBluetoothDevices var1) throws MethodException;

    public void responseLastPairedBtDevices(sLastPairedBtDevices var1) throws MethodException;

    public void responsePairedBtDevices(sPairedBtDevices var1) throws MethodException;

    public void responseConnectedBtDevices(sConnectedBtDevices var1) throws MethodException;

    public void responseConnectedBtDevice(sConnectedBtDevice var1) throws MethodException;

    public void responseAutoConnectBtHandset(sRoutineResponse var1) throws MethodException;

    public void responseBtDeleteLinkKeys(sRoutineResponse var1) throws MethodException;

    public void responseBtDeviceSearch(long var1) throws MethodException;

    public void responseBtDeviceSearchItem(sBluetoothDeviceName[] var1) throws MethodException;

    public void responseConnectionToLastBtDevice(long var1) throws MethodException;
}

