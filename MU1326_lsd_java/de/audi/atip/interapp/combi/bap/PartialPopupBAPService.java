/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap;

import de.audi.atip.interapp.combi.bap.CombiBAPService;
import de.audi.atip.interapp.combi.bap.data.PartialPopupBAPContent;

public interface PartialPopupBAPService
extends CombiBAPService {
    default public void showPartialPopup(int n, PartialPopupBAPContent partialPopupBAPContent) {
    }

    default public void hidePartialPopup(int n) {
    }
}

