/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.organizer.vcardexchange.impl;

import de.esolutions.fw.comm.asi.organizer.vcardexchange.VCardParser;
import de.esolutions.fw.comm.asi.organizer.vcardexchange.VCardParserC;
import de.esolutions.fw.comm.asi.organizer.vcardexchange.VCardParserReply;
import de.esolutions.fw.comm.asi.organizer.vcardexchange.impl.VCardParserReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.organizer.impl.AdbEntrySerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.organizer.AdbEntry;

public class VCardParserProxy
implements VCardParser,
VCardParserC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.organizer.vcardexchange.VCardParser");
    private Proxy proxy;

    public VCardParserProxy(int n, VCardParserReply vCardParserReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("ac51e9cb-58ff-4a94-82b2-348bedfdc513", n, "4d2de5a1-2ec1-5014-915d-ced43ea78aaf", "asi.organizer.vcardexchange.VCardParser");
        VCardParserReplyService vCardParserReplyService = new VCardParserReplyService(vCardParserReply);
        this.proxy = new Proxy(serviceInstanceID, vCardParserReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void parseVCard(String string, int n, int n2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)18, genericSerializable);
    }

    public void parseVCardDirectory(String string, int n, int n2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)19, genericSerializable);
    }

    public void exportVCard(final AdbEntry adbEntry, final String string, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                AdbEntrySerializer.putOptionalAdbEntry(iSerializer, adbEntry);
                iSerializer.putOptionalString(string);
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)25, iSerializable);
    }

    public void exportSmallVCard(final AdbEntry adbEntry, final String string, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                AdbEntrySerializer.putOptionalAdbEntry(iSerializer, adbEntry);
                iSerializer.putOptionalString(string);
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)24, iSerializable);
    }

    public void finishParsing(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    public void finishExport(int n, int n2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)23, genericSerializable);
    }

    public void finishSmallExport(String string, int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    public void setBinaryContentTempPath(String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)15, genericSerializable);
    }

    public void setBinaryContentQuotaPerFile(long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)13, genericSerializable);
    }

    public void setExtendedAddressHandling(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)28, genericSerializable);
    }
}

