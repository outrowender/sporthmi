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
    public void updateSkinInfo(SkinInfoContainer var1);

    public void updateLanguageInfo(LanguageInfoContainer var1);

    public void updateUnitDistance(UnitDistanceContainer var1);

    public void updateEncodedVehicleType(EncodedVehicleTypeContainer var1);
}

