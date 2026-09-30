/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapAbstractService;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapSettingsListener;
import de.audi.tghu.exlap.ifc.service.ExlapSettingsService;
import de.audi.tghu.exlap.impl.container.ExlapRestrictionModeContainer;

public abstract class ExlapAbstractSettingsService
extends ExlapAbstractService
implements ExlapSettingsService,
ExlapSettingsListener {
    public void updateExlapRestrictionMode(final ExlapRestrictionModeContainer exlapRestrictionModeContainer) {
        this.iterateListener(30, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapSettingsListener)exlapListener).updateExlapRestrictionMode(exlapRestrictionModeContainer);
            }
        });
    }
}

