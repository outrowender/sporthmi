/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIAdbUserProfileC {
    public void downloadToProfile(int var1) throws MethodException;

    public void restartDownload() throws MethodException;

    public void setProfileName(String var1) throws MethodException;

    public void deleteProfiles(int[] var1) throws MethodException;

    public void commonEntryCount() throws MethodException;

    public void entryMeter() throws MethodException;

    public void setPairingCode(String var1) throws MethodException;

    public void setHomeId(long var1) throws MethodException;

    public void setSOSButton(boolean var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

