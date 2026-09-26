/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.comfort;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.comfort.AbstractComfortInterappControlComponent;

public class ComfortInterappControlComponentEVO
extends AbstractComfortInterappControlComponent {
    public ComfortInterappControlComponentEVO(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    @Override
    public int getID() {
        return 55;
    }
}

