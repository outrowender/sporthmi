/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.instances;

import de.audi.tghu.navi.app.map.gui.SimpleButtonListener;
import de.audi.tghu.navi.app.map.instances.MapMain;

class MapMain$2
extends SimpleButtonListener {
    private final /* synthetic */ MapMain this$0;

    MapMain$2(MapMain mapMain) {
        this.this$0 = mapMain;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (this.this$0.getActiveContextIndex() != 5) {
            this.this$0.getMapLogChannel().log(-2137614336, "MapMain#<setShowAltRouteListener>#keyPressed()");
            this.this$0.getGuiInterface().fireModelEvent(n);
            this.this$0.enterAlternativeRoutes();
        }
    }
}

