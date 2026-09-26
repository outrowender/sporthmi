/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi.poiwarning;

import de.audi.tghu.navi.app.poi.poiwarning.PoiWarningManager;

final class PoiWarningManager$PoiElement {
    private final int id;
    private boolean isValid;
    private final /* synthetic */ PoiWarningManager this$0;

    public PoiWarningManager$PoiElement(PoiWarningManager poiWarningManager, int n, boolean bl) {
        this.this$0 = poiWarningManager;
        this.id = n;
        this.isValid = bl;
    }

    public int id() {
        return this.id;
    }

    public boolean isValid() {
        return this.isValid;
    }

    public void setActivlyInUse() {
        this.isValid = true;
    }
}

