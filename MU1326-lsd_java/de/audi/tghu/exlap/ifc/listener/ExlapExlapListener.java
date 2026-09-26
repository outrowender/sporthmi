/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.ifc.listener;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.impl.container.ContextStatesContainer;

public interface ExlapExlapListener
extends ExlapListener {
    default public void updateContextStates(ContextStatesContainer contextStatesContainer) {
    }
}

