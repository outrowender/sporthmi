/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.storage;

import de.audi.tghu.storage.DSIStorageProvider;
import de.audi.tghu.storage.DSIStorageProvider$1;
import de.audi.tghu.storage.DSIStorageProvider$Request;
import java.util.HashMap;
import java.util.Map;

class DSIStorageProvider$RequestRegistry {
    private Map namespaces = new HashMap();
    private final /* synthetic */ DSIStorageProvider this$0;

    private DSIStorageProvider$RequestRegistry(DSIStorageProvider dSIStorageProvider) {
        this.this$0 = dSIStorageProvider;
    }

    private Map getNamespace(int n) {
        HashMap hashMap = (HashMap)this.namespaces.get(new Integer(n));
        if (hashMap == null) {
            hashMap = new HashMap();
            this.namespaces.put(new Integer(n), hashMap);
        }
        return hashMap;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void releaseRequest(DSIStorageProvider$Request dSIStorageProvider$Request) {
        Map map = this.namespaces;
        synchronized (map) {
            DSIStorageProvider$Request.access$1410(dSIStorageProvider$Request);
            if (DSIStorageProvider$Request.access$1400(dSIStorageProvider$Request) == 0) {
                this.getNamespace(DSIStorageProvider$Request.access$400(dSIStorageProvider$Request)).remove(new Long(DSIStorageProvider$Request.access$500(dSIStorageProvider$Request)));
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    DSIStorageProvider$Request lookupRequest(int n, long l) {
        Map map = this.namespaces;
        synchronized (map) {
            return (DSIStorageProvider$Request)this.getNamespace(n).get(new Long(l));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    DSIStorageProvider$Request getRequest(int n, int n2) {
        Map map = this.namespaces;
        synchronized (map) {
            DSIStorageProvider$Request dSIStorageProvider$Request = this.lookupRequest(n, n2);
            if (dSIStorageProvider$Request == null) {
                dSIStorageProvider$Request = DSIStorageProvider$Request.access$1600(new DSIStorageProvider$Request(this.this$0, null), n, n2);
                this.getNamespace(n).put(new Long(n2), dSIStorageProvider$Request);
            }
            DSIStorageProvider$Request.access$1408(dSIStorageProvider$Request);
            return dSIStorageProvider$Request;
        }
    }

    /* synthetic */ DSIStorageProvider$RequestRegistry(DSIStorageProvider dSIStorageProvider, DSIStorageProvider$1 dSIStorageProvider$1) {
        this(dSIStorageProvider);
    }
}

