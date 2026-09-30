/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap;

import de.audi.tghu.exlap.Container;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ExlapService;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ResultReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class ExlapAbstractService
implements ExlapService {
    private final Map attributetoListMap = new HashMap();
    private ResultReceiver resultReceiver = new ResultReceiver(){

        public void actionResult(int n, int n2, Container container) {
        }
    };

    public void addListener(int n, ExlapListener exlapListener) {
        List list = this.getListForAttribute(n);
        if (!list.contains(exlapListener)) {
            list.add(exlapListener);
        }
    }

    public void addListener(int[] nArray, ExlapListener exlapListener) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.addListener(nArray[i2], exlapListener);
        }
    }

    public void removeListener(int[] nArray, ExlapListener exlapListener) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.removeListener(nArray[i2], exlapListener);
        }
    }

    protected List getListForAttribute(int n) {
        Integer n2 = new Integer(n);
        List list = (List)this.attributetoListMap.get(n2);
        if (list == null) {
            list = new ArrayList();
            this.attributetoListMap.put(n2, list);
        }
        return list;
    }

    public void removeListener(int n, ExlapListener exlapListener) {
        List list = this.getListForAttribute(n);
        if (list.contains(exlapListener)) {
            list.remove(exlapListener);
        }
    }

    protected void iterateListener(int n, ListenerIterator listenerIterator) {
        List list = this.getListForAttribute(n);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            listenerIterator.processListener((ExlapListener)iterator.next());
        }
    }

    protected void actionResult(int n, int n2, Container container) {
        this.resultReceiver.actionResult(n, n2, container);
    }

    public void setResultReceiver(ResultReceiver resultReceiver) {
        this.resultReceiver = resultReceiver;
    }

    public void init() {
    }
}

