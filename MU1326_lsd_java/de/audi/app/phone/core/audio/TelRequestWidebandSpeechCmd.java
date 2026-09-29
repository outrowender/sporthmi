/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.audio.AbstractTelAudioCmd;
import de.audi.app.phone.core.audio.ITelAudioCmdListener;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.audio.DSISound;
import org.dsi.ifc.audio.DSISoundListener;

public class TelRequestWidebandSpeechCmd
extends AbstractTelAudioCmd
implements ITelAudioCmdListener {
    private final DSISound dsiSound;
    private final boolean on;
    private final DSISoundListener listener;

    public TelRequestWidebandSpeechCmd(LogChannel logChannel, DSISound dSISound, HMIAudioService hMIAudioService, boolean bl, DSISoundListener dSISoundListener) {
        super(logChannel, new StringBuffer().append("TelRequestWidebandSpeechCmd: ").append(bl).toString(), hMIAudioService);
        this.dsiSound = dSISound;
        this.on = bl;
        this.listener = dSISoundListener;
    }

    @Override
    public void execute() {
        if (this.dsiSound != null) {
            this.logger.log(1078071040, "[TelRequestWidebandSpeechCmd#execute] onoff=%1", this.on);
            this.dsiSound.setWidebandSpeech(0, this.on);
        } else {
            this.logger.log(-1601830656, "[TelRequestWidebandSpeechCmd#execute] logMessage");
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void responseWidebandSpeech(int n, boolean bl) {
        this.logger.log(1078071040, "[TelRequestWidebandSpeechCmd#responseWidebandSpeech] onoff=%1", bl);
        if (this.listener != null) {
            this.listener.responseWidebandSpeech(n, bl);
        }
        this.getCommandList().commandFinished();
    }
}

