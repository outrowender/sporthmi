/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.picturestore.PictureStoreDSIListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.picturestore.DSIPictureStoreListener;

class PictureStoreDSIListener$19
extends CommandResponse {
    private final /* synthetic */ int val$contextId;
    private final /* synthetic */ String[] val$folderNames;
    private final /* synthetic */ PictureStoreDSIListener this$0;

    PictureStoreDSIListener$19(PictureStoreDSIListener pictureStoreDSIListener, int n, String[] stringArray) {
        this.this$0 = pictureStoreDSIListener;
        this.val$contextId = n;
        this.val$folderNames = stringArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        this.this$0.getLogChannel().log(-2137614336, "PictureStoreDSIListener#getAvailableFoldersResult CommandResponse#call handler: %1 ", (Object)dSIListener);
        ((DSIPictureStoreListener)dSIListener).getAvailableFoldersResult(this.val$contextId, this.val$folderNames);
    }
}

