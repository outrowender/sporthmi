/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio.list;

import de.audi.app.bap.fw.arrays.AbstractManagedListHandler;
import de.audi.app.combi.bap.app.audio.CombiModuleAudio;
import de.audi.app.combi.bap.fw.AbstractCombiModule;

public class CommonListHandler
extends AbstractManagedListHandler {
    public CommonListHandler(AbstractCombiModule abstractCombiModule) {
        super(abstractCombiModule, "CommonListHandler");
    }

    public void getNextListPos(int n, int n2) {
        super.getNextListPosForArbitraryIds(n, n2);
    }

    public void getNextListPosResult(boolean bl, int n, int n2, int n3) {
        ((CombiModuleAudio)this.moduleFsg).getTunerService().getNextListPosResult(bl ? 0 : 1, n, n2, n3);
    }
}

