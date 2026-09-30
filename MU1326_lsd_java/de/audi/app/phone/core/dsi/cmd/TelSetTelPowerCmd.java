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

public class TelSetTelPowerCmd
extends AbstractTelDSIMECommand {
    private static final long TIMEOUT = 300000L;
    private final int telPower;

    public TelSetTelPowerCmd(int n, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n2, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelSetTelPowerCmd", n2, iTelDSIResponseListener);
        this.telPower = n;
    }

    public long getTimeout() {
        return 300000L;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelSetTelPowerCmd.schedule(commandListManager, this, "TelSetTelPowerCmd", new Command(this.logger, "TelSetTelPowerCmdError"){

            public void execute() {
                this.logger.log(100000, "[TelSetTelPowerCmd.schedule().new Command() {...}#execute] Error.");
                if (TelSetTelPowerCmd.this.listener != null) {
                    TelSetTelPowerCmd.this.listener.responseTelPower(65537, TelSetTelPowerCmd.this.terminalID);
                }
                this.getCommandList().commandFinished();
            }
        }, monitor);
    }

    public void execute() {
        this.logger.log(1000000, "[TelSetTelPowerCmd#execute] telPower=%1", (long)this.telPower);
        if (this.isDSIAvailable()) {
            this.dsi.requestTelPower(this.telPower);
        } else {
            this.logger.log(100000, "[TelSetTelPowerCmd#execute] DSITelephone is null!");
            this.getCommandList().commandFinished();
        }
    }

    public void responseTelPower(int n) {
        this.logger.log(1000000, "[TelSetTelPowerCmd#responseTelPower] result=%1", (long)n);
        if (this.listener != null) {
            this.listener.responseTelPower(n, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

