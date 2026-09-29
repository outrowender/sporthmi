/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui.views;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.IView;

public class RouteBriefingView
implements IView {
    private NavigationEnv env;

    public RouteBriefingView(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
    }

    public void setDDSEnterListener(ButtonListener buttonListener) {
        this.env.getVirtualButtonModel(1897989632).setButtonListener(buttonListener);
    }
}

