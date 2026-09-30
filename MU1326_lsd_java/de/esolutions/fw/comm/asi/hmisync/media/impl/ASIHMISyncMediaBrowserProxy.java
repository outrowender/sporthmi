/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaBrowser;
import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaBrowserC;
import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaBrowserReply;
import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaBrowserReplyService;
import de.esolutions.fw.comm.asi.hmisync.media.impl.MediaEntrySerializer;
import de.esolutions.fw.comm.asi.hmisync.media.impl.MediaSourceSlotSerializer;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncMediaBrowserProxy
implements ASIHMISyncMediaBrowser,
ASIHMISyncMediaBrowserC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.media.ASIHMISyncMediaBrowser");
    private Proxy proxy;

    public ASIHMISyncMediaBrowserProxy(int n, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("04780aa8-9662-4220-9900-4a1e11586d28", n, "8f2aa3cc-0c22-5ffa-83d3-4e78162cf3e6", "asi.hmisync.media.ASIHMISyncMediaBrowser");
        ASIHMISyncMediaBrowserReplyService aSIHMISyncMediaBrowserReplyService = new ASIHMISyncMediaBrowserReplyService(aSIHMISyncMediaBrowserReply);
        this.proxy = new Proxy(serviceInstanceID, aSIHMISyncMediaBrowserReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void activate(final MediaSourceSlot mediaSourceSlot) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                MediaSourceSlotSerializer.putOptionalMediaSourceSlot(iSerializer, mediaSourceSlot);
            }
        };
        this.proxy.remoteCallMethod((short)0, iSerializable);
    }

    public void deactivate() throws MethodException {
        this.proxy.remoteCallMethod((short)6, null);
    }

    public void setBrowseMode(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }

    public void changeFolder(final MediaEntry[] mediaEntryArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                MediaEntrySerializer.putOptionalMediaEntryVarArray(iSerializer, mediaEntryArray);
            }
        };
        this.proxy.remoteCallMethod((short)2, iSerializable);
    }

    public void addSelection(final int n, final MediaEntry mediaEntry) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                MediaEntrySerializer.putOptionalMediaEntry(iSerializer, mediaEntry);
            }
        };
        this.proxy.remoteCallMethod((short)1, iSerializable);
    }

    public void requestList(int n, long l, int n2, int n3) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt64(l);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    public void setNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)12, null);
    }

    public void setNotification(long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)14, genericSerializable);
    }

    public void setNotification(long[] lArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalUInt32VarArray(lArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)13, genericSerializable);
    }

    public void clearNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)3, null);
    }

    public void clearNotification(long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    public void clearNotification(long[] lArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalUInt32VarArray(lArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }
}

