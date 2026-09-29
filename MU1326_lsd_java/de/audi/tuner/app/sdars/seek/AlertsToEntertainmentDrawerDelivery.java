/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.sdars.seek.AlertsToEntertainmentDrawerDelivery$AlertData;
import de.audi.tuner.app.sdars.seek.AlertsToEntertainmentDrawerDelivery$TimerListener;
import de.audi.tuner.app.sdars.seek.IEnrichedSeekAlertListener;
import de.audi.tuner.app.sdars.seek.SeekAlertIconTypeEnum;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.sdars.SeekEntry;

public class AlertsToEntertainmentDrawerDelivery
implements IEnrichedSeekAlertListener {
    private static final long CLEAR_DRAWER_AFTER_MS;
    private final Object mutex = new Object();
    private final LogChannel lc;
    private final Timer clearTimer;
    private AlertsToEntertainmentDrawerDelivery$AlertData lastDeliveredAlert = AlertsToEntertainmentDrawerDelivery$AlertData.access$000();
    private final LabelModelApp drawerAlertLabel;
    private final ChoiceModelApp drawerAlertType;
    private final ChoiceModelApp musicSeekNotificationDeliveryActiveChoice;
    private final ChoiceModelApp gameAlertNotificationDeliveryActiveChoice;

    public AlertsToEntertainmentDrawerDelivery(TunerBasics tunerBasics) {
        this.lc = tunerBasics.getLogger().sdarsSeekDSI;
        this.clearTimer = new Timer("AlertsToEntertainmentDrawerDelivery.ClearTimer", 0, true, new AlertsToEntertainmentDrawerDelivery$TimerListener(this, null));
        TunerModels tunerModels = tunerBasics.getModels();
        this.drawerAlertLabel = tunerModels.getLabelModel(780730624);
        this.drawerAlertType = tunerModels.getChoiceModel(797507840);
        this.musicSeekNotificationDeliveryActiveChoice = tunerModels.getChoiceModel(763953408);
        this.gameAlertNotificationDeliveryActiveChoice = tunerModels.getChoiceModel(1149763840);
        this.drawerAlertLabel.setText("");
        this.drawerAlertType.setValue(SeekAlertIconTypeEnum.NO_TYPE.ordinal);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void alertStarted(int n, int n2, SeekEntry seekEntry) {
        this.lc.log(-2137614336, "[AlertsToEntertainmentDrawerDelivery.alertStarted] seekID %1, sID %2", (long)n, (long)n2);
        SeekAlertIconTypeEnum seekAlertIconTypeEnum = SeekAlertIconTypeEnum.forSeekEntry(seekEntry);
        boolean bl = TunerModels.checkboxConstantToBoolean(this.musicSeekNotificationDeliveryActiveChoice.getValue());
        boolean bl2 = TunerModels.checkboxConstantToBoolean(this.gameAlertNotificationDeliveryActiveChoice.getValue());
        if (seekAlertIconTypeEnum.musicSeekRelated && bl || seekAlertIconTypeEnum.gameAlertRelated && bl2) {
            Object object = this.mutex;
            synchronized (object) {
                this.lastDeliveredAlert = new AlertsToEntertainmentDrawerDelivery$AlertData(n, n2);
                Buffer buffer = new Buffer().append(seekEntry.title1);
                if (!Utilities.isEmpty(seekEntry.title2)) {
                    buffer.append(" - ").append(seekEntry.title2);
                }
                int n3 = seekAlertIconTypeEnum.ordinal;
                String string = buffer.toString();
                this.lc.log(-2137614336, "[AlertsToEntertainmentDrawerDelivery.alertStarted] delivering '%1', %2 (%3)", (Object)string, (Object)seekAlertIconTypeEnum.name, (long)n3);
                this.drawerAlertLabel.setText(string);
                this.drawerAlertType.setValue(n3);
                this.clearTimer.restart();
            }
        } else {
            this.lc.log(-2137614336, "[AlertsToEntertainmentDrawerDelivery.alertStarted] Delivery temporary deactivated!");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void alertStopped(int n, int n2) {
        this.lc.log(-2137614336, "[AlertsToEntertainmentDrawerDelivery.alertStopped] seekID %1, sID %2", (long)n, (long)n2);
        Object object = this.mutex;
        synchronized (object) {
            if (AlertsToEntertainmentDrawerDelivery$AlertData.access$200(this.lastDeliveredAlert) == n && AlertsToEntertainmentDrawerDelivery$AlertData.access$300(this.lastDeliveredAlert) == n2) {
                this.lc.log(-2137614336, "[AlertsToEntertainmentDrawerDelivery.alertStopped] Stop matches! Clearing alert immediately");
                this.clearAlert();
                this.clearTimer.cancel();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void clearAlert() {
        this.lc.log(-2137614336, "[AlertsToEntertainmentDrawerDelivery.clearAlert]");
        Object object = this.mutex;
        synchronized (object) {
            this.lastDeliveredAlert = AlertsToEntertainmentDrawerDelivery$AlertData.access$000();
            this.drawerAlertLabel.setText("");
            this.drawerAlertType.setValue(SeekAlertIconTypeEnum.NO_TYPE.ordinal);
        }
    }

    static /* synthetic */ LogChannel access$400(AlertsToEntertainmentDrawerDelivery alertsToEntertainmentDrawerDelivery) {
        return alertsToEntertainmentDrawerDelivery.lc;
    }

    static /* synthetic */ void access$500(AlertsToEntertainmentDrawerDelivery alertsToEntertainmentDrawerDelivery) {
        alertsToEntertainmentDrawerDelivery.clearAlert();
    }
}

