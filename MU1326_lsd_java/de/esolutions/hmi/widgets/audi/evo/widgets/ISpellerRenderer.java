/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$AbstractExpandableItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ISpellerItem;

public interface ISpellerRenderer
extends IRenderer {
    default public void startCursorAnimation(SpellerController$ISpellerItem spellerController$ISpellerItem, SpellerController$ISpellerItem spellerController$ISpellerItem2) {
    }

    default public void closeItem(SpellerController$AbstractExpandableItem spellerController$AbstractExpandableItem) {
    }

    default public void openItem() {
    }

    default public void switchCase() {
    }

    default public void deleteMoved() {
    }

    default public void refreshItemColors() {
    }

    default public void switchCharSet() {
    }
}

