/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.evo.widgets.ISpellerListener;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerBandState;

public interface ISpellerListenerAsia
extends ISpellerListener {
    default public void spellerBandStateChanged(SpellerBandState spellerBandState, SpellerBandState spellerBandState2) {
    }

    default public void touchWordPredictionContextUpdateNeeded(String string) {
    }
}

