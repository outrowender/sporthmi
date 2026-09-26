/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import de.audi.app.car.core.hybrid.IMemoryBufferEntry;
import de.audi.app.car.core.hybrid.StatisticsLongTermEntry;
import de.audi.app.car.core.hybrid.StatisticsShortTermEntry;
import de.audi.app.car.core.hybrid.StatisticsZeroEmissionEntry;

public final class HybridStatisticsTypeFactory {
    static /* synthetic */ Class class$de$audi$app$car$core$hybrid$StatisticsShortTermEntry;
    static /* synthetic */ Class class$de$audi$app$car$core$hybrid$StatisticsLongTermEntry;
    static /* synthetic */ Class class$de$audi$app$car$core$hybrid$StatisticsZeroEmissionEntry;

    public static IMemoryBufferEntry create(int n) {
        IMemoryBufferEntry iMemoryBufferEntry;
        switch (n) {
            case 0: {
                iMemoryBufferEntry = new StatisticsShortTermEntry();
                break;
            }
            case 1: {
                iMemoryBufferEntry = new StatisticsLongTermEntry();
                break;
            }
            case 2: {
                iMemoryBufferEntry = new StatisticsZeroEmissionEntry();
                break;
            }
            default: {
                iMemoryBufferEntry = null;
            }
        }
        return iMemoryBufferEntry;
    }

    public static IMemoryBufferEntry[] create(int n, int n2) {
        IMemoryBufferEntry[] iMemoryBufferEntryArray;
        switch (n) {
            case 0: {
                iMemoryBufferEntryArray = new StatisticsShortTermEntry[n2];
                break;
            }
            case 1: {
                iMemoryBufferEntryArray = new StatisticsLongTermEntry[n2];
                break;
            }
            case 2: {
                iMemoryBufferEntryArray = new StatisticsZeroEmissionEntry[n2];
                break;
            }
            default: {
                iMemoryBufferEntryArray = null;
            }
        }
        return iMemoryBufferEntryArray;
    }

    public static boolean isSupported(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: {
                return true;
            }
        }
        return false;
    }

    public static String getEntryClassName(int n) {
        switch (n) {
            case 0: {
                return (class$de$audi$app$car$core$hybrid$StatisticsShortTermEntry == null ? (class$de$audi$app$car$core$hybrid$StatisticsShortTermEntry = HybridStatisticsTypeFactory.class$("de.audi.app.car.core.hybrid.StatisticsShortTermEntry")) : class$de$audi$app$car$core$hybrid$StatisticsShortTermEntry).getName();
            }
            case 1: {
                return (class$de$audi$app$car$core$hybrid$StatisticsLongTermEntry == null ? (class$de$audi$app$car$core$hybrid$StatisticsLongTermEntry = HybridStatisticsTypeFactory.class$("de.audi.app.car.core.hybrid.StatisticsLongTermEntry")) : class$de$audi$app$car$core$hybrid$StatisticsLongTermEntry).getName();
            }
            case 2: {
                return (class$de$audi$app$car$core$hybrid$StatisticsZeroEmissionEntry == null ? (class$de$audi$app$car$core$hybrid$StatisticsZeroEmissionEntry = HybridStatisticsTypeFactory.class$("de.audi.app.car.core.hybrid.StatisticsZeroEmissionEntry")) : class$de$audi$app$car$core$hybrid$StatisticsZeroEmissionEntry).getName();
            }
        }
        return null;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

