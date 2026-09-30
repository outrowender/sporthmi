/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap;

import de.audi.atip.interapp.combi.bap.CombiBAPServiceListener;

public interface PartialPopupBAPServiceListener
extends CombiBAPServiceListener {
    public void notifyPartialPopupVisible();

    public void notifyPartialPopupHidden();

    public void optionSelected(int var1, int var2);

    public void cancelPopup(int var1);
}

