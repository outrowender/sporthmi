/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.navi.list;

import de.audi.app.bap.fw.arrays.AbstractManagedListHandler;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.vw.mib.bap.generated.navsd.serializer.GetNextListPos_Result;

public class LastDestinationsListHandler
extends AbstractManagedListHandler {
    public LastDestinationsListHandler(AbstractCombiModule abstractCombiModule) {
        super(abstractCombiModule, "LastDestinationsListHandler");
    }

    public void getNextListPos(int n, int n2) {
        super.getNextListPosForArbitraryIds(n, n2);
    }

    public void getNextListPosResult(boolean bl, int n, int n2, int n3) {
        this.logChannel.log(10000000, "[%1#getNextListPosResult] called (result=%2, currentEntryID=%3,...)", (Object)this.className, (Object)(bl ? "successful" : "unsuccessful"), (long)n);
        this.logChannel.log(10000000, "[%1#getNextListPosResult] ..., nextEntryID=%2, absoluteListPos=%3", (Object)this.className, (long)n2, (long)n3);
        BAPFunctionMethodFSG bAPFunctionMethodFSG = this.moduleFsg.getBAPFunctionMethodFSG(41);
        GetNextListPos_Result getNextListPos_Result = (GetNextListPos_Result)this.moduleFsg.createResultSerializer(41);
        getNextListPos_Result.getNextListPos_Result = bl ? 0 : 1;
        getNextListPos_Result.currentPos = n;
        getNextListPos_Result.nextPos = n2;
        getNextListPos_Result.absoluteListPos = n3;
        bAPFunctionMethodFSG.resultREQ(getNextListPos_Result);
    }

    public int getIndexSize() {
        return 0;
    }
}

