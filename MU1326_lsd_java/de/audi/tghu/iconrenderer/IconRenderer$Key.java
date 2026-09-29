/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.iconrenderer;

import de.audi.tghu.iconrenderer.IconRenderer;

class IconRenderer$Key {
    private int firstIndex;
    private int secondIndex;
    private int thirdIndex;
    private final /* synthetic */ IconRenderer this$0;

    public IconRenderer$Key(IconRenderer iconRenderer, int n) {
        this.this$0 = iconRenderer;
        this.firstIndex = n;
        this.secondIndex = 0;
        this.thirdIndex = 0;
    }

    public IconRenderer$Key(IconRenderer iconRenderer, int n, int n2) {
        this.this$0 = iconRenderer;
        this.firstIndex = n;
        this.secondIndex = n2;
        this.thirdIndex = 0;
    }

    public IconRenderer$Key(IconRenderer iconRenderer, int n, int n2, int n3) {
        this.this$0 = iconRenderer;
        this.firstIndex = n;
        this.secondIndex = n2;
        this.thirdIndex = n3;
    }

    public int hashCode() {
        int n = 17;
        n = 37 * n + this.firstIndex;
        n = 37 * n + this.secondIndex;
        n = 37 * n + this.thirdIndex;
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof IconRenderer$Key)) {
            return false;
        }
        IconRenderer$Key iconRenderer$Key = (IconRenderer$Key)object;
        return this.thirdIndex == iconRenderer$Key.thirdIndex && this.secondIndex == iconRenderer$Key.secondIndex && this.firstIndex == iconRenderer$Key.firstIndex;
    }
}

