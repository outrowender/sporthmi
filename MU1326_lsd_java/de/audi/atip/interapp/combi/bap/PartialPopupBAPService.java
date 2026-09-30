/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap;

import de.audi.atip.interapp.combi.bap.CombiBAPService;
import de.audi.atip.interapp.combi.bap.data.PartialPopupBAPContent;

public interface PartialPopupBAPService
extends CombiBAPService {
    public void showPartialPopup(int var1, PartialPopupBAPContent var2);

    public void hidePartialPopup(int var1);
}

