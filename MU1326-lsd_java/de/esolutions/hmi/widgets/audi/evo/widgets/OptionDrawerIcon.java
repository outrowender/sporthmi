/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerIcon;

public interface OptionDrawerIcon
extends DrawerIcon {
    default public AbstractWidget getParent() {
    }

    @Override
    default public void setX(int n) {
    }

    @Override
    default public void setY(int n) {
    }

    default public void setLayout(int n, int n2) {
    }

    default public void setCompositesDirty(boolean bl) {
    }
}

