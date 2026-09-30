/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.command;

import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import org.dsi.ifc.online.DSIOnlineServiceRegistration;
import org.dsi.ifc.online.OSRServiceState;

public class OSRSetLanguageCommand
extends AbstractOSRCommand {
    private String language;

    public OSRSetLanguageCommand(String string) {
        this.language = string;
    }

    public void execute() {
        this.logger.log(10000000, "ORSSetLanguageCommand#execute() - call method setLanguage( %1 )", (Object)this.language);
        DSIOnlineServiceRegistration dSIOnlineServiceRegistration = this.getDSI();
        if (dSIOnlineServiceRegistration == null) {
            this.logger.log(10000, "ORSSetLanguageCommand#execute no DSI");
            return;
        }
        dSIOnlineServiceRegistration.setLanguage(this.language);
        this.getCommandList().commandFinished();
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }
}

