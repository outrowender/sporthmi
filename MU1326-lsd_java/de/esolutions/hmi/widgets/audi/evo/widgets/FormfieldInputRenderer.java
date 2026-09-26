/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;

public interface FormfieldInputRenderer
extends IRenderer {
    default public int getPreferredWidth() {
    }

    default public int getPreferredHeight() {
    }

    default public void setUseControllerHeight(boolean bl) {
    }

    default public void setEnableYTranslation(boolean bl) {
    }
}

