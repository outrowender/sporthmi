/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.menu;

import de.audi.atip.hmi.model.menu.MenuModelListener;

public class FallbackMenuModelListener
implements MenuModelListener {
    public static final MenuModelListener INSTANCE = new FallbackMenuModelListener();

    private FallbackMenuModelListener() {
    }

    public void itemFocused(int n, int n2, long l, int n3) {
    }
}

