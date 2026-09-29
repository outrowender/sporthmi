/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.picturestore.PictureStoreDSIListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.DSIPictureStoreListener;

class PictureStoreDSIListener$3
extends CommandResponse {
    private final /* synthetic */ ResourceLocator val$rl;
    private final /* synthetic */ boolean val$doesExist;
    private final /* synthetic */ PictureStoreDSIListener this$0;

    PictureStoreDSIListener$3(PictureStoreDSIListener pictureStoreDSIListener, ResourceLocator resourceLocator, boolean bl) {
        this.this$0 = pictureStoreDSIListener;
        this.val$rl = resourceLocator;
        this.val$doesExist = bl;
    }

    @Override
    public void call(DSIListener dSIListener) {
        this.this$0.getLogChannel().log(-2137614336, "PictureStoreDSIListener#pictureExists CommandResponse#call handler: %1 ", (Object)dSIListener);
        ((DSIPictureStoreListener)dSIListener).pictureExists(this.val$rl, this.val$doesExist);
    }
}

