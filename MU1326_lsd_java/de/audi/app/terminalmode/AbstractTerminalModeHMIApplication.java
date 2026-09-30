/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.log.LogChannel;
import java.util.Hashtable;
import org.osgi.framework.ServiceRegistration;

public abstract class AbstractTerminalModeHMIApplication
implements HMIApplication,
ITerminalModeComponent {
    protected final LogChannel logger;
    protected final IContext context;
    private volatile ServiceRegistration registration;
    static /* synthetic */ Class class$de$audi$atip$hmi$HMIApplication;

    public AbstractTerminalModeHMIApplication(IContext iContext) {
        this.context = iContext;
        this.logger = iContext.getLogger().main();
    }

    public void init() {
        Hashtable hashtable = new Hashtable(3);
        hashtable.put("moduleID", new Integer(this.getId()));
        hashtable.put("ApplicationName", "TerminalMode");
        this.registration = this.context.getServiceManager().registerService(class$de$audi$atip$hmi$HMIApplication == null ? (class$de$audi$atip$hmi$HMIApplication = AbstractTerminalModeHMIApplication.class$("de.audi.atip.hmi.HMIApplication")) : class$de$audi$atip$hmi$HMIApplication, this, hashtable);
    }

    public void deinit() {
        if (this.registration != null) {
            this.context.getServiceManager().unregisterService(this.registration);
        }
    }

    public ButtonModelApp getVirtualButton(int n) {
        ButtonModelApp buttonModelApp;
        switch (n) {
            case 1: {
                buttonModelApp = this.context.getFramework().getHmiServiceApp().getButtonModel(3200031);
                break;
            }
            case 53: {
                buttonModelApp = this.context.getFramework().getHmiServiceApp().getButtonModel(3200052);
                break;
            }
            case 0: {
                buttonModelApp = this.context.getFramework().getHmiServiceApp().getButtonModel(3200039);
                break;
            }
            case 52: {
                buttonModelApp = this.context.getFramework().getHmiServiceApp().getButtonModel(3200051);
                break;
            }
            case 14: {
                buttonModelApp = this.context.getFramework().getHmiServiceApp().getButtonModel(3200047);
                break;
            }
            case 44: {
                buttonModelApp = this.context.getFramework().getHmiServiceApp().getButtonModel(3200048);
                break;
            }
            case 34: {
                if (this.context.getFramework().getSysConst(460) == 1) {
                    buttonModelApp = null;
                    break;
                }
                buttonModelApp = this.context.getButtonModel(3200064);
                break;
            }
            case 35: {
                if (this.context.getFramework().getSysConst(460) == 1) {
                    buttonModelApp = null;
                    break;
                }
                buttonModelApp = this.context.getButtonModel(3200063);
                break;
            }
            default: {
                buttonModelApp = null;
            }
        }
        return buttonModelApp;
    }

    public void screenVisible(int n, int n2) {
        this.logger.log(1000000, "<<- [%1.screenVisible] %2", (Object)this.getLogClass(), (long)n);
        if (n == this.getTerminalModeScreenId()) {
            this.context.getActionProxyDispatcher().notifyActionProxyCall(1001, n2, new Hashtable());
        }
    }

    public void screenHidden(int n, int n2) {
        this.logger.log(1000000, "<<- [%1.screenHidden] %2", (Object)this.getLogClass(), (long)n);
        if (n == this.getTerminalModeScreenId()) {
            this.context.getActionProxyDispatcher().notifyActionProxyCall(1002, n2, new Hashtable());
        }
    }

    public void popupVisible(int n, int n2) {
    }

    public void popupHidden(int n, int n2) {
    }

    public void popupRemoved(int n, int n2) {
    }

    public void screenFadedOut(int n, int n2) {
        this.logger.log(1000000, "<<- [%1.screenFadedOut] %2", (Object)this.getLogClass(), (long)n);
    }

    public void screenConnected(int n, int n2) {
        this.logger.log(1000000, "<<- [%1.screenConnected] %2", (Object)this.getLogClass(), (long)n);
    }

    protected abstract String getLogClass();

    protected abstract int getTerminalModeScreenId();

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

