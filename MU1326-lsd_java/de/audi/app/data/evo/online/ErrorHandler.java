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

    @Override
    public void showPopup(int n, int n2) {
        this.log.log(1078071040, "ErrorHandler#showPopup(): Connectivity Online Check");
        this.dataApplication.getFramework().getHMIService().showPopup(-1541069312);
    }

    @Override
    public void showUnlockPopup() {
        this.log.log(1078071040, "ErrorHandler#showUnlockPopup(): Phone Unlock");
        this.dataApplication.getFramework().getHMIService().showPopup(-309132288);
    }
}

