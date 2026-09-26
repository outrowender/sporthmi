/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemMulti;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemSingle;

public interface IMenuItemMultiLine
extends IMenuItemSingle,
IMenuItemMulti {
    default public int getPreferredLineHeight(int n) {
    }

    default public int getFilledInsets(boolean bl) {
    }

    default public void setVisibleAreaBounds(int n, int n2, int n3) {
    }

    default public boolean isScrollLineByLine() {
    }

    default public int getSdsItemSelectedAction(int n) {
    }
}

