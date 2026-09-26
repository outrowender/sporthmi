/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.truffles.frequency;

import de.audi.app.tuner.truffles.RadioSearchListRow;

public interface IFrequencySearch {
    default public RadioSearchListRow getRowForFrequency(String string) {
    }

    default public void updateBandInformation(Object[] objectArray) {
    }
}

