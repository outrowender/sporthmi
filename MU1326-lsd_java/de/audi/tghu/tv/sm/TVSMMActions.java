/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tv.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.ap.EntertainmentActionProxy;
import de.audi.atip.statemachine.ap.TVActionProxy;

public class TVSMMActions
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;
    private volatile EntertainmentActionProxy ap0;
    private volatile TVActionProxy ap1;
    public static int[] REQUIRED_ACTION_PROXY_MODULE_IDS = new int[]{25, 18};

    protected TVSMMActions(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    public void removeActionProxy(int n, ActionProxy actionProxy) {
        if (actionProxy instanceof EntertainmentActionProxy) {
            this.ap0 = null;
            this.logChannel.log(-2137614336, "EntertainmentActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof TVActionProxy) {
            this.ap1 = null;
            this.logChannel.log(-2137614336, "TVActionProxy Action Proxy removed");
            return;
        }
    }

    public ActionProxy addActionProxy(int n, ActionProxy actionProxy) {
        if (actionProxy instanceof EntertainmentActionProxy) {
            this.ap0 = (EntertainmentActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "EntertainmentActionProxy Action Proxy added");
            return this.ap0;
        }
        if (actionProxy instanceof TVActionProxy) {
            this.ap1 = (TVActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "TVActionProxy Action Proxy added");
            return this.ap1;
        }
        return null;
    }

    private void catchActionExceptionEntertainmentActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'EntertainmentActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'EntertainmentActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionTVActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'TVActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'TVActionProxy' missing for call '%1'", (Object)string);
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

    private void ap0_entertainmentSetVisible_111812213() {
        EntertainmentActionProxy entertainmentActionProxy = this.ap0;
        try {
            entertainmentActionProxy.entertainmentSetVisible(this.smm.getTerminalID(), true);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionEntertainmentActionProxy(entertainmentActionProxy, nullPointerException, "entertainmentSetVisible");
        }
    }

    public void execExitAction(SMServices sMServices, int n) {
        switch (n) {
            case 2600001: {
                sMServices.removeContext(-25593258L);
                this.ap0_entertainmentBlacklist_1028045899();
                return;
            }
            case 2600004: {
                sMServices.removeContext(-1011568145L);
                return;
            }
            case 2600006: {
                sMServices.popDrawerIDs();
                sMServices.setScreenMode(1);
                return;
            }
            case 2600009: {
                this.ap0_entertainmentSetVisible_111812213();
                return;
            }
            case 2600014: {
                this.ap0_entertainmentSetVisible_111812213();
                return;
            }
            case 2600028: {
                this.ap0_entertainmentSetVisible_111812213();
                return;
            }
            case 2600029: {
                this.ap0_entertainmentSetVisible_111812213();
                return;
            }
            case 2600030: {
                sMServices.popDrawerIDs();
                return;
            }
            case 2600033: {
                ActionProxy actionProxy = this.ap1;
                try {
                    actionProxy.tvSeekModeLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTVActionProxy(actionProxy, nullPointerException, "tvSeekModeLeft");
                }
                this.ap0_entertainmentSetVisible__842232548();
                actionProxy = this.ap0;
                try {
                    actionProxy.entertainmentBlacklist(this.smm.getTerminalID(), 7001);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionEntertainmentActionProxy(actionProxy, nullPointerException, "entertainmentBlacklist");
                }
                return;
            }
            case 2600034: {
                this.ap0_entertainmentSetVisible_111812213();
                return;
            }
            case 2600037: {
                TVActionProxy tVActionProxy = this.ap1;
                try {
                    tVActionProxy.avFullscreenLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTVActionProxy(tVActionProxy, nullPointerException, "avFullscreenLeft");
                }
                return;
            }
            case 2600039: {
                sMServices.removeContext(0);
                this.ap0_entertainmentBlacklist_1028045899();
                return;
            }
            case 2600040: {
                sMServices.removeContext(-120066153L);
                return;
            }
            case 2600041: {
                sMServices.removeContext(-1033852506L);
                return;
            }
            case 2600042: {
                sMServices.removeContext(0);
                this.ap0_entertainmentBlacklist_1028045899();
                return;
            }
            case 2600045: {
                this.ap1_tvParentalRatingLeft_2107068339();
                return;
            }
            case 2600056: {
                sMServices.popDrawerIDs();
                return;
            }
            case 2600064: {
                sMServices.removeContext(-120066153L);
                sMServices.removeContext(0);
                return;
            }
            case 2600065: {
                sMServices.removeContext(-1033852506L);
                return;
            }
            case 2600066: {
                sMServices.popDrawerIDs();
                TVActionProxy tVActionProxy = this.ap1;
                try {
                    tVActionProxy.hmiDeactivatedTV(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTVActionProxy(tVActionProxy, nullPointerException, "hmiDeactivatedTV");
                }
                return;
            }
            case 2600070: {
                this.ap0_entertainmentSetVisible_111812213();
                return;
            }
            case 2600086: {
                sMServices.removeContext(-1011568145L);
                TVActionProxy tVActionProxy = this.ap1;
                try {
                    tVActionProxy.tvFullscreenLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTVActionProxy(tVActionProxy, nullPointerException, "tvFullscreenLeft");
                }
                return;
            }
            case 2600088: {
                sMServices.popDrawerIDs();
                return;
            }
            case 2600095: {
                sMServices.popDrawerIDs();
                this.ap0_entertainmentBlacklist_1028045899();
                return;
            }
            case 2600099: {
                TVActionProxy tVActionProxy = this.ap1;
                try {
                    tVActionProxy.tvEwsPopupClosed(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTVActionProxy(tVActionProxy, nullPointerException, "tvEwsPopupClosed");
                }
                return;
            }
        }
    }

    public void execEnteredAction(SMServices sMServices, int n) {
        switch (n) {
            default: 
        }
    }

    private void ap0_entertainmentSetVisible__842232548() {
        EntertainmentActionProxy entertainmentActionProxy = this.ap0;
        try {
            entertainmentActionProxy.entertainmentSetVisible(this.smm.getTerminalID(), false);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionEntertainmentActionProxy(entertainmentActionProxy, nullPointerException, "entertainmentSetVisible");
        }
    }

    public void execEnterAction(SMServices sMServices, int n) {
        switch (n) {
            case 2600001: {
                sMServices.addContext(-25593258L);
                this.ap0_entertainmentBlacklist_109959136();
                return;
            }
            case 2600004: {
                sMServices.addContext(-1011568145L);
                return;
            }
            case 2600006: {
                sMServices.pushDrawerIDs(0L, 0L);
                sMServices.setScreenMode(2);
                return;
            }
            case 2600009: {
                this.ap0_entertainmentSetVisible__842232548();
                return;
            }
            case 2600014: {
                this.ap0_entertainmentSetVisible__842232548();
                return;
            }
            case 2600028: {
                this.ap0_entertainmentSetVisible__842232548();
                return;
            }
            case 2600029: {
                this.ap0_entertainmentSetVisible__842232548();
                return;
            }
            case 2600030: {
                sMServices.pushDrawerIDs(0L, 0);
                return;
            }
            case 2600033: {
                this.ap0_entertainmentSetVisible__842232548();
                this.ap0_entertainmentBlacklist_1028045899();
                return;
            }
            case 2600034: {
                this.ap0_entertainmentSetVisible__842232548();
                return;
            }
            case 2600037: {
                TVActionProxy tVActionProxy = this.ap1;
                try {
                    tVActionProxy.avFullscreenEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTVActionProxy(tVActionProxy, nullPointerException, "avFullscreenEntered");
                }
                return;
            }
            case 2600039: {
                sMServices.addContext(0);
                this.ap0_entertainmentBlacklist_109959136();
                return;
            }
            case 2600040: {
                sMServices.addContext(-120066153L);
                return;
            }
            case 2600041: {
                sMServices.addContext(-1033852506L);
                return;
            }
            case 2600042: {
                sMServices.addContext(0);
                this.ap0_entertainmentBlacklist_109959136();
                return;
            }
            case 2600046: {
                TVActionProxy tVActionProxy = this.ap1;
                try {
                    tVActionProxy.tvParentalRatingDisclaimerEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTVActionProxy(tVActionProxy, nullPointerException, "tvParentalRatingDisclaimerEntered");
                }
                return;
            }
            case 2600056: {
                sMServices.pushDrawerIDs(0L, 0);
                return;
            }
            case 2600064: {
                sMServices.addContext(-120066153L);
                sMServices.addContext(0);
                return;
            }
            case 2600065: {
                sMServices.addContext(-1033852506L);
                return;
            }
            case 2600066: {
                sMServices.pushDrawerIDs(0, 0);
                TVActionProxy tVActionProxy = this.ap1;
                try {
                    tVActionProxy.hmiActivatedTV(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTVActionProxy(tVActionProxy, nullPointerException, "hmiActivatedTV");
                }
                return;
            }
            case 2600070: {
                this.ap0_entertainmentSetVisible__842232548();
                return;
            }
            case 2600086: {
                sMServices.addContext(-1011568145L);
                TVActionProxy tVActionProxy = this.ap1;
                try {
                    tVActionProxy.tvFullscreenEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTVActionProxy(tVActionProxy, nullPointerException, "tvFullscreenEntered");
                }
                return;
            }
            case 2600088: {
                sMServices.setColor(2);
                sMServices.pushDrawerIDs(0L, 0L);
                return;
            }
            case 2600095: {
                sMServices.pushDrawerIDs(0, 0L);
                this.ap0_entertainmentBlacklist_109959136();
                return;
            }
        }
    }

    private void ap1_tvParentalRatingLeft_2107068339() {
        TVActionProxy tVActionProxy = this.ap1;
        try {
            tVActionProxy.tvParentalRatingLeft(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionTVActionProxy(tVActionProxy, nullPointerException, "tvParentalRatingLeft");
        }
    }

    private void ap0_entertainmentBlacklist_109959136() {
        EntertainmentActionProxy entertainmentActionProxy = this.ap0;
        try {
            entertainmentActionProxy.entertainmentBlacklist(this.smm.getTerminalID(), 8001);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionEntertainmentActionProxy(entertainmentActionProxy, nullPointerException, "entertainmentBlacklist");
        }
    }

    private void ap0_entertainmentBlacklist_1028045899() {
        EntertainmentActionProxy entertainmentActionProxy = this.ap0;
        try {
            entertainmentActionProxy.entertainmentBlacklist(this.smm.getTerminalID(), -1);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionEntertainmentActionProxy(entertainmentActionProxy, nullPointerException, "entertainmentBlacklist");
        }
    }

    private void ap1_tvCasDisclaimerEntered_2107068339() {
        TVActionProxy tVActionProxy = this.ap1;
        try {
            tVActionProxy.tvCasDisclaimerEntered(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionTVActionProxy(tVActionProxy, nullPointerException, "tvCasDisclaimerEntered");
        }
    }

    public void execTransitionAction(SMServices sMServices, int n, int n2) {
        switch (n) {
            case 2600002: {
                this.ap1_tvParentalRatingLeft_2107068339();
                switch (n2) {
                    default: 
                }
                return;
            }
            case 2600006: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2600010: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2600011: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2600012: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2600014: {
                sMServices.addScreenAnimation(2);
                switch (n2) {
                    case 1: {
                        TVActionProxy tVActionProxy = this.ap1;
                        try {
                            tVActionProxy.tvDataBroadcastEntered(this.smm.getTerminalID());
                        }
                        catch (NullPointerException nullPointerException) {
                            this.catchActionExceptionTVActionProxy(tVActionProxy, nullPointerException, "tvDataBroadcastEntered");
                        }
                        return;
                    }
                }
                return;
            }
            case 2600021: {
                sMServices.addScreenAnimation(2);
                TVActionProxy tVActionProxy = this.ap1;
                try {
                    tVActionProxy.tvTeletextEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTVActionProxy(tVActionProxy, nullPointerException, "tvTeletextEntered");
                }
                switch (n2) {
                    default: 
                }
                return;
            }
            case 2600027: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2600028: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2600029: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2600030: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2600031: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 2600032: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 2600035: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 2600036: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 2600042: {
                TVActionProxy tVActionProxy = this.ap1;
                try {
                    tVActionProxy.tvEngineeringEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTVActionProxy(tVActionProxy, nullPointerException, "tvEngineeringEntered");
                }
                return;
            }
            case 2600045: {
                TVActionProxy tVActionProxy = this.ap1;
                try {
                    tVActionProxy.tvEPGEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTVActionProxy(tVActionProxy, nullPointerException, "tvEPGEntered");
                }
                return;
            }
            case 2600048: {
                switch (n2) {
                    case 0: {
                        sMServices.addScreenAnimation(2);
                        return;
                    }
                }
                return;
            }
            case 2600061: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 2600062: {
                TVActionProxy tVActionProxy = this.ap1;
                try {
                    tVActionProxy.tvVisualAudioEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTVActionProxy(tVActionProxy, nullPointerException, "tvVisualAudioEntered");
                }
                return;
            }
            case 2600071: {
                sMServices.showPartialPopup(1756112640);
                return;
            }
            case 2600074: {
                switch (n2) {
                    case 1: {
                        sMServices.addScreenAnimation(2);
                        return;
                    }
                }
                return;
            }
            case 2600075: {
                sMServices.addScreenAnimation(16);
                return;
            }
            case 2600091: {
                sMServices.addScreenAnimation(64);
                return;
            }
            case 2600112: {
                switch (n2) {
                    case 0: {
                        this.ap0_entertainmentBlacklist_109959136();
                        return;
                    }
                    case 1: {
                        this.ap0_entertainmentBlacklist_1028045899();
                        return;
                    }
                }
                return;
            }
            case 2600123: {
                this.ap1_tvCasDisclaimerEntered_2107068339();
                return;
            }
            case 2600135: {
                sMServices.addScreenAnimation(16);
                return;
            }
            case 2600138: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2600156: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2600169: {
                sMServices.addScreenAnimation(32);
                return;
            }
            case 2600171: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2600172: {
                switch (n2) {
                    case 0: {
                        return;
                    }
                }
                return;
            }
            case 2600191: {
                sMServices.addScreenAnimation(16);
                switch (n2) {
                    default: 
                }
                return;
            }
            case 2600192: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2600204: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2600235: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 2600236: {
                TVActionProxy tVActionProxy = this.ap1;
                try {
                    tVActionProxy.tvTxtEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTVActionProxy(tVActionProxy, nullPointerException, "tvTxtEntered");
                }
                switch (n2) {
                    default: 
                }
                return;
            }
            case 2600241: {
                this.ap1_tvCasDisclaimerEntered_2107068339();
                return;
            }
            case 2600251: {
                switch (n2) {
                    case 1: {
                        sMServices.hidePartialPopup(1756112640);
                        return;
                    }
                }
                return;
            }
        }
    }

    public HMIModel getModel(int n) {
        return this.smm.getModel(n);
    }
}

