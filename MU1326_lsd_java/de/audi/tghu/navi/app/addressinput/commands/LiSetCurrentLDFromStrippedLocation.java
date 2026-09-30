/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.commands;

import de.audi.tghu.navi.app.addressinput.commands.LISetCurrentLDCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

public class LiSetCurrentLDFromStrippedLocation
extends NavCommand {
    public void execute() {
        this.getCommandList().commandFinishedWithPostCommand(new LISetCurrentLDCommand((NavLocation)this.getCommandList().get("STRIPPED_LOCATION")));
    }
}

