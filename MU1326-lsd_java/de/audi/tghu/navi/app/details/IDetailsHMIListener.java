/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.details;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.interapp.PreviewMapCallback;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.presentationmode.DemoModeManager;

public interface IDetailsHMIListener
extends ButtonListener,
IDetailsScreen,
PreviewMapCallback,
MenuModelListener {
    default public void setDemoModeManager(DemoModeManager demoModeManager) {
    }
}

