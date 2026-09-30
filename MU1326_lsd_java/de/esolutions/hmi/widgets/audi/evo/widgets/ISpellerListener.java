/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerButtonArgument;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController;

public interface ISpellerListener {
    public static final int FOCUS_LOST = 0;
    public static final int FOCUS_GET = 1;

    public void focusChanged(SpellerController.ISpellerItem var1, int var2);

    public void buttonPressed(SpellerController.SpellerButtonType var1, SpellerButtonArgument var2);

    public void buttonLongPressed(SpellerController.SpellerButtonType var1);

    public void buttonReleased(SpellerController.SpellerButtonType var1);

    public void characterPressed(String var1, boolean var2, boolean var3);

    public void focusedCharacterChanged(String var1);
}

