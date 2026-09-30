/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carparkingsystem.PDCContinueDrivingAssist;

public class PDCContinueDrivingAssistSerializer {
    public static void putOptionalPDCContinueDrivingAssist(ISerializer iSerializer, PDCContinueDrivingAssist pDCContinueDrivingAssist) throws SerializerException {
        boolean bl = pDCContinueDrivingAssist == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = pDCContinueDrivingAssist.isOffEarlyMediumLate();
            iSerializer.putBool(bl2);
        }
    }

    public static void putOptionalPDCContinueDrivingAssistVarArray(ISerializer iSerializer, PDCContinueDrivingAssist[] pDCContinueDrivingAssistArray) throws SerializerException {
        boolean bl = pDCContinueDrivingAssistArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(pDCContinueDrivingAssistArray.length);
            for (int i2 = 0; i2 < pDCContinueDrivingAssistArray.length; ++i2) {
                PDCContinueDrivingAssistSerializer.putOptionalPDCContinueDrivingAssist(iSerializer, pDCContinueDrivingAssistArray[i2]);
            }
        }
    }

    public static PDCContinueDrivingAssist getOptionalPDCContinueDrivingAssist(IDeserializer iDeserializer) throws SerializerException {
        PDCContinueDrivingAssist pDCContinueDrivingAssist = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            pDCContinueDrivingAssist = new PDCContinueDrivingAssist();
            pDCContinueDrivingAssist.offEarlyMediumLate = bl2 = iDeserializer.getBool();
        }
        return pDCContinueDrivingAssist;
    }

    public static PDCContinueDrivingAssist[] getOptionalPDCContinueDrivingAssistVarArray(IDeserializer iDeserializer) throws SerializerException {
        PDCContinueDrivingAssist[] pDCContinueDrivingAssistArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            pDCContinueDrivingAssistArray = new PDCContinueDrivingAssist[n];
            for (int i2 = 0; i2 < n; ++i2) {
                pDCContinueDrivingAssistArray[i2] = PDCContinueDrivingAssistSerializer.getOptionalPDCContinueDrivingAssist(iDeserializer);
            }
        }
        return pDCContinueDrivingAssistArray;
    }
}

