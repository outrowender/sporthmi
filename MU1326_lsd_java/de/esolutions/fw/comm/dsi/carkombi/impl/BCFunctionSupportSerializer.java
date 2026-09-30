/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carkombi.BCFunctionSupport;

public class BCFunctionSupportSerializer {
    public static void putOptionalBCFunctionSupport(ISerializer iSerializer, BCFunctionSupport bCFunctionSupport) throws SerializerException {
        boolean bl = bCFunctionSupport == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = bCFunctionSupport.isResetTrip();
            iSerializer.putBool(bl2);
        }
    }

    public static void putOptionalBCFunctionSupportVarArray(ISerializer iSerializer, BCFunctionSupport[] bCFunctionSupportArray) throws SerializerException {
        boolean bl = bCFunctionSupportArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCFunctionSupportArray.length);
            for (int i2 = 0; i2 < bCFunctionSupportArray.length; ++i2) {
                BCFunctionSupportSerializer.putOptionalBCFunctionSupport(iSerializer, bCFunctionSupportArray[i2]);
            }
        }
    }

    public static BCFunctionSupport getOptionalBCFunctionSupport(IDeserializer iDeserializer) throws SerializerException {
        BCFunctionSupport bCFunctionSupport = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            bCFunctionSupport = new BCFunctionSupport();
            bCFunctionSupport.resetTrip = bl2 = iDeserializer.getBool();
        }
        return bCFunctionSupport;
    }

    public static BCFunctionSupport[] getOptionalBCFunctionSupportVarArray(IDeserializer iDeserializer) throws SerializerException {
        BCFunctionSupport[] bCFunctionSupportArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCFunctionSupportArray = new BCFunctionSupport[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCFunctionSupportArray[i2] = BCFunctionSupportSerializer.getOptionalBCFunctionSupport(iDeserializer);
            }
        }
        return bCFunctionSupportArray;
    }
}

