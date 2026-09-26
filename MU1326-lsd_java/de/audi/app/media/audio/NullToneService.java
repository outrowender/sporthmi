/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.audio;

import de.audi.atip.interapp.audio.ToneService;
import de.audi.atip.log.LogChannel;

public class NullToneService
implements ToneService {
    private static final String LOGCLASS;
    private final LogChannel logger;

    public NullToneService(LogChannel logChannel) {
        this.logger = logChannel;
    }

    @Override
    public void updateMicGainLevel(int n) {
        this.logger.log(1078071040, "[%1.updateMicGainLevel]", (Object)"NullToneService");
    }

    @Override
    public void updateMicGainRange(int n, int n2) {
        this.logger.log(1078071040, "[%1.updateMicGainRange]", (Object)"NullToneService");
    }

    @Override
    public void updatePhoneAudioScenario(int n) {
        this.logger.log(1078071040, "[%1.updatePhoneAudioScenario]", (Object)"NullToneService");
    }

    @Override
    public void updateBTLinkKeyAvailable(int n, boolean bl) {
        this.logger.log(1078071040, "[%1.updateBTLinkKeyAvailable]", (Object)"NullToneService");
    }

    @Override
    public void setMicGainLevel(int n) {
        this.logger.log(1078071040, "[%1.setMicGainLevel]", (Object)"NullToneService");
    }

    @Override
    public void updateUserDefinedRingtone(String string, String string2) {
        this.logger.log(1078071040, "[%1.updateUserDefinedRingtone]", (Object)"NullToneService");
    }

    @Override
    public void setDuration(int n, int n2) {
        this.logger.log(1078071040, "[%1.setDuration]", (Object)"NullToneService");
    }

    @Override
    public void setThreeDMode(int n) {
        this.logger.log(1078071040, "[%1.setThreeDMode]", (Object)"NullToneService");
    }

    @Override
    public void setSurround(boolean bl) {
        this.logger.log(1078071040, "[%1.setSurround]", (Object)"NullToneService");
    }

    @Override
    public void setInputGainOffSet(short s) {
        this.logger.log(1078071040, "[%1.setInputGainOffSet]", (Object)"NullToneService");
    }

    @Override
    public void setSurroundForActiveEntertainment(boolean bl) {
        this.logger.log(1078071040, "[%1.setSurroundForActiveEntertainment]", (Object)"NullToneService");
    }
}

