/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import de.audi.app.media.source.ActiveSourceState;

public interface IActiveSourceListener {
    default public void activeSourceChanged(boolean bl, ActiveSourceState activeSourceState) {
    }

    default public void sourceDeactivated() {
    }
}

