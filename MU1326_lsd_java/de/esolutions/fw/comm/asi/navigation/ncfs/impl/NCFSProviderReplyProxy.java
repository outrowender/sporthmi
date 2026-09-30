/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs.impl;

import de.esolutions.fw.comm.asi.navigation.ncfs.NCFSProviderReply;
import de.esolutions.fw.comm.asi.navigation.ncfs.impl.sBoundingBoxSerializer;
import de.esolutions.fw.comm.asi.navigation.ncfs.impl.sEdgeSerializer;
import de.esolutions.fw.comm.asi.navigation.ncfs.impl.sLGIEventSerializer;
import de.esolutions.fw.comm.asi.navigation.ncfs.impl.sRestrictionSerializer;
import de.esolutions.fw.comm.asi.navigation.ncfs.impl.sTileInfoSerializer;
import de.esolutions.fw.comm.asi.navigation.ncfs.sBoundingBox;
import de.esolutions.fw.comm.asi.navigation.ncfs.sEdge;
import de.esolutions.fw.comm.asi.navigation.ncfs.sLGIEvent;
import de.esolutions.fw.comm.asi.navigation.ncfs.sRestriction;
import de.esolutions.fw.comm.asi.navigation.ncfs.sTileInfo;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class NCFSProviderReplyProxy
implements NCFSProviderReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.navigation.ncfs.NCFSProvider");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public NCFSProviderReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("7114efbf-e1b7-4c0f-a8ef-4e4718806d54", -1, "45c3e4f9-004e-561f-92cf-4451d9da24ab", "asi.navigation.ncfs.NCFSProvider");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void updateVZOTileIndexes(final int[] nArray, final sBoundingBox sBoundingBox2, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalInt32VarArray(nArray);
                sBoundingBoxSerializer.putOptionalsBoundingBox(iSerializer, sBoundingBox2);
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)5, iSerializable);
    }

    public void updateVZORestrictions(final sTileInfo[] sTileInfoArray, final sEdge[] sEdgeArray, final sRestriction[] sRestrictionArray, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sTileInfoSerializer.putOptionalsTileInfoVarArray(iSerializer, sTileInfoArray);
                sEdgeSerializer.putOptionalsEdgeVarArray(iSerializer, sEdgeArray);
                sRestrictionSerializer.putOptionalsRestrictionVarArray(iSerializer, sRestrictionArray);
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)16, iSerializable);
    }

    public void updateLGITileIndexes(final int[] nArray, final sBoundingBox sBoundingBox2, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalInt32VarArray(nArray);
                sBoundingBoxSerializer.putOptionalsBoundingBox(iSerializer, sBoundingBox2);
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)3, iSerializable);
    }

    public void updateLGIEvents(final sTileInfo[] sTileInfoArray, final sLGIEvent[] sLGIEventArray, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sTileInfoSerializer.putOptionalsTileInfoVarArray(iSerializer, sTileInfoArray);
                sLGIEventSerializer.putOptionalsLGIEventVarArray(iSerializer, sLGIEventArray);
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)15, iSerializable);
    }
}

