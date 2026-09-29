/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ISpellerItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ITouchResultLine;

public interface ITouchPredictionLine
extends ITouchResultLine {
    public static final int MAX_AMOUNT_OF_PREDICTION_RESULTS;

    default public void updateWordPredictionContext(String string, String string2) {
    }

    default public void clear() {
    }

    default public SpellerController$ISpellerItem getTruffleButton() {
    }

    default public void onSuggestionChange(boolean bl) {
    }
}

