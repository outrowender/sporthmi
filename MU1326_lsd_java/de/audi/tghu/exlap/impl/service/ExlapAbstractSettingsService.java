/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapAbstractService;
import de.audi.tghu.exlap.ifc.listener.ExlapSettingsListener;
import de.audi.tghu.exlap.ifc.service.ExlapSettingsService;
import de.audi.tghu.exlap.impl.container.ExlapRestrictionModeContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractSettingsService$1;

public abstract class ExlapAbstractSettingsService
extends ExlapAbstractService
implements ExlapSettingsService,
ExlapSettingsListener {
    @Override
    public void updateExlapRestrictionMode(ExlapRestrictionModeContainer exlapRestrictionModeContainer) {
        this.iterateListener(30, new ExlapAbstractSettingsService$1(this, exlapRestrictionModeContainer));
    }
}

