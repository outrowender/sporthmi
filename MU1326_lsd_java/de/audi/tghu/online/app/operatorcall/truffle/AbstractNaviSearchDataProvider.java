/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.truffle;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.mib.jdsi.DSIActivator;
import de.audi.mib.jdsi.IDSIClient;
import de.esolutions.fw.util.commons.Converter;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.search.DSISearchDataProvider;
import org.dsi.ifc.search.DSISearchDataProviderListener;
import org.dsi.ifc.search.DataSet;
import org.osgi.framework.BundleContext;

public abstract class AbstractNaviSearchDataProvider
implements DSISearchDataProviderListener,
IDSIClient {
    private DSIActivator dsiActivator;
    private volatile DSISearchDataProvider dsi;
    protected final LogChannel logChannel;
    protected final IFrameworkAccess framework;
    protected final BundleContext context;
    private final int source;
    static /* synthetic */ Class class$org$dsi$ifc$search$DSISearchDataProvider;
    static /* synthetic */ Class class$org$dsi$ifc$search$DSISearchDataProviderListener;

    public AbstractNaviSearchDataProvider(LogChannel logChannel, IFrameworkAccess iFrameworkAccess, BundleContext bundleContext, int n) {
        this.logChannel = logChannel;
        this.framework = iFrameworkAccess;
        this.context = bundleContext;
        this.source = n;
    }

    public void start() {
        this.dsiActivator = new DSIActivator(this.framework, (class$org$dsi$ifc$search$DSISearchDataProvider == null ? (class$org$dsi$ifc$search$DSISearchDataProvider = AbstractNaviSearchDataProvider.class$("org.dsi.ifc.search.DSISearchDataProvider")) : class$org$dsi$ifc$search$DSISearchDataProvider).getName(), (class$org$dsi$ifc$search$DSISearchDataProviderListener == null ? (class$org$dsi$ifc$search$DSISearchDataProviderListener = AbstractNaviSearchDataProvider.class$("org.dsi.ifc.search.DSISearchDataProviderListener")) : class$org$dsi$ifc$search$DSISearchDataProviderListener).getName(), new Integer(0), this, this);
        this.dsiActivator.start(this.context);
    }

    public void stop() {
        if (this.dsiActivator != null) {
            this.dsiActivator.stop(this.context);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void setDSI(DSIBase dSIBase) {
        if (dSIBase == null) {
            this.dsi = null;
            return;
        }
        if (this.dsi == null) {
            if (!(dSIBase instanceof DSISearchDataProvider)) return;
            this.logChannel.log(1078071040, "[AbstractNaviSearchDataProvider#setDSI] DSISearchDataProvider available");
            this.dsi = (DSISearchDataProvider)dSIBase;
            this.dsi.registerProviderSource(this.source);
            return;
        }
        this.logChannel.log(-1601830656, "[AbstractNaviSearchDataProvider#setDSI] DSISearchDataProvider already exists!");
    }

    @Override
    public int[] getAutoNotifications() {
        return new int[0];
    }

    protected abstract DataSet[] getDataSet() {
    }

    public void invalidateData() {
        DSISearchDataProvider dSISearchDataProvider = this.dsi;
        if (dSISearchDataProvider != null) {
            this.logChannel.log(1078071040, "[AbstractNaviSearchDataProvider#invalidateData] source=%1", (long)this.source);
            dSISearchDataProvider.invalidateAllData(this.source);
        } else {
            this.logChannel.log(1078071040, "[AbstractNaviSearchDataProvider#invalidateData] dsi is null. Not invalidating source %1", (long)this.source);
        }
    }

    @Override
    public void registerProviderSourceResult(int n, int n2) {
        if (n2 == this.source) {
            this.logChannel.log(1078071040, "[AbstractNaviSearchDataProvider#registerProviderSourceResult] success=%1, source=%2", (long)n, (long)n2);
        }
    }

    @Override
    public void activateProviderSource(int n) {
        if (n == this.source) {
            this.logChannel.log(-2137614336, "[AbstractNaviSearchDataProvider#activateProviderSource] source=%1", (long)n);
        }
    }

    @Override
    public void invalidateAllDataResult(int n, int n2) {
        if (n2 == this.source) {
            this.logChannel.log(1078071040, "[AbstractNaviSearchDataProvider#invalidateAllDataResult] success=%1, source=%2", (long)n, (long)n2);
        }
    }

    @Override
    public void provideData(int n, int n2, int n3) {
        if (n == this.source) {
            this.logChannel.log(1078071040, "[AbstractNaviSearchDataProvider#provideData] source=%1, offset=%2, count=%3", (long)n, (long)n2, (long)n3);
            DSISearchDataProvider dSISearchDataProvider = this.dsi;
            if (dSISearchDataProvider != null) {
                DataSet[] dataSetArray = AbstractNaviSearchDataProvider.getDataSubSet(this.getDataSet(), n2, n3);
                this.logChannel.log(-2137614336, "[AbstractNaviSearchDataProvider#provideData] dataSet=%1", (Object)Converter.array2String(dataSetArray));
                dSISearchDataProvider.storeDataSets(this.source, dataSetArray, dataSetArray.length);
            }
        }
    }

    @Override
    public void storeDataSetsResult(int n, int n2) {
        if (n2 == this.source) {
            this.logChannel.log(1078071040, "[AbstractNaviSearchDataProvider#storeDataSetsResult] success=%1, source=%2", (long)n, (long)n2);
        }
    }

    @Override
    public void deleteDataSetResult(int n, int n2, long l) {
        if (n2 == this.source) {
            this.logChannel.log(1078071040, "[AbstractNaviSearchDataProvider#deleteDataSetResult] source=%1, source=%2, dataSetId=%3", (long)n2, (long)n2, l);
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.logChannel.log(10000, "[AbstractNaviSearchDataProvider#asyncException] errorCode=%2, errorMsg=%1, requestType=%3", (Object)string, (long)n, (long)n2);
    }

    public static DataSet[] getDataSubSet(DataSet[] dataSetArray, int n, int n2) {
        if (dataSetArray != null) {
            int n3 = n < dataSetArray.length ? n : dataSetArray.length;
            int n4 = n3 + n2;
            n4 = n4 < dataSetArray.length ? n4 : dataSetArray.length;
            DataSet[] dataSetArray2 = new DataSet[n4 - n3];
            System.arraycopy((Object)dataSetArray, n, (Object)dataSetArray2, 0, n2 < dataSetArray2.length ? n2 : dataSetArray2.length);
            return dataSetArray2;
        }
        return new DataSet[0];
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

