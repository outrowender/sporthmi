/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.model.MetricsModel;
import de.audi.atip.metrics.AbstractMetrics;
import de.audi.atip.metrics.DateMetric;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractInternalCursorWidgetController;
import java.util.Calendar;
import java.util.Date;

public abstract class AbstractTimeDateController
extends AbstractInternalCursorWidgetController {
    private Calendar calendar;
    private boolean suppressModelWrites;
    private boolean suppressModelReadsOnEnteringEditableMode;

    @Override
    protected void enterEditableMode() {
        if (!this.suppressModelReadsOnEnteringEditableMode && this.model instanceof MetricsModel) {
            DateMetric dateMetric = (DateMetric)((MetricsModel)this.model).getMetric();
            if (dateMetric != null) {
                Calendar calendar = this.getCalendar();
                this.readDataFromModel(this.model, calendar);
            } else {
                menuItemLogCh.log(10000, "DateSettingsWidgetController#connected Metric contained in the model is null.");
            }
        }
    }

    public Calendar getCalendar() {
        if (this.calendar == null) {
            this.calendar = Calendar.getInstance();
        }
        return this.calendar;
    }

    protected void readDataFromModel(Object object, Calendar calendar) {
        menuItemLogCh.log(-2137614336, "%1#readDataFromModel: %2", (Object)super.getClass().getName(), object);
        if (object != null) {
            if (object instanceof MetricsModel) {
                AbstractMetrics abstractMetrics = ((MetricsModel)object).getMetric();
                if (abstractMetrics instanceof DateMetric) {
                    DateMetric dateMetric = (DateMetric)abstractMetrics;
                    Date date = dateMetric.getDate();
                    calendar.setTime(date);
                    menuItemLogCh.log(-2137614336, "AbstractTimeDateController#readDataFromModel time in model: %1", (Object)date);
                } else {
                    menuItemLogCh.log(-2137614336, "AbstractTimeDateController#readDataFromModel Metric (%1) is not a DateMetric.", (Object)abstractMetrics);
                }
            } else {
                menuItemLogCh.log(-2137614336, "AbstractTimeDateController#readDataFromModel Model is not a MetricsModel.");
            }
        }
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public void setSuppressModelReadsOnEnteringEditableMode(boolean bl) {
        this.suppressModelReadsOnEnteringEditableMode = bl;
    }

    public void setSuppressModelWrites(boolean bl) {
        this.suppressModelWrites = bl;
    }

    protected void writeDataToModel() {
        menuItemLogCh.log(-2137614336, "%1#writeDataToModel", (Object)super.getClass().getName());
        if (!this.suppressModelWrites) {
            AbstractTimeDateController.writeDataToModel(this.getModel(), this.calendar, this.terminal.getTerminalID());
        }
    }

    protected static void writeDataToModel(Object object, Calendar calendar, int n) {
        if (object instanceof MetricsModel) {
            MetricsModel metricsModel = (MetricsModel)object;
            AbstractMetrics abstractMetrics = metricsModel.getMetric();
            if (abstractMetrics instanceof DateMetric) {
                DateMetric dateMetric = (DateMetric)abstractMetrics;
                Date date = calendar.getTime();
                dateMetric.setDate(date);
                metricsModel.metricsUpdated(n);
                menuItemLogCh.log(-2137614336, "AbstractTimeDateController#writeDataToModel new time: %1", (Object)date);
            }
        } else {
            menuItemLogCh.log(-1601830656, "AbstractTimeDateController#writeDataToModel wrong model connected %1.", object);
        }
    }
}

