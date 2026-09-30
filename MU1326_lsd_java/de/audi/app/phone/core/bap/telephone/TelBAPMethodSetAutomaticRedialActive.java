/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.telephone.AbstractTel1BAPMethodHandler;
import de.esolutions.fw.util.commons.job.DispatcherBase;

class TelBAPMethodSetAutomaticRedialActive
extends AbstractTel1BAPMethodHandler {
    TelBAPMethodSetAutomaticRedialActive(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    void setAutomaticRedialActive(boolean bl) {
        this.log.log(100000, "[TelBAPMethodSetAutomaticRedialActive#setAutomaticRedialActive] NOP!");
    }
}

