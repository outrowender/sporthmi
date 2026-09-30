/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state;

import de.audi.app.media.source.state.SourceStateUpdate;
import java.util.Map;

public interface ISourceStateUpdater {
    public void updateSourceState(SourceStateUpdate var1);

    public void updateNumberOfSlots(Map var1);

    public void updateSourceSlots(Map var1);

    public void updateSourceAvailability(int var1, Map var2);
}

