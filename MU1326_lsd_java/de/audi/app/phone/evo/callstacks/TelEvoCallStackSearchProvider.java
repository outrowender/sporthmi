/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.callstacks;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.search.AbstractTelSearchDataProvider;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.evo.callstacks.TelCallStack2JsonStringConverter;
import org.dsi.ifc.search.DataSet;
import org.dsi.ifc.search.Searchable;
import org.dsi.ifc.telephoneng.CallStackEntry;

public class TelEvoCallStackSearchProvider
extends AbstractTelSearchDataProvider {
    private volatile CallStackEntry[] combinedCallStack;

    private static int getDataSetEntryType(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 2049;
                break;
            }
            case 2: {
                n2 = 2050;
                break;
            }
            case 1: {
                n2 = 2048;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    public TelEvoCallStackSearchProvider(ITelApplication iTelApplication) {
        super(iTelApplication, 7);
    }

    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (n == 65576 && iGlobalTelephoneStateStruct != null) {
            this.combinedCallStack = iGlobalTelephoneStateStruct.getCombinedCallStackEntries();
            this.invalidateData();
        }
    }

    private Searchable[] getSearchablesForCallStackEntry(CallStackEntry callStackEntry) {
        if (callStackEntry != null) {
            return new Searchable[]{TelEvoCallStackSearchProvider.getSearchable(5, callStackEntry.getClName(), this.getTokenPostProcessingMethod()), TelEvoCallStackSearchProvider.getSearchable(11, callStackEntry.getClNumber(), this.getTokenPostProcessingMethod()), TelEvoCallStackSearchProvider.getSearchable(23, TelCallStack2JsonStringConverter.serialize(callStackEntry), this.getTokenPostProcessingMethod())};
        }
        return new Searchable[0];
    }

    DataSet[] getCombinedCallStackDataSets(CallStackEntry[] callStackEntryArray) {
        if (callStackEntryArray != null) {
            DataSet[] dataSetArray = new DataSet[callStackEntryArray.length];
            for (int i2 = 0; i2 < callStackEntryArray.length; ++i2) {
                CallStackEntry callStackEntry = callStackEntryArray[i2];
                dataSetArray[i2] = new DataSet(callStackEntry.getClEntryID(), TelEvoCallStackSearchProvider.getDataSetEntryType(callStackEntry.getClEntryType()), callStackEntry.getAdbNumberType(), this.getSearchablesForCallStackEntry(callStackEntry));
            }
            return dataSetArray;
        }
        return new DataSet[0];
    }

    protected DataSet[] getDataSet() {
        return this.getCombinedCallStackDataSets(this.combinedCallStack);
    }
}

