/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.audio.AbstractTelAudioCmd;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.log.LogChannel;

public class TelUpdateRingtoneMuteStateCmd
extends AbstractTelAudioCmd {
    private final boolean ringtoneMuteOn;
    private final ITelApplication application;

    TelUpdateRingtoneMuteStateCmd(LogChannel logChannel, HMIAudioService hMIAudioService, boolean bl, ITelApplication iTelApplication) {
        super(logChannel, "TelUpdateRingtoneMuteStateCmd", hMIAudioService);
        this.ringtoneMuteOn = bl;
        this.application = iTelApplication;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[TelUpdateRingtoneMuteStateCmd#execute] ringtoneMuteOn=%1", this.ringtoneMuteOn);
        this.application.getGlobalTelephoneStateManager().updateRingtoneMuteActive(this.ringtoneMuteOn);
        this.getCommandList().commandFinished();
    }
}

