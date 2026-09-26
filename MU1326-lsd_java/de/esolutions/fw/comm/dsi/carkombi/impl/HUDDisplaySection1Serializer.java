/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.HUDDisplaySection1;

public class HUDDisplaySection1Serializer {
    public static void putOptionalHUDDisplaySection1(ISerializer iSerializer, HUDDisplaySection1 hUDDisplaySection1) {
        boolean bl = hUDDisplaySection1 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = hUDDisplaySection1.isSpeed();
            iSerializer.putBool(bl2);
            boolean bl3 = hUDDisplaySection1.isFasStatusIcon();
            iSerializer.putBool(bl3);
            boolean bl4 = hUDDisplaySection1.isFasScreen();
            iSerializer.putBool(bl4);
            boolean bl5 = hUDDisplaySection1.isTrafficSign();
            iSerializer.putBool(bl5);
            boolean bl6 = hUDDisplaySection1.isNavigation();
            iSerializer.putBool(bl6);
            boolean bl7 = hUDDisplaySection1.isAdditionalNavigation();
            iSerializer.putBool(bl7);
            boolean bl8 = hUDDisplaySection1.isGForce();
            iSerializer.putBool(bl8);
            boolean bl9 = hUDDisplaySection1.isGearIndication();
            iSerializer.putBool(bl9);
        }
    }

    public static void putOptionalHUDDisplaySection1VarArray(ISerializer iSerializer, HUDDisplaySection1[] hUDDisplaySection1Array) {
        boolean bl = hUDDisplaySection1Array == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(hUDDisplaySection1Array.length);
            for (int i2 = 0; i2 < hUDDisplaySection1Array.length; ++i2) {
                HUDDisplaySection1Serializer.putOptionalHUDDisplaySection1(iSerializer, hUDDisplaySection1Array[i2]);
            }
        }
    }

    public static HUDDisplaySection1 getOptionalHUDDisplaySection1(IDeserializer iDeserializer) {
        HUDDisplaySection1 hUDDisplaySection1 = null;
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
            hUDDisplaySection1 = new HUDDisplaySection1();
            hUDDisplaySection1.speed = bl9 = iDeserializer.getBool();
            hUDDisplaySection1.fasStatusIcon = bl8 = iDeserializer.getBool();
            hUDDisplaySection1.fasScreen = bl7 = iDeserializer.getBool();
            hUDDisplaySection1.trafficSign = bl6 = iDeserializer.getBool();
            hUDDisplaySection1.navigation = bl5 = iDeserializer.getBool();
            hUDDisplaySection1.additionalNavigation = bl4 = iDeserializer.getBool();
            hUDDisplaySection1.gForce = bl3 = iDeserializer.getBool();
            hUDDisplaySection1.gearIndication = bl2 = iDeserializer.getBool();
        }
        return hUDDisplaySection1;
    }

    public static HUDDisplaySection1[] getOptionalHUDDisplaySection1VarArray(IDeserializer iDeserializer) {
        HUDDisplaySection1[] hUDDisplaySection1Array = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            hUDDisplaySection1Array = new HUDDisplaySection1[n];
            for (int i2 = 0; i2 < n; ++i2) {
                hUDDisplaySection1Array[i2] = HUDDisplaySection1Serializer.getOptionalHUDDisplaySection1(iDeserializer);
            }
        }
        return hUDDisplaySection1Array;
    }
}

