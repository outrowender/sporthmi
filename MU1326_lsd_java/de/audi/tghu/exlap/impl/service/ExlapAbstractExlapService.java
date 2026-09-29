/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapAbstractService;
import de.audi.tghu.exlap.ifc.listener.ExlapExlapListener;
import de.audi.tghu.exlap.ifc.service.ExlapExlapService;
import de.audi.tghu.exlap.impl.container.ContextStatesContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractExlapService$1;

public abstract class ExlapAbstractExlapService
extends ExlapAbstractService
implements ExlapExlapService,
ExlapExlapListener {
    @Override
    public void updateContextStates(ContextStatesContainer contextStatesContainer) {
        this.iterateListener(1, new ExlapAbstractExlapService$1(this, contextStatesContainer));
    }
}

