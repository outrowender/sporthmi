/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.InfolineController;

public interface IInfoLineRenderer
extends IRenderer {
    default public int getPreferredHeight(int n) {
    }

    default public void setController(InfolineController infolineController) {
    }

    default public void setFonts(Object[] objectArray) {
    }

    default public int getAutoWrap() {
    }

    default public void setAutoWrap(int n) {
    }
}

