/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemMetaData;

class MenuLayout$MenuLayoutTempData {
    boolean first = true;
    boolean focusCursorVisible = false;
    boolean selectionCursorVisible = false;
    boolean infolineVisible = false;
    int[] focusCursorPosition = null;
    float moveCursorGapOffset = 0.0f;
    int multiLineY = 0;
    MenuItemMetaData multiLineStartItem = null;
    MenuItemMetaData moveLayoutItem = null;
    float yChild;
    final int viewportOffset;
    final boolean alignTop;

    public MenuLayout$MenuLayoutTempData(boolean bl, int n, float f2) {
        this.alignTop = bl;
        this.viewportOffset = n;
        this.yChild = f2;
    }
}

