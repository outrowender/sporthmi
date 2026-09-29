/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.log.LogChannelFactory;
import de.audi.atip.util.Util;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.sdars.dsi.SDARSDSISeekDownManager;
import de.audi.tuner.app.sdars.seek.AbstractSeekListSizeRistrictionHandler;
import de.audi.tuner.app.sdars.seek.WeatherHandler$ButtonListener;
import de.audi.tuner.app.sdars.seek.WeatherHandler$DsiUpListener;
import de.audi.tuner.app.sdars.seek.WeatherHandler$GUIInterfaceGUIDE;
import de.audi.tuner.app.sdars.seek.WeatherHandler$IGUIInterface;
import de.audi.tuner.app.sdars.seek.WeatherHandler$WeatherListListener;
import de.audi.tuner.app.sdars.seek.WeatherRow;
import de.audi.tuner.ifc.ITunerVariantExt;
import java.util.ArrayList;
import java.util.HashMap;
import org.dsi.ifc.sdars.SeekEntry;
import org.dsi.ifc.sdars.TrafficWxEntry;

public class WeatherHandler {
    public WeatherHandler$DsiUpListener dsiUpListener = new WeatherHandler$DsiUpListener(this);
    SDARSDSISeekDownManager dsiInterface;
    WeatherHandler$IGUIInterface guiInterface;
    private WeatherHandler$WeatherListListener weatherListListener = new WeatherHandler$WeatherListListener(this, null);
    BaseListModelApp marketListModel;
    TrafficWxEntry[] markets = new TrafficWxEntry[0];
    private final LogChannel logger;
    private final TunerModels models;
    private final ITunerVariantExt varExt;
    private final AbstractSeekListSizeRistrictionHandler sizeRestriction;
    public static final int UNDEFINED_ID;
    private final HashMap seekIdToSeekListEntryMap = new HashMap();
    private final HashMap sessionSeekIdToSeekListEntryMap = new HashMap();

    public WeatherHandler(TunerBasics tunerBasics, SDARSDSISeekDownManager sDARSDSISeekDownManager, ITunerVariantExt iTunerVariantExt, AbstractSeekListSizeRistrictionHandler abstractSeekListSizeRistrictionHandler) {
        this.logger = tunerBasics.getLogger().sdarsSeekDSI;
        this.models = tunerBasics.getModels();
        this.guiInterface = new WeatherHandler$GUIInterfaceGUIDE(this, null);
        this.dsiInterface = sDARSDSISeekDownManager;
        this.varExt = iTunerVariantExt;
        this.sizeRestriction = abstractSeekListSizeRistrictionHandler;
        this.marketListModel = this.models.getBaseListModel(160039168);
        this.marketListModel.setListener(this.weatherListListener);
        this.initNewEditingSession();
        this.models.getButtonModel(411697408).setButtonListener(new WeatherHandler$ButtonListener(this, null));
    }

    WeatherHandler(LogChannelFactory logChannelFactory, WeatherHandler$IGUIInterface weatherHandler$IGUIInterface, SDARSDSISeekDownManager sDARSDSISeekDownManager, ITunerVariantExt iTunerVariantExt, AbstractSeekListSizeRistrictionHandler abstractSeekListSizeRistrictionHandler) {
        this.logger = logChannelFactory.getLogChannel("App.Tuner.SDARS.Seek");
        this.models = null;
        this.guiInterface = weatherHandler$IGUIInterface;
        this.dsiInterface = sDARSDSISeekDownManager;
        this.varExt = iTunerVariantExt;
        this.sizeRestriction = abstractSeekListSizeRistrictionHandler;
    }

    void disableSeek(int n) {
        this.dsiInterface.manageSeek2(4, n, 0, 2);
    }

    void enableSeek(int n) {
        this.dsiInterface.manageSeek2(4, n, 0, 1);
    }

    final void updateWeatherMarketModel() {
        ArrayList arrayList = new ArrayList(this.markets.length);
        for (int i2 = 0; i2 < this.markets.length; ++i2) {
            TrafficWxEntry trafficWxEntry = this.markets[i2];
            SeekEntry seekEntry = (SeekEntry)this.seekIdToSeekListEntryMap.get(Util.createInteger(trafficWxEntry.getSeekID()));
            boolean bl = seekEntry != null && seekEntry.isSeekActive();
            int n = TunerModels.booleanToCheckboxConstant(bl);
            SeekEntry seekEntry2 = (SeekEntry)this.sessionSeekIdToSeekListEntryMap.get(Util.createInteger(trafficWxEntry.getSeekID()));
            boolean bl2 = seekEntry2 != null && seekEntry2.isSeekActive();
            int n2 = TunerModels.booleanToCheckboxConstant(bl2);
            WeatherRow weatherRow = new WeatherRow(trafficWxEntry.getSeekID(), trafficWxEntry.getMarketName(), n, n2);
            arrayList.add(weatherRow);
        }
        if (this.marketListModel != null) {
            BaseListModelApp baseListModelApp = this.marketListModel.getEmptyCopy();
            baseListModelApp.append((EvoListRow[])arrayList.toArray(new WeatherRow[arrayList.size()]));
            this.marketListModel.update(baseListModelApp);
        }
    }

    private void updateSessionAddCounter(int n) {
        LabelModelApp labelModelApp = this.models.getLabelModel(361365760);
        int n2 = Integer.parseInt(labelModelApp.getText()) + n;
        labelModelApp.setText(String.valueOf(n2));
    }

    private void initNewEditingSession() {
        this.sessionSeekIdToSeekListEntryMap.clear();
        this.sessionSeekIdToSeekListEntryMap.putAll(this.seekIdToSeekListEntryMap);
        this.models.getLabelModel(361365760).setText("0");
        this.updateWeatherMarketModel();
    }

    static /* synthetic */ void access$300(WeatherHandler weatherHandler) {
        weatherHandler.initNewEditingSession();
    }

    static /* synthetic */ LogChannel access$400(WeatherHandler weatherHandler) {
        return weatherHandler.logger;
    }

    static /* synthetic */ HashMap access$500(WeatherHandler weatherHandler) {
        return weatherHandler.seekIdToSeekListEntryMap;
    }

    static /* synthetic */ AbstractSeekListSizeRistrictionHandler access$600(WeatherHandler weatherHandler) {
        return weatherHandler.sizeRestriction;
    }

    static /* synthetic */ ITunerVariantExt access$700(WeatherHandler weatherHandler) {
        return weatherHandler.varExt;
    }

    static /* synthetic */ void access$800(WeatherHandler weatherHandler, int n) {
        weatherHandler.updateSessionAddCounter(n);
    }
}

