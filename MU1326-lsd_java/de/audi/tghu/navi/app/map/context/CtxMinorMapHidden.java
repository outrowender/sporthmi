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

    @Override
    public void enterPrologue() {
        this.showMap(false);
        this.freezeMap();
    }

    @Override
    public void enterEpilogue() {
        this.unfreezeMap();
    }

    @Override
    public void enter() {
    }

    @Override
    public void exit() {
    }
}

