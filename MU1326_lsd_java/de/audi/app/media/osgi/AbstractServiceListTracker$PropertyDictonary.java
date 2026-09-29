/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.osgi;

import de.audi.app.media.osgi.AbstractServiceListTracker;
import java.util.Dictionary;
import java.util.Enumeration;
import org.osgi.framework.ServiceReference;

class AbstractServiceListTracker$PropertyDictonary
extends Dictionary {
    private final ServiceReference reference;
    private final /* synthetic */ AbstractServiceListTracker this$0;

    public AbstractServiceListTracker$PropertyDictonary(AbstractServiceListTracker abstractServiceListTracker, ServiceReference serviceReference) {
        this.this$0 = abstractServiceListTracker;
        this.reference = serviceReference;
    }

    @Override
    public int size() {
        return this.reference.getPropertyKeys().length;
    }

    @Override
    public Object remove(Object object) {
        return null;
    }

    @Override
    public Object put(Object object, Object object2) {
        return null;
    }

    @Override
    public Enumeration keys() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Object get(Object object) {
        return this.reference.getProperty(object.toString());
    }

    @Override
    public Enumeration elements() {
        return null;
    }
}

