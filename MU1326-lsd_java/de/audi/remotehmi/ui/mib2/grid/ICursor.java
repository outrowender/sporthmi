/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2.grid;

import de.audi.remotehmi.ui.mib2.grid.ICursorComponent;

public interface ICursor {
    default public ICursorComponent getFocus() {
    }

    default public ICursorComponent getSelection() {
    }

    default public boolean isForceUpdate() {
    }

    default public ICursor withSelection(ICursorComponent iCursorComponent) {
    }

    default public ICursor withSelection(int n, int n2, String string, String string2) {
    }

    default public ICursor withFocus(ICursorComponent iCursorComponent) {
    }

    default public ICursor withFocus(int n, int n2, String string, String string2) {
    }
}

