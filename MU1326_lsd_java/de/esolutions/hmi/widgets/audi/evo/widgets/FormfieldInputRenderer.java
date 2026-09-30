/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;

public interface FormfieldInputRenderer
extends IRenderer {
    public int getPreferredWidth();

    public int getPreferredHeight();

    public void setUseControllerHeight(boolean var1);

    public void setEnableYTranslation(boolean var1);
}

