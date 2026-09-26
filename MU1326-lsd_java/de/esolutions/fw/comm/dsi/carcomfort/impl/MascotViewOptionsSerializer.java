/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.carcomfort.impl.MascotConfigurationSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.MascotConfiguration;
import org.dsi.ifc.carcomfort.MascotViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class MascotViewOptionsSerializer {
    public static void putOptionalMascotViewOptions(ISerializer iSerializer, MascotViewOptions mascotViewOptions) {
        boolean bl = mascotViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = mascotViewOptions.getMascotSetFactoryDefault();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = mascotViewOptions.getMascotControl();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = mascotViewOptions.getMascotMode();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            MascotConfiguration mascotConfiguration = mascotViewOptions.getConfiguration();
            MascotConfigurationSerializer.putOptionalMascotConfiguration(iSerializer, mascotConfiguration);
        }
    }

    public static void putOptionalMascotViewOptionsVarArray(ISerializer iSerializer, MascotViewOptions[] mascotViewOptionsArray) {
        boolean bl = mascotViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(mascotViewOptionsArray.length);
            for (int i2 = 0; i2 < mascotViewOptionsArray.length; ++i2) {
                MascotViewOptionsSerializer.putOptionalMascotViewOptions(iSerializer, mascotViewOptionsArray[i2]);
            }
        }
    }

    public static MascotViewOptions getOptionalMascotViewOptions(IDeserializer iDeserializer) {
        MascotViewOptions mascotViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            MascotConfiguration mascotConfiguration;
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            CarViewOption carViewOption3;
            mascotViewOptions = new MascotViewOptions();
            mascotViewOptions.mascotSetFactoryDefault = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            mascotViewOptions.mascotControl = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            mascotViewOptions.mascotMode = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            mascotViewOptions.configuration = mascotConfiguration = MascotConfigurationSerializer.getOptionalMascotConfiguration(iDeserializer);
        }
        return mascotViewOptions;
    }

    public static MascotViewOptions[] getOptionalMascotViewOptionsVarArray(IDeserializer iDeserializer) {
        MascotViewOptions[] mascotViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            mascotViewOptionsArray = new MascotViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                mascotViewOptionsArray[i2] = MascotViewOptionsSerializer.getOptionalMascotViewOptions(iDeserializer);
            }
        }
        return mascotViewOptionsArray;
    }
}

