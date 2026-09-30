/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main;

import de.audi.app.addressbook.core.main.AbstractAddressBookApplication;
import de.audi.atip.log.LogChannel;

public class AddressBookActionProxyImpl {
    protected LogChannel log;
    protected AbstractAddressBookApplication appAdr;

    public AddressBookActionProxyImpl(LogChannel logChannel, AbstractAddressBookApplication abstractAddressBookApplication) {
        this.log = logChannel;
        this.appAdr = abstractAddressBookApplication;
    }

    public void adrEditNavEntered(int n) {
        this.log.log(10000000, "AddressBookActionProxyImpl#adrEditNavEntered(): terminalID: %1", (long)n);
        this.appAdr.getLocationInputHandler().adrEditNavEntered();
    }

    public void adrState(int n, int n2) {
        if (this.log.isInfo()) {
            String string;
            switch (n2) {
                case 1: {
                    string = "1 (ADR_ENTERED)";
                    break;
                }
                case 0: {
                    string = "0 (ADR_LEFT)";
                    break;
                }
                default: {
                    string = n2 + " (unknown)";
                }
            }
            this.log.log(1000000, "AddressBookActionProxyImpl#adrState(): state: %1, terminalID: %2", (Object)string, (long)n);
        }
    }

    public void adrEnteredViaSpeech(int n, int n2) {
        this.log.log(1000000, "AddressBookActionProxyImpl#adrEnteredViaSpeech(): mode: %1, terminalID: %2", (long)n2, (long)n);
        this.appAdr.loadMainList(n2);
    }

    public void adrImportListHKReturn(int n) {
        this.log.log(10000000, "AddressBookActionProxyImpl#adrImportListHKReturn(): terminalID: %1", (long)n);
        this.appAdr.getVCardExchangeADBHandler().oneFolderUp();
    }

    public void adrEnterPreviewMapScreen(int n, int n2, int n3) {
        this.log.log(10000000, "AddressBookActionProxyImpl#adrEnterPreviewMapScreen(): terminalID: %1, width: %2, height: %3", (long)n, (long)n2, (long)n3);
        this.appAdr.getNaviGateway().enterPreviewMap(n2, n3);
    }

    public void adrExitPreviewMapScreen(int n) {
        this.log.log(10000000, "AddressBookActionProxyImpl#adrExitPreviewMapScreen(): terminalID: %1", (long)n);
        this.appAdr.getNaviGateway().exitPreviewMap();
    }
}

