/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.atip.interapp.audio.ToneService;
import de.audi.atip.log.LogChannel;

public class NullToneService
implements ToneService {
    private static final String LOGCLASS = "NullToneService";
    private final LogChannel logger;

    public NullToneService(LogChannel logChannel) {
        this.logger = logChannel;
    }

    public void updateMicGainLevel(int n) {
        this.logger.log(1000000, "[%1.updateMicGainLevel]", (Object)LOGCLASS);
    }

    public void updateMicGainRange(int n, int n2) {
        this.logger.log(1000000, "[%1.updateMicGainRange]", (Object)LOGCLASS);
    }

    public void updatePhoneAudioScenario(int n) {
        this.logger.log(1000000, "[%1.updatePhoneAudioScenario]", (Object)LOGCLASS);
    }

    public void updateBTLinkKeyAvailable(int n, boolean bl) {
        this.logger.log(1000000, "[%1.updateBTLinkKeyAvailable]", (Object)LOGCLASS);
    }

    public void setMicGainLevel(int n) {
        this.logger.log(1000000, "[%1.setMicGainLevel]", (Object)LOGCLASS);
    }

    public void updateUserDefinedRingtone(String string, String string2) {
        this.logger.log(1000000, "[%1.updateUserDefinedRingtone]", (Object)LOGCLASS);
    }

    public void setDuration(int n, int n2) {
        this.logger.log(1000000, "[%1.setDuration]", (Object)LOGCLASS);
    }

    public void setThreeDMode(int n) {
        this.logger.log(1000000, "[%1.setThreeDMode]", (Object)LOGCLASS);
    }

    public void setSurround(boolean bl) {
        this.logger.log(1000000, "[%1.setSurround]", (Object)LOGCLASS);
    }

    public void setInputGainOffSet(short s) {
        this.logger.log(1000000, "[%1.setInputGainOffSet]", (Object)LOGCLASS);
    }

    public void setSurroundForActiveEntertainment(boolean bl) {
        this.logger.log(1000000, "[%1.setSurroundForActiveEntertainment]", (Object)LOGCLASS);
    }
}

