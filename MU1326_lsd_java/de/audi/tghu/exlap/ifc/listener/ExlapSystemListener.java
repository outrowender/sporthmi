/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.ifc.listener;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.impl.container.EncodedVehicleTypeContainer;
import de.audi.tghu.exlap.impl.container.LanguageInfoContainer;
import de.audi.tghu.exlap.impl.container.SkinInfoContainer;
import de.audi.tghu.exlap.impl.container.UnitDistanceContainer;

public interface ExlapSystemListener
extends ExlapListener {
    default public void updateSkinInfo(SkinInfoContainer skinInfoContainer) {
    }

    default public void updateLanguageInfo(LanguageInfoContainer languageInfoContainer) {
    }

    default public void updateUnitDistance(UnitDistanceContainer unitDistanceContainer) {
    }

    default public void updateEncodedVehicleType(EncodedVehicleTypeContainer encodedVehicleTypeContainer) {
    }
}

