/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.addressbook.sm;

import de.audi.atip.activator.AbstractSMMActivator;
import de.audi.tghu.addressbook.sm.AddressBookSMM;
import de.audi.tghu.addressbook.sm.AddressBookSMMActions;

public class Activator
extends AbstractSMMActivator {
    public void init() {
        this.smmList = new AddressBookSMM[8];
        if (this.framework.isFrontMU()) {
            this.smmList[0] = new AddressBookSMM(this.framework, 0, "main");
            if (this.framework.isDualView()) {
                this.smmList[2] = new AddressBookSMM(this.framework, 2, "frontPassenger");
            }
        } else {
            this.smmList[3] = new AddressBookSMM(this.framework, 3, "rearSeatLeft");
            this.smmList[4] = new AddressBookSMM(this.framework, 4, "rearSeatRight");
        }
        this.reqActionProxies = AddressBookSMMActions.REQUIRED_ACTION_PROXY_MODULE_IDS;
    }
}

