/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.tv;

import de.audi.app.media.evo.content.tv.DrawerContextHandler;
import de.audi.atip.interapp.media.IMediaDrawerElement;

class DrawerContextHandler$1
implements IMediaDrawerElement {
    int id;
    private final /* synthetic */ int val$paresedId;
    private final /* synthetic */ DrawerContextHandler this$0;

    DrawerContextHandler$1(DrawerContextHandler drawerContextHandler, int n) {
        this.this$0 = drawerContextHandler;
        this.val$paresedId = n;
        this.id = this.val$paresedId;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public int getIconID() {
        return 0;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isFocused() {
        return false;
    }
}

