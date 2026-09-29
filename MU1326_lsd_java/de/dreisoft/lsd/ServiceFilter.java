/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd;

import de.dreisoft.lsd.ServiceFilter$Condition;
import de.dreisoft.lsd.ServiceFilter$Parser;
import de.dreisoft.lsd.ServiceInfo;
import java.util.Dictionary;
import java.util.HashSet;
import org.osgi.framework.Filter;
import org.osgi.framework.ServiceReference;

public class ServiceFilter
implements Filter {
    private String filterString;
    private String[] svcInterfaces;
    private ServiceFilter$Condition condition;

    ServiceFilter(String string) {
        if (string == null) {
            throw new NullPointerException("filter string must not be null");
        }
        this.filterString = string;
        HashSet hashSet = new HashSet();
        this.condition = new ServiceFilter$Parser(null).parse(this.filterString, hashSet);
        this.svcInterfaces = new String[hashSet.size()];
        if (!hashSet.isEmpty()) {
            this.svcInterfaces = (String[])hashSet.toArray(this.svcInterfaces);
        }
    }

    public String[] getServiceInterfaces() {
        return this.svcInterfaces;
    }

    public boolean isServiceInterfaceList() {
        return this.condition.isServiceInterfaceList();
    }

    @Override
    public boolean match(ServiceReference serviceReference) {
        return this.match(((ServiceInfo)serviceReference).getProperties());
    }

    @Override
    public boolean match(Dictionary dictionary) {
        return this.condition.isFulfilled(dictionary);
    }

    @Override
    public String toString() {
        return this.filterString;
    }
}

