/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sClientResponseErrorSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sRoutineResponseSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sRoutineResponse;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2TelephoneDiagService;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2TelephoneDiagServiceC;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2TelephoneDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2TelephoneDiagServiceReplyService;
import de.esolutions.fw.comm.asi.diagnosis.telephone.impl.sConnectedBtHandsetSerializer;
import de.esolutions.fw.comm.asi.diagnosis.telephone.impl.sNadIMEISerializer;
import de.esolutions.fw.comm.asi.diagnosis.telephone.impl.sNumberHandsetsHUCsSerializer;
import de.esolutions.fw.comm.asi.diagnosis.telephone.impl.sSimStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.telephone.impl.sTelephoneAntennaStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.telephone.impl.sTelephoneNetworkStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.telephone.impl.sTelephoneTemperatureSerializer;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sConnectedBtHandset;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sNadIMEI;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sNumberHandsetsHUCs;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sSimState;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sTelephoneAntennaState;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sTelephoneNetworkState;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sTelephoneTemperature;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2TelephoneDiagServiceProxy
implements MMX2TelephoneDiagService,
MMX2TelephoneDiagServiceC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2TelephoneDiagService");
    private Proxy proxy;

    public MMX2TelephoneDiagServiceProxy(int n, MMX2TelephoneDiagServiceReply mMX2TelephoneDiagServiceReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("1875f7e5-0255-4283-8265-93dd91cd564d", n, "18c56909-7a93-5017-a939-9202333ba69e", "asi.diagnosis.mmx2app.MMX2TelephoneDiagService");
        MMX2TelephoneDiagServiceReplyService mMX2TelephoneDiagServiceReplyService = new MMX2TelephoneDiagServiceReplyService(mMX2TelephoneDiagServiceReply);
        this.proxy = new Proxy(serviceInstanceID, mMX2TelephoneDiagServiceReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void responseErrorTelephone(final sClientResponseError sClientResponseError2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sClientResponseErrorSerializer.putOptionalsClientResponseError(iSerializer, sClientResponseError2);
            }
        };
        this.proxy.remoteCallMethod((short)43, iSerializable);
    }

    public void responseSimState(final sSimState sSimState2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sSimStateSerializer.putOptionalsSimState(iSerializer, sSimState2);
            }
        };
        this.proxy.remoteCallMethod((short)42, iSerializable);
    }

    public void responseNadIMEI(final sNadIMEI sNadIMEI2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sNadIMEISerializer.putOptionalsNadIMEI(iSerializer, sNadIMEI2);
            }
        };
        this.proxy.remoteCallMethod((short)10, iSerializable);
    }

    public void responseTelephoneAntennaState(final sTelephoneAntennaState sTelephoneAntennaState2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sTelephoneAntennaStateSerializer.putOptionalsTelephoneAntennaState(iSerializer, sTelephoneAntennaState2);
            }
        };
        this.proxy.remoteCallMethod((short)31, iSerializable);
    }

    public void responseConnectedBtHandset(final sConnectedBtHandset sConnectedBtHandset2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sConnectedBtHandsetSerializer.putOptionalsConnectedBtHandset(iSerializer, sConnectedBtHandset2);
            }
        };
        this.proxy.remoteCallMethod((short)7, iSerializable);
    }

    public void responseNumberHandsetsHUCs(final sNumberHandsetsHUCs sNumberHandsetsHUCs2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sNumberHandsetsHUCsSerializer.putOptionalsNumberHandsetsHUCs(iSerializer, sNumberHandsetsHUCs2);
            }
        };
        this.proxy.remoteCallMethod((short)11, iSerializable);
    }

    public void responseTelephoneNetworkState(final sTelephoneNetworkState sTelephoneNetworkState2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sTelephoneNetworkStateSerializer.putOptionalsTelephoneNetworkState(iSerializer, sTelephoneNetworkState2);
            }
        };
        this.proxy.remoteCallMethod((short)29, iSerializable);
    }

    public void responseTelephoneTemperature(final sTelephoneTemperature sTelephoneTemperature2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sTelephoneTemperatureSerializer.putOptionalsTelephoneTemperature(iSerializer, sTelephoneTemperature2);
            }
        };
        this.proxy.remoteCallMethod((short)27, iSerializable);
    }

    public void responseDeleteMemory(final sRoutineResponse sRoutineResponse2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sRoutineResponseSerializer.putOptionalsRoutineResponse(iSerializer, sRoutineResponse2);
            }
        };
        this.proxy.remoteCallMethod((short)25, iSerializable);
    }

    public void responseNetworkName(long l, String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)38, genericSerializable);
    }

    public void responseNetworkType(long l, int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
            genericSerializable.putEnum(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)39, genericSerializable);
    }

    public void responseDialNumber(long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)37, genericSerializable);
    }

    public void responseCallStatus(long l, boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)36, genericSerializable);
    }

    public void responseInternalSimIdentification(long l, String string, String string2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)41, genericSerializable);
    }
}

