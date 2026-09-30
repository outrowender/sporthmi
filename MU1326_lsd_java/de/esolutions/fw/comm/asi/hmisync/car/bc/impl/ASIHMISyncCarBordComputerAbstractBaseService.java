/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.bc.impl;

import de.esolutions.fw.comm.asi.hmisync.car.FloatBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.IntBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.bc.ASIHMISyncCarBordComputerReply;
import de.esolutions.fw.comm.asi.hmisync.car.bc.ASIHMISyncCarBordComputerS;
import de.esolutions.fw.comm.asi.hmisync.car.bc.BCTermGeneralData;
import de.esolutions.fw.comm.attributes.AttributesBaseService;
import de.esolutions.fw.comm.attributes.IAttributeBitMapProvider;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class ASIHMISyncCarBordComputerAbstractBaseService
implements ASIHMISyncCarBordComputerS {
    private static final CallContext context = CallContext.getContext("ABSTRACTBASESERVICE.asi.hmisync.car.bc.ASIHMISyncCarBordComputer");
    private static final int attributesCount = 19;
    private String ASIVersion;
    private boolean ASIVersion_valid = false;
    private short[] RequestIDs;
    private boolean RequestIDs_valid = false;
    private short[] ReplyIDs;
    private boolean ReplyIDs_valid = false;
    private int BCShortTermAverageConsumption1Visibility;
    private boolean BCShortTermAverageConsumption1Visibility_valid = false;
    private FloatBaseType BCShortTermAverageConsumption1;
    private boolean BCShortTermAverageConsumption1_valid = false;
    private int BCShortTermAverageConsumption2Visibility;
    private boolean BCShortTermAverageConsumption2Visibility_valid = false;
    private FloatBaseType BCShortTermAverageConsumption2;
    private boolean BCShortTermAverageConsumption2_valid = false;
    private int BCLongTermAverageConsumption1Visibility;
    private boolean BCLongTermAverageConsumption1Visibility_valid = false;
    private FloatBaseType BCLongTermAverageConsumption1;
    private boolean BCLongTermAverageConsumption1_valid = false;
    private int BCLongTermAverageConsumption2Visibility;
    private boolean BCLongTermAverageConsumption2Visibility_valid = false;
    private FloatBaseType BCLongTermAverageConsumption2;
    private boolean BCLongTermAverageConsumption2_valid = false;
    private int BCCurrentRange1Visibility;
    private boolean BCCurrentRange1Visibility_valid = false;
    private IntBaseType BCCurrentRange1;
    private boolean BCCurrentRange1_valid = false;
    private int BCCurrentRange2Visibility;
    private boolean BCCurrentRange2Visibility_valid = false;
    private IntBaseType BCCurrentRange2;
    private boolean BCCurrentRange2_valid = false;
    private int BCShortTermGeneralVisibility;
    private boolean BCShortTermGeneralVisibility_valid = false;
    private BCTermGeneralData BCShortTermGeneral;
    private boolean BCShortTermGeneral_valid = false;
    private int BCLongTermGeneralVisibility;
    private boolean BCLongTermGeneralVisibility_valid = false;
    private BCTermGeneralData BCLongTermGeneral;
    private boolean BCLongTermGeneral_valid = false;
    private AttributesBaseService baseService;

    public static String copyString(String string) {
        if (string != null) {
            return new String(string);
        }
        return null;
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

    public static BCTermGeneralData copyBCTermGeneralData(BCTermGeneralData bCTermGeneralData) {
        if (bCTermGeneralData == null) {
            return null;
        }
        BCTermGeneralData bCTermGeneralData2 = new BCTermGeneralData();
        bCTermGeneralData2.distance = ASIHMISyncCarBordComputerAbstractBaseService.copyFloatBaseType(bCTermGeneralData.distance);
        bCTermGeneralData2.speed = ASIHMISyncCarBordComputerAbstractBaseService.copyFloatBaseType(bCTermGeneralData.speed);
        bCTermGeneralData2.timeValue = bCTermGeneralData.timeValue;
        return bCTermGeneralData2;
    }

    public ASIHMISyncCarBordComputerAbstractBaseService() {
        AttributesBitMapProvider attributesBitMapProvider = new AttributesBitMapProvider();
        this.baseService = new AttributesBaseService("ASIHMISyncCarBordComputer", attributesBitMapProvider);
    }

    public synchronized void setNotification(long l, ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply) {
        this.baseService.setNotification(l, (Object)aSIHMISyncCarBordComputerReply);
        this.sendAttributeUpdate(l, aSIHMISyncCarBordComputerReply);
    }

    public synchronized void setNotification(ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply) {
        this.baseService.setNotification(aSIHMISyncCarBordComputerReply);
        this.sendAttributeUpdate(aSIHMISyncCarBordComputerReply);
    }

    public synchronized void setNotification(long[] lArray, ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply) {
        this.baseService.setNotification(lArray, (Object)aSIHMISyncCarBordComputerReply);
        this.sendAttributeUpdate(lArray, aSIHMISyncCarBordComputerReply);
    }

    public synchronized void clearNotification(long l, ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply) {
        this.baseService.clearNotification(l, (Object)aSIHMISyncCarBordComputerReply);
    }

    public synchronized void clearNotification(ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply) {
        this.baseService.clearNotification(aSIHMISyncCarBordComputerReply);
    }

    public synchronized void clearNotification(long[] lArray, ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply) {
        this.baseService.clearNotification(lArray, (Object)aSIHMISyncCarBordComputerReply);
    }

    private void sendAttributeUpdate(ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply) {
        try {
            aSIHMISyncCarBordComputerReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            aSIHMISyncCarBordComputerReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            aSIHMISyncCarBordComputerReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            aSIHMISyncCarBordComputerReply.updateBCShortTermAverageConsumption1Visibility(this.BCShortTermAverageConsumption1Visibility, this.BCShortTermAverageConsumption1Visibility_valid);
            aSIHMISyncCarBordComputerReply.updateBCShortTermAverageConsumption1(this.BCShortTermAverageConsumption1, this.BCShortTermAverageConsumption1_valid);
            aSIHMISyncCarBordComputerReply.updateBCShortTermAverageConsumption2Visibility(this.BCShortTermAverageConsumption2Visibility, this.BCShortTermAverageConsumption2Visibility_valid);
            aSIHMISyncCarBordComputerReply.updateBCShortTermAverageConsumption2(this.BCShortTermAverageConsumption2, this.BCShortTermAverageConsumption2_valid);
            aSIHMISyncCarBordComputerReply.updateBCLongTermAverageConsumption1Visibility(this.BCLongTermAverageConsumption1Visibility, this.BCLongTermAverageConsumption1Visibility_valid);
            aSIHMISyncCarBordComputerReply.updateBCLongTermAverageConsumption1(this.BCLongTermAverageConsumption1, this.BCLongTermAverageConsumption1_valid);
            aSIHMISyncCarBordComputerReply.updateBCLongTermAverageConsumption2Visibility(this.BCLongTermAverageConsumption2Visibility, this.BCLongTermAverageConsumption2Visibility_valid);
            aSIHMISyncCarBordComputerReply.updateBCLongTermAverageConsumption2(this.BCLongTermAverageConsumption2, this.BCLongTermAverageConsumption2_valid);
            aSIHMISyncCarBordComputerReply.updateBCCurrentRange1Visibility(this.BCCurrentRange1Visibility, this.BCCurrentRange1Visibility_valid);
            aSIHMISyncCarBordComputerReply.updateBCCurrentRange1(this.BCCurrentRange1, this.BCCurrentRange1_valid);
            aSIHMISyncCarBordComputerReply.updateBCCurrentRange2Visibility(this.BCCurrentRange2Visibility, this.BCCurrentRange2Visibility_valid);
            aSIHMISyncCarBordComputerReply.updateBCCurrentRange2(this.BCCurrentRange2, this.BCCurrentRange2_valid);
            aSIHMISyncCarBordComputerReply.updateBCShortTermGeneralVisibility(this.BCShortTermGeneralVisibility, this.BCShortTermGeneralVisibility_valid);
            aSIHMISyncCarBordComputerReply.updateBCShortTermGeneral(this.BCShortTermGeneral, this.BCShortTermGeneral_valid);
            aSIHMISyncCarBordComputerReply.updateBCLongTermGeneralVisibility(this.BCLongTermGeneralVisibility, this.BCLongTermGeneralVisibility_valid);
            aSIHMISyncCarBordComputerReply.updateBCLongTermGeneral(this.BCLongTermGeneral, this.BCLongTermGeneral_valid);
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    private void sendAttributeUpdate(long[] lArray, ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            this.sendAttributeUpdate(lArray[i2], aSIHMISyncCarBordComputerReply);
        }
    }

    private void sendAttributeUpdate(long l, ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply) {
        try {
            if (l == 6L) {
                aSIHMISyncCarBordComputerReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            } else if (l == 24L) {
                aSIHMISyncCarBordComputerReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            } else if (l == 23L) {
                aSIHMISyncCarBordComputerReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            } else if (l == 18L) {
                aSIHMISyncCarBordComputerReply.updateBCShortTermAverageConsumption1Visibility(this.BCShortTermAverageConsumption1Visibility, this.BCShortTermAverageConsumption1Visibility_valid);
            } else if (l == 17L) {
                aSIHMISyncCarBordComputerReply.updateBCShortTermAverageConsumption1(this.BCShortTermAverageConsumption1, this.BCShortTermAverageConsumption1_valid);
            } else if (l == 20L) {
                aSIHMISyncCarBordComputerReply.updateBCShortTermAverageConsumption2Visibility(this.BCShortTermAverageConsumption2Visibility, this.BCShortTermAverageConsumption2Visibility_valid);
            } else if (l == 19L) {
                aSIHMISyncCarBordComputerReply.updateBCShortTermAverageConsumption2(this.BCShortTermAverageConsumption2, this.BCShortTermAverageConsumption2_valid);
            } else if (l == 12L) {
                aSIHMISyncCarBordComputerReply.updateBCLongTermAverageConsumption1Visibility(this.BCLongTermAverageConsumption1Visibility, this.BCLongTermAverageConsumption1Visibility_valid);
            } else if (l == 11L) {
                aSIHMISyncCarBordComputerReply.updateBCLongTermAverageConsumption1(this.BCLongTermAverageConsumption1, this.BCLongTermAverageConsumption1_valid);
            } else if (l == 14L) {
                aSIHMISyncCarBordComputerReply.updateBCLongTermAverageConsumption2Visibility(this.BCLongTermAverageConsumption2Visibility, this.BCLongTermAverageConsumption2Visibility_valid);
            } else if (l == 13L) {
                aSIHMISyncCarBordComputerReply.updateBCLongTermAverageConsumption2(this.BCLongTermAverageConsumption2, this.BCLongTermAverageConsumption2_valid);
            } else if (l == 8L) {
                aSIHMISyncCarBordComputerReply.updateBCCurrentRange1Visibility(this.BCCurrentRange1Visibility, this.BCCurrentRange1Visibility_valid);
            } else if (l == 7L) {
                aSIHMISyncCarBordComputerReply.updateBCCurrentRange1(this.BCCurrentRange1, this.BCCurrentRange1_valid);
            } else if (l == 10L) {
                aSIHMISyncCarBordComputerReply.updateBCCurrentRange2Visibility(this.BCCurrentRange2Visibility, this.BCCurrentRange2Visibility_valid);
            } else if (l == 9L) {
                aSIHMISyncCarBordComputerReply.updateBCCurrentRange2(this.BCCurrentRange2, this.BCCurrentRange2_valid);
            } else if (l == 22L) {
                aSIHMISyncCarBordComputerReply.updateBCShortTermGeneralVisibility(this.BCShortTermGeneralVisibility, this.BCShortTermGeneralVisibility_valid);
            } else if (l == 21L) {
                aSIHMISyncCarBordComputerReply.updateBCShortTermGeneral(this.BCShortTermGeneral, this.BCShortTermGeneral_valid);
            } else if (l == 16L) {
                aSIHMISyncCarBordComputerReply.updateBCLongTermGeneralVisibility(this.BCLongTermGeneralVisibility, this.BCLongTermGeneralVisibility_valid);
            } else if (l == 15L) {
                aSIHMISyncCarBordComputerReply.updateBCLongTermGeneral(this.BCLongTermGeneral, this.BCLongTermGeneral_valid);
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
        this.ASIVersion = ASIHMISyncCarBordComputerAbstractBaseService.copyString(string);
        this.ASIVersion_valid = bl;
        List list = this.baseService.getNotifications(6);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply = (ASIHMISyncCarBordComputerReply)iterator.next();
            try {
                aSIHMISyncCarBordComputerReply.updateASIVersion(string, bl);
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
        List list = this.baseService.getNotifications(24);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply = (ASIHMISyncCarBordComputerReply)iterator.next();
            try {
                aSIHMISyncCarBordComputerReply.updateRequestIDs(sArray, bl);
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
        List list = this.baseService.getNotifications(23);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply = (ASIHMISyncCarBordComputerReply)iterator.next();
            try {
                aSIHMISyncCarBordComputerReply.updateReplyIDs(sArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateBCShortTermAverageConsumption1Visibility(int n) throws MethodException {
        this.updateBCShortTermAverageConsumption1Visibility(n, true);
    }

    public void updateBCShortTermAverageConsumption1Visibility(int n, boolean bl) throws MethodException {
        this.BCShortTermAverageConsumption1Visibility = n;
        this.BCShortTermAverageConsumption1Visibility_valid = bl;
        List list = this.baseService.getNotifications(18);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply = (ASIHMISyncCarBordComputerReply)iterator.next();
            try {
                aSIHMISyncCarBordComputerReply.updateBCShortTermAverageConsumption1Visibility(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateBCShortTermAverageConsumption1(FloatBaseType floatBaseType) throws MethodException {
        this.updateBCShortTermAverageConsumption1(floatBaseType, true);
    }

    public void updateBCShortTermAverageConsumption1(FloatBaseType floatBaseType, boolean bl) throws MethodException {
        this.BCShortTermAverageConsumption1 = ASIHMISyncCarBordComputerAbstractBaseService.copyFloatBaseType(floatBaseType);
        this.BCShortTermAverageConsumption1_valid = bl;
        List list = this.baseService.getNotifications(17);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply = (ASIHMISyncCarBordComputerReply)iterator.next();
            try {
                aSIHMISyncCarBordComputerReply.updateBCShortTermAverageConsumption1(floatBaseType, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateBCShortTermAverageConsumption2Visibility(int n) throws MethodException {
        this.updateBCShortTermAverageConsumption2Visibility(n, true);
    }

    public void updateBCShortTermAverageConsumption2Visibility(int n, boolean bl) throws MethodException {
        this.BCShortTermAverageConsumption2Visibility = n;
        this.BCShortTermAverageConsumption2Visibility_valid = bl;
        List list = this.baseService.getNotifications(20);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply = (ASIHMISyncCarBordComputerReply)iterator.next();
            try {
                aSIHMISyncCarBordComputerReply.updateBCShortTermAverageConsumption2Visibility(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateBCShortTermAverageConsumption2(FloatBaseType floatBaseType) throws MethodException {
        this.updateBCShortTermAverageConsumption2(floatBaseType, true);
    }

    public void updateBCShortTermAverageConsumption2(FloatBaseType floatBaseType, boolean bl) throws MethodException {
        this.BCShortTermAverageConsumption2 = ASIHMISyncCarBordComputerAbstractBaseService.copyFloatBaseType(floatBaseType);
        this.BCShortTermAverageConsumption2_valid = bl;
        List list = this.baseService.getNotifications(19);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply = (ASIHMISyncCarBordComputerReply)iterator.next();
            try {
                aSIHMISyncCarBordComputerReply.updateBCShortTermAverageConsumption2(floatBaseType, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateBCLongTermAverageConsumption1Visibility(int n) throws MethodException {
        this.updateBCLongTermAverageConsumption1Visibility(n, true);
    }

    public void updateBCLongTermAverageConsumption1Visibility(int n, boolean bl) throws MethodException {
        this.BCLongTermAverageConsumption1Visibility = n;
        this.BCLongTermAverageConsumption1Visibility_valid = bl;
        List list = this.baseService.getNotifications(12);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply = (ASIHMISyncCarBordComputerReply)iterator.next();
            try {
                aSIHMISyncCarBordComputerReply.updateBCLongTermAverageConsumption1Visibility(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateBCLongTermAverageConsumption1(FloatBaseType floatBaseType) throws MethodException {
        this.updateBCLongTermAverageConsumption1(floatBaseType, true);
    }

    public void updateBCLongTermAverageConsumption1(FloatBaseType floatBaseType, boolean bl) throws MethodException {
        this.BCLongTermAverageConsumption1 = ASIHMISyncCarBordComputerAbstractBaseService.copyFloatBaseType(floatBaseType);
        this.BCLongTermAverageConsumption1_valid = bl;
        List list = this.baseService.getNotifications(11);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply = (ASIHMISyncCarBordComputerReply)iterator.next();
            try {
                aSIHMISyncCarBordComputerReply.updateBCLongTermAverageConsumption1(floatBaseType, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateBCLongTermAverageConsumption2Visibility(int n) throws MethodException {
        this.updateBCLongTermAverageConsumption2Visibility(n, true);
    }

    public void updateBCLongTermAverageConsumption2Visibility(int n, boolean bl) throws MethodException {
        this.BCLongTermAverageConsumption2Visibility = n;
        this.BCLongTermAverageConsumption2Visibility_valid = bl;
        List list = this.baseService.getNotifications(14);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply = (ASIHMISyncCarBordComputerReply)iterator.next();
            try {
                aSIHMISyncCarBordComputerReply.updateBCLongTermAverageConsumption2Visibility(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateBCLongTermAverageConsumption2(FloatBaseType floatBaseType) throws MethodException {
        this.updateBCLongTermAverageConsumption2(floatBaseType, true);
    }

    public void updateBCLongTermAverageConsumption2(FloatBaseType floatBaseType, boolean bl) throws MethodException {
        this.BCLongTermAverageConsumption2 = ASIHMISyncCarBordComputerAbstractBaseService.copyFloatBaseType(floatBaseType);
        this.BCLongTermAverageConsumption2_valid = bl;
        List list = this.baseService.getNotifications(13);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply = (ASIHMISyncCarBordComputerReply)iterator.next();
            try {
                aSIHMISyncCarBordComputerReply.updateBCLongTermAverageConsumption2(floatBaseType, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateBCCurrentRange1Visibility(int n) throws MethodException {
        this.updateBCCurrentRange1Visibility(n, true);
    }

    public void updateBCCurrentRange1Visibility(int n, boolean bl) throws MethodException {
        this.BCCurrentRange1Visibility = n;
        this.BCCurrentRange1Visibility_valid = bl;
        List list = this.baseService.getNotifications(8);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply = (ASIHMISyncCarBordComputerReply)iterator.next();
            try {
                aSIHMISyncCarBordComputerReply.updateBCCurrentRange1Visibility(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateBCCurrentRange1(IntBaseType intBaseType) throws MethodException {
        this.updateBCCurrentRange1(intBaseType, true);
    }

    public void updateBCCurrentRange1(IntBaseType intBaseType, boolean bl) throws MethodException {
        this.BCCurrentRange1 = ASIHMISyncCarBordComputerAbstractBaseService.copyIntBaseType(intBaseType);
        this.BCCurrentRange1_valid = bl;
        List list = this.baseService.getNotifications(7);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply = (ASIHMISyncCarBordComputerReply)iterator.next();
            try {
                aSIHMISyncCarBordComputerReply.updateBCCurrentRange1(intBaseType, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateBCCurrentRange2Visibility(int n) throws MethodException {
        this.updateBCCurrentRange2Visibility(n, true);
    }

    public void updateBCCurrentRange2Visibility(int n, boolean bl) throws MethodException {
        this.BCCurrentRange2Visibility = n;
        this.BCCurrentRange2Visibility_valid = bl;
        List list = this.baseService.getNotifications(10);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply = (ASIHMISyncCarBordComputerReply)iterator.next();
            try {
                aSIHMISyncCarBordComputerReply.updateBCCurrentRange2Visibility(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateBCCurrentRange2(IntBaseType intBaseType) throws MethodException {
        this.updateBCCurrentRange2(intBaseType, true);
    }

    public void updateBCCurrentRange2(IntBaseType intBaseType, boolean bl) throws MethodException {
        this.BCCurrentRange2 = ASIHMISyncCarBordComputerAbstractBaseService.copyIntBaseType(intBaseType);
        this.BCCurrentRange2_valid = bl;
        List list = this.baseService.getNotifications(9);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply = (ASIHMISyncCarBordComputerReply)iterator.next();
            try {
                aSIHMISyncCarBordComputerReply.updateBCCurrentRange2(intBaseType, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateBCShortTermGeneralVisibility(int n) throws MethodException {
        this.updateBCShortTermGeneralVisibility(n, true);
    }

    public void updateBCShortTermGeneralVisibility(int n, boolean bl) throws MethodException {
        this.BCShortTermGeneralVisibility = n;
        this.BCShortTermGeneralVisibility_valid = bl;
        List list = this.baseService.getNotifications(22);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply = (ASIHMISyncCarBordComputerReply)iterator.next();
            try {
                aSIHMISyncCarBordComputerReply.updateBCShortTermGeneralVisibility(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateBCShortTermGeneral(BCTermGeneralData bCTermGeneralData) throws MethodException {
        this.updateBCShortTermGeneral(bCTermGeneralData, true);
    }

    public void updateBCShortTermGeneral(BCTermGeneralData bCTermGeneralData, boolean bl) throws MethodException {
        this.BCShortTermGeneral = ASIHMISyncCarBordComputerAbstractBaseService.copyBCTermGeneralData(bCTermGeneralData);
        this.BCShortTermGeneral_valid = bl;
        List list = this.baseService.getNotifications(21);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply = (ASIHMISyncCarBordComputerReply)iterator.next();
            try {
                aSIHMISyncCarBordComputerReply.updateBCShortTermGeneral(bCTermGeneralData, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateBCLongTermGeneralVisibility(int n) throws MethodException {
        this.updateBCLongTermGeneralVisibility(n, true);
    }

    public void updateBCLongTermGeneralVisibility(int n, boolean bl) throws MethodException {
        this.BCLongTermGeneralVisibility = n;
        this.BCLongTermGeneralVisibility_valid = bl;
        List list = this.baseService.getNotifications(16);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply = (ASIHMISyncCarBordComputerReply)iterator.next();
            try {
                aSIHMISyncCarBordComputerReply.updateBCLongTermGeneralVisibility(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateBCLongTermGeneral(BCTermGeneralData bCTermGeneralData) throws MethodException {
        this.updateBCLongTermGeneral(bCTermGeneralData, true);
    }

    public void updateBCLongTermGeneral(BCTermGeneralData bCTermGeneralData, boolean bl) throws MethodException {
        this.BCLongTermGeneral = ASIHMISyncCarBordComputerAbstractBaseService.copyBCTermGeneralData(bCTermGeneralData);
        this.BCLongTermGeneral_valid = bl;
        List list = this.baseService.getNotifications(15);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply = (ASIHMISyncCarBordComputerReply)iterator.next();
            try {
                aSIHMISyncCarBordComputerReply.updateBCLongTermGeneral(bCTermGeneralData, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    private static class AttributesBitMapProvider
    implements IAttributeBitMapProvider {
        private final HashMap map = new HashMap();

        public AttributesBitMapProvider() {
            this.map.put(new Long(6L), new Integer(0));
            this.map.put(new Long(24L), new Integer(1));
            this.map.put(new Long(23L), new Integer(2));
            this.map.put(new Long(18L), new Integer(3));
            this.map.put(new Long(17L), new Integer(4));
            this.map.put(new Long(20L), new Integer(5));
            this.map.put(new Long(19L), new Integer(6));
            this.map.put(new Long(12L), new Integer(7));
            this.map.put(new Long(11L), new Integer(8));
            this.map.put(new Long(14L), new Integer(9));
            this.map.put(new Long(13L), new Integer(10));
            this.map.put(new Long(8L), new Integer(11));
            this.map.put(new Long(7L), new Integer(12));
            this.map.put(new Long(10L), new Integer(13));
            this.map.put(new Long(9L), new Integer(14));
            this.map.put(new Long(22L), new Integer(15));
            this.map.put(new Long(21L), new Integer(16));
            this.map.put(new Long(16L), new Integer(17));
            this.map.put(new Long(15L), new Integer(18));
        }

        public int getAttributeBit(long l) {
            Integer n = (Integer)this.map.get(new Long(l));
            return n;
        }

        public int getAttributesCount() {
            return 19;
        }
    }
}

