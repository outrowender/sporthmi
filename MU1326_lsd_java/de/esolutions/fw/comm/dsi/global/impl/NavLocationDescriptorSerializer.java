/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.global.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.NavLocationDescriptor;

public class NavLocationDescriptorSerializer {
    public static void putOptionalNavLocationDescriptor(ISerializer iSerializer, NavLocationDescriptor navLocationDescriptor) throws SerializerException {
        boolean bl = navLocationDescriptor == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = navLocationDescriptor.getSelectionCriterion();
            iSerializer.putInt32(n);
            String string = navLocationDescriptor.getData();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalNavLocationDescriptorVarArray(ISerializer iSerializer, NavLocationDescriptor[] navLocationDescriptorArray) throws SerializerException {
        boolean bl = navLocationDescriptorArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(navLocationDescriptorArray.length);
            for (int i2 = 0; i2 < navLocationDescriptorArray.length; ++i2) {
                NavLocationDescriptorSerializer.putOptionalNavLocationDescriptor(iSerializer, navLocationDescriptorArray[i2]);
            }
        }
    }

    public static NavLocationDescriptor getOptionalNavLocationDescriptor(IDeserializer iDeserializer) throws SerializerException {
        NavLocationDescriptor navLocationDescriptor = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            navLocationDescriptor = new NavLocationDescriptor();
            navLocationDescriptor.selectionCriterion = n = iDeserializer.getInt32();
            navLocationDescriptor.data = string = iDeserializer.getOptionalString();
        }
        return navLocationDescriptor;
    }

    public static NavLocationDescriptor[] getOptionalNavLocationDescriptorVarArray(IDeserializer iDeserializer) throws SerializerException {
        NavLocationDescriptor[] navLocationDescriptorArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            navLocationDescriptorArray = new NavLocationDescriptor[n];
            for (int i2 = 0; i2 < n; ++i2) {
                navLocationDescriptorArray[i2] = NavLocationDescriptorSerializer.getOptionalNavLocationDescriptor(iDeserializer);
            }
        }
        return navLocationDescriptorArray;
    }
}

