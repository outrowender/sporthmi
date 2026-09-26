/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sds;

import de.audi.app.media.sds.SDSController;
import de.audi.app.media.sds.SDSController$AbstractListenerCallback;
import de.audi.atip.interapp.media.IMediaSDSServiceListener;
import java.util.List;

class SDSController$18
extends SDSController$AbstractListenerCallback {
    private final /* synthetic */ byte val$pSuccessful;
    private final /* synthetic */ SDSController this$0;

    SDSController$18(SDSController sDSController, List list, byte by) {
        this.this$0 = sDSController;
        this.val$pSuccessful = by;
        super(sDSController, list);
    }

    @Override
    public void doCall(Object object) {
        ((IMediaSDSServiceListener)object).g2pPlayAlbumOfArtistResult(this.val$pSuccessful);
    }
}

