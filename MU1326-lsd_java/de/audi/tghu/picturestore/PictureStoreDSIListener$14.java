/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.picturestore.PictureStoreDSIListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.picturestore.DSIPictureStoreListener;

class PictureStoreDSIListener$14
extends CommandResponse {
    private final /* synthetic */ int[] val$years;
    private final /* synthetic */ PictureStoreDSIListener this$0;

    PictureStoreDSIListener$14(PictureStoreDSIListener pictureStoreDSIListener, int[] nArray) {
        this.this$0 = pictureStoreDSIListener;
        this.val$years = nArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        this.this$0.getLogChannel().log(-2137614336, "PictureStoreDSIListener#getAvailableYearsResult CommandResponse#call handler: %1 ", (Object)dSIListener);
        ((DSIPictureStoreListener)dSIListener).getAvailableYearsResult(this.val$years);
    }
}

