/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap;

import de.audi.app.combi.bap.AbstractCombiBAPApplication;
import de.audi.app.combi.bap.app.kombipictures.IPictureManager;
import de.audi.app.combi.bap.app.kombipictures.NullPictureManager;
import de.audi.app.combi.bap.app.kombipictures.evo.PictureManagerEvo;
import de.audi.atip.base.IFrameworkAccess;

public class CombiBAPApplicationEvo
extends AbstractCombiBAPApplication {
    protected CombiBAPApplicationEvo(IFrameworkAccess iFrameworkAccess) {
        super(iFrameworkAccess);
    }

    protected IPictureManager createPictureManager(IFrameworkAccess iFrameworkAccess) {
        IPictureManager iPictureManager = iFrameworkAccess.getSysConst(523) == 1 ? new PictureManagerEvo(iFrameworkAccess) : new NullPictureManager();
        return iPictureManager;
    }
}

