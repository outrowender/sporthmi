/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap;

import de.audi.atip.interapp.combi.bap.CombiBAPServiceListener;

public interface PartialPopupBAPServiceListener
extends CombiBAPServiceListener {
    default public void notifyPartialPopupVisible() {
    }

    default public void notifyPartialPopupHidden() {
    }

    default public void optionSelected(int n, int n2) {
    }

    default public void cancelPopup(int n) {
    }
}

