/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.picturestore.PictureStoreDSIListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.DSIPictureStoreListener;

class PictureStoreDSIListener$9
extends CommandResponse {
    private final /* synthetic */ int val$contextID;
    private final /* synthetic */ ResourceLocator[] val$rls;
    private final /* synthetic */ int val$index;
    private final /* synthetic */ PictureStoreDSIListener this$0;

    PictureStoreDSIListener$9(PictureStoreDSIListener pictureStoreDSIListener, int n, ResourceLocator[] resourceLocatorArray, int n2) {
        this.this$0 = pictureStoreDSIListener;
        this.val$contextID = n;
        this.val$rls = resourceLocatorArray;
        this.val$index = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        this.this$0.getLogChannel().log(-2137614336, "PictureStoreDSIListener#listForContextResult CommandResponse#call handler: %1 ", (Object)dSIListener);
        ((DSIPictureStoreListener)dSIListener).listForContextResult(this.val$contextID, this.val$rls, this.val$index);
    }
}

