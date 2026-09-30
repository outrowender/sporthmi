/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.organizer.vcardexchange.impl;

import de.esolutions.fw.comm.asi.organizer.vcardexchange.VCardParserReply;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.organizer.impl.AdbEntrySerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.organizer.AdbEntry;

public class VCardParserReplyProxy
implements VCardParserReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.organizer.vcardexchange.VCardParser");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public VCardParserReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("c4084aff-df82-4408-b56c-2aef1da8ec7e", -1, "167912de-3ac1-5a6e-8756-89022777b8bc", "asi.organizer.vcardexchange.VCardParser");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void parseVCardResult(final int n, final AdbEntry adbEntry, final int n2, final int n3) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putEnum(n);
                AdbEntrySerializer.putOptionalAdbEntry(iSerializer, adbEntry);
                iSerializer.putInt32(n2);
                iSerializer.putInt32(n3);
            }
        };
        this.proxy.remoteCallMethod((short)27, iSerializable);
    }

    public void parseVCardDirectoryResult(final int n, final AdbEntry[] adbEntryArray, final int n2, final int n3) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putEnum(n);
                AdbEntrySerializer.putOptionalAdbEntryVarArray(iSerializer, adbEntryArray);
                iSerializer.putInt32(n2);
                iSerializer.putInt32(n3);
            }
        };
        this.proxy.remoteCallMethod((short)26, iSerializable);
    }

    public void exportVCardResult(final int n, final String string, final int n2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putEnum(n);
                iSerializer.putOptionalString(string);
                iSerializer.putInt32(n2);
            }
        };
        this.proxy.remoteCallMethod((short)4, iSerializable);
    }

    public void exportSmallVCardResult(final int n, final String string, final int n2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putEnum(n);
                iSerializer.putOptionalString(string);
                iSerializer.putInt32(n2);
            }
        };
        this.proxy.remoteCallMethod((short)2, iSerializable);
    }

    public void parsingFinished(final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)12, iSerializable);
    }

    public void exportFinished(final int n, final int n2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putInt32(n2);
            }
        };
        this.proxy.remoteCallMethod((short)22, iSerializable);
    }

    public void smallExportFinished(final int n, final long[] lArray, final int n2, final String string, final int n3) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putEnum(n);
                iSerializer.putOptionalInt64VarArray(lArray);
                iSerializer.putInt32(n2);
                iSerializer.putOptionalString(string);
                iSerializer.putInt32(n3);
            }
        };
        this.proxy.remoteCallMethod((short)17, iSerializable);
    }

    public void setBinaryContentTempPathResult(final int n, final String string) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putEnum(n);
                iSerializer.putOptionalString(string);
            }
        };
        this.proxy.remoteCallMethod((short)16, iSerializable);
    }

    public void setBinaryContentQuotaPerFileResult(final int n, final long l) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putEnum(n);
                iSerializer.putInt64(l);
            }
        };
        this.proxy.remoteCallMethod((short)14, iSerializable);
    }
}

