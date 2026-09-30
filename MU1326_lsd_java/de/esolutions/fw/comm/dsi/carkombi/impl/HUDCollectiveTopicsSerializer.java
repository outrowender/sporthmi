/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carkombi.HUDCollectiveTopics;

public class HUDCollectiveTopicsSerializer {
    public static void putOptionalHUDCollectiveTopics(ISerializer iSerializer, HUDCollectiveTopics hUDCollectiveTopics) throws SerializerException {
        boolean bl = hUDCollectiveTopics == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = hUDCollectiveTopics.getAcc();
            iSerializer.putInt32(n);
            int n2 = hUDCollectiveTopics.getNightvision();
            iSerializer.putInt32(n2);
            int n3 = hUDCollectiveTopics.getRoadsign();
            iSerializer.putInt32(n3);
            int n4 = hUDCollectiveTopics.getRgi();
            iSerializer.putInt32(n4);
            int n5 = hUDCollectiveTopics.getHca();
            iSerializer.putInt32(n5);
            int n6 = hUDCollectiveTopics.getGra();
            iSerializer.putInt32(n6);
            int n7 = hUDCollectiveTopics.getEfficiencyAssist();
            iSerializer.putInt32(n7);
            int n8 = hUDCollectiveTopics.getSpeedLimiter();
            iSerializer.putInt32(n8);
            int n9 = hUDCollectiveTopics.getNavInfoInHUD();
            iSerializer.putInt32(n9);
        }
    }

    public static void putOptionalHUDCollectiveTopicsVarArray(ISerializer iSerializer, HUDCollectiveTopics[] hUDCollectiveTopicsArray) throws SerializerException {
        boolean bl = hUDCollectiveTopicsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(hUDCollectiveTopicsArray.length);
            for (int i2 = 0; i2 < hUDCollectiveTopicsArray.length; ++i2) {
                HUDCollectiveTopicsSerializer.putOptionalHUDCollectiveTopics(iSerializer, hUDCollectiveTopicsArray[i2]);
            }
        }
    }

    public static HUDCollectiveTopics getOptionalHUDCollectiveTopics(IDeserializer iDeserializer) throws SerializerException {
        HUDCollectiveTopics hUDCollectiveTopics = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            hUDCollectiveTopics = new HUDCollectiveTopics();
            hUDCollectiveTopics.acc = n9 = iDeserializer.getInt32();
            hUDCollectiveTopics.nightvision = n8 = iDeserializer.getInt32();
            hUDCollectiveTopics.roadsign = n7 = iDeserializer.getInt32();
            hUDCollectiveTopics.rgi = n6 = iDeserializer.getInt32();
            hUDCollectiveTopics.hca = n5 = iDeserializer.getInt32();
            hUDCollectiveTopics.gra = n4 = iDeserializer.getInt32();
            hUDCollectiveTopics.efficiencyAssist = n3 = iDeserializer.getInt32();
            hUDCollectiveTopics.speedLimiter = n2 = iDeserializer.getInt32();
            hUDCollectiveTopics.navInfoInHUD = n = iDeserializer.getInt32();
        }
        return hUDCollectiveTopics;
    }

    public static HUDCollectiveTopics[] getOptionalHUDCollectiveTopicsVarArray(IDeserializer iDeserializer) throws SerializerException {
        HUDCollectiveTopics[] hUDCollectiveTopicsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            hUDCollectiveTopicsArray = new HUDCollectiveTopics[n];
            for (int i2 = 0; i2 < n; ++i2) {
                hUDCollectiveTopicsArray[i2] = HUDCollectiveTopicsSerializer.getOptionalHUDCollectiveTopics(iDeserializer);
            }
        }
        return hUDCollectiveTopicsArray;
    }
}

