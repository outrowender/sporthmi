/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ITelTextFactory;
import de.audi.atip.hmi.IHMIServiceApp;

public class TelEvoTextFactory
implements ITelTextFactory {
    private IHMIServiceApp hmiService;

    public TelEvoTextFactory(ITelApplication iTelApplication) {
        this.hmiService = iTelApplication.getFrameworkAccess().getHmiServiceApp();
    }

    public String getText(int n) {
        switch (n) {
            case 0: {
                return this.hmiService.getText(301198);
            }
            case 3: {
                return this.hmiService.getText(301184);
            }
            case 1: {
                return this.hmiService.getText(301185);
            }
            case 4: {
                return this.hmiService.getText(301182);
            }
            case 2: {
                return this.hmiService.getText(301183);
            }
            case 5: {
                return this.hmiService.getText(302336);
            }
            case 7: {
                return this.hmiService.getText(302335);
            }
            case 6: {
                return this.hmiService.getText(302337);
            }
            case 8: {
                return this.hmiService.getText(301347);
            }
            case 9: {
                return this.hmiService.getText(302354);
            }
            case 10: {
                return this.hmiService.getText(302355);
            }
            case 11: {
                return this.hmiService.getText(302356);
            }
            case 12: {
                return this.hmiService.getText(302357);
            }
            case 13: {
                return this.hmiService.getText(302365);
            }
        }
        return "";
    }
}

