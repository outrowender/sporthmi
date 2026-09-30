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

public class TelSetLanguageCmd
extends AbstractTelDSIMECommand {
    private final String language;

    public TelSetLanguageCmd(String string, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelSetLanguageCmd", n, iTelDSIResponseListener);
        this.language = string;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelSetLanguageCmd.schedule(commandListManager, this, "TelSetLanguageCmd", new Command(this.logger, "TelSetLanguageCmdError"){

            public void execute() {
                this.logger.log(100000, "[TelSetLanguageCmd.schedule().new Command() {...}#execute] Error.");
                this.getCommandList().commandFinished();
            }
        }, monitor);
    }

    public void execute() {
        this.logger.log(1000000, "[TelSetLanguageCmd#execute] language=%1", (Object)this.language);
        if (this.isDSIAvailable()) {
            this.dsi.requestSetLanguage(this.language);
        } else {
            this.logger.log(100000, "[TelSetLanguageCmd#execute] dsi is null!");
        }
        this.getCommandList().commandFinished();
    }
}

