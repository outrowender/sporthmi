/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.comm;

import de.esolutions.fw.comm.core.IServiceWorker;

public interface IDSIServiceWorker
extends IServiceWorker {
    public void start();

    public void stop();

    public int getUseCount();

    public String getName();
}

