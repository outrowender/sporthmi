/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.radio.IntellitextSubmenu;

public class IntellitextSubmenuSerializer {
    public static void putOptionalIntellitextSubmenu(ISerializer iSerializer, IntellitextSubmenu intellitextSubmenu) throws SerializerException {
        boolean bl = intellitextSubmenu == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = intellitextSubmenu.getName();
            iSerializer.putOptionalString(string);
            String[] stringArray = intellitextSubmenu.getDataList();
            iSerializer.putOptionalStringVarArray(stringArray);
        }
    }

    public static void putOptionalIntellitextSubmenuVarArray(ISerializer iSerializer, IntellitextSubmenu[] intellitextSubmenuArray) throws SerializerException {
        boolean bl = intellitextSubmenuArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(intellitextSubmenuArray.length);
            for (int i2 = 0; i2 < intellitextSubmenuArray.length; ++i2) {
                IntellitextSubmenuSerializer.putOptionalIntellitextSubmenu(iSerializer, intellitextSubmenuArray[i2]);
            }
        }
    }

    public static IntellitextSubmenu getOptionalIntellitextSubmenu(IDeserializer iDeserializer) throws SerializerException {
        IntellitextSubmenu intellitextSubmenu = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            intellitextSubmenu = new IntellitextSubmenu();
            intellitextSubmenu.name = string = iDeserializer.getOptionalString();
            String[] stringArray = iDeserializer.getOptionalStringVarArray();
            intellitextSubmenu.dataList = stringArray;
        }
        return intellitextSubmenu;
    }

    public static IntellitextSubmenu[] getOptionalIntellitextSubmenuVarArray(IDeserializer iDeserializer) throws SerializerException {
        IntellitextSubmenu[] intellitextSubmenuArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            intellitextSubmenuArray = new IntellitextSubmenu[n];
            for (int i2 = 0; i2 < n; ++i2) {
                intellitextSubmenuArray[i2] = IntellitextSubmenuSerializer.getOptionalIntellitextSubmenu(iDeserializer);
            }
        }
        return intellitextSubmenuArray;
    }
}

