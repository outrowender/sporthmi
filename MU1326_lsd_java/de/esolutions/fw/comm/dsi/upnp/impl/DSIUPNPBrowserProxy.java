/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.upnp.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.upnp.DSIUPNPBrowser;
import de.esolutions.fw.comm.dsi.upnp.DSIUPNPBrowserC;
import de.esolutions.fw.comm.dsi.upnp.DSIUPNPBrowserReply;
import de.esolutions.fw.comm.dsi.upnp.impl.DSIUPNPBrowserReplyService;
import de.esolutions.fw.comm.dsi.upnp.impl.ListEntrySerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.upnp.ListEntry;

public class DSIUPNPBrowserProxy
implements DSIUPNPBrowser,
DSIUPNPBrowserC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.upnp.DSIUPNPBrowser");
    private Proxy proxy;

    public DSIUPNPBrowserProxy(int n, DSIUPNPBrowserReply dSIUPNPBrowserReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("8d35f5b4-3fbf-5229-98d1-b7f48f398272", n, "4689e104-88c5-580b-8c75-45b23c93e421", "dsi.upnp.DSIUPNPBrowser");
        DSIUPNPBrowserReplyService dSIUPNPBrowserReplyService = new DSIUPNPBrowserReplyService(dSIUPNPBrowserReply);
        this.proxy = new Proxy(serviceInstanceID, dSIUPNPBrowserReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void changeFolder(final ListEntry[] listEntryArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                ListEntrySerializer.putOptionalListEntryVarArray(iSerializer, listEntryArray);
            }
        };
        this.proxy.remoteCallMethod((short)1, iSerializable);
    }

    public void requestList(String string, int n, int n2, int n3) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    public void setNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)9, genericSerializable);
    }

    public void setNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)10, genericSerializable);
    }

    public void setNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)8, null);
    }

    public void clearNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)3, genericSerializable);
    }

    public void clearNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    public void clearNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)2, null);
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
        this.proxy.remoteCallMethod((short)14, genericSerializable);
    }
}

