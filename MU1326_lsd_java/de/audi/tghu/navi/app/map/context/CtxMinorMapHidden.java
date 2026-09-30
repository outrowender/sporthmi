/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.Context;

public class CtxMinorMapHidden
extends Context {
    public CtxMinorMapHidden(NavigationEnv navigationEnv, IconHandler iconHandler, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    public void enterPrologue() {
        this.showMap(false);
        this.freezeMap();
    }

    public void enterEpilogue() {
        this.unfreezeMap();
    }

    public void enter() {
    }

    public void exit() {
    }
}

