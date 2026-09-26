/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.widgets.ReusableInstanceCache$AbstractInstanceFactory;
import de.esolutions.hmi.widgets.audi.evo.widgets.ReusableInstanceCache$IReusable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class ReusableInstanceCache {
    private final ReusableInstanceCache$AbstractInstanceFactory factory;
    private final HashMap cachedInstancesSortedByClass;
    private final HashSet cachedInstances;

    public ReusableInstanceCache(ReusableInstanceCache$AbstractInstanceFactory reusableInstanceCache$AbstractInstanceFactory) {
        this.factory = reusableInstanceCache$AbstractInstanceFactory;
        this.cachedInstancesSortedByClass = new HashMap();
        this.cachedInstances = new HashSet();
    }

    public void collect(ReusableInstanceCache$IReusable reusableInstanceCache$IReusable) {
        if (reusableInstanceCache$IReusable == null) {
            IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "ReusableInstanceCache#add: ignored null instance.", new Throwable());
            return;
        }
        String string = reusableInstanceCache$IReusable.getTypeKey();
        if (string == null) {
            throw new IllegalArgumentException(new Buffer("Could not add instance '").append(reusableInstanceCache$IReusable).append("', type key was null.").toString());
        }
        if (!this.cachedInstancesSortedByClass.containsKey(string)) {
            this.cachedInstancesSortedByClass.put(string, new LinkedList());
        }
        if (this.cachedInstances.add(reusableInstanceCache$IReusable)) {
            reusableInstanceCache$IReusable.reset();
            this.getCachedInstanceList(string).add(reusableInstanceCache$IReusable);
        } else {
            IWidgetLogChannel.tpLogChannelInternal.log(10000, "ReusableInstanceCache#add: Could not add instance (%1), it already exists in the cache.", (Object)reusableInstanceCache$IReusable);
        }
    }

    private LinkedList getCachedInstanceList(String string) {
        return (LinkedList)this.cachedInstancesSortedByClass.get(string);
    }

    public ReusableInstanceCache$IReusable getOrCreateInstance(String string) {
        if (this.hasCachedInstance(string)) {
            ReusableInstanceCache$IReusable reusableInstanceCache$IReusable = (ReusableInstanceCache$IReusable)this.getCachedInstanceList(string).removeFirst();
            this.cachedInstances.remove(reusableInstanceCache$IReusable);
            return reusableInstanceCache$IReusable;
        }
        return ReusableInstanceCache$AbstractInstanceFactory.access$000(this.factory, string);
    }

    private boolean hasCachedInstance(String string) {
        return this.cachedInstancesSortedByClass.containsKey(string) && !this.getCachedInstanceList(string).isEmpty();
    }

    public void clear() {
        Iterator iterator = this.cachedInstancesSortedByClass.keySet().iterator();
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            ((LinkedList)this.cachedInstancesSortedByClass.get(string)).clear();
        }
        this.cachedInstancesSortedByClass.clear();
    }
}

