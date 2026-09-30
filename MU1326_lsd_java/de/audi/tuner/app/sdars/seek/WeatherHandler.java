/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.log.LogChannelFactory;
import de.audi.atip.util.Util;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.sdars.dsi.SDARSDSISeekDownManager;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.audi.tuner.app.sdars.seek.AbstractSeekListSizeRistrictionHandler;
import de.audi.tuner.app.sdars.seek.WeatherRow;
import de.audi.tuner.ifc.ITunerVariantExt;
import java.util.ArrayList;
import java.util.HashMap;
import org.dsi.ifc.sdars.SeekEntry;
import org.dsi.ifc.sdars.TrafficWxEntry;

public class WeatherHandler {
    public DsiUpListener dsiUpListener = new DsiUpListener();
    SDARSDSISeekDownManager dsiInterface;
    IGUIInterface guiInterface;
    private WeatherListListener weatherListListener = new WeatherListListener();
    BaseListModelApp marketListModel;
    TrafficWxEntry[] markets = new TrafficWxEntry[0];
    private final LogChannel logger;
    private final TunerModels models;
    private final ITunerVariantExt varExt;
    private final AbstractSeekListSizeRistrictionHandler sizeRestriction;
    public static final int UNDEFINED_ID = 0;
    private final HashMap seekIdToSeekListEntryMap = new HashMap();
    private final HashMap sessionSeekIdToSeekListEntryMap = new HashMap();

    public WeatherHandler(TunerBasics tunerBasics, SDARSDSISeekDownManager sDARSDSISeekDownManager, ITunerVariantExt iTunerVariantExt, AbstractSeekListSizeRistrictionHandler abstractSeekListSizeRistrictionHandler) {
        this.logger = tunerBasics.getLogger().sdarsSeekDSI;
        this.models = tunerBasics.getModels();
        this.guiInterface = new GUIInterfaceGUIDE();
        this.dsiInterface = sDARSDSISeekDownManager;
        this.varExt = iTunerVariantExt;
        this.sizeRestriction = abstractSeekListSizeRistrictionHandler;
        this.marketListModel = this.models.getBaseListModel(100873);
        this.marketListModel.setListener(this.weatherListListener);
        this.initNewEditingSession();
        this.models.getButtonModel(100888).setButtonListener(new ButtonListener());
    }

    WeatherHandler(LogChannelFactory logChannelFactory, IGUIInterface iGUIInterface, SDARSDSISeekDownManager sDARSDSISeekDownManager, ITunerVariantExt iTunerVariantExt, AbstractSeekListSizeRistrictionHandler abstractSeekListSizeRistrictionHandler) {
        this.logger = logChannelFactory.getLogChannel("App.Tuner.SDARS.Seek");
        this.models = null;
        this.guiInterface = iGUIInterface;
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
        LabelModelApp labelModelApp = this.models.getLabelModel(100885);
        int n2 = Integer.parseInt(labelModelApp.getText()) + n;
        labelModelApp.setText(String.valueOf(n2));
    }

    private void initNewEditingSession() {
        this.sessionSeekIdToSeekListEntryMap.clear();
        this.sessionSeekIdToSeekListEntryMap.putAll(this.seekIdToSeekListEntryMap);
        this.models.getLabelModel(100885).setText("0");
        this.updateWeatherMarketModel();
    }

    class DsiUpListener
    extends SDARSDsiUpInfo {
        DsiUpListener() {
        }

        public void updateSeekList(SeekEntry[] seekEntryArray) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < seekEntryArray.length; ++i2) {
                SeekEntry seekEntry = seekEntryArray[i2];
                if (seekEntry.getTypeOfContent() != 4) continue;
                arrayList.add(seekEntry);
            }
            Object[] objectArray = new SeekEntry[arrayList.size()];
            arrayList.toArray(objectArray);
            WeatherHandler.this.guiInterface.updateWeatherSeekList((SeekEntry[])objectArray);
        }

        public void updateTrafficWeatherList(TrafficWxEntry[] trafficWxEntryArray) {
            WeatherHandler.this.guiInterface.updateWeatherMarketList(trafficWxEntryArray);
        }

        public void updateAvailability(int n) {
            if (n == 1 && WeatherHandler.this.marketListModel != null) {
                WeatherHandler.this.marketListModel.fireEvent(0);
            }
        }
    }

    static interface IGUIInterface {
        public void updateWeatherSeekList(SeekEntry[] var1);

        public void updateWeatherMarketList(TrafficWxEntry[] var1);
    }

    private class ButtonListener
    extends DefaultButtonListener {
        private ButtonListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            WeatherHandler.this.initNewEditingSession();
        }
    }

    private class GUIInterfaceGUIDE
    implements IGUIInterface {
        private GUIInterfaceGUIDE() {
        }

        public void updateWeatherSeekList(SeekEntry[] seekEntryArray) {
            WeatherHandler.this.logger.log(10000000, "WeatherHandler.updateWeatherSeekList()");
            WeatherHandler.this.seekIdToSeekListEntryMap.clear();
            for (int i2 = 0; i2 < seekEntryArray.length; ++i2) {
                SeekEntry seekEntry = seekEntryArray[i2];
                WeatherHandler.this.seekIdToSeekListEntryMap.put(Util.createInteger(seekEntry.getSeekID()), seekEntry);
            }
            WeatherHandler.this.updateWeatherMarketModel();
        }

        public void updateWeatherMarketList(TrafficWxEntry[] trafficWxEntryArray) {
            WeatherHandler.this.logger.log(10000000, "WeatherHandler.updateWeatherMarketList()");
            WeatherHandler.this.markets = trafficWxEntryArray;
            WeatherHandler.this.updateWeatherMarketModel();
        }
    }

    private class WeatherListListener
    extends DefaultBaseListModelListener {
        private WeatherListListener() {
        }

        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            WeatherRow weatherRow = (WeatherRow)evoListRow;
            boolean bl = weatherRow.isActivationCheckboxSelected();
            int n5 = !bl ? 1 : 3;
            boolean bl2 = WeatherHandler.this.sizeRestriction.isSeekListFull(4);
            if (bl2 && n5 == 1) {
                WeatherHandler.this.varExt.showPartialPopup(16);
            } else {
                int n6 = n5 == 1 ? 1 : -1;
                WeatherHandler.this.updateSessionAddCounter(n6);
                WeatherHandler.this.dsiInterface.manageSeek2(4, weatherRow.getSeekId(), 0, n5);
            }
        }
    }
}

