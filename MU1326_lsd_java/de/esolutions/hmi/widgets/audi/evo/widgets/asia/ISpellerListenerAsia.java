/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.evo.widgets.ISpellerListener;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerBandState;

public interface ISpellerListenerAsia
extends ISpellerListener {
    public void spellerBandStateChanged(SpellerBandState var1, SpellerBandState var2);

    public void touchWordPredictionContextUpdateNeeded(String var1);
}

