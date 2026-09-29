/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.sdars.CategoryInfoExt;
import de.audi.tuner.app.sdars.SDARSLabels;
import de.audi.tuner.app.sdars.SDARSLabels$1;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.TeamSeekInformationEnum;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import org.dsi.ifc.sdars.SeekInformation;
import org.dsi.ifc.sdars.SeekPossibility;
import org.dsi.ifc.sdars.SeekState;

class SDARSLabels$DsiUpListener
extends SDARSDsiUpInfo {
    private final /* synthetic */ SDARSLabels this$0;

    private SDARSLabels$DsiUpListener(SDARSLabels sDARSLabels) {
        this.this$0 = sDARSLabels;
    }

    @Override
    public void updateSignalStatus(boolean bl) {
        SDARSLabels.access$400(this.this$0).getChoiceModel(-393740032).setValue(bl ? 1 : 0);
    }

    @Override
    public void updateSelectedStation(StationInfoExt stationInfoExt) {
        SDARSLabels.access$502(this.this$0, stationInfoExt);
        SDARSLabels.access$300(this.this$0, false);
    }

    @Override
    public void updateCategoryList(CategoryInfoExt[] categoryInfoExtArray) {
        SDARSLabels.access$300(this.this$0, false);
    }

    @Override
    public void updateStaticTaggingInfo(String string, String string2) {
        SDARSLabels.access$600(this.this$0).setStaticTaggingInfo(string, string2);
    }

    @Override
    public void updateSeekPossibility(SeekPossibility seekPossibility) {
        Object object;
        String string = "";
        String string2 = "";
        int n = 128;
        int n2 = 128;
        if (seekPossibility.seekInformation != null) {
            for (int i2 = 0; i2 < seekPossibility.seekInformation.length; ++i2) {
                object = seekPossibility.seekInformation[i2];
                TeamSeekInformationEnum teamSeekInformationEnum = TeamSeekInformationEnum.forOrdinal(((SeekInformation)object).seekInfo);
                if (teamSeekInformationEnum == null) continue;
                if (teamSeekInformationEnum.isTeamA) {
                    if (!teamSeekInformationEnum.isMoreImportantThan(n)) continue;
                    n = teamSeekInformationEnum.importance;
                    string = ((SeekInformation)object).seekText;
                    continue;
                }
                if (!teamSeekInformationEnum.isMoreImportantThan(n2)) continue;
                n2 = teamSeekInformationEnum.importance;
                string2 = ((SeekInformation)object).seekText;
            }
        }
        LabelModelApp labelModelApp = SDARSLabels.access$400(this.this$0).getLabelModel(1619460352);
        string = Utilities.isEmpty(string) ? "" : string;
        labelModelApp.setText(string);
        object = SDARSLabels.access$400(this.this$0).getLabelModel(1653014784);
        string2 = Utilities.isEmpty(string2) ? "" : string2;
        object.setText(string2);
        int n3 = seekPossibility.getTypeOfContent() == 1 ? 3 : 0;
        int n4 = seekPossibility.getTypeOfContent() == 3 ? 3 : 0;
        int n5 = n3;
        int n6 = n3;
        int n7 = n4;
        int n8 = n4;
        if (seekPossibility.seekState != null) {
            block7: for (int i3 = 0; i3 < seekPossibility.seekState.length; ++i3) {
                SeekState seekState = seekPossibility.seekState[i3];
                switch (seekState.seekType) {
                    case 1: {
                        n6 = seekState.state == 1 ? 3 : 1;
                        continue block7;
                    }
                    case 2: {
                        n5 = seekState.state == 1 ? 3 : 1;
                        continue block7;
                    }
                    case 4: {
                        n7 = seekState.state == 1 ? 3 : 1;
                        continue block7;
                    }
                    case 5: {
                        n8 = seekState.state == 1 ? 3 : 1;
                        continue block7;
                    }
                }
            }
        }
        SDARSLabels.access$400(this.this$0).getButtonModel(646512896).setStatus(n5);
        SDARSLabels.access$400(this.this$0).getButtonModel(663290112).setStatus(n6);
        SDARSLabels.access$400(this.this$0).getButtonModel(629735680).setStatus(n7);
        SDARSLabels.access$400(this.this$0).getButtonModel(680067328).setStatus(n8);
    }

    /* synthetic */ SDARSLabels$DsiUpListener(SDARSLabels sDARSLabels, SDARSLabels$1 sDARSLabels$1) {
        this(sDARSLabels);
    }
}

