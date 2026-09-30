/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.caraircondition.DSICarAirCondition;
import de.esolutions.fw.comm.dsi.caraircondition.DSICarAirConditionC;
import de.esolutions.fw.comm.dsi.caraircondition.DSICarAirConditionReply;
import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconAirDistributionSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconAirVolumeSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconBCMeasuresConfigurationSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconBlowerCompensationSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconContentSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconFreshAirConfigurationSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconNozzleListRecordSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconPureAirSetupSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconSteeringWheelHeaterSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconSynchronisationSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconTempSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.DSICarAirConditionReplyService;
import de.esolutions.fw.comm.dsi.global.impl.CarArrayListUpdateInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.caraircondition.AirconAirDistribution;
import org.dsi.ifc.caraircondition.AirconAirVolume;
import org.dsi.ifc.caraircondition.AirconBCMeasuresConfiguration;
import org.dsi.ifc.caraircondition.AirconBlowerCompensation;
import org.dsi.ifc.caraircondition.AirconContent;
import org.dsi.ifc.caraircondition.AirconFreshAirConfiguration;
import org.dsi.ifc.caraircondition.AirconNozzleListRecord;
import org.dsi.ifc.caraircondition.AirconPureAirSetup;
import org.dsi.ifc.caraircondition.AirconSteeringWheelHeater;
import org.dsi.ifc.caraircondition.AirconSynchronisation;
import org.dsi.ifc.caraircondition.AirconTemp;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public class DSICarAirConditionProxy
implements DSICarAirCondition,
DSICarAirConditionC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.caraircondition.DSICarAirCondition");
    private Proxy proxy;

    public DSICarAirConditionProxy(int n, DSICarAirConditionReply dSICarAirConditionReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("5bd0c4d1-7601-59a2-a47a-293eb5eb76b8", n, "cf30a335-1e95-5df1-81d1-e5ebf39a5f7b", "dsi.caraircondition.DSICarAirCondition");
        DSICarAirConditionReplyService dSICarAirConditionReplyService = new DSICarAirConditionReplyService(dSICarAirConditionReply);
        this.proxy = new Proxy(serviceInstanceID, dSICarAirConditionReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void setAirconAirCirculationMan(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)10, genericSerializable);
    }

    public void setAirconAirCirculationAuto(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)9, genericSerializable);
    }

    public void setAirconMiddleExhaustion(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)23, genericSerializable);
    }

    public void setAirconRearWindowHeater(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)27, genericSerializable);
    }

    public void setAirconIndirectVentilation(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)22, genericSerializable);
    }

    public void setAirconPopupTime(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)24, genericSerializable);
    }

    public void setAirconHeater(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)21, genericSerializable);
    }

    public void setAirconRearAuxHeater(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)25, genericSerializable);
    }

    public void setAirconFrontWindowHeater(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)18, genericSerializable);
    }

    public void setAirconDefrost(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)16, genericSerializable);
    }

    public void setAirconMaxDefrost(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)110, genericSerializable);
    }

    public void setAirconSolar(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)32, genericSerializable);
    }

    public void setAirconAC(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)8, genericSerializable);
    }

    public void setAirconMaxAC(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)109, genericSerializable);
    }

    public void setAirconEcoAC(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)141, genericSerializable);
    }

    public void setAirconRearControl(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)26, genericSerializable);
    }

    public void setAirconRearControlFondPlus(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)143, genericSerializable);
    }

    public void setAirconSteeringWheelHeater(final AirconSteeringWheelHeater airconSteeringWheelHeater) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                AirconSteeringWheelHeaterSerializer.putOptionalAirconSteeringWheelHeater(iSerializer, airconSteeringWheelHeater);
            }
        };
        this.proxy.remoteCallMethod((short)113, iSerializable);
    }

    public void setAirconFrontWindowHeaterAuto(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)19, genericSerializable);
    }

    public void setAirconBlowerCompensation(final AirconBlowerCompensation airconBlowerCompensation) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                AirconBlowerCompensationSerializer.putOptionalAirconBlowerCompensation(iSerializer, airconBlowerCompensation);
            }
        };
        this.proxy.remoteCallMethod((short)137, iSerializable);
    }

    public void setAirconSynchronisation(final AirconSynchronisation airconSynchronisation) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                AirconSynchronisationSerializer.putOptionalAirconSynchronisation(iSerializer, airconSynchronisation);
            }
        };
        this.proxy.remoteCallMethod((short)145, iSerializable);
    }

    public void setAirconSuppressVisualisation(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)35, genericSerializable);
    }

    public void setAirconSystemOnOffRow(int n, boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)195, genericSerializable);
    }

    public void setAirconAirCirculationSensitivity(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }

    public void setAirconResidualHeat(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)28, genericSerializable);
    }

    public void showAirconPopup(final AirconContent airconContent) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                AirconContentSerializer.putOptionalAirconContent(iSerializer, airconContent);
            }
        };
        this.proxy.remoteCallMethod((short)196, iSerializable);
    }

    public void cancelAirconPopup(final AirconContent airconContent, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                AirconContentSerializer.putOptionalAirconContent(iSerializer, airconContent);
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)169, iSerializable);
    }

    public void setAirconContent(final AirconContent airconContent) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                AirconContentSerializer.putOptionalAirconContent(iSerializer, airconContent);
            }
        };
        this.proxy.remoteCallMethod((short)179, iSerializable);
    }

    public void setAirconTempZone(final int n, final AirconTemp airconTemp) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                AirconTempSerializer.putOptionalAirconTemp(iSerializer, airconTemp);
            }
        };
        this.proxy.remoteCallMethod((short)40, iSerializable);
    }

    public void setAirconAirVolume(final int n, final AirconAirVolume airconAirVolume) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                AirconAirVolumeSerializer.putOptionalAirconAirVolume(iSerializer, airconAirVolume);
            }
        };
        this.proxy.remoteCallMethod((short)13, iSerializable);
    }

    public void setAirconAirDistribution(final int n, final AirconAirDistribution airconAirDistribution) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                AirconAirDistributionSerializer.putOptionalAirconAirDistribution(iSerializer, airconAirDistribution);
            }
        };
        this.proxy.remoteCallMethod((short)175, iSerializable);
    }

    public void setAirconFootwellTemp(int n, int n2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)17, genericSerializable);
    }

    public void setAirconSeatHeater(int n, int n2, int n3) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)281, genericSerializable);
    }

    public void setAirconSeatVentilation(int n, int n2, int n3) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)282, genericSerializable);
    }

    public void setAirconHMIIsReady(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)20, genericSerializable);
    }

    public void setAirconSeatHeaterDistribution(int n, int n2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)111, genericSerializable);
    }

    public void setAirconSeatVentilationDistribution(int n, int n2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)112, genericSerializable);
    }

    public void setAirconTempStep(int n, int n2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)114, genericSerializable);
    }

    public void setAirconClimateStyle(int n, int n2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)178, genericSerializable);
    }

    public void setAirconSetFactoryDefaultMaster() throws MethodException {
        this.proxy.remoteCallMethod((short)192, null);
    }

    public void setAirconSetFactoryDefaultRow(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)193, genericSerializable);
    }

    public void setAirconNozzleControlRow1(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)183, genericSerializable);
    }

    public void setAirconNozzleControlRow2(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)184, genericSerializable);
    }

    public void setAirconNozzleControlRow3(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)185, genericSerializable);
    }

    public void requestAirconNozzleListRow(final int n, final CarArrayListUpdateInfo carArrayListUpdateInfo) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                CarArrayListUpdateInfoSerializer.putOptionalCarArrayListUpdateInfo(iSerializer, carArrayListUpdateInfo);
            }
        };
        this.proxy.remoteCallMethod((short)170, iSerializable);
    }

    public void setAirconNozzleListRow(final int n, final CarArrayListUpdateInfo carArrayListUpdateInfo, final AirconNozzleListRecord[] airconNozzleListRecordArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                CarArrayListUpdateInfoSerializer.putOptionalCarArrayListUpdateInfo(iSerializer, carArrayListUpdateInfo);
                AirconNozzleListRecordSerializer.putOptionalAirconNozzleListRecordVarArray(iSerializer, airconNozzleListRecordArray);
            }
        };
        this.proxy.remoteCallMethod((short)186, iSerializable);
    }

    public void setAirconSideWindowDefrost(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)194, genericSerializable);
    }

    public void setAirconPureAir(final AirconPureAirSetup airconPureAirSetup) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                AirconPureAirSetupSerializer.putOptionalAirconPureAirSetup(iSerializer, airconPureAirSetup);
            }
        };
        this.proxy.remoteCallMethod((short)187, iSerializable);
    }

    public void setAirconFreshAirConfig(final AirconFreshAirConfiguration airconFreshAirConfiguration) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                AirconFreshAirConfigurationSerializer.putOptionalAirconFreshAirConfiguration(iSerializer, airconFreshAirConfiguration);
            }
        };
        this.proxy.remoteCallMethod((short)180, iSerializable);
    }

    public void setAirconAirQuality(int n, int n2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)176, genericSerializable);
    }

    public void setAirconSeatNeckHeater(int n, boolean bl, int n2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putBool(bl);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)189, genericSerializable);
    }

    public void setAirconSeatSurfaceHeater(int n, boolean bl, boolean bl2, int n2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putBool(bl);
            genericSerializable.putBool(bl2);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)190, genericSerializable);
    }

    public void setAirconIndividualClimatisation(int n, boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)181, genericSerializable);
    }

    public void setAirconIonisator(int n, int n2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)280, genericSerializable);
    }

    public void setAirconBodyCloseMeasures(final int n, final boolean bl, final AirconBCMeasuresConfiguration airconBCMeasuresConfiguration) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putBool(bl);
                AirconBCMeasuresConfigurationSerializer.putOptionalAirconBCMeasuresConfiguration(iSerializer, airconBCMeasuresConfiguration);
            }
        };
        this.proxy.remoteCallMethod((short)177, iSerializable);
    }

    public void setNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)42, genericSerializable);
    }

    public void setNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)43, genericSerializable);
    }

    public void setNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)41, null);
    }

    public void clearNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    public void clearNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    public void clearNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)4, null);
    }

    public void yySet(String string, String string2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)108, genericSerializable);
    }
}

