/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.data;

import de.audi.tghu.online.app.operatorcall.data.OperatorCallHistoryStorage;
import de.audi.tghu.online.app.operatorcall.data.OperatorCallHistoryStorageDataContainer;
import java.util.Comparator;

class OperatorCallHistoryStorageDataContainer$1
implements Comparator {
    private final /* synthetic */ OperatorCallHistoryStorageDataContainer this$0;

    OperatorCallHistoryStorageDataContainer$1(OperatorCallHistoryStorageDataContainer operatorCallHistoryStorageDataContainer) {
        this.this$0 = operatorCallHistoryStorageDataContainer;
    }

    @Override
    public int compare(Object object, Object object2) {
        Integer n = (Integer)object;
        OperatorCallHistoryStorage operatorCallHistoryStorage = (OperatorCallHistoryStorage)object2;
        return n - operatorCallHistoryStorage.getUniqueId();
    }
}

