/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.uni.UnifiedStationExt;

public interface IPSFreezeDB {
    public void add(AMFMStation var1);

    public void remove(AMFMStation var1);

    public String getFreezedName(AMFMStation var1);

    public String getFreezedName(UnifiedStationExt var1);

    public void removeAll();
}

