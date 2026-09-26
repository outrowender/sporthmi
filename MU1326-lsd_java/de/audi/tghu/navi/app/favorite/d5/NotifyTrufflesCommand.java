/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.favorite.d5;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.search.AbstractNaviSearchDataProvider;

public class NotifyTrufflesCommand
extends NavCommand {
    private final AbstractNaviSearchDataProvider provider;

    public NotifyTrufflesCommand(AbstractNaviSearchDataProvider abstractNaviSearchDataProvider) {
        this.provider = abstractNaviSearchDataProvider;
    }

    @Override
    public void execute() {
        this.provider.invalidateData();
        this.getCommandList().commandFinished();
    }
}

