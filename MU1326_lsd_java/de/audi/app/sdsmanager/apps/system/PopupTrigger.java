/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system;

import de.audi.app.sdsmanager.apps.system.PopupStrategy;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;

public class PopupTrigger
implements PopupStrategy {
    private final ISDSPopupHelper popupHelper;
    private final int popupMappingID;
    private final boolean show;

    public PopupTrigger(ISDSPopupHelper iSDSPopupHelper, int n, boolean bl) {
        this.popupHelper = iSDSPopupHelper;
        this.popupMappingID = n;
        this.show = bl;
    }

    @Override
    public void triggerPopup() {
        this.popupHelper.triggerHapticalPopup(this.popupMappingID, this.show);
    }
}

