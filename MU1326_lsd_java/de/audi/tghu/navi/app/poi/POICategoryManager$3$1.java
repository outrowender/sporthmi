/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi;

import de.audi.tghu.navi.app.poi.POICategoryManager;
import de.audi.tghu.navi.app.poi.POICategoryManager$3;
import org.dsi.ifc.navigation.Category;

class POICategoryManager$3$1
implements Runnable {
    private final /* synthetic */ Category[] val$categories;
    private final /* synthetic */ POICategoryManager$3 this$1;

    POICategoryManager$3$1(POICategoryManager$3 pOICategoryManager$3, Category[] categoryArray) {
        this.this$1 = pOICategoryManager$3;
        this.val$categories = categoryArray;
    }

    @Override
    public void run() {
        int n = this.val$categories == null ? 0 : this.val$categories.length;
        for (int i2 = 0; i2 < n; ++i2) {
            POICategoryManager.access$400(POICategoryManager$3.access$300(this.this$1)).resolvePOIIconResourceID(this.val$categories[i2].getIconIndex(), this.val$categories[i2].getSubIconIndex());
        }
    }
}

