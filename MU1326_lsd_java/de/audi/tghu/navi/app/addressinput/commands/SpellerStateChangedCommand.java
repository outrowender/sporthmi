/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.commands;

import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.command.NavCommand;

public class SpellerStateChangedCommand
extends NavCommand {
    private final IMatchspellerModelAccess modelAccess;
    private final int index;

    public SpellerStateChangedCommand(int n, IMatchspellerModelAccess iMatchspellerModelAccess) {
        this.index = n;
        this.modelAccess = iMatchspellerModelAccess;
    }

    public void execute() {
        this.modelAccess.onSpellerStatusChanged(this.index);
        this.getCommandList().commandFinished();
    }
}

