/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;

public class MenuItemMetaData
implements WidgetConstants {
    public MenuItemIndex index;
    public AbstractWidgetController widget;
    public int heightBefore;
    public int heightAfter;
    public boolean remove = false;
    public float opacityBefore = 1.0f;
    public boolean multiLine = false;
    public int separatingLineType = 0;

    public void setInitialHeight(int n) {
        this.heightBefore = n;
        this.heightAfter = n;
    }

    public boolean isMultiLine() {
        return this.multiLine;
    }

    public boolean isRealized() {
        return this.widget != null;
    }

    public float getOpacityAfter() {
        return this.remove ? 0.0f : 1.0f;
    }

    public boolean hasSeparatorAbove() {
        return this.separatingLineType == 2 || this.separatingLineType == 3;
    }

    public boolean hasSeparatorBelow() {
        return this.separatingLineType == 1 || this.separatingLineType == 3;
    }

    public String toString() {
        if (this.remove) {
            return this.index + "[remove]";
        }
        return this.index.toString();
    }
}

