/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.app.DrawerFocusManager$1;
import de.audi.tuner.app.DrawerFocusManager$ChoiceListener;
import de.audi.tuner.app.IDrawerFocusManager;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.ifc.IScanHandler;

public class DrawerFocusManager
implements IDrawerFocusManager {
    private boolean drawerIsOpen;
    private final IScanHandler scan;
    public static final IDrawerFocusManager NULL_DRAWER_FOCUS_MANAGER = new DrawerFocusManager$1();

    public DrawerFocusManager(TunerBasics tunerBasics, IScanHandler iScanHandler) {
        tunerBasics.getModels().getChoiceModel(1888026880).setChoiceListener(new DrawerFocusManager$ChoiceListener(this, null));
        this.scan = iScanHandler;
    }

    @Override
    public boolean isDrawerOpen() {
        return this.drawerIsOpen;
    }

    static /* synthetic */ boolean access$102(DrawerFocusManager drawerFocusManager, boolean bl) {
        drawerFocusManager.drawerIsOpen = bl;
        return drawerFocusManager.drawerIsOpen;
    }

    static /* synthetic */ boolean access$100(DrawerFocusManager drawerFocusManager) {
        return drawerFocusManager.drawerIsOpen;
    }

    static /* synthetic */ IScanHandler access$200(DrawerFocusManager drawerFocusManager) {
        return drawerFocusManager.scan;
    }
}

