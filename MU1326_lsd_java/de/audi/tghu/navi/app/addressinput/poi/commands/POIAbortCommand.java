/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.commands;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.SpellerStack;

public class POIAbortCommand
extends NavCommand {
    private final NavigationEnv env;
    private final LogChannel logChannel;

    public POIAbortCommand(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getPOILogChannel();
    }

    public void execute() {
        this.logChannel.log(1000000, "AbortPOICommand#execute - Current state of the speller stack: [%1]", (Object)SpellerStack.getInstance().toString());
        this.getCommandList().commandFinished();
    }
}

