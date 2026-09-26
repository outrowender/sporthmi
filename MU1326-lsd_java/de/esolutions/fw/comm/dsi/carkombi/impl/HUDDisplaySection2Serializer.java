/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.HUDDisplaySection2;

public class HUDDisplaySection2Serializer {
    public static void putOptionalHUDDisplaySection2(ISerializer iSerializer, HUDDisplaySection2 hUDDisplaySection2) {
        boolean bl = hUDDisplaySection2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = hUDDisplaySection2.isShiftIndicator();
            iSerializer.putBool(bl2);
            boolean bl3 = hUDDisplaySection2.isTrackInfo();
            iSerializer.putBool(bl3);
            boolean bl4 = hUDDisplaySection2.isLapTimer();
            iSerializer.putBool(bl4);
            boolean bl5 = hUDDisplaySection2.isTemperature();
            iSerializer.putBool(bl5);
            boolean bl6 = hUDDisplaySection2.isTelephone();
            iSerializer.putBool(bl6);
            boolean bl7 = hUDDisplaySection2.isSds();
            iSerializer.putBool(bl7);
            boolean bl8 = hUDDisplaySection2.isTireAngle();
            iSerializer.putBool(bl8);
            boolean bl9 = hUDDisplaySection2.isPitchAngle();
            iSerializer.putBool(bl9);
        }
    }

    public static void putOptionalHUDDisplaySection2VarArray(ISerializer iSerializer, HUDDisplaySection2[] hUDDisplaySection2Array) {
        boolean bl = hUDDisplaySection2Array == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(hUDDisplaySection2Array.length);
            for (int i2 = 0; i2 < hUDDisplaySection2Array.length; ++i2) {
                HUDDisplaySection2Serializer.putOptionalHUDDisplaySection2(iSerializer, hUDDisplaySection2Array[i2]);
            }
        }
    }

    public static HUDDisplaySection2 getOptionalHUDDisplaySection2(IDeserializer iDeserializer) {
        HUDDisplaySection2 hUDDisplaySection2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            boolean bl8;
            boolean bl9;
            hUDDisplaySection2 = new HUDDisplaySection2();
            hUDDisplaySection2.shiftIndicator = bl9 = iDeserializer.getBool();
            hUDDisplaySection2.trackInfo = bl8 = iDeserializer.getBool();
            hUDDisplaySection2.lapTimer = bl7 = iDeserializer.getBool();
            hUDDisplaySection2.temperature = bl6 = iDeserializer.getBool();
            hUDDisplaySection2.telephone = bl5 = iDeserializer.getBool();
            hUDDisplaySection2.sds = bl4 = iDeserializer.getBool();
            hUDDisplaySection2.tireAngle = bl3 = iDeserializer.getBool();
            hUDDisplaySection2.pitchAngle = bl2 = iDeserializer.getBool();
        }
        return hUDDisplaySection2;
    }

    public static HUDDisplaySection2[] getOptionalHUDDisplaySection2VarArray(IDeserializer iDeserializer) {
        HUDDisplaySection2[] hUDDisplaySection2Array = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            hUDDisplaySection2Array = new HUDDisplaySection2[n];
            for (int i2 = 0; i2 < n; ++i2) {
                hUDDisplaySection2Array[i2] = HUDDisplaySection2Serializer.getOptionalHUDDisplaySection2(iDeserializer);
            }
        }
        return hUDDisplaySection2Array;
    }
}

