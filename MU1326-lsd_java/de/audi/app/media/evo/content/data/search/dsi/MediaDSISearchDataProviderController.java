/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.search.dsi;

import de.audi.app.media.dsi.AbstractDSIController;
import de.audi.app.media.evo.content.data.search.dsi.IMediaDSISearchDataController;
import de.audi.app.media.evo.content.data.search.dsi.IMediaSearchDataProviderListener;
import de.audi.app.media.evo.content.data.search.dsi.MediaDSISearchDataProviderController$1;
import de.audi.app.media.evo.content.data.search.dsi.MediaDSISearchDataProviderController$2;
import de.audi.app.media.evo.content.data.search.dsi.MediaDSISearchDataProviderController$3;
import de.audi.app.media.evo.content.data.search.dsi.MediaDSISearchDataProviderController$4;
import de.audi.app.media.evo.content.data.search.dsi.MediaDSISearchDataProviderController$5;
import de.audi.app.media.evo.content.data.search.dsi.MediaDSISearchDataProviderController$6;
import de.audi.app.media.evo.content.data.search.dsi.MediaDSISearchDataProviderController$7;
import de.audi.app.media.evo.content.data.search.dsi.NullDSISearchDataProvider;
import de.audi.app.media.evo.content.data.search.dsi.NullMediaSearchDataProviderListener;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.search.DSISearchDataProvider;
import org.dsi.ifc.search.DSISearchDataProviderListener;
import org.dsi.ifc.search.DataSet;

public class MediaDSISearchDataProviderController
extends AbstractDSIController
implements IMediaDSISearchDataController,
DSISearchDataProviderListener {
    private static final String LOGCLASS;
    private volatile IMediaSearchDataProviderListener mediaSearchDataProviderListener;
    private volatile DSISearchDataProvider dsiSearchDataProvider;
    private final DSISearchDataProvider nullDsiSearchDataProvider = new NullDSISearchDataProvider();
    private final IMediaSearchDataProviderListener nullMediaSearchDataProviderListener = new NullMediaSearchDataProviderListener();
    private final DispatcherBase dispatcher;
    static /* synthetic */ Class class$org$dsi$ifc$search$DSISearchDataProvider;
    static /* synthetic */ Class class$org$dsi$ifc$search$DSISearchDataProviderListener;

    public MediaDSISearchDataProviderController(int n, IServiceManager iServiceManager, IFrameworkAccess iFrameworkAccess, DispatcherBase dispatcherBase, boolean bl, LogChannel logChannel) {
        super(n, iServiceManager, iFrameworkAccess, dispatcherBase, bl, logChannel);
        this.dsiSearchDataProvider = this.nullDsiSearchDataProvider;
        this.mediaSearchDataProviderListener = this.nullMediaSearchDataProviderListener;
        this.dispatcher = dispatcherBase;
    }

    @Override
    public void setMediaSearchDataProviderListener(IMediaSearchDataProviderListener iMediaSearchDataProviderListener) {
        if (null == iMediaSearchDataProviderListener) {
            this.mediaSearchDataProviderListener = this.nullMediaSearchDataProviderListener;
            return;
        }
        this.mediaSearchDataProviderListener = iMediaSearchDataProviderListener;
    }

    public void setNotification(int[] nArray, DSIListener dSIListener) {
    }

    public void setNotification(int n, DSIListener dSIListener) {
    }

    public void setNotification(DSIListener dSIListener) {
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
    }

    public void clearNotification(int n, DSIListener dSIListener) {
    }

    public void clearNotification(DSIListener dSIListener) {
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.logger.log(1078071040, "[%1.asyncException]", (Object)"MediaDSISearchDataProviderController");
        IMediaSearchDataProviderListener iMediaSearchDataProviderListener = this.mediaSearchDataProviderListener;
        this.dispatcher.execute(new MediaDSISearchDataProviderController$1(this, "searchDataProviderListener.asnycException", iMediaSearchDataProviderListener, n, string, n2));
    }

    @Override
    public void registerProviderSourceResult(int n, int n2) {
        this.logger.log(1078071040, "[%1.registerProviderSourceResult]", (Object)"MediaDSISearchDataProviderController");
        IMediaSearchDataProviderListener iMediaSearchDataProviderListener = this.mediaSearchDataProviderListener;
        this.dispatcher.execute(new MediaDSISearchDataProviderController$2(this, "searchDataProviderListener.registerProviderSourceResult", iMediaSearchDataProviderListener, n, n2));
    }

    @Override
    public void activateProviderSource(int n) {
        this.logger.log(1078071040, "[%1.activateProviderSource]", (Object)"MediaDSISearchDataProviderController");
        IMediaSearchDataProviderListener iMediaSearchDataProviderListener = this.mediaSearchDataProviderListener;
        this.dispatcher.execute(new MediaDSISearchDataProviderController$3(this, "searchDataProviderListener.activateProviderSource", iMediaSearchDataProviderListener, n));
    }

    @Override
    public void invalidateAllDataResult(int n, int n2) {
        this.logger.log(1078071040, "[%1.invalidateAllDataResult] %2", (Object)"MediaDSISearchDataProviderController", (Object)this.mediaSearchDataProviderListener);
        IMediaSearchDataProviderListener iMediaSearchDataProviderListener = this.mediaSearchDataProviderListener;
        this.dispatcher.execute(new MediaDSISearchDataProviderController$4(this, "searchDataProviderListener.invalidateAllDataResult", iMediaSearchDataProviderListener, n, n2));
    }

    @Override
    public void provideData(int n, int n2, int n3) {
        this.logger.log(1078071040, "[%1.provideData]", (Object)"MediaDSISearchDataProviderController");
        IMediaSearchDataProviderListener iMediaSearchDataProviderListener = this.mediaSearchDataProviderListener;
        this.dispatcher.execute(new MediaDSISearchDataProviderController$5(this, "searchDataProviderListener.provideData", iMediaSearchDataProviderListener, n, n2, n3));
    }

    @Override
    public void storeDataSetsResult(int n, int n2) {
        this.logger.log(1078071040, "[%1.storeDataSetsResult]", (Object)"MediaDSISearchDataProviderController");
        IMediaSearchDataProviderListener iMediaSearchDataProviderListener = this.mediaSearchDataProviderListener;
        this.dispatcher.execute(new MediaDSISearchDataProviderController$6(this, "searchDataProviderListener.storeDataSetsResult", iMediaSearchDataProviderListener, n, n2));
    }

    @Override
    public void deleteDataSetResult(int n, int n2, long l) {
        this.logger.log(1078071040, "[%1.deleteDataSetResult]", (Object)"MediaDSISearchDataProviderController");
        IMediaSearchDataProviderListener iMediaSearchDataProviderListener = this.mediaSearchDataProviderListener;
        this.dispatcher.execute(new MediaDSISearchDataProviderController$7(this, "searchDataProviderListener.deleteDataSetResult", iMediaSearchDataProviderListener, n, n2, l));
    }

    @Override
    public void registerProviderSource(int n) {
        this.logger.log(1078071040, "[%1.registerProviderSource]", (Object)"MediaDSISearchDataProviderController");
        this.dsiSearchDataProvider.registerProviderSource(n);
    }

    @Override
    public void sourceDataAvailabilityChanged(int n, boolean bl) {
        this.logger.log(1078071040, "[%1.sourceDataAvailabilityChanged]", (Object)"MediaDSISearchDataProviderController");
        this.dsiSearchDataProvider.sourceDataAvailabilityChanged(n, bl);
    }

    @Override
    public void invalidateAllData(int n) {
        this.logger.log(1078071040, "[%1.invalidateAllData]", (Object)"MediaDSISearchDataProviderController");
        this.dsiSearchDataProvider.invalidateAllData(n);
    }

    @Override
    public void storeDataSets(int n, DataSet[] dataSetArray, int n2) {
        this.logger.log(1078071040, "[%1.storeDataSets]", (Object)"MediaDSISearchDataProviderController");
        this.dsiSearchDataProvider.storeDataSets(n, dataSetArray, n2);
    }

    @Override
    public void deleteDataSet(int n, long l) {
        this.logger.log(1078071040, "[%1.deleteDataSet]", (Object)"MediaDSISearchDataProviderController");
        this.dsiSearchDataProvider.deleteDataSet(n, l);
    }

    @Override
    protected Class getDSIServiceClass() {
        return class$org$dsi$ifc$search$DSISearchDataProvider == null ? (class$org$dsi$ifc$search$DSISearchDataProvider = MediaDSISearchDataProviderController.class$("org.dsi.ifc.search.DSISearchDataProvider")) : class$org$dsi$ifc$search$DSISearchDataProvider;
    }

    @Override
    protected DSIListener getDSIListener() {
        return this;
    }

    @Override
    protected Class getDSIListenerClass() {
        return class$org$dsi$ifc$search$DSISearchDataProviderListener == null ? (class$org$dsi$ifc$search$DSISearchDataProviderListener = MediaDSISearchDataProviderController.class$("org.dsi.ifc.search.DSISearchDataProviderListener")) : class$org$dsi$ifc$search$DSISearchDataProviderListener;
    }

    @Override
    protected void addDSIService(DSIBase dSIBase) {
        this.dsiSearchDataProvider = (DSISearchDataProvider)dSIBase;
    }

    @Override
    protected void removeDSIService() {
        this.dsiSearchDataProvider = this.nullDsiSearchDataProvider;
    }

    static /* synthetic */ LogChannel access$000(MediaDSISearchDataProviderController mediaDSISearchDataProviderController) {
        return mediaDSISearchDataProviderController.logger;
    }

    static /* synthetic */ LogChannel access$100(MediaDSISearchDataProviderController mediaDSISearchDataProviderController) {
        return mediaDSISearchDataProviderController.logger;
    }

    static /* synthetic */ LogChannel access$200(MediaDSISearchDataProviderController mediaDSISearchDataProviderController) {
        return mediaDSISearchDataProviderController.logger;
    }

    static /* synthetic */ LogChannel access$300(MediaDSISearchDataProviderController mediaDSISearchDataProviderController) {
        return mediaDSISearchDataProviderController.logger;
    }

    static /* synthetic */ LogChannel access$400(MediaDSISearchDataProviderController mediaDSISearchDataProviderController) {
        return mediaDSISearchDataProviderController.logger;
    }

    static /* synthetic */ LogChannel access$500(MediaDSISearchDataProviderController mediaDSISearchDataProviderController) {
        return mediaDSISearchDataProviderController.logger;
    }

    static /* synthetic */ LogChannel access$600(MediaDSISearchDataProviderController mediaDSISearchDataProviderController) {
        return mediaDSISearchDataProviderController.logger;
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

