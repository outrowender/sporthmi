/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core;

import de.audi.app.ecall.core.IOpenClosePopupHandler;

public interface ISOSOpenClosePopupHandler
extends IOpenClosePopupHandler {
    default public void forceSOSScreenShowing(int n) {
    }

    default public void showLicencePopup() {
    }
}

