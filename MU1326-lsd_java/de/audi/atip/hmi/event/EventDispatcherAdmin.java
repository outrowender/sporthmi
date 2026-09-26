/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.esolutions.fw.util.commons.job.IJobFilter;
import java.io.PrintStream;

public interface EventDispatcherAdmin {
    default public boolean isUserInteraction(Object object) {
    }

    default public void blockScreenChangeDisturbingEvents() {
    }

    default public void unBlockScreenChangeDisturbingEvents() {
    }

    default public void blockHardkeys() {
    }

    default public void unBlockHardkeys() {
    }

    default public void lockUsage() {
    }

    default public void unlockUsage() {
    }

    default public void setKombiSyncFocus(int n) {
    }

    default public void addEventFilter(IJobFilter iJobFilter) {
    }

    default public void removeEventFilter(IJobFilter iJobFilter) {
    }

    default public void setPriority(int n) {
    }

    default public String[] getStatisticData() {
    }

    default public void dumpEventQueue(PrintStream printStream) {
    }

    default public void dump(PrintStream printStream) {
    }
}

