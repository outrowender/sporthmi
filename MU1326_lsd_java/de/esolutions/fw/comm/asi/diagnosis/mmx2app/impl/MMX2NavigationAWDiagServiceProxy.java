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
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sSystemNameSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sApplicationSoftwareVersionNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sHardwareNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sHardwareVersionNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sRoutineResponse;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSerialNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSparePartNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSystemName;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2NavigationAWDiagService;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2NavigationAWDiagServiceC;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2NavigationAWDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceReplyService;
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
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.impl.sAntennaStateDSRCSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.impl.sAntennaStateVICSSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.impl.sInfraredBeaconStateVICSSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.impl.sRadioBeaconStateVICSSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.impl.sSubsystemStatesSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.impl.sUnitStateDSRCSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.sAntennaStateDSRC;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.sAntennaStateVICS;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.sInfraredBeaconStateVICS;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.sRadioBeaconStateVICS;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.sSubsystemStates;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.sUnitStateDSRC;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2NavigationAWDiagServiceProxy
implements MMX2NavigationAWDiagService,
MMX2NavigationAWDiagServiceC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2NavigationAWDiagService");
    private Proxy proxy;

    public MMX2NavigationAWDiagServiceProxy(int n, MMX2NavigationAWDiagServiceReply mMX2NavigationAWDiagServiceReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("55ad22a1-cc94-4954-a4b5-26b3aa66a601", n, "0465a088-2c21-52dd-9089-0d4a3c078909", "asi.diagnosis.mmx2app.MMX2NavigationAWDiagService");
        MMX2NavigationAWDiagServiceReplyService mMX2NavigationAWDiagServiceReplyService = new MMX2NavigationAWDiagServiceReplyService(mMX2NavigationAWDiagServiceReply);
        this.proxy = new Proxy(serviceInstanceID, mMX2NavigationAWDiagServiceReplyService, context);
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
        this.proxy.remoteCallMethod((short)47, iSerializable);
    }

    public void responseSubsystemStates(final sSubsystemStates sSubsystemStates2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sSubsystemStatesSerializer.putOptionalsSubsystemStates(iSerializer, sSubsystemStates2);
            }
        };
        this.proxy.remoteCallMethod((short)37, iSerializable);
    }

    public void responseVersionsNavDB(final sVersionsNavDB sVersionsNavDB2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sVersionsNavDBSerializer.putOptionalsVersionsNavDB(iSerializer, sVersionsNavDB2);
            }
        };
        this.proxy.remoteCallMethod((short)40, iSerializable);
    }

    public void responseActiveNavDB(final sActiveNavDB sActiveNavDB2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sActiveNavDBSerializer.putOptionalsActiveNavDB(iSerializer, sActiveNavDB2);
            }
        };
        this.proxy.remoteCallMethod((short)20, iSerializable);
    }

    public void responseGPSNoSatellite(final sGPSNoSatellite sGPSNoSatellite2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sGPSNoSatelliteSerializer.putOptionalsGPSNoSatellite(iSerializer, sGPSNoSatellite2);
            }
        };
        this.proxy.remoteCallMethod((short)25, iSerializable);
    }

    public void responseGPSOffroad(final sGPSOffroad sGPSOffroad2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sGPSOffroadSerializer.putOptionalsGPSOffroad(iSerializer, sGPSOffroad2);
            }
        };
        this.proxy.remoteCallMethod((short)26, iSerializable);
    }

    public void responseNavCalibrationState(final sNavCalibrationState sNavCalibrationState2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sNavCalibrationStateSerializer.putOptionalsNavCalibrationState(iSerializer, sNavCalibrationState2);
            }
        };
        this.proxy.remoteCallMethod((short)30, iSerializable);
    }

    public void responseNavCorrectedPosition(final sNavCorrectedPosition sNavCorrectedPosition2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sNavCorrectedPositionSerializer.putOptionalsNavCorrectedPosition(iSerializer, sNavCorrectedPosition2);
            }
        };
        this.proxy.remoteCallMethod((short)32, iSerializable);
    }

    public void responseNavCorrectedDirection(final sNavCorrectedDirection sNavCorrectedDirection2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sNavCorrectedDirectionSerializer.putOptionalsNavCorrectedDirection(iSerializer, sNavCorrectedDirection2);
            }
        };
        this.proxy.remoteCallMethod((short)31, iSerializable);
    }

    public void responseUnitStateDSRC(final sUnitStateDSRC sUnitStateDSRC2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sUnitStateDSRCSerializer.putOptionalsUnitStateDSRC(iSerializer, sUnitStateDSRC2);
            }
        };
        this.proxy.remoteCallMethod((short)41, iSerializable);
    }

    public void responseAntennaStateDSRC(final sAntennaStateDSRC sAntennaStateDSRC2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sAntennaStateDSRCSerializer.putOptionalsAntennaStateDSRC(iSerializer, sAntennaStateDSRC2);
            }
        };
        this.proxy.remoteCallMethod((short)21, iSerializable);
    }

    public void responseAntennaStateVICS(final sAntennaStateVICS sAntennaStateVICS2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sAntennaStateVICSSerializer.putOptionalsAntennaStateVICS(iSerializer, sAntennaStateVICS2);
            }
        };
        this.proxy.remoteCallMethod((short)22, iSerializable);
    }

    public void responseRadioBeaconStateVICS(final sRadioBeaconStateVICS sRadioBeaconStateVICS2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sRadioBeaconStateVICSSerializer.putOptionalsRadioBeaconStateVICS(iSerializer, sRadioBeaconStateVICS2);
            }
        };
        this.proxy.remoteCallMethod((short)33, iSerializable);
    }

    public void responseInfraredBeaconStateVICS(final sInfraredBeaconStateVICS sInfraredBeaconStateVICS2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sInfraredBeaconStateVICSSerializer.putOptionalsInfraredBeaconStateVICS(iSerializer, sInfraredBeaconStateVICS2);
            }
        };
        this.proxy.remoteCallMethod((short)29, iSerializable);
    }

    public void responseResetCalibration(final sRoutineResponse sRoutineResponse2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sRoutineResponseSerializer.putOptionalsRoutineResponse(iSerializer, sRoutineResponse2);
            }
        };
        this.proxy.remoteCallMethod((short)34, iSerializable);
    }

    public void responseSparePartNumber(final sSparePartNumber sSparePartNumber2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sSparePartNumberSerializer.putOptionalsSparePartNumber(iSerializer, sSparePartNumber2);
            }
        };
        this.proxy.remoteCallMethod((short)36, iSerializable);
    }

    public void responseApplicationSoftwareVersionNumber(final sApplicationSoftwareVersionNumber sApplicationSoftwareVersionNumber2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sApplicationSoftwareVersionNumberSerializer.putOptionalsApplicationSoftwareVersionNumber(iSerializer, sApplicationSoftwareVersionNumber2);
            }
        };
        this.proxy.remoteCallMethod((short)23, iSerializable);
    }

    public void responseHardwareNumber(final sHardwareNumber sHardwareNumber2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sHardwareNumberSerializer.putOptionalsHardwareNumber(iSerializer, sHardwareNumber2);
            }
        };
        this.proxy.remoteCallMethod((short)27, iSerializable);
    }

    public void responseHardwareVersionNumber(final sHardwareVersionNumber sHardwareVersionNumber2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sHardwareVersionNumberSerializer.putOptionalsHardwareVersionNumber(iSerializer, sHardwareVersionNumber2);
            }
        };
        this.proxy.remoteCallMethod((short)28, iSerializable);
    }

    public void responseSerialNumber(final sSerialNumber sSerialNumber2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sSerialNumberSerializer.putOptionalsSerialNumber(iSerializer, sSerialNumber2);
            }
        };
        this.proxy.remoteCallMethod((short)35, iSerializable);
    }

    public void responseSystemName(final sSystemName sSystemName2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sSystemNameSerializer.putOptionalsSystemName(iSerializer, sSystemName2);
            }
        };
        this.proxy.remoteCallMethod((short)38, iSerializable);
    }

    public void responseCountryRegionVersion(final sNavCountryRegionVersion sNavCountryRegionVersion2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sNavCountryRegionVersionSerializer.putOptionalsNavCountryRegionVersion(iSerializer, sNavCountryRegionVersion2);
            }
        };
        this.proxy.remoteCallMethod((short)46, iSerializable);
    }

    public void responseDeleteMemory(final sRoutineResponse sRoutineResponse2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sRoutineResponseSerializer.putOptionalsRoutineResponse(iSerializer, sRoutineResponse2);
            }
        };
        this.proxy.remoteCallMethod((short)43, iSerializable);
    }
}

