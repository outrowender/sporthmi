/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.global.impl.CarArrayListTransmittableElementsSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.HUDConfiguration;
import org.dsi.ifc.global.CarArrayListTransmittableElements;

public class HUDConfigurationSerializer {
    public static void putOptionalHUDConfiguration(ISerializer iSerializer, HUDConfiguration hUDConfiguration) {
        boolean bl = hUDConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = hUDConfiguration.isSpeed();
            iSerializer.putBool(bl2);
            boolean bl3 = hUDConfiguration.isWarning();
            iSerializer.putBool(bl3);
            boolean bl4 = hUDConfiguration.isGra();
            iSerializer.putBool(bl4);
            boolean bl5 = hUDConfiguration.isNightvision();
            iSerializer.putBool(bl5);
            boolean bl6 = hUDConfiguration.isRoadsign();
            iSerializer.putBool(bl6);
            boolean bl7 = hUDConfiguration.isRgi();
            iSerializer.putBool(bl7);
            boolean bl8 = hUDConfiguration.isNavInfo();
            iSerializer.putBool(bl8);
            boolean bl9 = hUDConfiguration.isInfoList();
            iSerializer.putBool(bl9);
            boolean bl10 = hUDConfiguration.isHca();
            iSerializer.putBool(bl10);
            boolean bl11 = hUDConfiguration.isAcc();
            iSerializer.putBool(bl11);
            boolean bl12 = hUDConfiguration.isTelephone();
            iSerializer.putBool(bl12);
            boolean bl13 = hUDConfiguration.isEfficiencyAssist();
            iSerializer.putBool(bl13);
            boolean bl14 = hUDConfiguration.isSpeedLimiter();
            iSerializer.putBool(bl14);
            boolean bl15 = hUDConfiguration.isSds();
            iSerializer.putBool(bl15);
            boolean bl16 = hUDConfiguration.isColourDesignAuto();
            iSerializer.putBool(bl16);
            boolean bl17 = hUDConfiguration.isColourDesignDay();
            iSerializer.putBool(bl17);
            boolean bl18 = hUDConfiguration.isColourDesignNight();
            iSerializer.putBool(bl18);
            boolean bl19 = hUDConfiguration.isColourDefault();
            iSerializer.putBool(bl19);
            boolean bl20 = hUDConfiguration.isColourAlternative();
            iSerializer.putBool(bl20);
            boolean bl21 = hUDConfiguration.isPresetNone();
            iSerializer.putBool(bl21);
            boolean bl22 = hUDConfiguration.isPresetAssistance();
            iSerializer.putBool(bl22);
            boolean bl23 = hUDConfiguration.isPresetNavigation();
            iSerializer.putBool(bl23);
            boolean bl24 = hUDConfiguration.isPresetSportChrono();
            iSerializer.putBool(bl24);
            boolean bl25 = hUDConfiguration.isPresetOffroad();
            iSerializer.putBool(bl25);
            boolean bl26 = hUDConfiguration.isPresetPHEV();
            iSerializer.putBool(bl26);
            boolean bl27 = hUDConfiguration.isPresetIndividual();
            iSerializer.putBool(bl27);
            boolean bl28 = hUDConfiguration.isDisplaySection1();
            iSerializer.putBool(bl28);
            boolean bl29 = hUDConfiguration.isDisplaySection2();
            iSerializer.putBool(bl29);
            boolean bl30 = hUDConfiguration.isDisplaySection3();
            iSerializer.putBool(bl30);
            boolean bl31 = hUDConfiguration.isDisplaySection4();
            iSerializer.putBool(bl31);
            boolean bl32 = hUDConfiguration.isDisplaySection5();
            iSerializer.putBool(bl32);
            boolean bl33 = hUDConfiguration.isDisplaySection6();
            iSerializer.putBool(bl33);
            boolean bl34 = hUDConfiguration.isDisplaySection7();
            iSerializer.putBool(bl34);
            boolean bl35 = hUDConfiguration.isDisplaySection8();
            iSerializer.putBool(bl35);
            boolean bl36 = hUDConfiguration.isDriverAssistance();
            iSerializer.putBool(bl36);
            CarArrayListTransmittableElements carArrayListTransmittableElements = hUDConfiguration.getSectionConfigListTransmittableElements();
            CarArrayListTransmittableElementsSerializer.putOptionalCarArrayListTransmittableElements(iSerializer, carArrayListTransmittableElements);
            int[] nArray = hUDConfiguration.getSectionConfigListRAConfig();
            iSerializer.putOptionalInt32VarArray(nArray);
        }
    }

    public static void putOptionalHUDConfigurationVarArray(ISerializer iSerializer, HUDConfiguration[] hUDConfigurationArray) {
        boolean bl = hUDConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(hUDConfigurationArray.length);
            for (int i2 = 0; i2 < hUDConfigurationArray.length; ++i2) {
                HUDConfigurationSerializer.putOptionalHUDConfiguration(iSerializer, hUDConfigurationArray[i2]);
            }
        }
    }

    public static HUDConfiguration getOptionalHUDConfiguration(IDeserializer iDeserializer) {
        HUDConfiguration hUDConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarArrayListTransmittableElements carArrayListTransmittableElements;
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            boolean bl8;
            boolean bl9;
            boolean bl10;
            boolean bl11;
            boolean bl12;
            boolean bl13;
            boolean bl14;
            boolean bl15;
            boolean bl16;
            boolean bl17;
            boolean bl18;
            boolean bl19;
            boolean bl20;
            boolean bl21;
            boolean bl22;
            boolean bl23;
            boolean bl24;
            boolean bl25;
            boolean bl26;
            boolean bl27;
            boolean bl28;
            boolean bl29;
            boolean bl30;
            boolean bl31;
            boolean bl32;
            boolean bl33;
            boolean bl34;
            boolean bl35;
            boolean bl36;
            hUDConfiguration = new HUDConfiguration();
            hUDConfiguration.speed = bl36 = iDeserializer.getBool();
            hUDConfiguration.warning = bl35 = iDeserializer.getBool();
            hUDConfiguration.gra = bl34 = iDeserializer.getBool();
            hUDConfiguration.nightvision = bl33 = iDeserializer.getBool();
            hUDConfiguration.roadsign = bl32 = iDeserializer.getBool();
            hUDConfiguration.rgi = bl31 = iDeserializer.getBool();
            hUDConfiguration.navInfo = bl30 = iDeserializer.getBool();
            hUDConfiguration.infoList = bl29 = iDeserializer.getBool();
            hUDConfiguration.hca = bl28 = iDeserializer.getBool();
            hUDConfiguration.acc = bl27 = iDeserializer.getBool();
            hUDConfiguration.telephone = bl26 = iDeserializer.getBool();
            hUDConfiguration.efficiencyAssist = bl25 = iDeserializer.getBool();
            hUDConfiguration.speedLimiter = bl24 = iDeserializer.getBool();
            hUDConfiguration.sds = bl23 = iDeserializer.getBool();
            hUDConfiguration.colourDesignAuto = bl22 = iDeserializer.getBool();
            hUDConfiguration.colourDesignDay = bl21 = iDeserializer.getBool();
            hUDConfiguration.colourDesignNight = bl20 = iDeserializer.getBool();
            hUDConfiguration.colourDefault = bl19 = iDeserializer.getBool();
            hUDConfiguration.colourAlternative = bl18 = iDeserializer.getBool();
            hUDConfiguration.presetNone = bl17 = iDeserializer.getBool();
            hUDConfiguration.presetAssistance = bl16 = iDeserializer.getBool();
            hUDConfiguration.presetNavigation = bl15 = iDeserializer.getBool();
            hUDConfiguration.presetSportChrono = bl14 = iDeserializer.getBool();
            hUDConfiguration.presetOffroad = bl13 = iDeserializer.getBool();
            hUDConfiguration.presetPHEV = bl12 = iDeserializer.getBool();
            hUDConfiguration.presetIndividual = bl11 = iDeserializer.getBool();
            hUDConfiguration.displaySection1 = bl10 = iDeserializer.getBool();
            hUDConfiguration.displaySection2 = bl9 = iDeserializer.getBool();
            hUDConfiguration.displaySection3 = bl8 = iDeserializer.getBool();
            hUDConfiguration.displaySection4 = bl7 = iDeserializer.getBool();
            hUDConfiguration.displaySection5 = bl6 = iDeserializer.getBool();
            hUDConfiguration.displaySection6 = bl5 = iDeserializer.getBool();
            hUDConfiguration.displaySection7 = bl4 = iDeserializer.getBool();
            hUDConfiguration.displaySection8 = bl3 = iDeserializer.getBool();
            hUDConfiguration.driverAssistance = bl2 = iDeserializer.getBool();
            hUDConfiguration.sectionConfigListTransmittableElements = carArrayListTransmittableElements = CarArrayListTransmittableElementsSerializer.getOptionalCarArrayListTransmittableElements(iDeserializer);
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            hUDConfiguration.sectionConfigListRAConfig = nArray;
        }
        return hUDConfiguration;
    }

    public static HUDConfiguration[] getOptionalHUDConfigurationVarArray(IDeserializer iDeserializer) {
        HUDConfiguration[] hUDConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            hUDConfigurationArray = new HUDConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                hUDConfigurationArray[i2] = HUDConfigurationSerializer.getOptionalHUDConfiguration(iDeserializer);
            }
        }
        return hUDConfigurationArray;
    }
}

