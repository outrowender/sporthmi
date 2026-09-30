/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.widgets.audi.evo.high.MapWidgetDiagEvoHigh
 *  de.mib.swdiagnosis.widgets.audi.evo.high.WidgetsDiagEvoHigh
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.hmi.KbdService;
import de.audi.atip.msg.MsgListener;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.Layout;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.base.WidgetsActivator;
import de.esolutions.hmi.widgets.audi.evo.high.HMITerminalImplMIB2High;
import de.esolutions.hmi.widgets.audi.evo.high.HMITerminalImplMIB2Std;
import de.esolutions.hmi.widgets.audi.evo.high.HMITerminalKombiMapControl;
import de.esolutions.hmi.widgets.audi.evo.high.LayoutMIB2HighQ7;
import de.esolutions.hmi.widgets.audi.evo.high.LayoutMIB2HighScale;
import de.esolutions.hmi.widgets.audi.evo.high.LayoutMIB2MMICombiTT;
import de.esolutions.hmi.widgets.audi.evo.high.LayoutMIB2Std;
import de.esolutions.hmi.widgets.audi.evo.high.LayoutMIB2StdPlus;
import de.esolutions.hmi.widgets.audi.evo.high.ap.EntertainmentActionProxyRouter;
import de.mib.swdiagnosis.widgets.audi.evo.high.MapWidgetDiagEvoHigh;
import de.mib.swdiagnosis.widgets.audi.evo.high.WidgetsDiagEvoHigh;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;

public class WidgetsActivatorMIB2High
extends WidgetsActivator {
    private boolean sysConstInitialized = false;
    private HMITerminalImplMIB2High mainTerminal;
    private static final boolean VARIANT_STD = System.getProperty("variant.skin", "EvoHigh").indexOf("EvoStd") >= 0;
    static /* synthetic */ Class class$de$audi$atip$statemachine$ActionProxy;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;

    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        Hashtable hashtable = new Hashtable();
        hashtable.put("moduleID", new Integer(25));
        this.registerService((class$de$audi$atip$statemachine$ActionProxy == null ? (class$de$audi$atip$statemachine$ActionProxy = WidgetsActivatorMIB2High.class$("de.audi.atip.statemachine.ActionProxy")) : class$de$audi$atip$statemachine$ActionProxy).getName(), (Object)EntertainmentActionProxyRouter.getInstance(), (Dictionary)hashtable);
    }

    protected void registerTerminals(KbdService kbdService) {
        if (this.framework.isFrontMU()) {
            this.mainTerminal = (HMITerminalImplMIB2High)this.createTerminal(0, kbdService);
            if (this.framework.isDualView()) {
                this.createTerminal(2, kbdService);
            }
            this.createTerminal(1, kbdService);
        } else {
            this.createTerminal(3, kbdService);
            this.createTerminal(4, kbdService);
            this.createTerminal(5, kbdService);
        }
    }

    private HMITerminalImpl createTerminal(int n, KbdService kbdService) {
        HMITerminalImpl hMITerminalImpl = this.instantiateTerminal(n, this.bundleContext, this.framework);
        this.initializeLayout(hMITerminalImpl);
        hMITerminalImpl.setKbdService(kbdService);
        this.framework.getHMITerminalRegistry().registerTerminal(n, this.getSkinName(), hMITerminalImpl);
        return hMITerminalImpl;
    }

    void initializeLayout(HMITerminalImpl hMITerminalImpl) {
        WidgetConstants widgetConstants;
        switch (this.framework.getScreenRes()) {
            case 4: {
                widgetConstants = new LayoutMIB2MMICombiTT();
                break;
            }
            case 2: {
                widgetConstants = new LayoutMIB2HighQ7();
                break;
            }
            case 1: {
                if (VARIANT_STD) {
                    widgetConstants = new LayoutMIB2StdPlus();
                    break;
                }
                widgetConstants = new LayoutMIB2HighScale();
                break;
            }
            case 0: {
                widgetConstants = new LayoutMIB2Std();
                break;
            }
            default: {
                widgetConstants = new LayoutMIB2HighScale();
            }
        }
        hMITerminalImpl.setLayout((Layout)((Object)widgetConstants));
    }

    private String getSkinName() {
        return "EvoHigh";
    }

    private HMITerminalImpl instantiateTerminal(int n, BundleContext bundleContext, IFrameworkAccess iFrameworkAccess) {
        HMITerminalImplMIB2High hMITerminalImplMIB2High;
        if (n == 1) {
            return new HMITerminalKombiMapControl(n, bundleContext, iFrameworkAccess);
        }
        switch (iFrameworkAccess.getScreenRes()) {
            case 4: {
                hMITerminalImplMIB2High = new HMITerminalImplMIB2High(n, bundleContext, iFrameworkAccess);
                break;
            }
            case 2: {
                hMITerminalImplMIB2High = new HMITerminalImplMIB2High(n, bundleContext, iFrameworkAccess);
                break;
            }
            case 1: {
                if (VARIANT_STD) {
                    hMITerminalImplMIB2High = new HMITerminalImplMIB2Std(n, bundleContext, iFrameworkAccess);
                    break;
                }
                hMITerminalImplMIB2High = new HMITerminalImplMIB2High(n, bundleContext, iFrameworkAccess);
                break;
            }
            case 0: {
                hMITerminalImplMIB2High = new HMITerminalImplMIB2Std(n, bundleContext, iFrameworkAccess);
                break;
            }
            default: {
                hMITerminalImplMIB2High = new HMITerminalImplMIB2High(n, bundleContext, iFrameworkAccess);
            }
        }
        return hMITerminalImplMIB2High;
    }

    protected void registerDiagnosisGateways(SwDiagnosisManager swDiagnosisManager) {
        swDiagnosisManager.addDiagGateway((AbstractSwDiagnosis)WidgetsDiagEvoHigh.getInstance());
        swDiagnosisManager.addDiagGateway((AbstractSwDiagnosis)MapWidgetDiagEvoHigh.getInstance());
    }

    protected void unregisterDiagnosisGateways(SwDiagnosisManager swDiagnosisManager) {
        swDiagnosisManager.removeDiagGateway((AbstractSwDiagnosis)WidgetsDiagEvoHigh.getInstance());
        swDiagnosisManager.removeDiagGateway((AbstractSwDiagnosis)MapWidgetDiagEvoHigh.getInstance());
    }

    protected void initializeTracker(KbdService kbdService) {
        super.initializeTracker(kbdService);
        this.initializeSysConstMessageListener();
    }

    private void initializeSysConstMessageListener() {
        this.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = WidgetsActivatorMIB2High.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)new MsgListener(){

            public void processMsg(int n) {
                switch (n) {
                    case 101: {
                        WidgetsActivatorMIB2High.this.sysConstInitialized();
                        break;
                    }
                }
            }
        }, null);
        IWidgetLogChannel.logWidgetStartup.log(10000000, "WidgetsActivatorMIB2High#initializeSysConstMessageListener: Message listener registered");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void sysConstInitialized() {
        WidgetsActivatorMIB2High widgetsActivatorMIB2High = this;
        synchronized (widgetsActivatorMIB2High) {
            if (this.sysConstInitialized) {
                IWidgetLogChannel.logWidgetStartup.log(10000000, "WidgetsActivatorMIB2High#setSysConstInitialized: was already initialized, do nothing");
                return;
            }
            this.sysConstInitialized = true;
        }
        IWidgetLogChannel.logWidgetStartup.log(10000000, "WidgetsActivatorMIB2High#setSysConstInitialized: post initial events after sysConst");
        this.mainTerminal.postInitialEventsAfterSysConst();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

