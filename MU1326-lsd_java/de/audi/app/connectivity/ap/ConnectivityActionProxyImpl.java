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
    private static final int NO;
    private static final int YES;
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

    @Override
    public void connectivityBlueAbortInquiry(int n) {
        if (this.bluetooth == null) {
            return;
        }
        this.bluetooth.getLogChannel().log(1078071040, "ConnectivityActionProxyImpl#connectivityBlueAbortInquiry()");
        this.bluetooth.getEvoInquiry().abortInquiry(n);
    }

    @Override
    public void connectivityBluetoothBondingEntryAction(int n) {
        if (this.bluetooth == null) {
            return;
        }
        this.bluetooth.getLogChannel().log(1078071040, "ConnectivityActionProxyImpl#connectivityBluetoothBondingEntryAction()");
        this.bluetooth.getSecurity().securityEntryAction();
    }

    @Override
    public void connectivityBluetoothBondingExitAction(int n) {
        if (this.bluetooth == null) {
            return;
        }
        this.bluetooth.getLogChannel().log(1078071040, "ConnectivityActionProxyImpl#connectivityBluetoothBondingExitAction()");
        this.bluetooth.getSecurity().securityExitAction();
        this.bluetooth.getFramework().getHMIService().getChoiceModel(0x22262600).setValue(0);
    }

    @Override
    public void connectivityBluetoothBondingSpeedDisclaimerEntered(int n) {
        if (this.bluetooth == null) {
            return;
        }
        this.bluetooth.getLogChannel().log(1078071040, "ConnectivityActionProxyImpl#connectivityBluetoothBondingSpeedDisclaimerEntered()");
        this.bluetooth.getSecurity().speedDisclaimerEntered();
    }

    @Override
    public void connectivityBlueOfficeSetupExit(int n) {
        if (this.bluetooth != null) {
            this.bluetooth.getLogChannel().log(1078071040, "ConnectivityActionProxyImpl#connectivityBlueOfficeSetupExit()");
            this.bluetooth.getAudiConnectSetup().officeSetupLeft();
        }
    }

    @Override
    public void connectivityBlueApplicationContext(int n, int n2) {
        if (this.bluetooth != null) {
            this.bluetooth.getLogChannel().log(1078071040, "ConnectivityActionProxyImpl#connectivityBlueApplicationContext() %1", (long)n2);
        }
        ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(-1926879744);
        choiceModelApp.setValue(n2);
    }

    @Override
    public void connectivityCoMaApplicationContext(int n, int n2) {
        ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(-1624889856);
        choiceModelApp.setValue(n2);
    }

    @Override
    public void connectivityCoMaEntered(int n) {
        if (this.coma != null) {
            this.coma.connectivityManagerEntered();
        }
    }

    @Override
    public void connectivityBluetoothInstanceEntered(int n, int n2) {
        ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(-215603712);
        choiceModelApp.setValue(this.lastActiveBluetoothInstance == n2 ? 0 : 1);
        this.lastActiveBluetoothInstance = n2;
    }

    public void connectivityCoMaInstanceEntered(int n, int n2) {
    }

    @Override
    public void connectivityCoMaInstanceEnteredSetApplicationId(int n, int n2, int n3) {
        if (this.coma != null) {
            this.coma.getLogChannel().log(-2137614336, "ConnectivityActionProxyImpl#connectivityCoMaInstanceEnteredSetApplicationId(): instance %1, application %2", (long)n2, (long)n3);
            this.hmiService.getChoiceModel(-1138350592).setValue(this.lastActiveComaInstance == n2 ? 0 : 1);
            this.hmiService.getChoiceModel(-450484736).setValue(n3);
            this.lastActiveComaInstance = n2;
        }
    }

    @Override
    public void connectivitySetApplicationId(int n, int n2) {
        if (this.coma != null) {
            this.coma.getLogChannel().log(-2137614336, "ConnectivityActionProxyImpl#connectivitySetApplicationId(): terminalID %1, applicationId %2", (long)n, (long)n2);
            this.hmiService.getChoiceModel(-450484736).setValue(n2);
        }
    }

    @Override
    public void connectivityDataInstanceEntered(int n, int n2) {
        ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(-1071241728);
        choiceModelApp.setValue(this.lastActiveDataInstance == n2 ? 0 : 1);
        this.lastActiveDataInstance = n2;
    }

    @Override
    public void connectivityWlanInstanceEntered(int n, int n2) {
        ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(-1088018944);
        choiceModelApp.setValue(this.lastActiveWlanInstance == n2 ? 0 : 1);
        this.lastActiveWlanInstance = n2;
    }

    @Override
    public void connectivityDataApplicationContext(int n, int n2) {
        if (this.data != null) {
            this.data.getLogChannel().log(1078071040, "ConnectivityActionProxyImpl#connectivityDataApplicationContext() %1", (long)n2);
        }
        ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(-1708775936);
        choiceModelApp.setValue(n2);
    }

    @Override
    public void connectivityDataOnlineAppEntered(int n) {
        if (this.data == null) {
            return;
        }
        this.data.getLogChannel().log(1078071040, "ConnectivityActionProxyImpl#connectivityDataOnlineAppEntered()");
        this.data.getOnline().onlineAppEntered();
    }

    @Override
    public void connectivityDataOnlineAppLeft(int n) {
        if (this.data == null) {
            return;
        }
        this.data.getLogChannel().log(1078071040, "ConnectivityActionProxyImpl#connectivityDataOnlineAppLeft()");
        this.data.getOnline().onlineAppLeft();
    }

    @Override
    public void connectivityDataOnlineCheckEntered(int n) {
        if (this.data == null) {
            return;
        }
        this.data.getLogChannel().log(1078071040, "ConnectivityActionProxyImpl#connectivityDataOnlineCheckEntered()");
        this.data.getOnline().onlineCheckEntered();
    }

    @Override
    public void connectivityDataOnlineCheckLeft(int n) {
        if (this.data == null) {
            return;
        }
        this.data.getLogChannel().log(1078071040, "ConnectivityActionProxyImpl#connectivityDataOnlineCheckLeft()");
        this.data.getOnline().onlineCheckLeft();
    }

    @Override
    public void connectivityDataOnlinePopupEntered(int n) {
        if (this.data == null) {
            return;
        }
        this.data.getLogChannel().log(1078071040, "ConnectivityActionProxyImpl#connectivityDataOnlinePopupEntered()");
        this.hmiService.getChoiceModel(-1121573376).setValue(1);
        this.data.getOnline().onlinePopupEntered();
    }

    @Override
    public void connectivityDataOnlinePopupLeft(int n) {
        if (this.data == null) {
            return;
        }
        this.data.getLogChannel().log(1078071040, "ConnectivityActionProxyImpl#connectivityDataOnlinePopupLeft()");
        this.hmiService.getChoiceModel(-1121573376).setValue(0);
        this.data.getOnline().onlinePopupLeft();
    }

    @Override
    public void connectivityDataOnlineRequestEntered(int n, int n2) {
        if (this.data == null) {
            return;
        }
        this.data.getLogChannel().log(1078071040, "ConnectivityActionProxyImpl#connectivityDataOnlineRequestEntered(): %1", (long)n2);
        this.data.getOnline().onlineRequestEntered(n2);
    }

    @Override
    public void connectivityDataOnlineSetupLeft(int n) {
        if (this.data == null) {
            return;
        }
        this.data.getLogChannel().log(1078071040, "ConnectivityActionProxyImpl#connectivityDataOnlineSetupLeft()");
        this.data.getDataProfile().discardProfileEdits();
    }

    @Override
    public void connectivityDataOnlineSetupPhone(int n) {
        this.hmiService.getChoiceModel(-1742330368).setValue(0);
    }

    @Override
    public void connectivityDataOnlineSetupCoMa(int n) {
        this.hmiService.getChoiceModel(-1742330368).setValue(1);
    }

    @Override
    public void connectivityDataOnlineSetupOnlineError(int n) {
        this.hmiService.getChoiceModel(-1742330368).setValue(2);
    }

    @Override
    public void connectivityDataHkTelPressed(int n) {
        if (this.data == null) {
            return;
        }
        this.data.getLogChannel().log(1078071040, "ConnectivityActionProxyImpl#connectivityDataHkTelPressed()");
        this.data.getOnline().hkTelPressed();
    }

    @Override
    public void connectivityWlanAbortInquiry(int n) {
        if (this.wlan == null) {
            return;
        }
        this.wlan.getLogChannel().log(1078071040, "ConnectivityActionProxyImpl#connectivityWlanAbortInquiry()");
        this.wlan.getInquiry().abortInquiry();
    }

    @Override
    public void connectivityOpenSelectionDrawerByHKReturn(int n, int n2) {
        this.hmiService.getChoiceModel(271001088).setValue(n2);
    }

    @Override
    public void btBondingEntryPoint(int n, int n2) {
        this.hmiService.getChoiceModel(656877056).setValue(n2);
    }
}

