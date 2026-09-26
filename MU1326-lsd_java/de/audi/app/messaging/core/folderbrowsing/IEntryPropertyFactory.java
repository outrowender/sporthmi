/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.atip.hmi.model.PropertyListCell;
import org.dsi.ifc.messaging.ListEntry;

public interface IEntryPropertyFactory {
    default public PropertyListCell create(ListEntry listEntry) {
    }
}

