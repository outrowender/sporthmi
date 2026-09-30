/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

import org.dsi.ifc.base.DSIListener;

public interface DSIAdbSetupListener
extends DSIListener {
    public void updateAdbState(int var1, int var2);

    public void updateSortOrder(int var1, int var2);

    public void updatePictureVisibility(boolean var1, int var2);

    public void setLanguageResult(int var1);

    public void setSortOrderResult(int var1);

    public void setPublicProfileVisibilityResult(int var1);

    public void resetToFactorySettingsResult(int var1);

    public void resetTopDestinationResult(int var1);

    public void createBackupFileResult(int var1, String var2);

    public void importBackupFileResult(int var1, String var2);

    public void setPictureVisibilityResult(int var1);

    public void setContextSpecificVisibilityResult(int var1);

    public void updateContextSpecificVisibility(boolean var1, int var2);
}

