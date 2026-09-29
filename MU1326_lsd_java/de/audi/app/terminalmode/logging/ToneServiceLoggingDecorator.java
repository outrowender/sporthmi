/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.logging;

import de.audi.atip.interapp.audio.ToneService;
import de.audi.atip.log.LogChannel;

public class ToneServiceLoggingDecorator
implements ToneService {
    private final ToneService wrappee;
    private final LogChannel lc;
    private final int level;

    public ToneServiceLoggingDecorator(ToneService toneService, LogChannel logChannel, int n) {
        this.wrappee = toneService;
        this.lc = logChannel;
        this.level = n;
    }

    @Override
    public void updateMicGainLevel(int n) {
        this.lc.log(this.level, "-> [ToneService.updateMicGainLevel] %1", (long)n);
        this.wrappee.updateMicGainLevel(n);
    }

    @Override
    public void updateMicGainRange(int n, int n2) {
        this.lc.log(this.level, "-> [ToneService.updateMicGainRange] min %1, max %2", (long)n, (long)n2);
        this.wrappee.updateMicGainRange(n, n2);
    }

    @Override
    public void updatePhoneAudioScenario(int n) {
        this.lc.log(this.level, "-> [ToneService.updatePhoneAudioScenario] %1", (long)n);
        this.wrappee.updatePhoneAudioScenario(n);
    }

    @Override
    public void updateBTLinkKeyAvailable(int n, boolean bl) {
        this.lc.log(this.level, "-> [ToneService.updateBTLinkKeyAvailable] terminalID %1, available %2", (Object)Integer.toString(n), (Object)Boolean.toString(bl));
        this.wrappee.updateBTLinkKeyAvailable(n, bl);
    }

    @Override
    public void setMicGainLevel(int n) {
        this.lc.log(this.level, "-> [ToneService.updateMicGainLevel] %1", (long)n);
        this.wrappee.setMicGainLevel(n);
    }

    @Override
    public void updateUserDefinedRingtone(String string, String string2) {
        this.lc.log(this.level, "-> [ToneService.updateUserDefinedRingtone] %1, %2", (Object)string, (Object)string2);
        this.wrappee.updateUserDefinedRingtone(string, string2);
    }

    @Override
    public void setDuration(int n, int n2) {
        this.lc.log(this.level, "-> [ToneService.setDuration] connection %1, duration %2", (long)n, (long)n2);
        this.wrappee.setDuration(n, n2);
    }

    @Override
    public void setThreeDMode(int n) {
        this.lc.log(this.level, "-> [ToneService.setThreeDMode] %1", (long)n);
        this.wrappee.setThreeDMode(n);
    }

    @Override
    public void setSurround(boolean bl) {
        this.lc.log(this.level, "-> [ToneService.setSurround] %1", bl);
        this.wrappee.setSurround(bl);
    }

    @Override
    public void setSurroundForActiveEntertainment(boolean bl) {
        this.lc.log(this.level, "-> [ToneService.setSurroundForActiveEntertainment] %1", bl);
        this.wrappee.setSurroundForActiveEntertainment(bl);
    }

    @Override
    public void setInputGainOffSet(short s) {
        this.lc.log(this.level, "-> [ToneService.setInputGainOffSet] %1", (long)s);
        this.wrappee.setInputGainOffSet(s);
    }
}

