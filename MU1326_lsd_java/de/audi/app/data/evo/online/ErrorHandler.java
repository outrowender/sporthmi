/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.evo.online;

import de.audi.app.data.core.IDataApplication;
import de.audi.app.data.core.online.AbstractErrorHandler;

public class ErrorHandler
extends AbstractErrorHandler {
    public ErrorHandler(IDataApplication iDataApplication) {
        super(iDataApplication);
    }

    public void showPopup(int n, int n2) {
        this.log.log(1000000, "ErrorHandler#showPopup(): Connectivity Online Check");
        this.dataApplication.getFramework().getHMIService().showPopup(2500004);
    }

    public void showUnlockPopup() {
        this.log.log(1000000, "ErrorHandler#showUnlockPopup(): Phone Unlock");
        this.dataApplication.getFramework().getHMIService().showPopup(300013);
    }
}

