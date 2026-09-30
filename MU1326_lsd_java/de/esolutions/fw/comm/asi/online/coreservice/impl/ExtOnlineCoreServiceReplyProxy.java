/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice.impl;

import de.esolutions.fw.comm.asi.online.coreservice.ExtOnlineCoreServiceReply;
import de.esolutions.fw.comm.asi.online.coreservice.KeyValPair;
import de.esolutions.fw.comm.asi.online.coreservice.OAuthToken;
import de.esolutions.fw.comm.asi.online.coreservice.Result;
import de.esolutions.fw.comm.asi.online.coreservice.ServiceListEntry;
import de.esolutions.fw.comm.asi.online.coreservice.impl.KeyValPairSerializer;
import de.esolutions.fw.comm.asi.online.coreservice.impl.OAuthTokenSerializer;
import de.esolutions.fw.comm.asi.online.coreservice.impl.ResultSerializer;
import de.esolutions.fw.comm.asi.online.coreservice.impl.ServiceListEntrySerializer;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.online.impl.OSRNotifyPropertiesSLSerializer;
import de.esolutions.fw.comm.dsi.online.impl.OSRNotifyPropertiesSerializer;
import de.esolutions.fw.comm.dsi.online.impl.OSRServiceStateSerializer;
import de.esolutions.fw.comm.dsi.online.impl.OSRUserSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.online.OSRNotifyProperties;
import org.dsi.ifc.online.OSRNotifyPropertiesSL;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.OSRUser;

public class ExtOnlineCoreServiceReplyProxy
implements ExtOnlineCoreServiceReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.online.coreservice.ExtOnlineCoreService");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public ExtOnlineCoreServiceReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("5bb8eff1-90a0-11e2-9e96-0800200c9a66", -1, "ffcc1b5d-eaea-5a1c-86e3-def3e28eb53d", "asi.online.coreservice.ExtOnlineCoreService");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void initResponse(final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)25, iSerializable);
    }

    public void registerServiceResponse(final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)31, iSerializable);
    }

    public void enableApplication() throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
            }
        };
        this.proxy.remoteCallMethod((short)2, iSerializable);
    }

    public void disableApplication() throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
            }
        };
        this.proxy.remoteCallMethod((short)1, iSerializable);
    }

    public void getServiceListEntryResponse(final int n, final ServiceListEntry serviceListEntry) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                ServiceListEntrySerializer.putOptionalServiceListEntry(iSerializer, serviceListEntry);
            }
        };
        this.proxy.remoteCallMethod((short)21, iSerializable);
    }

    public void updateApplicationState(final OSRNotifyProperties[] oSRNotifyPropertiesArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                OSRNotifyPropertiesSerializer.putOptionalOSRNotifyPropertiesVarArray(iSerializer, oSRNotifyPropertiesArray);
            }
        };
        this.proxy.remoteCallMethod((short)32, iSerializable);
    }

    public void updateServices(final OSRNotifyPropertiesSL[] oSRNotifyPropertiesSLArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                OSRNotifyPropertiesSLSerializer.putOptionalOSRNotifyPropertiesSLVarArray(iSerializer, oSRNotifyPropertiesSLArray);
            }
        };
        this.proxy.remoteCallMethod((short)36, iSerializable);
    }

    public void updateServiceState(final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)35, iSerializable);
    }

    public void precheckOnlineServiceServiceIDResponse(final OSRServiceState oSRServiceState) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                OSRServiceStateSerializer.putOptionalOSRServiceState(iSerializer, oSRServiceState);
            }
        };
        this.proxy.remoteCallMethod((short)29, iSerializable);
    }

    public void precheckOnlineServiceResponse(final OSRServiceState[] oSRServiceStateArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                OSRServiceStateSerializer.putOptionalOSRServiceStateVarArray(iSerializer, oSRServiceStateArray);
            }
        };
        this.proxy.remoteCallMethod((short)27, iSerializable);
    }

    public void keyStoreChanged() throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
            }
        };
        this.proxy.remoteCallMethod((short)13, iSerializable);
    }

    public void updateLoggedInUser(final OSRUser oSRUser, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                OSRUserSerializer.putOptionalOSRUser(iSerializer, oSRUser);
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)34, iSerializable);
    }

    public void getTokenResponse(final int n, final OAuthToken oAuthToken, final String string) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putEnum(n);
                OAuthTokenSerializer.putOptionalOAuthToken(iSerializer, oAuthToken);
                iSerializer.putOptionalString(string);
            }
        };
        this.proxy.remoteCallMethod((short)23, iSerializable);
    }

    public void onlineResponse(final int n, final KeyValPair[] keyValPairArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                KeyValPairSerializer.putOptionalKeyValPairVarArray(iSerializer, keyValPairArray);
            }
        };
        this.proxy.remoteCallMethod((short)7, iSerializable);
    }

    public void dataResponse(final int n, final byte[] byArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putOptionalInt8VarArray(byArray);
            }
        };
        this.proxy.remoteCallMethod((short)8, iSerializable);
    }

    public void finalResponse(final int n, final Result result) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                ResultSerializer.putOptionalResult(iSerializer, result);
            }
        };
        this.proxy.remoteCallMethod((short)19, iSerializable);
    }

    public void updateCredentials(final int n, final int n2, final String string, final String string2, final String string3) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putEnum(n2);
                iSerializer.putOptionalString(string);
                iSerializer.putOptionalString(string2);
                iSerializer.putOptionalString(string3);
            }
        };
        this.proxy.remoteCallMethod((short)33, iSerializable);
    }
}

