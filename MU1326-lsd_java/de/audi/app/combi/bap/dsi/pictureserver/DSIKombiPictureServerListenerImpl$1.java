/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.pictureserver;

import de.audi.app.combi.bap.dsi.pictureserver.DSIKombiPictureServerListenerImpl;
import edu.emory.mathcs.backport.java.util.concurrent.Callable;

class DSIKombiPictureServerListenerImpl$1
implements Callable {
    private final /* synthetic */ int val$callID;
    private final /* synthetic */ DSIKombiPictureServerListenerImpl this$0;

    DSIKombiPictureServerListenerImpl$1(DSIKombiPictureServerListenerImpl dSIKombiPictureServerListenerImpl, int n) {
        this.this$0 = dSIKombiPictureServerListenerImpl;
        this.val$callID = n;
    }

    @Override
    public Object call() {
        DSIKombiPictureServerListenerImpl.access$000(this.this$0).log(-2137614336, "[DSIKombiPictureServerListenerImpl#indicationActiveCallPicture] calling requestActiveCallPicture callID: %1", (long)this.val$callID);
        DSIKombiPictureServerListenerImpl.access$100(this.this$0).requestActiveCallPicture(this.val$callID);
        return null;
    }
}

