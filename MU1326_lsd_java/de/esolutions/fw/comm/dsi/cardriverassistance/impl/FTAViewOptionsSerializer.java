/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardriverassistance.impl;

import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.cardriverassistance.FTAViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class FTAViewOptionsSerializer {
    public static void putOptionalFTAViewOptions(ISerializer iSerializer, FTAViewOptions fTAViewOptions) throws SerializerException {
        boolean bl = fTAViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = fTAViewOptions.getSystem();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
        }
    }

    public static void putOptionalFTAViewOptionsVarArray(ISerializer iSerializer, FTAViewOptions[] fTAViewOptionsArray) throws SerializerException {
        boolean bl = fTAViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(fTAViewOptionsArray.length);
            for (int i2 = 0; i2 < fTAViewOptionsArray.length; ++i2) {
                FTAViewOptionsSerializer.putOptionalFTAViewOptions(iSerializer, fTAViewOptionsArray[i2]);
            }
        }
    }

    public static FTAViewOptions getOptionalFTAViewOptions(IDeserializer iDeserializer) throws SerializerException {
        FTAViewOptions fTAViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarViewOption carViewOption;
            fTAViewOptions = new FTAViewOptions();
            fTAViewOptions.system = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
        }
        return fTAViewOptions;
    }

    public static FTAViewOptions[] getOptionalFTAViewOptionsVarArray(IDeserializer iDeserializer) throws SerializerException {
        FTAViewOptions[] fTAViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            fTAViewOptionsArray = new FTAViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                fTAViewOptionsArray[i2] = FTAViewOptionsSerializer.getOptionalFTAViewOptions(iDeserializer);
            }
        }
        return fTAViewOptionsArray;
    }
}

