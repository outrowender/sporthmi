/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state;

import de.audi.app.media.source.state.SourceStateUpdate;
import java.util.Map;

public interface ISourceStateUpdater {
    default public void updateSourceState(SourceStateUpdate sourceStateUpdate) {
    }

    default public void updateNumberOfSlots(Map map) {
    }

    default public void updateSourceSlots(Map map) {
    }

    default public void updateSourceAvailability(int n, Map map) {
    }
}

