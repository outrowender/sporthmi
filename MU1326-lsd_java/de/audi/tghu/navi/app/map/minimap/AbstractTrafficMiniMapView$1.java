/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.minimap;

import de.audi.tghu.navi.app.map.minimap.AbstractTrafficMiniMapView;
import de.audi.tghu.navi.app.map.minimap.ChoiceListenerAdapter;

class AbstractTrafficMiniMapView$1
extends ChoiceListenerAdapter {
    private final /* synthetic */ AbstractTrafficMiniMapView this$0;

    AbstractTrafficMiniMapView$1(AbstractTrafficMiniMapView abstractTrafficMiniMapView) {
        this.this$0 = abstractTrafficMiniMapView;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        if (n2 == 0) {
            this.this$0.deactivateAndPersist();
        } else {
            this.this$0.activateAndPersist();
        }
    }
}

