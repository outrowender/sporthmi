/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.tuner.app.sdars.dsi.SDARSDSISeekDownManager;
import de.audi.tuner.app.sdars.seek.AbstractSeekListSizeRistrictionHandler$DsiUpListener;
import org.dsi.ifc.sdars.SeekEntry;

public abstract class AbstractSeekListSizeRistrictionHandler {
    public static final int FULL;
    public static final int NOT_FULL;
    public final AbstractSeekListSizeRistrictionHandler$DsiUpListener dsiUpListener = new AbstractSeekListSizeRistrictionHandler$DsiUpListener(this, null);
    protected final SDARSDSISeekDownManager dsi;

    public AbstractSeekListSizeRistrictionHandler(SDARSDSISeekDownManager sDARSDSISeekDownManager) {
        this.dsi = sDARSDSISeekDownManager;
    }

    protected abstract void onDSIUpdateSeekList(SeekEntry[] seekEntryArray) {
    }

    public abstract boolean isSeekListFull(int n) {
    }

    public abstract int getRemainingSpace(int n) {
    }
}

