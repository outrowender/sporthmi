/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.truffles.frequency;

import de.audi.app.tuner.truffles.RadioSearchListRow;
import de.audi.app.tuner.truffles.frequency.AmFmFrequencySearch;
import de.audi.app.tuner.truffles.frequency.IFrequencySearch;
import de.audi.atip.log.LogChannel;

class FmFrequencySearch
extends AmFmFrequencySearch
implements IFrequencySearch {
    FmFrequencySearch(LogChannel logChannel) {
        super(logChannel);
    }

    public RadioSearchListRow getRowForFrequency(String string) {
        String string2;
        RadioSearchListRow radioSearchListRow = null;
        if (string.length() > 2 && (",".equals(string2 = string.substring(string.length() - 2, string.length() - 1)) || ".".equals(string2))) {
            radioSearchListRow = this.getRowForFrequency(string, 1);
        }
        return radioSearchListRow;
    }
}

