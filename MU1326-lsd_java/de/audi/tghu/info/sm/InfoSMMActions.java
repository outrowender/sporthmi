/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.ap.InfoActionProxy;
import de.audi.atip.statemachine.ap.NaviActionProxy;
import de.audi.atip.statemachine.ap.TopLevelScreenActionProxy;

public class InfoSMMActions
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;
    private volatile InfoActionProxy ap0;
    private volatile NaviActionProxy ap1;
    private volatile TopLevelScreenActionProxy ap2;
    public static int[] REQUIRED_ACTION_PROXY_MODULE_IDS = new int[]{5, 10, 27};

    protected InfoSMMActions(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    public void removeActionProxy(int n, ActionProxy actionProxy) {
        if (actionProxy instanceof InfoActionProxy) {
            this.ap0 = null;
            this.logChannel.log(-2137614336, "InfoActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof NaviActionProxy) {
            this.ap1 = null;
            this.logChannel.log(-2137614336, "NaviActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof TopLevelScreenActionProxy) {
            this.ap2 = null;
            this.logChannel.log(-2137614336, "TopLevelScreenActionProxy Action Proxy removed");
            return;
        }
    }

    public ActionProxy addActionProxy(int n, ActionProxy actionProxy) {
        if (actionProxy instanceof InfoActionProxy) {
            this.ap0 = (InfoActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "InfoActionProxy Action Proxy added");
            return this.ap0;
        }
        if (actionProxy instanceof NaviActionProxy) {
            this.ap1 = (NaviActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "NaviActionProxy Action Proxy added");
            return this.ap1;
        }
        if (actionProxy instanceof TopLevelScreenActionProxy) {
            this.ap2 = (TopLevelScreenActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "TopLevelScreenActionProxy Action Proxy added");
            return this.ap2;
        }
        return null;
    }

    private void catchActionExceptionInfoActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'InfoActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'InfoActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionNaviActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'NaviActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'NaviActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionTopLevelScreenActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'TopLevelScreenActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'TopLevelScreenActionProxy' missing for call '%1'", (Object)string);
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

    private void ap1_exitPreviewMapScreen_2107068339() {
        NaviActionProxy naviActionProxy = this.ap1;
        try {
            naviActionProxy.exitPreviewMapScreen(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "exitPreviewMapScreen");
        }
    }

    public void execExitAction(SMServices sMServices, int n) {
        switch (n) {
            case 500000: {
                sMServices.popDrawerIDs();
                return;
            }
            case 500009: {
                InfoActionProxy infoActionProxy = this.ap0;
                try {
                    infoActionProxy.tmcExitDetailsScreen(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionInfoActionProxy(infoActionProxy, nullPointerException, "tmcExitDetailsScreen");
                }
                return;
            }
            case 500010: {
                InfoActionProxy infoActionProxy = this.ap0;
                try {
                    infoActionProxy.tmcExitScreens(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionInfoActionProxy(infoActionProxy, nullPointerException, "tmcExitScreens");
                }
                return;
            }
            case 500012: {
                this.ap1_exitPreviewMapScreen_2107068339();
                InfoActionProxy infoActionProxy = this.ap0;
                try {
                    infoActionProxy.tmcExitMainScreen(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionInfoActionProxy(infoActionProxy, nullPointerException, "tmcExitMainScreen");
                }
                return;
            }
            case 500013: {
                this.ap1_exitPreviewMapScreen_2107068339();
                return;
            }
            case 500014: {
                sMServices.popDrawerIDs();
                sMServices.removeContext(0);
                TopLevelScreenActionProxy topLevelScreenActionProxy = this.ap2;
                try {
                    topLevelScreenActionProxy.setTopLevelScreen(this.smm.getTerminalID(), 4, true);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTopLevelScreenActionProxy(topLevelScreenActionProxy, nullPointerException, "setTopLevelScreen");
                }
                return;
            }
            case 500015: {
                this.ap1_exitPreviewMapScreen_2107068339();
                return;
            }
            case 500018: {
                sMServices.popDrawerIDs();
                sMServices.setScreenMode(1);
                return;
            }
        }
    }

    public void execEnteredAction(SMServices sMServices, int n) {
        switch (n) {
            default: 
        }
    }

    private void ap1_enterPreviewMapScreen_109716467() {
        NaviActionProxy naviActionProxy = this.ap1;
        try {
            naviActionProxy.enterPreviewMapScreen(this.smm.getTerminalID(), 0, 0);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterPreviewMapScreen");
        }
    }

    public void execEnterAction(SMServices sMServices, int n) {
        switch (n) {
            case 500000: {
                sMServices.pushDrawerIDs(0, 0L);
                return;
            }
            case 500001: {
                sMServices.setColor(3);
                return;
            }
            case 500009: {
                ActionProxy actionProxy = this.ap0;
                try {
                    actionProxy.tmcEnterDetailsScreen(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionInfoActionProxy(actionProxy, nullPointerException, "tmcEnterDetailsScreen");
                }
                actionProxy = this.ap1;
                try {
                    actionProxy.enterTrafficDetails(this.smm.getTerminalID(), 0);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(actionProxy, nullPointerException, "enterTrafficDetails");
                }
                return;
            }
            case 500010: {
                InfoActionProxy infoActionProxy = this.ap0;
                try {
                    infoActionProxy.tmcEnterScreens(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionInfoActionProxy(infoActionProxy, nullPointerException, "tmcEnterScreens");
                }
                sMServices.setColor(3);
                return;
            }
            case 500012: {
                this.ap1_enterPreviewMapScreen_109716467();
                return;
            }
            case 500013: {
                this.ap1_enterPreviewMapScreen_109716467();
                return;
            }
            case 500014: {
                sMServices.setColor(3);
                sMServices.pushDrawerIDs(0L, 0L);
                sMServices.addContext(0);
                return;
            }
            case 500015: {
                this.ap1_enterPreviewMapScreen_109716467();
                return;
            }
            case 500016: {
                sMServices.setColor(3);
                return;
            }
            case 500017: {
                NaviActionProxy naviActionProxy = this.ap1;
                try {
                    naviActionProxy.setMapActiveContext(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setMapActiveContext");
                }
                return;
            }
            case 500018: {
                sMServices.setScreenMode(2);
                sMServices.pushDrawerIDs(0L, 0L);
                ActionProxy actionProxy = this.ap1;
                try {
                    actionProxy.setMapShowDetailsContext(this.smm.getTerminalID(), 0);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(actionProxy, nullPointerException, "setMapShowDetailsContext");
                }
                actionProxy = this.ap2;
                try {
                    actionProxy.setTopLevelScreen(this.smm.getTerminalID(), 4, false);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTopLevelScreenActionProxy(actionProxy, nullPointerException, "setTopLevelScreen");
                }
                return;
            }
        }
    }

    private void ap0_tmcEnterMainScreen_2107068339() {
        InfoActionProxy infoActionProxy = this.ap0;
        try {
            infoActionProxy.tmcEnterMainScreen(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionInfoActionProxy(infoActionProxy, nullPointerException, "tmcEnterMainScreen");
        }
    }

    public void execTransitionAction(SMServices sMServices, int n, int n2) {
        switch (n) {
            case 500002: {
                switch (n2) {
                    case 0: {
                        this.ap0_tmcEnterMainScreen_2107068339();
                        return;
                    }
                }
                return;
            }
            case 500004: {
                this.ap0_tmcEnterMainScreen_2107068339();
                return;
            }
            case 500027: {
                this.ap0_tmcEnterMainScreen_2107068339();
                return;
            }
        }
    }

    public HMIModel getModel(int n) {
        return this.smm.getModel(n);
    }
}

