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

    @Override
    public String getText(int n) {
        switch (n) {
            case 0: {
                return this.hmiService.getText(-1902640128);
            }
            case 3: {
                return this.hmiService.getText(-2137521152);
            }
            case 1: {
                return this.hmiService.getText(-2120743936);
            }
            case 4: {
                return this.hmiService.getText(2123891712);
            }
            case 2: {
                return this.hmiService.getText(2140668928);
            }
            case 5: {
                return this.hmiService.getText(10290176);
            }
            case 7: {
                return this.hmiService.getText(-6552576);
            }
            case 6: {
                return this.hmiService.getText(27067392);
            }
            case 8: {
                return this.hmiService.getText(597230592);
            }
            case 9: {
                return this.hmiService.getText(312280064);
            }
            case 10: {
                return this.hmiService.getText(329057280);
            }
            case 11: {
                return this.hmiService.getText(345834496);
            }
            case 12: {
                return this.hmiService.getText(362611712);
            }
            case 13: {
                return this.hmiService.getText(496829440);
            }
        }
        return "";
    }
}

