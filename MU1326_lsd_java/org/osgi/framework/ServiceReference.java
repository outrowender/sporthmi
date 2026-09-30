/*
 * Decompiled with CFR 0.152.
 */
package org.osgi.framework;

import org.osgi.framework.Bundle;

public interface ServiceReference {
    public Object getProperty(String var1);

    public String[] getPropertyKeys();

    public Bundle getBundle();

    public Bundle[] getUsingBundles();
}

