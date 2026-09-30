/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sApplicationSoftwareVersionNumberSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sClientResponseErrorSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sHardwareNumberSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sHardwareVersionNumberSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sRoutineResponseSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sSerialNumberSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sSparePartNumberSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sSubsystemStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sSystemNameSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sApplicationSoftwareVersionNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sHardwareNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sHardwareVersionNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sRoutineResponse;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSerialNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSparePartNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSubsystemState;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSystemName;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2NavigationDiagService;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2NavigationDiagServiceC;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2NavigationDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceReplyService;
import de.esolutions.fw.comm.asi.diagnosis.navigation.impl.sActiveNavDBSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigation.impl.sGPSNoSatelliteSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigation.impl.sGPSOffroadSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigation.impl.sNavCalibrationStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigation.impl.sNavCorrectedDirectionSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigation.impl.sNavCorrectedPositionSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigation.impl.sNavCountryRegionVersionSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigation.impl.sVersionsNavDBSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sActiveNavDB;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sGPSNoSatellite;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sGPSOffroad;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCalibrationState;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCorrectedDirection;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCorrectedPosition;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCountryRegionVersion;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sVersionsNavDB;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2NavigationDiagServiceProxy
implements MMX2NavigationDiagService,
MMX2NavigationDiagServiceC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2NavigationDiagService");
    private Proxy proxy;

    public MMX2NavigationDiagServiceProxy(int n, MMX2NavigationDiagServiceReply mMX2NavigationDiagServiceReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("3a0f97f7-4596-4e19-9184-8b0609943a55", n, "add52511-ec64-5161-8bcb-0540c6ab2e22", "asi.diagnosis.mmx2app.MMX2NavigationDiagService");
        MMX2NavigationDiagServiceReplyService mMX2NavigationDiagServiceReplyService = new MMX2NavigationDiagServiceReplyService(mMX2NavigationDiagServiceReply);
        this.proxy = new Proxy(serviceInstanceID, mMX2NavigationDiagServiceReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void responseErrorNavigation(final sClientResponseError sClientResponseError2) throws MethodException {
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
        this.proxy.remoteCallMethod((short)38, iSerializable);
    }

    public void responseVersionsNavDB(final sVersionsNavDB sVersionsNavDB2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sVersionsNavDBSerializer.putOptionalsVersionsNavDB(iSerializer, sVersionsNavDB2);
            }
        };
        this.proxy.remoteCallMethod((short)16, iSerializable);
    }

    public void responseActiveNavDB(final sActiveNavDB sActiveNavDB2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sActiveNavDBSerializer.putOptionalsActiveNavDB(iSerializer, sActiveNavDB2);
            }
        };
        this.proxy.remoteCallMethod((short)8, iSerializable);
    }

    public void responseGPSNoSatellite(final sGPSNoSatellite sGPSNoSatellite2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sGPSNoSatelliteSerializer.putOptionalsGPSNoSatellite(iSerializer, sGPSNoSatellite2);
            }
        };
        this.proxy.remoteCallMethod((short)10, iSerializable);
    }

    public void responseGPSOffroad(final sGPSOffroad sGPSOffroad2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sGPSOffroadSerializer.putOptionalsGPSOffroad(iSerializer, sGPSOffroad2);
            }
        };
        this.proxy.remoteCallMethod((short)11, iSerializable);
    }

    public void responseNavCalibrationState(final sNavCalibrationState sNavCalibrationState2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sNavCalibrationStateSerializer.putOptionalsNavCalibrationState(iSerializer, sNavCalibrationState2);
            }
        };
        this.proxy.remoteCallMethod((short)12, iSerializable);
    }

    public void responseNavCorrectedPosition(final sNavCorrectedPosition sNavCorrectedPosition2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sNavCorrectedPositionSerializer.putOptionalsNavCorrectedPosition(iSerializer, sNavCorrectedPosition2);
            }
        };
        this.proxy.remoteCallMethod((short)20, iSerializable);
    }

    public void responseNavCorrectedDirection(final sNavCorrectedDirection sNavCorrectedDirection2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sNavCorrectedDirectionSerializer.putOptionalsNavCorrectedDirection(iSerializer, sNavCorrectedDirection2);
            }
        };
        this.proxy.remoteCallMethod((short)13, iSerializable);
    }

    public void responseResetCalibration(final sRoutineResponse sRoutineResponse2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sRoutineResponseSerializer.putOptionalsRoutineResponse(iSerializer, sRoutineResponse2);
            }
        };
        this.proxy.remoteCallMethod((short)32, iSerializable);
    }

    public void responseSparePartNumberNavDB(final sSparePartNumber sSparePartNumber2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sSparePartNumberSerializer.putOptionalsSparePartNumber(iSerializer, sSparePartNumber2);
            }
        };
        this.proxy.remoteCallMethod((short)34, iSerializable);
    }

    public void responseApplicationSoftwareVersionNumberNavDB(final sApplicationSoftwareVersionNumber sApplicationSoftwareVersionNumber2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sApplicationSoftwareVersionNumberSerializer.putOptionalsApplicationSoftwareVersionNumber(iSerializer, sApplicationSoftwareVersionNumber2);
            }
        };
        this.proxy.remoteCallMethod((short)28, iSerializable);
    }

    public void responseHardwareNumberNavDB(final sHardwareNumber sHardwareNumber2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sHardwareNumberSerializer.putOptionalsHardwareNumber(iSerializer, sHardwareNumber2);
            }
        };
        this.proxy.remoteCallMethod((short)30, iSerializable);
    }

    public void responseHardwareVersionNumberNavDB(final sHardwareVersionNumber sHardwareVersionNumber2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sHardwareVersionNumberSerializer.putOptionalsHardwareVersionNumber(iSerializer, sHardwareVersionNumber2);
            }
        };
        this.proxy.remoteCallMethod((short)31, iSerializable);
    }

    public void responseSerialNumberNavDB(final sSerialNumber sSerialNumber2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sSerialNumberSerializer.putOptionalsSerialNumber(iSerializer, sSerialNumber2);
            }
        };
        this.proxy.remoteCallMethod((short)33, iSerializable);
    }

    public void responseSystemNameNavDB(final sSystemName sSystemName2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sSystemNameSerializer.putOptionalsSystemName(iSerializer, sSystemName2);
            }
        };
        this.proxy.remoteCallMethod((short)35, iSerializable);
    }

    public void responseCountryRegionVersion(final sNavCountryRegionVersion sNavCountryRegionVersion2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sNavCountryRegionVersionSerializer.putOptionalsNavCountryRegionVersion(iSerializer, sNavCountryRegionVersion2);
            }
        };
        this.proxy.remoteCallMethod((short)41, iSerializable);
    }
}

