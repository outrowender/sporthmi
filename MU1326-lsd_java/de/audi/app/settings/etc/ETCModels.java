/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.etc;

import de.audi.app.settings.SettingsEnv;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;

public class ETCModels {
    private final SettingsEnv env;

    public ETCModels(SettingsEnv settingsEnv) {
        this.env = settingsEnv;
    }

    private final IHMIServiceApp getHMIService() {
        return this.env.getFw().getHmiServiceApp();
    }

    final ChoiceModelApp getETCStatusChoice() {
        return this.getHMIService().getChoiceModel(-506916864);
    }

    final ButtonModelApp getETCPaymentHistoryButton() {
        return this.getHMIService().getButtonModel(-104263680);
    }

    final ButtonModelApp getETCHardwareInformationButton() {
        return this.getHMIService().getButtonModel(-87486464);
    }

    final ButtonModelApp getETCSettingsButton() {
        return this.getHMIService().getButtonModel(-121040896);
    }

    final LabelModelApp getETCHardwareIDNumberLabel() {
        return this.getHMIService().getLabelModel(-255258624);
    }

    final LabelModelApp getETCHardwareManufacturerNameLabel() {
        return this.getHMIService().getLabelModel(-238481408);
    }

    final LabelModelApp getETCHardwareTypeApprovalModelNameLabel() {
        return this.getHMIService().getLabelModel(-272035840);
    }

    final LabelModelApp getETCHardwareModelNameLabel() {
        return this.getHMIService().getLabelModel(-221704192);
    }

    final LabelModelApp getETCHardwareSerialNumberLabel() {
        return this.getHMIService().getLabelModel(-204926976);
    }

    final BaseListModelApp getETCPaymentHistoryList() {
        return this.getHMIService().getBaseListModel(-188149760);
    }

    final LabelModelApp getETCPaymentHistoryDetailExitICNameLabel() {
        return this.getHMIService().getLabelModel(-423030784);
    }

    final LabelModelApp getETCPaymentHistoryDetailExitICRoadNameLabel() {
        return this.getHMIService().getLabelModel(-339144704);
    }

    final LabelModelApp getETCPaymentHistoryDetailEntranceICNameLabel() {
        return this.getHMIService().getLabelModel(-355921920);
    }

    final LabelModelApp getETCPaymentHistoryDetailEntranceICRoadNameLabel() {
        return this.getHMIService().getLabelModel(-322367488);
    }

    final LabelModelApp getETCPaymentHistoryDetailTitleLabel() {
        return this.getHMIService().getLabelModel(-389476352);
    }

    final LabelModelApp getETCPaymentHistoryDetailAmountLabel() {
        return this.getHMIService().getLabelModel(-305590272);
    }

    final ChoiceModelApp getETCAmountAnnouncementChoice() {
        return this.getHMIService().getChoiceModel(-456585216);
    }

    final ChoiceModelApp getETCAmountNoticeChoice() {
        return this.getHMIService().getChoiceModel(-439808000);
    }

    final ChoiceModelApp getETCCardPickUpReminderChoice() {
        return this.getHMIService().getChoiceModel(-490139648);
    }

    final ChoiceModelApp getETCWarningChoice() {
        return this.getHMIService().getChoiceModel(-473362432);
    }

    final ChoiceModelApp getETCErrorPopupTypeChoice() {
        return this.getHMIService().getChoiceModel(-171372544);
    }

    final LabelModelApp getETCErrorCodeLabel() {
        return this.getHMIService().getLabelModel(-53932032);
    }

    final LabelModelApp getPopupPassGateFeeLabel() {
        return this.getHMIService().getLabelModel(-137818112);
    }

    final ChoiceModelApp getPopupPassGateChoice() {
        return this.getHMIService().getChoiceModel(-154595328);
    }

    final ChoiceModelApp getETCPaymentHistoryButtonAvailableChoice() {
        return this.getHMIService().getChoiceModel(533336064);
    }

    final ChoiceModelApp getETCIconChoiceModel() {
        return this.getHMIService().getChoiceModel(381);
    }

    final ChoiceModelApp getETCHistoryDetailsRefundChoiceModel() {
        return this.getHMIService().getChoiceModel(499781632);
    }
}

