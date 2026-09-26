/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.compose.INewMessagePropertyFactory;
import de.audi.atip.hmi.model.PropertyListCell;

public class INewMessagePropertyFactory$NullFactory
implements INewMessagePropertyFactory {
    @Override
    public PropertyListCell create(boolean bl) {
        return PropertyListCell.EMPTY_CELL;
    }
}

