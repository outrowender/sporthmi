/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.telephone.TelBAPManagerTel1;
import de.audi.app.phone.core.bap.telephone2.TelBAPManagerTel2;

public class TelBAPManager
extends AbstractPhoneComponent {
    public TelBAPManager(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.BAP");
        this.addSubPhoneComponent(new TelBAPManagerTel1(iTelApplication, "App.Phone.BAP"));
        this.addSubPhoneComponent(new TelBAPManagerTel2(iTelApplication, "App.Phone.BAP"));
    }
}

