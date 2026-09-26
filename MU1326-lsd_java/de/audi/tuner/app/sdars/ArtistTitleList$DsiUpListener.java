/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.sdars.ArtistTitleList;
import de.audi.tuner.app.sdars.ArtistTitleList$1;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import org.dsi.ifc.sdars.RadioText;
import org.dsi.ifc.sdars.SeekAlert;

class ArtistTitleList$DsiUpListener
extends SDARSDsiUpInfo {
    private final /* synthetic */ ArtistTitleList this$0;

    private ArtistTitleList$DsiUpListener(ArtistTitleList artistTitleList) {
        this.this$0 = artistTitleList;
    }

    @Override
    public void updateSelectedStation(StationInfoExt stationInfoExt) {
        ArtistTitleList.access$402(this.this$0, stationInfoExt);
        ArtistTitleList.access$500(this.this$0);
        ArtistTitleList.access$600(this.this$0).flush();
    }

    @Override
    public void updateStationList(StationInfoExt[] stationInfoExtArray) {
        ArtistTitleList.access$702(this.this$0, stationInfoExtArray);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void informationRadioText2(RadioText[] radioTextArray) {
        Object object = ArtistTitleList.access$800(this.this$0);
        synchronized (object) {
            for (int i2 = 0; i2 < radioTextArray.length; ++i2) {
                if (radioTextArray[i2].sID >= 0 && radioTextArray[i2].sID < 384) {
                    ArtistTitleList.access$900(this.this$0, radioTextArray[i2]);
                    continue;
                }
                ArtistTitleList.access$1000(this.this$0).log(10000, "[ATL.informationRadioText2] received invalid sId %1", (long)radioTextArray[i2].sID);
            }
        }
        ArtistTitleList.access$500(this.this$0);
        ArtistTitleList.access$600(this.this$0).flush();
    }

    @Override
    public void updateSeekAlert(SeekAlert seekAlert) {
        ArtistTitleList.access$1100(this.this$0, seekAlert.getSID(), seekAlert.getAlertType() == 1);
    }

    /* synthetic */ ArtistTitleList$DsiUpListener(ArtistTitleList artistTitleList, ArtistTitleList$1 artistTitleList$1) {
        this(artistTitleList);
    }
}

