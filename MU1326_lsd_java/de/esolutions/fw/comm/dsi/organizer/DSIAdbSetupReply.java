/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIAdbSetupReply {
    public static final String IPL_COMM_UUID = "cc1266c2-e252-54fa-8a38-76eb4551247b";
    public static final String IPL_COMM_INTERFACE_KEY = "3eae9550-165e-55c9-b8bf-5515a3b98ee4";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.31";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.31";

    public void updateAdbState(int var1, int var2) throws MethodException;

    public void updateSortOrder(int var1, int var2) throws MethodException;

    public void updatePictureVisibility(boolean var1, int var2) throws MethodException;

    public void setLanguageResult(int var1) throws MethodException;

    public void setSortOrderResult(int var1) throws MethodException;

    public void setPublicProfileVisibilityResult(int var1) throws MethodException;

    public void resetToFactorySettingsResult(int var1) throws MethodException;

    public void resetTopDestinationResult(int var1) throws MethodException;

    public void createBackupFileResult(int var1, String var2) throws MethodException;

    public void importBackupFileResult(int var1, String var2) throws MethodException;

    public void setPictureVisibilityResult(int var1) throws MethodException;

    public void setContextSpecificVisibilityResult(int var1) throws MethodException;

    public void updateContextSpecificVisibility(boolean var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

