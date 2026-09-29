/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.picturestore.PictureStoreDSIListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.picturestore.DSIPictureStoreListener;

class PictureStoreDSIListener$16
extends CommandResponse {
    private final /* synthetic */ int val$filterSetID;
    private final /* synthetic */ PictureStoreDSIListener this$0;

    PictureStoreDSIListener$16(PictureStoreDSIListener pictureStoreDSIListener, int n) {
        this.this$0 = pictureStoreDSIListener;
        this.val$filterSetID = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        this.this$0.getLogChannel().log(-2137614336, "PictureStoreDSIListener#createFilterSetResult CommandResponse#call handler: %1 ", (Object)dSIListener);
        ((DSIPictureStoreListener)dSIListener).createFilterSetResult(this.val$filterSetID);
    }
}

