/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.truffles.frequency;

import de.audi.app.tuner.truffles.ISearchGUI;
import de.audi.app.tuner.truffles.RadioSearchListRow;
import de.audi.app.tuner.truffles.frequency.AmFrequencySearch;
import de.audi.app.tuner.truffles.frequency.FmFrequencySearch;
import de.audi.app.tuner.truffles.frequency.SdarsFrequencySearch;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import org.dsi.ifc.radio.WavebandInfo;

public class FrequencySearchHandler {
    private final BaseListModelApp searchList;
    private final AmFrequencySearch amFrequencySearch;
    private final FmFrequencySearch fmFrequencySearch;
    private final SdarsFrequencySearch sdarsFrequencySearch;
    public final DsiUpListener upListener = new DsiUpListener();
    public ISearchGUI searchGUI = null;

    public FrequencySearchHandler(TunerBasics tunerBasics) {
        this.searchList = tunerBasics.getModels().getBaseListModel(100544);
        this.amFrequencySearch = new AmFrequencySearch(tunerBasics.getLogger().truffles);
        this.fmFrequencySearch = new FmFrequencySearch(tunerBasics.getLogger().truffles);
        this.sdarsFrequencySearch = new SdarsFrequencySearch();
    }

    public void registerSearchGui(ISearchGUI iSearchGUI) {
        this.searchGUI = iSearchGUI;
    }

    public void textChanged(String string) {
        RadioSearchListRow radioSearchListRow = null;
        BaseListModelApp baseListModelApp = this.searchList.getEmptyCopy();
        radioSearchListRow = this.amFrequencySearch.getRowForFrequency(string);
        if (radioSearchListRow != null) {
            baseListModelApp.append(radioSearchListRow);
        }
        if ((radioSearchListRow = this.fmFrequencySearch.getRowForFrequency(string)) != null) {
            baseListModelApp.append(radioSearchListRow);
        }
        if ((radioSearchListRow = this.sdarsFrequencySearch.getRowForFrequency(string)) != null) {
            baseListModelApp.append(radioSearchListRow);
        }
        this.searchList.update(baseListModelApp);
        if (this.searchGUI != null) {
            this.searchGUI.frequencySearchEnded(this.searchList.getLength());
        }
    }

    public void clearSearchResults() {
        this.searchList.removeAll();
    }

    private class DsiUpListener
    extends AMFMDsiUpInfo {
        private DsiUpListener() {
        }

        public void updateWavebandInfoList(WavebandInfo[] wavebandInfoArray) {
            block4: for (int i2 = 0; i2 < wavebandInfoArray.length; ++i2) {
                switch (wavebandInfoArray[i2].waveband) {
                    case 1: {
                        FrequencySearchHandler.this.fmFrequencySearch.updateBandInformation(new WavebandInfo[]{wavebandInfoArray[i2]});
                        continue block4;
                    }
                    case 3: {
                        FrequencySearchHandler.this.amFrequencySearch.updateBandInformation(new WavebandInfo[]{wavebandInfoArray[i2]});
                        continue block4;
                    }
                }
            }
        }
    }
}

