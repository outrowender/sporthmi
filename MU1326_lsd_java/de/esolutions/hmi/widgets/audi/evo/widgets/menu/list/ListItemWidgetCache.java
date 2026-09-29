/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu.list;

import de.audi.atip.util.Util;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListItemWidgetCache {
    public static final int MAX_CACHED_WIDGETS_PER_RECORD_SET;
    private Map cache = new HashMap(5);

    public boolean add(int n, AbstractWidgetController abstractWidgetController) {
        Integer n2 = this.createCacheKey(n);
        List list = (List)this.cache.get(n2);
        if (list == null) {
            list = new ArrayList(15);
            this.cache.put(n2, list);
        }
        if (list.size() >= 15) {
            return false;
        }
        list.add(abstractWidgetController);
        return true;
    }

    public AbstractWidgetController get(int n) {
        Integer n2 = this.createCacheKey(n);
        List list = (List)this.cache.get(n2);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (AbstractWidgetController)list.remove(list.size() - 1);
    }

    public Map clear() {
        HashMap hashMap = new HashMap(this.cache);
        this.cache.clear();
        return hashMap;
    }

    private Integer createCacheKey(int n) {
        return Util.createInteger(n);
    }
}

