/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.filebrowser.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.filebrowser.Path;

public class PathSerializer {
    public static void putOptionalPath(ISerializer iSerializer, Path path) throws SerializerException {
        boolean bl = path == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = path.getMountPoint();
            iSerializer.putOptionalString(string);
            String[] stringArray = path.getFolderNames();
            iSerializer.putOptionalStringVarArray(stringArray);
        }
    }

    public static void putOptionalPathVarArray(ISerializer iSerializer, Path[] pathArray) throws SerializerException {
        boolean bl = pathArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(pathArray.length);
            for (int i2 = 0; i2 < pathArray.length; ++i2) {
                PathSerializer.putOptionalPath(iSerializer, pathArray[i2]);
            }
        }
    }

    public static Path getOptionalPath(IDeserializer iDeserializer) throws SerializerException {
        Path path = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            path = new Path();
            path.mountPoint = string = iDeserializer.getOptionalString();
            String[] stringArray = iDeserializer.getOptionalStringVarArray();
            path.folderNames = stringArray;
        }
        return path;
    }

    public static Path[] getOptionalPathVarArray(IDeserializer iDeserializer) throws SerializerException {
        Path[] pathArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            pathArray = new Path[n];
            for (int i2 = 0; i2 < n; ++i2) {
                pathArray[i2] = PathSerializer.getOptionalPath(iDeserializer);
            }
        }
        return pathArray;
    }
}

