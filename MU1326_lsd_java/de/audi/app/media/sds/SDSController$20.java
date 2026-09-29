/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sds;

import de.audi.app.media.sds.SDSController;
import de.audi.app.media.sds.SDSController$AbstractListenerCallback;
import de.audi.atip.interapp.media.IMediaSDSServiceListener;
import java.util.List;

class SDSController$20
extends SDSController$AbstractListenerCallback {
    private final /* synthetic */ byte val$successful;
    private final /* synthetic */ SDSController this$0;

    SDSController$20(SDSController sDSController, List list, byte by) {
        this.this$0 = sDSController;
        this.val$successful = by;
        super(sDSController, list);
    }

    @Override
    public void doCall(Object object) {
        ((IMediaSDSServiceListener)object).g2pPlayArtistResult(this.val$successful);
    }
}

