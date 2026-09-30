/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.earlyapps.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.ap.EarlyAppsActionProxy;
import java.util.NoSuchElementException;

public class EarlyAppsSMMActions
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;
    private volatile EarlyAppsActionProxy ap0;
    public static int[] REQUIRED_ACTION_PROXY_MODULE_IDS = new int[]{3};

    protected EarlyAppsSMMActions(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    public void removeActionProxy(int n, ActionProxy actionProxy) {
        if (actionProxy instanceof EarlyAppsActionProxy) {
            this.ap0 = null;
            this.logChannel.log(10000000, "EarlyAppsActionProxy Action Proxy removed");
            return;
        }
    }

    public ActionProxy addActionProxy(int n, ActionProxy actionProxy) {
        if (actionProxy instanceof EarlyAppsActionProxy) {
            this.ap0 = (EarlyAppsActionProxy)actionProxy;
            this.logChannel.log(10000000, "EarlyAppsActionProxy Action Proxy added");
            return this.ap0;
        }
        return null;
    }

    private void catchActionExceptionEarlyAppsActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'EarlyAppsActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1000000, "Action Proxy 'EarlyAppsActionProxy' missing for call '%1'", (Object)string);
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
            case 2100042: {
                sMServices.removeContext(-342076071L);
                return;
            }
            case 2100043: {
                sMServices.removeContext(1033578716L);
                return;
            }
            case 2100054: {
                sMServices.removeContext(-93834L);
                return;
            }
            case 2100055: {
                sMServices.removeContext(-93834L);
                return;
            }
            case 2100062: {
                sMServices.popDrawerIDs();
                sMServices.setScreenMode(1);
                return;
            }
            case 2100066: {
                sMServices.removeContext(1341779114L);
                return;
            }
            case 2100067: {
                sMServices.removeContext(456296360L);
                return;
            }
            case 2100068: {
                sMServices.popDrawerIDs();
                EarlyAppsActionProxy earlyAppsActionProxy = this.ap0;
                try {
                    earlyAppsActionProxy.phevGoodbyeEntered(this.smm.getTerminalID(), false);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionEarlyAppsActionProxy(earlyAppsActionProxy, nullPointerException, "phevGoodbyeEntered");
                }
                return;
            }
            case 2100069: {
                sMServices.removeContext(456296360L);
                sMServices.popDrawerIDs();
                return;
            }
            case 2100071: {
                sMServices.removeContext(-93834L);
                sMServices.removeContext(-823312789L);
                return;
            }
            case 2100072: {
                sMServices.removeContext(-823312789L);
                sMServices.removeContext(-93834L);
                return;
            }
            case 2100073: {
                sMServices.removeContext(-823312789L);
                sMServices.removeContext(-93834L);
                return;
            }
            case 2100075: {
                sMServices.popDrawerIDs();
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
            case 2100042: {
                sMServices.addContext(-342076071L);
                return;
            }
            case 2100043: {
                sMServices.addContext(1033578716L);
                return;
            }
            case 2100054: {
                sMServices.addContext(-93834L);
                return;
            }
            case 2100055: {
                sMServices.addContext(-93834L);
                return;
            }
            case 2100058: {
                sMServices.pushDrawerIDs(0L, 2100024L);
                sMServices.setColor(1);
                return;
            }
            case 2100062: {
                sMServices.pushDrawerIDs(0L, 0L);
                sMServices.setScreenMode(2);
                return;
            }
            case 2100066: {
                sMServices.addContext(1341779114L);
                return;
            }
            case 2100067: {
                sMServices.addContext(456296360L);
                return;
            }
            case 2100068: {
                sMServices.pushDrawerIDs(0L, 2100024L);
                sMServices.setColor(1);
                EarlyAppsActionProxy earlyAppsActionProxy = this.ap0;
                try {
                    earlyAppsActionProxy.phevGoodbyeEntered(this.smm.getTerminalID(), true);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionEarlyAppsActionProxy(earlyAppsActionProxy, nullPointerException, "phevGoodbyeEntered");
                }
                return;
            }
            case 2100069: {
                sMServices.addContext(456296360L);
                sMServices.pushDrawerIDs(0L, 0L);
                return;
            }
            case 2100070: {
                sMServices.setColor(1);
                return;
            }
            case 2100071: {
                sMServices.addContext(-93834L);
                sMServices.addContext(-823312789L);
                return;
            }
            case 2100072: {
                sMServices.addContext(-93834L);
                sMServices.addContext(-823312789L);
                return;
            }
            case 2100073: {
                sMServices.addContext(-93834L);
                sMServices.addContext(-823312789L);
                return;
            }
            case 2100075: {
                sMServices.setColor(1);
                sMServices.pushDrawerIDs(0L, 2100024L);
                return;
            }
        }
    }

    public void execTransitionAction(SMServices sMServices, int n, int n2) {
        switch (n) {
            case 2100075: {
                switch (n2) {
                    case 0: {
                        sMServices.addScreenAnimation(32);
                        return;
                    }
                    case 1: {
                        sMServices.addScreenAnimation(32);
                        return;
                    }
                }
                return;
            }
            case 2100076: {
                switch (n2) {
                    case 0: {
                        sMServices.addScreenAnimation(32);
                        return;
                    }
                    case 1: {
                        sMServices.addScreenAnimation(32);
                        return;
                    }
                }
                return;
            }
            case 2100081: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2100082: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2100084: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2100085: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2100089: {
                switch (n2) {
                    case 0: {
                        sMServices.addScreenAnimation(32);
                        return;
                    }
                    case 1: {
                        sMServices.addScreenAnimation(32);
                        return;
                    }
                }
                return;
            }
            case 2100090: {
                sMServices.addScreenAnimation(32);
                return;
            }
            case 2100091: {
                switch (n2) {
                    case 0: {
                        sMServices.addScreenAnimation(32);
                        return;
                    }
                }
                return;
            }
            case 2100092: {
                sMServices.addScreenAnimation(32);
                return;
            }
            case 2100093: {
                switch (n2) {
                    case 0: {
                        sMServices.addScreenAnimation(32);
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

