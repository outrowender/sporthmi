/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carkombi.DSICarKombi;
import de.esolutions.fw.comm.dsi.carkombi.DSICarKombiC;
import de.esolutions.fw.comm.dsi.carkombi.DSICarKombiReply;
import de.esolutions.fw.comm.dsi.carkombi.impl.BCMenueConfigurationSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.BCSpeedWarningSettingsSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.BCStatisticsResetSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.BCVehicleStateUpdateInfoAHSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DCAdditionalInstrument2Serializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DCAdditionalInstrumentSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DCDisplayDependencySerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DCDisplayPresetsListRecordSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DCDisplayViewConfigurationSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DCElementContentSelectionListRA1Serializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DCElementContentSelectionListRA2Serializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DCElementContentSelectionListUpdateInfoSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DCMainItemsSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiReplyService;
import de.esolutions.fw.comm.dsi.carkombi.impl.HUDCollectiveTopicsSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.HUDContentSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.HUDSectionConfigListRecordSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarArrayListUpdateInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carkombi.BCMenueConfiguration;
import org.dsi.ifc.carkombi.BCSpeedWarningSettings;
import org.dsi.ifc.carkombi.BCStatisticsReset;
import org.dsi.ifc.carkombi.BCVehicleStateUpdateInfoAH;
import org.dsi.ifc.carkombi.DCAdditionalInstrument;
import org.dsi.ifc.carkombi.DCAdditionalInstrument2;
import org.dsi.ifc.carkombi.DCDisplayDependency;
import org.dsi.ifc.carkombi.DCDisplayPresetsListRecord;
import org.dsi.ifc.carkombi.DCDisplayViewConfiguration;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA1;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA2;
import org.dsi.ifc.carkombi.DCElementContentSelectionListUpdateInfo;
import org.dsi.ifc.carkombi.DCMainItems;
import org.dsi.ifc.carkombi.HUDCollectiveTopics;
import org.dsi.ifc.carkombi.HUDContent;
import org.dsi.ifc.carkombi.HUDSectionConfigListRecord;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public class DSICarKombiProxy
implements DSICarKombi,
DSICarKombiC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.carkombi.DSICarKombi");
    private Proxy proxy;

    public DSICarKombiProxy(int n, DSICarKombiReply dSICarKombiReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("2134aec9-b386-5e87-ba1a-0c71e46a44b4", n, "055e4089-6e85-5d64-8e84-a31fb50a2501", "dsi.carkombi.DSICarKombi");
        DSICarKombiReplyService dSICarKombiReplyService = new DSICarKombiReplyService(dSICarKombiReply);
        this.proxy = new Proxy(serviceInstanceID, dSICarKombiReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void resetSIAValue(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }

    public void requestSIAHistoryList(final CarArrayListUpdateInfo carArrayListUpdateInfo) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                CarArrayListUpdateInfoSerializer.putOptionalCarArrayListUpdateInfo(iSerializer, carArrayListUpdateInfo);
            }
        };
        this.proxy.remoteCallMethod((short)188, iSerializable);
    }

    public void setSIADistanceOilUser(int n, int n2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)205, genericSerializable);
    }

    public void setSIADistanceAirFilterUser(int n, int n2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)203, genericSerializable);
    }

    public void setSIADistanceOilFilterUser(int n, int n2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)204, genericSerializable);
    }

    public void setSIAInspectionDistanceUser(int n, int n2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)206, genericSerializable);
    }

    public void setBCVZADisplay(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)27, genericSerializable);
    }

    public void setBCLifeTipsDisplay(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)21, genericSerializable);
    }

    public void setBCConsumerDisplay(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)18, genericSerializable);
    }

    public void setBCMenueConfig(final BCMenueConfiguration bCMenueConfiguration, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                BCMenueConfigurationSerializer.putOptionalBCMenueConfiguration(iSerializer, bCMenueConfiguration);
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)111, iSerializable);
    }

    public void resetBCMenue(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)9, genericSerializable);
    }

    public void setBCOilTemperature(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)23, genericSerializable);
    }

    public void setBCDigitalSpeed(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)19, genericSerializable);
    }

    public void setBCStopwatch(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)26, genericSerializable);
    }

    public void setBCVzaMFA(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)28, genericSerializable);
    }

    public void setBCSpeedWarning(final BCSpeedWarningSettings bCSpeedWarningSettings) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                BCSpeedWarningSettingsSerializer.putOptionalBCSpeedWarningSettings(iSerializer, bCSpeedWarningSettings);
            }
        };
        this.proxy.remoteCallMethod((short)25, iSerializable);
    }

    public void setBCGearRecommendation(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)20, genericSerializable);
    }

    public void setBCRearSeatbeltWarning(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)24, genericSerializable);
    }

    public void requestVehicleStateList(final BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                BCVehicleStateUpdateInfoAHSerializer.putOptionalBCVehicleStateUpdateInfoAH(iSerializer, bCVehicleStateUpdateInfoAH);
            }
        };
        this.proxy.remoteCallMethod((short)143, iSerializable);
    }

    public void setBcSetFactoryDefault() throws MethodException {
        this.proxy.remoteCallMethod((short)29, null);
    }

    public void resetBCStatistics(final BCStatisticsReset bCStatisticsReset) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                BCStatisticsResetSerializer.putOptionalBCStatisticsReset(iSerializer, bCStatisticsReset);
            }
        };
        this.proxy.remoteCallMethod((short)10, iSerializable);
    }

    public void setBCAstaMFA(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)171, genericSerializable);
    }

    public void setHUDHeightAdjustment(byte by) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt8(by);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)32, genericSerializable);
    }

    public void setHUDBrightness(byte by) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt8(by);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)30, genericSerializable);
    }

    public void setHUDContent(final HUDContent hUDContent) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                HUDContentSerializer.putOptionalHUDContent(iSerializer, hUDContent);
            }
        };
        this.proxy.remoteCallMethod((short)236, iSerializable);
    }

    public void setHUDRotationAdjustment(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)105, genericSerializable);
    }

    public void setHUDColour(int n, int n2) throws MethodException {
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

    public void setHUDSetFactoryDefault() throws MethodException {
        this.proxy.remoteCallMethod((short)113, null);
    }

    public void setHUDSystemOnOff(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)114, genericSerializable);
    }

    public void setHUDPresets(int n, int n2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)237, genericSerializable);
    }

    public void setHUDCollectiveTopics(final HUDCollectiveTopics hUDCollectiveTopics) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                HUDCollectiveTopicsSerializer.putOptionalHUDCollectiveTopics(iSerializer, hUDCollectiveTopics);
            }
        };
        this.proxy.remoteCallMethod((short)235, iSerializable);
    }

    public void setHUDAutoSkinSwitch(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)234, genericSerializable);
    }

    public void requestHUDSectionConfigList(final CarArrayListUpdateInfo carArrayListUpdateInfo) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                CarArrayListUpdateInfoSerializer.putOptionalCarArrayListUpdateInfo(iSerializer, carArrayListUpdateInfo);
            }
        };
        this.proxy.remoteCallMethod((short)232, iSerializable);
    }

    public void setHUDSectionConfigList(final CarArrayListUpdateInfo carArrayListUpdateInfo, final HUDSectionConfigListRecord[] hUDSectionConfigListRecordArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                CarArrayListUpdateInfoSerializer.putOptionalCarArrayListUpdateInfo(iSerializer, carArrayListUpdateInfo);
                HUDSectionConfigListRecordSerializer.putOptionalHUDSectionConfigListRecordVarArray(iSerializer, hUDSectionConfigListRecordArray);
            }
        };
        this.proxy.remoteCallMethod((short)238, iSerializable);
    }

    public void setDCSetFactoryDefault() throws MethodException {
        this.proxy.remoteCallMethod((short)158, null);
    }

    public void setDCBrightness(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)152, genericSerializable);
    }

    public void setDCVolume(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)159, genericSerializable);
    }

    public void setDCDisplay1MainSelection(final DCMainItems dCMainItems) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                DCMainItemsSerializer.putOptionalDCMainItems(iSerializer, dCMainItems);
            }
        };
        this.proxy.remoteCallMethod((short)194, iSerializable);
    }

    public void setDCDisplay2MainSelection(final DCMainItems dCMainItems) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                DCMainItemsSerializer.putOptionalDCMainItems(iSerializer, dCMainItems);
            }
        };
        this.proxy.remoteCallMethod((short)195, iSerializable);
    }

    public void setDCDisplay3MainSelection(final DCMainItems dCMainItems) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                DCMainItemsSerializer.putOptionalDCMainItems(iSerializer, dCMainItems);
            }
        };
        this.proxy.remoteCallMethod((short)196, iSerializable);
    }

    public void requestDCElementContentSelectionList(final DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                DCElementContentSelectionListUpdateInfoSerializer.putOptionalDCElementContentSelectionListUpdateInfo(iSerializer, dCElementContentSelectionListUpdateInfo);
            }
        };
        this.proxy.remoteCallMethod((short)142, iSerializable);
    }

    public void setDCElementContentSelectionListRA1(final DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, final DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                DCElementContentSelectionListUpdateInfoSerializer.putOptionalDCElementContentSelectionListUpdateInfo(iSerializer, dCElementContentSelectionListUpdateInfo);
                DCElementContentSelectionListRA1Serializer.putOptionalDCElementContentSelectionListRA1VarArray(iSerializer, dCElementContentSelectionListRA1Array);
            }
        };
        this.proxy.remoteCallMethod((short)156, iSerializable);
    }

    public void setDCElementContentSelectionListRA2(final DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, final DCElementContentSelectionListRA2[] dCElementContentSelectionListRA2Array) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                DCElementContentSelectionListUpdateInfoSerializer.putOptionalDCElementContentSelectionListUpdateInfo(iSerializer, dCElementContentSelectionListUpdateInfo);
                DCElementContentSelectionListRA2Serializer.putOptionalDCElementContentSelectionListRA2VarArray(iSerializer, dCElementContentSelectionListRA2Array);
            }
        };
        this.proxy.remoteCallMethod((short)200, iSerializable);
    }

    public void setDCElementContentSelectionListRAF(final DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, final int[] nArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                DCElementContentSelectionListUpdateInfoSerializer.putOptionalDCElementContentSelectionListUpdateInfo(iSerializer, dCElementContentSelectionListUpdateInfo);
                iSerializer.putOptionalInt32VarArray(nArray);
            }
        };
        this.proxy.remoteCallMethod((short)157, iSerializable);
    }

    public void setDCAdditionalInstrumentSetup(final DCAdditionalInstrument dCAdditionalInstrument) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                DCAdditionalInstrumentSerializer.putOptionalDCAdditionalInstrument(iSerializer, dCAdditionalInstrument);
            }
        };
        this.proxy.remoteCallMethod((short)172, iSerializable);
    }

    public void setDCAdditionalInstrument2Setup(final DCAdditionalInstrument2 dCAdditionalInstrument2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                DCAdditionalInstrument2Serializer.putOptionalDCAdditionalInstrument2(iSerializer, dCAdditionalInstrument2);
            }
        };
        this.proxy.remoteCallMethod((short)193, iSerializable);
    }

    public void requestDCDisplayPresetsList(final CarArrayListUpdateInfo carArrayListUpdateInfo) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                CarArrayListUpdateInfoSerializer.putOptionalCarArrayListUpdateInfo(iSerializer, carArrayListUpdateInfo);
            }
        };
        this.proxy.remoteCallMethod((short)187, iSerializable);
    }

    public void setDCDisplayPresetsList(final CarArrayListUpdateInfo carArrayListUpdateInfo, final DCDisplayPresetsListRecord[] dCDisplayPresetsListRecordArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                CarArrayListUpdateInfoSerializer.putOptionalCarArrayListUpdateInfo(iSerializer, carArrayListUpdateInfo);
                DCDisplayPresetsListRecordSerializer.putOptionalDCDisplayPresetsListRecordVarArray(iSerializer, dCDisplayPresetsListRecordArray);
            }
        };
        this.proxy.remoteCallMethod((short)198, iSerializable);
    }

    public void setDCDisplayDependencySetup(final DCDisplayDependency dCDisplayDependency) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                DCDisplayDependencySerializer.putOptionalDCDisplayDependency(iSerializer, dCDisplayDependency);
            }
        };
        this.proxy.remoteCallMethod((short)197, iSerializable);
    }

    public void setDCActiveDisplayPreset(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)192, genericSerializable);
    }

    public void setDCDisplayViewConfiguration(final DCDisplayViewConfiguration dCDisplayViewConfiguration) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                DCDisplayViewConfigurationSerializer.putOptionalDCDisplayViewConfiguration(iSerializer, dCDisplayViewConfiguration);
            }
        };
        this.proxy.remoteCallMethod((short)199, iSerializable);
    }

    public void setHUDLicense(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)202, genericSerializable);
    }

    public void setDCLEDConfiguration(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)201, genericSerializable);
    }

    public void setNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)34, genericSerializable);
    }

    public void setNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)35, genericSerializable);
    }

    public void setNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)33, null);
    }

    public void clearNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    public void clearNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    public void clearNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)3, null);
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
        this.proxy.remoteCallMethod((short)98, genericSerializable);
    }
}

