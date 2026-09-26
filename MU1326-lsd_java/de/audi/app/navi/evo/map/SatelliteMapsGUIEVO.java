/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.map;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.SatelliteMapsGUI;

public class SatelliteMapsGUIEVO
extends SatelliteMapsGUI {
    private static final int DATA_PROVIDER_CONCEPT;

    public SatelliteMapsGUIEVO(NavigationEnv navigationEnv) {
        super(navigationEnv);
    }

    @Override
    public void showFunctionCurrentlyNotAvailableHelpText() {
    }

    @Override
    public void showFunctionCurrentlyNotAvailableHelpTextWithTimeout() {
    }

    @Override
    public void redrawFunctionCurrentlyNotAvailableHelpTextWithTimeout() {
    }

    @Override
    public void cleanUp() {
    }

    @Override
    protected void setDynamicProviderIconConcept() {
        this.logger.log(-2137614336, "Setting Data Provider Icon Concept to %1", 1L);
        this.env.getChoiceModel(5624).setValue(1);
    }
}

