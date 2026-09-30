/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.bluetooth.impl;

import de.esolutions.fw.comm.asi.connectivity.bluetooth.BluetoothDevice;
import de.esolutions.fw.comm.asi.connectivity.bluetooth.BluetoothInformationServiceReply;
import de.esolutions.fw.comm.asi.connectivity.bluetooth.impl.BluetoothDeviceSerializer;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class BluetoothInformationServiceReplyProxy
implements BluetoothInformationServiceReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.connectivity.bluetooth.BluetoothInformationService");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public BluetoothInformationServiceReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("0d9b5586-8f24-4a93-8c53-d5cdaef1e111", -1, "4a7a95f3-5ac7-5d3b-b84d-85008994e7bf", "asi.connectivity.bluetooth.BluetoothInformationService");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void updateBluetoothState(final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)2, iSerializable);
    }

    public void updateBluetoothDevices(final BluetoothDevice[] bluetoothDeviceArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                BluetoothDeviceSerializer.putOptionalBluetoothDeviceVarArray(iSerializer, bluetoothDeviceArray);
            }
        };
        this.proxy.remoteCallMethod((short)1, iSerializable);
    }
}

