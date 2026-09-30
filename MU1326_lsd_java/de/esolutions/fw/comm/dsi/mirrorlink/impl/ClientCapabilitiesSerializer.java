/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.mirrorlink.impl;

import de.esolutions.fw.comm.dsi.mirrorlink.impl.DisplayCapabilitiesSerializer;
import de.esolutions.fw.comm.dsi.mirrorlink.impl.IconCapabilitiesSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.mirrorlink.ClientCapabilities;
import org.dsi.ifc.mirrorlink.DisplayCapabilities;
import org.dsi.ifc.mirrorlink.IconCapabilities;

public class ClientCapabilitiesSerializer {
    public static void putOptionalClientCapabilities(ISerializer iSerializer, ClientCapabilities clientCapabilities) throws SerializerException {
        boolean bl = clientCapabilities == null;
        iSerializer.putBool(bl);
        if (!bl) {
            DisplayCapabilities displayCapabilities = clientCapabilities.getDisplayCapabilities();
            DisplayCapabilitiesSerializer.putOptionalDisplayCapabilities(iSerializer, displayCapabilities);
            IconCapabilities iconCapabilities = clientCapabilities.getIconCapabilities();
            IconCapabilitiesSerializer.putOptionalIconCapabilities(iSerializer, iconCapabilities);
            int n = clientCapabilities.getNumberOfSimultaneousEvents();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalClientCapabilitiesVarArray(ISerializer iSerializer, ClientCapabilities[] clientCapabilitiesArray) throws SerializerException {
        boolean bl = clientCapabilitiesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(clientCapabilitiesArray.length);
            for (int i2 = 0; i2 < clientCapabilitiesArray.length; ++i2) {
                ClientCapabilitiesSerializer.putOptionalClientCapabilities(iSerializer, clientCapabilitiesArray[i2]);
            }
        }
    }

    public static ClientCapabilities getOptionalClientCapabilities(IDeserializer iDeserializer) throws SerializerException {
        ClientCapabilities clientCapabilities = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            IconCapabilities iconCapabilities;
            DisplayCapabilities displayCapabilities;
            clientCapabilities = new ClientCapabilities();
            clientCapabilities.displayCapabilities = displayCapabilities = DisplayCapabilitiesSerializer.getOptionalDisplayCapabilities(iDeserializer);
            clientCapabilities.iconCapabilities = iconCapabilities = IconCapabilitiesSerializer.getOptionalIconCapabilities(iDeserializer);
            clientCapabilities.numberOfSimultaneousEvents = n = iDeserializer.getInt32();
        }
        return clientCapabilities;
    }

    public static ClientCapabilities[] getOptionalClientCapabilitiesVarArray(IDeserializer iDeserializer) throws SerializerException {
        ClientCapabilities[] clientCapabilitiesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            clientCapabilitiesArray = new ClientCapabilities[n];
            for (int i2 = 0; i2 < n; ++i2) {
                clientCapabilitiesArray[i2] = ClientCapabilitiesSerializer.getOptionalClientCapabilities(iDeserializer);
            }
        }
        return clientCapabilitiesArray;
    }
}

