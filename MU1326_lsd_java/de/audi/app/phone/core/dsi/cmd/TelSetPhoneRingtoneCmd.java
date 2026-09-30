/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
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
        TelSetPhoneRingtoneCmd.schedule(commandListManager, this, "TelSetPhoneRingtoneCmd", new Command(this.logger, "TelSetPhoneRingtoneCmdError"){

            public void execute() {
                this.logger.log(100000, "[TelSetPhoneRingtoneCmd.schedule().new Command() {...}#execute] Error.");
                if (TelSetPhoneRingtoneCmd.this.listener != null) {
                    TelSetPhoneRingtoneCmd.this.listener.responseSetPhoneRingtone(65537, TelSetPhoneRingtoneCmd.this.terminalID);
                }
                this.getCommandList().commandFinished();
            }
        }, monitor);
    }

    public void execute() {
        this.logger.log(1000000, "[TelSetPhoneRingtoneCmd#execute] ringtoneIndex=%2, ringtonePath=%1", (Object)this.ringtonePath, (long)this.ringtoneIndex);
        if (this.isDSIAvailable()) {
            this.dsi.requestSetPhoneRingtone(this.ringtoneIndex, this.ringtonePath);
        } else {
            this.logger.log(100000, "[TelSetPhoneRingtoneCmd#execute] dsi is null!");
            this.getCommandList().commandFinished();
        }
    }

    public void responseSetPhoneRingtone(int n) {
        this.logger.log(1000000, "[TelSetPhoneRingtoneCmd#responseSetPhoneRingtone] result=%1", (long)n);
        if (this.listener != null) {
            this.listener.responseSetPhoneRingtone(n, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

