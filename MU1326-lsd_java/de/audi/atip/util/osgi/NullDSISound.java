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

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void getVolume(int n, int n2) {
        this.log();
    }

    @Override
    public void setVolume(int n, int n2, short s) {
        this.log();
    }

    @Override
    public void decreaseVolume(int n, int n2, short s) {
        this.log();
    }

    @Override
    public void increaseVolume(int n, int n2, short s) {
        this.log();
    }

    @Override
    public void getBalance(int n, int n2) {
        this.log();
    }

    @Override
    public void setBalance(int n, int n2, short s) {
        this.log();
    }

    @Override
    public void decreaseBalance(int n, int n2, short s) {
        this.log();
    }

    @Override
    public void increaseBalance(int n, int n2, short s) {
        this.log();
    }

    @Override
    public void getBass(int n, int n2) {
        this.log();
    }

    @Override
    public void setBass(int n, int n2, short s) {
        this.log();
    }

    @Override
    public void decreaseBass(int n, int n2, short s) {
        this.log();
    }

    @Override
    public void increaseBass(int n, int n2, short s) {
        this.log();
    }

    @Override
    public void getTreble(int n, int n2) {
        this.log();
    }

    @Override
    public void setTreble(int n, int n2, short s) {
        this.log();
    }

    @Override
    public void decreaseTreble(int n, int n2, short s) {
        this.log();
    }

    @Override
    public void increaseTreble(int n, int n2, short s) {
        this.log();
    }

    @Override
    public void getFader(int n, int n2) {
        this.log();
    }

    @Override
    public void setFader(int n, int n2, short s) {
        this.log();
    }

    @Override
    public void decreaseFader(int n, int n2, short s) {
        this.log();
    }

    @Override
    public void increaseFader(int n, int n2, short s) {
        this.log();
    }

    @Override
    public void getSubwoofer(int n, int n2) {
        this.log();
    }

    @Override
    public void setSubwoofer(int n, int n2, short s) {
        this.log();
    }

    @Override
    public void getInputGainOffset(int n, int n2) {
        this.log();
    }

    @Override
    public void setInputGainOffset(int n, int n2, short s) {
        this.log();
    }

    @Override
    public void getInputGainOffsetRange(int n, int n2) {
        this.log();
    }

    @Override
    public void getLoweringEntertainment(int n, int n2, int n3) {
        this.log();
    }

    @Override
    public void setLoweringEntertainment(int n, int n2, int n3, short s) {
        this.log();
    }

    @Override
    public void getMenuVolEntRange(int n) {
        this.log();
    }

    @Override
    public void getMenuVolumeRange(int n, int n2) {
        this.log();
    }

    public void getSoundSet(int n, int n2) {
        this.log();
    }

    @Override
    public void getSurroundLevel(int n, int n2) {
        this.log();
    }

    @Override
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

    @Override
    public void setSurroundOnOff(int n, int n2, boolean bl) {
        this.log();
    }

    @Override
    public void revertToFactorySettings(int n, int n2) {
        this.log();
    }

    @Override
    public void createExportFile(String string, int n) {
        this.log();
    }

    @Override
    public void importFile(String string, int n) {
        this.log();
    }

    @Override
    public void getMiddle(int n, int n2) {
        this.log();
    }

    @Override
    public void setMiddle(int n, int n2, short s) {
        this.log();
    }

    @Override
    public void decreaseMiddle(int n, int n2, short s) {
        this.log();
    }

    @Override
    public void increaseMiddle(int n, int n2, short s) {
        this.log();
    }

    @Override
    public void setEqualizer(int n, int n2, int n3, int n4) {
        this.log();
    }

    @Override
    public void increaseEqualizer(int n, int n2, int n3, short s) {
        this.log();
    }

    @Override
    public void decreaseEqualizer(int n, int n2, int n3, short s) {
        this.log();
    }

    @Override
    public void getEqualizer(int n, int n2) {
        this.log();
    }

    @Override
    public void setOnVolumeLimit(int n) {
        this.log();
    }

    @Override
    public void increaseOnVolumeLimit(short s) {
        this.log();
    }

    @Override
    public void decreaseOnVolumeLimit(short s) {
        this.log();
    }

    @Override
    public void decreaseSubwoofer(int n, int n2, short s) {
        this.log();
    }

    @Override
    public void increaseSubwoofer(int n, int n2, short s) {
        this.log();
    }

    @Override
    public void decreaseInputGainOffset(int n, int n2, short s) {
        this.log();
    }

    @Override
    public void increaseInputGainOffset(int n, int n2, short s) {
        this.log();
    }

    public void decreaseVolumeLeveling(int n, int n2, short s) {
        this.log();
    }

    public void increaseVolumeLeveling(int n, int n2, short s) {
        this.log();
    }

    @Override
    public void decreaseSurroundLevel(int n, int n2, short s) {
        this.log();
    }

    @Override
    public void increaseSurroundLevel(int n, int n2, short s) {
        this.log();
    }

    public void setSoundSet(int n, int n2, long l) {
        this.log();
    }

    @Override
    public void decreaseLoweringEntertainment(int n, int n2, int n3, short s) {
        this.log();
    }

    @Override
    public void increaseLoweringEntertainment(int n, int n2, int n3, short s) {
        this.log();
    }

    @Override
    public void setMicGainLevel(int n) {
        this.log();
    }

    @Override
    public void decreaseMicGainLevel(short s) {
        this.log();
    }

    @Override
    public void increaseMicGainLevel(short s) {
        this.log();
    }

    @Override
    public void getNoiseCompensation(int n, int n2) {
        this.log();
    }

    public void setNoiseCompensation(int n, int n2, boolean bl, short s) {
        this.log();
    }

    @Override
    public void increaseNoiseCompensation(int n, int n2, short s) {
        this.log();
    }

    @Override
    public void decreaseNoiseCompensation(int n, int n2, short s) {
        this.log();
    }

    @Override
    public void getPresetEQ(int n, int n2) {
        this.log();
    }

    @Override
    public void setPresetEQ(int n, int n2, int n3) {
        this.log();
    }

    @Override
    public void getPresetPosition(int n, int n2) {
        this.log();
    }

    @Override
    public void setPresetPosition(int n, int n2, int n3) {
        this.log();
    }

    @Override
    public void setSubwooferActivity(int n, int n2, boolean bl) {
        this.log();
    }

    @Override
    public void setNoiseCompensation(int n, int n2, short s) {
        this.log();
    }

    @Override
    public void get3DMode(int n, int n2) {
        this.log();
    }

    @Override
    public void set3DMode(int n, int n2, int n3) {
        this.log();
    }

    @Override
    public void setWidebandSpeech(int n, boolean bl) {
        this.log();
    }

    @Override
    public void setDuration(int n, int n2) {
        this.log();
    }

    @Override
    public void getVolumeRange(int n, int n2) {
        this.log();
    }

    @Override
    public void getSoundShapeActive() {
    }

    @Override
    public void setSoundShapeActive(boolean bl) {
    }

    @Override
    public void getSoundShape() {
    }

    @Override
    public void setSoundShape(short s, short s2, short s3) {
    }

    @Override
    public void profileChange(int n) {
        this.log();
    }

    @Override
    public void profileCopy(int n, int n2) {
        this.log();
    }

    @Override
    public void profileReset(int n) {
        this.log();
    }

    @Override
    public void profileResetAll() {
        this.log();
    }
}

