/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu.list;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListController;

public interface ListManager {
    public void listModelChanged(ListController var1, ModelUpdateEvent var2);
}

