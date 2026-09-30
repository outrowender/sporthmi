/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner;

import de.audi.app.tuner.truffles.IRadioSearch;
import de.audi.app.tuner.truffles.ISearchGUI;
import de.audi.app.tuner.truffles.RadioSearch;
import de.audi.app.tuner.truffles.RadioSearchDataProvider;
import de.audi.app.tuner.truffles.SearchGUI;
import de.audi.app.tuner.truffles.TrufflesCommandHandler;
import de.audi.app.tuner.truffles.frequency.FrequencySearchHandler;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.tuner.app.AppTuner;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.app.history.HistoryTuner;
import de.audi.tuner.ifc.IMemoryList;
import de.audi.tuner.ifc.listener.IUpdateListener;
import de.audi.tuner.sds.UpdateListenerHandler;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.search.DSISearchDataProviderListener;
import org.osgi.framework.BundleContext;

public class AppTunerEvo {
    private final ISearchGUI searchGui;
    private final IRadioSearch radioSearch;
    private final AppTuner appTuner;
    final DSISearchDataProviderListener searchDataProvider;
    private final FrequencySearchHandler frequencySearch;

    public AppTunerEvo(AppTuner appTuner, IFrameworkAccess iFrameworkAccess, BundleContext bundleContext) {
        Object object;
        this.appTuner = appTuner;
        if (Utilities.isEvoHigh()) {
            object = new TrufflesCommandHandler();
            this.frequencySearch = new FrequencySearchHandler(appTuner.getBasics());
            TunerProxyManager.getInstance().getAmFmTuner().registerDsiUpDownListener(this.frequencySearch.upListener);
            this.radioSearch = new RadioSearch(bundleContext, iFrameworkAccess, appTuner.getBasics());
            this.searchGui = new SearchGUI(appTuner.getBasics(), this.radioSearch, this.frequencySearch, (TrufflesCommandHandler)object, appTuner.getMemory());
            this.radioSearch.setActiveGuiSearchHandler(this.searchGui);
            this.searchDataProvider = new RadioSearchDataProvider(appTuner.getBasics(), appTuner.getMemory(), (TrufflesCommandHandler)object, this.searchGui);
            appTuner.register(((RadioSearchDataProvider)this.searchDataProvider).searchListener, 100480);
            appTuner.getHMIApplication().addListener(((SearchGUI)this.searchGui).hmiAppListener);
        } else {
            this.radioSearch = null;
            this.searchGui = null;
            this.searchDataProvider = null;
            this.frequencySearch = null;
            appTuner.getBasics().getModels().getSpellerModel(100442).setStatus(0);
        }
        object = appTuner.getMemory();
        appTuner.getCombiTunerListener().setFavortieListHandler((IMemoryList)object);
        appTuner.getCombiServiceHandler().setFavortieListHandler((IMemoryList)object);
        appTuner.getTunerServiceHandler().setFavortieListHandler((IMemoryList)object);
        HistoryTuner historyTuner = appTuner.getHistory();
        IUpdateListener[] iUpdateListenerArray = TunerProxyManager.getInstance().getAmFmTuner().getUpdateListeners((IMemoryList)object);
        for (int i2 = 0; i2 < iUpdateListenerArray.length; ++i2) {
            ((UpdateListenerHandler)object).addUpdateListener(iUpdateListenerArray[i2]);
        }
        ((UpdateListenerHandler)object).addUpdateListener(TunerProxyManager.getInstance().getSDARSTuner().getUpdateListener((IMemoryList)object));
        ((UpdateListenerHandler)object).addUpdateListener(appTuner.getBandList().updateListener);
        if (historyTuner != null) {
            ((UpdateListenerHandler)object).addUpdateListener(historyTuner.getUpdateListener((IMemoryList)object));
        }
        ((UpdateListenerHandler)object).addUpdateListener(appTuner.getTunerServiceHandler());
        ((UpdateListenerHandler)object).addUpdateListener(appTuner.getCombiServiceHandler());
    }

    public TunerActionProxyListener[] getActionProxyListeners() {
        if (this.searchGui != null) {
            return new TunerActionProxyListener[]{((SearchGUI)this.searchGui).actionProxy};
        }
        return new TunerActionProxyListener[0];
    }

    public void setDeviceService(DSIBase dSIBase) {
        if (this.searchDataProvider != null) {
            RadioSearchDataProvider radioSearchDataProvider = (RadioSearchDataProvider)this.searchDataProvider;
            radioSearchDataProvider.setDeviceService(dSIBase);
            this.appTuner.registerUpdateListener(radioSearchDataProvider.updateListener);
            this.appTuner.registerUpdateListener(this.searchGui.getUpdateListener());
        }
    }
}

