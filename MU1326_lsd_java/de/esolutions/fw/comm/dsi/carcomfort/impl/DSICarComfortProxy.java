/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carcomfort.DSICarComfort;
import de.esolutions.fw.comm.dsi.carcomfort.DSICarComfortC;
import de.esolutions.fw.comm.dsi.carcomfort.DSICarComfortReply;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortReplyService;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DoorLockingComfortOpenSettingsSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DoorLockingRearBlindSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DoorLockingTheftWarningSettingsSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DoorLockingUserListRA1Serializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DoorLockingUserListUpdateInfoSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DoorLockingUserProfileOnOffSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.RGSBeltPretensionDataSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.RGSLocalHazardInformationSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOButtonListRA0Serializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOButtonListRA1Serializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOButtonListRA2Serializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOButtonListRA3Serializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOButtonListRA4Serializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOButtonListRA5Serializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOButtonListUpdateInfoSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOContentSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDODestinationReachedSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOLearningDataSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOOpenDoorSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOSoftkeysSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOSynchronisationSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carcomfort.DoorLockingComfortOpenSettings;
import org.dsi.ifc.carcomfort.DoorLockingRearBlind;
import org.dsi.ifc.carcomfort.DoorLockingTheftWarningSettings;
import org.dsi.ifc.carcomfort.DoorLockingUserListRA1;
import org.dsi.ifc.carcomfort.DoorLockingUserListUpdateInfo;
import org.dsi.ifc.carcomfort.DoorLockingUserProfileOnOff;
import org.dsi.ifc.carcomfort.RGSBeltPretensionData;
import org.dsi.ifc.carcomfort.RGSLocalHazardInformation;
import org.dsi.ifc.carcomfort.UGDOButtonListRA0;
import org.dsi.ifc.carcomfort.UGDOButtonListRA1;
import org.dsi.ifc.carcomfort.UGDOButtonListRA2;
import org.dsi.ifc.carcomfort.UGDOButtonListRA3;
import org.dsi.ifc.carcomfort.UGDOButtonListRA4;
import org.dsi.ifc.carcomfort.UGDOButtonListRA5;
import org.dsi.ifc.carcomfort.UGDOButtonListUpdateInfo;
import org.dsi.ifc.carcomfort.UGDOContent;
import org.dsi.ifc.carcomfort.UGDODestinationReached;
import org.dsi.ifc.carcomfort.UGDOLearningData;
import org.dsi.ifc.carcomfort.UGDOOpenDoor;
import org.dsi.ifc.carcomfort.UGDOSoftkeys;
import org.dsi.ifc.carcomfort.UGDOSynchronisation;

public class DSICarComfortProxy
implements DSICarComfort,
DSICarComfortC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.carcomfort.DSICarComfort");
    private Proxy proxy;

    public DSICarComfortProxy(int n, DSICarComfortReply dSICarComfortReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("549029d4-de8f-5cec-a6b0-782619f5452c", n, "2b6d7626-e971-5290-a9c1-772b28f11f8f", "dsi.carcomfort.DSICarComfort");
        DSICarComfortReplyService dSICarComfortReplyService = new DSICarComfortReplyService(dSICarComfortReply);
        this.proxy = new Proxy(serviceInstanceID, dSICarComfortReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void setRGSBeltPretensionerDataFront(final RGSBeltPretensionData rGSBeltPretensionData) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                RGSBeltPretensionDataSerializer.putOptionalRGSBeltPretensionData(iSerializer, rGSBeltPretensionData);
            }
        };
        this.proxy.remoteCallMethod((short)49, iSerializable);
    }

    public void setRGSBeltPretensionerDataRear(final RGSBeltPretensionData rGSBeltPretensionData) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                RGSBeltPretensionDataSerializer.putOptionalRGSBeltPretensionData(iSerializer, rGSBeltPretensionData);
            }
        };
        this.proxy.remoteCallMethod((short)50, iSerializable);
    }

    public void setRGSPreCrashSystem(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)51, genericSerializable);
    }

    public void setRgsSetFactoryDefault() throws MethodException {
        this.proxy.remoteCallMethod((short)52, null);
    }

    public void setRGSPreSenseSystem(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)130, genericSerializable);
    }

    public void setRGSPreSenseWarning(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)166, genericSerializable);
    }

    public void setRGSLocalHazardInformation(final RGSLocalHazardInformation rGSLocalHazardInformation) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                RGSLocalHazardInformationSerializer.putOptionalRGSLocalHazardInformation(iSerializer, rGSLocalHazardInformation);
            }
        };
        this.proxy.remoteCallMethod((short)165, iSerializable);
    }

    public void setDoorLockingComfortOpenSettings(final DoorLockingComfortOpenSettings doorLockingComfortOpenSettings) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                DoorLockingComfortOpenSettingsSerializer.putOptionalDoorLockingComfortOpenSettings(iSerializer, doorLockingComfortOpenSettings);
            }
        };
        this.proxy.remoteCallMethod((short)26, iSerializable);
    }

    public void setDoorLockingTheftWarningSettings(final DoorLockingTheftWarningSettings doorLockingTheftWarningSettings) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                DoorLockingTheftWarningSettingsSerializer.putOptionalDoorLockingTheftWarningSettings(iSerializer, doorLockingTheftWarningSettings);
            }
        };
        this.proxy.remoteCallMethod((short)32, iSerializable);
    }

    public void setDoorLockingClBootOpen(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)163, genericSerializable);
    }

    public void setDoorLockingBootOpen(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)25, genericSerializable);
    }

    public void setDoorLockingBootClose(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)161, genericSerializable);
    }

    public void startDoorLockingRemoteLockUnlock(String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)169, genericSerializable);
    }

    public void abortDoorLockingRemoteLockUnlock() throws MethodException {
        this.proxy.remoteCallMethod((short)154, null);
    }

    public void sendDoorLockingRemoteLockUnlockSignature(String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)160, genericSerializable);
    }

    public void startDoorLockingRemoteBlinking(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)167, genericSerializable);
    }

    public void startDoorLockingRemoteHorn(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)168, genericSerializable);
    }

    public void setDoorLockingUnlockingMode(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)33, genericSerializable);
    }

    public void setDoorLockingAutoLock(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)22, genericSerializable);
    }

    public void setDoorLockingAutoUnlock(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)23, genericSerializable);
    }

    public void setDoorLockingClBootLock(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)162, genericSerializable);
    }

    public void setDoorLockingMirrorProtection(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)28, genericSerializable);
    }

    public void setDoorLockingConfirmation(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)27, genericSerializable);
    }

    public void setDoorLockingRainClosing(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)29, genericSerializable);
    }

    public void setDoorLockingRearBlind(final DoorLockingRearBlind doorLockingRearBlind) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                DoorLockingRearBlindSerializer.putOptionalDoorLockingRearBlind(iSerializer, doorLockingRearBlind);
            }
        };
        this.proxy.remoteCallMethod((short)30, iSerializable);
    }

    public void setDoorLockingSetFactoryDefault() throws MethodException {
        this.proxy.remoteCallMethod((short)31, null);
    }

    public void requestDoorLockingUserList(final DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                DoorLockingUserListUpdateInfoSerializer.putOptionalDoorLockingUserListUpdateInfo(iSerializer, doorLockingUserListUpdateInfo);
            }
        };
        this.proxy.remoteCallMethod((short)211, iSerializable);
    }

    public void setDoorLockingUserListRA1(final DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, final DoorLockingUserListRA1[] doorLockingUserListRA1Array) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                DoorLockingUserListUpdateInfoSerializer.putOptionalDoorLockingUserListUpdateInfo(iSerializer, doorLockingUserListUpdateInfo);
                DoorLockingUserListRA1Serializer.putOptionalDoorLockingUserListRA1VarArray(iSerializer, doorLockingUserListRA1Array);
            }
        };
        this.proxy.remoteCallMethod((short)222, iSerializable);
    }

    public void setDoorLockingUserListRAF(final DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, final int[] nArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                DoorLockingUserListUpdateInfoSerializer.putOptionalDoorLockingUserListUpdateInfo(iSerializer, doorLockingUserListUpdateInfo);
                iSerializer.putOptionalInt32VarArray(nArray);
            }
        };
        this.proxy.remoteCallMethod((short)223, iSerializable);
    }

    public void setDoorLockingActiveUser(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)184, genericSerializable);
    }

    public void setDoorLockingUserProfileOnOff(final DoorLockingUserProfileOnOff doorLockingUserProfileOnOff) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                DoorLockingUserProfileOnOffSerializer.putOptionalDoorLockingUserProfileOnOff(iSerializer, doorLockingUserProfileOnOff);
            }
        };
        this.proxy.remoteCallMethod((short)244, iSerializable);
    }

    public void startDoorLockingUserProfileControl(int n, int n2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)188, genericSerializable);
    }

    public void abortDoorLockingUserProfileControl() throws MethodException {
        this.proxy.remoteCallMethod((short)203, null);
    }

    public void setDoorLockingWindowAutoClose(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)204, genericSerializable);
    }

    public void setDoorlockingBlindsControl(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)224, genericSerializable);
    }

    public void setDoorlockingBlindsControlExtended(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)255, genericSerializable);
    }

    public void setDoorLockingLeftSideBlindControl(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)253, genericSerializable);
    }

    public void setDoorLockingRightSideBlindControl(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)254, genericSerializable);
    }

    public void setDoorLockingTurnIndRepeat(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)243, genericSerializable);
    }

    public void setDoorLockingKeyless(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)252, genericSerializable);
    }

    public void setWiperServicePosition(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)58, genericSerializable);
    }

    public void setWiperRainSensorOnOff(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)56, genericSerializable);
    }

    public void setWiperRainSensorConfig(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)55, genericSerializable);
    }

    public void setWiperRearWiping(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)57, genericSerializable);
    }

    public void setWiperTearsWiping(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)60, genericSerializable);
    }

    public void setWiperWinterPosition(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)61, genericSerializable);
    }

    public void setEasyEntrySteeringColumn(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)34, genericSerializable);
    }

    public void setWiperSetFactoryDefault() throws MethodException {
        this.proxy.remoteCallMethod((short)59, null);
    }

    public void setUGDOLearningData(final UGDOLearningData uGDOLearningData) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                UGDOLearningDataSerializer.putOptionalUGDOLearningData(iSerializer, uGDOLearningData);
            }
        };
        this.proxy.remoteCallMethod((short)53, iSerializable);
    }

    public void showUGDOPopup(final UGDOContent uGDOContent) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                UGDOContentSerializer.putOptionalUGDOContent(iSerializer, uGDOContent);
            }
        };
        this.proxy.remoteCallMethod((short)142, iSerializable);
    }

    public void cancelUGDOPopup(final UGDOContent uGDOContent) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                UGDOContentSerializer.putOptionalUGDOContent(iSerializer, uGDOContent);
            }
        };
        this.proxy.remoteCallMethod((short)119, iSerializable);
    }

    public void deleteUGDOButton(final UGDOSoftkeys uGDOSoftkeys) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                UGDOSoftkeysSerializer.putOptionalUGDOSoftkeys(iSerializer, uGDOSoftkeys);
            }
        };
        this.proxy.remoteCallMethod((short)177, iSerializable);
    }

    public void setUGDOSetFactoryDefault() throws MethodException {
        this.proxy.remoteCallMethod((short)140, null);
    }

    public void setUGDODestinationReached(final UGDODestinationReached uGDODestinationReached) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                UGDODestinationReachedSerializer.putOptionalUGDODestinationReached(iSerializer, uGDODestinationReached);
            }
        };
        this.proxy.remoteCallMethod((short)138, iSerializable);
    }

    public void setUGDOOpenDoor(final UGDOOpenDoor uGDOOpenDoor) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                UGDOOpenDoorSerializer.putOptionalUGDOOpenDoor(iSerializer, uGDOOpenDoor);
            }
        };
        this.proxy.remoteCallMethod((short)139, iSerializable);
    }

    public void setUGDOSynchronisation(final UGDOSynchronisation uGDOSynchronisation) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                UGDOSynchronisationSerializer.putOptionalUGDOSynchronisation(iSerializer, uGDOSynchronisation);
            }
        };
        this.proxy.remoteCallMethod((short)141, iSerializable);
    }

    public void responseUGDOSynchronisation(final UGDOSynchronisation uGDOSynchronisation) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                UGDOSynchronisationSerializer.putOptionalUGDOSynchronisation(iSerializer, uGDOSynchronisation);
            }
        };
        this.proxy.remoteCallMethod((short)129, iSerializable);
    }

    public void startUGDOLearning(int n, int n2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)143, genericSerializable);
    }

    public void abortUGDOLearning() throws MethodException {
        this.proxy.remoteCallMethod((short)113, null);
    }

    public void requestUGDOButtonList(final UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                UGDOButtonListUpdateInfoSerializer.putOptionalUGDOButtonListUpdateInfo(iSerializer, uGDOButtonListUpdateInfo);
            }
        };
        this.proxy.remoteCallMethod((short)212, iSerializable);
    }

    public void setUGDOButtonListRA0(final UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, final UGDOButtonListRA0[] uGDOButtonListRA0Array) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                UGDOButtonListUpdateInfoSerializer.putOptionalUGDOButtonListUpdateInfo(iSerializer, uGDOButtonListUpdateInfo);
                UGDOButtonListRA0Serializer.putOptionalUGDOButtonListRA0VarArray(iSerializer, uGDOButtonListRA0Array);
            }
        };
        this.proxy.remoteCallMethod((short)226, iSerializable);
    }

    public void setUGDOButtonListRA1(final UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, final UGDOButtonListRA1[] uGDOButtonListRA1Array) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                UGDOButtonListUpdateInfoSerializer.putOptionalUGDOButtonListUpdateInfo(iSerializer, uGDOButtonListUpdateInfo);
                UGDOButtonListRA1Serializer.putOptionalUGDOButtonListRA1VarArray(iSerializer, uGDOButtonListRA1Array);
            }
        };
        this.proxy.remoteCallMethod((short)227, iSerializable);
    }

    public void setUGDOButtonListRA2(final UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, final UGDOButtonListRA2[] uGDOButtonListRA2Array) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                UGDOButtonListUpdateInfoSerializer.putOptionalUGDOButtonListUpdateInfo(iSerializer, uGDOButtonListUpdateInfo);
                UGDOButtonListRA2Serializer.putOptionalUGDOButtonListRA2VarArray(iSerializer, uGDOButtonListRA2Array);
            }
        };
        this.proxy.remoteCallMethod((short)228, iSerializable);
    }

    public void setUGDOButtonListRA3(final UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, final UGDOButtonListRA3[] uGDOButtonListRA3Array) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                UGDOButtonListUpdateInfoSerializer.putOptionalUGDOButtonListUpdateInfo(iSerializer, uGDOButtonListUpdateInfo);
                UGDOButtonListRA3Serializer.putOptionalUGDOButtonListRA3VarArray(iSerializer, uGDOButtonListRA3Array);
            }
        };
        this.proxy.remoteCallMethod((short)229, iSerializable);
    }

    public void setUGDOButtonListRA4(final UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, final UGDOButtonListRA4[] uGDOButtonListRA4Array) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                UGDOButtonListUpdateInfoSerializer.putOptionalUGDOButtonListUpdateInfo(iSerializer, uGDOButtonListUpdateInfo);
                UGDOButtonListRA4Serializer.putOptionalUGDOButtonListRA4VarArray(iSerializer, uGDOButtonListRA4Array);
            }
        };
        this.proxy.remoteCallMethod((short)230, iSerializable);
    }

    public void setUGDOButtonListRA5(final UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, final UGDOButtonListRA5[] uGDOButtonListRA5Array) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                UGDOButtonListUpdateInfoSerializer.putOptionalUGDOButtonListUpdateInfo(iSerializer, uGDOButtonListUpdateInfo);
                UGDOButtonListRA5Serializer.putOptionalUGDOButtonListRA5VarArray(iSerializer, uGDOButtonListRA5Array);
            }
        };
        this.proxy.remoteCallMethod((short)231, iSerializable);
    }

    public void setUGDOButtonListRAF(final UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, final int[] nArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                UGDOButtonListUpdateInfoSerializer.putOptionalUGDOButtonListUpdateInfo(iSerializer, uGDOButtonListUpdateInfo);
                iSerializer.putOptionalInt32VarArray(nArray);
            }
        };
        this.proxy.remoteCallMethod((short)232, iSerializable);
    }

    public void setRDKSystemOnOff(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)46, genericSerializable);
    }

    public void setRDKTireSetupSelectedTire(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)48, genericSerializable);
    }

    public void setRDKSpeedLimit(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)45, genericSerializable);
    }

    public void setRDKTireChanged() throws MethodException {
        this.proxy.remoteCallMethod((short)47, null);
    }

    public void setRDKPressureChanged() throws MethodException {
        this.proxy.remoteCallMethod((short)44, null);
    }

    public void requestRDKLifeMonitoring() throws MethodException {
        this.proxy.remoteCallMethod((short)13, null);
    }

    public void setRDKPressureLevel(byte by) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt8(by);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)196, genericSerializable);
    }

    public void setRDKSetFactoryDefault() throws MethodException {
        this.proxy.remoteCallMethod((short)225, null);
    }

    public void setMirrorLowering(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)38, genericSerializable);
    }

    public void setMirrorSyncAdjust(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)40, genericSerializable);
    }

    public void setMirrorFolding(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)36, genericSerializable);
    }

    public void setMirrorDimming(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)35, genericSerializable);
    }

    public void setMirrorHeating(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)37, genericSerializable);
    }

    public void setMirrorSetFactoryDefault() throws MethodException {
        this.proxy.remoteCallMethod((short)39, null);
    }

    public void setBrakeElectricalParking(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)19, genericSerializable);
    }

    public void setBrakeAutoHold(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)18, genericSerializable);
    }

    public void setBrakeEscMode(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)20, genericSerializable);
    }

    public void setBrakeHdcMode(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)195, genericSerializable);
    }

    public void setHMIIsReady(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)164, genericSerializable);
    }

    public void showDoorLockingPrompt(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)245, genericSerializable);
    }

    public void cancelDoorLockingPrompt(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)241, genericSerializable);
    }

    public void setMascotSetFactoryDefault() throws MethodException {
        this.proxy.remoteCallMethod((short)264, null);
    }

    public void setMascotControl(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)262, genericSerializable);
    }

    public void setMascotMode(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)263, genericSerializable);
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
        this.proxy.remoteCallMethod((short)10, genericSerializable);
    }

    public void clearNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }

    public void clearNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)9, null);
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
        this.proxy.remoteCallMethod((short)112, genericSerializable);
    }
}

