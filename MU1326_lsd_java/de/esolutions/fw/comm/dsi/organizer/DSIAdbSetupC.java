/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIAdbSetupC {
    public void setLanguage(String var1) throws MethodException;

    public void setSortOrder(int var1) throws MethodException;

    public void setPublicProfileVisibility(boolean var1) throws MethodException;

    public void resetToFactorySettings() throws MethodException;

    public void resetTopDestination() throws MethodException;

    public void createBackupFile(String var1) throws MethodException;

    public void importBackupFile(String var1) throws MethodException;

    public void setPictureVisibility(boolean var1) throws MethodException;

    public void setContextSpecificVisibility(boolean var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

