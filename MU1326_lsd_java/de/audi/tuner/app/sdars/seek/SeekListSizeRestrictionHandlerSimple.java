/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.sdars.dsi.SDARSDSISeekDownManager;
import de.audi.tuner.app.sdars.seek.AbstractSeekListSizeRistrictionHandler;
import org.dsi.ifc.sdars.SeekEntry;

public class SeekListSizeRestrictionHandlerSimple
extends AbstractSeekListSizeRistrictionHandler {
    private static final int DEFAULT_MAX_ALLOWED_SEEK_LIST_SIZE;
    private final int maxAllowedSeekListSize;
    private final ChoiceModelApp seekListFullChoice;
    private int lastSeekListSize = 0;

    public SeekListSizeRestrictionHandlerSimple(TunerBasics tunerBasics, SDARSDSISeekDownManager sDARSDSISeekDownManager) {
        this(tunerBasics, sDARSDSISeekDownManager, 50);
    }

    public SeekListSizeRestrictionHandlerSimple(TunerBasics tunerBasics, SDARSDSISeekDownManager sDARSDSISeekDownManager, int n) {
        super(sDARSDSISeekDownManager);
        this.maxAllowedSeekListSize = n;
        this.seekListFullChoice = tunerBasics.getModels().getChoiceModel(1871249664);
    }

    @Override
    protected void onDSIUpdateSeekList(SeekEntry[] seekEntryArray) {
        boolean bl = this.seekListFullChoice != null && this.seekListFullChoice.getValue() == 1;
        boolean bl2 = seekEntryArray.length >= this.maxAllowedSeekListSize;
        this.lastSeekListSize = seekEntryArray.length;
        if (this.seekListFullChoice != null) {
            this.seekListFullChoice.setValue(bl2 ? 1 : 0);
        }
        if (bl != bl2) {
            this.dsi.setSeekPossibliltyNotification();
        }
    }

    @Override
    public boolean isSeekListFull(int n) {
        return this.getRemainingSpace(n) == 0;
    }

    @Override
    public int getRemainingSpace(int n) {
        return this.maxAllowedSeekListSize - this.lastSeekListSize;
    }
}

