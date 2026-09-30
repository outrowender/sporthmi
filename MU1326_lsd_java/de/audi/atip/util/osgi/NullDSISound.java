/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.util.osgi;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.audio.DSISound;
import org.dsi.ifc.base.DSIListener;

public class NullDSISound
extends NullService
implements DSISound {
    public NullDSISound(LogChannel logChannel) {
        this(logChannel, 10000);
    }

    public NullDSISound(LogChannel logChannel, int n) {
        super(logChannel, n, "DSISound");
    }

    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.log();
    }

    public void setNotification(int n, DSIListener dSIListener) {
        this.log();
    }

    public void setNotification(DSIListener dSIListener) {
        this.log();
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.log();
    }

    public void clearNotification(int n, DSIListener dSIListener) {
        this.log();
    }

    public void clearNotification(DSIListener dSIListener) {
        this.log();
    }

    public void getVolume(int n, int n2) {
        this.log();
    }

    public void setVolume(int n, int n2, short s) {
        this.log();
    }

    public void decreaseVolume(int n, int n2, short s) {
        this.log();
    }

    public void increaseVolume(int n, int n2, short s) {
        this.log();
    }

    public void getBalance(int n, int n2) {
        this.log();
    }

    public void setBalance(int n, int n2, short s) {
        this.log();
    }

    public void decreaseBalance(int n, int n2, short s) {
        this.log();
    }

    public void increaseBalance(int n, int n2, short s) {
        this.log();
    }

    public void getBass(int n, int n2) {
        this.log();
    }

    public void setBass(int n, int n2, short s) {
        this.log();
    }

    public void decreaseBass(int n, int n2, short s) {
        this.log();
    }

    public void increaseBass(int n, int n2, short s) {
        this.log();
    }

    public void getTreble(int n, int n2) {
        this.log();
    }

    public void setTreble(int n, int n2, short s) {
        this.log();
    }

    public void decreaseTreble(int n, int n2, short s) {
        this.log();
    }

    public void increaseTreble(int n, int n2, short s) {
        this.log();
    }

    public void getFader(int n, int n2) {
        this.log();
    }

    public void setFader(int n, int n2, short s) {
        this.log();
    }

    public void decreaseFader(int n, int n2, short s) {
        this.log();
    }

    public void increaseFader(int n, int n2, short s) {
        this.log();
    }

    public void getSubwoofer(int n, int n2) {
        this.log();
    }

    public void setSubwoofer(int n, int n2, short s) {
        this.log();
    }

    public void getInputGainOffset(int n, int n2) {
        this.log();
    }

    public void setInputGainOffset(int n, int n2, short s) {
        this.log();
    }

    public void getInputGainOffsetRange(int n, int n2) {
        this.log();
    }

    public void getLoweringEntertainment(int n, int n2, int n3) {
        this.log();
    }

    public void setLoweringEntertainment(int n, int n2, int n3, short s) {
        this.log();
    }

    public void getMenuVolEntRange(int n) {
        this.log();
    }

    public void getMenuVolumeRange(int n, int n2) {
        this.log();
    }

    public void getSoundSet(int n, int n2) {
        this.log();
    }

    public void getSurroundLevel(int n, int n2) {
        this.log();
    }

    public void setSurroundLevel(int n, int n2, short s) {
        this.log();
    }

    public void getDynSoundControl(int n, int n2) {
        this.log();
    }

    public void setDynSoundControl(int n, int n2, short s) {
        this.log();
    }

    public void getVolumeLeveling(int n, int n2) {
        this.log();
    }

    public void setVolumeLeveling(int n, int n2, short s) {
        this.log();
    }

    public void setSurroundOnOff(int n, int n2, boolean bl) {
        this.log();
    }

    public void revertToFactorySettings(int n, int n2) {
        this.log();
    }

    public void createExportFile(String string, int n) {
        this.log();
    }

    public void importFile(String string, int n) {
        this.log();
    }

    public void getMiddle(int n, int n2) {
        this.log();
    }

    public void setMiddle(int n, int n2, short s) {
        this.log();
    }

    public void decreaseMiddle(int n, int n2, short s) {
        this.log();
    }

    public void increaseMiddle(int n, int n2, short s) {
        this.log();
    }

    public void setEqualizer(int n, int n2, int n3, int n4) {
        this.log();
    }

    public void increaseEqualizer(int n, int n2, int n3, short s) {
        this.log();
    }

    public void decreaseEqualizer(int n, int n2, int n3, short s) {
        this.log();
    }

    public void getEqualizer(int n, int n2) {
        this.log();
    }

    public void setOnVolumeLimit(int n) {
        this.log();
    }

    public void increaseOnVolumeLimit(short s) {
        this.log();
    }

    public void decreaseOnVolumeLimit(short s) {
        this.log();
    }

    public void decreaseSubwoofer(int n, int n2, short s) {
        this.log();
    }

    public void increaseSubwoofer(int n, int n2, short s) {
        this.log();
    }

    public void decreaseInputGainOffset(int n, int n2, short s) {
        this.log();
    }

    public void increaseInputGainOffset(int n, int n2, short s) {
        this.log();
    }

    public void decreaseVolumeLeveling(int n, int n2, short s) {
        this.log();
    }

    public void increaseVolumeLeveling(int n, int n2, short s) {
        this.log();
    }

    public void decreaseSurroundLevel(int n, int n2, short s) {
        this.log();
    }

    public void increaseSurroundLevel(int n, int n2, short s) {
        this.log();
    }

    public void setSoundSet(int n, int n2, long l) {
        this.log();
    }

    public void decreaseLoweringEntertainment(int n, int n2, int n3, short s) {
        this.log();
    }

    public void increaseLoweringEntertainment(int n, int n2, int n3, short s) {
        this.log();
    }

    public void setMicGainLevel(int n) {
        this.log();
    }

    public void decreaseMicGainLevel(short s) {
        this.log();
    }

    public void increaseMicGainLevel(short s) {
        this.log();
    }

    public void getNoiseCompensation(int n, int n2) {
        this.log();
    }

    public void setNoiseCompensation(int n, int n2, boolean bl, short s) {
        this.log();
    }

    public void increaseNoiseCompensation(int n, int n2, short s) {
        this.log();
    }

    public void decreaseNoiseCompensation(int n, int n2, short s) {
        this.log();
    }

    public void getPresetEQ(int n, int n2) {
        this.log();
    }

    public void setPresetEQ(int n, int n2, int n3) {
        this.log();
    }

    public void getPresetPosition(int n, int n2) {
        this.log();
    }

    public void setPresetPosition(int n, int n2, int n3) {
        this.log();
    }

    public void setSubwooferActivity(int n, int n2, boolean bl) {
        this.log();
    }

    public void setNoiseCompensation(int n, int n2, short s) {
        this.log();
    }

    public void get3DMode(int n, int n2) {
        this.log();
    }

    public void set3DMode(int n, int n2, int n3) {
        this.log();
    }

    public void setWidebandSpeech(int n, boolean bl) {
        this.log();
    }

    public void setDuration(int n, int n2) {
        this.log();
    }

    public void getVolumeRange(int n, int n2) {
        this.log();
    }

    public void getSoundShapeActive() {
    }

    public void setSoundShapeActive(boolean bl) {
    }

    public void getSoundShape() {
    }

    public void setSoundShape(short s, short s2, short s3) {
    }

    public void profileChange(int n) {
        this.log();
    }

    public void profileCopy(int n, int n2) {
        this.log();
    }

    public void profileReset(int n) {
        this.log();
    }

    public void profileResetAll() {
        this.log();
    }
}

