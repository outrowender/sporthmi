/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;

public class StoreStartingTimeCommand
extends NavCommand {
    public static final String STARTING_TIME_KEY = "STARTING_TIME_KEY";

    public void execute() {
        long l = this.env.getFramework().getKombiTime();
        this.getCommandList().put(STARTING_TIME_KEY, new Long(l));
        this.getCommandList().commandFinished();
    }
}

