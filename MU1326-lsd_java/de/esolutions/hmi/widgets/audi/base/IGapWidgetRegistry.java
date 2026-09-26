/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.esolutions.hmi.widgets.audi.base.IEntertainmentDrawerGapEventHandler;
import de.esolutions.hmi.widgets.audi.base.IStatusbarGapEventHandler;

public interface IGapWidgetRegistry {
    default public void setStatusbarGapEventHandler(IStatusbarGapEventHandler iStatusbarGapEventHandler) {
    }

    default public IStatusbarGapEventHandler getStatusbarGapEventHandler() {
    }

    default public void setEntertainmentDrawerGapEventHandler(IEntertainmentDrawerGapEventHandler iEntertainmentDrawerGapEventHandler) {
    }

    default public IEntertainmentDrawerGapEventHandler getEntertainmentDrawerGapEventHandler() {
    }
}

