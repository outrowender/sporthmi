/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carkombi.BCSpeedWarningSettings;

public class BCSpeedWarningSettingsSerializer {
    public static void putOptionalBCSpeedWarningSettings(ISerializer iSerializer, BCSpeedWarningSettings bCSpeedWarningSettings) throws SerializerException {
        boolean bl = bCSpeedWarningSettings == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = bCSpeedWarningSettings.isState();
            iSerializer.putBool(bl2);
            int n = bCSpeedWarningSettings.getSpeedValue();
            iSerializer.putInt32(n);
            int n2 = bCSpeedWarningSettings.getSpeedUnit();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalBCSpeedWarningSettingsVarArray(ISerializer iSerializer, BCSpeedWarningSettings[] bCSpeedWarningSettingsArray) throws SerializerException {
        boolean bl = bCSpeedWarningSettingsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCSpeedWarningSettingsArray.length);
            for (int i2 = 0; i2 < bCSpeedWarningSettingsArray.length; ++i2) {
                BCSpeedWarningSettingsSerializer.putOptionalBCSpeedWarningSettings(iSerializer, bCSpeedWarningSettingsArray[i2]);
            }
        }
    }

    public static BCSpeedWarningSettings getOptionalBCSpeedWarningSettings(IDeserializer iDeserializer) throws SerializerException {
        BCSpeedWarningSettings bCSpeedWarningSettings = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            boolean bl2;
            bCSpeedWarningSettings = new BCSpeedWarningSettings();
            bCSpeedWarningSettings.state = bl2 = iDeserializer.getBool();
            bCSpeedWarningSettings.speedValue = n2 = iDeserializer.getInt32();
            bCSpeedWarningSettings.speedUnit = n = iDeserializer.getInt32();
        }
        return bCSpeedWarningSettings;
    }

    public static BCSpeedWarningSettings[] getOptionalBCSpeedWarningSettingsVarArray(IDeserializer iDeserializer) throws SerializerException {
        BCSpeedWarningSettings[] bCSpeedWarningSettingsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCSpeedWarningSettingsArray = new BCSpeedWarningSettings[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCSpeedWarningSettingsArray[i2] = BCSpeedWarningSettingsSerializer.getOptionalBCSpeedWarningSettings(iDeserializer);
            }
        }
        return bCSpeedWarningSettingsArray;
    }
}

