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

    @Override
    public void init() {
        Hashtable hashtable = new Hashtable(3);
        hashtable.put("moduleID", new Integer(this.getId()));
        hashtable.put("ApplicationName", "TerminalMode");
        this.registration = this.context.getServiceManager().registerService(class$de$audi$atip$hmi$HMIApplication == null ? (class$de$audi$atip$hmi$HMIApplication = AbstractTerminalModeHMIApplication.class$("de.audi.atip.hmi.HMIApplication")) : class$de$audi$atip$hmi$HMIApplication, this, hashtable);
    }

    @Override
    public void deinit() {
        if (this.registration != null) {
            this.context.getServiceManager().unregisterService(this.registration);
        }
    }

    @Override
    public ButtonModelApp getVirtualButton(int n) {
        ButtonModelApp buttonModelApp;
        switch (n) {
            case 1: {
                buttonModelApp = this.context.getFramework().getHmiServiceApp().getButtonModel(533999616);
                break;
            }
            case 53: {
                buttonModelApp = this.context.getFramework().getHmiServiceApp().getButtonModel(886321152);
                break;
            }
            case 0: {
                buttonModelApp = this.context.getFramework().getHmiServiceApp().getButtonModel(668217344);
                break;
            }
            case 52: {
                buttonModelApp = this.context.getFramework().getHmiServiceApp().getButtonModel(869543936);
                break;
            }
            case 14: {
                buttonModelApp = this.context.getFramework().getHmiServiceApp().getButtonModel(802435072);
                break;
            }
            case 44: {
                buttonModelApp = this.context.getFramework().getHmiServiceApp().getButtonModel(819212288);
                break;
            }
            case 34: {
                if (this.context.getFramework().getSysConst(460) == 1) {
                    buttonModelApp = null;
                    break;
                }
                buttonModelApp = this.context.getButtonModel(1087647744);
                break;
            }
            case 35: {
                if (this.context.getFramework().getSysConst(460) == 1) {
                    buttonModelApp = null;
                    break;
                }
                buttonModelApp = this.context.getButtonModel(1070870528);
                break;
            }
            default: {
                buttonModelApp = null;
            }
        }
        return buttonModelApp;
    }

    @Override
    public void screenVisible(int n, int n2) {
        this.logger.log(1078071040, "<<- [%1.screenVisible] %2", (Object)this.getLogClass(), (long)n);
        if (n == this.getTerminalModeScreenId()) {
            this.context.getActionProxyDispatcher().notifyActionProxyCall(1001, n2, new Hashtable());
        }
    }

    @Override
    public void screenHidden(int n, int n2) {
        this.logger.log(1078071040, "<<- [%1.screenHidden] %2", (Object)this.getLogClass(), (long)n);
        if (n == this.getTerminalModeScreenId()) {
            this.context.getActionProxyDispatcher().notifyActionProxyCall(1002, n2, new Hashtable());
        }
    }

    @Override
    public void popupVisible(int n, int n2) {
    }

    @Override
    public void popupHidden(int n, int n2) {
    }

    @Override
    public void popupRemoved(int n, int n2) {
    }

    @Override
    public void screenFadedOut(int n, int n2) {
        this.logger.log(1078071040, "<<- [%1.screenFadedOut] %2", (Object)this.getLogClass(), (long)n);
    }

    @Override
    public void screenConnected(int n, int n2) {
        this.logger.log(1078071040, "<<- [%1.screenConnected] %2", (Object)this.getLogClass(), (long)n);
    }

    protected abstract String getLogClass() {
    }

    protected abstract int getTerminalModeScreenId() {
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

