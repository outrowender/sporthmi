/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.actionproxy;

import de.audi.app.terminalmode.actionproxy.IActionProxyListener;
import de.audi.atip.log.LogChannel;
import java.util.Map;

public interface IActionProxyDispatcher {
    default public void addActionProxyListener(int n, int n2, IActionProxyListener iActionProxyListener) {
    }

    default public void removeActionProxyListener(int n, IActionProxyListener iActionProxyListener) {
    }

    default public void notifyActionProxyCall(int n, int n2, Map map) {
    }

    default public LogChannel getLogChannel() {
    }
}

