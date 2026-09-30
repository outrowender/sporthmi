/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.truffles.frequency;

import de.audi.app.tuner.truffles.RadioSearchListRow;

public interface IFrequencySearch {
    public RadioSearchListRow getRowForFrequency(String var1);

    public void updateBandInformation(Object[] var1);
}

