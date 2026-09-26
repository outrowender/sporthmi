/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.handler;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.terminalmode.DefaultTerminalModeUpdateListener;
import de.audi.atip.interapp.terminalmode.TerminalModeAudioUsage;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.operatorcall.AbstractOperatorCallMain;

public class TerminalModeHandler
extends DefaultTerminalModeUpdateListener {
    private static final int TERMINALMODE_CALL_ACTIVE;
    private static final int TERMINALMODE_CALL_NOT_ACTIVE;
    private final LogChannel logChannel = Online.getInstance().getOperatorCallLogChannel();
    private boolean isTerminalModeActive = false;
    private AbstractOperatorCallMain operatorCallMain;
    private final ChoiceModelApp operatorCallBlockedByTMChoice;

    public TerminalModeHandler(AbstractOperatorCallMain abstractOperatorCallMain, HMIService hMIService) {
        this.operatorCallMain = abstractOperatorCallMain;
        this.operatorCallBlockedByTMChoice = hMIService.getChoiceModel(1059005184);
    }

    @Override
    public void updateAudioConnectionUsage(TerminalModeAudioUsage terminalModeAudioUsage) {
        if (terminalModeAudioUsage != null) {
            this.isTerminalModeActive = terminalModeAudioUsage.isInUse();
            this.logChannel.log(1078071040, "TerminalModeUpdateListener#updateAudioConnectionUsage: setting isTerminalModeActive to '%1'.", (Object)Boolean.toString(this.isTerminalModeActive));
            if (this.operatorCallMain.isTerminalModeChangedSupressed(this.isTerminalModeActive)) {
                this.logChannel.log(1078071040, "TerminalModeUpdateListener#updateAudioConnectionUsage: Do not trigger abort connection because a CarPlay call is connecting.");
            } else {
                this.logChannel.log(1078071040, "TerminalModeUpdateListener#updateAudioConnectionUsage: Triggering terminalModeChanged()");
                this.operatorCallMain.terminalModeChanged();
                this.operatorCallBlockedByTMChoice.setValue(this.isTerminalModeActive ? 1 : 0);
            }
        } else {
            this.logChannel.log(1078071040, "TerminalModeUpdateListener#updateAudioConnectionUsage: reveiced null for pAudioUsageList '%1'.", (Object)Boolean.toString(this.isTerminalModeActive));
        }
    }

    public boolean isTerminalModeActive() {
        return this.isTerminalModeActive;
    }
}

