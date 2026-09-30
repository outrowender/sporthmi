/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carparkingsystem.PDCSteeringInformation;

public class PDCSteeringInformationSerializer {
    public static void putOptionalPDCSteeringInformation(ISerializer iSerializer, PDCSteeringInformation pDCSteeringInformation) throws SerializerException {
        boolean bl = pDCSteeringInformation == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = pDCSteeringInformation.isAdditionalInfo();
            iSerializer.putBool(bl2);
            int n = pDCSteeringInformation.getTrackDisplay();
            iSerializer.putInt32(n);
            boolean bl3 = pDCSteeringInformation.isDirection();
            iSerializer.putBool(bl3);
            int n2 = pDCSteeringInformation.getRadiusRearWheel();
            iSerializer.putInt32(n2);
            int n3 = pDCSteeringInformation.getRadiusFrontWheel();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalPDCSteeringInformationVarArray(ISerializer iSerializer, PDCSteeringInformation[] pDCSteeringInformationArray) throws SerializerException {
        boolean bl = pDCSteeringInformationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(pDCSteeringInformationArray.length);
            for (int i2 = 0; i2 < pDCSteeringInformationArray.length; ++i2) {
                PDCSteeringInformationSerializer.putOptionalPDCSteeringInformation(iSerializer, pDCSteeringInformationArray[i2]);
            }
        }
    }

    public static PDCSteeringInformation getOptionalPDCSteeringInformation(IDeserializer iDeserializer) throws SerializerException {
        PDCSteeringInformation pDCSteeringInformation = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            boolean bl2;
            int n3;
            boolean bl3;
            pDCSteeringInformation = new PDCSteeringInformation();
            pDCSteeringInformation.additionalInfo = bl3 = iDeserializer.getBool();
            pDCSteeringInformation.trackDisplay = n3 = iDeserializer.getInt32();
            pDCSteeringInformation.direction = bl2 = iDeserializer.getBool();
            pDCSteeringInformation.radiusRearWheel = n2 = iDeserializer.getInt32();
            pDCSteeringInformation.radiusFrontWheel = n = iDeserializer.getInt32();
        }
        return pDCSteeringInformation;
    }

    public static PDCSteeringInformation[] getOptionalPDCSteeringInformationVarArray(IDeserializer iDeserializer) throws SerializerException {
        PDCSteeringInformation[] pDCSteeringInformationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            pDCSteeringInformationArray = new PDCSteeringInformation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                pDCSteeringInformationArray[i2] = PDCSteeringInformationSerializer.getOptionalPDCSteeringInformation(iDeserializer);
            }
        }
        return pDCSteeringInformationArray;
    }
}

