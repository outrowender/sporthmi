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
        super(logChannel, "TelRequestWidebandSpeechCmd: " + bl, hMIAudioService);
        this.dsiSound = dSISound;
        this.on = bl;
        this.listener = dSISoundListener;
    }

    public void execute() {
        if (this.dsiSound != null) {
            this.logger.log(1000000, "[TelRequestWidebandSpeechCmd#execute] onoff=%1", this.on);
            this.dsiSound.setWidebandSpeech(0, this.on);
        } else {
            this.logger.log(100000, "[TelRequestWidebandSpeechCmd#execute] logMessage");
            this.getCommandList().commandFinished();
        }
    }

    public void responseWidebandSpeech(int n, boolean bl) {
        this.logger.log(1000000, "[TelRequestWidebandSpeechCmd#responseWidebandSpeech] onoff=%1", bl);
        if (this.listener != null) {
            this.listener.responseWidebandSpeech(n, bl);
        }
        this.getCommandList().commandFinished();
    }
}

