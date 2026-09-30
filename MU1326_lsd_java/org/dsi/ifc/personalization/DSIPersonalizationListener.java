/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.personalization;

import org.dsi.ifc.base.DSIListener;

public interface DSIPersonalizationListener
extends DSIListener {
    public void copyProfile(int var1, int var2);

    public void resetProfile(int var1);

    public void resetAllProfiles();
}

