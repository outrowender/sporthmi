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
import org.dsi.ifc.telephoneng.LockStateStruct;

public class TelUnlockSIMCmd
extends AbstractTelDSIMECommand {
    private static final long TIMEOUT = 150000L;
    private final int telLockCode;
    private final String telCurrentCode;
    private final String telNewCode;
    private volatile LockStateStruct lockState;

    public TelUnlockSIMCmd(int n, String string, String string2, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n2, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelUnlockSIMCmd", n2, iTelDSIResponseListener);
        this.telLockCode = n;
        this.telCurrentCode = string;
        this.telNewCode = string2;
    }

    public long getTimeout() {
        return 150000L;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelUnlockSIMCmd.schedule(commandListManager, this, "TelUnlockSIMCmd", new Command(this.logger, "TelUnlockSIMCmdError"){

            public void execute() {
                this.logger.log(100000, "[TelUnlockSIMCmd.schedule().new Command() {...}#execute] Error.");
                if (TelUnlockSIMCmd.this.listener != null) {
                    TelUnlockSIMCmd.this.listener.responseUnlockSIM(65537, TelUnlockSIMCmd.this.terminalID, null);
                }
                this.getCommandList().commandFinished();
            }
        }, monitor);
    }

    public void execute() {
        this.logger.log(1000000, "[TelUnlockSIMCmd#execute] lockCode=%3, currentCode=%1, newCode=%2", (Object)this.telCurrentCode, (Object)this.telNewCode, (long)this.telLockCode);
        if (this.isDSIAvailable()) {
            this.dsi.requestUnlockSIM(this.telLockCode, this.telCurrentCode, this.telNewCode);
        } else {
            this.logger.log(100000, "[TelUnlockSIMCmd#execute] dsi is null!");
            this.getCommandList().commandFinished();
        }
    }

    public void updateLockState(LockStateStruct lockStateStruct, int n) {
        this.logger.log(1000000, "[TelUnlockSIMCmd#updateLockState] lockState=%1", (Object)lockStateStruct);
        this.lockState = lockStateStruct;
    }

    public void responseUnlockSIM(int n) {
        this.logger.log(1000000, "[TelUnlockSIMCmd#responseUnlockSIM] result=%1", (long)n);
        if (this.listener != null) {
            this.listener.responseUnlockSIM(n, this.terminalID, this.lockState);
        }
        this.getCommandList().commandFinished();
    }
}

