/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.picturestore.PictureStoreDSIListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.DSIPictureStoreListener;

class PictureStoreDSIListener$5
extends CommandResponse {
    private final /* synthetic */ ResourceLocator val$rl;
    private final /* synthetic */ int[] val$contextIDs;
    private final /* synthetic */ PictureStoreDSIListener this$0;

    PictureStoreDSIListener$5(PictureStoreDSIListener pictureStoreDSIListener, ResourceLocator resourceLocator, int[] nArray) {
        this.this$0 = pictureStoreDSIListener;
        this.val$rl = resourceLocator;
        this.val$contextIDs = nArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        this.this$0.getLogChannel().log(-2137614336, "PictureStoreDSIListener#getReferencesResult CommandResponse#call handler: %1 ", (Object)dSIListener);
        ((DSIPictureStoreListener)dSIListener).getReferencesResult(this.val$rl, this.val$contextIDs);
    }
}

