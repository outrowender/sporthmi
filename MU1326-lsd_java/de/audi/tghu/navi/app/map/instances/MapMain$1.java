/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.instances;

import de.audi.tghu.navi.app.map.gui.SimpleButtonListener;
import de.audi.tghu.navi.app.map.instances.MapMain;

class MapMain$1
extends SimpleButtonListener {
    private final /* synthetic */ MapMain this$0;

    MapMain$1(MapMain mapMain) {
        this.this$0 = mapMain;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.this$0.getMapLogChannel().log(-2137614336, "MapMain#<setDDSEnterListener>#keyPressed()");
        this.this$0.getActiveContext().keyPressed(n, n2);
    }
}

