/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.bluetooth.impl.sBluetoothDeviceNameSerializer;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.impl.sBluetoothDevicesSerializer;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.impl.sBluetoothMACSerializer;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.impl.sBluetoothStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.impl.sConnectedBtDeviceSerializer;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.impl.sConnectedBtDevicesSerializer;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.impl.sLastPairedBtDevicesSerializer;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.impl.sPairedBtDevicesSerializer;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sBluetoothDeviceName;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sBluetoothDevices;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sBluetoothMAC;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sBluetoothState;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sConnectedBtDevice;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sConnectedBtDevices;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sLastPairedBtDevices;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sPairedBtDevices;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sClientResponseErrorSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sRoutineResponseSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sRoutineResponse;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2BluetoothDiagService;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2BluetoothDiagServiceC;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2BluetoothDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2BluetoothDiagServiceProxy
implements MMX2BluetoothDiagService,
MMX2BluetoothDiagServiceC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2BluetoothDiagService");
    private Proxy proxy;

    public MMX2BluetoothDiagServiceProxy(int n, MMX2BluetoothDiagServiceReply mMX2BluetoothDiagServiceReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("f669c772-a80d-457f-b9af-0eb44581d9e1", n, "95c41391-df54-5fea-80a5-0615f88b8b03", "asi.diagnosis.mmx2app.MMX2BluetoothDiagService");
        MMX2BluetoothDiagServiceReplyService mMX2BluetoothDiagServiceReplyService = new MMX2BluetoothDiagServiceReplyService(mMX2BluetoothDiagServiceReply);
        this.proxy = new Proxy(serviceInstanceID, mMX2BluetoothDiagServiceReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void responseErrorBluetooth(final sClientResponseError sClientResponseError2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sClientResponseErrorSerializer.putOptionalsClientResponseError(iSerializer, sClientResponseError2);
            }
        };
        this.proxy.remoteCallMethod((short)37, iSerializable);
    }

    public void responseBluetoothState(final sBluetoothState sBluetoothState2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sBluetoothStateSerializer.putOptionalsBluetoothState(iSerializer, sBluetoothState2);
            }
        };
        this.proxy.remoteCallMethod((short)14, iSerializable);
    }

    public void responseBluetoothMAC(final sBluetoothMAC sBluetoothMAC2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sBluetoothMACSerializer.putOptionalsBluetoothMAC(iSerializer, sBluetoothMAC2);
            }
        };
        this.proxy.remoteCallMethod((short)13, iSerializable);
    }

    public void responseBluetoothDevices(final sBluetoothDevices sBluetoothDevices2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sBluetoothDevicesSerializer.putOptionalsBluetoothDevices(iSerializer, sBluetoothDevices2);
            }
        };
        this.proxy.remoteCallMethod((short)12, iSerializable);
    }

    public void responseLastPairedBtDevices(final sLastPairedBtDevices sLastPairedBtDevices2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sLastPairedBtDevicesSerializer.putOptionalsLastPairedBtDevices(iSerializer, sLastPairedBtDevices2);
            }
        };
        this.proxy.remoteCallMethod((short)38, iSerializable);
    }

    public void responsePairedBtDevices(final sPairedBtDevices sPairedBtDevices2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sPairedBtDevicesSerializer.putOptionalsPairedBtDevices(iSerializer, sPairedBtDevices2);
            }
        };
        this.proxy.remoteCallMethod((short)32, iSerializable);
    }

    public void responseConnectedBtDevices(final sConnectedBtDevices sConnectedBtDevices2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sConnectedBtDevicesSerializer.putOptionalsConnectedBtDevices(iSerializer, sConnectedBtDevices2);
            }
        };
        this.proxy.remoteCallMethod((short)31, iSerializable);
    }

    public void responseConnectedBtDevice(final sConnectedBtDevice sConnectedBtDevice2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sConnectedBtDeviceSerializer.putOptionalsConnectedBtDevice(iSerializer, sConnectedBtDevice2);
            }
        };
        this.proxy.remoteCallMethod((short)17, iSerializable);
    }

    public void responseAutoConnectBtHandset(final sRoutineResponse sRoutineResponse2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sRoutineResponseSerializer.putOptionalsRoutineResponse(iSerializer, sRoutineResponse2);
            }
        };
        this.proxy.remoteCallMethod((short)27, iSerializable);
    }

    public void responseBtDeleteLinkKeys(final sRoutineResponse sRoutineResponse2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sRoutineResponseSerializer.putOptionalsRoutineResponse(iSerializer, sRoutineResponse2);
            }
        };
        this.proxy.remoteCallMethod((short)28, iSerializable);
    }

    public void responseBtDeviceSearch(long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)16, genericSerializable);
    }

    public void responseBtDeviceSearchItem(final sBluetoothDeviceName[] sBluetoothDeviceNameArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sBluetoothDeviceNameSerializer.putOptionalsBluetoothDeviceNameVarArray(iSerializer, sBluetoothDeviceNameArray);
            }
        };
        this.proxy.remoteCallMethod((short)36, iSerializable);
    }

    public void responseConnectionToLastBtDevice(long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)19, genericSerializable);
    }
}

