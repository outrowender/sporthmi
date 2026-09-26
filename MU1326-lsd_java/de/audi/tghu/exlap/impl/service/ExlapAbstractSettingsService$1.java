/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapSettingsListener;
import de.audi.tghu.exlap.impl.container.ExlapRestrictionModeContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractSettingsService;

class ExlapAbstractSettingsService$1
implements ListenerIterator {
    private final /* synthetic */ ExlapRestrictionModeContainer val$exlapRestrictionModeProperty;
    private final /* synthetic */ ExlapAbstractSettingsService this$0;

    ExlapAbstractSettingsService$1(ExlapAbstractSettingsService exlapAbstractSettingsService, ExlapRestrictionModeContainer exlapRestrictionModeContainer) {
        this.this$0 = exlapAbstractSettingsService;
        this.val$exlapRestrictionModeProperty = exlapRestrictionModeContainer;
    }

    @Override
    public void processListener(ExlapListener exlapListener) {
        ((ExlapSettingsListener)exlapListener).updateExlapRestrictionMode(this.val$exlapRestrictionModeProperty);
    }
}

