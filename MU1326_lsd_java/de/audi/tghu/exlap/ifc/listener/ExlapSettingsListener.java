/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.ifc.listener;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.impl.container.ExlapRestrictionModeContainer;

public interface ExlapSettingsListener
extends ExlapListener {
    public void updateExlapRestrictionMode(ExlapRestrictionModeContainer var1);
}

