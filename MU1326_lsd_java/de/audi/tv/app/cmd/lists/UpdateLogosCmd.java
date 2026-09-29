/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.cmd.lists;

import de.audi.atip.log.LogChannel;
import de.audi.tv.app.cmd.AbstractTVCommand;
import de.audi.tv.app.lists.IServiceListsResource;
import org.dsi.ifc.tvtuner.LogoInfo;

public class UpdateLogosCmd
extends AbstractTVCommand {
    private final IServiceListsResource resource;
    private final LogoInfo[] logos;

    public UpdateLogosCmd(LogChannel logChannel, IServiceListsResource iServiceListsResource, LogoInfo[] logoInfoArray) {
        super(logChannel, 3);
        this.resource = iServiceListsResource;
        this.logos = logoInfoArray;
    }

    @Override
    public void execute() {
        this.logger.log(14808325, "[UpdateLogosCmd.execute] command started");
        this.resource.updateLogoList(this.logos);
        this.logger.log(14808325, "[UpdateLogosCmd.execute] command finished");
        this.commandFinished();
    }
}

