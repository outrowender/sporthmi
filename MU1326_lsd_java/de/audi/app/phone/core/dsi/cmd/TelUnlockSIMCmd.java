/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.app.phone.core.dsi.cmd.TelUnlockSIMCmd$1;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.Monitor;
import org.dsi.ifc.telephoneng.LockStateStruct;

public class TelUnlockSIMCmd
extends AbstractTelDSIMECommand {
    private static final long TIMEOUT;
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

    @Override
    public long getTimeout() {
        return 0;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelUnlockSIMCmd.schedule(commandListManager, this, "TelUnlockSIMCmd", new TelUnlockSIMCmd$1(this, this.logger, "TelUnlockSIMCmdError"), monitor);
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[TelUnlockSIMCmd#execute] lockCode=%3, currentCode=%1, newCode=%2", (Object)this.telCurrentCode, (Object)this.telNewCode, (long)this.telLockCode);
        if (this.isDSIAvailable()) {
            this.dsi.requestUnlockSIM(this.telLockCode, this.telCurrentCode, this.telNewCode);
        } else {
            this.logger.log(-1601830656, "[TelUnlockSIMCmd#execute] dsi is null!");
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void updateLockState(LockStateStruct lockStateStruct, int n) {
        this.logger.log(1078071040, "[TelUnlockSIMCmd#updateLockState] lockState=%1", (Object)lockStateStruct);
        this.lockState = lockStateStruct;
    }

    @Override
    public void responseUnlockSIM(int n) {
        this.logger.log(1078071040, "[TelUnlockSIMCmd#responseUnlockSIM] result=%1", (long)n);
        if (this.listener != null) {
            this.listener.responseUnlockSIM(n, this.terminalID, this.lockState);
        }
        this.getCommandList().commandFinished();
    }
}

