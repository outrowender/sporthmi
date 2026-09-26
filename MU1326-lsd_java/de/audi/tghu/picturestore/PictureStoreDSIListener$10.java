/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.picturestore.PictureStoreDSIListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.DSIPictureStoreListener;
import org.dsi.ifc.picturestore.PictureAttribute;

class PictureStoreDSIListener$10
extends CommandResponse {
    private final /* synthetic */ ResourceLocator val$rl;
    private final /* synthetic */ PictureAttribute[] val$attributes;
    private final /* synthetic */ int val$resultCode;
    private final /* synthetic */ PictureStoreDSIListener this$0;

    PictureStoreDSIListener$10(PictureStoreDSIListener pictureStoreDSIListener, ResourceLocator resourceLocator, PictureAttribute[] pictureAttributeArray, int n) {
        this.this$0 = pictureStoreDSIListener;
        this.val$rl = resourceLocator;
        this.val$attributes = pictureAttributeArray;
        this.val$resultCode = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        this.this$0.getLogChannel().log(-2137614336, "PictureStoreDSIListener#listForContextResult CommandResponse#call handler: %1 ", (Object)dSIListener);
        ((DSIPictureStoreListener)dSIListener).getPictureAttributesResult(this.val$rl, this.val$attributes, this.val$resultCode);
    }
}

