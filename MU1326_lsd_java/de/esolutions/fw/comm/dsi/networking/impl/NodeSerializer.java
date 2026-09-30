/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.networking.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.networking.Node;

public class NodeSerializer {
    public static void putOptionalNode(ISerializer iSerializer, Node node) throws SerializerException {
        boolean bl = node == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = node.getMacAddress();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalNodeVarArray(ISerializer iSerializer, Node[] nodeArray) throws SerializerException {
        boolean bl = nodeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(nodeArray.length);
            for (int i2 = 0; i2 < nodeArray.length; ++i2) {
                NodeSerializer.putOptionalNode(iSerializer, nodeArray[i2]);
            }
        }
    }

    public static Node getOptionalNode(IDeserializer iDeserializer) throws SerializerException {
        Node node = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            node = new Node();
            node.macAddress = string = iDeserializer.getOptionalString();
        }
        return node;
    }

    public static Node[] getOptionalNodeVarArray(IDeserializer iDeserializer) throws SerializerException {
        Node[] nodeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            nodeArray = new Node[n];
            for (int i2 = 0; i2 < n; ++i2) {
                nodeArray[i2] = NodeSerializer.getOptionalNode(iDeserializer);
            }
        }
        return nodeArray;
    }
}

