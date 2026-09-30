/*
 * Decompiled with CFR 0.152.
 */
package org.osgi.framework;

import java.io.InputStream;
import java.net.URL;
import java.util.Dictionary;
import org.osgi.framework.BundleException;
import org.osgi.framework.ServiceReference;

public interface Bundle {
    public static final int UNINSTALLED = 1;
    public static final int INSTALLED = 2;
    public static final int RESOLVED = 4;
    public static final int STARTING = 8;
    public static final int STOPPING = 16;
    public static final int ACTIVE = 32;

    public int getState();

    public void start() throws BundleException;

    public void stop() throws BundleException;

    public void update() throws BundleException;

    public void update(InputStream var1) throws BundleException;

    public void uninstall() throws BundleException;

    public Dictionary getHeaders();

    public long getBundleId();

    public String getLocation();

    public ServiceReference[] getRegisteredServices();

    public ServiceReference[] getServicesInUse();

    public boolean hasPermission(Object var1);

    public URL getResource(String var1);
}

