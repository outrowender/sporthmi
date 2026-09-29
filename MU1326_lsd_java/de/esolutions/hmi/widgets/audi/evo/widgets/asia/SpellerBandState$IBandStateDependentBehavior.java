/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ISpellerItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerControllerAsia;

interface SpellerBandState$IBandStateDependentBehavior {
    default public void handlePressItem(SpellerController$ISpellerItem spellerController$ISpellerItem, SpellerControllerAsia spellerControllerAsia) {
    }

    default public void touchPadFilteredCharactersRecognized(String string, SpellerControllerAsia spellerControllerAsia) {
    }

    default public void closed(SpellerControllerAsia spellerControllerAsia) {
    }

    default public boolean hasPendingTouchResult() {
    }

    default public String getPendingTouchResult(SpellerControllerAsia spellerControllerAsia) {
    }
}

