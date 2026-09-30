/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.onlineservices.auth.impl;

import de.esolutions.fw.comm.asi.onlineservices.auth.PairingCodeValidatorReply;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class PairingCodeValidatorReplyProxy
implements PairingCodeValidatorReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.onlineservices.auth.PairingCodeValidator");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public PairingCodeValidatorReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("66f43e33-18c7-4244-bb8e-c0ecce462f56", -1, "2097acb3-6a38-515a-af63-e947eb363c44", "asi.onlineservices.auth.PairingCodeValidator");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void validatePairingCodeResult(final boolean bl, final String string, final String string2, final int n, final int n2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putBool(bl);
                iSerializer.putOptionalString(string);
                iSerializer.putOptionalString(string2);
                iSerializer.putInt32(n);
                iSerializer.putInt32(n2);
            }
        };
        this.proxy.remoteCallMethod((short)5, iSerializable);
    }

    public void resetPairingCode(final String string, final String string2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalString(string);
                iSerializer.putOptionalString(string2);
            }
        };
        this.proxy.remoteCallMethod((short)0, iSerializable);
    }
}

