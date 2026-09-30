/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.sdars.seek.IEnrichedSeekAlertListener;
import de.audi.tuner.app.sdars.seek.SeekAlertIconTypeEnum;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.sdars.SeekEntry;

public class AlertsToEntertainmentDrawerDelivery
implements IEnrichedSeekAlertListener {
    private static final long CLEAR_DRAWER_AFTER_MS = 9000L;
    private final Object mutex = new Object();
    private final LogChannel lc;
    private final Timer clearTimer;
    private AlertData lastDeliveredAlert = AlertData.access$000();
    private final LabelModelApp drawerAlertLabel;
    private final ChoiceModelApp drawerAlertType;
    private final ChoiceModelApp musicSeekNotificationDeliveryActiveChoice;
    private final ChoiceModelApp gameAlertNotificationDeliveryActiveChoice;

    public AlertsToEntertainmentDrawerDelivery(TunerBasics tunerBasics) {
        this.lc = tunerBasics.getLogger().sdarsSeekDSI;
        this.clearTimer = new Timer("AlertsToEntertainmentDrawerDelivery.ClearTimer", 9000L, true, new TimerListener());
        TunerModels tunerModels = tunerBasics.getModels();
        this.drawerAlertLabel = tunerModels.getLabelModel(100654);
        this.drawerAlertType = tunerModels.getChoiceModel(100655);
        this.musicSeekNotificationDeliveryActiveChoice = tunerModels.getChoiceModel(100653);
        this.gameAlertNotificationDeliveryActiveChoice = tunerModels.getChoiceModel(100420);
        this.drawerAlertLabel.setText("");
        this.drawerAlertType.setValue(SeekAlertIconTypeEnum.NO_TYPE.ordinal);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void alertStarted(int n, int n2, SeekEntry seekEntry) {
        this.lc.log(10000000, "[AlertsToEntertainmentDrawerDelivery.alertStarted] seekID %1, sID %2", (long)n, (long)n2);
        SeekAlertIconTypeEnum seekAlertIconTypeEnum = SeekAlertIconTypeEnum.forSeekEntry(seekEntry);
        boolean bl = TunerModels.checkboxConstantToBoolean(this.musicSeekNotificationDeliveryActiveChoice.getValue());
        boolean bl2 = TunerModels.checkboxConstantToBoolean(this.gameAlertNotificationDeliveryActiveChoice.getValue());
        if (seekAlertIconTypeEnum.musicSeekRelated && bl || seekAlertIconTypeEnum.gameAlertRelated && bl2) {
            Object object = this.mutex;
            synchronized (object) {
                this.lastDeliveredAlert = new AlertData(n, n2);
                Buffer buffer = new Buffer().append(seekEntry.title1);
                if (!Utilities.isEmpty(seekEntry.title2)) {
                    buffer.append(" - ").append(seekEntry.title2);
                }
                int n3 = seekAlertIconTypeEnum.ordinal;
                String string = buffer.toString();
                this.lc.log(10000000, "[AlertsToEntertainmentDrawerDelivery.alertStarted] delivering '%1', %2 (%3)", (Object)string, (Object)seekAlertIconTypeEnum.name, (long)n3);
                this.drawerAlertLabel.setText(string);
                this.drawerAlertType.setValue(n3);
                this.clearTimer.restart();
            }
        } else {
            this.lc.log(10000000, "[AlertsToEntertainmentDrawerDelivery.alertStarted] Delivery temporary deactivated!");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void alertStopped(int n, int n2) {
        this.lc.log(10000000, "[AlertsToEntertainmentDrawerDelivery.alertStopped] seekID %1, sID %2", (long)n, (long)n2);
        Object object = this.mutex;
        synchronized (object) {
            if (this.lastDeliveredAlert.seekID == n && this.lastDeliveredAlert.sID == n2) {
                this.lc.log(10000000, "[AlertsToEntertainmentDrawerDelivery.alertStopped] Stop matches! Clearing alert immediately");
                this.clearAlert();
                this.clearTimer.cancel();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void clearAlert() {
        this.lc.log(10000000, "[AlertsToEntertainmentDrawerDelivery.clearAlert]");
        Object object = this.mutex;
        synchronized (object) {
            this.lastDeliveredAlert = AlertData.NULL_ALERT_DATA;
            this.drawerAlertLabel.setText("");
            this.drawerAlertType.setValue(SeekAlertIconTypeEnum.NO_TYPE.ordinal);
        }
    }

    private static class AlertData {
        private static final AlertData NULL_ALERT_DATA = new AlertData(-1, -1);
        private final int seekID;
        private final int sID;

        public AlertData(int n, int n2) {
            this.seekID = n;
            this.sID = n2;
        }
    }

    private class TimerListener
    extends DefaultTimerListener {
        private TimerListener() {
        }

        public void fireTimer(Timer timer) {
            AlertsToEntertainmentDrawerDelivery.this.lc.log(10000000, "[AlertsToEntertainmentDrawerDelivery.TimerListener.fireTimer] Clearing alert, was shown long enough =)");
            AlertsToEntertainmentDrawerDelivery.this.clearAlert();
        }
    }
}

