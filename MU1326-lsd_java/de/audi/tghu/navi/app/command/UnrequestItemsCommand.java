/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.command.NavCommand;

public class UnrequestItemsCommand
extends NavCommand {
    private final int length;
    private final int startIndex;
    private final IMatchspellerModelAccess modelAccess;

    public UnrequestItemsCommand(int n, int n2, IMatchspellerModelAccess iMatchspellerModelAccess) {
        this.startIndex = n;
        this.length = n2;
        this.modelAccess = iMatchspellerModelAccess;
    }

    @Override
    public void execute() {
        this.modelAccess.unrequestItems(this.startIndex, this.length);
        this.getCommandList().commandFinished();
    }
}

