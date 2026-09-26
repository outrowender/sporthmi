/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets.factories;

import de.esolutions.hmi.widgets.audi.evo.high.widgets.SpellerRendererEuropeHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.asia.SpellerRendererAsiaHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerControllerAsia;

public final class SpellerRendererHighFactory {
    private SpellerRendererHighFactory() {
    }

    public static SpellerRendererEuropeHigh create(SpellerController spellerController) {
        if (spellerController instanceof SpellerControllerAsia) {
            return new SpellerRendererAsiaHigh((SpellerControllerAsia)spellerController);
        }
        return new SpellerRendererEuropeHigh(spellerController);
    }
}

