/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerIcon;

public interface OptionDrawerIcon
extends DrawerIcon {
    public AbstractWidget getParent();

    public void setX(int var1);

    public void setY(int var1);

    public void setLayout(int var1, int var2);

    public void setCompositesDirty(boolean var1);
}

