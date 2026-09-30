/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.ddp20.impl;

import de.esolutions.fw.comm.dsi.ddp20.impl.FrameRequestSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.ddp20.DisplayRequest;
import org.dsi.ifc.ddp20.FrameRequest;

public class DisplayRequestSerializer {
    public static void putOptionalDisplayRequest(ISerializer iSerializer, DisplayRequest displayRequest) throws SerializerException {
        boolean bl = displayRequest == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = displayRequest.getNumFrames();
            iSerializer.putInt32(n);
            FrameRequest[] frameRequestArray = displayRequest.getFrameRequest();
            FrameRequestSerializer.putOptionalFrameRequestVarArray(iSerializer, frameRequestArray);
        }
    }

    public static void putOptionalDisplayRequestVarArray(ISerializer iSerializer, DisplayRequest[] displayRequestArray) throws SerializerException {
        boolean bl = displayRequestArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(displayRequestArray.length);
            for (int i2 = 0; i2 < displayRequestArray.length; ++i2) {
                DisplayRequestSerializer.putOptionalDisplayRequest(iSerializer, displayRequestArray[i2]);
            }
        }
    }

    public static DisplayRequest getOptionalDisplayRequest(IDeserializer iDeserializer) throws SerializerException {
        DisplayRequest displayRequest = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            displayRequest = new DisplayRequest();
            displayRequest.numFrames = n = iDeserializer.getInt32();
            FrameRequest[] frameRequestArray = FrameRequestSerializer.getOptionalFrameRequestVarArray(iDeserializer);
            displayRequest.frameRequest = frameRequestArray;
        }
        return displayRequest;
    }

    public static DisplayRequest[] getOptionalDisplayRequestVarArray(IDeserializer iDeserializer) throws SerializerException {
        DisplayRequest[] displayRequestArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            displayRequestArray = new DisplayRequest[n];
            for (int i2 = 0; i2 < n; ++i2) {
                displayRequestArray[i2] = DisplayRequestSerializer.getOptionalDisplayRequest(iDeserializer);
            }
        }
        return displayRequestArray;
    }
}

