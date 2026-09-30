/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapAbstractService;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapExlapListener;
import de.audi.tghu.exlap.ifc.service.ExlapExlapService;
import de.audi.tghu.exlap.impl.container.ContextStatesContainer;

public abstract class ExlapAbstractExlapService
extends ExlapAbstractService
implements ExlapExlapService,
ExlapExlapListener {
    public void updateContextStates(final ContextStatesContainer contextStatesContainer) {
        this.iterateListener(0x1000000, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapExlapListener)exlapListener).updateContextStates(contextStatesContainer);
            }
        });
    }
}

