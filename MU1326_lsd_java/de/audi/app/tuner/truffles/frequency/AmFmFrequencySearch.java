/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.truffles.frequency;

import de.audi.app.tuner.truffles.RadioSearchListRow;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.radio.WavebandInfo;

class AmFmFrequencySearch {
    private long lowerLimit = -1L;
    private long upperLimit = -1L;
    private long stepWidth = -1L;
    private final LogChannel log;

    AmFmFrequencySearch(LogChannel logChannel) {
        this.log = logChannel;
    }

    RadioSearchListRow getRowForFrequency(String string, int n) {
        String string2 = string.replace(',', '.').trim();
        RadioSearchListRow radioSearchListRow = null;
        long l = 0L;
        try {
            l = n == 1 ? (long)(Double.parseDouble(string2) * 1000.0) : (long)Double.parseDouble(string2);
        }
        catch (NumberFormatException numberFormatException) {
            this.log.log(10000000, "[AmFmFrequencySearch.getRowForFrequency] unable to parse frequency string to double.");
            return null;
        }
        if (this.frequencyIsCorrect(l)) {
            radioSearchListRow = new RadioSearchListRow(string2, n, l);
        }
        this.log.log(10000000, "[AmFmFrequencySearch.getRowForFrequency] result for band %2 is row: %1", (Object)radioSearchListRow, (long)n);
        return radioSearchListRow;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean frequencyIsCorrect(long l) {
        AmFmFrequencySearch amFmFrequencySearch = this;
        synchronized (amFmFrequencySearch) {
            boolean bl = this.lowerLimit > -1L && this.upperLimit > -1L && this.stepWidth > -1L;
            boolean bl2 = this.lowerLimit <= l && l <= this.upperLimit;
            boolean bl3 = (l - this.lowerLimit) % this.stepWidth == 0L;
            return bl && bl2 && bl3;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateBandInformation(Object[] objectArray) {
        WavebandInfo wavebandInfo = (WavebandInfo)objectArray[0];
        AmFmFrequencySearch amFmFrequencySearch = this;
        synchronized (amFmFrequencySearch) {
            this.lowerLimit = wavebandInfo.lowerLimit;
            this.upperLimit = wavebandInfo.upperLimit;
            this.stepWidth = wavebandInfo.stepWidth;
        }
    }
}

