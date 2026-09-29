/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.picturestore.PictureStoreDSIListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.DSIPictureStoreListener;

class PictureStoreDSIListener$8
extends CommandResponse {
    private final /* synthetic */ ResourceLocator[] val$rls;
    private final /* synthetic */ int val$index;
    private final /* synthetic */ PictureStoreDSIListener this$0;

    PictureStoreDSIListener$8(PictureStoreDSIListener pictureStoreDSIListener, ResourceLocator[] resourceLocatorArray, int n) {
        this.this$0 = pictureStoreDSIListener;
        this.val$rls = resourceLocatorArray;
        this.val$index = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        this.this$0.getLogChannel().log(-2137614336, "PictureStoreDSIListener#listForContextResult CommandResponse#call handler: %1 ", (Object)dSIListener);
        ((DSIPictureStoreListener)dSIListener).listResult(this.val$rls, this.val$index);
    }
}

