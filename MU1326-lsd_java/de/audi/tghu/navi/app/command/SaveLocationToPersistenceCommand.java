/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocalPersistNavLocationHelper;

public class SaveLocationToPersistenceCommand
extends NavCommand {
    private final String mapKey;
    private final int persistenceKey;

    public SaveLocationToPersistenceCommand(int n, String string) {
        this.persistenceKey = n;
        this.mapKey = string;
    }

    @Override
    public void execute() {
        byte[] byArray = (byte[])this.getCommandList().get(this.mapKey);
        new LocalPersistNavLocationHelper(this.env, this.persistenceKey).savePersistentState(byArray);
        this.getCommandList().commandFinished();
    }
}

