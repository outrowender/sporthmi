/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.picturestore.PictureStoreDSIListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.DSIPictureStoreListener;

class PictureStoreDSIListener$6
extends CommandResponse {
    private final /* synthetic */ ResourceLocator[] val$rls;
    private final /* synthetic */ PictureStoreDSIListener this$0;

    PictureStoreDSIListener$6(PictureStoreDSIListener pictureStoreDSIListener, ResourceLocator[] resourceLocatorArray) {
        this.this$0 = pictureStoreDSIListener;
        this.val$rls = resourceLocatorArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        this.this$0.getLogChannel().log(-2137614336, "PictureStoreDSIListener#deletedPictures CommandResponse#call handler: %1 ", (Object)dSIListener);
        ((DSIPictureStoreListener)dSIListener).deletedPictures(this.val$rls);
    }
}

