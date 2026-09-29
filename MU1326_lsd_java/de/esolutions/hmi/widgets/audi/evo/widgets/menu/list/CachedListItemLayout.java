/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu.list;

class CachedListItemLayout {
    private int heightExpanded = -1;
    private int heightNotExpanded = -1;
    public int marginTop;
    public int marginBottom;
    public int glassplateInsetsTop;
    public int glassplateInsetsBottom;
    int cachedSizes = 0;

    CachedListItemLayout() {
    }

    public int getHeight(boolean bl) {
        return bl ? this.heightExpanded : this.heightNotExpanded;
    }

    public void setHeight(int n, boolean bl) {
        if (bl) {
            this.heightExpanded = n;
            this.cachedSizes |= 1;
        } else {
            this.heightNotExpanded = n;
            this.cachedSizes |= 2;
        }
    }

    public void setMargin(int n, int n2) {
        this.marginTop = n;
        this.marginBottom = n2;
        this.cachedSizes |= 8;
    }

    public void setGlasplateInsets(int n, int n2) {
        this.glassplateInsetsTop = n;
        this.glassplateInsetsBottom = n2;
        this.cachedSizes |= 4;
    }
}

