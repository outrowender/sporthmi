/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardriverassistance.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.cardriverassistance.AWVConfiguration;

public class AWVConfigurationSerializer {
    public static void putOptionalAWVConfiguration(ISerializer iSerializer, AWVConfiguration aWVConfiguration) throws SerializerException {
        boolean bl = aWVConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = aWVConfiguration.getSystemMode();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalAWVConfigurationVarArray(ISerializer iSerializer, AWVConfiguration[] aWVConfigurationArray) throws SerializerException {
        boolean bl = aWVConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(aWVConfigurationArray.length);
            for (int i2 = 0; i2 < aWVConfigurationArray.length; ++i2) {
                AWVConfigurationSerializer.putOptionalAWVConfiguration(iSerializer, aWVConfigurationArray[i2]);
            }
        }
    }

    public static AWVConfiguration getOptionalAWVConfiguration(IDeserializer iDeserializer) throws SerializerException {
        AWVConfiguration aWVConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            aWVConfiguration = new AWVConfiguration();
            aWVConfiguration.systemMode = n = iDeserializer.getInt32();
        }
        return aWVConfiguration;
    }

    public static AWVConfiguration[] getOptionalAWVConfigurationVarArray(IDeserializer iDeserializer) throws SerializerException {
        AWVConfiguration[] aWVConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            aWVConfigurationArray = new AWVConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                aWVConfigurationArray[i2] = AWVConfigurationSerializer.getOptionalAWVConfiguration(iDeserializer);
            }
        }
        return aWVConfigurationArray;
    }
}

