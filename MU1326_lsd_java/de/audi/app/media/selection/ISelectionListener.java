/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.selection;

import de.audi.app.media.selection.IDataSelectionContext;

public interface ISelectionListener {
    default public void notifySelectionChanged(IDataSelectionContext iDataSelectionContext, boolean bl) {
    }
}

