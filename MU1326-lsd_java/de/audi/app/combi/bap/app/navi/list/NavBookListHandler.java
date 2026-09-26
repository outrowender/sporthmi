/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.navi.list;

import de.audi.app.bap.fw.arrays.AbstractArrayHandler;
import de.audi.app.bap.fw.arrays.GetArrayIndication;
import de.audi.app.combi.bap.app.navi.CombiModuleNavi;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;

public class NavBookListHandler
extends AbstractArrayHandler {
    private int currentListSize;

    public NavBookListHandler(CombiModuleNavi combiModuleNavi) {
        super(combiModuleNavi, "NavBookListHandler");
    }

    @Override
    public CombiBAPArrayElement getArrayElement(int n) {
        return null;
    }

    @Override
    public void getNextListPos(int n, int n2) {
    }

    @Override
    public void getNextListPosResult(boolean bl, int n, int n2, int n3) {
    }

    @Override
    public int getCurrentListSize() {
        return this.currentListSize;
    }

    @Override
    public int getPredecessorID(int n) {
        return 0;
    }

    @Override
    public int getSuccessorID(int n) {
        return 0;
    }

    @Override
    public void requestListElements(GetArrayIndication getArrayIndication) {
    }
}

