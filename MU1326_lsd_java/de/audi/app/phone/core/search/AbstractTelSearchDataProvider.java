/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.search;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.mib.jdsi.DSIActivator;
import de.audi.mib.jdsi.IDSIClient;
import de.esolutions.fw.util.commons.Converter;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.search.DSISearchDataProvider;
import org.dsi.ifc.search.DSISearchDataProviderListener;
import org.dsi.ifc.search.DataSet;
import org.dsi.ifc.search.Searchable;

public abstract class AbstractTelSearchDataProvider
extends AbstractPhoneComponent
implements DSISearchDataProviderListener,
IDSIClient {
    private DSIActivator dsiActivator;
    private volatile DSISearchDataProvider dsi;
    private volatile boolean sourceActivated;
    private final int source;
    private final int tokenPostProcessingMethod;
    static /* synthetic */ Class class$org$dsi$ifc$search$DSISearchDataProvider;
    static /* synthetic */ Class class$org$dsi$ifc$search$DSISearchDataProviderListener;

    protected static Searchable getSearchable(int n, String string, int n2) {
        Searchable searchable = new Searchable();
        searchable.wordType = n;
        searchable.token = string;
        searchable.tokenPostProcessing = n2;
        return searchable;
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

    public AbstractTelSearchDataProvider(ITelApplication iTelApplication, int n) {
        super(iTelApplication, "App.Phone.Search");
        this.source = n;
        this.tokenPostProcessingMethod = this.getApplication().getFrameworkAccess().isCn() || this.getApplication().getFrameworkAccess().isTaiwan() ? 2 : (this.getApplication().getFrameworkAccess().isJp() ? 4 : 0);
    }

    @Override
    public void init() {
        this.dsiActivator = new DSIActivator(this.getApplication().getFrameworkAccess(), (class$org$dsi$ifc$search$DSISearchDataProvider == null ? (class$org$dsi$ifc$search$DSISearchDataProvider = AbstractTelSearchDataProvider.class$("org.dsi.ifc.search.DSISearchDataProvider")) : class$org$dsi$ifc$search$DSISearchDataProvider).getName(), (class$org$dsi$ifc$search$DSISearchDataProviderListener == null ? (class$org$dsi$ifc$search$DSISearchDataProviderListener = AbstractTelSearchDataProvider.class$("org.dsi.ifc.search.DSISearchDataProviderListener")) : class$org$dsi$ifc$search$DSISearchDataProviderListener).getName(), new Integer(4), this, this);
        this.dsiActivator.start(this.getApplication().getBundleContext());
    }

    @Override
    public void deinit() {
        if (this.dsiActivator != null) {
            this.dsiActivator.stop(this.getApplication().getBundleContext());
        }
    }

    protected int getTokenPostProcessingMethod() {
        return this.tokenPostProcessingMethod;
    }

    @Override
    public void setDSI(DSIBase dSIBase) {
        if (dSIBase != null) {
            if (dSIBase instanceof DSISearchDataProvider) {
                this.log.log(1078071040, "[AbstractTelSearchDataProvider#setDSI] DSISearchDataProvider available");
                this.dsi = (DSISearchDataProvider)dSIBase;
                this.dsi.registerProviderSource(this.source);
            }
        } else {
            this.dsi = null;
        }
    }

    protected boolean isSourceActivated() {
        return this.sourceActivated;
    }

    @Override
    public int[] getAutoNotifications() {
        return DSIActivator.ATTR_ALL;
    }

    protected abstract DataSet[] getDataSet() {
    }

    public void invalidateData() {
        if (this.isSourceActivated()) {
            DSISearchDataProvider dSISearchDataProvider = this.dsi;
            if (dSISearchDataProvider != null) {
                this.log.log(1078071040, "[AbstractTelSearchDataProvider#invalidateData] source=%1", (long)this.source);
                dSISearchDataProvider.invalidateAllData(this.source);
            } else {
                this.log.log(1078071040, "[AbstractTelSearchDataProvider#invalidateData] dsi is null. Not invalidating source %1", (long)this.source);
            }
        } else {
            this.log.log(1078071040, "[AbstractTelSearchDataProvider#invalidateData] source not yet activated - NOP!");
        }
    }

    @Override
    public void registerProviderSourceResult(int n, int n2) {
        if (n2 == this.source) {
            this.log.log(1078071040, "[AbstractTelSearchDataProvider#registerProviderSourceResult] success=%1, source=%2", (long)n, (long)n2);
        }
    }

    @Override
    public void activateProviderSource(int n) {
        if (n == this.source) {
            this.log.log(1078071040, "[AbstractTelSearchDataProvider#activateProviderSource] source=%1", (long)n);
            this.sourceActivated = true;
        }
    }

    @Override
    public void invalidateAllDataResult(int n, int n2) {
        if (n2 == this.source) {
            this.log.log(1078071040, "[AbstractTelSearchDataProvider#invalidateAllDataResult] success=%1, source=%2", (long)n, (long)n2);
        }
    }

    @Override
    public void provideData(int n, int n2, int n3) {
        if (n == this.source) {
            this.log.log(1078071040, "[AbstractTelSearchDataProvider#provideData] source=%1, offset=%2, count=%3", (long)n, (long)n2, (long)n3);
            DSISearchDataProvider dSISearchDataProvider = this.dsi;
            if (dSISearchDataProvider != null) {
                DataSet[] dataSetArray = AbstractTelSearchDataProvider.getDataSubSet(this.getDataSet(), n2, n3);
                this.log.log(-2137614336, "[AbstractTelSearchDataProvider#provideData] dataSet=%1", (Object)Converter.array2String(dataSetArray));
                dSISearchDataProvider.storeDataSets(this.source, dataSetArray, dataSetArray.length);
            }
        }
    }

    @Override
    public void storeDataSetsResult(int n, int n2) {
        if (n2 == this.source) {
            this.log.log(1078071040, "[AbstractTelSearchDataProvider#storeDataSetsResult] success=%1, source=%2", (long)n, (long)n2);
        }
    }

    @Override
    public void deleteDataSetResult(int n, int n2, long l) {
        if (n2 == this.source) {
            this.log.log(1078071040, "[AbstractTelSearchDataProvider#deleteDataSetResult] source=%1, source=%2, dataSetId=%3", (long)n2, (long)n2, l);
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.log.log(10000, "[AbstractTelSearchDataProvider#asyncException] errorCode=%2, errorMsg=%1, requestType=%3", (Object)string, (long)n, (long)n2);
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

