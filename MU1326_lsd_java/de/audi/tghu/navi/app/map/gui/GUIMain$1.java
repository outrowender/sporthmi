/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.tghu.navi.app.map.gui.GUIMain;
import de.audi.tghu.navi.app.map.gui.SimpleButtonListener;

class GUIMain$1
extends SimpleButtonListener {
    private final /* synthetic */ GUIMain this$0;

    GUIMain$1(GUIMain gUIMain) {
        this.this$0 = gUIMain;
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        this.this$0.getMap().getActiveContext().keyReleased(n, n2);
    }
}

