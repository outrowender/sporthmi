/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.addressbook.hmi;

import de.audi.atip.activator.AbstractHMIActivator;
import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.model.AddressBookModelBank;
import de.audi.tghu.addressbook.hmi.evohighscale.AddressBookConditionBank;
import de.audi.tghu.addressbook.hmi.evohighscale.AddressBookScreenFactory;

public class Activator
extends AbstractHMIActivator {
    private AddressBookScreenFactory instance = null;
    private AddressBookConditionBank conditionBank;

    public Activator() {
        super(7, "AddressBook", System.getProperty("variant.skin", "EvoHighScale"), new AddressBookModelBank());
    }

    @Override
    protected synchronized AbstractScreenFactory getScreenFactory() {
        if (this.instance == null) {
            this.instance = new AddressBookScreenFactory(this.getFramework());
        }
        return this.instance;
    }

    @Override
    public HMIConditionBank getConditionBank() {
        if (this.conditionBank == null) {
            this.conditionBank = new AddressBookConditionBank((AddressBookScreenFactory)this.getScreenFactory());
        }
        return this.conditionBank;
    }
}

