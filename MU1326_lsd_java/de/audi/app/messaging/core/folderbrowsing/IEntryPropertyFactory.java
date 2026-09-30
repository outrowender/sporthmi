/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.atip.hmi.model.PropertyListCell;
import org.dsi.ifc.messaging.ListEntry;

public interface IEntryPropertyFactory {
    public PropertyListCell create(ListEntry var1);

    public static final class NullFactory
    implements IEntryPropertyFactory {
        public PropertyListCell create(ListEntry listEntry) {
            return PropertyListCell.EMPTY_CELL;
        }
    }
}

