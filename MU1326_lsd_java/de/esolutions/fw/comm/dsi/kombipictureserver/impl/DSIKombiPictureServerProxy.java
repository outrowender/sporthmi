/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombipictureserver.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.comm.dsi.kombipictureserver.DSIKombiPictureServer;
import de.esolutions.fw.comm.dsi.kombipictureserver.DSIKombiPictureServerC;
import de.esolutions.fw.comm.dsi.kombipictureserver.DSIKombiPictureServerReply;
import de.esolutions.fw.comm.dsi.kombipictureserver.impl.DSIKombiPictureServerReplyService;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.ResourceLocator;

public class DSIKombiPictureServerProxy
implements DSIKombiPictureServer,
DSIKombiPictureServerC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.kombipictureserver.DSIKombiPictureServer");
    private Proxy proxy;

    public DSIKombiPictureServerProxy(int n, DSIKombiPictureServerReply dSIKombiPictureServerReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("e2ec2c1a-6feb-5795-ad64-808237e9eb04", n, "b5b5ee5e-67a7-517b-8bd4-22d8ed778502", "dsi.kombipictureserver.DSIKombiPictureServer");
        DSIKombiPictureServerReplyService dSIKombiPictureServerReplyService = new DSIKombiPictureServerReplyService(dSIKombiPictureServerReply);
        this.proxy = new Proxy(serviceInstanceID, dSIKombiPictureServerReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void setKombiHmiReady() throws MethodException {
        this.proxy.remoteCallMethod((short)15, null);
    }

    public void responseCoverArt(final long l, final int n, final int n2, final int n3, final ResourceLocator resourceLocator) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt64(l);
                iSerializer.putInt32(n);
                iSerializer.putInt32(n2);
                iSerializer.putInt32(n3);
                ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
            }
        };
        this.proxy.remoteCallMethod((short)27, iSerializable);
    }

    public void responseStationArt(final long l, final int n, final int n2, final int n3, final ResourceLocator resourceLocator) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt64(l);
                iSerializer.putInt32(n);
                iSerializer.putInt32(n2);
                iSerializer.putInt32(n3);
                ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
            }
        };
        this.proxy.remoteCallMethod((short)29, iSerializable);
    }

    public void responseActiveCallPicture(final int n, final int n2, final ResourceLocator resourceLocator) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putInt32(n2);
                ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
            }
        };
        this.proxy.remoteCallMethod((short)10, iSerializable);
    }

    public void responseActiveCallPictureInstance(final int n, final int n2, final int n3, final ResourceLocator resourceLocator) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putInt32(n2);
                iSerializer.putInt32(n3);
                ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
            }
        };
        this.proxy.remoteCallMethod((short)36, iSerializable);
    }

    public void responseDynamicIcon(final int n, final int n2, final boolean bl, final ResourceLocator resourceLocator) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putInt32(n2);
                iSerializer.putBool(bl);
                ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
            }
        };
        this.proxy.remoteCallMethod((short)37, iSerializable);
    }

    public void responseAdbContactPicture(final long l, final int n, final int n2, final ResourceLocator resourceLocator) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt64(l);
                iSerializer.putInt32(n);
                iSerializer.putInt32(n2);
                ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
            }
        };
        this.proxy.remoteCallMethod((short)26, iSerializable);
    }

    public void responseInternalAddressID(long l, int n, int n2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)28, genericSerializable);
    }

    public void responsePictureServerAbilities(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)32, genericSerializable);
    }

    public void responsePictureStream(int n, short s, short s2, int n2, int n3, byte[] byArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt16(s);
            genericSerializable.putInt16(s2);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
            genericSerializable.putOptionalInt8VarArray(byArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)33, genericSerializable);
    }

    public void setNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)17, genericSerializable);
    }

    public void setNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)18, genericSerializable);
    }

    public void setNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)16, null);
    }

    public void clearNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)2, genericSerializable);
    }

    public void clearNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)3, genericSerializable);
    }

    public void clearNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)1, null);
    }

    public void yySet(String string, String string2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)20, genericSerializable);
    }
}

