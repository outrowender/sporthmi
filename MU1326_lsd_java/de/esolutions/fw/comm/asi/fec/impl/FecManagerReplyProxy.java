/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec.impl;

import de.esolutions.fw.comm.asi.fec.FecManagerReply;
import de.esolutions.fw.comm.asi.fec.SFecDetails;
import de.esolutions.fw.comm.asi.fec.SFecHistory;
import de.esolutions.fw.comm.asi.fec.SFecImportStatus;
import de.esolutions.fw.comm.asi.fec.impl.SFecDetailsSerializer;
import de.esolutions.fw.comm.asi.fec.impl.SFecHistorySerializer;
import de.esolutions.fw.comm.asi.fec.impl.SFecImportStatusSerializer;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class FecManagerReplyProxy
implements FecManagerReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.fec.FecManager");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public FecManagerReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("7b2f491d-eea1-4197-9124-469efe2453d2", -1, "8db34658-32cf-5a16-a3fd-9571af38a1d3", "asi.fec.FecManager");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void checkDataSignature(final String string, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalString(string);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)1, iSerializable);
    }

    public void fecDetails(final SFecDetails sFecDetails) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                SFecDetailsSerializer.putOptionalSFecDetails(iSerializer, sFecDetails);
            }
        };
        this.proxy.remoteCallMethod((short)15, iSerializable);
    }

    public void importFecs(final int n, final SFecImportStatus[] sFecImportStatusArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                SFecImportStatusSerializer.putOptionalSFecImportStatusVarArray(iSerializer, sFecImportStatusArray);
            }
        };
        this.proxy.remoteCallMethod((short)13, iSerializable);
    }

    public void exportCCD(final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)6, iSerializable);
    }

    public void getHistory(final SFecHistory[] sFecHistoryArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                SFecHistorySerializer.putOptionalSFecHistoryVarArray(iSerializer, sFecHistoryArray);
            }
        };
        this.proxy.remoteCallMethod((short)11, iSerializable);
    }

    public void encryptFile(final String string, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalString(string);
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)4, iSerializable);
    }

    public void decryptFile(final String string, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalString(string);
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)2, iSerializable);
    }
}

