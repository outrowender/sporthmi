/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.picturestore.PictureStoreDSIListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.picturestore.DSIPictureStoreListener;

class PictureStoreDSIListener$17
extends CommandResponse {
    private final /* synthetic */ int val$sourceFilterSetID;
    private final /* synthetic */ int val$newFilterSetID;
    private final /* synthetic */ PictureStoreDSIListener this$0;

    PictureStoreDSIListener$17(PictureStoreDSIListener pictureStoreDSIListener, int n, int n2) {
        this.this$0 = pictureStoreDSIListener;
        this.val$sourceFilterSetID = n;
        this.val$newFilterSetID = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        this.this$0.getLogChannel().log(-2137614336, "PictureStoreDSIListener#cloneFilterSetResult CommandResponse#call handler: %1 ", (Object)dSIListener);
        ((DSIPictureStoreListener)dSIListener).cloneFilterSetResult(this.val$sourceFilterSetID, this.val$newFilterSetID);
    }
}

