/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.IView;

public abstract class AbstractView
implements IView {
    private LogChannel logger;
    private NavigationEnv env;

    public AbstractView(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
        this.logger = navigationEnv.getLogChannel("App.Map.GUI.Default");
    }

    protected LogChannel getLogger() {
        return this.logger;
    }

    protected NavigationEnv getEnv() {
        return this.env;
    }
}

