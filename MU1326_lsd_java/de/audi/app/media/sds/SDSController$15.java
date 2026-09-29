/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sds;

import de.audi.app.media.sds.SDSController;
import de.audi.app.media.sds.SDSController$AbstractListenerCallback;
import de.audi.atip.interapp.media.IMediaSDSServiceListener;
import java.util.List;

class SDSController$15
extends SDSController$AbstractListenerCallback {
    private final /* synthetic */ int val$pState;
    private final /* synthetic */ SDSController this$0;

    SDSController$15(SDSController sDSController, List list, int n) {
        this.this$0 = sDSController;
        this.val$pState = n;
        super(sDSController, list);
    }

    @Override
    public void doCall(Object object) {
        ((IMediaSDSServiceListener)object).processedRepeatTrack(this.val$pState);
    }
}

