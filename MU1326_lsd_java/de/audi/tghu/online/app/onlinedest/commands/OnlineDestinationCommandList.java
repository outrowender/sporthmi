/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.onlinedest.commands;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.online.app.onlinedest.OnlineDestinationController;
import org.dsi.ifc.online.DSIDestinationImport;

public class OnlineDestinationCommandList
extends CommandList {
    DSIDestinationImport dsi;
    OnlineDestinationController application;

    public OnlineDestinationCommandList(OnlineDestinationController onlineDestinationController) {
        super(onlineDestinationController.getCmdListManager());
        this.application = onlineDestinationController;
    }

    public OnlineDestinationController getApplication() {
        return this.application;
    }
}

