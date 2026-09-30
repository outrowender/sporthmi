/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carcomfort.MascotConfiguration;

public class MascotConfigurationSerializer {
    public static void putOptionalMascotConfiguration(ISerializer iSerializer, MascotConfiguration mascotConfiguration) throws SerializerException {
        boolean bl = mascotConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = mascotConfiguration.isManualMode();
            iSerializer.putBool(bl2);
            boolean bl3 = mascotConfiguration.isOnIgnitionMode();
            iSerializer.putBool(bl3);
            boolean bl4 = mascotConfiguration.isOnLockMode();
            iSerializer.putBool(bl4);
        }
    }

    public static void putOptionalMascotConfigurationVarArray(ISerializer iSerializer, MascotConfiguration[] mascotConfigurationArray) throws SerializerException {
        boolean bl = mascotConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(mascotConfigurationArray.length);
            for (int i2 = 0; i2 < mascotConfigurationArray.length; ++i2) {
                MascotConfigurationSerializer.putOptionalMascotConfiguration(iSerializer, mascotConfigurationArray[i2]);
            }
        }
    }

    public static MascotConfiguration getOptionalMascotConfiguration(IDeserializer iDeserializer) throws SerializerException {
        MascotConfiguration mascotConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            mascotConfiguration = new MascotConfiguration();
            mascotConfiguration.manualMode = bl4 = iDeserializer.getBool();
            mascotConfiguration.onIgnitionMode = bl3 = iDeserializer.getBool();
            mascotConfiguration.onLockMode = bl2 = iDeserializer.getBool();
        }
        return mascotConfiguration;
    }

    public static MascotConfiguration[] getOptionalMascotConfigurationVarArray(IDeserializer iDeserializer) throws SerializerException {
        MascotConfiguration[] mascotConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            mascotConfigurationArray = new MascotConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                mascotConfigurationArray[i2] = MascotConfigurationSerializer.getOptionalMascotConfiguration(iDeserializer);
            }
        }
        return mascotConfigurationArray;
    }
}

