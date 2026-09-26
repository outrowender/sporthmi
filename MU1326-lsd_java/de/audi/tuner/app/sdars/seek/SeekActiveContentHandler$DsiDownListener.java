/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.SDARSDsiDownInfo;
import de.audi.tuner.app.sdars.seek.SeekActiveContentHandler;
import de.audi.tuner.app.sdars.seek.SeekActiveContentHandler$1;

class SeekActiveContentHandler$DsiDownListener
extends SDARSDsiDownInfo {
    private final /* synthetic */ SeekActiveContentHandler this$0;

    private SeekActiveContentHandler$DsiDownListener(SeekActiveContentHandler seekActiveContentHandler) {
        this.this$0 = seekActiveContentHandler;
    }

    @Override
    public void preTuneAction(StationInfoExt stationInfoExt) {
        SeekActiveContentHandler.access$1900(this.this$0, -1);
    }

    /* synthetic */ SeekActiveContentHandler$DsiDownListener(SeekActiveContentHandler seekActiveContentHandler, SeekActiveContentHandler$1 seekActiveContentHandler$1) {
        this(seekActiveContentHandler);
    }
}

