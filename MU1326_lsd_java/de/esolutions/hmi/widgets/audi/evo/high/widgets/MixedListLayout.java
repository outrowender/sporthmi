/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListPlaceholder;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;

public class MixedListLayout
extends LayoutContainerController {
    private int layoutFormat = -1;

    public MixedListLayout(int n) {
        this.layoutFormat = n;
    }

    public MixedListPlaceholder getPlaceholderByModelColumn(int n) {
        int n2 = this.getChildrenSize();
        for (int i2 = 0; i2 < n2; ++i2) {
            MixedListPlaceholder mixedListPlaceholder = (MixedListPlaceholder)this.getChild(i2);
            if (mixedListPlaceholder.getModelColumn() != n) continue;
            return mixedListPlaceholder;
        }
        return null;
    }

    public int getLayoutFormat() {
        return this.layoutFormat;
    }

    public void setLayoutFormat(int n) {
        this.layoutFormat = n;
    }
}

