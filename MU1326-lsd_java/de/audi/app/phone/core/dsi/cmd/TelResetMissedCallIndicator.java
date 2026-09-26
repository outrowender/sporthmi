/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.app.phone.core.dsi.cmd.TelResetMissedCallIndicator$1;
import de.audi.app.phone.core.epm.ITelEPMHandler;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.Monitor;

public class TelResetMissedCallIndicator
extends AbstractTelDSIMECommand {
    public TelResetMissedCallIndicator(ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelEPMHandler iTelEPMHandler) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelResetMissedCallIndicator", n, iTelDSIResponseListener);
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelResetMissedCallIndicator.schedule(commandListManager, this, "TelResetMissedCallIndicator", new TelResetMissedCallIndicator$1(this, this.logger, "TelResetMissedCallIndicatorError"), monitor);
    }

    @Override
    public void execute() {
        if (this.isDSIAvailable()) {
            this.logger.log(1078071040, "[TelResetMissedCallIndicator#execute]");
            this.dsi.resetMissedCallIndicator();
        } else {
            this.logger.log(-1601830656, "[TelResetMissedCallIndicator#execute] dsi is null --> NOP!");
        }
        this.getCommandList().commandFinished();
    }
}

