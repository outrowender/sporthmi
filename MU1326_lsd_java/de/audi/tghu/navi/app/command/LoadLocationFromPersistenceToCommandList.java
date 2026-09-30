/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocalPersistNavLocationHelper;

public class LoadLocationFromPersistenceToCommandList
extends NavCommand {
    private final int persistenceKey;
    private final String mapKey;

    public LoadLocationFromPersistenceToCommandList(int n, String string) {
        this.persistenceKey = n;
        this.mapKey = string;
    }

    public void execute() {
        byte[] byArray = new LocalPersistNavLocationHelper(this.env, this.persistenceKey).loadPersistentState();
        this.logger.log(10000000, "%1#execute() - put byte[] into commandList [%2]", (Object)this.CLASS_NAME, (Object)byArray);
        this.getCommandList().put(this.mapKey, byArray);
        this.getCommandList().commandFinished();
    }
}

