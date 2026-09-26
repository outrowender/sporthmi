/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.tghu.navi.app.map.dsi.AbstractRequester;

public interface DSIStateChangeListener {
    default public void onOperabilityChanged(AbstractRequester abstractRequester) {
    }
}

