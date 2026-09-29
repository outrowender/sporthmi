/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.Context;
import de.audi.tghu.navi.app.map.context.State;
import de.audi.tghu.navi.app.poi.POICategoryManager;
import de.audi.tghu.navi.app.util.Util;

public class CtxLoadState
extends Context {
    public CtxLoadState(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    @Override
    public void enter() {
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        if (iStorageAccess != null) {
            int n = this.naviMap.isMapKombi() ? 950 : 900;
            State state = new State(iStorageAccess, this.getLogChannel(), this.env.getFramework(), n);
            state.readAndDeserialize();
            this.getSetup().initFromStateData(state.getData(), false);
        } else {
            this.getLogChannel().log(10000, "CtxLoadState#enter(): could not load persistent data");
        }
        try {
            this.getLogChannel().log(-2137614336, "CtxLoadState#enter() - fetchPOICategories");
            POICategoryManager pOICategoryManager = this.getMap().getNaviInterface().getPOICategoryManager();
            pOICategoryManager.fetchPOICategories(0).execute("CtxLoadState#fetchPOICategories(Standard/Traffic)");
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        Util.logStartupEvent(this.env.getFramework(), "CtxLoadState#enter() - finished map configuration - unfreeze map");
        this.naviMap.switchToAShownContext();
        if (this.naviMap.isMapMain()) {
            this.naviMap.getNaviInterface().setOperationTaskCompleted(6);
        }
    }

    @Override
    public void exitMapScreen() {
        this.getLogChannel().log(-2137614336, "CtxLoadState#exitMapScreen(): ignoring");
    }
}

