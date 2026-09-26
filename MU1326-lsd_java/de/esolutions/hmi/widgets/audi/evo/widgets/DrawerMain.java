/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.tghu.hmi.evo.ScreenAreaFocus;
import de.esolutions.hmi.widgets.audi.base.DrawerItem;
import de.esolutions.hmi.widgets.audi.base.Rectangular;

public interface DrawerMain
extends DrawerItem,
ScreenAreaFocus,
Rectangular {
    default public boolean canOpen() {
    }

    default public void initializeScreenChangeAnimation() {
    }

    default public boolean canClose() {
    }
}

