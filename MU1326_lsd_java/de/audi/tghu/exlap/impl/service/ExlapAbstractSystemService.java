/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapAbstractService;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapSystemListener;
import de.audi.tghu.exlap.ifc.service.ExlapSystemService;
import de.audi.tghu.exlap.impl.container.EncodedVehicleTypeContainer;
import de.audi.tghu.exlap.impl.container.LanguageInfoContainer;
import de.audi.tghu.exlap.impl.container.SkinInfoContainer;
import de.audi.tghu.exlap.impl.container.UnitDistanceContainer;

public abstract class ExlapAbstractSystemService
extends ExlapAbstractService
implements ExlapSystemService,
ExlapSystemListener {
    public void updateSkinInfo(final SkinInfoContainer skinInfoContainer) {
        this.iterateListener(5, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapSystemListener)exlapListener).updateSkinInfo(skinInfoContainer);
            }
        });
    }

    public void updateLanguageInfo(final LanguageInfoContainer languageInfoContainer) {
        this.iterateListener(6, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapSystemListener)exlapListener).updateLanguageInfo(languageInfoContainer);
            }
        });
    }

    public void updateUnitDistance(final UnitDistanceContainer unitDistanceContainer) {
        this.iterateListener(13, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapSystemListener)exlapListener).updateUnitDistance(unitDistanceContainer);
            }
        });
    }

    public void updateEncodedVehicleType(final EncodedVehicleTypeContainer encodedVehicleTypeContainer) {
        this.iterateListener(51, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapSystemListener)exlapListener).updateEncodedVehicleType(encodedVehicleTypeContainer);
            }
        });
    }
}

