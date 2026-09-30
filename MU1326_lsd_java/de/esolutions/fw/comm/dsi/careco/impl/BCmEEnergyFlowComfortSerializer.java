/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.careco.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.careco.BCmEEnergyFlowComfort;

public class BCmEEnergyFlowComfortSerializer {
    public static void putOptionalBCmEEnergyFlowComfort(ISerializer iSerializer, BCmEEnergyFlowComfort bCmEEnergyFlowComfort) throws SerializerException {
        boolean bl = bCmEEnergyFlowComfort == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = bCmEEnergyFlowComfort.isClimateControlUnitHeater();
            iSerializer.putBool(bl2);
            boolean bl3 = bCmEEnergyFlowComfort.isAirConditionCompressor();
            iSerializer.putBool(bl3);
        }
    }

    public static void putOptionalBCmEEnergyFlowComfortVarArray(ISerializer iSerializer, BCmEEnergyFlowComfort[] bCmEEnergyFlowComfortArray) throws SerializerException {
        boolean bl = bCmEEnergyFlowComfortArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCmEEnergyFlowComfortArray.length);
            for (int i2 = 0; i2 < bCmEEnergyFlowComfortArray.length; ++i2) {
                BCmEEnergyFlowComfortSerializer.putOptionalBCmEEnergyFlowComfort(iSerializer, bCmEEnergyFlowComfortArray[i2]);
            }
        }
    }

    public static BCmEEnergyFlowComfort getOptionalBCmEEnergyFlowComfort(IDeserializer iDeserializer) throws SerializerException {
        BCmEEnergyFlowComfort bCmEEnergyFlowComfort = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            bCmEEnergyFlowComfort = new BCmEEnergyFlowComfort();
            bCmEEnergyFlowComfort.climateControlUnitHeater = bl3 = iDeserializer.getBool();
            bCmEEnergyFlowComfort.airConditionCompressor = bl2 = iDeserializer.getBool();
        }
        return bCmEEnergyFlowComfort;
    }

    public static BCmEEnergyFlowComfort[] getOptionalBCmEEnergyFlowComfortVarArray(IDeserializer iDeserializer) throws SerializerException {
        BCmEEnergyFlowComfort[] bCmEEnergyFlowComfortArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCmEEnergyFlowComfortArray = new BCmEEnergyFlowComfort[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCmEEnergyFlowComfortArray[i2] = BCmEEnergyFlowComfortSerializer.getOptionalBCmEEnergyFlowComfort(iDeserializer);
            }
        }
        return bCmEEnergyFlowComfortArray;
    }
}

