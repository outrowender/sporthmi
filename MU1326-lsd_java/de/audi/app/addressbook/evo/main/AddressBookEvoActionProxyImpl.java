/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.evo.main;

import de.audi.app.addressbook.core.main.AbstractAddressBookApplication;
import de.audi.app.addressbook.core.main.AddressBookActionProxyImpl;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.ap.AdrActionProxy;

public class AddressBookEvoActionProxyImpl
extends AddressBookActionProxyImpl
implements AdrActionProxy {
    public AddressBookEvoActionProxyImpl(LogChannel logChannel, AbstractAddressBookApplication abstractAddressBookApplication) {
        super(logChannel, abstractAddressBookApplication);
    }
}

