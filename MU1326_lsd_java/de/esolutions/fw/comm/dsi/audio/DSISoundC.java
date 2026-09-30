/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.audio;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSISoundC {
    public void getVolume(int var1, int var2) throws MethodException;

    public void setVolume(int var1, int var2, short var3) throws MethodException;

    public void decreaseVolume(int var1, int var2, short var3) throws MethodException;

    public void increaseVolume(int var1, int var2, short var3) throws MethodException;

    public void getBalance(int var1, int var2) throws MethodException;

    public void setBalance(int var1, int var2, short var3) throws MethodException;

    public void decreaseBalance(int var1, int var2, short var3) throws MethodException;

    public void increaseBalance(int var1, int var2, short var3) throws MethodException;

    public void getBass(int var1, int var2) throws MethodException;

    public void setBass(int var1, int var2, short var3) throws MethodException;

    public void decreaseBass(int var1, int var2, short var3) throws MethodException;

    public void increaseBass(int var1, int var2, short var3) throws MethodException;

    public void getTreble(int var1, int var2) throws MethodException;

    public void setTreble(int var1, int var2, short var3) throws MethodException;

    public void decreaseTreble(int var1, int var2, short var3) throws MethodException;

    public void increaseTreble(int var1, int var2, short var3) throws MethodException;

    public void getFader(int var1, int var2) throws MethodException;

    public void setFader(int var1, int var2, short var3) throws MethodException;

    public void decreaseFader(int var1, int var2, short var3) throws MethodException;

    public void increaseFader(int var1, int var2, short var3) throws MethodException;

    public void getSubwoofer(int var1, int var2) throws MethodException;

    public void setSubwoofer(int var1, int var2, short var3) throws MethodException;

    public void getInputGainOffset(int var1, int var2) throws MethodException;

    public void setInputGainOffset(int var1, int var2, short var3) throws MethodException;

    public void getInputGainOffsetRange(int var1, int var2) throws MethodException;

    public void getLoweringEntertainment(int var1, int var2, int var3) throws MethodException;

    public void setLoweringEntertainment(int var1, int var2, int var3, short var4) throws MethodException;

    public void getMenuVolEntRange(int var1) throws MethodException;

    public void getMenuVolumeRange(int var1, int var2) throws MethodException;

    public void getVolumeRange(int var1, int var2) throws MethodException;

    public void getSurroundLevel(int var1, int var2) throws MethodException;

    public void setSurroundLevel(int var1, int var2, short var3) throws MethodException;

    public void setSurroundOnOff(int var1, int var2, boolean var3) throws MethodException;

    public void revertToFactorySettings(int var1, int var2) throws MethodException;

    public void createExportFile(String var1, int var2) throws MethodException;

    public void importFile(String var1, int var2) throws MethodException;

    public void getMiddle(int var1, int var2) throws MethodException;

    public void setMiddle(int var1, int var2, short var3) throws MethodException;

    public void decreaseMiddle(int var1, int var2, short var3) throws MethodException;

    public void increaseMiddle(int var1, int var2, short var3) throws MethodException;

    public void setEqualizer(int var1, int var2, int var3, int var4) throws MethodException;

    public void increaseEqualizer(int var1, int var2, int var3, short var4) throws MethodException;

    public void decreaseEqualizer(int var1, int var2, int var3, short var4) throws MethodException;

    public void getEqualizer(int var1, int var2) throws MethodException;

    public void setOnVolumeLimit(int var1) throws MethodException;

    public void increaseOnVolumeLimit(short var1) throws MethodException;

    public void decreaseOnVolumeLimit(short var1) throws MethodException;

    public void decreaseSubwoofer(int var1, int var2, short var3) throws MethodException;

    public void increaseSubwoofer(int var1, int var2, short var3) throws MethodException;

    public void decreaseInputGainOffset(int var1, int var2, short var3) throws MethodException;

    public void increaseInputGainOffset(int var1, int var2, short var3) throws MethodException;

    public void decreaseLoweringEntertainment(int var1, int var2, int var3, short var4) throws MethodException;

    public void increaseLoweringEntertainment(int var1, int var2, int var3, short var4) throws MethodException;

    public void decreaseSurroundLevel(int var1, int var2, short var3) throws MethodException;

    public void increaseSurroundLevel(int var1, int var2, short var3) throws MethodException;

    public void setMicGainLevel(int var1) throws MethodException;

    public void decreaseMicGainLevel(short var1) throws MethodException;

    public void increaseMicGainLevel(short var1) throws MethodException;

    public void getNoiseCompensation(int var1, int var2) throws MethodException;

    public void setNoiseCompensation(int var1, int var2, short var3) throws MethodException;

    public void increaseNoiseCompensation(int var1, int var2, short var3) throws MethodException;

    public void decreaseNoiseCompensation(int var1, int var2, short var3) throws MethodException;

    public void getPresetEQ(int var1, int var2) throws MethodException;

    public void setPresetEQ(int var1, int var2, int var3) throws MethodException;

    public void getPresetPosition(int var1, int var2) throws MethodException;

    public void setPresetPosition(int var1, int var2, int var3) throws MethodException;

    public void get3DMode(int var1, int var2) throws MethodException;

    public void set3DMode(int var1, int var2, int var3) throws MethodException;

    public void setSubwooferActivity(int var1, int var2, boolean var3) throws MethodException;

    public void setWidebandSpeech(int var1, boolean var2) throws MethodException;

    public void setDuration(int var1, int var2) throws MethodException;

    public void getSoundShapeActive() throws MethodException;

    public void setSoundShapeActive(boolean var1) throws MethodException;

    public void getSoundShape() throws MethodException;

    public void setSoundShape(short var1, short var2, short var3) throws MethodException;

    public void profileChange(int var1) throws MethodException;

    public void profileCopy(int var1, int var2) throws MethodException;

    public void profileReset(int var1) throws MethodException;

    public void profileResetAll() throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

