/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio.list;

import de.audi.app.bap.fw.arrays.AbstractManagedListHandler;
import de.audi.app.bap.fw.arrays.ListDelta;
import de.audi.app.combi.bap.app.audio.CombiModuleAudio;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.esolutions.fw.util.commons.Buffer;

public class RadioTVPresetListHandler
extends AbstractManagedListHandler {
    private final Object mutex = new Object();
    private volatile CombiBAPArrayElement[] deferredNewList;

    public RadioTVPresetListHandler(CombiModuleAudio combiModuleAudio) {
        super(combiModuleAudio, "RadioTVPresetListHandler");
    }

    @Override
    public void getNextListPos(int n, int n2) {
        super.getNextListPosForArbitraryIds(n, n2);
    }

    @Override
    public void getNextListPosResult(boolean bl, int n, int n2, int n3) {
        ((CombiModuleAudio)this.moduleFsg).getTunerService().getNextListPosResult(bl ? 0 : 1, n, n2, n3);
    }

    @Override
    public int getIndexSize() {
        return 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateList(CombiBAPArrayElement[] combiBAPArrayElementArray) {
        this.logChannel.log(-2137614336, "[%1#updateList] presetListSize=%2", (Object)this.className, (long)combiBAPArrayElementArray.length);
        boolean bl = this.moduleFsg.getFunctionSynchronizationHandler().getCurrentSyncType() == 0 || this.moduleFsg.getFunctionSynchronizationHandler().getCurrentSyncType() == 2 || this.moduleFsg.getFunctionSynchronizationHandler().getCurrentSyncType() == 5;
        ListDelta listDelta = ListDelta.compare(this.getManagedList(), combiBAPArrayElementArray);
        if (bl) {
            this.logChannel.log(-2137614336, "[%1#updateList] function sync %2 is opened", (Object)this.className, (long)this.moduleFsg.getFunctionSynchronizationHandler().getCurrentSyncType());
            Object object = this.mutex;
            synchronized (object) {
                if (!listDelta.isUnchanged() || this.deferredNewList != null) {
                    this.deferredNewList = combiBAPArrayElementArray;
                    this.logChannel.log(-2137614336, "[%1#updateList] source change in progress, request deferred. New list:\n%2", (Object)this.className, (Object)this.deferredListToString());
                }
            }
        }
        Object object = this.mutex;
        synchronized (object) {
            this.list = combiBAPArrayElementArray;
            this.deferredNewList = null;
        }
        this.sendChangedArrayRequest(listDelta);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean updateDeferredList(boolean bl) {
        this.logChannel.log(-2137614336, "[%1#updateDeferredList] forceFullRangeUpdate=%2", (Object)this.className, (Object)bl);
        Object object = this.mutex;
        synchronized (object) {
            if (this.deferredNewList == null) {
                this.logChannel.log(-2137614336, "[%1#updateDeferredList] no deferred updates", (Object)this.className);
                if (!bl) {
                    return false;
                }
                this.sendFullRangeUpdate();
            } else if (bl) {
                this.list = this.deferredNewList;
                this.deferredNewList = null;
                this.sendFullRangeUpdate();
            } else {
                ListDelta listDelta = ListDelta.compare(this.getManagedList(), this.deferredNewList);
                this.list = this.deferredNewList;
                this.deferredNewList = null;
                this.sendChangedArrayRequest(listDelta);
            }
            return true;
        }
    }

    private String deferredListToString() {
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < this.deferredNewList.length; ++i2) {
            buffer.append(this.deferredNewList[i2]);
            buffer.append('\n');
        }
        return buffer.toString();
    }
}

