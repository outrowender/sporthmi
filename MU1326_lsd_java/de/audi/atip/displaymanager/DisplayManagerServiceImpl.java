/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.displaymanager;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.displaymanager.AbstractComponentCommand;
import de.audi.atip.displaymanager.DSIDisplayManagerControllerImpl;
import de.audi.atip.displaymanager.DisplayManagerState;
import de.audi.atip.displaymanager.IDSIDisplayManagerController;
import de.audi.atip.displaymanager.SetCroppingCommand;
import de.audi.atip.displaymanager.StartComponentCommand;
import de.audi.atip.displaymanager.StopComponentCommand;
import de.audi.atip.interapp.displaymanager.DSIMgnHandler;
import de.audi.atip.interapp.displaymanager.IDisplayManagerListener;
import de.audi.atip.interapp.displaymanager.IDisplayManagerService;
import de.audi.atip.interapp.displaymanager.IDisplayManagerServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class DisplayManagerServiceImpl
implements IDisplayManagerService,
IDisplayManagerListener {
    private static final String LOGCLASS = "DisplayManagerServiceImpl";
    private final LogChannel logger;
    private final BundleContext bundleContext;
    private final IDSIDisplayManagerController displayManagerController;
    private final CommandListManager commandListManager;
    private final DSIMgnHandler croppingHandler;
    private DisplayManagerState state;
    private final Object stateMutex = new Object();
    private volatile ServiceRegistration registerService;
    static /* synthetic */ Class class$de$audi$atip$interapp$displaymanager$IDisplayManagerService;

    public DisplayManagerServiceImpl(IFrameworkAccess iFrameworkAccess, BundleContext bundleContext) {
        this.logger = iFrameworkAccess.getLogChannel("Fw.DisplayManager.Main");
        this.bundleContext = bundleContext;
        this.displayManagerController = new DSIDisplayManagerControllerImpl(0, bundleContext, iFrameworkAccess, iFrameworkAccess.getLogChannel("Fw.DisplayManager.DSI"));
        this.commandListManager = new CommandListManager("DisplayManagerQueue", iFrameworkAccess, this.logger, null, null);
        this.croppingHandler = new DSIMgnHandler(iFrameworkAccess);
        this.state = new DisplayManagerState();
    }

    public void init() {
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.registerService = this.bundleContext.registerService((class$de$audi$atip$interapp$displaymanager$IDisplayManagerService == null ? (class$de$audi$atip$interapp$displaymanager$IDisplayManagerService = DisplayManagerServiceImpl.class$("de.audi.atip.interapp.displaymanager.IDisplayManagerService")) : class$de$audi$atip$interapp$displaymanager$IDisplayManagerService).getName(), (Object)this, (Dictionary)new Hashtable(0));
        this.displayManagerController.addListener(this);
        this.commandListManager.start();
        this.displayManagerController.startDSI();
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.commandListManager.destroy();
        this.displayManagerController.stopDSI();
        this.displayManagerController.addListener(null);
        if (null != this.registerService) {
            this.registerService.unregister();
            this.registerService = null;
        }
    }

    public void activateComponent(int n, IDisplayManagerServiceListener iDisplayManagerServiceListener) {
        this.logger.log(1000000, "[%1.activateComponent] %2", (Object)LOGCLASS, (long)n);
        CommandList commandList = new CommandList(this.commandListManager);
        commandList.add(new StartComponentCommand(this, this.logger, this.displayManagerController, n, iDisplayManagerServiceListener));
        this.commandListManager.execute(commandList);
    }

    public void deactivateComponent(int n, IDisplayManagerServiceListener iDisplayManagerServiceListener) {
        this.logger.log(1000000, "[%1.deactivateComponent] %2", (Object)LOGCLASS, (long)n);
        CommandList commandList = new CommandList(this.commandListManager);
        commandList.add(new StopComponentCommand(this, this.logger, this.displayManagerController, n, iDisplayManagerServiceListener));
        this.commandListManager.execute(commandList);
    }

    public void activateComponent(int n) {
        this.activateComponent(n, null);
    }

    public void deactivateComponent(int n) {
        this.deactivateComponent(n, null);
    }

    public void activateComponentRVC(int n) {
        this.logger.log(1000000, "[%1.activateComponentRVC]", (Object)LOGCLASS);
        this.displayManagerController.startComponent(n, 0, 0);
    }

    public void deactivateComponentRVC(int n) {
        this.logger.log(1000000, "[%1.deactivateComponentRVC]", (Object)LOGCLASS);
        this.displayManagerController.stopComponent(n, 0, 0);
    }

    public void setCropping(int n, int n2, int n3, int n4, IDisplayManagerServiceListener iDisplayManagerServiceListener) {
        this.logger.log(1000000, "[%1.setCropping]", (Object)LOGCLASS);
        CommandList commandList = new CommandList(this.commandListManager);
        commandList.add(new SetCroppingCommand(this, this.logger, this.displayManagerController, this.croppingHandler.getCropping(n2), 0, 0, n3, n4, iDisplayManagerServiceListener));
        this.commandListManager.execute(commandList);
    }

    public void setCropping(int n, int n2, int n3, int n4, int n5, int n6, IDisplayManagerServiceListener iDisplayManagerServiceListener) {
        this.logger.log(1000000, "[%1.setCropping]", (Object)LOGCLASS);
        CommandList commandList = new CommandList(this.commandListManager);
        commandList.add(new SetCroppingCommand(this, this.logger, this.displayManagerController, this.croppingHandler.getCropping(n2), n3, n4, n5, n6, iDisplayManagerServiceListener));
        this.commandListManager.execute(commandList);
    }

    public int getCurrentDisplayable() {
        return this.state.getDisplayableId();
    }

    private AbstractComponentCommand getActiveCommand() {
        Command command;
        Command command2 = command = this.commandListManager.getActiveCommandList() == null ? null : this.commandListManager.getActiveCommandList().getActiveCommand();
        if (command instanceof AbstractComponentCommand) {
            return (AbstractComponentCommand)command;
        }
        return new AbstractComponentCommand(this.logger, LOGCLASS){

            public void execute() {
            }
        };
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void setDisplayManagerState(DisplayManagerState displayManagerState) {
        Object object = this.stateMutex;
        synchronized (object) {
            this.state = displayManagerState;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected DisplayManagerState getDisplayManagerState() {
        Object object = this.stateMutex;
        synchronized (object) {
            return this.state;
        }
    }

    public void startComponentResult(int n, int n2, int n3, int n4) {
        this.logger.log(1000000, "[%1.startComponentResult]", (Object)LOGCLASS);
        this.getActiveCommand().startComponentResult(n, n2, n3, n4);
    }

    public void stopComponentResult(int n, int n2, int n3, int n4) {
        this.logger.log(1000000, "[%1.stopComponentResult]", (Object)LOGCLASS);
        this.getActiveCommand().stopComponentResult(n, n2, n3, n4);
    }

    public void setCroppingResult(int n) {
        this.logger.log(1000000, "[%1.setCroppingResult]", (Object)LOGCLASS);
        this.getActiveCommand().setCroppingResult(n);
    }

    public void error() {
        this.getActiveCommand().error();
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

