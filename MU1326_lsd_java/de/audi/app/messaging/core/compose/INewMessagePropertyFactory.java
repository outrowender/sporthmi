/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.atip.hmi.model.PropertyListCell;

public interface INewMessagePropertyFactory {
    public PropertyListCell create(boolean var1);

    public static class NullFactory
    implements INewMessagePropertyFactory {
        public PropertyListCell create(boolean bl) {
            return PropertyListCell.EMPTY_CELL;
        }
    }
}

