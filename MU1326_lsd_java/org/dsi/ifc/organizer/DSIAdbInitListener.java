/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

import org.dsi.ifc.base.DSIListener;

public interface DSIAdbInitListener
extends DSIListener {
    public void updateDefaultPublicProfileVisibility(boolean var1, int var2);

    public void updateMaxLocalEntries(int var1, int var2);

    public void updateMaxPhoneEntries(int var1, int var2);

    public void updateMaxTopDestEntries(int var1, int var2);

    public void updateMaxSpeedDialEntries(int var1, int var2);

    public void updateAutoProfileAllocation(boolean var1, int var2);

    public void setDefaultPublicProfileVisibilityResult(int var1);

    public void setMaxLocalEntriesResult(int var1);

    public void setMaxPhoneEntriesResult(int var1);

    public void setMaxTopDestEntriesResult(int var1);

    public void setMaxSpeedDialEntriesResult(int var1);

    public void setNumericalSpellerEnabledResult(int var1);

    public void setAutoProfileAllocationResult(int var1);

    public void setSpeedDialTypeResult(int var1);

    public void setProfileHandlingType(int var1);

    public void setDefaultSortOrderResult(int var1);

    public void setOnlineDestinationEnabledResult(int var1);

    public void setDefaultSOSButtonResult(int var1);

    public void updateDefaultSOSButton(boolean var1, int var2);
}

