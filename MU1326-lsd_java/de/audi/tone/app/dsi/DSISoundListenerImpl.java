/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.dsi;

import de.audi.atip.audio.TerminalMapper;
import de.audi.atip.interapp.audio.ISoundHandlerListener;
import de.audi.atip.interapp.def.NullSoundHandlerListener;
import de.audi.atip.util.DefaultDSISoundListener;
import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.ToneTools;
import de.audi.tone.app.intra.AppSoundListeners;
import de.audi.tone.app.intra.IAppSoundListener;
import de.audi.tone.app.sound.SoundHandler;
import org.dsi.ifc.audio.AmplifierCapabilities;

public class DSISoundListenerImpl
extends DefaultDSISoundListener {
    private final ToneEnv env;
    private final SoundHandler soundHandler;
    private final AppSoundListeners listeners = new AppSoundListeners();
    private ISoundHandlerListener soundHandlerListener;
    private volatile int surroundMin = -1;
    private volatile int surroundMax = -1;

    public DSISoundListenerImpl(ToneEnv toneEnv, SoundHandler soundHandler) {
        this.env = toneEnv;
        this.soundHandler = soundHandler;
        this.soundHandlerListener = new NullSoundHandlerListener(toneEnv.lcHMI);
    }

    public int[] getNotifications() {
        int[] nArray = new int[]{35, 26, 24, 3, 2, 10, 9, 5, 4, 22, 21, 18, 17, 19, 20, 49, 45, 43, 44, 42, 47, 39, 12, 13, 36, 50, 51};
        return nArray;
    }

    public void addAppListener(IAppSoundListener iAppSoundListener) {
        this.env.lcMain.log(-2137614336, "[DSISoundListenerImpl.addAppListener] %1", (Object)iAppSoundListener);
        this.listeners.add(iAppSoundListener);
    }

    public synchronized void setSdisSoundHandlerListener(ISoundHandlerListener iSoundHandlerListener) {
        this.env.lcMain.log(-2137614336, "[DSISoundListenerImpl.setSdisSoundListener] %1", (Object)iSoundHandlerListener);
        this.soundHandlerListener.distributeValuesAndRanges(iSoundHandlerListener);
        this.soundHandlerListener = iSoundHandlerListener;
    }

    public void removeSdisSoundHandlerListener() {
        this.env.lcMain.log(-2137614336, "[DSISoundListenerImpl.removeSdisSoundListener]");
        this.soundHandlerListener = new NullSoundHandlerListener(this.env.lcHMI);
    }

    @Override
    public void updateSoundSet(int n, int n2, long l, int n3) {
        this.env.lcMain.log(-2137614336, "<- [DSISoundListenerImpl.updateSoundSet] nothing to do.");
    }

    @Override
    public void updatePresetPositionList(int n, int n2) {
        if (this.env.lcDSI.isDebug()) {
            this.env.lcDSI.log(-2137614336, "<- [DSISoundListener.updatePresetPositionList] list:0b%1 (valid:%2)", (Object)Integer.toBinaryString(n), (long)n2);
        }
        if (this.isValid(n2, "updatePresetPositionList")) {
            for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
                this.listeners.get(i2).updatePresetPositionList(n);
            }
            this.soundHandlerListener.updatePresetPositionList(n);
        }
    }

    @Override
    public void updatePresetPosition(int n, int n2, int n3, int n4) {
        this.env.lcDSI.log(-2137614336, "<- [DSISoundListener.updatePresetPosition] AC:%1 presetPosition:%2 (valid:%3)", (long)n, (long)n3, (long)n4);
        if (this.isValid(n4, "updatePresetPosition")) {
            for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
                this.listeners.get(i2).updatePresetPosition(n3);
            }
            this.soundHandlerListener.updatePresetPosition(n3);
        }
    }

    @Override
    public void updatePresetEQList(int n, int n2) {
        if (this.env.lcDSI.isDebug()) {
            this.env.lcDSI.log(-2137614336, "<- [DSISoundListenerImpl.updatePresetEQList] list:0b%1 (valid:%2)", (Object)Integer.toBinaryString(n), (long)n2);
        }
        if (this.isValid(n2, "updatePresetEQList")) {
            for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
                this.listeners.get(i2).updatePresetEQList(n);
            }
        }
        this.soundHandlerListener.updatePresetEqList(n);
    }

    @Override
    public void updatePresetEQ(int n, int n2, int n3, int n4) {
        this.env.lcDSI.log(-2137614336, "<- [DSISoundListenerImpl.updatePresetEQ] AC:%1 presetPosition:%2 (valid:%3)", (long)n, (long)n3, (long)n4);
        if (this.isValid(n4, "updatePresetEQ")) {
            for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
                this.listeners.get(i2).updatePresetEQ(n3);
            }
        }
        this.soundHandlerListener.updatePresetEq(n3);
    }

    @Override
    public void updateVolume(int n, int n2, short s, int n3) {
        if (this.env.lcDSI.isDebug()) {
            String string = ToneTools.toLogMessage(n, n2, s);
            this.env.lcDSI.log(-2137614336, "<- [DSISoundListenerImpl.updateVolume] %1 (valid:%2)", (Object)string, (long)n3);
        }
        if (this.isValid(n3, "updateVolume")) {
            int n4 = this.toHMITerminal(n2);
            for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
                this.listeners.get(i2).updateVolume(n4, n, s);
            }
        }
    }

    @Override
    public void updateVolumeRange(int n, int n2, int n3) {
        this.env.lcDSI.log(-2137614336, "<- [DSISoundListenerImpl.updateVolumeRange] min:%1 max:%2 (valid:%3)", (long)n, (long)n2, (long)n3);
        if (this.isValid(n3, "updateVolumeRange")) {
            for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
                this.listeners.get(i2).updateVolumeRange(n, n2);
            }
        }
    }

    @Override
    public void updateBalance(int n, int n2, short s, int n3) {
        if (this.env.lcDSI.isDebug()) {
            String string = ToneTools.toLogMessage(n, n2, s);
            this.env.lcDSI.log(-2137614336, "<- [DSISoundListenerImpl.updateBalance] %1 (valid:%2)", (Object)string, (long)n3);
        }
        if (this.isValid(n3, "updateBalance")) {
            int n4 = this.toHMITerminal(n2);
            this.soundHandler.updateValue(1682050816, n4, s);
            this.soundHandlerListener.updateBalance(s);
            for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
                this.listeners.get(i2).updateBalance(n, n4, s);
            }
        }
    }

    @Override
    public void updateBalanceRange(int n, int n2, int n3) {
        this.env.lcDSI.log(-2137614336, "<- [DSISoundListenerImpl.updateBalanceRange] min:%1 max:%2 (valid:%3)", (long)n, (long)n2, (long)n3);
        if (this.isValid(n3, "updateBalanceRange")) {
            this.soundHandler.updateLimits(1682050816, n, n2);
            this.soundHandlerListener.updateBalanceRange(n, n2);
            for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
                this.listeners.get(i2).updateBalanceRange(n, n2);
            }
        }
    }

    @Override
    public void updateFader(int n, int n2, short s, int n3) {
        if (this.env.lcDSI.isDebug()) {
            String string = ToneTools.toLogMessage(n, n2, s);
            this.env.lcDSI.log(-2137614336, "<- [DSISoundListenerImpl.updateFader] %1 (valid:%2)", (Object)string, (long)n3);
        }
        if (this.isValid(n3, "updateFader")) {
            int n4 = this.toHMITerminal(n2);
            this.soundHandler.updateValue(1799491328, n4, s);
            this.soundHandlerListener.updateFader(s);
            for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
                this.listeners.get(i2).updateFader(n, n4, s);
            }
        }
    }

    @Override
    public void updateFaderRange(int n, int n2, int n3) {
        this.env.lcDSI.log(-2137614336, "<- [DSISoundListenerImpl.updateFaderRange] min:%1 max:%2 (valid:%3)", (long)n, (long)n2, (long)n3);
        if (this.isValid(n3, "updateFaderRange")) {
            this.soundHandler.updateLimits(1799491328, n, n2);
            this.soundHandlerListener.updateFaderRange(n, n2);
            for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
                this.listeners.get(i2).updateFaderRanges(n, n2);
            }
        }
    }

    @Override
    public void updateBass(int n, int n2, short s, int n3) {
        if (this.env.lcDSI.isDebug()) {
            String string = ToneTools.toLogMessage(n, n2, s);
            this.env.lcDSI.log(-2137614336, "<- [DSISoundListenerImpl.updateBass] %1 (valid:%2)", (Object)string, (long)n3);
        }
        if (this.isValid(n3, "updateBass")) {
            int n4 = this.toHMITerminal(n2);
            this.soundHandler.updateValue(1715605248, n4, s);
            this.soundHandlerListener.updateBass(s);
        }
    }

    @Override
    public void updateBassRange(int n, int n2, int n3) {
        this.env.lcDSI.log(-2137614336, "<- [DSISoundListenerImpl.updateBassRange] min:%1 max:%2 (valid:%3)", (long)n, (long)n2, (long)n3);
        if (this.isValid(n3, "updateBassRange")) {
            this.soundHandler.updateLimits(1715605248, n, n2);
            this.soundHandlerListener.updateBassRange(n, n2);
        }
    }

    @Override
    public void updateTreble(int n, int n2, short s, int n3) {
        if (this.env.lcDSI.isDebug()) {
            String string = ToneTools.toLogMessage(n, n2, s);
            this.env.lcDSI.log(-2137614336, "<- [DSISoundListenerImpl.updateTreble] %1 (valid:%2)", (Object)string, (long)n3);
        }
        if (this.isValid(n3, "updateTreble")) {
            int n4 = this.toHMITerminal(n2);
            this.soundHandler.updateValue(1380060928, n4, s);
            this.soundHandlerListener.updateTreble(s);
        }
    }

    @Override
    public void updateTrebleRange(int n, int n2, int n3) {
        this.env.lcDSI.log(-2137614336, "<- [DSISoundListenerImpl.updateTrebleRange] min:%1 max:%2 (valid:%3)", (long)n, (long)n2, (long)n3);
        if (this.isValid(n3, "updateTrebleRange")) {
            this.soundHandler.updateLimits(1380060928, n, n2);
            this.soundHandlerListener.updateTrebleRange(n, n2);
        }
    }

    @Override
    public void updateSubwoofer(int n, int n2, short s, int n3) {
        if (this.env.lcDSI.isDebug()) {
            String string = ToneTools.toLogMessage(n, n2, s);
            this.env.lcDSI.log(-2137614336, "<- [DSISoundListenerImpl.updateSubwoofer] %1 (valid:%2)", (Object)string, (long)n3);
        }
        if (this.isValid(n3, "updateSubwoofer")) {
            int n4 = this.toHMITerminal(n2);
            this.soundHandler.updateValue(1329729280, n4, s);
            this.soundHandlerListener.updateSubwoofer(s);
        }
    }

    @Override
    public void updateSubwooferRange(int n, int n2, int n3) {
        this.env.lcDSI.log(-2137614336, "<- [DSISoundListenerImpl.updateSubwooferRange] min:%1 max:%2 (valid:%3)", (long)n, (long)n2, (long)n3);
        if (this.isValid(n3, "updateSubwooferRange")) {
            this.soundHandler.updateLimits(1329729280, n, n2);
            this.soundHandlerListener.updateSubwooferRange(n, n2);
        }
    }

    @Override
    public void updateSurroundLevel(int n, int n2, short s, int n3) {
        if (this.env.lcDSI.isDebug()) {
            String string = ToneTools.toLogMessage(n, n2, s);
            this.env.lcDSI.log(-2137614336, "<- [DSISoundListenerImpl.updateSurroundLevel] %1 (valid:%2)", (Object)string, (long)n3);
        }
        if (this.isValid(n3, "updateSurroundLevel")) {
            int n4 = this.toHMITerminal(n2);
            this.soundHandler.updateValue(1749159680, n4, s);
            this.soundHandlerListener.updateSurroundLevel(s);
        }
    }

    @Override
    public void updateSurroundOnOff(int n, int n2, boolean bl, int n3) {
        if (this.env.lcDSI.isDebug()) {
            String string = ToneTools.toLogMessage(n, n2, bl);
            this.env.lcDSI.log(-2137614336, "<- [DSISoundListenerImpl.updateSurroundOnOff] %1 (valid:%2)", (Object)string, (long)n3);
        }
        if (this.isValid(n3, "updateSurroundOnOff")) {
            int n4 = this.toHMITerminal(n2);
            this.soundHandler.updateChoiceValue(-1270739200, n4, bl ? 1 : 0);
        }
    }

    @Override
    public void updateSurrLevelRange(int n, int n2, int n3) {
        this.env.lcDSI.log(-2137614336, "<- [DSISoundListenerImpl.updateSurrLevelRange] min:%1 max:%2 (valid:%3)", (long)n, (long)n2, (long)n3);
        if (this.isValid(n3, "updateSurrLevelRange")) {
            this.surroundMin = n;
            this.surroundMax = n2;
            this.soundHandler.updateLimits(1749159680, n, n2);
            this.soundHandlerListener.updateSurroundLevelRange(n, n2);
        }
    }

    @Override
    public void updateNoiseCompensation(int n, int n2, short s, int n3) {
        if (this.env.lcDSI.isDebug()) {
            String string = ToneTools.toLogMessage(n, n2, s);
            this.env.lcDSI.log(-2137614336, "<- [DSISoundListenerImpl.updateNoiseCompensation] %1 (valid:%2)", (Object)string, (long)n3);
        }
        if (this.isValid(n3, "updateNoiseCompensation")) {
            int n4 = this.toHMITerminal(n2);
            this.soundHandler.updateValue(1732382464, n4, s);
            this.soundHandlerListener.updateNoiseCompensation(s);
        }
    }

    @Override
    public void updateNoiseCompensationRange(int n, int n2, int n3) {
        this.env.lcDSI.log(-2137614336, "<- [DSISoundListenerImpl.updateNoiseCompensationRange] min:%1 max:%2 (valid:%3)", (long)n, (long)n2, (long)n3);
        if (this.isValid(n3, "updateNoiseCompensationRange")) {
            this.soundHandler.updateLimits(1732382464, n, n2);
            this.soundHandlerListener.updateNoiseCompensationRange(n, n2);
        }
    }

    @Override
    public void updateLoweringEntertainment(int n, int n2, int n3, short s, int n4) {
        if (this.env.lcDSI.isDebug()) {
            String string = ToneTools.toLogMessage(n, n2, s);
            this.env.lcDSI.log(-2137614336, "<- [DSISoundListenerImpl.updateLoweringEntertainment] %1 entType:%2 (valid:%3)", (Object)string, (long)n3, (long)n4);
        }
        if (this.isValid(n4, "updateLoweringEntertainment")) {
            for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
                this.listeners.get(i2).updateLoweringEntertainment(n3, s);
            }
        }
    }

    @Override
    public void updateInputGainOffset(int n, int n2, short s, int n3) {
        if (this.env.lcDSI.isDebug()) {
            String string = ToneTools.toLogMessage(n, n2, s);
            this.env.lcDSI.log(-2137614336, "<- [DSISoundListenerImpl.updateInputGainOffset] %1 (valid:%2)", (Object)string, (long)n3);
        }
        if (this.isValid(n3, "updateInputGainOffset")) {
            for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
                this.listeners.get(i2).updateInputGainOffset(n, s);
            }
        }
    }

    @Override
    public void inputGainOffsetRange(int n, int n2, int n3, int n4) {
        if (this.env.lcDSI.isDebug()) {
            String string = ToneTools.toLogMessage(n, n2, n3, n4);
            this.env.lcDSI.log(-2137614336, "<- [DSISoundListenerImpl.inputGainOffsetRange] %1", (Object)string);
        }
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            this.listeners.get(i2).inputGainOffsetRange(n3, n4);
        }
    }

    @Override
    public void updateActiveAmplifierCapabilities(AmplifierCapabilities amplifierCapabilities, int n) {
        this.env.lcDSI.log(-2137614336, "<- [DSISoundListenerImpl.updateActiveAmplifierCapabilities] %1 (valid:%2)", (Object)amplifierCapabilities, (long)n);
        if (this.isValid(n, amplifierCapabilities, "updateActiveAmplifierCapabilities")) {
            for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
                this.listeners.get(i2).updateAmplifier(amplifierCapabilities.amplifier);
            }
            this.soundHandlerListener.updateAmplifier(amplifierCapabilities.amplifier);
            if (amplifierCapabilities.amplifier == 5 && this.surroundMin != -1 && this.surroundMax != -1) {
                this.env.lcDSI.log(-1601830656, "[DSISoundListenerImpl.updateActiveAmplifierCapabilities] WORKAROUND FOR BENTLEY executed");
                this.updateSurrLevelRange(this.surroundMin, this.surroundMax, 1);
            }
        }
    }

    @Override
    public void menuVolumeRange(int n, int n2, int n3, int n4) {
        if (this.env.lcDSI.isDebug()) {
            String string = ToneTools.toLogMessage(n, n2, n3, n4);
            this.env.lcDSI.log(-2137614336, "<- [DSISoundListenerImpl.menuVolumeRange] %1", (Object)string);
        }
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            this.listeners.get(i2).menuVolumeRange(n, n3, n4);
        }
    }

    @Override
    public void menuVolEntRange(int n, int n2, int n3) {
        if (this.env.lcDSI.isDebug()) {
            this.env.lcDSI.log(-2137614336, "<- [DSISoundListener.menuVolumeRange] type:%1 min:%2 max:%3", (long)n, (long)n2, (long)n3);
        }
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            this.listeners.get(i2).menuVolEntRange(n, n2, n3);
        }
    }

    @Override
    public void updateMuteTheftProtection(boolean bl, int n) {
        this.env.lcDSI.log(1078071040, "<- [DSISoundListenerImpl.updateMuteTheftProtection] status:%1 (valid:%2)", bl, (long)n);
        if (n == 1) {
            for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
                this.listeners.get(i2).updateMuteTheftProtection(bl);
            }
        }
    }

    @Override
    public void updateThreeDMode(int n, int n2, int n3, int n4) {
        this.env.lcDSI.log(1078071040, "<- [DSISoundListenerImpl.updateThreeDMode] AC:%1 mode:%2 (valid:%3)", (long)n, (long)n3, (long)n4);
        if (n4 == 1) {
            for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
                this.listeners.get(i2).updateThreeDMode(n3);
            }
        }
        this.soundHandlerListener.updateThreeDMode(n3);
    }

    @Override
    public void updateThreeDModeRange(int n, int n2, int n3) {
        this.env.lcDSI.log(1078071040, "<- [DSISoundListenerImpl.updateThreeDModeRange] min:%1 max:%2 (valid:%3)", (long)n, (long)n2, (long)n3);
        if (n3 == 1) {
            for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
                this.listeners.get(i2).updateThreeDModeRange(n, n2);
            }
        }
        this.soundHandlerListener.updateThreeDModeRange(n, n2);
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.env.lcDSI.log(10000, "<- [DSISoundListenerImpl.asyncException]  errorMsg:%1 errorCode:%2 requestType:%3", (Object)string, (long)n, (long)n2);
    }

    private boolean isValid(int n, Object object, String string) {
        if (n == 1 && object != null) {
            return true;
        }
        this.env.lcDSI.log(1078071040, "[DSISoundListenerImpl.%1] Invalid Update! parameter:%2 (valid:%3)", (Object)string, object, (long)n);
        return false;
    }

    private boolean isValid(int n, String string) {
        if (n == 1) {
            return true;
        }
        this.env.lcDSI.log(1078071040, "[DSISoundListenerImpl.%1] Invalid Update! (valid:%2)", (Object)string, (long)n);
        return false;
    }

    private int toHMITerminal(int n) {
        return TerminalMapper.toHmiTerminal(n);
    }
}

