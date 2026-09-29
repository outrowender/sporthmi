/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import org.dsi.ifc.sdars.SeekEntry;

interface IEnrichedSeekAlertListener {
    default public void alertStarted(int n, int n2, SeekEntry seekEntry) {
    }

    default public void alertStopped(int n, int n2) {
    }
}

