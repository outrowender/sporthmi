/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.tghu.hmi.evo.DrawerAnimationListener;
import de.audi.tghu.hmi.evo.ScreenChangeAnimationItem;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;

public interface ScreenArea
extends ScreenChangeAnimationItem,
DrawerAnimationListener {
    default public AbstractWidgetController getScreenAreaWidget() {
    }

    default public void setMainAreaState(int n, int n2, int n3) {
    }
}

