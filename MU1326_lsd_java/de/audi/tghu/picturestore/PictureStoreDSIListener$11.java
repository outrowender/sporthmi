/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.picturestore.PictureStoreDSIListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.DSIPictureStoreListener;

class PictureStoreDSIListener$11
extends CommandResponse {
    private final /* synthetic */ int val$contextID;
    private final /* synthetic */ ResourceLocator val$volatileRL;
    private final /* synthetic */ ResourceLocator val$persistentRL;
    private final /* synthetic */ int val$resultCode;
    private final /* synthetic */ PictureStoreDSIListener this$0;

    PictureStoreDSIListener$11(PictureStoreDSIListener pictureStoreDSIListener, int n, ResourceLocator resourceLocator, ResourceLocator resourceLocator2, int n2) {
        this.this$0 = pictureStoreDSIListener;
        this.val$contextID = n;
        this.val$volatileRL = resourceLocator;
        this.val$persistentRL = resourceLocator2;
        this.val$resultCode = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        this.this$0.getLogChannel().log(-2137614336, "PictureStoreDSIListener#importPictureFromSourceResult CommandResponse#call handler: %1 ", (Object)dSIListener);
        ((DSIPictureStoreListener)dSIListener).importPictureFromSourceResult(this.val$contextID, this.val$volatileRL, this.val$persistentRL, this.val$resultCode);
    }
}

