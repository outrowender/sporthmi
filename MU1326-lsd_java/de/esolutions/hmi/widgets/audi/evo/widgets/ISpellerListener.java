/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerButtonArgument;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ISpellerItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SpellerButtonType;

public interface ISpellerListener {
    public static final int FOCUS_LOST;
    public static final int FOCUS_GET;

    default public void focusChanged(SpellerController$ISpellerItem spellerController$ISpellerItem, int n) {
    }

    default public void buttonPressed(SpellerController.SpellerButtonType spellerButtonType, SpellerButtonArgument spellerButtonArgument) {
    }

    default public void buttonLongPressed(SpellerController.SpellerButtonType spellerButtonType) {
    }

    default public void buttonReleased(SpellerController.SpellerButtonType spellerButtonType) {
    }

    default public void characterPressed(String string, boolean bl, boolean bl2) {
    }

    default public void focusedCharacterChanged(String string) {
    }
}

