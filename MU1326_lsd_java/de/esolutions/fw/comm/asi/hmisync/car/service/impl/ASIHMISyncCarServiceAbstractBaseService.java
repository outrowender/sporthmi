/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.service.impl;

import de.esolutions.fw.comm.asi.hmisync.car.FloatBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.IntBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.service.ASIHMISyncCarServiceReply;
import de.esolutions.fw.comm.asi.hmisync.car.service.ASIHMISyncCarServiceS;
import de.esolutions.fw.comm.asi.hmisync.car.service.AdBlueInfo;
import de.esolutions.fw.comm.asi.hmisync.car.service.OilLevelData;
import de.esolutions.fw.comm.asi.hmisync.car.service.SIAOilInspection;
import de.esolutions.fw.comm.asi.hmisync.car.service.SIAServiceData;
import de.esolutions.fw.comm.asi.hmisync.car.service.TireDisplayData;
import de.esolutions.fw.comm.asi.hmisync.car.service.WheelPressures;
import de.esolutions.fw.comm.asi.hmisync.car.service.WheelStates;
import de.esolutions.fw.comm.asi.hmisync.car.service.WheelTemperatures;
import de.esolutions.fw.comm.attributes.AttributesBaseService;
import de.esolutions.fw.comm.attributes.IAttributeBitMapProvider;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class ASIHMISyncCarServiceAbstractBaseService
implements ASIHMISyncCarServiceS {
    private static final CallContext context = CallContext.getContext("ABSTRACTBASESERVICE.asi.hmisync.car.service.ASIHMISyncCarService");
    private static final int attributesCount = 20;
    private String ASIVersion;
    private boolean ASIVersion_valid = false;
    private short[] RequestIDs;
    private boolean RequestIDs_valid = false;
    private short[] ReplyIDs;
    private boolean ReplyIDs_valid = false;
    private OilLevelData OilLevelData;
    private boolean OilLevelData_valid = false;
    private int OilLevelDataVisibilityState;
    private boolean OilLevelDataVisibilityState_valid = false;
    private AdBlueInfo AdBlueInfo;
    private boolean AdBlueInfo_valid = false;
    private int AdBlueInfoVisibilityState;
    private boolean AdBlueInfoVisibilityState_valid = false;
    private SIAOilInspection SIAOilInspection;
    private boolean SIAOilInspection_valid = false;
    private int[] SIAOilInspectionVisibilityState;
    private boolean SIAOilInspectionVisibilityState_valid = false;
    private SIAServiceData SIAServiceData;
    private boolean SIAServiceData_valid = false;
    private int SIAServiceDataVisibilityState;
    private boolean SIAServiceDataVisibilityState_valid = false;
    private String VinData;
    private boolean VinData_valid = false;
    private int VinDataVisibilityState;
    private boolean VinDataVisibilityState_valid = false;
    private int[] KeyData;
    private boolean KeyData_valid = false;
    private int KeyDataVisibilityState;
    private boolean KeyDataVisibilityState_valid = false;
    private TireDisplayData TireDisplayData;
    private boolean TireDisplayData_valid = false;
    private int TireDisplayDataVisibilityState;
    private boolean TireDisplayDataVisibilityState_valid = false;
    private int TireSystem;
    private boolean TireSystem_valid = false;
    private int VehicleSpeedVisibility;
    private boolean VehicleSpeedVisibility_valid = false;
    private FloatBaseType VehicleSpeed;
    private boolean VehicleSpeed_valid = false;
    private AttributesBaseService baseService;

    public static String copyString(String string) {
        if (string != null) {
            return new String(string);
        }
        return null;
    }

    public static OilLevelData copyOilLevelData(OilLevelData oilLevelData) {
        if (oilLevelData == null) {
            return null;
        }
        OilLevelData oilLevelData2 = new OilLevelData();
        oilLevelData2.level = oilLevelData.level;
        oilLevelData2.refillVolume = ASIHMISyncCarServiceAbstractBaseService.copyIntBaseType(oilLevelData.refillVolume);
        oilLevelData2.warnings = oilLevelData.warnings;
        oilLevelData2.oilsystem = oilLevelData.oilsystem;
        oilLevelData2.bargraph = oilLevelData.bargraph;
        return oilLevelData2;
    }

    public static IntBaseType copyIntBaseType(IntBaseType intBaseType) {
        if (intBaseType == null) {
            return null;
        }
        IntBaseType intBaseType2 = new IntBaseType();
        intBaseType2.value = intBaseType.value;
        intBaseType2.unit = intBaseType.unit;
        intBaseType2.status = intBaseType.status;
        return intBaseType2;
    }

    public static AdBlueInfo copyAdBlueInfo(AdBlueInfo adBlueInfo) {
        if (adBlueInfo == null) {
            return null;
        }
        AdBlueInfo adBlueInfo2 = new AdBlueInfo();
        adBlueInfo2.range = adBlueInfo.range;
        adBlueInfo2.rangeUnit = adBlueInfo.rangeUnit;
        adBlueInfo2.level = adBlueInfo.level;
        adBlueInfo2.tankVolume = adBlueInfo.tankVolume;
        adBlueInfo2.state = adBlueInfo.state;
        adBlueInfo2.volumeUnit = adBlueInfo.volumeUnit;
        adBlueInfo2.minRefill = adBlueInfo.minRefill;
        adBlueInfo2.maxRefill = adBlueInfo.maxRefill;
        return adBlueInfo2;
    }

    public static SIAOilInspection copySIAOilInspection(SIAOilInspection sIAOilInspection) {
        if (sIAOilInspection == null) {
            return null;
        }
        SIAOilInspection sIAOilInspection2 = new SIAOilInspection();
        sIAOilInspection2.distanceStatus = sIAOilInspection.distanceStatus;
        sIAOilInspection2.distance = sIAOilInspection.distance;
        sIAOilInspection2.distanceUnit = sIAOilInspection.distanceUnit;
        sIAOilInspection2.timeStatus = sIAOilInspection.timeStatus;
        sIAOilInspection2.time = sIAOilInspection.time;
        return sIAOilInspection2;
    }

    public static SIAServiceData copySIAServiceData(SIAServiceData sIAServiceData) {
        if (sIAServiceData == null) {
            return null;
        }
        SIAServiceData sIAServiceData2 = new SIAServiceData();
        sIAServiceData2.distanceStatus = sIAServiceData.distanceStatus;
        sIAServiceData2.distance = sIAServiceData.distance;
        sIAServiceData2.distanceUnit = sIAServiceData.distanceUnit;
        sIAServiceData2.timeStatus = sIAServiceData.timeStatus;
        sIAServiceData2.time = sIAServiceData.time;
        return sIAServiceData2;
    }

    public static TireDisplayData copyTireDisplayData(TireDisplayData tireDisplayData) {
        if (tireDisplayData == null) {
            return null;
        }
        TireDisplayData tireDisplayData2 = new TireDisplayData();
        tireDisplayData2.wheelStates = ASIHMISyncCarServiceAbstractBaseService.copyWheelStates(tireDisplayData.wheelStates);
        tireDisplayData2.wheelPressures = ASIHMISyncCarServiceAbstractBaseService.copyWheelPressures(tireDisplayData.wheelPressures);
        tireDisplayData2.requiredWheelPressures = ASIHMISyncCarServiceAbstractBaseService.copyWheelPressures(tireDisplayData.requiredWheelPressures);
        tireDisplayData2.wheelTemperatures = ASIHMISyncCarServiceAbstractBaseService.copyWheelTemperatures(tireDisplayData.wheelTemperatures);
        return tireDisplayData2;
    }

    public static WheelStates copyWheelStates(WheelStates wheelStates) {
        if (wheelStates == null) {
            return null;
        }
        WheelStates wheelStates2 = new WheelStates();
        wheelStates2.frontLeft = wheelStates.frontLeft;
        wheelStates2.frontRight = wheelStates.frontRight;
        wheelStates2.rearLeft = wheelStates.rearLeft;
        wheelStates2.rearRight = wheelStates.rearRight;
        wheelStates2.spareWheel = wheelStates.spareWheel;
        wheelStates2.collectedState = wheelStates.collectedState;
        return wheelStates2;
    }

    public static WheelPressures copyWheelPressures(WheelPressures wheelPressures) {
        if (wheelPressures == null) {
            return null;
        }
        WheelPressures wheelPressures2 = new WheelPressures();
        wheelPressures2.pressureUnit = wheelPressures.pressureUnit;
        wheelPressures2.frontLeft = wheelPressures.frontLeft;
        wheelPressures2.frontRight = wheelPressures.frontRight;
        wheelPressures2.rearLeft = wheelPressures.rearLeft;
        wheelPressures2.rearRight = wheelPressures.rearRight;
        wheelPressures2.spareWheel = wheelPressures.spareWheel;
        return wheelPressures2;
    }

    public static WheelTemperatures copyWheelTemperatures(WheelTemperatures wheelTemperatures) {
        if (wheelTemperatures == null) {
            return null;
        }
        WheelTemperatures wheelTemperatures2 = new WheelTemperatures();
        wheelTemperatures2.temperatureUnit = wheelTemperatures.temperatureUnit;
        wheelTemperatures2.frontLeft = wheelTemperatures.frontLeft;
        wheelTemperatures2.frontRight = wheelTemperatures.frontRight;
        wheelTemperatures2.rearLeft = wheelTemperatures.rearLeft;
        wheelTemperatures2.rearRight = wheelTemperatures.rearRight;
        wheelTemperatures2.spareWheel = wheelTemperatures.spareWheel;
        return wheelTemperatures2;
    }

    public static FloatBaseType copyFloatBaseType(FloatBaseType floatBaseType) {
        if (floatBaseType == null) {
            return null;
        }
        FloatBaseType floatBaseType2 = new FloatBaseType();
        floatBaseType2.value = floatBaseType.value;
        floatBaseType2.unit = floatBaseType.unit;
        floatBaseType2.status = floatBaseType.status;
        return floatBaseType2;
    }

    public ASIHMISyncCarServiceAbstractBaseService() {
        AttributesBitMapProvider attributesBitMapProvider = new AttributesBitMapProvider();
        this.baseService = new AttributesBaseService("ASIHMISyncCarService", attributesBitMapProvider);
    }

    public synchronized void setNotification(long l, ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply) {
        this.baseService.setNotification(l, (Object)aSIHMISyncCarServiceReply);
        this.sendAttributeUpdate(l, aSIHMISyncCarServiceReply);
    }

    public synchronized void setNotification(ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply) {
        this.baseService.setNotification(aSIHMISyncCarServiceReply);
        this.sendAttributeUpdate(aSIHMISyncCarServiceReply);
    }

    public synchronized void setNotification(long[] lArray, ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply) {
        this.baseService.setNotification(lArray, (Object)aSIHMISyncCarServiceReply);
        this.sendAttributeUpdate(lArray, aSIHMISyncCarServiceReply);
    }

    public synchronized void clearNotification(long l, ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply) {
        this.baseService.clearNotification(l, (Object)aSIHMISyncCarServiceReply);
    }

    public synchronized void clearNotification(ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply) {
        this.baseService.clearNotification(aSIHMISyncCarServiceReply);
    }

    public synchronized void clearNotification(long[] lArray, ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply) {
        this.baseService.clearNotification(lArray, (Object)aSIHMISyncCarServiceReply);
    }

    private void sendAttributeUpdate(ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply) {
        try {
            aSIHMISyncCarServiceReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            aSIHMISyncCarServiceReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            aSIHMISyncCarServiceReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            aSIHMISyncCarServiceReply.updateOilLevelData(this.OilLevelData, this.OilLevelData_valid);
            aSIHMISyncCarServiceReply.updateOilLevelDataVisibilityState(this.OilLevelDataVisibilityState, this.OilLevelDataVisibilityState_valid);
            aSIHMISyncCarServiceReply.updateAdBlueInfo(this.AdBlueInfo, this.AdBlueInfo_valid);
            aSIHMISyncCarServiceReply.updateAdBlueInfoVisibilityState(this.AdBlueInfoVisibilityState, this.AdBlueInfoVisibilityState_valid);
            aSIHMISyncCarServiceReply.updateSIAOilInspection(this.SIAOilInspection, this.SIAOilInspection_valid);
            aSIHMISyncCarServiceReply.updateSIAOilInspectionVisibilityState(this.SIAOilInspectionVisibilityState, this.SIAOilInspectionVisibilityState_valid);
            aSIHMISyncCarServiceReply.updateSIAServiceData(this.SIAServiceData, this.SIAServiceData_valid);
            aSIHMISyncCarServiceReply.updateSIAServiceDataVisibilityState(this.SIAServiceDataVisibilityState, this.SIAServiceDataVisibilityState_valid);
            aSIHMISyncCarServiceReply.updateVinData(this.VinData, this.VinData_valid);
            aSIHMISyncCarServiceReply.updateVinDataVisibilityState(this.VinDataVisibilityState, this.VinDataVisibilityState_valid);
            aSIHMISyncCarServiceReply.updateKeyData(this.KeyData, this.KeyData_valid);
            aSIHMISyncCarServiceReply.updateKeyDataVisibilityState(this.KeyDataVisibilityState, this.KeyDataVisibilityState_valid);
            aSIHMISyncCarServiceReply.updateTireDisplayData(this.TireDisplayData, this.TireDisplayData_valid);
            aSIHMISyncCarServiceReply.updateTireDisplayDataVisibilityState(this.TireDisplayDataVisibilityState, this.TireDisplayDataVisibilityState_valid);
            aSIHMISyncCarServiceReply.updateTireSystem(this.TireSystem, this.TireSystem_valid);
            aSIHMISyncCarServiceReply.updateVehicleSpeedVisibility(this.VehicleSpeedVisibility, this.VehicleSpeedVisibility_valid);
            aSIHMISyncCarServiceReply.updateVehicleSpeed(this.VehicleSpeed, this.VehicleSpeed_valid);
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    private void sendAttributeUpdate(long[] lArray, ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            this.sendAttributeUpdate(lArray[i2], aSIHMISyncCarServiceReply);
        }
    }

    private void sendAttributeUpdate(long l, ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply) {
        try {
            if (l == 6L) {
                aSIHMISyncCarServiceReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            } else if (l == 14L) {
                aSIHMISyncCarServiceReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            } else if (l == 13L) {
                aSIHMISyncCarServiceReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            } else if (l == 11L) {
                aSIHMISyncCarServiceReply.updateOilLevelData(this.OilLevelData, this.OilLevelData_valid);
            } else if (l == 12L) {
                aSIHMISyncCarServiceReply.updateOilLevelDataVisibilityState(this.OilLevelDataVisibilityState, this.OilLevelDataVisibilityState_valid);
            } else if (l == 26L) {
                aSIHMISyncCarServiceReply.updateAdBlueInfo(this.AdBlueInfo, this.AdBlueInfo_valid);
            } else if (l == 8L) {
                aSIHMISyncCarServiceReply.updateAdBlueInfoVisibilityState(this.AdBlueInfoVisibilityState, this.AdBlueInfoVisibilityState_valid);
            } else if (l == 15L) {
                aSIHMISyncCarServiceReply.updateSIAOilInspection(this.SIAOilInspection, this.SIAOilInspection_valid);
            } else if (l == 16L) {
                aSIHMISyncCarServiceReply.updateSIAOilInspectionVisibilityState(this.SIAOilInspectionVisibilityState, this.SIAOilInspectionVisibilityState_valid);
            } else if (l == 17L) {
                aSIHMISyncCarServiceReply.updateSIAServiceData(this.SIAServiceData, this.SIAServiceData_valid);
            } else if (l == 18L) {
                aSIHMISyncCarServiceReply.updateSIAServiceDataVisibilityState(this.SIAServiceDataVisibilityState, this.SIAServiceDataVisibilityState_valid);
            } else if (l == 24L) {
                aSIHMISyncCarServiceReply.updateVinData(this.VinData, this.VinData_valid);
            } else if (l == 25L) {
                aSIHMISyncCarServiceReply.updateVinDataVisibilityState(this.VinDataVisibilityState, this.VinDataVisibilityState_valid);
            } else if (l == 9L) {
                aSIHMISyncCarServiceReply.updateKeyData(this.KeyData, this.KeyData_valid);
            } else if (l == 10L) {
                aSIHMISyncCarServiceReply.updateKeyDataVisibilityState(this.KeyDataVisibilityState, this.KeyDataVisibilityState_valid);
            } else if (l == 19L) {
                aSIHMISyncCarServiceReply.updateTireDisplayData(this.TireDisplayData, this.TireDisplayData_valid);
            } else if (l == 20L) {
                aSIHMISyncCarServiceReply.updateTireDisplayDataVisibilityState(this.TireDisplayDataVisibilityState, this.TireDisplayDataVisibilityState_valid);
            } else if (l == 21L) {
                aSIHMISyncCarServiceReply.updateTireSystem(this.TireSystem, this.TireSystem_valid);
            } else if (l == 23L) {
                aSIHMISyncCarServiceReply.updateVehicleSpeedVisibility(this.VehicleSpeedVisibility, this.VehicleSpeedVisibility_valid);
            } else if (l == 22L) {
                aSIHMISyncCarServiceReply.updateVehicleSpeed(this.VehicleSpeed, this.VehicleSpeed_valid);
            } else {
                System.out.println("unexpected");
            }
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    public void updateASIVersion(String string) throws MethodException {
        this.updateASIVersion(string, true);
    }

    public void updateASIVersion(String string, boolean bl) throws MethodException {
        this.ASIVersion = ASIHMISyncCarServiceAbstractBaseService.copyString(string);
        this.ASIVersion_valid = bl;
        List list = this.baseService.getNotifications(6);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateASIVersion(string, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateRequestIDs(short[] sArray) throws MethodException {
        this.updateRequestIDs(sArray, true);
    }

    public void updateRequestIDs(short[] sArray, boolean bl) throws MethodException {
        if (sArray != null) {
            this.RequestIDs = new short[sArray.length];
            System.arraycopy((Object)sArray, 0, (Object)this.RequestIDs, 0, sArray.length);
        } else {
            this.RequestIDs = null;
        }
        this.RequestIDs_valid = bl;
        List list = this.baseService.getNotifications(14);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateRequestIDs(sArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateReplyIDs(short[] sArray) throws MethodException {
        this.updateReplyIDs(sArray, true);
    }

    public void updateReplyIDs(short[] sArray, boolean bl) throws MethodException {
        if (sArray != null) {
            this.ReplyIDs = new short[sArray.length];
            System.arraycopy((Object)sArray, 0, (Object)this.ReplyIDs, 0, sArray.length);
        } else {
            this.ReplyIDs = null;
        }
        this.ReplyIDs_valid = bl;
        List list = this.baseService.getNotifications(13);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateReplyIDs(sArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateOilLevelData(OilLevelData oilLevelData) throws MethodException {
        this.updateOilLevelData(oilLevelData, true);
    }

    public void updateOilLevelData(OilLevelData oilLevelData, boolean bl) throws MethodException {
        this.OilLevelData = ASIHMISyncCarServiceAbstractBaseService.copyOilLevelData(oilLevelData);
        this.OilLevelData_valid = bl;
        List list = this.baseService.getNotifications(11);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateOilLevelData(oilLevelData, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateOilLevelDataVisibilityState(int n) throws MethodException {
        this.updateOilLevelDataVisibilityState(n, true);
    }

    public void updateOilLevelDataVisibilityState(int n, boolean bl) throws MethodException {
        this.OilLevelDataVisibilityState = n;
        this.OilLevelDataVisibilityState_valid = bl;
        List list = this.baseService.getNotifications(12);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateOilLevelDataVisibilityState(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateAdBlueInfo(AdBlueInfo adBlueInfo) throws MethodException {
        this.updateAdBlueInfo(adBlueInfo, true);
    }

    public void updateAdBlueInfo(AdBlueInfo adBlueInfo, boolean bl) throws MethodException {
        this.AdBlueInfo = ASIHMISyncCarServiceAbstractBaseService.copyAdBlueInfo(adBlueInfo);
        this.AdBlueInfo_valid = bl;
        List list = this.baseService.getNotifications(26);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateAdBlueInfo(adBlueInfo, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateAdBlueInfoVisibilityState(int n) throws MethodException {
        this.updateAdBlueInfoVisibilityState(n, true);
    }

    public void updateAdBlueInfoVisibilityState(int n, boolean bl) throws MethodException {
        this.AdBlueInfoVisibilityState = n;
        this.AdBlueInfoVisibilityState_valid = bl;
        List list = this.baseService.getNotifications(8);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateAdBlueInfoVisibilityState(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateSIAOilInspection(SIAOilInspection sIAOilInspection) throws MethodException {
        this.updateSIAOilInspection(sIAOilInspection, true);
    }

    public void updateSIAOilInspection(SIAOilInspection sIAOilInspection, boolean bl) throws MethodException {
        this.SIAOilInspection = ASIHMISyncCarServiceAbstractBaseService.copySIAOilInspection(sIAOilInspection);
        this.SIAOilInspection_valid = bl;
        List list = this.baseService.getNotifications(15);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateSIAOilInspection(sIAOilInspection, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateSIAOilInspectionVisibilityState(int[] nArray) throws MethodException {
        this.updateSIAOilInspectionVisibilityState(nArray, true);
    }

    public void updateSIAOilInspectionVisibilityState(int[] nArray, boolean bl) throws MethodException {
        if (nArray != null) {
            this.SIAOilInspectionVisibilityState = new int[nArray.length];
            System.arraycopy((Object)nArray, 0, (Object)this.SIAOilInspectionVisibilityState, 0, nArray.length);
        } else {
            this.SIAOilInspectionVisibilityState = null;
        }
        this.SIAOilInspectionVisibilityState_valid = bl;
        List list = this.baseService.getNotifications(16);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateSIAOilInspectionVisibilityState(nArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateSIAServiceData(SIAServiceData sIAServiceData) throws MethodException {
        this.updateSIAServiceData(sIAServiceData, true);
    }

    public void updateSIAServiceData(SIAServiceData sIAServiceData, boolean bl) throws MethodException {
        this.SIAServiceData = ASIHMISyncCarServiceAbstractBaseService.copySIAServiceData(sIAServiceData);
        this.SIAServiceData_valid = bl;
        List list = this.baseService.getNotifications(17);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateSIAServiceData(sIAServiceData, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateSIAServiceDataVisibilityState(int n) throws MethodException {
        this.updateSIAServiceDataVisibilityState(n, true);
    }

    public void updateSIAServiceDataVisibilityState(int n, boolean bl) throws MethodException {
        this.SIAServiceDataVisibilityState = n;
        this.SIAServiceDataVisibilityState_valid = bl;
        List list = this.baseService.getNotifications(18);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateSIAServiceDataVisibilityState(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateVinData(String string) throws MethodException {
        this.updateVinData(string, true);
    }

    public void updateVinData(String string, boolean bl) throws MethodException {
        this.VinData = ASIHMISyncCarServiceAbstractBaseService.copyString(string);
        this.VinData_valid = bl;
        List list = this.baseService.getNotifications(24);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateVinData(string, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateVinDataVisibilityState(int n) throws MethodException {
        this.updateVinDataVisibilityState(n, true);
    }

    public void updateVinDataVisibilityState(int n, boolean bl) throws MethodException {
        this.VinDataVisibilityState = n;
        this.VinDataVisibilityState_valid = bl;
        List list = this.baseService.getNotifications(25);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateVinDataVisibilityState(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateKeyData(int[] nArray) throws MethodException {
        this.updateKeyData(nArray, true);
    }

    public void updateKeyData(int[] nArray, boolean bl) throws MethodException {
        if (nArray != null) {
            this.KeyData = new int[nArray.length];
            System.arraycopy((Object)nArray, 0, (Object)this.KeyData, 0, nArray.length);
        } else {
            this.KeyData = null;
        }
        this.KeyData_valid = bl;
        List list = this.baseService.getNotifications(9);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateKeyData(nArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateKeyDataVisibilityState(int n) throws MethodException {
        this.updateKeyDataVisibilityState(n, true);
    }

    public void updateKeyDataVisibilityState(int n, boolean bl) throws MethodException {
        this.KeyDataVisibilityState = n;
        this.KeyDataVisibilityState_valid = bl;
        List list = this.baseService.getNotifications(10);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateKeyDataVisibilityState(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateTireDisplayData(TireDisplayData tireDisplayData) throws MethodException {
        this.updateTireDisplayData(tireDisplayData, true);
    }

    public void updateTireDisplayData(TireDisplayData tireDisplayData, boolean bl) throws MethodException {
        this.TireDisplayData = ASIHMISyncCarServiceAbstractBaseService.copyTireDisplayData(tireDisplayData);
        this.TireDisplayData_valid = bl;
        List list = this.baseService.getNotifications(19);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateTireDisplayData(tireDisplayData, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateTireDisplayDataVisibilityState(int n) throws MethodException {
        this.updateTireDisplayDataVisibilityState(n, true);
    }

    public void updateTireDisplayDataVisibilityState(int n, boolean bl) throws MethodException {
        this.TireDisplayDataVisibilityState = n;
        this.TireDisplayDataVisibilityState_valid = bl;
        List list = this.baseService.getNotifications(20);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateTireDisplayDataVisibilityState(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateTireSystem(int n) throws MethodException {
        this.updateTireSystem(n, true);
    }

    public void updateTireSystem(int n, boolean bl) throws MethodException {
        this.TireSystem = n;
        this.TireSystem_valid = bl;
        List list = this.baseService.getNotifications(21);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateTireSystem(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateVehicleSpeedVisibility(int n) throws MethodException {
        this.updateVehicleSpeedVisibility(n, true);
    }

    public void updateVehicleSpeedVisibility(int n, boolean bl) throws MethodException {
        this.VehicleSpeedVisibility = n;
        this.VehicleSpeedVisibility_valid = bl;
        List list = this.baseService.getNotifications(23);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateVehicleSpeedVisibility(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateVehicleSpeed(FloatBaseType floatBaseType) throws MethodException {
        this.updateVehicleSpeed(floatBaseType, true);
    }

    public void updateVehicleSpeed(FloatBaseType floatBaseType, boolean bl) throws MethodException {
        this.VehicleSpeed = ASIHMISyncCarServiceAbstractBaseService.copyFloatBaseType(floatBaseType);
        this.VehicleSpeed_valid = bl;
        List list = this.baseService.getNotifications(22);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateVehicleSpeed(floatBaseType, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    private static class AttributesBitMapProvider
    implements IAttributeBitMapProvider {
        private final HashMap map = new HashMap();

        public AttributesBitMapProvider() {
            this.map.put(new Long(6L), new Integer(0));
            this.map.put(new Long(14L), new Integer(1));
            this.map.put(new Long(13L), new Integer(2));
            this.map.put(new Long(11L), new Integer(3));
            this.map.put(new Long(12L), new Integer(4));
            this.map.put(new Long(26L), new Integer(5));
            this.map.put(new Long(8L), new Integer(6));
            this.map.put(new Long(15L), new Integer(7));
            this.map.put(new Long(16L), new Integer(8));
            this.map.put(new Long(17L), new Integer(9));
            this.map.put(new Long(18L), new Integer(10));
            this.map.put(new Long(24L), new Integer(11));
            this.map.put(new Long(25L), new Integer(12));
            this.map.put(new Long(9L), new Integer(13));
            this.map.put(new Long(10L), new Integer(14));
            this.map.put(new Long(19L), new Integer(15));
            this.map.put(new Long(20L), new Integer(16));
            this.map.put(new Long(21L), new Integer(17));
            this.map.put(new Long(23L), new Integer(18));
            this.map.put(new Long(22L), new Integer(19));
        }

        public int getAttributeBit(long l) {
            Integer n = (Integer)this.map.get(new Long(l));
            return n;
        }

        public int getAttributesCount() {
            return 20;
        }
    }
}

