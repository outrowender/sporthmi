/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapAbstractService;
import de.audi.tghu.exlap.ifc.listener.ExlapSystemListener;
import de.audi.tghu.exlap.ifc.service.ExlapSystemService;
import de.audi.tghu.exlap.impl.container.EncodedVehicleTypeContainer;
import de.audi.tghu.exlap.impl.container.LanguageInfoContainer;
import de.audi.tghu.exlap.impl.container.SkinInfoContainer;
import de.audi.tghu.exlap.impl.container.UnitDistanceContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractSystemService$1;
import de.audi.tghu.exlap.impl.service.ExlapAbstractSystemService$2;
import de.audi.tghu.exlap.impl.service.ExlapAbstractSystemService$3;
import de.audi.tghu.exlap.impl.service.ExlapAbstractSystemService$4;

public abstract class ExlapAbstractSystemService
extends ExlapAbstractService
implements ExlapSystemService,
ExlapSystemListener {
    @Override
    public void updateSkinInfo(SkinInfoContainer skinInfoContainer) {
        this.iterateListener(5, new ExlapAbstractSystemService$1(this, skinInfoContainer));
    }

    @Override
    public void updateLanguageInfo(LanguageInfoContainer languageInfoContainer) {
        this.iterateListener(6, new ExlapAbstractSystemService$2(this, languageInfoContainer));
    }

    @Override
    public void updateUnitDistance(UnitDistanceContainer unitDistanceContainer) {
        this.iterateListener(13, new ExlapAbstractSystemService$3(this, unitDistanceContainer));
    }

    @Override
    public void updateEncodedVehicleType(EncodedVehicleTypeContainer encodedVehicleTypeContainer) {
        this.iterateListener(51, new ExlapAbstractSystemService$4(this, encodedVehicleTypeContainer));
    }
}

