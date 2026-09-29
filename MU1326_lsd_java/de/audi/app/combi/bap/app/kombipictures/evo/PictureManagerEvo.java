/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.kombipictures.evo;

import de.audi.app.combi.bap.app.kombipictures.AbstractPictureManager;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIImageConstantsSystem;

public class PictureManagerEvo
extends AbstractPictureManager {
    public PictureManagerEvo(IFrameworkAccess iFrameworkAccess) {
        super(iFrameworkAccess);
    }

    @Override
    protected int getDefaultPictureImageID(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = HMIImageConstantsSystem.kombiDefaultPicture_CoverArt;
                break;
            }
            case 1: {
                n2 = HMIImageConstantsSystem.kombiDefaultPicture_StationArt;
                break;
            }
            case 2: {
                n2 = HMIImageConstantsSystem.kombiDefaultPicture_ActiveCall;
                break;
            }
            case 21: {
                n2 = HMIImageConstantsSystem.kombiDefaultPicture_ActiveCall_Conference;
                break;
            }
            case 3: {
                n2 = HMIImageConstantsSystem.kombiDefaultPicture_AdressbookContact;
                break;
            }
            default: {
                n2 = -1;
            }
        }
        return n2;
    }
}

