/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carplay.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carplay.CallState;

public class CallStateSerializer {
    public static void putOptionalCallState(ISerializer iSerializer, CallState callState) throws SerializerException {
        boolean bl = callState == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = callState.getPhoneNumber();
            iSerializer.putOptionalString(string);
            String string2 = callState.getCallerName();
            iSerializer.putOptionalString(string2);
            int n = callState.getStatus();
            iSerializer.putInt32(n);
            int n2 = callState.getDirection();
            iSerializer.putInt32(n2);
            String string3 = callState.getUniqueCallID();
            iSerializer.putOptionalString(string3);
        }
    }

    public static void putOptionalCallStateVarArray(ISerializer iSerializer, CallState[] callStateArray) throws SerializerException {
        boolean bl = callStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(callStateArray.length);
            for (int i2 = 0; i2 < callStateArray.length; ++i2) {
                CallStateSerializer.putOptionalCallState(iSerializer, callStateArray[i2]);
            }
        }
    }

    public static CallState getOptionalCallState(IDeserializer iDeserializer) throws SerializerException {
        CallState callState = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            int n2;
            String string2;
            String string3;
            callState = new CallState();
            callState.phoneNumber = string3 = iDeserializer.getOptionalString();
            callState.callerName = string2 = iDeserializer.getOptionalString();
            callState.status = n2 = iDeserializer.getInt32();
            callState.direction = n = iDeserializer.getInt32();
            callState.uniqueCallID = string = iDeserializer.getOptionalString();
        }
        return callState;
    }

    public static CallState[] getOptionalCallStateVarArray(IDeserializer iDeserializer) throws SerializerException {
        CallState[] callStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            callStateArray = new CallState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                callStateArray[i2] = CallStateSerializer.getOptionalCallState(iDeserializer);
            }
        }
        return callStateArray;
    }
}

