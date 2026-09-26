/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.truffles.frequency;

import de.audi.app.tuner.truffles.RadioSearchListRow;
import de.audi.app.tuner.truffles.frequency.AmFmFrequencySearch;
import de.audi.app.tuner.truffles.frequency.IFrequencySearch;
import de.audi.atip.log.LogChannel;

class AmFrequencySearch
extends AmFmFrequencySearch
implements IFrequencySearch {
    AmFrequencySearch(LogChannel logChannel) {
        super(logChannel);
    }

    @Override
    public RadioSearchListRow getRowForFrequency(String string) {
        return this.getRowForFrequency(string, 4);
    }
}

