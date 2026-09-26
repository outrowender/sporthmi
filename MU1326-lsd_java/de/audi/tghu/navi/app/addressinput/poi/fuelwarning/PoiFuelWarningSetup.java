/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.fuelwarning;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.fuelwarning.PoiFuelWarningSetup$FuelWarningState;
import de.audi.tghu.navi.app.util.Util;

public class PoiFuelWarningSetup {
    private static final int FUEL_WARNING_RECOMMENDATION_ON;
    private static final int FUEL_WARNING_RECOMMENDATION_OFF;
    private boolean fuelWarningActive;
    private final NavigationEnv env;
    private final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());

    public PoiFuelWarningSetup(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
        this.loadState(navigationEnv.getFramework().getStorageMgr(), navigationEnv.getLogChannel());
    }

    public final boolean isFuelWarningActive() {
        return this.fuelWarningActive;
    }

    private void doSetFuelWarningActive(boolean bl, boolean bl2) {
        this.fuelWarningActive = bl;
        this.doPersistFuelWarningActive();
    }

    public void setFuelWarningActive(boolean bl, boolean bl2) {
        this.doSetFuelWarningActive(bl, bl2);
    }

    public void persistFuelWarningActive() {
        this.doPersistFuelWarningActive();
    }

    private void doPersistFuelWarningActive() {
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        PoiFuelWarningSetup$FuelWarningState poiFuelWarningSetup$FuelWarningState = new PoiFuelWarningSetup$FuelWarningState(iStorageAccess, this.env.getLogChannel());
        poiFuelWarningSetup$FuelWarningState.setRecommendation(this.fuelWarningActive ? 0 : 1);
        poiFuelWarningSetup$FuelWarningState.serializeAndWrite();
    }

    public final void loadState(IStorageAccess iStorageAccess, LogChannel logChannel) {
        if (iStorageAccess == null) {
            logChannel.log(10000, "%1#loadState() - no storage manager available!!!", (Object)this.CLASS_NAME);
            return;
        }
        PoiFuelWarningSetup$FuelWarningState poiFuelWarningSetup$FuelWarningState = new PoiFuelWarningSetup$FuelWarningState(iStorageAccess, logChannel);
        poiFuelWarningSetup$FuelWarningState.readAndDeserialize();
        boolean bl = poiFuelWarningSetup$FuelWarningState.getRecommendation() != 1;
        this.doSetFuelWarningActive(bl, false);
    }

    void saveState(IStorageAccess iStorageAccess, LogChannel logChannel) {
        if (iStorageAccess == null) {
            logChannel.log(10000, "%1#saveState() - no storage manager available!!!", (Object)this.CLASS_NAME);
            return;
        }
        PoiFuelWarningSetup$FuelWarningState poiFuelWarningSetup$FuelWarningState = new PoiFuelWarningSetup$FuelWarningState(iStorageAccess, logChannel);
        int n = this.isFuelWarningActive() ? 0 : 1;
        poiFuelWarningSetup$FuelWarningState.setRecommendation(n);
        poiFuelWarningSetup$FuelWarningState.serializeAndWrite();
    }

    public void resetSettings() {
        this.env.getLogChannel().log(-2137614336, "%1#resetSettings() - reset FuelWarningActive - true", (Object)this.CLASS_NAME);
        this.setFuelWarningActive(true, true);
    }
}

