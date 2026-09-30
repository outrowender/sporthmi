/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tuner.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.ap.EntertainmentActionProxy;
import de.audi.atip.statemachine.ap.FrameworkActionProxy;
import de.audi.atip.statemachine.ap.TunerActionProxy;
import java.util.NoSuchElementException;

public class TunerSMMActions
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;
    private volatile TunerActionProxy ap0;
    private volatile FrameworkActionProxy ap1;
    private volatile EntertainmentActionProxy ap2;
    public static int[] REQUIRED_ACTION_PROXY_MODULE_IDS = new int[]{25, 4, 20};

    protected TunerSMMActions(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    public void removeActionProxy(int n, ActionProxy actionProxy) {
        if (actionProxy instanceof EntertainmentActionProxy) {
            this.ap2 = null;
            this.logChannel.log(10000000, "EntertainmentActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof FrameworkActionProxy) {
            this.ap1 = null;
            this.logChannel.log(10000000, "FrameworkActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof TunerActionProxy) {
            this.ap0 = null;
            this.logChannel.log(10000000, "TunerActionProxy Action Proxy removed");
            return;
        }
    }

    public ActionProxy addActionProxy(int n, ActionProxy actionProxy) {
        if (actionProxy instanceof EntertainmentActionProxy) {
            this.ap2 = (EntertainmentActionProxy)actionProxy;
            this.logChannel.log(10000000, "EntertainmentActionProxy Action Proxy added");
            return this.ap2;
        }
        if (actionProxy instanceof FrameworkActionProxy) {
            this.ap1 = (FrameworkActionProxy)actionProxy;
            this.logChannel.log(10000000, "FrameworkActionProxy Action Proxy added");
            return this.ap1;
        }
        if (actionProxy instanceof TunerActionProxy) {
            this.ap0 = (TunerActionProxy)actionProxy;
            this.logChannel.log(10000000, "TunerActionProxy Action Proxy added");
            return this.ap0;
        }
        return null;
    }

    private void catchActionExceptionEntertainmentActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'EntertainmentActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1000000, "Action Proxy 'EntertainmentActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionFrameworkActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'FrameworkActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1000000, "Action Proxy 'FrameworkActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionTunerActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'TunerActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1000000, "Action Proxy 'TunerActionProxy' missing for call '%1'", (Object)string);
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
            case 100001: {
                TunerActionProxy tunerActionProxy = this.ap0;
                try {
                    tunerActionProxy.hmiDeactivatedTuner(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTunerActionProxy(tunerActionProxy, nullPointerException, "hmiDeactivatedTuner");
                }
                sMServices.popDrawerIDs();
                return;
            }
            case 100007: {
                sMServices.popDrawerIDs();
                sMServices.setScreenMode(1);
                return;
            }
            case 100010: {
                sMServices.popDrawerIDs();
                sMServices.removeContext(813421785L);
                return;
            }
            case 100017: {
                this.ap2_entertainmentBlacklist_1028045899();
                return;
            }
            case 100018: {
                sMServices.removeContext(-283997989L);
                return;
            }
            case 100021: {
                sMServices.removeContext(149234859L);
                return;
            }
            case 100030: {
                sMServices.removeContext(-1825460317L);
                return;
            }
            case 100032: {
                sMServices.removeContext(2011252774L);
                return;
            }
            case 100035: {
                TunerActionProxy tunerActionProxy = this.ap0;
                try {
                    tunerActionProxy.tunerTempBandChangeLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTunerActionProxy(tunerActionProxy, nullPointerException, "tunerTempBandChangeLeft");
                }
                sMServices.popDrawerIDs();
                return;
            }
            case 100055: {
                sMServices.removeContext(-1569128598L);
                return;
            }
            case 100063: {
                sMServices.removeContext(-1017632050L);
                return;
            }
            case 100069: {
                sMServices.removeContext(967773909L);
                return;
            }
            case 100073: {
                sMServices.popDrawerIDs();
                return;
            }
            case 100099: {
                TunerActionProxy tunerActionProxy = this.ap0;
                try {
                    tunerActionProxy.tunerListUpdateLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTunerActionProxy(tunerActionProxy, nullPointerException, "tunerListUpdateLeft");
                }
                return;
            }
            case 100116: {
                TunerActionProxy tunerActionProxy = this.ap0;
                try {
                    tunerActionProxy.tunerSDARSManageAlertsLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTunerActionProxy(tunerActionProxy, nullPointerException, "tunerSDARSManageAlertsLeft");
                }
                sMServices.popDrawerIDs();
                sMServices.removeContext(1427689803L);
                return;
            }
            case 100126: {
                this.ap2_entertainmentBlacklist_1028045899();
                return;
            }
            case 100127: {
                TunerActionProxy tunerActionProxy = this.ap0;
                try {
                    tunerActionProxy.tunerManualTuneLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTunerActionProxy(tunerActionProxy, nullPointerException, "tunerManualTuneLeft");
                }
                return;
            }
            case 100129: {
                this.ap2_entertainmentBlacklist_1028045899();
                return;
            }
            case 100130: {
                TunerActionProxy tunerActionProxy = this.ap0;
                try {
                    tunerActionProxy.tunerSeekLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTunerActionProxy(tunerActionProxy, nullPointerException, "tunerSeekLeft");
                }
                return;
            }
            case 100138: {
                sMServices.removeContext(86942196L);
                return;
            }
            case 100157: {
                sMServices.popDrawerIDs();
                return;
            }
            case 100182: {
                sMServices.removeContext(1446942497L);
                return;
            }
            case 100185: {
                TunerActionProxy tunerActionProxy = this.ap0;
                try {
                    tunerActionProxy.tunerFavoritesLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTunerActionProxy(tunerActionProxy, nullPointerException, "tunerFavoritesLeft");
                }
                return;
            }
            case 100186: {
                TunerActionProxy tunerActionProxy = this.ap0;
                try {
                    tunerActionProxy.tunerGuidedStoreLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTunerActionProxy(tunerActionProxy, nullPointerException, "tunerGuidedStoreLeft");
                }
                return;
            }
            case 100188: {
                sMServices.popDrawerIDs();
                return;
            }
            case 100200: {
                sMServices.removeContext(-283997989L);
                return;
            }
            case 100201: {
                sMServices.removeContext(-1825460317L);
                return;
            }
            case 100202: {
                sMServices.removeContext(86942196L);
                return;
            }
            case 100205: {
                sMServices.removeContext(149234859L);
                return;
            }
            case 100206: {
                sMServices.removeContext(-1569128598L);
                return;
            }
            case 100218: {
                sMServices.popDrawerIDs();
                return;
            }
            case 100243: {
                sMServices.setColor(2);
                return;
            }
            case 100245: {
                sMServices.setColor(2);
                return;
            }
        }
    }

    public void execEnteredAction(SMServices sMServices, int n) {
        switch (n) {
            default: 
        }
    }

    public void execEnterAction(SMServices sMServices, int n) {
        switch (n) {
            case 100001: {
                ActionProxy actionProxy = this.ap0;
                try {
                    actionProxy.hmiActivatedTuner(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTunerActionProxy(actionProxy, nullPointerException, "hmiActivatedTuner");
                }
                actionProxy = this.ap1;
                try {
                    actionProxy.activeApplication(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionFrameworkActionProxy(actionProxy, nullPointerException, "activeApplication");
                }
                sMServices.pushDrawerIDs(100080L, 100005L);
                sMServices.setColor(2);
                return;
            }
            case 100007: {
                sMServices.pushDrawerIDs(0L, 0L);
                sMServices.setScreenMode(2);
                return;
            }
            case 100010: {
                sMServices.pushDrawerIDs(0L, 100147L);
                sMServices.addContext(813421785L);
                return;
            }
            case 100012: {
                this.ap2_entertainmentBlacklist_109750599();
                return;
            }
            case 100018: {
                sMServices.addContext(-283997989L);
                return;
            }
            case 100021: {
                sMServices.addContext(149234859L);
                return;
            }
            case 100030: {
                sMServices.addContext(-1825460317L);
                return;
            }
            case 100032: {
                sMServices.addContext(2011252774L);
                return;
            }
            case 100035: {
                this.ap0_tunerTempBandChangeEntered_2107068339();
                sMServices.pushDrawerIDs(0L, 0L);
                return;
            }
            case 100055: {
                sMServices.addContext(-1569128598L);
                return;
            }
            case 100063: {
                sMServices.addContext(-1017632050L);
                return;
            }
            case 100069: {
                sMServices.addContext(967773909L);
                return;
            }
            case 100073: {
                sMServices.pushDrawerIDs(0L, 69L);
                return;
            }
            case 100116: {
                sMServices.pushDrawerIDs(0L, 100147L);
                sMServices.addContext(1427689803L);
                return;
            }
            case 100126: {
                this.ap2_entertainmentBlacklist_109750599();
                return;
            }
            case 100127: {
                TunerActionProxy tunerActionProxy = this.ap0;
                try {
                    tunerActionProxy.tunerManualTuneEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTunerActionProxy(tunerActionProxy, nullPointerException, "tunerManualTuneEntered");
                }
                return;
            }
            case 100129: {
                this.ap2_entertainmentBlacklist_109750599();
                return;
            }
            case 100138: {
                sMServices.addContext(86942196L);
                return;
            }
            case 100149: {
                sMServices.setColor(2);
                return;
            }
            case 100151: {
                sMServices.setColor(2);
                return;
            }
            case 100153: {
                sMServices.setColor(2);
                return;
            }
            case 100155: {
                sMServices.setColor(2);
                return;
            }
            case 100157: {
                sMServices.setColor(2);
                sMServices.pushDrawerIDs(0L, 100005L);
                return;
            }
            case 100159: {
                sMServices.setColor(2);
                return;
            }
            case 100160: {
                this.ap2_entertainmentBlacklist_109750599();
                return;
            }
            case 100182: {
                sMServices.addContext(1446942497L);
                return;
            }
            case 100185: {
                TunerActionProxy tunerActionProxy = this.ap0;
                try {
                    tunerActionProxy.tunerFavoritesEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTunerActionProxy(tunerActionProxy, nullPointerException, "tunerFavoritesEntered");
                }
                return;
            }
            case 100188: {
                sMServices.pushDrawerIDs(100080L, 69L);
                return;
            }
            case 100200: {
                sMServices.addContext(-283997989L);
                return;
            }
            case 100201: {
                sMServices.addContext(-1825460317L);
                return;
            }
            case 100202: {
                sMServices.addContext(86942196L);
                return;
            }
            case 100205: {
                sMServices.addContext(149234859L);
                return;
            }
            case 100206: {
                sMServices.addContext(-1569128598L);
                return;
            }
            case 100218: {
                sMServices.pushDrawerIDs(100080L, 0L);
                return;
            }
            case 100243: {
                sMServices.setColor(4);
                return;
            }
            case 100245: {
                sMServices.setColor(4);
                return;
            }
        }
    }

    private void ap2_entertainmentBlacklist_109750599() {
        EntertainmentActionProxy entertainmentActionProxy = this.ap2;
        try {
            entertainmentActionProxy.entertainmentBlacklist(this.smm.getTerminalID(), 1001);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionEntertainmentActionProxy(entertainmentActionProxy, nullPointerException, "entertainmentBlacklist");
        }
    }

    private void ap2_entertainmentBlacklist_1028045899() {
        EntertainmentActionProxy entertainmentActionProxy = this.ap2;
        try {
            entertainmentActionProxy.entertainmentBlacklist(this.smm.getTerminalID(), -1);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionEntertainmentActionProxy(entertainmentActionProxy, nullPointerException, "entertainmentBlacklist");
        }
    }

    private void ap0_tunerTempBandChangeEntered_2107068339() {
        TunerActionProxy tunerActionProxy = this.ap0;
        try {
            tunerActionProxy.tunerTempBandChangeEntered(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionTunerActionProxy(tunerActionProxy, nullPointerException, "tunerTempBandChangeEntered");
        }
    }

    private void ap0_tunerAbortScan_2107068339() {
        TunerActionProxy tunerActionProxy = this.ap0;
        try {
            tunerActionProxy.tunerAbortScan(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionTunerActionProxy(tunerActionProxy, nullPointerException, "tunerAbortScan");
        }
    }

    public void execTransitionAction(SMServices sMServices, int n, int n2) {
        switch (n) {
            case 100008: {
                this.ap2_entertainmentBlacklist_109750599();
                switch (n2) {
                    default: 
                }
                return;
            }
            case 100013: {
                switch (n2) {
                    case 0: {
                        this.ap2_entertainmentBlacklist_1028045899();
                        return;
                    }
                    case 1: {
                        this.ap2_entertainmentBlacklist_109750599();
                        return;
                    }
                }
                return;
            }
            case 100018: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 100025: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 100033: {
                switch (n2) {
                    case 0: {
                        sMServices.addScreenAnimation(64);
                        return;
                    }
                }
                return;
            }
            case 100036: {
                this.ap0_tunerTempBandChangeEntered_2107068339();
                return;
            }
            case 100048: {
                sMServices.addScreenAnimation(32);
                return;
            }
            case 100050: {
                sMServices.addScreenAnimation(32);
                return;
            }
            case 100056: {
                sMServices.addScreenAnimation(32);
                return;
            }
            case 100057: {
                sMServices.addScreenAnimation(32);
                return;
            }
            case 100070: {
                switch (n2) {
                    case 0: {
                        this.ap2_entertainmentBlacklist_1028045899();
                        return;
                    }
                    case 1: {
                        this.ap2_entertainmentBlacklist_109750599();
                        return;
                    }
                }
                return;
            }
            case 100085: {
                sMServices.addScreenAnimation(16);
                return;
            }
            case 100099: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 100110: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 100121: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 100122: {
                switch (n2) {
                    case 0: {
                        sMServices.addScreenAnimation(2);
                        return;
                    }
                }
                return;
            }
            case 100128: {
                sMServices.addScreenAnimation(32);
                return;
            }
            case 100130: {
                sMServices.addScreenAnimation(32);
                return;
            }
            case 100143: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 100146: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 100147: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 100157: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 100161: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 100174: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 100182: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 100183: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 100184: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 100223: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 100224: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 100225: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 100226: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 100227: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 100228: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 100229: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 100237: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 100238: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 100246: {
                this.ap0_tunerAbortScan_2107068339();
                return;
            }
            case 100264: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 100265: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 100274: {
                switch (n2) {
                    case 0: {
                        sMServices.addScreenAnimation(4);
                        return;
                    }
                }
                return;
            }
            case 100279: {
                sMServices.addScreenAnimation(16);
                this.ap0_tunerAbortScan_2107068339();
                return;
            }
            case 100282: {
                sMServices.addScreenAnimation(16);
                return;
            }
            case 100290: {
                sMServices.addScreenAnimation(64);
                this.ap0_tunerAbortScan_2107068339();
                return;
            }
            case 100296: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 100311: {
                sMServices.addScreenAnimation(32);
                return;
            }
            case 100312: {
                sMServices.addScreenAnimation(32);
                return;
            }
            case 100319: {
                sMServices.showPartialPopup(100104);
                return;
            }
            case 100320: {
                sMServices.addScreenAnimation(32);
                switch (n2) {
                    default: 
                }
                return;
            }
            case 100321: {
                switch (n2) {
                    case 0: {
                        this.ap2_entertainmentBlacklist_1028045899();
                        return;
                    }
                    case 1: {
                        this.ap2_entertainmentBlacklist_109750599();
                        return;
                    }
                }
                return;
            }
            case 100322: {
                switch (n2) {
                    case 0: {
                        this.ap2_entertainmentBlacklist_1028045899();
                        return;
                    }
                    case 1: {
                        this.ap2_entertainmentBlacklist_109750599();
                        return;
                    }
                }
                return;
            }
            case 100324: {
                sMServices.addScreenAnimation(32);
                switch (n2) {
                    default: 
                }
                return;
            }
            case 100328: {
                sMServices.addScreenAnimation(32);
                return;
            }
            case 100329: {
                sMServices.addScreenAnimation(32);
                return;
            }
            case 100335: {
                sMServices.addScreenAnimation(16);
                return;
            }
            case 100339: {
                switch (n2) {
                    case 0: {
                        return;
                    }
                }
                return;
            }
            case 100359: {
                switch (n2) {
                    case 0: {
                        this.ap2_entertainmentBlacklist_109750599();
                        return;
                    }
                }
                return;
            }
            case 100367: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 100396: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 100398: {
                sMServices.showPartialPopup(100150);
                return;
            }
            case 100399: {
                sMServices.showPartialPopup(100151);
                return;
            }
            case 100400: {
                sMServices.addScreenAnimation(32);
                return;
            }
            case 100402: {
                sMServices.addScreenAnimation(32);
                return;
            }
            case 100403: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 100422: {
                sMServices.addScreenAnimation(64);
                return;
            }
            case 100425: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 100433: {
                switch (n2) {
                    case 0: {
                        this.ap2_entertainmentBlacklist_1028045899();
                        return;
                    }
                    case 1: {
                        this.ap2_entertainmentBlacklist_109750599();
                        return;
                    }
                }
                return;
            }
            case 100434: {
                switch (n2) {
                    case 0: {
                        this.ap2_entertainmentBlacklist_1028045899();
                        return;
                    }
                    case 1: {
                        this.ap2_entertainmentBlacklist_109750599();
                        return;
                    }
                }
                return;
            }
            case 100435: {
                switch (n2) {
                    case 0: {
                        this.ap2_entertainmentBlacklist_1028045899();
                        return;
                    }
                    case 1: {
                        this.ap2_entertainmentBlacklist_109750599();
                        return;
                    }
                }
                return;
            }
            case 100440: {
                switch (n2) {
                    case 0: {
                        this.ap2_entertainmentBlacklist_1028045899();
                        return;
                    }
                    case 1: {
                        this.ap2_entertainmentBlacklist_109750599();
                        return;
                    }
                }
                return;
            }
            case 100441: {
                switch (n2) {
                    case 0: {
                        this.ap2_entertainmentBlacklist_1028045899();
                        return;
                    }
                    case 1: {
                        this.ap2_entertainmentBlacklist_109750599();
                        return;
                    }
                }
                return;
            }
            case 100443: {
                switch (n2) {
                    case 0: {
                        this.ap2_entertainmentBlacklist_1028045899();
                        return;
                    }
                    case 1: {
                        this.ap2_entertainmentBlacklist_109750599();
                        return;
                    }
                }
                return;
            }
            case 100449: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(100161);
                        sMServices.addScreenAnimation(32);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(100162);
                        sMServices.addScreenAnimation(32);
                        return;
                    }
                    case 2: {
                        sMServices.showPartialPopup(100163);
                        sMServices.addScreenAnimation(32);
                        return;
                    }
                    case 3: {
                        sMServices.showPartialPopup(100164);
                        sMServices.addScreenAnimation(32);
                        return;
                    }
                }
                return;
            }
            case 100484: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 100485: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 100510: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(100161);
                        sMServices.addScreenAnimation(32);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(100162);
                        sMServices.addScreenAnimation(32);
                        return;
                    }
                    case 2: {
                        sMServices.showPartialPopup(100163);
                        sMServices.addScreenAnimation(32);
                        return;
                    }
                    case 3: {
                        sMServices.showPartialPopup(100164);
                        sMServices.addScreenAnimation(32);
                        return;
                    }
                }
                return;
            }
            case 100511: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 100512: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 100518: {
                sMServices.showPartialPopup(100168);
                return;
            }
            case 100519: {
                this.ap0_tunerAbortScan_2107068339();
                return;
            }
            case 100525: {
                switch (n2) {
                    case 1: {
                        sMServices.hidePartialPopup(100104);
                        return;
                    }
                }
                return;
            }
            case 100526: {
                switch (n2) {
                    case 1: {
                        sMServices.hidePartialPopup(100104);
                        return;
                    }
                }
                return;
            }
        }
    }

    public HMIModel getModel(int n) throws NoSuchElementException {
        return this.smm.getModel(n);
    }
}

