/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.phone.list;

import de.audi.app.bap.fw.arrays.AbstractManagedListHandler;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.combi.bap.app.phone.CombiModulePhone;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.vw.mib.bap.generated.telephone.serializer.GetNextListPos_Result;

public class CombinedNumbersListHandler
extends AbstractManagedListHandler {
    public CombinedNumbersListHandler(CombiModulePhone combiModulePhone) {
        super(combiModulePhone, "CombinedNumbersListHandler");
    }

    @Override
    public void updateList(CombiBAPArrayElement[] combiBAPArrayElementArray) {
        this.logChannel.log(-2137614336, "[%1#updateList] listSize=%2", (Object)this.className, (long)combiBAPArrayElementArray.length);
        if (this.list.length == 0 && combiBAPArrayElementArray.length == 0) {
            this.logChannel.log(-2137614336, "[CombinedNumbersListHandler#updateList] list is still empty -> don't send ChangedArray");
        } else {
            this.list = combiBAPArrayElementArray;
            this.sendFullRangeUpdate();
        }
    }

    @Override
    public void getNextListPos(int n, int n2) {
        super.getNextListPosForConsecutiveIds(n, n2);
    }

    @Override
    public void getNextListPosResult(boolean bl, int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "[CombinedNumbersListHandler#getNextListPosResult]");
        BAPFunctionMethodFSG bAPFunctionMethodFSG = this.moduleFsg.getBAPFunctionMethodFSG(54);
        GetNextListPos_Result getNextListPos_Result = new GetNextListPos_Result();
        getNextListPos_Result.getNextListPos_Result = bl ? 0 : 1;
        getNextListPos_Result.currentPos = n;
        getNextListPos_Result.nextPos = n2;
        getNextListPos_Result.absoluteListPos = n3;
        bAPFunctionMethodFSG.resultREQ(getNextListPos_Result);
    }
}

