/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.ap;

import de.audi.app.ecall.core.ap.IActionProxyListener;
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

    default public void notifyActionProxyCall(int n) {
    }

    default public LogChannel getAPLogChannel() {
    }
}

