/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import org.dsi.ifc.sdars.SeekEntry;

interface IEnrichedSeekAlertListener {
    public void alertStarted(int var1, int var2, SeekEntry var3);

    public void alertStopped(int var1, int var2);
}

