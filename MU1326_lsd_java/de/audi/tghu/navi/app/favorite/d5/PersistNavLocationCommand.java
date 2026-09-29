/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.favorite.d5;

import de.audi.tghu.command.ICommandList;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocalPersistNavLocationHelper;

public class PersistNavLocationCommand
extends NavCommand {
    private final int key;

    public PersistNavLocationCommand(int n) {
        this.key = n;
    }

    @Override
    public void execute() {
        ICommandList iCommandList = this.getCommandList();
        byte[] byArray = (byte[])iCommandList.get("LOCATION_STREAM");
        new LocalPersistNavLocationHelper(this.env, this.key).savePersistentState(byArray);
        this.getCommandList().commandFinished();
    }
}

