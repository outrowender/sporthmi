/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main;

import de.audi.app.addressbook.core.main.AbstractAddressBookApplication;
import de.audi.app.addressbook.core.main.commands.setup.SetLanguageCommand;
import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.i18n.I18NTarget;
import de.audi.atip.i18n.Language;

public class AddressBookHMIApplication
implements HMIApplication,
I18NTarget {
    private AbstractAddressBookApplication appAdr;

    public AddressBookHMIApplication(AbstractAddressBookApplication abstractAddressBookApplication) {
        this.appAdr = abstractAddressBookApplication;
    }

    @Override
    public int getId() {
        return 7;
    }

    @Override
    public ButtonModelApp getVirtualButton(int n) {
        return null;
    }

    @Override
    public void popupVisible(int n, int n2) {
    }

    @Override
    public void popupHidden(int n, int n2) {
    }

    @Override
    public void popupRemoved(int n, int n2) {
    }

    @Override
    public void screenVisible(int n, int n2) {
    }

    @Override
    public void screenHidden(int n, int n2) {
    }

    @Override
    public void screenFadedOut(int n, int n2) {
    }

    @Override
    public void screenConnected(int n, int n2) {
    }

    @Override
    public void setLanguage(Language language) {
        this.appAdr.getLog().log(1078071040, "AddressBookHMIApplication#setLanguage(): languageCode: %1", (Object)language.getLanguageCode());
        this.appAdr.setCurrentLanguageCode(language.getLanguageCode());
        if (this.appAdr.getAdbStateHandler().isAdbReady()) {
            SetLanguageCommand.createSetLanguageCommand(this.appAdr, language.getLanguageCode());
        }
    }
}

