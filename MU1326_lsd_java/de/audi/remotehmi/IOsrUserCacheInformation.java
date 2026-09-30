/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi;

public interface IOsrUserCacheInformation {
    public Object getUser();

    public String getProfilePath();

    public boolean isAuthenticated();

    public String getDomain();

    public void setAuthenticated(boolean var1);
}

