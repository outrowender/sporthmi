/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.esolutions.hmi.widgets.audi.evo.widgets.PlaceholderMenuMultiItem;

public interface PlaceholderMenuListManager {
    public void listModelChanged(PlaceholderMenuMultiItem var1, ModelUpdateEvent var2);

    public void subListModelChanged(PlaceholderMenuMultiItem var1, PlaceholderMenuMultiItem var2, ModelUpdateEvent var3);
}

