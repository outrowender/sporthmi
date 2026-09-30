/*
 * Decompiled with CFR 0.152.
 */
package org.osgi.framework;

import java.util.Dictionary;
import org.osgi.framework.ServiceReference;

public interface ServiceRegistration {
    public ServiceReference getReference();

    public void setProperties(Dictionary var1);

    public void unregister();
}

