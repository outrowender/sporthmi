/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController;

public interface ISpellerRenderer
extends IRenderer {
    public void startCursorAnimation(SpellerController.ISpellerItem var1, SpellerController.ISpellerItem var2);

    public void closeItem(SpellerController.AbstractExpandableItem var1);

    public void openItem();

    public void switchCase();

    public void deleteMoved();

    public void refreshItemColors();

    public void switchCharSet();
}

