/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.app.phone.core.dsi.cmd.TelSetPhoneRingtoneCmd$1;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.Monitor;

public class TelSetPhoneRingtoneCmd
extends AbstractTelDSIMECommand {
    private final int ringtoneIndex;
    private final String ringtonePath;

    public TelSetPhoneRingtoneCmd(int n, String string, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n2, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelSetPhoneRingtoneCmd", n2, iTelDSIResponseListener);
        this.ringtoneIndex = n;
        this.ringtonePath = string;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelSetPhoneRingtoneCmd.schedule(commandListManager, this, "TelSetPhoneRingtoneCmd", new TelSetPhoneRingtoneCmd$1(this, this.logger, "TelSetPhoneRingtoneCmdError"), monitor);
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[TelSetPhoneRingtoneCmd#execute] ringtoneIndex=%2, ringtonePath=%1", (Object)this.ringtonePath, (long)this.ringtoneIndex);
        if (this.isDSIAvailable()) {
            this.dsi.requestSetPhoneRingtone(this.ringtoneIndex, this.ringtonePath);
        } else {
            this.logger.log(-1601830656, "[TelSetPhoneRingtoneCmd#execute] dsi is null!");
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void responseSetPhoneRingtone(int n) {
        this.logger.log(1078071040, "[TelSetPhoneRingtoneCmd#responseSetPhoneRingtone] result=%1", (long)n);
        if (this.listener != null) {
            this.listener.responseSetPhoneRingtone(n, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

