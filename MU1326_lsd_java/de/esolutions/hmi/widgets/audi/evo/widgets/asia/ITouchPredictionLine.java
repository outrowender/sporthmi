/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ITouchResultLine;

public interface ITouchPredictionLine
extends ITouchResultLine {
    public static final int MAX_AMOUNT_OF_PREDICTION_RESULTS = 20;

    public void updateWordPredictionContext(String var1, String var2);

    public void clear();

    public SpellerController.ISpellerItem getTruffleButton();

    public void onSuggestionChange(boolean var1);
}

