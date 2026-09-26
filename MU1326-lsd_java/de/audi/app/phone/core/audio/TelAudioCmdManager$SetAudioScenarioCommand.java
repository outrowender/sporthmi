/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.audio.AbstractTelAudioCmd;
import de.audi.app.phone.core.audio.TelAudioCmdManager;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.log.LogChannel;

class TelAudioCmdManager$SetAudioScenarioCommand
extends AbstractTelAudioCmd {
    final int audioScenario;
    private final /* synthetic */ TelAudioCmdManager this$0;

    TelAudioCmdManager$SetAudioScenarioCommand(TelAudioCmdManager telAudioCmdManager, LogChannel logChannel, HMIAudioService hMIAudioService, int n) {
        this.this$0 = telAudioCmdManager;
        super(logChannel, "SetAudioScenarioCommand", hMIAudioService);
        this.audioScenario = n;
    }

    @Override
    public void execute() {
        TelAudioCmdManager.access$000(this.this$0, this.audioScenario);
        this.getCommandList().commandFinished();
    }
}

