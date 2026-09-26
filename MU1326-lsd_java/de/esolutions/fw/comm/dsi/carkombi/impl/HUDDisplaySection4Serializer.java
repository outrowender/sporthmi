/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.HUDDisplaySection4;

public class HUDDisplaySection4Serializer {
    public static void putOptionalHUDDisplaySection4(ISerializer iSerializer, HUDDisplaySection4 hUDDisplaySection4) {
        boolean bl = hUDDisplaySection4 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = hUDDisplaySection4.isCompass();
            iSerializer.putBool(bl2);
            boolean bl3 = hUDDisplaySection4.isNightvision();
            iSerializer.putBool(bl3);
            boolean bl4 = hUDDisplaySection4.isWarnings();
            iSerializer.putBool(bl4);
            boolean bl5 = hUDDisplaySection4.isRevolution();
            iSerializer.putBool(bl5);
        }
    }

    public static void putOptionalHUDDisplaySection4VarArray(ISerializer iSerializer, HUDDisplaySection4[] hUDDisplaySection4Array) {
        boolean bl = hUDDisplaySection4Array == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(hUDDisplaySection4Array.length);
            for (int i2 = 0; i2 < hUDDisplaySection4Array.length; ++i2) {
                HUDDisplaySection4Serializer.putOptionalHUDDisplaySection4(iSerializer, hUDDisplaySection4Array[i2]);
            }
        }
    }

    public static HUDDisplaySection4 getOptionalHUDDisplaySection4(IDeserializer iDeserializer) {
        HUDDisplaySection4 hUDDisplaySection4 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            hUDDisplaySection4 = new HUDDisplaySection4();
            hUDDisplaySection4.compass = bl5 = iDeserializer.getBool();
            hUDDisplaySection4.nightvision = bl4 = iDeserializer.getBool();
            hUDDisplaySection4.warnings = bl3 = iDeserializer.getBool();
            hUDDisplaySection4.revolution = bl2 = iDeserializer.getBool();
        }
        return hUDDisplaySection4;
    }

    public static HUDDisplaySection4[] getOptionalHUDDisplaySection4VarArray(IDeserializer iDeserializer) {
        HUDDisplaySection4[] hUDDisplaySection4Array = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            hUDDisplaySection4Array = new HUDDisplaySection4[n];
            for (int i2 = 0; i2 < n; ++i2) {
                hUDDisplaySection4Array[i2] = HUDDisplaySection4Serializer.getOptionalHUDDisplaySection4(iDeserializer);
            }
        }
        return hUDDisplaySection4Array;
    }
}

