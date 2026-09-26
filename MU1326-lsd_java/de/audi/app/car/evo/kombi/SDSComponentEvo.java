/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.kombi;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.kombi.AbstractSDSComponent;

public class SDSComponentEvo
extends AbstractSDSComponent {
    public SDSComponentEvo(ICarApplication iCarApplication) {
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
        return 42;
    }
}

