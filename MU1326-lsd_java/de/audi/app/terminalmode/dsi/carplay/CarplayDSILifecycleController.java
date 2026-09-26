/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.carplay;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeConfiguration;
import de.audi.app.terminalmode.diagnosis.IDiagnosisCommandProvider;
import de.audi.app.terminalmode.dsi.AbstractDSIController;
import de.audi.app.terminalmode.dsi.carplay.CarplayDSILifecycleController$CarplayDSIController;
import de.audi.app.terminalmode.dsi.carplay.CarplayDSILifecycleController$DSICarplayListenerImpl;
import de.audi.app.terminalmode.dsi.carplay.CarplayDSILifecycleController$TerminalModeDSIKeyEventsController;
import de.audi.app.terminalmode.dsi.carplay.DSICarplaySafe;
import de.audi.app.terminalmode.dsi.carplay.DSICarplaySafeProxy;
import de.audi.app.terminalmode.dsi.carplay.ICarplayDSIController;
import de.audi.app.terminalmode.dsi.carplay.IDSICarplayTransferObjectFactory;
import de.audi.app.terminalmode.keyevents.ITerminalModeDSIKeyEventsController;
import de.audi.app.terminalmode.keyevents.Key;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carplay.DSICarplay;
import org.dsi.ifc.carplay.TouchEvent;

public class CarplayDSILifecycleController
extends AbstractDSIController
implements IDiagnosisCommandProvider {
    private final DSICarplaySafeProxy dsiCarplayProxy;
    private final DSICarplaySafe dsiCarplaySafe;
    private final ITerminalModeConfiguration configuration;
    private final CarplayDSILifecycleController$DSICarplayListenerImpl dsiCarPlayListener;
    private volatile Key lastJoystickkey;
    private final CarplayDSILifecycleController$CarplayDSIController carPlayDsiController;
    private final ITerminalModeDSIKeyEventsController keyEventController;
    private final IFrameworkAccess fw;
    private final IContext tmManager;
    private final IDSICarplayTransferObjectFactory transferObjectFactory;
    private volatile TouchEvent[] lastFingers;
    private static final String postButton;
    private static final String requestUI;
    static /* synthetic */ Class class$org$dsi$ifc$carplay$DSICarplay;
    static /* synthetic */ Class class$org$dsi$ifc$carplay$DSICarplayListener;
    static /* synthetic */ Class class$de$audi$app$terminalmode$dsi$carplay$ICarplayDSIControllerListener;

    public CarplayDSILifecycleController(IContext iContext, IDSICarplayTransferObjectFactory iDSICarplayTransferObjectFactory, DSICarplaySafe dSICarplaySafe, CarplayDSILifecycleController$DSICarplayListenerImpl dSICarplayListenerImpl, DSICarplaySafeProxy dSICarplaySafeProxy) {
        super(0, iContext.getServiceManager(), iContext.getFramework(), iContext.getDispatcher(), true, iContext.getLogger().dsi());
        this.dsiCarplaySafe = dSICarplaySafe;
        this.dsiCarplayProxy = dSICarplaySafeProxy;
        this.dsiCarPlayListener = dSICarplayListenerImpl;
        this.carPlayDsiController = new CarplayDSILifecycleController$CarplayDSIController(this, null);
        this.configuration = iContext.getConfiguration();
        this.keyEventController = new CarplayDSILifecycleController$TerminalModeDSIKeyEventsController(this, null);
        this.fw = iContext.getFramework();
        this.tmManager = iContext;
        iContext.getDiagnosisManager().addCommandProvider(0, this);
        this.transferObjectFactory = iDSICarplayTransferObjectFactory;
    }

    @Override
    public void init() {
        super.init();
        this.startDSI();
        this.dsiCarPlayListener.init();
        this.carPlayDsiController.init();
    }

    @Override
    public void deinit() {
        super.deinit();
        this.carPlayDsiController.deinit();
    }

    public ICarplayDSIController getDioDsiController() {
        return this.carPlayDsiController;
    }

    public ITerminalModeDSIKeyEventsController getKeyEventController() {
        return this.keyEventController;
    }

    @Override
    protected Class getDSIServiceClass() {
        return class$org$dsi$ifc$carplay$DSICarplay == null ? (class$org$dsi$ifc$carplay$DSICarplay = CarplayDSILifecycleController.class$("org.dsi.ifc.carplay.DSICarplay")) : class$org$dsi$ifc$carplay$DSICarplay;
    }

    @Override
    protected DSIListener getDSIListener() {
        return this.dsiCarPlayListener;
    }

    @Override
    protected Class getDSIListenerClass() {
        return class$org$dsi$ifc$carplay$DSICarplayListener == null ? (class$org$dsi$ifc$carplay$DSICarplayListener = CarplayDSILifecycleController.class$("org.dsi.ifc.carplay.DSICarplayListener")) : class$org$dsi$ifc$carplay$DSICarplayListener;
    }

    @Override
    protected void addDSIService(DSIBase dSIBase) {
        this.dsiCarplayProxy.addDSIService((DSICarplay)dSIBase);
    }

    @Override
    protected void removeDSIService() {
        this.dsiCarplayProxy.removeDSIService();
    }

    @Override
    public String[] getDiagKeys() {
        return new String[]{"postButton(CarplayId)", "requestUI"};
    }

    @Override
    public void executeDiagCommand(String string, String[] stringArray) {
        if ("postButton(CarplayId)".equals(string) && stringArray.length > 0) {
            int n = Integer.parseInt(stringArray[0]);
            this.dsiCarplaySafe.postButtonEvent(n, 0);
            this.dsiCarplaySafe.postButtonEvent(n, 1);
        } else if ("requestUI".equals(string)) {
            this.dsiCarplaySafe.requestUI(0);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ LogChannel access$200(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }

    static /* synthetic */ DSICarplaySafe access$300(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.dsiCarplaySafe;
    }

    static /* synthetic */ IContext access$400(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.tmManager;
    }

    static /* synthetic */ LogChannel access$500(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }

    static /* synthetic */ ITerminalModeConfiguration access$600(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.configuration;
    }

    static /* synthetic */ LogChannel access$700(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }

    static /* synthetic */ LogChannel access$800(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }

    static /* synthetic */ LogChannel access$900(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }

    static /* synthetic */ LogChannel access$1000(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }

    static /* synthetic */ LogChannel access$1100(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }

    static /* synthetic */ LogChannel access$1200(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }

    static /* synthetic */ LogChannel access$1300(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }

    static /* synthetic */ LogChannel access$1400(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }

    static /* synthetic */ LogChannel access$1500(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }

    static /* synthetic */ LogChannel access$1600(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }

    static /* synthetic */ LogChannel access$1700(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }

    static /* synthetic */ LogChannel access$1800(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }

    static /* synthetic */ LogChannel access$1900(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }

    static /* synthetic */ IDSICarplayTransferObjectFactory access$2000(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.transferObjectFactory;
    }

    static /* synthetic */ LogChannel access$2100(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }

    static /* synthetic */ LogChannel access$2200(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }

    static /* synthetic */ LogChannel access$2300(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }

    static /* synthetic */ LogChannel access$2400(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }

    static /* synthetic */ LogChannel access$2500(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }

    static /* synthetic */ LogChannel access$2600(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }

    static /* synthetic */ LogChannel access$2700(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }

    static /* synthetic */ LogChannel access$2800(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }

    static /* synthetic */ Key access$2900(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.lastJoystickkey;
    }

    static /* synthetic */ LogChannel access$3000(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }

    static /* synthetic */ Key access$2902(CarplayDSILifecycleController carplayDSILifecycleController, Key key) {
        carplayDSILifecycleController.lastJoystickkey = key;
        return carplayDSILifecycleController.lastJoystickkey;
    }

    static /* synthetic */ LogChannel access$3100(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }

    static /* synthetic */ LogChannel access$3200(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }

    static /* synthetic */ LogChannel access$3300(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }

    static /* synthetic */ TouchEvent[] access$3400(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.lastFingers;
    }

    static /* synthetic */ LogChannel access$3500(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }

    static /* synthetic */ LogChannel access$3600(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }

    static /* synthetic */ LogChannel access$3700(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }

    static /* synthetic */ TouchEvent[] access$3402(CarplayDSILifecycleController carplayDSILifecycleController, TouchEvent[] touchEventArray) {
        carplayDSILifecycleController.lastFingers = touchEventArray;
        return touchEventArray;
    }

    static /* synthetic */ LogChannel access$3800(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }

    static /* synthetic */ LogChannel access$3900(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }

    static /* synthetic */ LogChannel access$4000(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }

    static /* synthetic */ LogChannel access$4100(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }

    static /* synthetic */ LogChannel access$4200(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }

    static /* synthetic */ LogChannel access$4300(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }

    static /* synthetic */ LogChannel access$4400(CarplayDSILifecycleController carplayDSILifecycleController) {
        return carplayDSILifecycleController.logger;
    }
}

