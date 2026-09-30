/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.dsi;

import de.audi.atip.audio.AudioConnection;
import de.audi.atip.audio.TerminalMapper;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.osgi.NullDSISound;
import de.audi.tone.app.AmplifierVariant;
import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.dsi.AudioServiceHandler;
import de.audi.tone.app.dsi.IDSISoundHandler;
import org.dsi.ifc.audio.DSISound;

public class DSISoundHandler
implements IDSISoundHandler {
    private final LogChannel lc;
    private final AudioServiceHandler audioService;
    private final ToneEnv env;
    private volatile DSISound dsi;
    private AmplifierVariant amplifierVariant;

    public DSISoundHandler(ToneEnv toneEnv, AudioServiceHandler audioServiceHandler, AmplifierVariant amplifierVariant) {
        this.lc = toneEnv.lcDSI;
        this.audioService = audioServiceHandler;
        this.dsi = new NullDSISound(this.lc);
        this.amplifierVariant = amplifierVariant;
        this.env = toneEnv;
    }

    public void registerDSI(DSISound dSISound) {
        this.lc.log(10000000, "[DSISoundHandler.registerDSI] %1", (Object)dSISound);
        this.dsi = dSISound;
    }

    public void deregisterDSISound() {
        this.lc.log(1000000, "[DSISoundHandler.deregisterDSISound]");
        this.dsi = new NullDSISound(this.lc);
    }

    public DSISound getDSI() {
        return this.dsi;
    }

    public void increaseVolume(int n, int n2, int n3) {
        int n4 = this.getAudioTerminal(n);
        this.lc.log(10000000, "-> [DSISoundHandler.increaseVolume] AT:%1 AC:%2 steps:%3", (long)n4, (long)n2, (long)n3);
        this.dsi.increaseVolume(n2, n4, (short)n3);
    }

    public void decreaseVolume(int n, int n2, int n3) {
        int n4 = this.getAudioTerminal(n);
        this.lc.log(10000000, "-> [DSISoundHandler.decreaseVolume] AT:%1 AC:%2 steps:%3", (long)n4, (long)n2, (long)n3);
        this.dsi.decreaseVolume(n2, n4, (short)n3);
    }

    public void changeBalance(int n, int n2) {
        int n3 = this.getActiveEntConn(n);
        if (n3 == 0) {
            return;
        }
        int n4 = this.getAudioTerminal(n);
        if (n2 > 0) {
            this.lc.log(10000000, "-> [DSISoundHandler.changeBalance] increase by %1 steps - AEC:%2 AT:%3", (long)n2, (long)n3, (long)n4);
            this.dsi.increaseBalance(n3, n4, (short)n2);
        } else {
            this.lc.log(10000000, "-> [DSISoundHandler.changeBalance] decrease by %1 steps - AEC:%2 AT:%3", (long)(-n2), (long)n3, (long)n4);
            this.dsi.decreaseBalance(n3, n4, (short)(-n2));
        }
    }

    public void setBalance(int n, int n2) {
        int n3 = this.getActiveEntConn(n);
        if (n3 == 0) {
            return;
        }
        int n4 = this.getAudioTerminal(n);
        this.lc.log(10000000, "-> [DSISoundHandler.setBalance] AEC:%2 AT:%3 balance:%3", (long)n3, (long)n4, (long)n2);
        this.dsi.setBalance(n3, n4, (short)n2);
    }

    public void changeFader(int n, int n2) {
        int n3 = this.getActiveEntConn(n);
        if (n3 == 0) {
            return;
        }
        int n4 = this.getAudioTerminal(n);
        if (n2 > 0) {
            this.lc.log(10000000, "-> [DSISoundHandler.changeFader] increase by %1 steps - %2 AT:%3", (long)n2, (long)n3, (long)n4);
            this.dsi.increaseFader(n3, n4, (short)n2);
        } else {
            this.lc.log(10000000, "-> [DSISoundHandler.changeFader] decrease by %1 steps - %2 AT:%3", (long)(-n2), (long)n3, (long)n4);
            this.dsi.decreaseFader(n3, n4, (short)(-n2));
        }
    }

    public void setFader(int n, int n2) {
        int n3 = this.getActiveEntConn(n);
        if (n3 == 0) {
            return;
        }
        int n4 = this.getAudioTerminal(n);
        this.lc.log(10000000, "-> [DSISoundHandler.setFader] AEC:%1 AT:%2 fader:%3", (long)n3, (long)n4, (long)n2);
        this.dsi.setFader(n3, n4, (short)n2);
    }

    public void changeBass(int n, int n2) {
        int n3 = this.getActiveEntConn(n);
        if (n3 == 0) {
            return;
        }
        int n4 = this.getAudioTerminal(n);
        if (n2 > 0) {
            this.lc.log(10000000, "-> [DSISoundHandler.changeBass] increase by %1 steps - AEC:%2 AT:%3", (long)n2, (long)n3, (long)n4);
            this.dsi.increaseBass(n3, n4, (short)n2);
        } else {
            this.lc.log(10000000, "-> [DSISoundHandler.changeBass] decrease by %1 steps - AEC:%2 AT:%3", (long)(-n2), (long)n3, (long)n4);
            this.dsi.decreaseBass(n3, n4, (short)(-n2));
        }
    }

    public void changeTreble(int n, int n2) {
        int n3 = this.getActiveEntConn(n);
        if (n3 == 0) {
            return;
        }
        int n4 = this.getAudioTerminal(n);
        if (n2 > 0) {
            this.lc.log(10000000, "-> [DSISoundHandler.changeTreble] increase by %1 steps - AEC:%2 AT:%3", (long)n2, (long)n3, (long)n4);
            this.dsi.increaseTreble(n3, n4, (short)n2);
        } else {
            this.lc.log(10000000, "-> [DSISoundHandler.changeTreble] decrease by %1 steps - AEC:%2 AT:%3", (long)(-n2), (long)n3, (long)n4);
            this.dsi.decreaseTreble(n3, n4, (short)(-n2));
        }
    }

    public void changeNoiseCompensation(int n) {
        int n2 = this.getActiveEntConn(0);
        if (n2 == 0) {
            return;
        }
        int n3 = this.getAudioTerminal(0);
        if (n > 0) {
            this.lc.log(10000000, "-> [DSISoundHandler.changeNoiseCompensation] increase by %1 steps - AEC:%2 AT:%3", (long)n, (long)n2, (long)n3);
            this.dsi.increaseNoiseCompensation(n2, n3, (short)n);
        } else {
            this.lc.log(10000000, "-> [DSISoundHandler.changeNoiseCompensation] decrease by %1 steps - AEC:%2 AT:%3", (long)(-n), (long)n2, (long)n3);
            this.dsi.decreaseNoiseCompensation(n2, n3, (short)(-n));
        }
    }

    public void setNoiseCompensation(int n) {
        int n2 = this.getActiveEntConn(0);
        if (n2 == 0) {
            return;
        }
        int n3 = this.getAudioTerminal(0);
        this.lc.log(10000000, "-> [DSISoundHandler.setNoiseCompensation] level:%1 AEC:%2 AT:%3", (long)n, (long)n2, (long)n3);
        this.dsi.setNoiseCompensation(n2, n3, (short)n);
    }

    public void changeSubwoofer(int n, int n2) {
        int n3 = this.getActiveEntConn(n);
        if (n3 == 0) {
            return;
        }
        int n4 = this.getAudioTerminal(n);
        if (n2 > 0) {
            this.lc.log(10000000, "-> [DSISoundHandler.changeSubwoofer] increase by %1 steps - AEC:%2 AT:%3", (long)n2, (long)n3, (long)n4);
            this.dsi.increaseSubwoofer(n3, n4, (short)n2);
        } else {
            this.lc.log(10000000, "-> [DSISoundHandler.changeSubwoofer] decrease by %1 steps - AEC:%2 AT:%3", (long)(-n2), (long)n3, (long)n4);
            this.dsi.decreaseSubwoofer(n3, n4, (short)(-n2));
        }
    }

    public void changeSurroundLevel(int n, int n2) {
        int n3 = this.getActiveEntConn(n);
        if (n3 == 0) {
            return;
        }
        int n4 = this.getAudioTerminal(n);
        if (n2 > 0) {
            this.lc.log(10000000, "-> [DSISoundHandler.changeSurroundLevel] increase by %1 steps - AEC:%2 AT:%3", (long)n2, (long)n3, (long)n4);
            this.dsi.increaseSurroundLevel(n3, n4, (short)n2);
        } else {
            this.lc.log(10000000, "-> [DSISoundHandler.changeSurroundLevel] increase by %1 steps - AEC:%2 AT:%3", (long)(-n2), (long)n3, (long)n4);
            this.dsi.decreaseSurroundLevel(n3, n4, (short)(-n2));
        }
    }

    public void setVolume(int n, int n2, int n3) {
        int n4 = this.getAudioTerminal(n);
        this.lc.log(10000000, "-> [DSISoundHandler.setVolume] AC:%1 volume:%2 AT:%3", (long)n2, (long)n3, (long)n4);
        this.dsi.setVolume(n2, n4, (short)n3);
    }

    public void getVolume(int n, int n2) {
        if (n2 == 88 && this.env.isStd()) {
            this.lc.log(100000, "-> [DSISoundHandler.getVolume] IGNORED AC:%1 (not supported by Delphi)", (long)n2);
            return;
        }
        int n3 = this.getAudioTerminal(n);
        this.lc.log(10000000, "-> [DSISoundHandler.getVolume] AC:%1", (long)n2);
        this.dsi.getVolume(n2, n3);
    }

    public void changeLoweringEntertainment(int n, int n2, int n3) {
        int n4 = this.getActiveEntConn(n3);
        if (n4 == 0) {
            return;
        }
        int n5 = this.getAudioTerminal(n3);
        if (n2 > 0) {
            this.lc.log(10000000, "-> [DSISoundHandler.changeLoweringEntertainment]increase by %3 steps - AEC:%1 type:%2", (long)n4, (long)n, (long)n2);
            this.dsi.increaseLoweringEntertainment(n4, n5, n, (short)n2);
        } else {
            this.lc.log(10000000, "-> [DSISoundHandler.changeLoweringEntertainment] decrease by %3 steps - AEC:%1 type:%2", (long)n4, (long)n, (long)(-n2));
            this.dsi.decreaseLoweringEntertainment(n4, n5, n, (short)(-n2));
        }
    }

    public void setLoweringEntertainment(int n, int n2) {
        int n3 = this.getActiveEntConn(0);
        if (n3 == 0) {
            return;
        }
        this.lc.log(10000000, "-> [DSISoundHandler.setLoweringEntertainment] AEC:%1 type:%2 preset:%3", (long)n3, (long)n, (long)n2);
        int n4 = this.getAudioTerminal(0);
        this.dsi.setLoweringEntertainment(n3, n4, n, (short)n2);
    }

    public void revertToFactorySettings(int n, int[] nArray, String string) {
        this.lc.log(10000000, "-> [DSISoundHandler.revertToFactorySettings]");
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.revertToFactorySettings(n, nArray[i2]);
        }
    }

    public void revertToFactorySettings(int n, int n2) {
        int n3 = this.getAudioTerminal(n);
        this.lc.log(10000000, "-> [DSISoundHandler.revertToFactorySettings] AC:%1", (long)n2);
        this.dsi.revertToFactorySettings(n2, n3);
        for (int i2 = 0; i2 < AudioConnection.VOLUME_MENU_CONNECTIONS.length; ++i2) {
            this.dsi.getVolume(AudioConnection.VOLUME_MENU_CONNECTIONS[i2], n3);
        }
    }

    public void setPresetPosition(int n, int n2) {
        int n3 = this.getActiveEntConn(n);
        if (n3 == 0) {
            return;
        }
        this.lc.log(10000000, "-> [DSISoundHandler.setPresetPosition] presetPosition:%1 AEC:%2", (long)n2, (long)n3);
        int n4 = this.getAudioTerminal(n);
        this.dsi.setPresetPosition(n3, n4, n2);
    }

    public void setPresetEQ(int n, int n2) {
        int n3 = this.getActiveEntConn(n);
        if (n3 == 0) {
            return;
        }
        this.lc.log(10000000, "-> [DSISoundHandler.setPresetEQ] presetEQ:%1 AEC:%2", (long)n2, (long)n3);
        int n4 = this.getAudioTerminal(n);
        this.dsi.setPresetEQ(n3, n4, n2);
    }

    public void getMenuVolumeRange(int n, int n2) {
        if (n2 == 88 && this.env.isStd()) {
            this.lc.log(100000, "-> [DSISoundHandler.getMenuVolumeRange] IGNORED AC:%1 (not supported by Delphi)", (long)n2);
            return;
        }
        int n3 = this.getAudioTerminal(n);
        this.lc.log(10000000, "-> [DSISoundHandler.getMenuVolumeRange] AC:%1", (long)n2);
        this.dsi.getMenuVolumeRange(n2, n3);
    }

    public void getMenuVolEntRange(int n) {
        this.lc.log(10000000, "-> [DSISoundHandler.getMenuVolEntRange] announcementType:%1", (long)n);
        this.dsi.getMenuVolEntRange(n);
    }

    public void getInputGainOffsetRange(int n, int n2) {
        int n3 = this.getAudioTerminal(n);
        this.lc.log(10000000, "-> [DSISoundHandler.getInputGainOffsetRange] AC:%1 HT:%2", (long)n2, (long)n);
        this.dsi.getInputGainOffsetRange(n2, n3);
    }

    public void getInputGainOffset(int n, int n2) {
        int n3 = this.getAudioTerminal(n);
        this.lc.log(10000000, "-> [DSISoundHandler.getInputGainOffset] AC:%1 HT:%2", (long)n2, (long)n);
        this.dsi.getInputGainOffset(n2, n3);
    }

    public void changeInputGainOffset(int n, int n2, int n3) {
        int n4 = this.getAudioTerminal(n);
        if (n3 > 0) {
            this.lc.log(10000000, "-> [DSISoundHandler.changeInputGainOffset] increase by %1 steps - AC:%2 AT:%3", (long)n3, (long)n2, (long)n4);
            this.dsi.increaseInputGainOffset(n2, n4, (short)n3);
        } else {
            this.lc.log(10000000, "-> [DSISoundHandler.changeInputGainOffset] decrease by %1 steps - AC:%2 AT:%3", (long)(-n3), (long)n2, (long)n4);
            this.dsi.decreaseInputGainOffset(n2, n4, (short)(-n3));
        }
    }

    public void setMicGainLevel(int n) {
        this.lc.log(10000000, "-> [DSISoundHandler.setMicGainLevel] micGainLevel:%1", (long)n);
        this.dsi.setMicGainLevel(n);
    }

    public void setThreeDMode(int n) {
        int n2 = this.getActiveEntConn(0);
        if (n2 == 0) {
            return;
        }
        int n3 = this.getAudioTerminal(0);
        this.setThreeDMode(n2, n3, n);
    }

    public void setThreeDMode(int n, int n2, int n3) {
        int n4 = this.getAudioTerminal(n2);
        this.lc.log(10000000, "-> [DSISoundHandler.setThreeDMode] AC:%1, AT:%2, mode3D:%3", (long)n, (long)n4, (long)n3);
        if (!this.amplifierVariant.isStandardOrBasicSound()) {
            this.dsi.set3DMode(n, n4, n3);
        } else {
            this.lc.log(10000000, "-> [DSISoundHandler.setThreeDMode] do not set 3 Mode in basic and standard sound variants");
        }
    }

    public void setSurround(int n, int n2, boolean bl) {
        int n3 = this.getAudioTerminal(n2);
        this.lc.log(10000000, "-> [DSISoundHandler.setSurroundLevel] AC:%1, AT:%2, enable:%3", (long)n, (long)n3, bl);
        this.dsi.setSurroundOnOff(n, n3, bl);
    }

    public void setSurround(int n, boolean bl) {
        int n2 = this.getActiveEntConn(0);
        this.setSurround(n2, n, bl);
    }

    public void setInputGainOffSet(int n, int n2, short s) {
        int n3 = this.getAudioTerminal(n2);
        this.lc.log(10000000, "-> [DSISoundHandler.setInputGainOffSet] AC:%1, AT:%2, value:%3", (long)n, (long)n3, (long)s);
        this.dsi.setInputGainOffset(n, n3, s);
    }

    public void setDuration(int n, int n2) {
        this.lc.log(10000000, "-> [DSISoundHandler.setDuration] AC:%1, duration:%2", (long)n, (long)n2);
        this.dsi.setDuration(n, n2);
    }

    private int getActiveEntConn(int n) {
        int n2 = this.audioService.getActiveEntertainmentConnection(n);
        if (n2 == 0) {
            this.lc.log(1000, "[DSISoundHandler.getActiveEntConn] No active entertainment connection found!");
        }
        return n2;
    }

    private int getAudioTerminal(int n) {
        return TerminalMapper.toAudioTerminal(n);
    }

    public void getLoweringEntertainment(int n, int n2, int n3) {
        int n4 = this.getAudioTerminal(n2);
        this.lc.log(10000000, "-> [DSISoundHandler.getLoweringEntertainment] AC:%1, audioTerminal:%2, type:%3", (long)n, (long)n4, (long)n3);
        this.dsi.getLoweringEntertainment(n, n4, n3);
    }

    public AmplifierVariant getAmplifierVariant() {
        return this.amplifierVariant;
    }
}

