/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sApplicationSoftwareVersionNumberSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sClientResponseErrorSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sSerialNumberSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sSparePartNumberSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sSubsystemStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sSystemNameSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sApplicationSoftwareVersionNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSerialNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSparePartNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSubsystemState;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSystemName;
import de.esolutions.fw.comm.asi.diagnosis.media.impl.sActiveMediaSourceStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.media.impl.sDTCPStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.media.impl.sMediaDBVersionSerializer;
import de.esolutions.fw.comm.asi.diagnosis.media.impl.sMediaRegionCodesSerializer;
import de.esolutions.fw.comm.asi.diagnosis.media.impl.sMediaTypeOpticalDriveSerializer;
import de.esolutions.fw.comm.asi.diagnosis.media.impl.sPmlStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.media.impl.sUsbOvercurrentSerializer;
import de.esolutions.fw.comm.asi.diagnosis.media.sActiveMediaSourceState;
import de.esolutions.fw.comm.asi.diagnosis.media.sDTCPState;
import de.esolutions.fw.comm.asi.diagnosis.media.sMediaDBVersion;
import de.esolutions.fw.comm.asi.diagnosis.media.sMediaRegionCodes;
import de.esolutions.fw.comm.asi.diagnosis.media.sMediaTypeOpticalDrive;
import de.esolutions.fw.comm.asi.diagnosis.media.sPmlState;
import de.esolutions.fw.comm.asi.diagnosis.media.sUsbOvercurrent;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2MediaDiagService;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2MediaDiagServiceC;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2MediaDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2MediaDiagServiceProxy
implements MMX2MediaDiagService,
MMX2MediaDiagServiceC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2MediaDiagService");
    private Proxy proxy;

    public MMX2MediaDiagServiceProxy(int n, MMX2MediaDiagServiceReply mMX2MediaDiagServiceReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("a99c34a4-b437-42f3-89c0-ac0cee7d9eed", n, "90b1f04c-32af-51b8-b1a2-aedf7704b6ce", "asi.diagnosis.mmx2app.MMX2MediaDiagService");
        MMX2MediaDiagServiceReplyService mMX2MediaDiagServiceReplyService = new MMX2MediaDiagServiceReplyService(mMX2MediaDiagServiceReply);
        this.proxy = new Proxy(serviceInstanceID, mMX2MediaDiagServiceReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void responseErrorMedia(final sClientResponseError sClientResponseError2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sClientResponseErrorSerializer.putOptionalsClientResponseError(iSerializer, sClientResponseError2);
            }
        };
        this.proxy.remoteCallMethod((short)42, iSerializable);
    }

    public void responseSubsystemState(final sSubsystemState sSubsystemState2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sSubsystemStateSerializer.putOptionalsSubsystemState(iSerializer, sSubsystemState2);
            }
        };
        this.proxy.remoteCallMethod((short)34, iSerializable);
    }

    public void responseMediaDBVersion(final sMediaDBVersion sMediaDBVersion2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sMediaDBVersionSerializer.putOptionalsMediaDBVersion(iSerializer, sMediaDBVersion2);
            }
        };
        this.proxy.remoteCallMethod((short)8, iSerializable);
    }

    public void responseActiveMediaSourceState(final sActiveMediaSourceState sActiveMediaSourceState2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sActiveMediaSourceStateSerializer.putOptionalsActiveMediaSourceState(iSerializer, sActiveMediaSourceState2);
            }
        };
        this.proxy.remoteCallMethod((short)6, iSerializable);
    }

    public void responseMediaRegionCodes(final sMediaRegionCodes sMediaRegionCodes2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sMediaRegionCodesSerializer.putOptionalsMediaRegionCodes(iSerializer, sMediaRegionCodes2);
            }
        };
        this.proxy.remoteCallMethod((short)9, iSerializable);
    }

    public void responseMediaTypeOpticalDrive(final sMediaTypeOpticalDrive sMediaTypeOpticalDrive2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sMediaTypeOpticalDriveSerializer.putOptionalsMediaTypeOpticalDrive(iSerializer, sMediaTypeOpticalDrive2);
            }
        };
        this.proxy.remoteCallMethod((short)29, iSerializable);
    }

    public void responseUsbOvercurrent(final sUsbOvercurrent sUsbOvercurrent2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sUsbOvercurrentSerializer.putOptionalsUsbOvercurrent(iSerializer, sUsbOvercurrent2);
            }
        };
        this.proxy.remoteCallMethod((short)17, iSerializable);
    }

    public void responsePmlState(final sPmlState sPmlState2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sPmlStateSerializer.putOptionalsPmlState(iSerializer, sPmlState2);
            }
        };
        this.proxy.remoteCallMethod((short)33, iSerializable);
    }

    public void responseSparePartNumberMediaDB(final sSparePartNumber sSparePartNumber2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sSparePartNumberSerializer.putOptionalsSparePartNumber(iSerializer, sSparePartNumber2);
            }
        };
        this.proxy.remoteCallMethod((short)36, iSerializable);
    }

    public void responseApplicationSoftwareVersionNumberMediaDB(final sApplicationSoftwareVersionNumber sApplicationSoftwareVersionNumber2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sApplicationSoftwareVersionNumberSerializer.putOptionalsApplicationSoftwareVersionNumber(iSerializer, sApplicationSoftwareVersionNumber2);
            }
        };
        this.proxy.remoteCallMethod((short)22, iSerializable);
    }

    public void responseSerialNumberMediaDB(final sSerialNumber sSerialNumber2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sSerialNumberSerializer.putOptionalsSerialNumber(iSerializer, sSerialNumber2);
            }
        };
        this.proxy.remoteCallMethod((short)25, iSerializable);
    }

    public void responseSystemNameMediaDB(final sSystemName sSystemName2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sSystemNameSerializer.putOptionalsSystemName(iSerializer, sSystemName2);
            }
        };
        this.proxy.remoteCallMethod((short)26, iSerializable);
    }

    public void responseStatusUSBCommunication(long l, int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
            genericSerializable.putEnum(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)40, genericSerializable);
    }

    public void responseUSBHubIdentification(long l, short[] sArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
            genericSerializable.putOptionalUInt8VarArray(sArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)41, genericSerializable);
    }

    public void responseDTCPEncryptionState(final long l, final sDTCPState[] sDTCPStateArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putUInt32(l);
                sDTCPStateSerializer.putOptionalsDTCPStateVarArray(iSerializer, sDTCPStateArray);
            }
        };
        this.proxy.remoteCallMethod((short)50, iSerializable);
    }

    public void responseDTCPKeytypeMMX(long l, int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
            genericSerializable.putEnum(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)51, genericSerializable);
    }

    public void responseDTCPSRMInfo(long l, short s, int n, int n2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
            genericSerializable.putUInt8(s);
            genericSerializable.putUInt16(n);
            genericSerializable.putUInt16(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)52, genericSerializable);
    }
}

