/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.drawerfocus.DrawerFocusUtil;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tuner.app.DrawerFocusManager;
import de.audi.tuner.app.DrawerFocusManager$1;

class DrawerFocusManager$ChoiceListener
extends DefaultChoiceListener {
    private final /* synthetic */ DrawerFocusManager this$0;

    private DrawerFocusManager$ChoiceListener(DrawerFocusManager drawerFocusManager) {
        this.this$0 = drawerFocusManager;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        DrawerFocusManager.access$102(this.this$0, DrawerFocusUtil.isFocusGained(n2));
        if (DrawerFocusManager.access$100(this.this$0)) {
            DrawerFocusManager.access$200(this.this$0).abortScan();
        }
    }

    /* synthetic */ DrawerFocusManager$ChoiceListener(DrawerFocusManager drawerFocusManager, DrawerFocusManager$1 drawerFocusManager$1) {
        this(drawerFocusManager);
    }
}

