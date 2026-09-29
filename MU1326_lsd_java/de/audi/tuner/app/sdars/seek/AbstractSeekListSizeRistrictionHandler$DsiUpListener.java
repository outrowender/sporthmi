/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.audi.tuner.app.sdars.seek.AbstractSeekListSizeRistrictionHandler;
import de.audi.tuner.app.sdars.seek.AbstractSeekListSizeRistrictionHandler$1;
import org.dsi.ifc.sdars.SeekEntry;

class AbstractSeekListSizeRistrictionHandler$DsiUpListener
extends SDARSDsiUpInfo {
    private final /* synthetic */ AbstractSeekListSizeRistrictionHandler this$0;

    private AbstractSeekListSizeRistrictionHandler$DsiUpListener(AbstractSeekListSizeRistrictionHandler abstractSeekListSizeRistrictionHandler) {
        this.this$0 = abstractSeekListSizeRistrictionHandler;
    }

    @Override
    public void updateSeekList(SeekEntry[] seekEntryArray) {
        this.this$0.onDSIUpdateSeekList(seekEntryArray);
    }

    /* synthetic */ AbstractSeekListSizeRistrictionHandler$DsiUpListener(AbstractSeekListSizeRistrictionHandler abstractSeekListSizeRistrictionHandler, AbstractSeekListSizeRistrictionHandler$1 abstractSeekListSizeRistrictionHandler$1) {
        this(abstractSeekListSizeRistrictionHandler);
    }
}

