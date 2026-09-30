/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.util;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.emergency.IEmergencyTextFactory;
import de.audi.atip.hmi.IHMIServiceApp;

public class EvoKoreaEmergencyTextFactory
implements IEmergencyTextFactory {
    private static final String[] KOREA_SOS_NUMBERS = new String[]{"111", "112", "113", "117", "118", "119", "122", "125", "127"};
    private static final int[] KOREA_SOS_NUMBERS_IDS = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    private IHMIServiceApp hmiService;

    public EvoKoreaEmergencyTextFactory(ITelApplication iTelApplication) {
        this.hmiService = iTelApplication.getFrameworkAccess().getHmiServiceApp();
    }

    public String getText(int n) {
        String string = "";
        switch (n) {
            case 1: {
                string = this.hmiService.getText(302825);
                break;
            }
            case 2: {
                string = this.hmiService.getText(302826);
                break;
            }
            case 3: {
                string = this.hmiService.getText(302827);
                break;
            }
            case 4: {
                string = this.hmiService.getText(302828);
                break;
            }
            case 5: {
                string = this.hmiService.getText(302829);
                break;
            }
            case 6: {
                string = this.hmiService.getText(302830);
                break;
            }
            case 7: {
                string = this.hmiService.getText(302831);
                break;
            }
            case 8: {
                string = this.hmiService.getText(302832);
                break;
            }
            case 9: {
                string = this.hmiService.getText(302833);
                break;
            }
            case 0: {
                string = this.hmiService.getText(301182);
                break;
            }
            default: {
                string = this.hmiService.getText(301182);
            }
        }
        return string;
    }

    public String[] getEmergencyNumbers() {
        return KOREA_SOS_NUMBERS;
    }

    public int[] getEmergencyNumbersIDs() {
        return KOREA_SOS_NUMBERS_IDS;
    }
}

