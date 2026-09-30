/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.carkombi.impl.HUDConfigurationSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carkombi.HUDConfiguration;
import org.dsi.ifc.carkombi.HUDViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class HUDViewOptionsSerializer {
    public static void putOptionalHUDViewOptions(ISerializer iSerializer, HUDViewOptions hUDViewOptions) throws SerializerException {
        boolean bl = hUDViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = hUDViewOptions.getHeightAdjustment();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = hUDViewOptions.getBrightness();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = hUDViewOptions.getContent();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = hUDViewOptions.getRotationAdjustment();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = hUDViewOptions.getColour();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = hUDViewOptions.getSetFactoryDefault();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            CarViewOption carViewOption7 = hUDViewOptions.getSystemOnOff();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
            HUDConfiguration hUDConfiguration = hUDViewOptions.getConfiguration();
            HUDConfigurationSerializer.putOptionalHUDConfiguration(iSerializer, hUDConfiguration);
            CarViewOption carViewOption8 = hUDViewOptions.getLicense();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption8);
            CarViewOption carViewOption9 = hUDViewOptions.getPresets();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption9);
            CarViewOption carViewOption10 = hUDViewOptions.getSectionConfigList();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption10);
            CarViewOption carViewOption11 = hUDViewOptions.getCollectiveTopicsACC();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption11);
            CarViewOption carViewOption12 = hUDViewOptions.getCollectiveTopicsNightvision();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption12);
            CarViewOption carViewOption13 = hUDViewOptions.getCollectiveTopicsRSD();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption13);
            CarViewOption carViewOption14 = hUDViewOptions.getCollectiveTopicsRGI();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption14);
            CarViewOption carViewOption15 = hUDViewOptions.getCollectiveTopicsHCA();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption15);
            CarViewOption carViewOption16 = hUDViewOptions.getCollectiveTopicsGRA();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption16);
            CarViewOption carViewOption17 = hUDViewOptions.getCollectiveTopicsEfficiencyAssist();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption17);
            CarViewOption carViewOption18 = hUDViewOptions.getCollectiveTopicsSpeedLimiter();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption18);
            CarViewOption carViewOption19 = hUDViewOptions.getCollectiveTopicsNavInfo();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption19);
            CarViewOption carViewOption20 = hUDViewOptions.getAutoSkinSwitch();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption20);
        }
    }

    public static void putOptionalHUDViewOptionsVarArray(ISerializer iSerializer, HUDViewOptions[] hUDViewOptionsArray) throws SerializerException {
        boolean bl = hUDViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(hUDViewOptionsArray.length);
            for (int i2 = 0; i2 < hUDViewOptionsArray.length; ++i2) {
                HUDViewOptionsSerializer.putOptionalHUDViewOptions(iSerializer, hUDViewOptionsArray[i2]);
            }
        }
    }

    public static HUDViewOptions getOptionalHUDViewOptions(IDeserializer iDeserializer) throws SerializerException {
        HUDViewOptions hUDViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            CarViewOption carViewOption3;
            CarViewOption carViewOption4;
            CarViewOption carViewOption5;
            CarViewOption carViewOption6;
            CarViewOption carViewOption7;
            CarViewOption carViewOption8;
            CarViewOption carViewOption9;
            CarViewOption carViewOption10;
            CarViewOption carViewOption11;
            CarViewOption carViewOption12;
            CarViewOption carViewOption13;
            HUDConfiguration hUDConfiguration;
            CarViewOption carViewOption14;
            CarViewOption carViewOption15;
            CarViewOption carViewOption16;
            CarViewOption carViewOption17;
            CarViewOption carViewOption18;
            CarViewOption carViewOption19;
            CarViewOption carViewOption20;
            hUDViewOptions = new HUDViewOptions();
            hUDViewOptions.heightAdjustment = carViewOption20 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            hUDViewOptions.brightness = carViewOption19 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            hUDViewOptions.content = carViewOption18 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            hUDViewOptions.rotationAdjustment = carViewOption17 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            hUDViewOptions.colour = carViewOption16 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            hUDViewOptions.setFactoryDefault = carViewOption15 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            hUDViewOptions.systemOnOff = carViewOption14 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            hUDViewOptions.configuration = hUDConfiguration = HUDConfigurationSerializer.getOptionalHUDConfiguration(iDeserializer);
            hUDViewOptions.license = carViewOption13 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            hUDViewOptions.presets = carViewOption12 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            hUDViewOptions.sectionConfigList = carViewOption11 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            hUDViewOptions.collectiveTopicsACC = carViewOption10 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            hUDViewOptions.collectiveTopicsNightvision = carViewOption9 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            hUDViewOptions.collectiveTopicsRSD = carViewOption8 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            hUDViewOptions.collectiveTopicsRGI = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            hUDViewOptions.collectiveTopicsHCA = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            hUDViewOptions.collectiveTopicsGRA = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            hUDViewOptions.collectiveTopicsEfficiencyAssist = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            hUDViewOptions.collectiveTopicsSpeedLimiter = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            hUDViewOptions.collectiveTopicsNavInfo = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            hUDViewOptions.autoSkinSwitch = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
        }
        return hUDViewOptions;
    }

    public static HUDViewOptions[] getOptionalHUDViewOptionsVarArray(IDeserializer iDeserializer) throws SerializerException {
        HUDViewOptions[] hUDViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            hUDViewOptionsArray = new HUDViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                hUDViewOptionsArray[i2] = HUDViewOptionsSerializer.getOptionalHUDViewOptions(iDeserializer);
            }
        }
        return hUDViewOptionsArray;
    }
}

