/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio.functionsync;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayFSG;
import de.audi.app.combi.bap.app.audio.list.MediaBrowserListHandler;
import de.audi.app.combi.bap.functionsync.AbstractFunctionSyncEpilogueAction;
import de.audi.atip.log.LogChannel;

final class EpilogueActionMediaBrowserFullRangeUpdate
extends AbstractFunctionSyncEpilogueAction {
    private final BAPFunctionArrayFSG mediaBrowserArray;

    public EpilogueActionMediaBrowserFullRangeUpdate(AbstractBAPModuleFSG abstractBAPModuleFSG, LogChannel logChannel) {
        super(abstractBAPModuleFSG, logChannel);
        this.mediaBrowserArray = abstractBAPModuleFSG.getBAPFunctionArrayFSG(36);
    }

    protected void execute() {
        MediaBrowserListHandler mediaBrowserListHandler = (MediaBrowserListHandler)this.mediaBrowserArray.getArrayHandler();
        if (mediaBrowserListHandler != null && mediaBrowserListHandler.isListSizeUpdateDeferred()) {
            mediaBrowserListHandler.resetListSizeUpdateDeferred();
            mediaBrowserListHandler.sendFullRangeUpdate();
        }
    }
}

