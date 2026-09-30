/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class ReusableInstanceCache {
    private final AbstractInstanceFactory factory;
    private final HashMap cachedInstancesSortedByClass;
    private final HashSet cachedInstances;

    public ReusableInstanceCache(AbstractInstanceFactory abstractInstanceFactory) {
        this.factory = abstractInstanceFactory;
        this.cachedInstancesSortedByClass = new HashMap();
        this.cachedInstances = new HashSet();
    }

    public void collect(IReusable iReusable) throws IllegalArgumentException {
        if (iReusable == null) {
            IWidgetLogChannel.tpLogChannelInternal.log(10000000, "ReusableInstanceCache#add: ignored null instance.", new Throwable());
            return;
        }
        String string = iReusable.getTypeKey();
        if (string == null) {
            throw new IllegalArgumentException(new Buffer("Could not add instance '").append(iReusable).append("', type key was null.").toString());
        }
        if (!this.cachedInstancesSortedByClass.containsKey(string)) {
            this.cachedInstancesSortedByClass.put(string, new LinkedList());
        }
        if (this.cachedInstances.add(iReusable)) {
            iReusable.reset();
            this.getCachedInstanceList(string).add(iReusable);
        } else {
            IWidgetLogChannel.tpLogChannelInternal.log(10000, "ReusableInstanceCache#add: Could not add instance (%1), it already exists in the cache.", (Object)iReusable);
        }
    }

    private LinkedList getCachedInstanceList(String string) {
        return (LinkedList)this.cachedInstancesSortedByClass.get(string);
    }

    public IReusable getOrCreateInstance(String string) {
        if (this.hasCachedInstance(string)) {
            IReusable iReusable = (IReusable)this.getCachedInstanceList(string).removeFirst();
            this.cachedInstances.remove(iReusable);
            return iReusable;
        }
        return this.factory.createAndCheckForNull(string);
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

    public static interface IReusable {
        public void reset();

        public String getTypeKey();
    }

    public static abstract class AbstractInstanceFactory {
        public abstract IReusable newInstance(String var1);

        private final IReusable createAndCheckForNull(String string) {
            IReusable iReusable = this.newInstance(string);
            if (iReusable == null) {
                throw new NullPointerException("Factory returned null.");
            }
            return iReusable;
        }
    }
}

