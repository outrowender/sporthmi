/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.picturestore.PictureStoreDSIListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.picturestore.DSIPictureStoreListener;

class PictureStoreDSIListener$4
extends CommandResponse {
    private final /* synthetic */ int val$contextID;
    private final /* synthetic */ int val$numberOfFreeSlots;
    private final /* synthetic */ PictureStoreDSIListener this$0;

    PictureStoreDSIListener$4(PictureStoreDSIListener pictureStoreDSIListener, int n, int n2) {
        this.this$0 = pictureStoreDSIListener;
        this.val$contextID = n;
        this.val$numberOfFreeSlots = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        this.this$0.getLogChannel().log(-2137614336, "PictureStoreDSIListener#freeSlots CommandResponse#call handler: %1 ", (Object)dSIListener);
        ((DSIPictureStoreListener)dSIListener).freeSlots(this.val$contextID, this.val$numberOfFreeSlots);
    }
}

