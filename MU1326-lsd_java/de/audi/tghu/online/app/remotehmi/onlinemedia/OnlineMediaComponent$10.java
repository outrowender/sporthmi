/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.onlinemedia;

import de.audi.atip.interapp.media.IMediaDrawerElement;
import de.audi.tghu.online.app.remotehmi.onlinemedia.OnlineMediaComponent;

class OnlineMediaComponent$10
implements IMediaDrawerElement {
    private final /* synthetic */ OnlineMediaComponent this$0;

    OnlineMediaComponent$10(OnlineMediaComponent onlineMediaComponent) {
        this.this$0 = onlineMediaComponent;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isFocused() {
        return false;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getIconID() {
        return 1;
    }

    @Override
    public int getID() {
        return 1;
    }
}

