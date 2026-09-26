/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.esolutions.hmi.widgets.audi.evo.widgets.PlaceholderMenuMultiItem;

public interface PlaceholderMenuListManager {
    default public void listModelChanged(PlaceholderMenuMultiItem placeholderMenuMultiItem, ModelUpdateEvent modelUpdateEvent) {
    }

    default public void subListModelChanged(PlaceholderMenuMultiItem placeholderMenuMultiItem, PlaceholderMenuMultiItem placeholderMenuMultiItem2, ModelUpdateEvent modelUpdateEvent) {
    }
}

