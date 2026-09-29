/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.common;

import de.audi.app.sdsmanager.syscall.ISystemCall;

public interface SDSListener {
    default public void processCommand(ISystemCall iSystemCall) {
    }
}

