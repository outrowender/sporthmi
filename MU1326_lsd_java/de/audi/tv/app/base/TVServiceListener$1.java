/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.atip.interapp.media.IMediaDrawerElement;
import de.audi.tv.app.base.TVServiceListener;

class TVServiceListener$1
implements IMediaDrawerElement {
    private final /* synthetic */ int val$activeList;
    private final /* synthetic */ TVServiceListener this$0;

    TVServiceListener$1(TVServiceListener tVServiceListener, int n) {
        this.this$0 = tVServiceListener;
        this.val$activeList = n;
    }

    @Override
    public String getName() {
        return "favorites";
    }

    @Override
    public int getIconID() {
        return 0;
    }

    @Override
    public int getID() {
        return 1;
    }

    @Override
    public boolean isSelected() {
        return this.val$activeList == 1;
    }

    @Override
    public boolean isFocused() {
        return this.val$activeList == 1;
    }
}

