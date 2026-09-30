/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap;

import de.audi.app.media.combi.bap.CombiBAPController;
import de.audi.app.media.interapp.ITransferStateListener;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Hashtable;
import org.osgi.framework.ServiceRegistration;

public class CombiBAPTransferStateListener
implements ITransferStateListener {
    private static final String LOGCLASS = "CombiBAPTransferStateListener";
    private final LogChannel logger;
    private final IServiceManager serviceManager;
    private final CombiBAPController bapController;
    private volatile ServiceRegistration serviceRegistration;
    private ISourceSlot activeImportSlot = null;
    static /* synthetic */ Class class$de$audi$app$media$interapp$ITransferStateListener;

    public CombiBAPTransferStateListener(LogChannel logChannel, IServiceManager iServiceManager, CombiBAPController combiBAPController) {
        this.logger = logChannel;
        this.serviceManager = iServiceManager;
        this.bapController = combiBAPController;
    }

    public void init() {
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.serviceRegistration = this.serviceManager.registerService(class$de$audi$app$media$interapp$ITransferStateListener == null ? (class$de$audi$app$media$interapp$ITransferStateListener = CombiBAPTransferStateListener.class$("de.audi.app.media.interapp.ITransferStateListener")) : class$de$audi$app$media$interapp$ITransferStateListener, this, new Hashtable(0));
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.serviceManager.unregisterService(this.serviceRegistration);
    }

    public void importStarted(ISourceSlot iSourceSlot) {
        this.logger.log(1000000, "[%1.importStarted] '%2'", (Object)LOGCLASS, (Object)iSourceSlot);
        this.bapController.updateImportState(iSourceSlot, true, 0);
        this.activeImportSlot = iSourceSlot;
    }

    public void importProgressChanged(int n) {
        this.logger.log(1000000, "[%1.importProgressChanged] '%2'", (Object)LOGCLASS, (long)n);
        this.bapController.updateImportState(this.activeImportSlot, true, n);
    }

    public void importStopped() {
        this.logger.log(1000000, "[%1.importStopped]", (Object)LOGCLASS);
        this.bapController.updateImportState(this.activeImportSlot, false, 0);
        this.activeImportSlot = null;
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append(LOGCLASS).append("@").append(this.hashCode());
        return buffer.toString();
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

