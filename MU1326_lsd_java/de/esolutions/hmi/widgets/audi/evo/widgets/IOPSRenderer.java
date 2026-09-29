/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;

public interface IOPSRenderer
extends IRenderer {
    default public void setVisible(boolean bl) {
    }

    default public void finalizeAsyncMerge(String string) {
    }
}

