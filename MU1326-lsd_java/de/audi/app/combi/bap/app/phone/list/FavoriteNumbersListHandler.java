/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.phone.list;

import de.audi.app.bap.fw.arrays.AbstractManagedListHandler;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.combi.bap.app.phone.CombiModulePhone;
import de.vw.mib.bap.generated.telephone.serializer.GetNextListPos_Result;

public class FavoriteNumbersListHandler
extends AbstractManagedListHandler {
    public FavoriteNumbersListHandler(CombiModulePhone combiModulePhone) {
        super(combiModulePhone, "FavoriteNumbersListHandler");
    }

    @Override
    public void getNextListPos(int n, int n2) {
        super.getNextListPosForConsecutiveIds(n, n2);
    }

    @Override
    public void getNextListPosResult(boolean bl, int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "[FavoriteNumbersListHandler#getNextListPosResult]");
        BAPFunctionMethodFSG bAPFunctionMethodFSG = this.moduleFsg.getBAPFunctionMethodFSG(54);
        GetNextListPos_Result getNextListPos_Result = new GetNextListPos_Result();
        getNextListPos_Result.getNextListPos_Result = bl ? 0 : 1;
        getNextListPos_Result.currentPos = n;
        getNextListPos_Result.nextPos = n2;
        getNextListPos_Result.absoluteListPos = n3;
        bAPFunctionMethodFSG.resultREQ(getNextListPos_Result);
    }
}

