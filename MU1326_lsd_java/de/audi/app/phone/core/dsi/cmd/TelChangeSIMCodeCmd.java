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

public class TelChangeSIMCodeCmd
extends AbstractTelDSIMECommand {
    private final int telLockCode;
    private final String telCurrentCode;
    private final String telNewCode;

    public TelChangeSIMCodeCmd(int n, String string, String string2, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n2, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelChangeSIMCodeCmd", n2, iTelDSIResponseListener);
        this.telLockCode = n;
        this.telCurrentCode = string;
        this.telNewCode = string2;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelChangeSIMCodeCmd.schedule(commandListManager, this, "TelChangeSIMCodeCmd", new Command(this.logger, "TelChangeSIMCodeCmdError"){

            public void execute() {
                this.logger.log(100000, "[TelChangeSIMCodeCmd.schedule().new Command() {...}#execute] Error.");
                if (TelChangeSIMCodeCmd.this.listener != null) {
                    TelChangeSIMCodeCmd.this.listener.responseChangeSIMCode(-1, 65537, TelChangeSIMCodeCmd.this.terminalID);
                }
                this.getCommandList().commandFinished();
            }
        }, monitor);
    }

    public void execute() {
        if (this.isDSIAvailable()) {
            this.logger.log(1000000, "[TelChangeSIMCodeCmd#execute] telLockCode=%1, telCurrentCode=%2, telNewCode=%3", (Object)String.valueOf(this.telLockCode), (Object)this.telCurrentCode, (Object)this.telNewCode);
            this.dsi.requestChangeSIMCode(this.telLockCode, this.telCurrentCode, this.telNewCode);
        } else {
            this.logger.log(100000, "[TelChangeSIMCodeCmd#execute] dsi is null!");
            this.getCommandList().commandFinished();
        }
    }

    public void responseChangeSIMCode(int n, int n2) {
        this.logger.log(1000000, "[TelChangeSIMCodeCmd#responseChangeSIMCode] telLockCode=%1, result=%2", (long)n, (long)n2);
        if (this.listener != null) {
            this.listener.responseChangeSIMCode(n, n2, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

