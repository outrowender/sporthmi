/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.hybrid;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.hybrid.AbstractAudiEnergyAssistComponent;

public class AudiEnergyAssistComponentEvo
extends AbstractAudiEnergyAssistComponent {
    public AudiEnergyAssistComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    @Override
    protected void initVisibility() {
    }

    @Override
    protected void deinitVisibility() {
    }

    @Override
    public int getID() {
        return 49;
    }
}

