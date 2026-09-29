/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw;

import de.audi.app.bap.fw.AbstractBAPModule;

public interface IInitStateListener {
    default public void updateInitState(AbstractBAPModule abstractBAPModule, int n) {
    }
}

