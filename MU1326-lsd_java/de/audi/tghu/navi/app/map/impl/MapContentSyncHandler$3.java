/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.impl;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.gui.SimpleChoiceListener;
import de.audi.tghu.navi.app.map.impl.MapContentSyncHandler;

class MapContentSyncHandler$3
extends SimpleChoiceListener {
    private final /* synthetic */ NavigationEnv val$env;
    private final /* synthetic */ MapContentSyncHandler this$0;

    MapContentSyncHandler$3(MapContentSyncHandler mapContentSyncHandler, NavigationEnv navigationEnv) {
        this.this$0 = mapContentSyncHandler;
        this.val$env = navigationEnv;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        int n5 = 1 - this.val$env.getChoiceModel(n).getValue();
        this.val$env.getChoiceModel(n).setValue(n5);
        this.this$0.checkAll(n5 == 1);
    }
}

