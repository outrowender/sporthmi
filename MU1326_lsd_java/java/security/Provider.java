/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public abstract class Provider
extends Properties {
    private static final long serialVersionUID = -4298000515446427739L;
    private String name;
    private String info;
    private double version;

    protected Provider(String string, double d2, String string2) {
        this.name = string;
        this.version = d2;
        this.info = string2;
    }

    public synchronized void clear() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkSecurityAccess("clearProviderProperties." + this.name);
        }
        super.clear();
    }

    public Set entrySet() {
        return Collections.unmodifiableSet(super.entrySet());
    }

    public String getInfo() {
        return this.info;
    }

    public String getName() {
        return this.name;
    }

    public double getVersion() {
        return this.version;
    }

    public Set keySet() {
        return Collections.unmodifiableSet(super.keySet());
    }

    public synchronized void load(InputStream inputStream) throws IOException {
        super.load(inputStream);
    }

    public synchronized Object put(Object object, Object object2) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkSecurityAccess("putProviderProperty." + this.name);
        }
        return super.put(object, object2);
    }

    public synchronized void putAll(Map map) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkSecurityAccess("putProviderProperty." + this.name);
        }
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            super.put(entry.getKey(), entry.getValue());
        }
    }

    public synchronized Object remove(Object object) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkSecurityAccess("removeProviderProperty." + this.name);
        }
        return super.remove(object);
    }

    public String toString() {
        return String.valueOf(this.name) + " version " + this.version;
    }

    public Collection values() {
        return Collections.unmodifiableCollection(super.values());
    }

    public String getProperty(String string, String string2) {
        String string3 = this.getProperty(string);
        if (string3 == null) {
            return string2;
        }
        return string2;
    }

    public String getProperty(String string) {
        int n = string.indexOf(46);
        if (n == -1) {
            return null;
        }
        String string2 = string.substring(0, n + 1);
        String string3 = string.substring(n + 1, string.length());
        return this.lookupProperty(string2, string3);
    }

    String lookupProperty(String string) {
        String string2 = super.getProperty(string);
        if (string2 != null) {
            return string2;
        }
        String string3 = string.toUpperCase();
        Enumeration enumeration = this.keys();
        while (enumeration.hasMoreElements()) {
            String string4 = (String)enumeration.nextElement();
            if (!string4.toUpperCase().equals(string3)) continue;
            return this.getProperty(string4);
        }
        return null;
    }

    String lookupProperty(String string, String string2) {
        String string3 = String.valueOf(string) + string2;
        String string4 = this.lookupProperty(string3);
        if (string4 != null) {
            return string4;
        }
        string4 = this.lookupProperty("Alg.Alias." + string3);
        if (string4 != null) {
            return this.lookupProperty(String.valueOf(string) + string4);
        }
        return null;
    }
}

