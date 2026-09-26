/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.HUDDisplaySection3;

public class HUDDisplaySection3Serializer {
    public static void putOptionalHUDDisplaySection3(ISerializer iSerializer, HUDDisplaySection3 hUDDisplaySection3) {
        boolean bl = hUDDisplaySection3 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = hUDDisplaySection3.isRollAngle();
            iSerializer.putBool(bl2);
            boolean bl3 = hUDDisplaySection3.isHdc();
            iSerializer.putBool(bl3);
            boolean bl4 = hUDDisplaySection3.isSportResponse();
            iSerializer.putBool(bl4);
            boolean bl5 = hUDDisplaySection3.isBoostAssist();
            iSerializer.putBool(bl5);
            boolean bl6 = hUDDisplaySection3.isHeightIndication();
            iSerializer.putBool(bl6);
            boolean bl7 = hUDDisplaySection3.isJunctionAssistant();
            iSerializer.putBool(bl7);
            boolean bl8 = hUDDisplaySection3.isTrafficLightAssistant();
            iSerializer.putBool(bl8);
            boolean bl9 = hUDDisplaySection3.isCurveAssistant();
            iSerializer.putBool(bl9);
        }
    }

    public static void putOptionalHUDDisplaySection3VarArray(ISerializer iSerializer, HUDDisplaySection3[] hUDDisplaySection3Array) {
        boolean bl = hUDDisplaySection3Array == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(hUDDisplaySection3Array.length);
            for (int i2 = 0; i2 < hUDDisplaySection3Array.length; ++i2) {
                HUDDisplaySection3Serializer.putOptionalHUDDisplaySection3(iSerializer, hUDDisplaySection3Array[i2]);
            }
        }
    }

    public static HUDDisplaySection3 getOptionalHUDDisplaySection3(IDeserializer iDeserializer) {
        HUDDisplaySection3 hUDDisplaySection3 = null;
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
            hUDDisplaySection3 = new HUDDisplaySection3();
            hUDDisplaySection3.rollAngle = bl9 = iDeserializer.getBool();
            hUDDisplaySection3.hdc = bl8 = iDeserializer.getBool();
            hUDDisplaySection3.sportResponse = bl7 = iDeserializer.getBool();
            hUDDisplaySection3.boostAssist = bl6 = iDeserializer.getBool();
            hUDDisplaySection3.heightIndication = bl5 = iDeserializer.getBool();
            hUDDisplaySection3.junctionAssistant = bl4 = iDeserializer.getBool();
            hUDDisplaySection3.trafficLightAssistant = bl3 = iDeserializer.getBool();
            hUDDisplaySection3.curveAssistant = bl2 = iDeserializer.getBool();
        }
        return hUDDisplaySection3;
    }

    public static HUDDisplaySection3[] getOptionalHUDDisplaySection3VarArray(IDeserializer iDeserializer) {
        HUDDisplaySection3[] hUDDisplaySection3Array = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            hUDDisplaySection3Array = new HUDDisplaySection3[n];
            for (int i2 = 0; i2 < n; ++i2) {
                hUDDisplaySection3Array[i2] = HUDDisplaySection3Serializer.getOptionalHUDDisplaySection3(iDeserializer);
            }
        }
        return hUDDisplaySection3Array;
    }
}

