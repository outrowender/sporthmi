/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.commands;

import de.audi.tghu.navi.app.command.LISetHistoryCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

public class SetHistoryContextWithCurrentLDCommand
extends NavCommand {
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
        this.logger.log(10000000, "%1#execute() - calling LISetHistoryCommand with currentLD %2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
        this.getCommandList().commandFinishedWithPostCommand(new LISetHistoryCommand(navLocation));
    }
}

