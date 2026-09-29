/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.listener;

import de.audi.tghu.exlap.ifc.listener.ExlapSystemListener;
import de.audi.tghu.exlap.impl.container.EncodedVehicleTypeContainer;
import de.audi.tghu.exlap.impl.container.LanguageInfoContainer;
import de.audi.tghu.exlap.impl.container.SkinInfoContainer;
import de.audi.tghu.exlap.impl.container.UnitDistanceContainer;

public class ExlapSystemEmptyListener
implements ExlapSystemListener {
    @Override
    public void updateSkinInfo(SkinInfoContainer skinInfoContainer) {
    }

    @Override
    public void updateLanguageInfo(LanguageInfoContainer languageInfoContainer) {
    }

    @Override
    public void updateUnitDistance(UnitDistanceContainer unitDistanceContainer) {
    }

    @Override
    public void updateEncodedVehicleType(EncodedVehicleTypeContainer encodedVehicleTypeContainer) {
    }
}

