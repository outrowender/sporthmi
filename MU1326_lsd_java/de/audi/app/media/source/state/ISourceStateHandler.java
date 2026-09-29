/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state;

import de.audi.app.media.source.IMultipleSourceSlotListener;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceSlotListener;
import de.audi.app.media.source.state.ISourceStateUpdater;

public interface ISourceStateHandler {
    default public void registerSource(ISource iSource) {
    }

    default public void addSourceSlotListener(IMultipleSourceSlotListener iMultipleSourceSlotListener) {
    }

    default public void addSourceSlotListener(ISource iSource, ISourceSlotListener iSourceSlotListener, boolean bl) {
    }

    default public void removeSlotListener(ISource iSource, ISourceSlotListener iSourceSlotListener) {
    }

    default public ISourceStateUpdater getSourceStateUpdater() {
    }
}

