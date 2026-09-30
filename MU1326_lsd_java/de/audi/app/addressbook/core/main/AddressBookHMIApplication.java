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

    public int getId() {
        return 7;
    }

    public ButtonModelApp getVirtualButton(int n) {
        return null;
    }

    public void popupVisible(int n, int n2) {
    }

    public void popupHidden(int n, int n2) {
    }

    public void popupRemoved(int n, int n2) {
    }

    public void screenVisible(int n, int n2) {
    }

    public void screenHidden(int n, int n2) {
    }

    public void screenFadedOut(int n, int n2) {
    }

    public void screenConnected(int n, int n2) {
    }

    public void setLanguage(Language language) {
        this.appAdr.getLog().log(1000000, "AddressBookHMIApplication#setLanguage(): languageCode: %1", (Object)language.getLanguageCode());
        this.appAdr.setCurrentLanguageCode(language.getLanguageCode());
        if (this.appAdr.getAdbStateHandler().isAdbReady()) {
            SetLanguageCommand.createSetLanguageCommand(this.appAdr, language.getLanguageCode());
        }
    }
}

