/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sClientResponseErrorSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sRoutineResponseSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sRoutineResponse;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2OocDiagService;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2OocDiagServiceC;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2OocDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2OocDiagServiceReplyService;
import de.esolutions.fw.comm.asi.diagnosis.ooc.impl.sTemperatureMMXSerializer;
import de.esolutions.fw.comm.asi.diagnosis.ooc.sTemperatureMMX;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2OocDiagServiceProxy
implements MMX2OocDiagService,
MMX2OocDiagServiceC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2OocDiagService");
    private Proxy proxy;

    public MMX2OocDiagServiceProxy(int n, MMX2OocDiagServiceReply mMX2OocDiagServiceReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("09c63284-f374-4fbe-89ea-924e201190ad", n, "24561f40-b427-5b46-a327-ce4029a7b7b0", "asi.diagnosis.mmx2app.MMX2OocDiagService");
        MMX2OocDiagServiceReplyService mMX2OocDiagServiceReplyService = new MMX2OocDiagServiceReplyService(mMX2OocDiagServiceReply);
        this.proxy = new Proxy(serviceInstanceID, mMX2OocDiagServiceReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void responseErrorOoc(final sClientResponseError sClientResponseError2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sClientResponseErrorSerializer.putOptionalsClientResponseError(iSerializer, sClientResponseError2);
            }
        };
        this.proxy.remoteCallMethod((short)8, iSerializable);
    }

    public void responseTemperatureMMX(final sTemperatureMMX sTemperatureMMX2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sTemperatureMMXSerializer.putOptionalsTemperatureMMX(iSerializer, sTemperatureMMX2);
            }
        };
        this.proxy.remoteCallMethod((short)2, iSerializable);
    }

    public void responseDeleteMemory(final sRoutineResponse sRoutineResponse2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sRoutineResponseSerializer.putOptionalsRoutineResponse(iSerializer, sRoutineResponse2);
            }
        };
        this.proxy.remoteCallMethod((short)5, iSerializable);
    }
}

