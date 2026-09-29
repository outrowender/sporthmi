/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sds;

import de.audi.tghu.navi.app.sds.ISDSStateObserver;

public interface ISDSStateEventsProvider {
    default public void registerListener(ISDSStateObserver iSDSStateObserver) {
    }
}

