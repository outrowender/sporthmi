/*
 * Decompiled with CFR 0.152.
 */
package org.osgi.framework;

import java.util.Dictionary;
import org.osgi.framework.ServiceReference;

public interface Filter {
    public boolean match(ServiceReference var1);

    public boolean match(Dictionary var1);

    public String toString();

    public boolean equals(Object var1);

    public int hashCode();
}

