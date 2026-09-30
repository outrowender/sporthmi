/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.carkombi.impl.HUDDisplaySection1Serializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.HUDDisplaySection2Serializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.HUDDisplaySection3Serializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.HUDDisplaySection4Serializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carkombi.HUDDisplaySection1;
import org.dsi.ifc.carkombi.HUDDisplaySection2;
import org.dsi.ifc.carkombi.HUDDisplaySection3;
import org.dsi.ifc.carkombi.HUDDisplaySection4;
import org.dsi.ifc.carkombi.HUDSectionConfigListRecord;

public class HUDSectionConfigListRecordSerializer {
    public static void putOptionalHUDSectionConfigListRecord(ISerializer iSerializer, HUDSectionConfigListRecord hUDSectionConfigListRecord) throws SerializerException {
        boolean bl = hUDSectionConfigListRecord == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = hUDSectionConfigListRecord.getPos();
            iSerializer.putInt32(n);
            int n2 = hUDSectionConfigListRecord.getDisplaySection();
            iSerializer.putInt32(n2);
            HUDDisplaySection1 hUDDisplaySection1 = hUDSectionConfigListRecord.getDisplaySectionSetup1();
            HUDDisplaySection1Serializer.putOptionalHUDDisplaySection1(iSerializer, hUDDisplaySection1);
            HUDDisplaySection2 hUDDisplaySection2 = hUDSectionConfigListRecord.getDisplaySectionSetup2();
            HUDDisplaySection2Serializer.putOptionalHUDDisplaySection2(iSerializer, hUDDisplaySection2);
            HUDDisplaySection3 hUDDisplaySection3 = hUDSectionConfigListRecord.getDisplaySectionSetup3();
            HUDDisplaySection3Serializer.putOptionalHUDDisplaySection3(iSerializer, hUDDisplaySection3);
            HUDDisplaySection4 hUDDisplaySection4 = hUDSectionConfigListRecord.getDisplaySectionSetup4();
            HUDDisplaySection4Serializer.putOptionalHUDDisplaySection4(iSerializer, hUDDisplaySection4);
            HUDDisplaySection1 hUDDisplaySection12 = hUDSectionConfigListRecord.getDisplaySectionSelection1();
            HUDDisplaySection1Serializer.putOptionalHUDDisplaySection1(iSerializer, hUDDisplaySection12);
            HUDDisplaySection2 hUDDisplaySection22 = hUDSectionConfigListRecord.getDisplaySectionSelection2();
            HUDDisplaySection2Serializer.putOptionalHUDDisplaySection2(iSerializer, hUDDisplaySection22);
            HUDDisplaySection3 hUDDisplaySection32 = hUDSectionConfigListRecord.getDisplaySectionSelection3();
            HUDDisplaySection3Serializer.putOptionalHUDDisplaySection3(iSerializer, hUDDisplaySection32);
            HUDDisplaySection4 hUDDisplaySection42 = hUDSectionConfigListRecord.getDisplaySectionSelection4();
            HUDDisplaySection4Serializer.putOptionalHUDDisplaySection4(iSerializer, hUDDisplaySection42);
        }
    }

    public static void putOptionalHUDSectionConfigListRecordVarArray(ISerializer iSerializer, HUDSectionConfigListRecord[] hUDSectionConfigListRecordArray) throws SerializerException {
        boolean bl = hUDSectionConfigListRecordArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(hUDSectionConfigListRecordArray.length);
            for (int i2 = 0; i2 < hUDSectionConfigListRecordArray.length; ++i2) {
                HUDSectionConfigListRecordSerializer.putOptionalHUDSectionConfigListRecord(iSerializer, hUDSectionConfigListRecordArray[i2]);
            }
        }
    }

    public static HUDSectionConfigListRecord getOptionalHUDSectionConfigListRecord(IDeserializer iDeserializer) throws SerializerException {
        HUDSectionConfigListRecord hUDSectionConfigListRecord = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            HUDDisplaySection4 hUDDisplaySection4;
            HUDDisplaySection3 hUDDisplaySection3;
            HUDDisplaySection2 hUDDisplaySection2;
            HUDDisplaySection1 hUDDisplaySection1;
            HUDDisplaySection4 hUDDisplaySection42;
            HUDDisplaySection3 hUDDisplaySection32;
            HUDDisplaySection2 hUDDisplaySection22;
            HUDDisplaySection1 hUDDisplaySection12;
            int n;
            int n2;
            hUDSectionConfigListRecord = new HUDSectionConfigListRecord();
            hUDSectionConfigListRecord.pos = n2 = iDeserializer.getInt32();
            hUDSectionConfigListRecord.displaySection = n = iDeserializer.getInt32();
            hUDSectionConfigListRecord.displaySectionSetup1 = hUDDisplaySection12 = HUDDisplaySection1Serializer.getOptionalHUDDisplaySection1(iDeserializer);
            hUDSectionConfigListRecord.displaySectionSetup2 = hUDDisplaySection22 = HUDDisplaySection2Serializer.getOptionalHUDDisplaySection2(iDeserializer);
            hUDSectionConfigListRecord.displaySectionSetup3 = hUDDisplaySection32 = HUDDisplaySection3Serializer.getOptionalHUDDisplaySection3(iDeserializer);
            hUDSectionConfigListRecord.displaySectionSetup4 = hUDDisplaySection42 = HUDDisplaySection4Serializer.getOptionalHUDDisplaySection4(iDeserializer);
            hUDSectionConfigListRecord.displaySectionSelection1 = hUDDisplaySection1 = HUDDisplaySection1Serializer.getOptionalHUDDisplaySection1(iDeserializer);
            hUDSectionConfigListRecord.displaySectionSelection2 = hUDDisplaySection2 = HUDDisplaySection2Serializer.getOptionalHUDDisplaySection2(iDeserializer);
            hUDSectionConfigListRecord.displaySectionSelection3 = hUDDisplaySection3 = HUDDisplaySection3Serializer.getOptionalHUDDisplaySection3(iDeserializer);
            hUDSectionConfigListRecord.displaySectionSelection4 = hUDDisplaySection4 = HUDDisplaySection4Serializer.getOptionalHUDDisplaySection4(iDeserializer);
        }
        return hUDSectionConfigListRecord;
    }

    public static HUDSectionConfigListRecord[] getOptionalHUDSectionConfigListRecordVarArray(IDeserializer iDeserializer) throws SerializerException {
        HUDSectionConfigListRecord[] hUDSectionConfigListRecordArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            hUDSectionConfigListRecordArray = new HUDSectionConfigListRecord[n];
            for (int i2 = 0; i2 < n; ++i2) {
                hUDSectionConfigListRecordArray[i2] = HUDSectionConfigListRecordSerializer.getOptionalHUDSectionConfigListRecord(iDeserializer);
            }
        }
        return hUDSectionConfigListRecordArray;
    }
}

