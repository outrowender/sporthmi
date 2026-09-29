/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.picturestore.PictureStoreDSIListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.picturestore.DSIPictureStoreListener;

class PictureStoreDSIListener$20
extends CommandResponse {
    private final /* synthetic */ int val$contextID;
    private final /* synthetic */ int val$filterSetID;
    private final /* synthetic */ int val$count;
    private final /* synthetic */ PictureStoreDSIListener this$0;

    PictureStoreDSIListener$20(PictureStoreDSIListener pictureStoreDSIListener, int n, int n2, int n3) {
        this.this$0 = pictureStoreDSIListener;
        this.val$contextID = n;
        this.val$filterSetID = n2;
        this.val$count = n3;
    }

    @Override
    public void call(DSIListener dSIListener) {
        this.this$0.getLogChannel().log(-2137614336, "PictureStoreDSIListener#countPicturesInContextResult CommandResponse#call handler: %1 ", (Object)dSIListener);
        ((DSIPictureStoreListener)dSIListener).countPicturesInContextResult(this.val$contextID, this.val$filterSetID, this.val$count);
    }
}

