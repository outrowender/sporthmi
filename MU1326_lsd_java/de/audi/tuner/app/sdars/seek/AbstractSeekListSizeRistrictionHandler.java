/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.tuner.app.sdars.dsi.SDARSDSISeekDownManager;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import org.dsi.ifc.sdars.SeekEntry;

public abstract class AbstractSeekListSizeRistrictionHandler {
    public static final int FULL = 1;
    public static final int NOT_FULL = 0;
    public final DsiUpListener dsiUpListener = new DsiUpListener();
    protected final SDARSDSISeekDownManager dsi;

    public AbstractSeekListSizeRistrictionHandler(SDARSDSISeekDownManager sDARSDSISeekDownManager) {
        this.dsi = sDARSDSISeekDownManager;
    }

    protected abstract void onDSIUpdateSeekList(SeekEntry[] var1);

    public abstract boolean isSeekListFull(int var1);

    public abstract int getRemainingSpace(int var1);

    private class DsiUpListener
    extends SDARSDsiUpInfo {
        private DsiUpListener() {
        }

        public void updateSeekList(SeekEntry[] seekEntryArray) {
            AbstractSeekListSizeRistrictionHandler.this.onDSIUpdateSeekList(seekEntryArray);
        }
    }
}

