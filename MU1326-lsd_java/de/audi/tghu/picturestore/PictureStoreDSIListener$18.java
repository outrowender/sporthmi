/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.picturestore.PictureStoreDSIListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.picturestore.DSIPictureStoreListener;

class PictureStoreDSIListener$18
extends CommandResponse {
    private final /* synthetic */ int val$success;
    private final /* synthetic */ PictureStoreDSIListener this$0;

    PictureStoreDSIListener$18(PictureStoreDSIListener pictureStoreDSIListener, int n) {
        this.this$0 = pictureStoreDSIListener;
        this.val$success = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        this.this$0.getLogChannel().log(-2137614336, "PictureStoreDSIListener#resetToFactorySettingsResult CommandResponse#call handler: %1 ", (Object)dSIListener);
        ((DSIPictureStoreListener)dSIListener).resetToFactorySettingsResult(this.val$success);
    }
}

