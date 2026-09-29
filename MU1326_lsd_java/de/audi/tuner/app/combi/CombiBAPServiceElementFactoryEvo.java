/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.combi;

import de.audi.tuner.app.combi.CombiBAPServiceElementBuilderAMFMEvo;
import de.audi.tuner.ifc.ICombiBAPServiceElementBuilderAMFM;
import de.audi.tuner.ifc.ICombiBAPServiceElementFactory;

public class CombiBAPServiceElementFactoryEvo
implements ICombiBAPServiceElementFactory {
    private CombiBAPServiceElementBuilderAMFMEvo amfmFactory = new CombiBAPServiceElementBuilderAMFMEvo();

    @Override
    public ICombiBAPServiceElementBuilderAMFM getServiceElementFactoryAMFM() {
        return this.amfmFactory;
    }
}

