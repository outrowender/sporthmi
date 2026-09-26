/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ISpellerItem;
import java.util.List;

public interface SpellerController$ISpellerBand {
    default public List getSpellerItems() {
    }

    default public SpellerController$ISpellerItem getCurrentFocusedItem() {
    }

    default public void setCurrentFocusedItem(SpellerController$ISpellerItem spellerController$ISpellerItem) {
    }

    default public SpellerController$ISpellerItem getCloseButton() {
    }

    default public SpellerController$ISpellerItem getOkItem() {
    }

    default public SpellerController$ISpellerItem getDeleteButton() {
    }

    default public SpellerController$ISpellerItem getLeftButton() {
    }

    default public SpellerController$ISpellerItem getRightButton() {
    }

    default public SpellerController$ISpellerItem getDeleteButtonNeighbor() {
    }

    default public boolean isUpperCase() {
    }

    default public void setIsUpperCase(boolean bl) {
    }

    default public void itemPressed(SpellerController$ISpellerItem spellerController$ISpellerItem) {
    }

    default public void resetInitialItem(boolean bl) {
    }

    default public boolean hasMovingDeleteButton() {
    }

    default public void autoCompletionAccepted() {
    }

    default public void free(boolean bl) {
    }
}

