/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ICharacterSpellerItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ISpellerBand;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ISpellerItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchCharSetAndTTSHandler;
import java.util.List;

public interface ITouchResultLine
extends SpellerController$ISpellerBand {
    default public void updateToggleButton(TouchCharSetAndTTSHandler touchCharSetAndTTSHandler) {
    }

    default public boolean isToggleButton(SpellerController$ISpellerItem spellerController$ISpellerItem) {
    }

    default public SpellerController$ISpellerItem getToggleButton() {
    }

    default public SpellerController$ICharacterSpellerItem getSpaceItem() {
    }

    default public void deleteOldResultItemsIfPresent() {
    }

    default public void setSpaceItemEnabled(boolean bl) {
    }

    default public void setResultItems(String string) {
    }

    default public void setResultItems(List list) {
    }

    default public boolean isResultItem(SpellerController$ISpellerItem spellerController$ISpellerItem) {
    }

    default public String getFirstResultOrEmptyString() {
    }

    default public boolean hasResultItems() {
    }

    default public List getResultItems() {
    }
}

