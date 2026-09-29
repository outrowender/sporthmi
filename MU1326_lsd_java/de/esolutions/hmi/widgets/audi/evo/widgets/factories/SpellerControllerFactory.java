/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.factories;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerControllerAsia;

public final class SpellerControllerFactory {
    private SpellerControllerFactory() {
    }

    public static SpellerController create() {
        if (AbstractWidget.isAsia()) {
            return new SpellerControllerAsia();
        }
        return new SpellerController();
    }
}

