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
        return this.getHMIService().getChoiceModel(1100257);
    }

    final ButtonModelApp getETCPaymentHistoryButton() {
        return this.getHMIService().getButtonModel(1100281);
    }

    final ButtonModelApp getETCHardwareInformationButton() {
        return this.getHMIService().getButtonModel(1100282);
    }

    final ButtonModelApp getETCSettingsButton() {
        return this.getHMIService().getButtonModel(1100280);
    }

    final LabelModelApp getETCHardwareIDNumberLabel() {
        return this.getHMIService().getLabelModel(1100272);
    }

    final LabelModelApp getETCHardwareManufacturerNameLabel() {
        return this.getHMIService().getLabelModel(1100273);
    }

    final LabelModelApp getETCHardwareTypeApprovalModelNameLabel() {
        return this.getHMIService().getLabelModel(1100271);
    }

    final LabelModelApp getETCHardwareModelNameLabel() {
        return this.getHMIService().getLabelModel(1100274);
    }

    final LabelModelApp getETCHardwareSerialNumberLabel() {
        return this.getHMIService().getLabelModel(1100275);
    }

    final BaseListModelApp getETCPaymentHistoryList() {
        return this.getHMIService().getBaseListModel(1100276);
    }

    final LabelModelApp getETCPaymentHistoryDetailExitICNameLabel() {
        return this.getHMIService().getLabelModel(1100262);
    }

    final LabelModelApp getETCPaymentHistoryDetailExitICRoadNameLabel() {
        return this.getHMIService().getLabelModel(1100267);
    }

    final LabelModelApp getETCPaymentHistoryDetailEntranceICNameLabel() {
        return this.getHMIService().getLabelModel(1100266);
    }

    final LabelModelApp getETCPaymentHistoryDetailEntranceICRoadNameLabel() {
        return this.getHMIService().getLabelModel(1100268);
    }

    final LabelModelApp getETCPaymentHistoryDetailTitleLabel() {
        return this.getHMIService().getLabelModel(1100264);
    }

    final LabelModelApp getETCPaymentHistoryDetailAmountLabel() {
        return this.getHMIService().getLabelModel(1100269);
    }

    final ChoiceModelApp getETCAmountAnnouncementChoice() {
        return this.getHMIService().getChoiceModel(1100260);
    }

    final ChoiceModelApp getETCAmountNoticeChoice() {
        return this.getHMIService().getChoiceModel(1100261);
    }

    final ChoiceModelApp getETCCardPickUpReminderChoice() {
        return this.getHMIService().getChoiceModel(1100258);
    }

    final ChoiceModelApp getETCWarningChoice() {
        return this.getHMIService().getChoiceModel(1100259);
    }

    final ChoiceModelApp getETCErrorPopupTypeChoice() {
        return this.getHMIService().getChoiceModel(1100277);
    }

    final LabelModelApp getETCErrorCodeLabel() {
        return this.getHMIService().getLabelModel(1100284);
    }

    final LabelModelApp getPopupPassGateFeeLabel() {
        return this.getHMIService().getLabelModel(1100279);
    }

    final ChoiceModelApp getPopupPassGateChoice() {
        return this.getHMIService().getChoiceModel(1100278);
    }

    final ChoiceModelApp getETCPaymentHistoryButtonAvailableChoice() {
        return this.getHMIService().getChoiceModel(1100319);
    }

    final ChoiceModelApp getETCIconChoiceModel() {
        return this.getHMIService().getChoiceModel(381);
    }

    final ChoiceModelApp getETCHistoryDetailsRefundChoiceModel() {
        return this.getHMIService().getChoiceModel(1100317);
    }
}

