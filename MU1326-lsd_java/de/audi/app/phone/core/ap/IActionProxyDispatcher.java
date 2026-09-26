/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.ap;

import de.audi.app.phone.core.ap.IActionProxyListener;
import de.audi.atip.log.LogChannel;
import java.util.Map;

public interface IActionProxyDispatcher {
    default public void init() {
    }

    default public void deinit() {
    }

    default public void addActionProxyListener(int n, IActionProxyListener iActionProxyListener) {
    }

    default public void removeActionProxyListener(int n, IActionProxyListener iActionProxyListener) {
    }

    default public void notifyActionProxyCall(int n, Map map) {
    }

    default public LogChannel getAPLogChannel() {
    }
}

