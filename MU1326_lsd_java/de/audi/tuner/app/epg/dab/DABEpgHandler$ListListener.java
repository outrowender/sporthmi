/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg.dab;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.epg.dab.DABEpgHandler;
import de.audi.tuner.app.epg.dab.DABEpgHandler$1;
import de.audi.tuner.app.epg.dab.DABEpgHandler$EpgDetailRow;
import de.audi.tuner.app.epg.dab.EPGListRow;
import de.audi.tuner.app.uni.UnifiedStationExt;

class DABEpgHandler$ListListener
extends DefaultBaseListModelListener {
    private final /* synthetic */ DABEpgHandler this$0;

    private DABEpgHandler$ListListener(DABEpgHandler dABEpgHandler) {
        this.this$0 = dABEpgHandler;
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        switch (n) {
            case 100459: {
                DabStation dabStation = ((EPGListRow)evoListRow).getDabStation();
                if (evoListRow.getInteger(0) == 0) {
                    if (n3 == 0) {
                        DABEpgHandler.access$1000(this.this$0).setSelectedIndex(n2);
                        if (DABEpgHandler.access$1100(this.this$0).getActiveTuner() == 5) {
                            TunerProxyManager.getInstance().prepareAndTune(new TunerObjectContainer(dabStation), n4);
                            break;
                        }
                        UnifiedStationExt unifiedStationExt = new UnifiedStationExt();
                        unifiedStationExt.shortName = dabStation.getShortName();
                        unifiedStationExt.longName = dabStation.getFullName();
                        unifiedStationExt.frequency = dabStation.ensemble.frequencyValue;
                        unifiedStationExt.piSId = (int)dabStation.service.sID;
                        unifiedStationExt.ensId = dabStation.service.ensID;
                        unifiedStationExt.ecc = dabStation.service.ensECC;
                        unifiedStationExt.sCIDI = dabStation.component.sCIDI;
                        TunerProxyManager.getInstance().prepareAndTune(new TunerObjectContainer(unifiedStationExt), n4);
                        break;
                    }
                    this.prepareDetailsList(evoListRow, n4);
                    break;
                }
                DABEpgHandler.access$1200(this.this$0, (EPGListRow)evoListRow);
                DABEpgHandler.access$1100(this.this$0).getChoiceModel(-1601634048).setValue(1);
                DABEpgHandler.access$1000(this.this$0).fireEvent(n4);
                break;
            }
            case 100532: {
                DABEpgHandler.access$1300(this.this$0, n2);
                DABEpgHandler$EpgDetailRow dABEpgHandler$EpgDetailRow = (DABEpgHandler$EpgDetailRow)evoListRow;
                DABEpgHandler.access$1400(this.this$0, dABEpgHandler$EpgDetailRow.getDetails());
                DABEpgHandler.access$1100(this.this$0).getBaseListModel(-1266155264).fireEvent(n4);
                DABEpgHandler.access$1500(this.this$0).showPartialPopup(22);
                break;
            }
        }
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        if (Utilities.isPGen1OrBentley()) {
            this.prepareDetailsList(evoListRow, n4);
        }
    }

    private void prepareDetailsList(EvoListRow evoListRow, int n) {
        BaseListModelApp baseListModelApp = DABEpgHandler.access$1100(this.this$0).getBaseListModel(-1266155264);
        baseListModelApp.removeAll();
        DabStation dabStation = ((EPGListRow)evoListRow).getDabStation();
        DABEpgHandler.access$1602(this.this$0, dabStation);
        DABEpgHandler.access$1700(this.this$0).getEPGDetailData(dabStation);
        DABEpgHandler.access$1800(this.this$0, null);
        DABEpgHandler.access$1902(this.this$0, (EPGListRow)evoListRow);
        DABEpgHandler.access$1100(this.this$0).getLabelModel(495452416).setText(((EPGListRow)evoListRow).getStationName());
        DABEpgHandler.access$1100(this.this$0).getResourceLocatorModel(193593600).setResourceLocator(dabStation.getStationLogo());
        DABEpgHandler.access$1100(this.this$0).getResourceLocatorModel(-192413440).setResourceLocator(dabStation.getStationLogo());
        DABEpgHandler.access$1000(this.this$0).fireEvent(n);
    }

    /* synthetic */ DABEpgHandler$ListListener(DABEpgHandler dABEpgHandler, DABEpgHandler$1 dABEpgHandler$1) {
        this(dABEpgHandler);
    }
}

