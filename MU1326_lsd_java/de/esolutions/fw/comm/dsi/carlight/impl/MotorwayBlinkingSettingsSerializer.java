/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlight.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carlight.MotorwayBlinkingSettings;

public class MotorwayBlinkingSettingsSerializer {
    public static void putOptionalMotorwayBlinkingSettings(ISerializer iSerializer, MotorwayBlinkingSettings motorwayBlinkingSettings) throws SerializerException {
        boolean bl = motorwayBlinkingSettings == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = motorwayBlinkingSettings.getTime();
            iSerializer.putInt32(n);
            boolean bl2 = motorwayBlinkingSettings.isState();
            iSerializer.putBool(bl2);
        }
    }

    public static void putOptionalMotorwayBlinkingSettingsVarArray(ISerializer iSerializer, MotorwayBlinkingSettings[] motorwayBlinkingSettingsArray) throws SerializerException {
        boolean bl = motorwayBlinkingSettingsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(motorwayBlinkingSettingsArray.length);
            for (int i2 = 0; i2 < motorwayBlinkingSettingsArray.length; ++i2) {
                MotorwayBlinkingSettingsSerializer.putOptionalMotorwayBlinkingSettings(iSerializer, motorwayBlinkingSettingsArray[i2]);
            }
        }
    }

    public static MotorwayBlinkingSettings getOptionalMotorwayBlinkingSettings(IDeserializer iDeserializer) throws SerializerException {
        MotorwayBlinkingSettings motorwayBlinkingSettings = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            int n;
            motorwayBlinkingSettings = new MotorwayBlinkingSettings();
            motorwayBlinkingSettings.time = n = iDeserializer.getInt32();
            motorwayBlinkingSettings.state = bl2 = iDeserializer.getBool();
        }
        return motorwayBlinkingSettings;
    }

    public static MotorwayBlinkingSettings[] getOptionalMotorwayBlinkingSettingsVarArray(IDeserializer iDeserializer) throws SerializerException {
        MotorwayBlinkingSettings[] motorwayBlinkingSettingsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            motorwayBlinkingSettingsArray = new MotorwayBlinkingSettings[n];
            for (int i2 = 0; i2 < n; ++i2) {
                motorwayBlinkingSettingsArray[i2] = MotorwayBlinkingSettingsSerializer.getOptionalMotorwayBlinkingSettings(iDeserializer);
            }
        }
        return motorwayBlinkingSettingsArray;
    }
}

