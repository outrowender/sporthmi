/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.osgi.IServiceTracker;
import de.audi.app.media.transfer.ITransferController;
import de.audi.app.media.transfer.ITransferLockListener;
import de.audi.app.media.transfer.TransferLogger;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractTransferHMIHandler
extends AbstractMediaTerminalComponent
implements ITransferLockListener,
ServiceTrackerCustomizer {
    private static final String LOGCLASS = "AbstractTransferHMIHandler";
    protected LogChannel logger;
    private volatile ITransferController transferController;
    private IServiceTracker serviceTracker;
    static /* synthetic */ Class class$de$audi$app$media$transfer$ITransferController;

    public AbstractTransferHMIHandler(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
        this.logger = new TransferLogger(iMediaTerminal.getFramework()).hmi();
        this.serviceTracker = this.getTerminal().getServiceManager().createServiceTracker(class$de$audi$app$media$transfer$ITransferController == null ? (class$de$audi$app$media$transfer$ITransferController = AbstractTransferHMIHandler.class$("de.audi.app.media.transfer.ITransferController")) : class$de$audi$app$media$transfer$ITransferController, this);
    }

    public void init() {
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.serviceTracker.open();
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.serviceTracker.close();
    }

    public Object addingService(ServiceReference serviceReference) {
        this.logger.log(1000000, "[%1.addingService]", (Object)LOGCLASS);
        Object object = this.getTerminal().getServiceManager().getService(serviceReference);
        if (!(object instanceof ITransferController)) {
            this.logger.log(1000000, "[%1.addingService] unwanted service", (Object)LOGCLASS);
            this.getTerminal().getServiceManager().releaseService(serviceReference);
            return object;
        }
        this.transferController = (ITransferController)object;
        this.transferControllerAvailable();
        return object;
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        this.transferControllerUnavailable();
        this.getTerminal().getServiceManager().releaseService(serviceReference);
    }

    public abstract void transferControllerAvailable();

    public abstract void transferControllerUnavailable();

    public void blockImportFunctionality() {
        this.logger.log(1000000, "[%1.blockImportFunctionality]", (Object)LOGCLASS);
        this.getChoiceModel(200299).setValue(1);
    }

    public void unblockImportFunctionality() {
        this.logger.log(1000000, "[%1.unblockImportFunctionality]", (Object)LOGCLASS);
        this.getChoiceModel(200299).setValue(0);
    }

    protected ITransferController getTransferController() {
        return this.transferController;
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

