/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.sound.impl;

import de.esolutions.fw.comm.asi.hmisync.sound.ASIHMISyncSoundReply;
import de.esolutions.fw.comm.asi.hmisync.sound.ASIHMISyncSoundS;
import de.esolutions.fw.comm.asi.hmisync.sound.SoundRange;
import de.esolutions.fw.comm.asi.hmisync.sound.SoundShapeRange;
import de.esolutions.fw.comm.asi.hmisync.sound.SoundShapeValue;
import de.esolutions.fw.comm.attributes.AttributesBaseService;
import de.esolutions.fw.comm.attributes.IAttributeBitMapProvider;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class ASIHMISyncSoundAbstractBaseService
implements ASIHMISyncSoundS {
    private static final CallContext context = CallContext.getContext("ABSTRACTBASESERVICE.asi.hmisync.sound.ASIHMISyncSound");
    private static final int attributesCount = 27;
    private String ASIVersion;
    private boolean ASIVersion_valid = false;
    private short[] RequestIDs;
    private boolean RequestIDs_valid = false;
    private short[] ReplyIDs;
    private boolean ReplyIDs_valid = false;
    private int SoundState;
    private boolean SoundState_valid = false;
    private int Amplifier;
    private boolean Amplifier_valid = false;
    private SoundRange BassRange;
    private boolean BassRange_valid = false;
    private int BassValue;
    private boolean BassValue_valid = false;
    private SoundRange TrebleRange;
    private boolean TrebleRange_valid = false;
    private int TrebleValue;
    private boolean TrebleValue_valid = false;
    private SoundRange BalanceRange;
    private boolean BalanceRange_valid = false;
    private int BalanceValue;
    private boolean BalanceValue_valid = false;
    private SoundRange FaderRange;
    private boolean FaderRange_valid = false;
    private int FaderValue;
    private boolean FaderValue_valid = false;
    private SoundRange SubwooferRange;
    private boolean SubwooferRange_valid = false;
    private int SubwooferValue;
    private boolean SubwooferValue_valid = false;
    private SoundRange SurroundRange;
    private boolean SurroundRange_valid = false;
    private int SurroundValue;
    private boolean SurroundValue_valid = false;
    private SoundRange NoiseCompensationRange;
    private boolean NoiseCompensationRange_valid = false;
    private int NoiseCompensationValue;
    private boolean NoiseCompensationValue_valid = false;
    private SoundRange ThreeDModeRange;
    private boolean ThreeDModeRange_valid = false;
    private int ThreeDModeValue;
    private boolean ThreeDModeValue_valid = false;
    private SoundShapeRange SoundShapeRange;
    private boolean SoundShapeRange_valid = false;
    private SoundShapeValue SoundShapeValue;
    private boolean SoundShapeValue_valid = false;
    private int PresetPositionList;
    private boolean PresetPositionList_valid = false;
    private int PresetPosition;
    private boolean PresetPosition_valid = false;
    private int PresetEQList;
    private boolean PresetEQList_valid = false;
    private int PresetEQ;
    private boolean PresetEQ_valid = false;
    private AttributesBaseService baseService;

    public static String copyString(String string) {
        if (string != null) {
            return new String(string);
        }
        return null;
    }

    public static SoundRange copySoundRange(SoundRange soundRange) {
        if (soundRange == null) {
            return null;
        }
        SoundRange soundRange2 = new SoundRange();
        soundRange2.min = soundRange.min;
        soundRange2.max = soundRange.max;
        return soundRange2;
    }

    public static SoundShapeRange copySoundShapeRange(SoundShapeRange soundShapeRange) {
        if (soundShapeRange == null) {
            return null;
        }
        SoundShapeRange soundShapeRange2 = new SoundShapeRange();
        soundShapeRange2.minXRange = soundShapeRange.minXRange;
        soundShapeRange2.minYRange = soundShapeRange.minYRange;
        soundShapeRange2.minZRange = soundShapeRange.minZRange;
        soundShapeRange2.maxXRange = soundShapeRange.maxXRange;
        soundShapeRange2.maxYRange = soundShapeRange.maxYRange;
        soundShapeRange2.maxZRange = soundShapeRange.maxZRange;
        return soundShapeRange2;
    }

    public static SoundShapeValue copySoundShapeValue(SoundShapeValue soundShapeValue) {
        if (soundShapeValue == null) {
            return null;
        }
        SoundShapeValue soundShapeValue2 = new SoundShapeValue();
        soundShapeValue2.x = soundShapeValue.x;
        soundShapeValue2.y = soundShapeValue.y;
        soundShapeValue2.z = soundShapeValue.z;
        return soundShapeValue2;
    }

    public ASIHMISyncSoundAbstractBaseService() {
        AttributesBitMapProvider attributesBitMapProvider = new AttributesBitMapProvider();
        this.baseService = new AttributesBaseService("ASIHMISyncSound", attributesBitMapProvider);
    }

    public synchronized void setNotification(long l, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        this.baseService.setNotification(l, (Object)aSIHMISyncSoundReply);
        this.sendAttributeUpdate(l, aSIHMISyncSoundReply);
    }

    public synchronized void setNotification(ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        this.baseService.setNotification(aSIHMISyncSoundReply);
        this.sendAttributeUpdate(aSIHMISyncSoundReply);
    }

    public synchronized void setNotification(long[] lArray, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        this.baseService.setNotification(lArray, (Object)aSIHMISyncSoundReply);
        this.sendAttributeUpdate(lArray, aSIHMISyncSoundReply);
    }

    public synchronized void clearNotification(long l, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        this.baseService.clearNotification(l, (Object)aSIHMISyncSoundReply);
    }

    public synchronized void clearNotification(ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        this.baseService.clearNotification(aSIHMISyncSoundReply);
    }

    public synchronized void clearNotification(long[] lArray, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        this.baseService.clearNotification(lArray, (Object)aSIHMISyncSoundReply);
    }

    private void sendAttributeUpdate(ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        try {
            aSIHMISyncSoundReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            aSIHMISyncSoundReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            aSIHMISyncSoundReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            aSIHMISyncSoundReply.updateSoundState(this.SoundState, this.SoundState_valid);
            aSIHMISyncSoundReply.updateAmplifier(this.Amplifier, this.Amplifier_valid);
            aSIHMISyncSoundReply.updateBassRange(this.BassRange, this.BassRange_valid);
            aSIHMISyncSoundReply.updateBassValue(this.BassValue, this.BassValue_valid);
            aSIHMISyncSoundReply.updateTrebleRange(this.TrebleRange, this.TrebleRange_valid);
            aSIHMISyncSoundReply.updateTrebleValue(this.TrebleValue, this.TrebleValue_valid);
            aSIHMISyncSoundReply.updateBalanceRange(this.BalanceRange, this.BalanceRange_valid);
            aSIHMISyncSoundReply.updateBalanceValue(this.BalanceValue, this.BalanceValue_valid);
            aSIHMISyncSoundReply.updateFaderRange(this.FaderRange, this.FaderRange_valid);
            aSIHMISyncSoundReply.updateFaderValue(this.FaderValue, this.FaderValue_valid);
            aSIHMISyncSoundReply.updateSubwooferRange(this.SubwooferRange, this.SubwooferRange_valid);
            aSIHMISyncSoundReply.updateSubwooferValue(this.SubwooferValue, this.SubwooferValue_valid);
            aSIHMISyncSoundReply.updateSurroundRange(this.SurroundRange, this.SurroundRange_valid);
            aSIHMISyncSoundReply.updateSurroundValue(this.SurroundValue, this.SurroundValue_valid);
            aSIHMISyncSoundReply.updateNoiseCompensationRange(this.NoiseCompensationRange, this.NoiseCompensationRange_valid);
            aSIHMISyncSoundReply.updateNoiseCompensationValue(this.NoiseCompensationValue, this.NoiseCompensationValue_valid);
            aSIHMISyncSoundReply.updateThreeDModeRange(this.ThreeDModeRange, this.ThreeDModeRange_valid);
            aSIHMISyncSoundReply.updateThreeDModeValue(this.ThreeDModeValue, this.ThreeDModeValue_valid);
            aSIHMISyncSoundReply.updateSoundShapeRange(this.SoundShapeRange, this.SoundShapeRange_valid);
            aSIHMISyncSoundReply.updateSoundShapeValue(this.SoundShapeValue, this.SoundShapeValue_valid);
            aSIHMISyncSoundReply.updatePresetPositionList(this.PresetPositionList, this.PresetPositionList_valid);
            aSIHMISyncSoundReply.updatePresetPosition(this.PresetPosition, this.PresetPosition_valid);
            aSIHMISyncSoundReply.updatePresetEQList(this.PresetEQList, this.PresetEQList_valid);
            aSIHMISyncSoundReply.updatePresetEQ(this.PresetEQ, this.PresetEQ_valid);
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    private void sendAttributeUpdate(long[] lArray, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            this.sendAttributeUpdate(lArray[i2], aSIHMISyncSoundReply);
        }
    }

    private void sendAttributeUpdate(long l, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        try {
            if (l == 14L) {
                aSIHMISyncSoundReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            } else if (l == 27L) {
                aSIHMISyncSoundReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            } else if (l == 26L) {
                aSIHMISyncSoundReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            } else if (l == 28L) {
                aSIHMISyncSoundReply.updateSoundState(this.SoundState, this.SoundState_valid);
            } else if (l == 15L) {
                aSIHMISyncSoundReply.updateAmplifier(this.Amplifier, this.Amplifier_valid);
            } else if (l == 18L) {
                aSIHMISyncSoundReply.updateBassRange(this.BassRange, this.BassRange_valid);
            } else if (l == 19L) {
                aSIHMISyncSoundReply.updateBassValue(this.BassValue, this.BassValue_valid);
            } else if (l == 33L) {
                aSIHMISyncSoundReply.updateTrebleRange(this.TrebleRange, this.TrebleRange_valid);
            } else if (l == 34L) {
                aSIHMISyncSoundReply.updateTrebleValue(this.TrebleValue, this.TrebleValue_valid);
            } else if (l == 16L) {
                aSIHMISyncSoundReply.updateBalanceRange(this.BalanceRange, this.BalanceRange_valid);
            } else if (l == 17L) {
                aSIHMISyncSoundReply.updateBalanceValue(this.BalanceValue, this.BalanceValue_valid);
            } else if (l == 20L) {
                aSIHMISyncSoundReply.updateFaderRange(this.FaderRange, this.FaderRange_valid);
            } else if (l == 21L) {
                aSIHMISyncSoundReply.updateFaderValue(this.FaderValue, this.FaderValue_valid);
            } else if (l == 29L) {
                aSIHMISyncSoundReply.updateSubwooferRange(this.SubwooferRange, this.SubwooferRange_valid);
            } else if (l == 30L) {
                aSIHMISyncSoundReply.updateSubwooferValue(this.SubwooferValue, this.SubwooferValue_valid);
            } else if (l == 31L) {
                aSIHMISyncSoundReply.updateSurroundRange(this.SurroundRange, this.SurroundRange_valid);
            } else if (l == 32L) {
                aSIHMISyncSoundReply.updateSurroundValue(this.SurroundValue, this.SurroundValue_valid);
            } else if (l == 22L) {
                aSIHMISyncSoundReply.updateNoiseCompensationRange(this.NoiseCompensationRange, this.NoiseCompensationRange_valid);
            } else if (l == 23L) {
                aSIHMISyncSoundReply.updateNoiseCompensationValue(this.NoiseCompensationValue, this.NoiseCompensationValue_valid);
            } else if (l == 39L) {
                aSIHMISyncSoundReply.updateThreeDModeRange(this.ThreeDModeRange, this.ThreeDModeRange_valid);
            } else if (l == 40L) {
                aSIHMISyncSoundReply.updateThreeDModeValue(this.ThreeDModeValue, this.ThreeDModeValue_valid);
            } else if (l == 42L) {
                aSIHMISyncSoundReply.updateSoundShapeRange(this.SoundShapeRange, this.SoundShapeRange_valid);
            } else if (l == 43L) {
                aSIHMISyncSoundReply.updateSoundShapeValue(this.SoundShapeValue, this.SoundShapeValue_valid);
            } else if (l == 25L) {
                aSIHMISyncSoundReply.updatePresetPositionList(this.PresetPositionList, this.PresetPositionList_valid);
            } else if (l == 24L) {
                aSIHMISyncSoundReply.updatePresetPosition(this.PresetPosition, this.PresetPosition_valid);
            } else if (l == 38L) {
                aSIHMISyncSoundReply.updatePresetEQList(this.PresetEQList, this.PresetEQList_valid);
            } else if (l == 37L) {
                aSIHMISyncSoundReply.updatePresetEQ(this.PresetEQ, this.PresetEQ_valid);
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
        this.ASIVersion = ASIHMISyncSoundAbstractBaseService.copyString(string);
        this.ASIVersion_valid = bl;
        List list = this.baseService.getNotifications(14);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateASIVersion(string, bl);
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
        List list = this.baseService.getNotifications(27);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateRequestIDs(sArray, bl);
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
        List list = this.baseService.getNotifications(26);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateReplyIDs(sArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateSoundState(int n) throws MethodException {
        this.updateSoundState(n, true);
    }

    public void updateSoundState(int n, boolean bl) throws MethodException {
        this.SoundState = n;
        this.SoundState_valid = bl;
        List list = this.baseService.getNotifications(28);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateSoundState(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateAmplifier(int n) throws MethodException {
        this.updateAmplifier(n, true);
    }

    public void updateAmplifier(int n, boolean bl) throws MethodException {
        this.Amplifier = n;
        this.Amplifier_valid = bl;
        List list = this.baseService.getNotifications(15);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateAmplifier(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateBassRange(SoundRange soundRange) throws MethodException {
        this.updateBassRange(soundRange, true);
    }

    public void updateBassRange(SoundRange soundRange, boolean bl) throws MethodException {
        this.BassRange = ASIHMISyncSoundAbstractBaseService.copySoundRange(soundRange);
        this.BassRange_valid = bl;
        List list = this.baseService.getNotifications(18);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateBassRange(soundRange, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateBassValue(int n) throws MethodException {
        this.updateBassValue(n, true);
    }

    public void updateBassValue(int n, boolean bl) throws MethodException {
        this.BassValue = n;
        this.BassValue_valid = bl;
        List list = this.baseService.getNotifications(19);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateBassValue(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateTrebleRange(SoundRange soundRange) throws MethodException {
        this.updateTrebleRange(soundRange, true);
    }

    public void updateTrebleRange(SoundRange soundRange, boolean bl) throws MethodException {
        this.TrebleRange = ASIHMISyncSoundAbstractBaseService.copySoundRange(soundRange);
        this.TrebleRange_valid = bl;
        List list = this.baseService.getNotifications(33);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateTrebleRange(soundRange, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateTrebleValue(int n) throws MethodException {
        this.updateTrebleValue(n, true);
    }

    public void updateTrebleValue(int n, boolean bl) throws MethodException {
        this.TrebleValue = n;
        this.TrebleValue_valid = bl;
        List list = this.baseService.getNotifications(34);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateTrebleValue(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateBalanceRange(SoundRange soundRange) throws MethodException {
        this.updateBalanceRange(soundRange, true);
    }

    public void updateBalanceRange(SoundRange soundRange, boolean bl) throws MethodException {
        this.BalanceRange = ASIHMISyncSoundAbstractBaseService.copySoundRange(soundRange);
        this.BalanceRange_valid = bl;
        List list = this.baseService.getNotifications(16);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateBalanceRange(soundRange, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateBalanceValue(int n) throws MethodException {
        this.updateBalanceValue(n, true);
    }

    public void updateBalanceValue(int n, boolean bl) throws MethodException {
        this.BalanceValue = n;
        this.BalanceValue_valid = bl;
        List list = this.baseService.getNotifications(17);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateBalanceValue(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateFaderRange(SoundRange soundRange) throws MethodException {
        this.updateFaderRange(soundRange, true);
    }

    public void updateFaderRange(SoundRange soundRange, boolean bl) throws MethodException {
        this.FaderRange = ASIHMISyncSoundAbstractBaseService.copySoundRange(soundRange);
        this.FaderRange_valid = bl;
        List list = this.baseService.getNotifications(20);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateFaderRange(soundRange, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateFaderValue(int n) throws MethodException {
        this.updateFaderValue(n, true);
    }

    public void updateFaderValue(int n, boolean bl) throws MethodException {
        this.FaderValue = n;
        this.FaderValue_valid = bl;
        List list = this.baseService.getNotifications(21);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateFaderValue(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateSubwooferRange(SoundRange soundRange) throws MethodException {
        this.updateSubwooferRange(soundRange, true);
    }

    public void updateSubwooferRange(SoundRange soundRange, boolean bl) throws MethodException {
        this.SubwooferRange = ASIHMISyncSoundAbstractBaseService.copySoundRange(soundRange);
        this.SubwooferRange_valid = bl;
        List list = this.baseService.getNotifications(29);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateSubwooferRange(soundRange, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateSubwooferValue(int n) throws MethodException {
        this.updateSubwooferValue(n, true);
    }

    public void updateSubwooferValue(int n, boolean bl) throws MethodException {
        this.SubwooferValue = n;
        this.SubwooferValue_valid = bl;
        List list = this.baseService.getNotifications(30);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateSubwooferValue(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateSurroundRange(SoundRange soundRange) throws MethodException {
        this.updateSurroundRange(soundRange, true);
    }

    public void updateSurroundRange(SoundRange soundRange, boolean bl) throws MethodException {
        this.SurroundRange = ASIHMISyncSoundAbstractBaseService.copySoundRange(soundRange);
        this.SurroundRange_valid = bl;
        List list = this.baseService.getNotifications(31);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateSurroundRange(soundRange, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateSurroundValue(int n) throws MethodException {
        this.updateSurroundValue(n, true);
    }

    public void updateSurroundValue(int n, boolean bl) throws MethodException {
        this.SurroundValue = n;
        this.SurroundValue_valid = bl;
        List list = this.baseService.getNotifications(32);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateSurroundValue(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateNoiseCompensationRange(SoundRange soundRange) throws MethodException {
        this.updateNoiseCompensationRange(soundRange, true);
    }

    public void updateNoiseCompensationRange(SoundRange soundRange, boolean bl) throws MethodException {
        this.NoiseCompensationRange = ASIHMISyncSoundAbstractBaseService.copySoundRange(soundRange);
        this.NoiseCompensationRange_valid = bl;
        List list = this.baseService.getNotifications(22);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateNoiseCompensationRange(soundRange, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateNoiseCompensationValue(int n) throws MethodException {
        this.updateNoiseCompensationValue(n, true);
    }

    public void updateNoiseCompensationValue(int n, boolean bl) throws MethodException {
        this.NoiseCompensationValue = n;
        this.NoiseCompensationValue_valid = bl;
        List list = this.baseService.getNotifications(23);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateNoiseCompensationValue(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateThreeDModeRange(SoundRange soundRange) throws MethodException {
        this.updateThreeDModeRange(soundRange, true);
    }

    public void updateThreeDModeRange(SoundRange soundRange, boolean bl) throws MethodException {
        this.ThreeDModeRange = ASIHMISyncSoundAbstractBaseService.copySoundRange(soundRange);
        this.ThreeDModeRange_valid = bl;
        List list = this.baseService.getNotifications(39);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateThreeDModeRange(soundRange, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateThreeDModeValue(int n) throws MethodException {
        this.updateThreeDModeValue(n, true);
    }

    public void updateThreeDModeValue(int n, boolean bl) throws MethodException {
        this.ThreeDModeValue = n;
        this.ThreeDModeValue_valid = bl;
        List list = this.baseService.getNotifications(40);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateThreeDModeValue(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateSoundShapeRange(SoundShapeRange soundShapeRange) throws MethodException {
        this.updateSoundShapeRange(soundShapeRange, true);
    }

    public void updateSoundShapeRange(SoundShapeRange soundShapeRange, boolean bl) throws MethodException {
        this.SoundShapeRange = ASIHMISyncSoundAbstractBaseService.copySoundShapeRange(soundShapeRange);
        this.SoundShapeRange_valid = bl;
        List list = this.baseService.getNotifications(42);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateSoundShapeRange(soundShapeRange, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateSoundShapeValue(SoundShapeValue soundShapeValue) throws MethodException {
        this.updateSoundShapeValue(soundShapeValue, true);
    }

    public void updateSoundShapeValue(SoundShapeValue soundShapeValue, boolean bl) throws MethodException {
        this.SoundShapeValue = ASIHMISyncSoundAbstractBaseService.copySoundShapeValue(soundShapeValue);
        this.SoundShapeValue_valid = bl;
        List list = this.baseService.getNotifications(43);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateSoundShapeValue(soundShapeValue, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updatePresetPositionList(int n) throws MethodException {
        this.updatePresetPositionList(n, true);
    }

    public void updatePresetPositionList(int n, boolean bl) throws MethodException {
        this.PresetPositionList = n;
        this.PresetPositionList_valid = bl;
        List list = this.baseService.getNotifications(25);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updatePresetPositionList(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updatePresetPosition(int n) throws MethodException {
        this.updatePresetPosition(n, true);
    }

    public void updatePresetPosition(int n, boolean bl) throws MethodException {
        this.PresetPosition = n;
        this.PresetPosition_valid = bl;
        List list = this.baseService.getNotifications(24);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updatePresetPosition(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updatePresetEQList(int n) throws MethodException {
        this.updatePresetEQList(n, true);
    }

    public void updatePresetEQList(int n, boolean bl) throws MethodException {
        this.PresetEQList = n;
        this.PresetEQList_valid = bl;
        List list = this.baseService.getNotifications(38);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updatePresetEQList(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updatePresetEQ(int n) throws MethodException {
        this.updatePresetEQ(n, true);
    }

    public void updatePresetEQ(int n, boolean bl) throws MethodException {
        this.PresetEQ = n;
        this.PresetEQ_valid = bl;
        List list = this.baseService.getNotifications(37);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updatePresetEQ(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    private static class AttributesBitMapProvider
    implements IAttributeBitMapProvider {
        private final HashMap map = new HashMap();

        public AttributesBitMapProvider() {
            this.map.put(new Long(14L), new Integer(0));
            this.map.put(new Long(27L), new Integer(1));
            this.map.put(new Long(26L), new Integer(2));
            this.map.put(new Long(28L), new Integer(3));
            this.map.put(new Long(15L), new Integer(4));
            this.map.put(new Long(18L), new Integer(5));
            this.map.put(new Long(19L), new Integer(6));
            this.map.put(new Long(33L), new Integer(7));
            this.map.put(new Long(34L), new Integer(8));
            this.map.put(new Long(16L), new Integer(9));
            this.map.put(new Long(17L), new Integer(10));
            this.map.put(new Long(20L), new Integer(11));
            this.map.put(new Long(21L), new Integer(12));
            this.map.put(new Long(29L), new Integer(13));
            this.map.put(new Long(30L), new Integer(14));
            this.map.put(new Long(31L), new Integer(15));
            this.map.put(new Long(32L), new Integer(16));
            this.map.put(new Long(22L), new Integer(17));
            this.map.put(new Long(23L), new Integer(18));
            this.map.put(new Long(39L), new Integer(19));
            this.map.put(new Long(40L), new Integer(20));
            this.map.put(new Long(42L), new Integer(21));
            this.map.put(new Long(43L), new Integer(22));
            this.map.put(new Long(25L), new Integer(23));
            this.map.put(new Long(24L), new Integer(24));
            this.map.put(new Long(38L), new Integer(25));
            this.map.put(new Long(37L), new Integer(26));
        }

        public int getAttributeBit(long l) {
            Integer n = (Integer)this.map.get(new Long(l));
            return n;
        }

        public int getAttributesCount() {
            return 27;
        }
    }
}

