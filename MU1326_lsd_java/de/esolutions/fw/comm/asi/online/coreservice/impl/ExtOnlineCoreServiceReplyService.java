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
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.online.impl.OSRNotifyPropertiesSLSerializer;
import de.esolutions.fw.comm.dsi.online.impl.OSRNotifyPropertiesSerializer;
import de.esolutions.fw.comm.dsi.online.impl.OSRServiceStateSerializer;
import de.esolutions.fw.comm.dsi.online.impl.OSRUserSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.online.OSRNotifyProperties;
import org.dsi.ifc.online.OSRNotifyPropertiesSL;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.OSRUser;

public class ExtOnlineCoreServiceReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.online.coreservice.ExtOnlineCoreService");
    private static int dynamicHandle = 0;
    private ExtOnlineCoreServiceReply p_ExtOnlineCoreServiceReply;

    public ExtOnlineCoreServiceReplyService(ExtOnlineCoreServiceReply extOnlineCoreServiceReply) {
        super(new ServiceInstanceID("5bb8eff1-90a0-11e2-9e96-0800200c9a66", ExtOnlineCoreServiceReplyService.nextDynamicHandle(), "ffcc1b5d-eaea-5a1c-86e3-def3e28eb53d", "asi.online.coreservice.ExtOnlineCoreService"));
        this.p_ExtOnlineCoreServiceReply = extOnlineCoreServiceReply;
    }

    private static synchronized int nextDynamicHandle() {
        int n = ++dynamicHandle;
        return n;
    }

    public CallContext getCallContext() {
        return context;
    }

    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) throws MethodException {
        try {
            switch (s) {
                case 25: {
                    int n = iDeserializer.getInt32();
                    this.p_ExtOnlineCoreServiceReply.initResponse(n);
                    break;
                }
                case 31: {
                    int n = iDeserializer.getInt32();
                    this.p_ExtOnlineCoreServiceReply.registerServiceResponse(n);
                    break;
                }
                case 2: {
                    this.p_ExtOnlineCoreServiceReply.enableApplication();
                    break;
                }
                case 1: {
                    this.p_ExtOnlineCoreServiceReply.disableApplication();
                    break;
                }
                case 21: {
                    int n = iDeserializer.getInt32();
                    ServiceListEntry serviceListEntry = ServiceListEntrySerializer.getOptionalServiceListEntry(iDeserializer);
                    this.p_ExtOnlineCoreServiceReply.getServiceListEntryResponse(n, serviceListEntry);
                    break;
                }
                case 32: {
                    OSRNotifyProperties[] oSRNotifyPropertiesArray = OSRNotifyPropertiesSerializer.getOptionalOSRNotifyPropertiesVarArray(iDeserializer);
                    this.p_ExtOnlineCoreServiceReply.updateApplicationState(oSRNotifyPropertiesArray);
                    break;
                }
                case 36: {
                    OSRNotifyPropertiesSL[] oSRNotifyPropertiesSLArray = OSRNotifyPropertiesSLSerializer.getOptionalOSRNotifyPropertiesSLVarArray(iDeserializer);
                    this.p_ExtOnlineCoreServiceReply.updateServices(oSRNotifyPropertiesSLArray);
                    break;
                }
                case 35: {
                    int n = iDeserializer.getInt32();
                    this.p_ExtOnlineCoreServiceReply.updateServiceState(n);
                    break;
                }
                case 29: {
                    OSRServiceState oSRServiceState = OSRServiceStateSerializer.getOptionalOSRServiceState(iDeserializer);
                    this.p_ExtOnlineCoreServiceReply.precheckOnlineServiceServiceIDResponse(oSRServiceState);
                    break;
                }
                case 27: {
                    OSRServiceState[] oSRServiceStateArray = OSRServiceStateSerializer.getOptionalOSRServiceStateVarArray(iDeserializer);
                    this.p_ExtOnlineCoreServiceReply.precheckOnlineServiceResponse(oSRServiceStateArray);
                    break;
                }
                case 13: {
                    this.p_ExtOnlineCoreServiceReply.keyStoreChanged();
                    break;
                }
                case 34: {
                    OSRUser oSRUser = OSRUserSerializer.getOptionalOSRUser(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_ExtOnlineCoreServiceReply.updateLoggedInUser(oSRUser, n);
                    break;
                }
                case 23: {
                    int n = iDeserializer.getEnum();
                    OAuthToken oAuthToken = OAuthTokenSerializer.getOptionalOAuthToken(iDeserializer);
                    String string = iDeserializer.getOptionalString();
                    this.p_ExtOnlineCoreServiceReply.getTokenResponse(n, oAuthToken, string);
                    break;
                }
                case 7: {
                    int n = iDeserializer.getInt32();
                    KeyValPair[] keyValPairArray = KeyValPairSerializer.getOptionalKeyValPairVarArray(iDeserializer);
                    this.p_ExtOnlineCoreServiceReply.onlineResponse(n, keyValPairArray);
                    break;
                }
                case 8: {
                    int n = iDeserializer.getInt32();
                    byte[] byArray = iDeserializer.getOptionalInt8VarArray();
                    this.p_ExtOnlineCoreServiceReply.dataResponse(n, byArray);
                    break;
                }
                case 19: {
                    int n = iDeserializer.getInt32();
                    Result result = ResultSerializer.getOptionalResult(iDeserializer);
                    this.p_ExtOnlineCoreServiceReply.finalResponse(n, result);
                    break;
                }
                case 33: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getEnum();
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    String string3 = iDeserializer.getOptionalString();
                    this.p_ExtOnlineCoreServiceReply.updateCredentials(n, n2, string, string2, string3);
                    break;
                }
                default: {
                    throw new MethodException("Invalid Method Id " + s);
                }
            }
        }
        catch (SerializerException serializerException) {
            throw new MethodException("Deserialization failed: method=" + s + ", error=" + serializerException.getMessage());
        }
    }
}

