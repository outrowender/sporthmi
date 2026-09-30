/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.ap;

import de.audi.app.bluetooth.evo.IEvoBluetoothApplication;
import de.audi.app.connectivity.manager.ConnectivityManager;
import de.audi.app.data.core.IDataApplication;
import de.audi.app.wlan.evo.IEvoWlanApplication;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.statemachine.ap.ConnectivityActionProxy;

public class ConnectivityActionProxyImpl
implements ConnectivityActionProxy {
    private final IEvoBluetoothApplication bluetooth;
    private final IDataApplication data;
    private final IEvoWlanApplication wlan;
    private final ConnectivityManager coma;
    private final IHMIServiceApp hmiService;
    private static final int NO = 0;
    private static final int YES = 1;
    private volatile int lastActiveBluetoothInstance = -1;
    private volatile int lastActiveComaInstance = -1;
    private volatile int lastActiveDataInstance = -1;
    private volatile int lastActiveWlanInstance = -1;

    public ConnectivityActionProxyImpl(IEvoBluetoothApplication iEvoBluetoothApplication, IEvoWlanApplication iEvoWlanApplication, IDataApplication iDataApplication, ConnectivityManager connectivityManager, IHMIServiceApp iHMIServiceApp) {
        this.bluetooth = iEvoBluetoothApplication;
        this.wlan = iEvoWlanApplication;
        this.data = iDataApplication;
        this.coma = connectivityManager;
        this.hmiService = iHMIServiceApp;
    }

    public void connectivityBlueAbortInquiry(int n) {
        if (this.bluetooth == null) {
            return;
        }
        this.bluetooth.getLogChannel().log(1000000, "ConnectivityActionProxyImpl#connectivityBlueAbortInquiry()");
        this.bluetooth.getEvoInquiry().abortInquiry(n);
    }

    public void connectivityBluetoothBondingEntryAction(int n) {
        if (this.bluetooth == null) {
            return;
        }
        this.bluetooth.getLogChannel().log(1000000, "ConnectivityActionProxyImpl#connectivityBluetoothBondingEntryAction()");
        this.bluetooth.getSecurity().securityEntryAction();
    }

    public void connectivityBluetoothBondingExitAction(int n) {
        if (this.bluetooth == null) {
            return;
        }
        this.bluetooth.getLogChannel().log(1000000, "ConnectivityActionProxyImpl#connectivityBluetoothBondingExitAction()");
        this.bluetooth.getSecurity().securityExitAction();
        this.bluetooth.getFramework().getHMIService().getChoiceModel(0x262622).setValue(0);
    }

    public void connectivityBluetoothBondingSpeedDisclaimerEntered(int n) {
        if (this.bluetooth == null) {
            return;
        }
        this.bluetooth.getLogChannel().log(1000000, "ConnectivityActionProxyImpl#connectivityBluetoothBondingSpeedDisclaimerEntered()");
        this.bluetooth.getSecurity().speedDisclaimerEntered();
    }

    public void connectivityBlueOfficeSetupExit(int n) {
        if (this.bluetooth != null) {
            this.bluetooth.getLogChannel().log(1000000, "ConnectivityActionProxyImpl#connectivityBlueOfficeSetupExit()");
            this.bluetooth.getAudiConnectSetup().officeSetupLeft();
        }
    }

    public void connectivityBlueApplicationContext(int n, int n2) {
        if (this.bluetooth != null) {
            this.bluetooth.getLogChannel().log(1000000, "ConnectivityActionProxyImpl#connectivityBlueApplicationContext() %1", (long)n2);
        }
        ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(2500237);
        choiceModelApp.setValue(n2);
    }

    public void connectivityCoMaApplicationContext(int n, int n2) {
        ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(2500255);
        choiceModelApp.setValue(n2);
    }

    public void connectivityCoMaEntered(int n) {
        if (this.coma != null) {
            this.coma.connectivityManagerEntered();
        }
    }

    public void connectivityBluetoothInstanceEntered(int n, int n2) {
        ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(2500339);
        choiceModelApp.setValue(this.lastActiveBluetoothInstance == n2 ? 0 : 1);
        this.lastActiveBluetoothInstance = n2;
    }

    public void connectivityCoMaInstanceEntered(int n, int n2) {
    }

    public void connectivityCoMaInstanceEnteredSetApplicationId(int n, int n2, int n3) {
        if (this.coma != null) {
            this.coma.getLogChannel().log(10000000, "ConnectivityActionProxyImpl#connectivityCoMaInstanceEnteredSetApplicationId(): instance %1, application %2", (long)n2, (long)n3);
            this.hmiService.getChoiceModel(2500284).setValue(this.lastActiveComaInstance == n2 ? 0 : 1);
            this.hmiService.getChoiceModel(2500325).setValue(n3);
            this.lastActiveComaInstance = n2;
        }
    }

    public void connectivitySetApplicationId(int n, int n2) {
        if (this.coma != null) {
            this.coma.getLogChannel().log(10000000, "ConnectivityActionProxyImpl#connectivitySetApplicationId(): terminalID %1, applicationId %2", (long)n, (long)n2);
            this.hmiService.getChoiceModel(2500325).setValue(n2);
        }
    }

    public void connectivityDataInstanceEntered(int n, int n2) {
        ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(2500288);
        choiceModelApp.setValue(this.lastActiveDataInstance == n2 ? 0 : 1);
        this.lastActiveDataInstance = n2;
    }

    public void connectivityWlanInstanceEntered(int n, int n2) {
        ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(2500287);
        choiceModelApp.setValue(this.lastActiveWlanInstance == n2 ? 0 : 1);
        this.lastActiveWlanInstance = n2;
    }

    public void connectivityDataApplicationContext(int n, int n2) {
        if (this.data != null) {
            this.data.getLogChannel().log(1000000, "ConnectivityActionProxyImpl#connectivityDataApplicationContext() %1", (long)n2);
        }
        ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(2500250);
        choiceModelApp.setValue(n2);
    }

    public void connectivityDataOnlineAppEntered(int n) {
        if (this.data == null) {
            return;
        }
        this.data.getLogChannel().log(1000000, "ConnectivityActionProxyImpl#connectivityDataOnlineAppEntered()");
        this.data.getOnline().onlineAppEntered();
    }

    public void connectivityDataOnlineAppLeft(int n) {
        if (this.data == null) {
            return;
        }
        this.data.getLogChannel().log(1000000, "ConnectivityActionProxyImpl#connectivityDataOnlineAppLeft()");
        this.data.getOnline().onlineAppLeft();
    }

    public void connectivityDataOnlineCheckEntered(int n) {
        if (this.data == null) {
            return;
        }
        this.data.getLogChannel().log(1000000, "ConnectivityActionProxyImpl#connectivityDataOnlineCheckEntered()");
        this.data.getOnline().onlineCheckEntered();
    }

    public void connectivityDataOnlineCheckLeft(int n) {
        if (this.data == null) {
            return;
        }
        this.data.getLogChannel().log(1000000, "ConnectivityActionProxyImpl#connectivityDataOnlineCheckLeft()");
        this.data.getOnline().onlineCheckLeft();
    }

    public void connectivityDataOnlinePopupEntered(int n) {
        if (this.data == null) {
            return;
        }
        this.data.getLogChannel().log(1000000, "ConnectivityActionProxyImpl#connectivityDataOnlinePopupEntered()");
        this.hmiService.getChoiceModel(2500285).setValue(1);
        this.data.getOnline().onlinePopupEntered();
    }

    public void connectivityDataOnlinePopupLeft(int n) {
        if (this.data == null) {
            return;
        }
        this.data.getLogChannel().log(1000000, "ConnectivityActionProxyImpl#connectivityDataOnlinePopupLeft()");
        this.hmiService.getChoiceModel(2500285).setValue(0);
        this.data.getOnline().onlinePopupLeft();
    }

    public void connectivityDataOnlineRequestEntered(int n, int n2) {
        if (this.data == null) {
            return;
        }
        this.data.getLogChannel().log(1000000, "ConnectivityActionProxyImpl#connectivityDataOnlineRequestEntered(): %1", (long)n2);
        this.data.getOnline().onlineRequestEntered(n2);
    }

    public void connectivityDataOnlineSetupLeft(int n) {
        if (this.data == null) {
            return;
        }
        this.data.getLogChannel().log(1000000, "ConnectivityActionProxyImpl#connectivityDataOnlineSetupLeft()");
        this.data.getDataProfile().discardProfileEdits();
    }

    public void connectivityDataOnlineSetupPhone(int n) {
        this.hmiService.getChoiceModel(2500248).setValue(0);
    }

    public void connectivityDataOnlineSetupCoMa(int n) {
        this.hmiService.getChoiceModel(2500248).setValue(1);
    }

    public void connectivityDataOnlineSetupOnlineError(int n) {
        this.hmiService.getChoiceModel(2500248).setValue(2);
    }

    public void connectivityDataHkTelPressed(int n) {
        if (this.data == null) {
            return;
        }
        this.data.getLogChannel().log(1000000, "ConnectivityActionProxyImpl#connectivityDataHkTelPressed()");
        this.data.getOnline().hkTelPressed();
    }

    public void connectivityWlanAbortInquiry(int n) {
        if (this.wlan == null) {
            return;
        }
        this.wlan.getLogChannel().log(1000000, "ConnectivityActionProxyImpl#connectivityWlanAbortInquiry()");
        this.wlan.getInquiry().abortInquiry();
    }

    public void connectivityOpenSelectionDrawerByHKReturn(int n, int n2) {
        this.hmiService.getChoiceModel(2500368).setValue(n2);
    }

    public void btBondingEntryPoint(int n, int n2) {
        this.hmiService.getChoiceModel(0x262727).setValue(n2);
    }
}

