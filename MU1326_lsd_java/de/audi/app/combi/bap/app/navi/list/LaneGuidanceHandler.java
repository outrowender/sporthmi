/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.navi.list;

import de.audi.app.bap.fw.arrays.AbstractManagedListHandler;
import de.audi.app.combi.bap.app.navi.CombiModuleNavi;

public class LaneGuidanceHandler
extends AbstractManagedListHandler {
    private boolean displayLaneGuidance;

    public LaneGuidanceHandler(CombiModuleNavi combiModuleNavi) {
        super(combiModuleNavi, "LaneGuidanceHandler");
    }

    public void setLaneGuidanceEnabled(boolean bl) {
        this.displayLaneGuidance = bl;
    }

    protected boolean isLaneGuidanceEnabled() {
        return this.displayLaneGuidance;
    }

    @Override
    public void getNextListPos(int n, int n2) {
        this.logChannel.log(10000, "[%1#getNextListPos] not supported", (Object)this.className);
    }

    @Override
    public void getNextListPosResult(boolean bl, int n, int n2, int n3) {
        this.logChannel.log(10000, "[%1#getNextListPosResult] not supported", (Object)this.className);
    }

    @Override
    public int getIndexSize() {
        return 0;
    }
}

