/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.search;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.dsi.IDSIControllerStateListener;
import de.audi.app.media.evo.content.data.search.dsi.IMediaDSISearchDataController;
import de.audi.app.media.evo.content.data.search.dsi.IMediaSearchDataProviderListener;
import de.audi.app.media.evo.content.data.search.dsi.MediaDSISearchDataProviderController;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.search.DataSet;

public abstract class AbstractMediaSearchDataProvider
implements IMediaSearchDataProviderListener,
IDSIControllerStateListener {
    private static final String LOGCLASS = "AbstractMediaSearchDataProvider";
    private final LogChannel logger;
    private final int searchSourceId;
    private final IMediaDSISearchDataController dsiSearchDataController;
    private volatile boolean isActive;

    public AbstractMediaSearchDataProvider(IMediaTerminal iMediaTerminal, int n) {
        this.dsiSearchDataController = new MediaDSISearchDataProviderController(2, iMediaTerminal.getServiceManager(), iMediaTerminal.getFramework(), iMediaTerminal.getDispatcher(), true, iMediaTerminal.getLogger().dsi());
        this.logger = iMediaTerminal.getLogger().main();
        this.searchSourceId = n;
    }

    public void init() {
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.dsiSearchDataController.init();
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.dsiSearchDataController.deinit();
    }

    public void activate() {
        this.logger.log(1000000, "[%1.activate]", (Object)LOGCLASS);
        this.isActive = false;
        this.dsiSearchDataController.setStateListener(this);
        this.dsiSearchDataController.setMediaSearchDataProviderListener(this);
        this.dsiSearchDataController.startDSI();
    }

    public void deactivate() {
        this.logger.log(1000000, "[%1.deactivate]", (Object)LOGCLASS);
        this.dsiSearchDataController.setStateListener(null);
        this.dsiSearchDataController.setMediaSearchDataProviderListener(null);
    }

    public void registerProviderSourceResult(boolean bl, int n) {
        if (n == this.searchSourceId) {
            return;
        }
        this.logger.log(1000000, "[%1.registerProviderSourceResult]", (Object)LOGCLASS);
        if (!bl) {
            this.logger.log(1000000, "[%1.registerProviderSourceResult] Registration was not successful for source='%2'.", (Object)LOGCLASS, (long)n);
        }
    }

    public void activateProviderSource(int n) {
        if (n != this.searchSourceId) {
            return;
        }
        this.isActive = true;
        this.providerSourceActivated();
    }

    public void sourceDataAvailabilityChanged(boolean bl) {
        this.dsiSearchDataController.sourceDataAvailabilityChanged(this.searchSourceId, bl);
    }

    public void invalidateAllData() {
        this.dsiSearchDataController.invalidateAllData(this.searchSourceId);
    }

    public void storeDataSets(DataSet[] dataSetArray, int n) {
        this.dsiSearchDataController.storeDataSets(this.searchSourceId, dataSetArray, n);
    }

    public void deleteDataSet(int n, long l) {
        this.dsiSearchDataController.deleteDataSet(this.searchSourceId, l);
    }

    public void dsiAvailable() {
        this.logger.log(1000000, "[%1.dsiAvailable]", (Object)LOGCLASS);
        this.dsiSearchDataController.registerProviderSource(this.searchSourceId);
        this.isActive = true;
    }

    public void dsiUnavailable() {
        this.logger.log(1000000, "[%1.dsiUnavailable]", (Object)LOGCLASS);
        this.isActive = false;
    }

    protected boolean isActive() {
        return this.isActive;
    }

    protected abstract void providerSourceActivated();
}

