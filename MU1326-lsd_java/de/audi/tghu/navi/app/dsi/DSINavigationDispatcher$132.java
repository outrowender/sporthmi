/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.BlockElement;

class DSINavigationDispatcher$132
extends CommandResponse {
    private final /* synthetic */ BlockElement[] val$listOfBlocks;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$132(DSINavigationDispatcher dSINavigationDispatcher, BlockElement[] blockElementArray) {
        this.this$0 = dSINavigationDispatcher;
        this.val$listOfBlocks = blockElementArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateListOfBlocks(this.val$listOfBlocks);
    }
}

