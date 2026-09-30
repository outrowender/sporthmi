/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.map;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.SatelliteMapsGUI;

public class SatelliteMapsGUIEVO
extends SatelliteMapsGUI {
    private static final int DATA_PROVIDER_CONCEPT = 1;

    public SatelliteMapsGUIEVO(NavigationEnv navigationEnv) {
        super(navigationEnv);
    }

    public void showFunctionCurrentlyNotAvailableHelpText() {
    }

    public void showFunctionCurrentlyNotAvailableHelpTextWithTimeout() {
    }

    public void redrawFunctionCurrentlyNotAvailableHelpTextWithTimeout() {
    }

    public void cleanUp() {
    }

    protected void setDynamicProviderIconConcept() {
        this.logger.log(10000000, "Setting Data Provider Icon Concept to %1", 1L);
        this.env.getChoiceModel(5624).setValue(1);
    }
}

