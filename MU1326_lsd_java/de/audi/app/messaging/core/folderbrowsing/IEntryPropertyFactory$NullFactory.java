/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.folderbrowsing.IEntryPropertyFactory;
import de.audi.atip.hmi.model.PropertyListCell;
import org.dsi.ifc.messaging.ListEntry;

public final class IEntryPropertyFactory$NullFactory
implements IEntryPropertyFactory {
    @Override
    public PropertyListCell create(ListEntry listEntry) {
        return PropertyListCell.EMPTY_CELL;
    }
}

