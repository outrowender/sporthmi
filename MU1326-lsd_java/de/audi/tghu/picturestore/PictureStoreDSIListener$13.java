/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.picturestore.PictureStoreDSIListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.picturestore.DSIPictureStoreListener;
import org.dsi.ifc.picturestore.GeoPicture;

class PictureStoreDSIListener$13
extends CommandResponse {
    private final /* synthetic */ GeoPicture[] val$geopictures;
    private final /* synthetic */ PictureStoreDSIListener this$0;

    PictureStoreDSIListener$13(PictureStoreDSIListener pictureStoreDSIListener, GeoPicture[] geoPictureArray) {
        this.this$0 = pictureStoreDSIListener;
        this.val$geopictures = geoPictureArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        this.this$0.getLogChannel().log(-2137614336, "PictureStoreDSIListener#getRectanglePicturesGridResult CommandResponse#call handler: %1 ", (Object)dSIListener);
        ((DSIPictureStoreListener)dSIListener).getRectanglePicturesGridResult(this.val$geopictures);
    }
}

