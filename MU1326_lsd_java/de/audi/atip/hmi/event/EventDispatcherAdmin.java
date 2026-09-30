/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.esolutions.fw.util.commons.job.IJobFilter;
import java.io.PrintStream;

public interface EventDispatcherAdmin {
    public boolean isUserInteraction(Object var1);

    public void blockScreenChangeDisturbingEvents();

    public void unBlockScreenChangeDisturbingEvents();

    public void blockHardkeys();

    public void unBlockHardkeys();

    public void lockUsage();

    public void unlockUsage();

    public void setKombiSyncFocus(int var1);

    public void addEventFilter(IJobFilter var1);

    public void removeEventFilter(IJobFilter var1);

    public void setPriority(int var1);

    public String[] getStatisticData();

    public void dumpEventQueue(PrintStream var1);

    public void dump(PrintStream var1);
}

