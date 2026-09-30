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

    public CombiBAPArrayElement getArrayElement(int n) {
        return null;
    }

    public void getNextListPos(int n, int n2) {
    }

    public void getNextListPosResult(boolean bl, int n, int n2, int n3) {
    }

    public int getCurrentListSize() {
        return this.currentListSize;
    }

    public int getPredecessorID(int n) {
        return 0;
    }

    public int getSuccessorID(int n) {
        return 0;
    }

    public void requestListElements(GetArrayIndication getArrayIndication) {
    }
}

