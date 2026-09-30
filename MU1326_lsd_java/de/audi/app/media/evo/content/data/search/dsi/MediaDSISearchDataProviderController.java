/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.search.dsi;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.AbstractDSIController;
import de.audi.app.media.evo.content.data.search.dsi.IMediaDSISearchDataController;
import de.audi.app.media.evo.content.data.search.dsi.IMediaSearchDataProviderListener;
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
    private static final String LOGCLASS = "MediaDSISearchDataProviderController";
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

    public void asyncException(final int n, final String string, final int n2) {
        this.logger.log(1000000, "[%1.asyncException]", (Object)LOGCLASS);
        final IMediaSearchDataProviderListener iMediaSearchDataProviderListener = this.mediaSearchDataProviderListener;
        this.dispatcher.execute(new AbstractDispatcherRunnable("searchDataProviderListener.asnycException"){

            public void run() {
                try {
                    iMediaSearchDataProviderListener.asyncException(n, string, n2);
                }
                catch (Exception exception) {
                    MediaDSISearchDataProviderController.this.logger.log(10000, "[%1.asyncException]", (Object)MediaDSISearchDataProviderController.LOGCLASS, (Throwable)exception);
                }
            }
        });
    }

    public void registerProviderSourceResult(final int n, final int n2) {
        this.logger.log(1000000, "[%1.registerProviderSourceResult]", (Object)LOGCLASS);
        final IMediaSearchDataProviderListener iMediaSearchDataProviderListener = this.mediaSearchDataProviderListener;
        this.dispatcher.execute(new AbstractDispatcherRunnable("searchDataProviderListener.registerProviderSourceResult"){

            public void run() {
                try {
                    iMediaSearchDataProviderListener.registerProviderSourceResult(n == 0, n2);
                }
                catch (Exception exception) {
                    MediaDSISearchDataProviderController.this.logger.log(10000, "[%1.registerProviderSourceResult]", (Object)MediaDSISearchDataProviderController.LOGCLASS, (Throwable)exception);
                }
            }
        });
    }

    public void activateProviderSource(final int n) {
        this.logger.log(1000000, "[%1.activateProviderSource]", (Object)LOGCLASS);
        final IMediaSearchDataProviderListener iMediaSearchDataProviderListener = this.mediaSearchDataProviderListener;
        this.dispatcher.execute(new AbstractDispatcherRunnable("searchDataProviderListener.activateProviderSource"){

            public void run() {
                try {
                    iMediaSearchDataProviderListener.activateProviderSource(n);
                }
                catch (Exception exception) {
                    MediaDSISearchDataProviderController.this.logger.log(10000, "[%1.activateProviderSource]", (Object)MediaDSISearchDataProviderController.LOGCLASS, (Throwable)exception);
                }
            }
        });
    }

    public void invalidateAllDataResult(final int n, final int n2) {
        this.logger.log(1000000, "[%1.invalidateAllDataResult] %2", (Object)LOGCLASS, (Object)this.mediaSearchDataProviderListener);
        final IMediaSearchDataProviderListener iMediaSearchDataProviderListener = this.mediaSearchDataProviderListener;
        this.dispatcher.execute(new AbstractDispatcherRunnable("searchDataProviderListener.invalidateAllDataResult"){

            public void run() {
                try {
                    iMediaSearchDataProviderListener.invalidateAllDataResult(n == 0, n2);
                }
                catch (Exception exception) {
                    MediaDSISearchDataProviderController.this.logger.log(10000, "[%1.invalidateAllDataResult]", (Object)MediaDSISearchDataProviderController.LOGCLASS, (Throwable)exception);
                }
            }
        });
    }

    public void provideData(final int n, final int n2, final int n3) {
        this.logger.log(1000000, "[%1.provideData]", (Object)LOGCLASS);
        final IMediaSearchDataProviderListener iMediaSearchDataProviderListener = this.mediaSearchDataProviderListener;
        this.dispatcher.execute(new AbstractDispatcherRunnable("searchDataProviderListener.provideData"){

            public void run() {
                try {
                    iMediaSearchDataProviderListener.provideData(n, n2, n3);
                }
                catch (Exception exception) {
                    MediaDSISearchDataProviderController.this.logger.log(10000, "[%1.provideData]", (Object)MediaDSISearchDataProviderController.LOGCLASS, (Throwable)exception);
                }
            }
        });
    }

    public void storeDataSetsResult(final int n, final int n2) {
        this.logger.log(1000000, "[%1.storeDataSetsResult]", (Object)LOGCLASS);
        final IMediaSearchDataProviderListener iMediaSearchDataProviderListener = this.mediaSearchDataProviderListener;
        this.dispatcher.execute(new AbstractDispatcherRunnable("searchDataProviderListener.storeDataSetsResult"){

            public void run() {
                try {
                    iMediaSearchDataProviderListener.storeDataSetsResult(n == 0, n2);
                }
                catch (Exception exception) {
                    MediaDSISearchDataProviderController.this.logger.log(10000, "[%1.storeDataSetsResult]", (Object)MediaDSISearchDataProviderController.LOGCLASS, (Throwable)exception);
                }
            }
        });
    }

    public void deleteDataSetResult(final int n, final int n2, final long l) {
        this.logger.log(1000000, "[%1.deleteDataSetResult]", (Object)LOGCLASS);
        final IMediaSearchDataProviderListener iMediaSearchDataProviderListener = this.mediaSearchDataProviderListener;
        this.dispatcher.execute(new AbstractDispatcherRunnable("searchDataProviderListener.deleteDataSetResult"){

            public void run() {
                try {
                    iMediaSearchDataProviderListener.deleteDataSetResult(n == 0, n2, l);
                }
                catch (Exception exception) {
                    MediaDSISearchDataProviderController.this.logger.log(10000, "[%1.deleteDataSetResult]", (Object)MediaDSISearchDataProviderController.LOGCLASS, (Throwable)exception);
                }
            }
        });
    }

    public void registerProviderSource(int n) {
        this.logger.log(1000000, "[%1.registerProviderSource]", (Object)LOGCLASS);
        this.dsiSearchDataProvider.registerProviderSource(n);
    }

    public void sourceDataAvailabilityChanged(int n, boolean bl) {
        this.logger.log(1000000, "[%1.sourceDataAvailabilityChanged]", (Object)LOGCLASS);
        this.dsiSearchDataProvider.sourceDataAvailabilityChanged(n, bl);
    }

    public void invalidateAllData(int n) {
        this.logger.log(1000000, "[%1.invalidateAllData]", (Object)LOGCLASS);
        this.dsiSearchDataProvider.invalidateAllData(n);
    }

    public void storeDataSets(int n, DataSet[] dataSetArray, int n2) {
        this.logger.log(1000000, "[%1.storeDataSets]", (Object)LOGCLASS);
        this.dsiSearchDataProvider.storeDataSets(n, dataSetArray, n2);
    }

    public void deleteDataSet(int n, long l) {
        this.logger.log(1000000, "[%1.deleteDataSet]", (Object)LOGCLASS);
        this.dsiSearchDataProvider.deleteDataSet(n, l);
    }

    protected Class getDSIServiceClass() {
        return class$org$dsi$ifc$search$DSISearchDataProvider == null ? (class$org$dsi$ifc$search$DSISearchDataProvider = MediaDSISearchDataProviderController.class$("org.dsi.ifc.search.DSISearchDataProvider")) : class$org$dsi$ifc$search$DSISearchDataProvider;
    }

    protected DSIListener getDSIListener() {
        return this;
    }

    protected Class getDSIListenerClass() {
        return class$org$dsi$ifc$search$DSISearchDataProviderListener == null ? (class$org$dsi$ifc$search$DSISearchDataProviderListener = MediaDSISearchDataProviderController.class$("org.dsi.ifc.search.DSISearchDataProviderListener")) : class$org$dsi$ifc$search$DSISearchDataProviderListener;
    }

    protected void addDSIService(DSIBase dSIBase) {
        this.dsiSearchDataProvider = (DSISearchDataProvider)dSIBase;
    }

    protected void removeDSIService() {
        this.dsiSearchDataProvider = this.nullDsiSearchDataProvider;
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

