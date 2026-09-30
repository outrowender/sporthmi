/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.cmd.lists;

import de.audi.atip.log.LogChannel;
import de.audi.tv.app.cmd.AbstractTVCommand;
import de.audi.tv.app.lists.IServiceListsResource;

public class LoadFavoritesCmd
extends AbstractTVCommand {
    private final IServiceListsResource serviceListsResource;

    public LoadFavoritesCmd(LogChannel logChannel, IServiceListsResource iServiceListsResource) {
        super(logChannel, 0);
        this.setName("LoadFavoritesCmd");
        this.serviceListsResource = iServiceListsResource;
    }

    public void execute() {
        this.logger.log(100000000, "[LoadFavoritesCmd.execute] command started");
        this.serviceListsResource.loadFavoritesFromMemory();
        this.logger.log(100000000, "[LoadFavoritesCmd.execute] command finished");
        this.commandFinished();
    }
}

