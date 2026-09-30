/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.imageserver.impl;

import de.esolutions.fw.comm.asi.imageserver.Image;
import de.esolutions.fw.comm.asi.imageserver.ImageInfo;
import de.esolutions.fw.comm.asi.imageserver.ImageServerReply;
import de.esolutions.fw.comm.asi.imageserver.impl.ImageInfoSerializer;
import de.esolutions.fw.comm.asi.imageserver.impl.ImageSerializer;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ImageServerReplyProxy
implements ImageServerReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.imageserver.ImageServer");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public ImageServerReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("4859e928-623e-4248-8210-d55453bef3a4", -1, "b9a016f3-d0ec-5bf0-bc90-42549185f0a0", "asi.imageserver.ImageServer");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void responseImage(final String string, final Image image, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalString(string);
                ImageSerializer.putOptionalImage(iSerializer, image);
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)24, iSerializable);
    }

    public void responseImageInformation(final String string, final ImageInfo imageInfo, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalString(string);
                ImageInfoSerializer.putOptionalImageInfo(iSerializer, imageInfo);
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)25, iSerializable);
    }

    public void updateASIVersion(final String string, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalString(string);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)23, iSerializable);
    }
}

