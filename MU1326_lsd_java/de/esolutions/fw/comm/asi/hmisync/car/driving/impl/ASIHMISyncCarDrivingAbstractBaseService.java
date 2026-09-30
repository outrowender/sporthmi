/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.driving.impl;

import de.esolutions.fw.comm.asi.hmisync.car.driving.ASIHMISyncCarDrivingReply;
import de.esolutions.fw.comm.asi.hmisync.car.driving.ASIHMISyncCarDrivingS;
import de.esolutions.fw.comm.asi.hmisync.car.driving.TADConfiguration;
import de.esolutions.fw.comm.asi.hmisync.car.driving.TADVehicleInfo;
import de.esolutions.fw.comm.attributes.AttributesBaseService;
import de.esolutions.fw.comm.attributes.IAttributeBitMapProvider;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class ASIHMISyncCarDrivingAbstractBaseService
implements ASIHMISyncCarDrivingS {
    private static final CallContext context = CallContext.getContext("ABSTRACTBASESERVICE.asi.hmisync.car.driving.ASIHMISyncCarDriving");
    private static final int attributesCount = 17;
    private String ASIVersion;
    private boolean ASIVersion_valid = false;
    private short[] RequestIDs;
    private boolean RequestIDs_valid = false;
    private short[] ReplyIDs;
    private boolean ReplyIDs_valid = false;
    private TADVehicleInfo TADVehicleInfo;
    private boolean TADVehicleInfo_valid = false;
    private TADConfiguration TADConfiguration;
    private boolean TADConfiguration_valid = false;
    private float TADCurrentRollAngle;
    private boolean TADCurrentRollAngle_valid = false;
    private float TADPosMaxRollAngle;
    private boolean TADPosMaxRollAngle_valid = false;
    private float TADNegMaxRollAngle;
    private boolean TADNegMaxRollAngle_valid = false;
    private float TADCurrentPitchAngle;
    private boolean TADCurrentPitchAngle_valid = false;
    private float TADPosMaxPitch;
    private boolean TADPosMaxPitch_valid = false;
    private float TADNegMaxPitch;
    private boolean TADNegMaxPitch_valid = false;
    private int TADVisibilityState;
    private boolean TADVisibilityState_valid = false;
    private int SuspensionControlCurrentLevel;
    private boolean SuspensionControlCurrentLevel_valid = false;
    private int SuspensionControlTargetLevel;
    private boolean SuspensionControlTargetLevel_valid = false;
    private int[] SuspensionVisibilityState;
    private boolean SuspensionVisibilityState_valid = false;
    private int DriveSelectActiveProfile;
    private boolean DriveSelectActiveProfile_valid = false;
    private int DriveSelectActiveProfileVisibilityState;
    private boolean DriveSelectActiveProfileVisibilityState_valid = false;
    private AttributesBaseService baseService;

    public static String copyString(String string) {
        if (string != null) {
            return new String(string);
        }
        return null;
    }

    public static TADVehicleInfo copyTADVehicleInfo(TADVehicleInfo tADVehicleInfo) {
        if (tADVehicleInfo == null) {
            return null;
        }
        TADVehicleInfo tADVehicleInfo2 = new TADVehicleInfo();
        tADVehicleInfo2.roofLoad = tADVehicleInfo.roofLoad;
        tADVehicleInfo2.trailer = tADVehicleInfo.trailer;
        return tADVehicleInfo2;
    }

    public static TADConfiguration copyTADConfiguration(TADConfiguration tADConfiguration) {
        if (tADConfiguration == null) {
            return null;
        }
        TADConfiguration tADConfiguration2 = new TADConfiguration();
        tADConfiguration2.rollAngleMaxScale = tADConfiguration.rollAngleMaxScale;
        tADConfiguration2.rollAngleStartSoftWarning = tADConfiguration.rollAngleStartSoftWarning;
        tADConfiguration2.rollAngleStartHardWarning = tADConfiguration.rollAngleStartHardWarning;
        tADConfiguration2.pitchAngleMaxScale = tADConfiguration.pitchAngleMaxScale;
        tADConfiguration2.pitchAngleStartSoftWarning = tADConfiguration.pitchAngleStartSoftWarning;
        tADConfiguration2.pitchAngleStartHardWarning = tADConfiguration.pitchAngleStartHardWarning;
        tADConfiguration2.rollAngleInstallation = tADConfiguration.rollAngleInstallation;
        tADConfiguration2.pitchAngleInstallation = tADConfiguration.pitchAngleInstallation;
        return tADConfiguration2;
    }

    public ASIHMISyncCarDrivingAbstractBaseService() {
        AttributesBitMapProvider attributesBitMapProvider = new AttributesBitMapProvider();
        this.baseService = new AttributesBaseService("ASIHMISyncCarDriving", attributesBitMapProvider);
    }

    public synchronized void setNotification(long l, ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply) {
        this.baseService.setNotification(l, (Object)aSIHMISyncCarDrivingReply);
        this.sendAttributeUpdate(l, aSIHMISyncCarDrivingReply);
    }

    public synchronized void setNotification(ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply) {
        this.baseService.setNotification(aSIHMISyncCarDrivingReply);
        this.sendAttributeUpdate(aSIHMISyncCarDrivingReply);
    }

    public synchronized void setNotification(long[] lArray, ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply) {
        this.baseService.setNotification(lArray, (Object)aSIHMISyncCarDrivingReply);
        this.sendAttributeUpdate(lArray, aSIHMISyncCarDrivingReply);
    }

    public synchronized void clearNotification(long l, ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply) {
        this.baseService.clearNotification(l, (Object)aSIHMISyncCarDrivingReply);
    }

    public synchronized void clearNotification(ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply) {
        this.baseService.clearNotification(aSIHMISyncCarDrivingReply);
    }

    public synchronized void clearNotification(long[] lArray, ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply) {
        this.baseService.clearNotification(lArray, (Object)aSIHMISyncCarDrivingReply);
    }

    private void sendAttributeUpdate(ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply) {
        try {
            aSIHMISyncCarDrivingReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            aSIHMISyncCarDrivingReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            aSIHMISyncCarDrivingReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            aSIHMISyncCarDrivingReply.updateTADVehicleInfo(this.TADVehicleInfo, this.TADVehicleInfo_valid);
            aSIHMISyncCarDrivingReply.updateTADConfiguration(this.TADConfiguration, this.TADConfiguration_valid);
            aSIHMISyncCarDrivingReply.updateTADCurrentRollAngle(this.TADCurrentRollAngle, this.TADCurrentRollAngle_valid);
            aSIHMISyncCarDrivingReply.updateTADPosMaxRollAngle(this.TADPosMaxRollAngle, this.TADPosMaxRollAngle_valid);
            aSIHMISyncCarDrivingReply.updateTADNegMaxRollAngle(this.TADNegMaxRollAngle, this.TADNegMaxRollAngle_valid);
            aSIHMISyncCarDrivingReply.updateTADCurrentPitchAngle(this.TADCurrentPitchAngle, this.TADCurrentPitchAngle_valid);
            aSIHMISyncCarDrivingReply.updateTADPosMaxPitch(this.TADPosMaxPitch, this.TADPosMaxPitch_valid);
            aSIHMISyncCarDrivingReply.updateTADNegMaxPitch(this.TADNegMaxPitch, this.TADNegMaxPitch_valid);
            aSIHMISyncCarDrivingReply.updateTADVisibilityState(this.TADVisibilityState, this.TADVisibilityState_valid);
            aSIHMISyncCarDrivingReply.updateSuspensionControlCurrentLevel(this.SuspensionControlCurrentLevel, this.SuspensionControlCurrentLevel_valid);
            aSIHMISyncCarDrivingReply.updateSuspensionControlTargetLevel(this.SuspensionControlTargetLevel, this.SuspensionControlTargetLevel_valid);
            aSIHMISyncCarDrivingReply.updateSuspensionVisibilityState(this.SuspensionVisibilityState, this.SuspensionVisibilityState_valid);
            aSIHMISyncCarDrivingReply.updateDriveSelectActiveProfile(this.DriveSelectActiveProfile, this.DriveSelectActiveProfile_valid);
            aSIHMISyncCarDrivingReply.updateDriveSelectActiveProfileVisibilityState(this.DriveSelectActiveProfileVisibilityState, this.DriveSelectActiveProfileVisibilityState_valid);
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    private void sendAttributeUpdate(long[] lArray, ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            this.sendAttributeUpdate(lArray[i2], aSIHMISyncCarDrivingReply);
        }
    }

    private void sendAttributeUpdate(long l, ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply) {
        try {
            if (l == 6L) {
                aSIHMISyncCarDrivingReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            } else if (l == 10L) {
                aSIHMISyncCarDrivingReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            } else if (l == 9L) {
                aSIHMISyncCarDrivingReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            } else if (l == 20L) {
                aSIHMISyncCarDrivingReply.updateTADVehicleInfo(this.TADVehicleInfo, this.TADVehicleInfo_valid);
            } else if (l == 22L) {
                aSIHMISyncCarDrivingReply.updateTADConfiguration(this.TADConfiguration, this.TADConfiguration_valid);
            } else if (l == 15L) {
                aSIHMISyncCarDrivingReply.updateTADCurrentRollAngle(this.TADCurrentRollAngle, this.TADCurrentRollAngle_valid);
            } else if (l == 19L) {
                aSIHMISyncCarDrivingReply.updateTADPosMaxRollAngle(this.TADPosMaxRollAngle, this.TADPosMaxRollAngle_valid);
            } else if (l == 17L) {
                aSIHMISyncCarDrivingReply.updateTADNegMaxRollAngle(this.TADNegMaxRollAngle, this.TADNegMaxRollAngle_valid);
            } else if (l == 14L) {
                aSIHMISyncCarDrivingReply.updateTADCurrentPitchAngle(this.TADCurrentPitchAngle, this.TADCurrentPitchAngle_valid);
            } else if (l == 18L) {
                aSIHMISyncCarDrivingReply.updateTADPosMaxPitch(this.TADPosMaxPitch, this.TADPosMaxPitch_valid);
            } else if (l == 16L) {
                aSIHMISyncCarDrivingReply.updateTADNegMaxPitch(this.TADNegMaxPitch, this.TADNegMaxPitch_valid);
            } else if (l == 21L) {
                aSIHMISyncCarDrivingReply.updateTADVisibilityState(this.TADVisibilityState, this.TADVisibilityState_valid);
            } else if (l == 11L) {
                aSIHMISyncCarDrivingReply.updateSuspensionControlCurrentLevel(this.SuspensionControlCurrentLevel, this.SuspensionControlCurrentLevel_valid);
            } else if (l == 12L) {
                aSIHMISyncCarDrivingReply.updateSuspensionControlTargetLevel(this.SuspensionControlTargetLevel, this.SuspensionControlTargetLevel_valid);
            } else if (l == 13L) {
                aSIHMISyncCarDrivingReply.updateSuspensionVisibilityState(this.SuspensionVisibilityState, this.SuspensionVisibilityState_valid);
            } else if (l == 7L) {
                aSIHMISyncCarDrivingReply.updateDriveSelectActiveProfile(this.DriveSelectActiveProfile, this.DriveSelectActiveProfile_valid);
            } else if (l == 8L) {
                aSIHMISyncCarDrivingReply.updateDriveSelectActiveProfileVisibilityState(this.DriveSelectActiveProfileVisibilityState, this.DriveSelectActiveProfileVisibilityState_valid);
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
        this.ASIVersion = ASIHMISyncCarDrivingAbstractBaseService.copyString(string);
        this.ASIVersion_valid = bl;
        List list = this.baseService.getNotifications(6);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply = (ASIHMISyncCarDrivingReply)iterator.next();
            try {
                aSIHMISyncCarDrivingReply.updateASIVersion(string, bl);
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
        List list = this.baseService.getNotifications(10);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply = (ASIHMISyncCarDrivingReply)iterator.next();
            try {
                aSIHMISyncCarDrivingReply.updateRequestIDs(sArray, bl);
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
        List list = this.baseService.getNotifications(9);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply = (ASIHMISyncCarDrivingReply)iterator.next();
            try {
                aSIHMISyncCarDrivingReply.updateReplyIDs(sArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateTADVehicleInfo(TADVehicleInfo tADVehicleInfo) throws MethodException {
        this.updateTADVehicleInfo(tADVehicleInfo, true);
    }

    public void updateTADVehicleInfo(TADVehicleInfo tADVehicleInfo, boolean bl) throws MethodException {
        this.TADVehicleInfo = ASIHMISyncCarDrivingAbstractBaseService.copyTADVehicleInfo(tADVehicleInfo);
        this.TADVehicleInfo_valid = bl;
        List list = this.baseService.getNotifications(20);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply = (ASIHMISyncCarDrivingReply)iterator.next();
            try {
                aSIHMISyncCarDrivingReply.updateTADVehicleInfo(tADVehicleInfo, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateTADConfiguration(TADConfiguration tADConfiguration) throws MethodException {
        this.updateTADConfiguration(tADConfiguration, true);
    }

    public void updateTADConfiguration(TADConfiguration tADConfiguration, boolean bl) throws MethodException {
        this.TADConfiguration = ASIHMISyncCarDrivingAbstractBaseService.copyTADConfiguration(tADConfiguration);
        this.TADConfiguration_valid = bl;
        List list = this.baseService.getNotifications(22);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply = (ASIHMISyncCarDrivingReply)iterator.next();
            try {
                aSIHMISyncCarDrivingReply.updateTADConfiguration(tADConfiguration, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateTADCurrentRollAngle(float f2) throws MethodException {
        this.updateTADCurrentRollAngle(f2, true);
    }

    public void updateTADCurrentRollAngle(float f2, boolean bl) throws MethodException {
        this.TADCurrentRollAngle = f2;
        this.TADCurrentRollAngle_valid = bl;
        List list = this.baseService.getNotifications(15);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply = (ASIHMISyncCarDrivingReply)iterator.next();
            try {
                aSIHMISyncCarDrivingReply.updateTADCurrentRollAngle(f2, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateTADPosMaxRollAngle(float f2) throws MethodException {
        this.updateTADPosMaxRollAngle(f2, true);
    }

    public void updateTADPosMaxRollAngle(float f2, boolean bl) throws MethodException {
        this.TADPosMaxRollAngle = f2;
        this.TADPosMaxRollAngle_valid = bl;
        List list = this.baseService.getNotifications(19);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply = (ASIHMISyncCarDrivingReply)iterator.next();
            try {
                aSIHMISyncCarDrivingReply.updateTADPosMaxRollAngle(f2, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateTADNegMaxRollAngle(float f2) throws MethodException {
        this.updateTADNegMaxRollAngle(f2, true);
    }

    public void updateTADNegMaxRollAngle(float f2, boolean bl) throws MethodException {
        this.TADNegMaxRollAngle = f2;
        this.TADNegMaxRollAngle_valid = bl;
        List list = this.baseService.getNotifications(17);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply = (ASIHMISyncCarDrivingReply)iterator.next();
            try {
                aSIHMISyncCarDrivingReply.updateTADNegMaxRollAngle(f2, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateTADCurrentPitchAngle(float f2) throws MethodException {
        this.updateTADCurrentPitchAngle(f2, true);
    }

    public void updateTADCurrentPitchAngle(float f2, boolean bl) throws MethodException {
        this.TADCurrentPitchAngle = f2;
        this.TADCurrentPitchAngle_valid = bl;
        List list = this.baseService.getNotifications(14);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply = (ASIHMISyncCarDrivingReply)iterator.next();
            try {
                aSIHMISyncCarDrivingReply.updateTADCurrentPitchAngle(f2, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateTADPosMaxPitch(float f2) throws MethodException {
        this.updateTADPosMaxPitch(f2, true);
    }

    public void updateTADPosMaxPitch(float f2, boolean bl) throws MethodException {
        this.TADPosMaxPitch = f2;
        this.TADPosMaxPitch_valid = bl;
        List list = this.baseService.getNotifications(18);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply = (ASIHMISyncCarDrivingReply)iterator.next();
            try {
                aSIHMISyncCarDrivingReply.updateTADPosMaxPitch(f2, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateTADNegMaxPitch(float f2) throws MethodException {
        this.updateTADNegMaxPitch(f2, true);
    }

    public void updateTADNegMaxPitch(float f2, boolean bl) throws MethodException {
        this.TADNegMaxPitch = f2;
        this.TADNegMaxPitch_valid = bl;
        List list = this.baseService.getNotifications(16);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply = (ASIHMISyncCarDrivingReply)iterator.next();
            try {
                aSIHMISyncCarDrivingReply.updateTADNegMaxPitch(f2, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateTADVisibilityState(int n) throws MethodException {
        this.updateTADVisibilityState(n, true);
    }

    public void updateTADVisibilityState(int n, boolean bl) throws MethodException {
        this.TADVisibilityState = n;
        this.TADVisibilityState_valid = bl;
        List list = this.baseService.getNotifications(21);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply = (ASIHMISyncCarDrivingReply)iterator.next();
            try {
                aSIHMISyncCarDrivingReply.updateTADVisibilityState(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateSuspensionControlCurrentLevel(int n) throws MethodException {
        this.updateSuspensionControlCurrentLevel(n, true);
    }

    public void updateSuspensionControlCurrentLevel(int n, boolean bl) throws MethodException {
        this.SuspensionControlCurrentLevel = n;
        this.SuspensionControlCurrentLevel_valid = bl;
        List list = this.baseService.getNotifications(11);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply = (ASIHMISyncCarDrivingReply)iterator.next();
            try {
                aSIHMISyncCarDrivingReply.updateSuspensionControlCurrentLevel(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateSuspensionControlTargetLevel(int n) throws MethodException {
        this.updateSuspensionControlTargetLevel(n, true);
    }

    public void updateSuspensionControlTargetLevel(int n, boolean bl) throws MethodException {
        this.SuspensionControlTargetLevel = n;
        this.SuspensionControlTargetLevel_valid = bl;
        List list = this.baseService.getNotifications(12);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply = (ASIHMISyncCarDrivingReply)iterator.next();
            try {
                aSIHMISyncCarDrivingReply.updateSuspensionControlTargetLevel(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateSuspensionVisibilityState(int[] nArray) throws MethodException {
        this.updateSuspensionVisibilityState(nArray, true);
    }

    public void updateSuspensionVisibilityState(int[] nArray, boolean bl) throws MethodException {
        if (nArray != null) {
            this.SuspensionVisibilityState = new int[nArray.length];
            System.arraycopy((Object)nArray, 0, (Object)this.SuspensionVisibilityState, 0, nArray.length);
        } else {
            this.SuspensionVisibilityState = null;
        }
        this.SuspensionVisibilityState_valid = bl;
        List list = this.baseService.getNotifications(13);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply = (ASIHMISyncCarDrivingReply)iterator.next();
            try {
                aSIHMISyncCarDrivingReply.updateSuspensionVisibilityState(nArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateDriveSelectActiveProfile(int n) throws MethodException {
        this.updateDriveSelectActiveProfile(n, true);
    }

    public void updateDriveSelectActiveProfile(int n, boolean bl) throws MethodException {
        this.DriveSelectActiveProfile = n;
        this.DriveSelectActiveProfile_valid = bl;
        List list = this.baseService.getNotifications(7);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply = (ASIHMISyncCarDrivingReply)iterator.next();
            try {
                aSIHMISyncCarDrivingReply.updateDriveSelectActiveProfile(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateDriveSelectActiveProfileVisibilityState(int n) throws MethodException {
        this.updateDriveSelectActiveProfileVisibilityState(n, true);
    }

    public void updateDriveSelectActiveProfileVisibilityState(int n, boolean bl) throws MethodException {
        this.DriveSelectActiveProfileVisibilityState = n;
        this.DriveSelectActiveProfileVisibilityState_valid = bl;
        List list = this.baseService.getNotifications(8);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply = (ASIHMISyncCarDrivingReply)iterator.next();
            try {
                aSIHMISyncCarDrivingReply.updateDriveSelectActiveProfileVisibilityState(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    private static class AttributesBitMapProvider
    implements IAttributeBitMapProvider {
        private final HashMap map = new HashMap();

        public AttributesBitMapProvider() {
            this.map.put(new Long(6L), new Integer(0));
            this.map.put(new Long(10L), new Integer(1));
            this.map.put(new Long(9L), new Integer(2));
            this.map.put(new Long(20L), new Integer(3));
            this.map.put(new Long(22L), new Integer(4));
            this.map.put(new Long(15L), new Integer(5));
            this.map.put(new Long(19L), new Integer(6));
            this.map.put(new Long(17L), new Integer(7));
            this.map.put(new Long(14L), new Integer(8));
            this.map.put(new Long(18L), new Integer(9));
            this.map.put(new Long(16L), new Integer(10));
            this.map.put(new Long(21L), new Integer(11));
            this.map.put(new Long(11L), new Integer(12));
            this.map.put(new Long(12L), new Integer(13));
            this.map.put(new Long(13L), new Integer(14));
            this.map.put(new Long(7L), new Integer(15));
            this.map.put(new Long(8L), new Integer(16));
        }

        public int getAttributeBit(long l) {
            Integer n = (Integer)this.map.get(new Long(l));
            return n;
        }

        public int getAttributesCount() {
            return 17;
        }
    }
}

