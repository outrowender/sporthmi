/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.system;

import de.audi.app.system.AbstractAppManagerCore;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.ButtonListener;

public class AppManagerEvo
extends AbstractAppManagerCore
implements ButtonListener {
    public AppManagerEvo(IFrameworkAccess iFrameworkAccess) {
        super(iFrameworkAccess);
        this.initSMEvents(101, 102, 1485, 1484, 106, 1482, 151, 1525, 1557, 1539, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    @Override
    void handleHKSource(int n, int n2) {
    }

    @Override
    void handleHKOption(int n, int n2) {
    }

    @Override
    protected void handleHKNav(int n, int n2) {
        if (this.getFramework().isEvoHighMMIKombi() && this.getFramework().getSysConst(459) == 0) {
            this.getFramework().getHMIService().showPartialPopup(n, 113);
        } else {
            this.fireSMEvent(n, n2);
        }
    }
}

