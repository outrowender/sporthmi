/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.settings.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.ap.ConnectivityActionProxy;
import de.audi.atip.statemachine.ap.CustDownloadActionProxy;
import de.audi.atip.statemachine.ap.FrameworkActionProxy;
import de.audi.atip.statemachine.ap.SettingsActionProxy;
import de.audi.atip.statemachine.ap.ToneActionProxy;
import java.util.NoSuchElementException;

public class SettingsSMMActions
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;
    private volatile SettingsActionProxy ap0;
    private volatile ConnectivityActionProxy ap1;
    private volatile FrameworkActionProxy ap2;
    private volatile CustDownloadActionProxy ap3;
    private volatile ToneActionProxy ap4;
    public static int[] REQUIRED_ACTION_PROXY_MODULE_IDS = new int[]{22, 4, 26, 16, 19};

    protected SettingsSMMActions(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    public void removeActionProxy(int n, ActionProxy actionProxy) {
        if (actionProxy instanceof CustDownloadActionProxy) {
            this.ap3 = null;
            this.logChannel.log(10000000, "CustDownloadActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof FrameworkActionProxy) {
            this.ap2 = null;
            this.logChannel.log(10000000, "FrameworkActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof ConnectivityActionProxy) {
            this.ap1 = null;
            this.logChannel.log(10000000, "ConnectivityActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof SettingsActionProxy) {
            this.ap0 = null;
            this.logChannel.log(10000000, "SettingsActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof ToneActionProxy) {
            this.ap4 = null;
            this.logChannel.log(10000000, "ToneActionProxy Action Proxy removed");
            return;
        }
    }

    public ActionProxy addActionProxy(int n, ActionProxy actionProxy) {
        if (actionProxy instanceof CustDownloadActionProxy) {
            this.ap3 = (CustDownloadActionProxy)actionProxy;
            this.logChannel.log(10000000, "CustDownloadActionProxy Action Proxy added");
            return this.ap3;
        }
        if (actionProxy instanceof FrameworkActionProxy) {
            this.ap2 = (FrameworkActionProxy)actionProxy;
            this.logChannel.log(10000000, "FrameworkActionProxy Action Proxy added");
            return this.ap2;
        }
        if (actionProxy instanceof ConnectivityActionProxy) {
            this.ap1 = (ConnectivityActionProxy)actionProxy;
            this.logChannel.log(10000000, "ConnectivityActionProxy Action Proxy added");
            return this.ap1;
        }
        if (actionProxy instanceof SettingsActionProxy) {
            this.ap0 = (SettingsActionProxy)actionProxy;
            this.logChannel.log(10000000, "SettingsActionProxy Action Proxy added");
            return this.ap0;
        }
        if (actionProxy instanceof ToneActionProxy) {
            this.ap4 = (ToneActionProxy)actionProxy;
            this.logChannel.log(10000000, "ToneActionProxy Action Proxy added");
            return this.ap4;
        }
        return null;
    }

    private void catchActionExceptionCustDownloadActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'CustDownloadActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1000000, "Action Proxy 'CustDownloadActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionFrameworkActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'FrameworkActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1000000, "Action Proxy 'FrameworkActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionConnectivityActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'ConnectivityActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1000000, "Action Proxy 'ConnectivityActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionSettingsActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'SettingsActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1000000, "Action Proxy 'SettingsActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionToneActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'ToneActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1000000, "Action Proxy 'ToneActionProxy' missing for call '%1'", (Object)string);
    }

    public void execFocusGainedAction(SMServices sMServices, int n) {
        switch (n) {
            default: 
        }
    }

    public void execFocusLostAction(SMServices sMServices, int n) {
        switch (n) {
            default: 
        }
    }

    public void execExitAction(SMServices sMServices, int n) {
        switch (n) {
            case 1100111: {
                sMServices.removeContext(1711027731L);
                return;
            }
            case 1100112: {
                SettingsActionProxy settingsActionProxy = this.ap0;
                try {
                    settingsActionProxy.leaveETCDesktopHistory(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionSettingsActionProxy(settingsActionProxy, nullPointerException, "leaveETCDesktopHistory");
                }
                return;
            }
            case 1100115: {
                sMServices.popDrawerIDs();
                sMServices.setScreenMode(1);
                return;
            }
            case 1100126: {
                sMServices.removeContext(-1954970189L);
                return;
            }
            case 1100128: {
                sMServices.popDrawerIDs();
                this.ap0_leaveSettings_2107068339();
                return;
            }
            case 1100130: {
                sMServices.removeContext(41420174L);
                CustDownloadActionProxy custDownloadActionProxy = this.ap3;
                try {
                    custDownloadActionProxy.swdlCustomerUpdateLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionCustDownloadActionProxy(custDownloadActionProxy, nullPointerException, "swdlCustomerUpdateLeft");
                }
                return;
            }
            case 1100132: {
                SettingsActionProxy settingsActionProxy = this.ap0;
                try {
                    settingsActionProxy.leaveFactoryReset(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionSettingsActionProxy(settingsActionProxy, nullPointerException, "leaveFactoryReset");
                }
                return;
            }
            case 1100133: {
                sMServices.removeContext(-492762904L);
                return;
            }
            case 1100141: {
                sMServices.removeContext(-469138162L);
                return;
            }
            case 1100143: {
                sMServices.removeContext(-1666594315L);
                return;
            }
            case 1100148: {
                sMServices.removeContext(1285098874L);
                return;
            }
            case 1100157: {
                ToneActionProxy toneActionProxy = this.ap4;
                try {
                    toneActionProxy.volumeSDSExited(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionToneActionProxy(toneActionProxy, nullPointerException, "volumeSDSExited");
                }
                return;
            }
            case 1100165: {
                sMServices.removeContext(187140678L);
                return;
            }
            case 1100166: {
                sMServices.removeContext(-1969819011L);
                return;
            }
        }
    }

    public void execEnteredAction(SMServices sMServices, int n) {
        switch (n) {
            default: 
        }
    }

    private void ap0_enterMMISettings_2107068339() {
        SettingsActionProxy settingsActionProxy = this.ap0;
        try {
            settingsActionProxy.enterMMISettings(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionSettingsActionProxy(settingsActionProxy, nullPointerException, "enterMMISettings");
        }
    }

    private void ap0_enterSystemSettings_2107068339() {
        SettingsActionProxy settingsActionProxy = this.ap0;
        try {
            settingsActionProxy.enterSystemSettings(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionSettingsActionProxy(settingsActionProxy, nullPointerException, "enterSystemSettings");
        }
    }

    public void execEnterAction(SMServices sMServices, int n) {
        switch (n) {
            case 1100111: {
                sMServices.addContext(1711027731L);
                return;
            }
            case 1100112: {
                SettingsActionProxy settingsActionProxy = this.ap0;
                try {
                    settingsActionProxy.enterETCDesktopHistory(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionSettingsActionProxy(settingsActionProxy, nullPointerException, "enterETCDesktopHistory");
                }
                return;
            }
            case 1100115: {
                sMServices.pushDrawerIDs(0L, 0L);
                sMServices.setScreenMode(2);
                return;
            }
            case 1100117: {
                SettingsActionProxy settingsActionProxy = this.ap0;
                try {
                    settingsActionProxy.enterETCSettings(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionSettingsActionProxy(settingsActionProxy, nullPointerException, "enterETCSettings");
                }
                return;
            }
            case 1100118: {
                this.ap0_enterMMISettings_2107068339();
                return;
            }
            case 1100126: {
                sMServices.addContext(-1954970189L);
                return;
            }
            case 1100127: {
                ConnectivityActionProxy connectivityActionProxy = this.ap1;
                try {
                    connectivityActionProxy.connectivityCoMaInstanceEnteredSetApplicationId(this.smm.getTerminalID(), 11, 9);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityCoMaInstanceEnteredSetApplicationId");
                }
                connectivityActionProxy = this.ap1;
                try {
                    connectivityActionProxy.connectivityCoMaApplicationContext(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityCoMaApplicationContext");
                }
                return;
            }
            case 1100128: {
                FrameworkActionProxy frameworkActionProxy = this.ap2;
                try {
                    frameworkActionProxy.activeApplication(this.smm.getTerminalID(), 10);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionFrameworkActionProxy(frameworkActionProxy, nullPointerException, "activeApplication");
                }
                sMServices.setColor(0);
                sMServices.pushDrawerIDs(1100000L, 1100081L);
                return;
            }
            case 1100130: {
                sMServices.addContext(41420174L);
                return;
            }
            case 1100133: {
                sMServices.addContext(-492762904L);
                return;
            }
            case 1100141: {
                sMServices.addContext(-469138162L);
                return;
            }
            case 1100142: {
                this.ap0_enterMMISettings_2107068339();
                return;
            }
            case 1100143: {
                sMServices.addContext(-1666594315L);
                return;
            }
            case 1100147: {
                SettingsActionProxy settingsActionProxy = this.ap0;
                try {
                    settingsActionProxy.enterRSESettings(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionSettingsActionProxy(settingsActionProxy, nullPointerException, "enterRSESettings");
                }
                return;
            }
            case 1100148: {
                sMServices.addContext(1285098874L);
                return;
            }
            case 1100157: {
                ToneActionProxy toneActionProxy = this.ap4;
                try {
                    toneActionProxy.volumeSDSEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionToneActionProxy(toneActionProxy, nullPointerException, "volumeSDSEntered");
                }
                return;
            }
            case 1100158: {
                this.ap0_enterSystemSettings_2107068339();
                return;
            }
            case 1100159: {
                this.ap0_enterSystemSettings_2107068339();
                return;
            }
            case 1100165: {
                sMServices.addContext(187140678L);
                return;
            }
            case 1100166: {
                sMServices.addContext(-1969819011L);
                return;
            }
            case 1100174: {
                SettingsActionProxy settingsActionProxy = this.ap0;
                try {
                    settingsActionProxy.enterLicenseBrowser(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionSettingsActionProxy(settingsActionProxy, nullPointerException, "enterLicenseBrowser");
                }
                return;
            }
        }
    }

    private void ap0_leaveSettings_2107068339() {
        SettingsActionProxy settingsActionProxy = this.ap0;
        try {
            settingsActionProxy.leaveSettings(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionSettingsActionProxy(settingsActionProxy, nullPointerException, "leaveSettings");
        }
    }

    public void execTransitionAction(SMServices sMServices, int n, int n2) {
        switch (n) {
            case 1100081: {
                CustDownloadActionProxy custDownloadActionProxy = this.ap3;
                try {
                    custDownloadActionProxy.swdlCustomerUpdateEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionCustDownloadActionProxy(custDownloadActionProxy, nullPointerException, "swdlCustomerUpdateEntered");
                }
                return;
            }
            case 1100121: {
                sMServices.addScreenAnimation(16);
                return;
            }
            case 1100125: {
                sMServices.addScreenAnimation(16);
                return;
            }
            case 1100127: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 1100131: {
                sMServices.addScreenAnimation(16);
                this.ap0_leaveSettings_2107068339();
                return;
            }
            case 1100142: {
                sMServices.pushDrawerIDs(1100000L, 600144L);
                return;
            }
            case 1100159: {
                sMServices.addScreenAnimation(16);
                return;
            }
            case 1100165: {
                sMServices.addScreenAnimation(16);
                return;
            }
            case 1100241: {
                sMServices.addScreenAnimation(64);
                return;
            }
            case 1100242: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 1100245: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 1100246: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 1100277: {
                sMServices.showPartialPopup(1100030);
                return;
            }
            case 1100281: {
                sMServices.showPartialPopup(1100078);
                return;
            }
            case 1100299: {
                sMServices.showPartialPopup(1100029);
                return;
            }
            case 1100306: {
                sMServices.showPartialPopup(1100031);
                return;
            }
            case 1100307: {
                sMServices.showPartialPopup(1100037);
                return;
            }
            case 1100308: {
                sMServices.showPartialPopup(1100077);
                return;
            }
            case 1100309: {
                sMServices.showPartialPopup(1100038);
                return;
            }
            case 1100322: {
                sMServices.showPartialPopup(1100036);
                return;
            }
            case 1100327: {
                this.ap0_leaveSettings_2107068339();
                return;
            }
            case 1100337: {
                switch (n2) {
                    case 1: {
                        sMServices.showPartialPopup(1100033);
                        return;
                    }
                }
                return;
            }
            case 1100339: {
                sMServices.setColor(0);
                return;
            }
            case 1100360: {
                sMServices.addScreenAnimation(128);
                return;
            }
        }
    }

    public HMIModel getModel(int n) throws NoSuchElementException {
        return this.smm.getModel(n);
    }
}

