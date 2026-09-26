/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.data.search;

import de.audi.app.media.content.media.data.search.AbstractSearchHandler;
import de.audi.app.media.content.media.data.search.IDataMediaSearch;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.AbstractGuiSearchHandler;
import de.audi.atip.search.AbstractSearch;
import de.audi.atip.util.Util;
import java.util.HashMap;
import java.util.Map;
import org.dsi.ifc.search.SearchFilter;
import org.osgi.framework.BundleContext;

public class DataMediaSearch
extends AbstractSearch
implements IDataMediaSearch {
    private static final String LOGCLASS;
    private static final int[] WORDTYPELIST_ALL;
    private final Map sourceAvailabilityMap;
    private volatile int currentSearchFilterType;
    private volatile int[] currentDefaultSearchFilter = WORDTYPELIST_ALL;

    public DataMediaSearch(BundleContext bundleContext, IFrameworkAccess iFrameworkAccess, LogChannel logChannel) {
        super(bundleContext, iFrameworkAccess, logChannel, 2);
        this.sourceAvailabilityMap = new HashMap(8);
        this.sourceAvailabilityMap.put(Util.createInteger(11), Boolean.FALSE);
        this.sourceAvailabilityMap.put(Util.createInteger(12), Boolean.FALSE);
        this.sourceAvailabilityMap.put(Util.createInteger(13), Boolean.FALSE);
        this.sourceAvailabilityMap.put(Util.createInteger(19), Boolean.FALSE);
        this.sourceAvailabilityMap.put(Util.createInteger(20), Boolean.FALSE);
        this.sourceAvailabilityMap.put(Util.createInteger(21), Boolean.FALSE);
        this.sourceAvailabilityMap.put(Util.createInteger(22), Boolean.FALSE);
        this.sourceAvailabilityMap.put(Util.createInteger(20011), Boolean.FALSE);
    }

    public void init() {
        this.logChannel.log(1078071040, "[%1.init]", (Object)"DataMediaSearch");
        this.startDSI();
    }

    public void deinit() {
        this.logChannel.log(1078071040, "[%1.deinit]", (Object)"DataMediaSearch");
        this.stopDSI();
    }

    public void activate() {
        this.logChannel.log(1078071040, "[%1.activate]", (Object)"DataMediaSearch");
        this.sourceAvailabilityMap.put(Util.createInteger(11), Boolean.FALSE);
        this.sourceAvailabilityMap.put(Util.createInteger(12), Boolean.FALSE);
        this.sourceAvailabilityMap.put(Util.createInteger(13), Boolean.FALSE);
        this.sourceAvailabilityMap.put(Util.createInteger(19), Boolean.FALSE);
        this.sourceAvailabilityMap.put(Util.createInteger(20), Boolean.FALSE);
        this.sourceAvailabilityMap.put(Util.createInteger(21), Boolean.FALSE);
        this.sourceAvailabilityMap.put(Util.createInteger(22), Boolean.FALSE);
        this.sourceAvailabilityMap.put(Util.createInteger(20011), Boolean.FALSE);
    }

    public void deactivate() {
        this.logChannel.log(1078071040, "[%1.deactivate]", (Object)"DataMediaSearch");
    }

    @Override
    public void setActiveGuiSearchHandler(AbstractGuiSearchHandler abstractGuiSearchHandler) {
        this.logChannel.log(1078071040, "[%1.setActiveGuiSearchHandler]", (Object)"DataMediaSearch");
        if (this.activeGuiSearchHandler == abstractGuiSearchHandler) {
            return;
        }
        if (null != this.activeGuiSearchHandler) {
            this.activeGuiSearchHandler.cancelTimers();
        }
        AbstractSearchHandler abstractSearchHandler = (AbstractSearchHandler)abstractGuiSearchHandler;
        abstractSearchHandler.setSourceDataAvailability(this.isAnySourceAvailable(abstractGuiSearchHandler.getSources()));
        abstractSearchHandler.updateListener();
        super.setActiveGuiSearchHandler(abstractGuiSearchHandler);
        this.setSearchFilterTypeInternal(this.currentSearchFilterType);
    }

    @Override
    public void initDSI() {
        super.initDSI();
        this.logChannel.log(1078071040, "[%1.initDSI]", (Object)"DataMediaSearch");
        super.prepareSources(new int[]{11, 12, 13, 19, 20, 21, 22, 20011});
        this.setSearchFilter(11, new SearchFilter(WORDTYPELIST_NAME, null, 0, null));
        this.setSearchFilter(13, new SearchFilter(WORDTYPELIST_ALBUM, null, 0, null));
        this.setSearchFilter(12, new SearchFilter(WORDTYPELIST_ARTIST, null, 0, null));
        this.setSearchFilter(19, new SearchFilter(WORDTYPELIST_ALL, null, 0, null));
        this.setSearchFilter(20, new SearchFilter(WORDTYPELIST_GENRE, null, 0, null));
        this.setSearchFilter(21, new SearchFilter(WORDTYPELIST_NAME, null, 0, null));
        this.setSearchFilter(22, new SearchFilter(WORDTYPELIST_NAME, null, 0, null));
        this.setSearchFilter(20011, new SearchFilter(WORDTYPELIST_NAME, null, 0, null));
    }

    @Override
    public void sourceDataAvailabilityChanged(int n, boolean bl) {
        switch (n) {
            case 11: 
            case 12: 
            case 13: 
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 20011: {
                int[] nArray;
                if (this.logChannel.isDebug2()) {
                    this.logChannel.log(14808325, "[%1.sourceDataAvailabilityChanged] source=%2 %3", (Object)"DataMediaSearch", (Object)String.valueOf(n), (Object)String.valueOf(bl));
                }
                this.sourceAvailabilityMap.put(Util.createInteger(n), bl);
                if (null == this.activeGuiSearchHandler || !this.isSourceRelevant(n, nArray = ((AbstractSearchHandler)this.activeGuiSearchHandler).getSources())) break;
                ((AbstractSearchHandler)this.activeGuiSearchHandler).setSourceDataAvailability(this.isAnySourceAvailable(nArray));
                break;
            }
        }
    }

    private boolean getSourceAvailability(int n) {
        return (Boolean)this.sourceAvailabilityMap.get(Util.createInteger(n));
    }

    private boolean isSourceRelevant(int n, int[] nArray) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "[%1.isSourceRelevant]", (Object)"DataMediaSearch");
        }
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (n != nArray[i2]) continue;
            return true;
        }
        return false;
    }

    private boolean isAnySourceAvailable(int[] nArray) {
        boolean bl = false;
        for (int i2 = 0; i2 < nArray.length && !bl; bl |= this.getSourceAvailability(nArray[i2]), ++i2) {
        }
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "[%1.isAnySourceAvailable] %2", (Object)"DataMediaSearch", (Object)bl);
        }
        return bl;
    }

    @Override
    public void setSearchFilterType(int n) {
        if (this.currentSearchFilterType == n) {
            this.logChannel.log(-2137614336, "[%1.setSearchFilterType] Search filter '%2' already set.", (Object)"DataMediaSearch", (long)n);
            return;
        }
        this.setSearchFilterTypeInternal(n);
    }

    private void setSearchFilterTypeInternal(int n) {
        this.logChannel.log(-2137614336, "[%1.setSearchFilterType] '%2'", (Object)"DataMediaSearch", (long)n);
        this.currentSearchFilterType = n;
        switch (n) {
            case 1: {
                this.setDefaultSearchFilter();
                break;
            }
            case 2: {
                this.setAdvanceSearchFilter();
                break;
            }
            default: {
                this.logChannel.log(1078071040, "[%1.setSearchFilterType] Search type not supported.", (Object)"DataMediaSearch");
            }
        }
    }

    @Override
    public void setDefaultSearchFilter(int[] nArray) {
        this.logChannel.log(1078071040, "[%1.setDefaultSearchFilter]", (Object)"DataMediaSearch");
        this.currentDefaultSearchFilter = nArray;
        this.setDefaultSearchFilter();
    }

    private void setAdvanceSearchFilter() {
        this.logChannel.log(1078071040, "[%1.setAdvanceSearchFilter]", (Object)"DataMediaSearch");
        int[] nArray = this.activeGuiSearchHandler.getSources();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.setSearchFilter(WORDTYPELIST_ALL, nArray[i2]);
        }
    }

    private void setDefaultSearchFilter() {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "[%1.setDefaultSearchFilter]", (Object)"DataMediaSearch");
        }
        int[] nArray = this.activeGuiSearchHandler.getSources();
        block9: for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (19 == nArray[i2]) {
                this.setSearchFilter(this.currentDefaultSearchFilter, nArray[i2]);
                continue;
            }
            switch (nArray[i2]) {
                case 11: {
                    this.setSearchFilter(11, new SearchFilter(WORDTYPELIST_NAME, null, 0, null));
                    continue block9;
                }
                case 13: {
                    this.setSearchFilter(13, new SearchFilter(WORDTYPELIST_ALBUM, null, 0, null));
                    continue block9;
                }
                case 12: {
                    this.setSearchFilter(12, new SearchFilter(WORDTYPELIST_ARTIST, null, 0, null));
                    continue block9;
                }
                case 20: {
                    this.setSearchFilter(20, new SearchFilter(WORDTYPELIST_GENRE, null, 0, null));
                    continue block9;
                }
                case 21: {
                    this.setSearchFilter(21, new SearchFilter(WORDTYPELIST_NAME, null, 0, null));
                    continue block9;
                }
                case 22: {
                    this.setSearchFilter(22, new SearchFilter(WORDTYPELIST_NAME, null, 0, null));
                    continue block9;
                }
                case 20011: {
                    this.setSearchFilter(20011, new SearchFilter(WORDTYPELIST_NAME, null, 0, null));
                    continue block9;
                }
            }
        }
    }

    private void setSearchFilter(int[] nArray, int n) {
        this.logChannel.log(1078071040, "[%1.setSearchFilter]", (Object)"DataMediaSearch");
        this.setSearchFilter(n, new SearchFilter(nArray, null, 0, null));
    }

    static {
        WORDTYPELIST_ALL = new int[]{15, 16, 5, 14};
    }
}

