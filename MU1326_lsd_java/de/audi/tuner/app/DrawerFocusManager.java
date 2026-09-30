/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.drawerfocus.DrawerFocusUtil;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tuner.app.IDrawerFocusManager;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.ifc.IScanHandler;

public class DrawerFocusManager
implements IDrawerFocusManager {
    private boolean drawerIsOpen;
    private final IScanHandler scan;
    public static final IDrawerFocusManager NULL_DRAWER_FOCUS_MANAGER = new IDrawerFocusManager(){

        public boolean isDrawerOpen() {
            return false;
        }
    };

    public DrawerFocusManager(TunerBasics tunerBasics, IScanHandler iScanHandler) {
        tunerBasics.getModels().getChoiceModel(100720).setChoiceListener(new ChoiceListener());
        this.scan = iScanHandler;
    }

    public boolean isDrawerOpen() {
        return this.drawerIsOpen;
    }

    private class ChoiceListener
    extends DefaultChoiceListener {
        private ChoiceListener() {
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            DrawerFocusManager.this.drawerIsOpen = DrawerFocusUtil.isFocusGained(n2);
            if (DrawerFocusManager.this.drawerIsOpen) {
                DrawerFocusManager.this.scan.abortScan();
            }
        }
    }
}

