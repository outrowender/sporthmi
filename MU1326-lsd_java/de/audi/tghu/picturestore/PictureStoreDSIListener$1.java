/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.picturestore.PictureStoreDSIListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.picturestore.DSIPictureStoreListener;

class PictureStoreDSIListener$1
extends CommandResponse {
    private final /* synthetic */ int val$errorCode;
    private final /* synthetic */ String val$errorMsg;
    private final /* synthetic */ int val$requestType;
    private final /* synthetic */ PictureStoreDSIListener this$0;

    PictureStoreDSIListener$1(PictureStoreDSIListener pictureStoreDSIListener, int n, String string, int n2) {
        this.this$0 = pictureStoreDSIListener;
        this.val$errorCode = n;
        this.val$errorMsg = string;
        this.val$requestType = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        this.this$0.getLogChannel().log(-2137614336, "PictureStoreDSIListener#asyncException CommandResponse#call handler: %1 ", (Object)dSIListener);
        ((DSIPictureStoreListener)dSIListener).asyncException(this.val$errorCode, this.val$errorMsg, this.val$requestType);
    }
}

