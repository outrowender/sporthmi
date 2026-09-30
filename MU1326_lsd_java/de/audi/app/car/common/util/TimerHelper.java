/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.util;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.util.TimerObject;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.DateMetric;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerTimer;
import org.dsi.ifc.carhybrid.BatteryControlTimer;

public class TimerHelper {
    private ICarApplication application = null;
    private LogChannel logChannel = null;

    public TimerHelper(ICarApplication iCarApplication, LogChannel logChannel) {
        this.application = iCarApplication;
        this.logChannel = logChannel;
    }

    public static boolean isDateEarlierThan(Date date, Date date2) {
        long l = date.getTime() - date2.getTime() / 60000L * 60000L;
        return l < 0L;
    }

    public boolean isDateInThePast(Date date, String string) {
        Date date2 = ((DateMetric)this.application.getFrameworkAccess().getSysApp().getClock().getMetric()).getDate();
        if (TimerHelper.isDateEarlierThan(date, date2)) {
            this.logChannel.log(1000000, "[TimerHelper#isDateInThePast] Date in the past detected from method %1", (Object)string);
            return true;
        }
        return false;
    }

    public static void setTimerMetric(Date date, MetricsModelApp metricsModelApp, String string) {
        DateMetric dateMetric = (DateMetric)metricsModelApp.getMetric();
        if (dateMetric == null) {
            dateMetric = new DateMetric(date, 2);
        }
        dateMetric.setDate(date);
        metricsModelApp.setMetric(dateMetric);
    }

    public void setTimerMetric(TimerObject timerObject, MetricsModelApp metricsModelApp, String string) {
        Date date = TimerHelper.getCorrectDateFromTimer(timerObject);
        Date date2 = ((DateMetric)this.application.getFrameworkAccess().getSysApp().getClock().getMetric()).getDate();
        this.logChannel.log(1000000, "%1 update timer model (ID:VALUE) %2 -> ", (Object)string, (Object)("(" + metricsModelApp.getID() + ":" + date + ")"));
        DateMetric dateMetric = (DateMetric)metricsModelApp.getMetric();
        if (dateMetric == null) {
            dateMetric = new DateMetric(date, 2);
        }
        dateMetric.setDate(date);
        metricsModelApp.setMetric(dateMetric);
    }

    public TimerObject castTimerToGeneralObject(AuxHeaterCoolerTimer auxHeaterCoolerTimer) {
        TimerObject timerObject = new TimerObject();
        timerObject.setMonth(auxHeaterCoolerTimer.getMonth());
        timerObject.setYear(auxHeaterCoolerTimer.getYear());
        timerObject.setDay(auxHeaterCoolerTimer.getDay());
        timerObject.setHour(auxHeaterCoolerTimer.getHour());
        timerObject.setMinute(auxHeaterCoolerTimer.getMinute());
        return timerObject;
    }

    public TimerObject castTimerToGeneralObject(BatteryControlTimer batteryControlTimer) {
        TimerObject timerObject = new TimerObject();
        timerObject.setMonth(batteryControlTimer.getMonth());
        if (batteryControlTimer.getYear() < 2000) {
            timerObject.setYear(batteryControlTimer.getYear() + 2000);
        } else {
            timerObject.setYear(batteryControlTimer.getYear());
        }
        timerObject.setDay(batteryControlTimer.getDay());
        timerObject.setHour(batteryControlTimer.getHour());
        timerObject.setMinute(batteryControlTimer.getMinute());
        return timerObject;
    }

    public static Calendar getCorrectCalendarFromDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(1) % 2000, calendar.get(2), calendar.get(5), calendar.get(11), calendar.get(12), 0);
        return calendar;
    }

    public static Date getCorrectDateFromTimer(TimerObject timerObject) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(timerObject.getYear(), timerObject.getMonth() - 1, timerObject.getDay(), timerObject.getHour(), timerObject.getMinute(), 0);
        return calendar.getTime();
    }

    public Calendar getCalendarFromTimer(BatteryControlTimer batteryControlTimer) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, batteryControlTimer.year);
        calendar.set(2, batteryControlTimer.month - 1);
        calendar.set(5, batteryControlTimer.day);
        calendar.set(11, batteryControlTimer.hour);
        calendar.set(12, batteryControlTimer.minute);
        calendar.set(13, 0);
        return calendar;
    }

    public Calendar getNowInOneYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(((DateMetric)this.application.getFrameworkAccess().getSysApp().getClock().getMetric()).getDate());
        calendar.add(1, 1);
        return calendar;
    }

    public Object[] getNextChargeTimerAsArray(ArrayList arrayList, ArrayList arrayList2) {
        boolean[] blArray = new boolean[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            if (arrayList.get(i2) == null) continue;
            blArray[i2] = ((ChoiceModelApp)arrayList.get(i2)).getValue() == 1;
        }
        ArrayList arrayList3 = new ArrayList();
        for (int i3 = 0; i3 < arrayList2.size(); ++i3) {
            if (!blArray[i3]) continue;
            arrayList3.add(arrayList2.get(i3));
        }
        return this.getEarliestDate(arrayList3);
    }

    public Object[] getEarliestDate(List list) {
        Date date = new Date();
        Date date2 = new Date();
        Object[] objectArray = new Object[2];
        int n = -1;
        for (int i2 = 0; i2 < list.size(); ++i2) {
            date = ((DateMetric)((MetricsModelApp)list.get(0)).getMetric()).getDate();
            if (!date.before(date2)) continue;
            date2 = date;
            n = i2;
        }
        objectArray[0] = new Integer(n);
        objectArray[1] = date2;
        return objectArray;
    }

    public Date getTomorrowCurrentTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(((DateMetric)this.application.getFrameworkAccess().getSysApp().getClock().getMetric()).getDate());
        calendar.add(5, 1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date);
        calendar.set(11, calendar2.get(11));
        calendar.set(12, calendar2.get(12));
        return calendar.getTime();
    }

    public Date getNextTimeOccurrenceFromNow(Date date, String string) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(((DateMetric)this.application.getFrameworkAccess().getSysApp().getClock().getMetric()).getDate());
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date);
        calendar.set(11, calendar2.get(11));
        calendar.set(12, calendar2.get(12));
        if (this.isDateInThePast(calendar.getTime(), string)) {
            calendar.add(5, 1);
        }
        return calendar.getTime();
    }
}

