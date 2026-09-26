/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.map.context.State$StateData;

public class State$StateDataMapMain
extends State$StateData {
    public State$StateDataMapMain(IFrameworkAccess iFrameworkAccess) {
        super(iFrameworkAccess);
    }

    @Override
    final void init() {
        this.panorama = true;
        this.initCommon();
    }

    @Override
    final void initFromOldKeys(IStorageAccess iStorageAccess) {
        this.panorama = true;
        this.initFromOldKeysCommon(iStorageAccess);
    }
}

