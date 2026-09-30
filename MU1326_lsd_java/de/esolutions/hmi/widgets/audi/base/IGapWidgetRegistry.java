/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.esolutions.hmi.widgets.audi.base.IEntertainmentDrawerGapEventHandler;
import de.esolutions.hmi.widgets.audi.base.IStatusbarGapEventHandler;

public interface IGapWidgetRegistry {
    public void setStatusbarGapEventHandler(IStatusbarGapEventHandler var1);

    public IStatusbarGapEventHandler getStatusbarGapEventHandler();

    public void setEntertainmentDrawerGapEventHandler(IEntertainmentDrawerGapEventHandler var1);

    public IEntertainmentDrawerGapEventHandler getEntertainmentDrawerGapEventHandler();
}

