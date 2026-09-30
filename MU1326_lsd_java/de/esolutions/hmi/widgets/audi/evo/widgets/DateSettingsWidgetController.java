/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.model.MetricsModel;
import de.audi.atip.metrics.AbstractMetrics;
import de.audi.atip.metrics.DateMetric;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.LineElement;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractTimeDateController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ITimeDateSetttingsRenderer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class DateSettingsWidgetController
extends AbstractTimeDateController {
    public static final byte MAXDAYS30 = 1;
    public static final byte MAXDAYS365 = 2;
    public static final byte MAXDAYS6 = 6;
    public static byte cursorPosYear = (byte)2;
    public static byte cursorPosMonth = 1;
    public static byte cursorPosDay = 0;
    private static final int MIN_YEAR = 2000;
    private static final int MAX_YEAR = 2254;
    private static final int CLOCK_METRICS = 55;
    private static final String[] separators = new String[]{".", "/", "-"};
    protected ITimeDateSetttingsRenderer renderer;
    private int format = 20;
    private int maxDaysInFuture = -1;
    private int dayOfMonth;
    private int month;
    private int year;
    private int dayOfWeek;
    private Calendar localReference;
    private int daysIncreased = 0;
    private int[] textIds;
    private static Calendar referenceCalendar = new GregorianCalendar();
    private List cached_LineDescription;
    private int cached_dayOfWeek;
    private int cached_dayOfMonth;
    private int cached_month;
    private int cached_year;
    private int cached_format;
    private int[] labelArrangement = new int[5];
    private static final int ERROR = -1;
    private static final int LTR = 0;
    private static final int RTL = 1;
    private int currentDirection = -1;
    private int lastDirection = -1;
    private boolean preventPastDateTime = false;

    private static int calculateDistanceInDays(Calendar calendar, Calendar calendar2) {
        int n;
        int n2 = 1;
        if (calendar2.before(calendar)) {
            Calendar calendar3 = calendar;
            calendar = calendar2;
            calendar2 = calendar3;
            n2 = -1;
        }
        int n3 = 0;
        int n4 = calendar.get(5);
        int n5 = calendar.get(2);
        int n6 = calendar2.get(5);
        int n7 = calendar2.get(2);
        int n8 = calendar2.get(1);
        for (n = calendar.get(1); n < n8; ++n) {
            if (n % 4 == 0) {
                if (n % 100 == 0 && n % 400 != 0) {
                    n3 += 365;
                    continue;
                }
                n3 += 366;
                continue;
            }
            n3 += 365;
        }
        if (n5 < n7) {
            while (n5 < n7) {
                n3 += DateSettingsWidgetController.getNumberOfDaysInMonth(n5, n);
                ++n5;
            }
        } else {
            while (n5 > n7) {
                n3 -= DateSettingsWidgetController.getNumberOfDaysInMonth(n5 - 1, n);
                --n5;
            }
        }
        if (n4 < n6) {
            while (n4 < n6) {
                ++n3;
                ++n4;
            }
        } else {
            while (n4 > n6) {
                --n3;
                --n4;
            }
        }
        return n2 * n3;
    }

    public void connected(InitializationContext initializationContext) {
        this.updateReferenceCalendar();
        if (!this.isConnected()) {
            super.connected(initializationContext);
            this.cached_LineDescription = null;
            menuItemLogCh.log(10000000, "DateSettingsWidgetController#connected %1", (long)this.hashCode());
            if (this.model instanceof MetricsModel) {
                DateMetric dateMetric = (DateMetric)((MetricsModel)this.model).getMetric();
                if (dateMetric != null) {
                    Calendar calendar = this.getCalendar();
                    this.setFormat(dateMetric.getDateFormat());
                    this.readDataFromModel(this.model, calendar);
                } else {
                    menuItemLogCh.log(10000, "DateSettingsWidgetController#connected Metric contained in the model is null.");
                }
            }
            this.readCalendarIntoLocalMemory();
        }
        this.setArrangement();
    }

    private void setArrangement() {
        if (this.terminal.getFramework().getLanguageMgr().isLeftToRightOrientation()) {
            this.labelArrangement[0] = 0;
            this.labelArrangement[1] = 1;
            this.labelArrangement[2] = 2;
            this.labelArrangement[3] = 3;
            this.labelArrangement[4] = 4;
            cursorPosYear = (byte)2;
            cursorPosMonth = 1;
            cursorPosDay = 0;
            this.currentDirection = 0;
        } else {
            this.labelArrangement[4] = 0;
            this.labelArrangement[3] = 1;
            this.labelArrangement[2] = 2;
            this.labelArrangement[1] = 3;
            this.labelArrangement[0] = 4;
            cursorPosYear = 0;
            cursorPosMonth = 1;
            cursorPosDay = (byte)2;
            this.currentDirection = 1;
        }
    }

    protected void enterEditableMode() {
        super.enterEditableMode();
        this.isInEditableMode = true;
        this.setHighlighted(true);
        this.cursorPosition = cursorPosDay;
        this.switchOFFParentMenuCursor();
        if (this.getModeMaxDaysInFuture() > 0) {
            this.updateReferenceCalendar();
            this.daysIncreased = DateSettingsWidgetController.calculateDistanceInDays(referenceCalendar, this.getCalendar());
            menuItemLogCh.log(10000000, "DateSettingsWidgetController#enterEditableMode time in reference calendar is %1, days increased = %2", (Object)referenceCalendar.getTime(), (long)this.daysIncreased);
            if (this.daysIncreased < 0 || this.daysIncreased > this.getMaxDaysInFuture()) {
                menuItemLogCh.log(100000, "DateSettingsWidgetController#enterEditableMode Date seems to be not valid.");
            }
        }
        this.readCalendarIntoLocalMemory();
    }

    protected void exitEditableMode() {
        this.isInEditableMode = false;
        this.cursorPosition = -1;
        this.setHighlighted(false);
        this.switchONParentMenuCursor();
        this.writeLocalMemoryIntoCalendar();
        if (this.isDateInPast()) {
            this.updateReferenceCalendar();
            this.getCalendar().setTime(referenceCalendar.getTime());
        }
        this.writeDataToModel();
        if (this.model instanceof MetricsModel) {
            ((MetricsModel)this.model).setMetric(((MetricsModel)this.model).getMetric());
        }
    }

    protected void exitEditableModeWithoutSavings() {
        this.isInEditableMode = false;
        this.cursorPosition = -1;
        this.setHighlighted(false);
        this.switchONParentMenuCursor();
        this.readDataFromModel(this.getModel(), this.getCalendar());
        this.readCalendarIntoLocalMemory();
    }

    public int getCursorIndex() {
        int n = this.getFormat();
        int n2 = this.getCursorPos();
        if (n2 == cursorPosDay) {
            switch (n) {
                case 23: 
                case 24: 
                case 25: {
                    n2 = cursorPosMonth;
                    break;
                }
                case 26: 
                case 27: 
                case 28: {
                    n2 = cursorPosYear;
                    break;
                }
            }
        } else if (n2 == cursorPosMonth) {
            switch (n) {
                case 23: 
                case 24: 
                case 25: {
                    n2 = cursorPosDay;
                    break;
                }
            }
        } else if (n2 == cursorPosYear) {
            switch (n) {
                case 26: 
                case 27: 
                case 28: {
                    n2 = cursorPosDay;
                    break;
                }
            }
        }
        return n2;
    }

    public int getFormat() {
        if (this.format == -1) {
            menuItemLogCh.log(10000, "DateSettingsWidgetController#getFormat No format has been set.");
        }
        return this.format;
    }

    public List getLineDescription() {
        boolean bl;
        int n = this.dayOfWeek;
        int n2 = this.dayOfMonth;
        int n3 = this.month;
        int n4 = this.year;
        int n5 = this.getFormat();
        boolean bl2 = n != this.cached_dayOfWeek;
        boolean bl3 = n2 != this.cached_dayOfMonth;
        boolean bl4 = n3 != this.cached_month;
        boolean bl5 = n4 != this.cached_year;
        boolean bl6 = n5 != this.cached_format;
        boolean bl7 = bl = this.lastDirection != this.currentDirection;
        if (bl2 || bl3 || bl4 || bl5 || bl6 || bl || this.cached_LineDescription == null) {
            String string = this.getSeparatorString();
            ArrayList arrayList = new ArrayList(6);
            if (this.isShowDayOfWeek()) {
                arrayList.add(new LineElement(this.getText(this.getTextID(n))));
            }
            LineElement lineElement = new LineElement(DateSettingsWidgetController.appendOneLeadingZero(n2) + n2, true);
            LineElement lineElement2 = new LineElement(DateSettingsWidgetController.appendOneLeadingZero(n3) + n3, true);
            LineElement lineElement3 = new LineElement("" + n4, true);
            switch (n5) {
                case 20: 
                case 21: 
                case 22: {
                    arrayList.add(lineElement);
                    arrayList.add(new LineElement(string));
                    arrayList.add(lineElement2);
                    arrayList.add(new LineElement(string));
                    arrayList.add(lineElement3);
                    break;
                }
                case 23: 
                case 24: 
                case 25: {
                    arrayList.add(lineElement2);
                    arrayList.add(new LineElement(string));
                    arrayList.add(lineElement);
                    arrayList.add(new LineElement(string));
                    arrayList.add(lineElement3);
                    break;
                }
                case 26: 
                case 27: 
                case 28: {
                    arrayList.add(lineElement3);
                    arrayList.add(new LineElement(string));
                    arrayList.add(lineElement2);
                    arrayList.add(new LineElement(string));
                    arrayList.add(lineElement);
                    break;
                }
                default: {
                    menuItemLogCh.log(10000, "DateSettingsWidgetController#getLineDescription No case defined for format = %1.", (long)this.getFormat());
                }
            }
            arrayList = DateSettingsWidgetController.permutate(arrayList, this.labelArrangement);
            this.lastDirection = this.currentDirection;
            this.cached_LineDescription = arrayList;
            this.cached_dayOfMonth = n2;
            this.cached_dayOfWeek = n;
            this.cached_month = n3;
            this.cached_year = n4;
            this.cached_format = n5;
            return arrayList;
        }
        return this.cached_LineDescription;
    }

    public int getMaxDaysInFuture() {
        switch (this.maxDaysInFuture) {
            case 6: {
                return 6;
            }
            case 1: {
                return 30;
            }
            case 2: {
                return 365;
            }
        }
        menuItemLogCh.log(10000, "DateSettingsWidgetController#getMaxDaysInFuture No case defined for maxDaysInFuture = %1.", (long)this.maxDaysInFuture);
        return 0;
    }

    public int getModeMaxDaysInFuture() {
        return this.maxDaysInFuture;
    }

    private static int getNumberOfDaysInMonth(int n, int n2) {
        int n3 = 0;
        switch (n) {
            case 0: 
            case 2: 
            case 4: 
            case 6: 
            case 7: 
            case 9: 
            case 11: {
                n3 = 31;
                break;
            }
            case 1: {
                if (n2 % 4 == 0) {
                    n3 = 29;
                    break;
                }
                n3 = 28;
                break;
            }
            case 3: 
            case 5: 
            case 8: 
            case 10: {
                n3 = 30;
                break;
            }
            default: {
                menuItemLogCh.log(10000, "DateSettingsWidgetController#getNumberOfDaysInMonth No case defined for month = %1.", (long)n);
            }
        }
        return n3;
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }

    public static Calendar getReferenceCalendar() {
        return referenceCalendar;
    }

    public int getTextID(int n) {
        if (this.textIds != null && n >= 0 && n < this.textIds.length) {
            return this.textIds[n];
        }
        return -1;
    }

    private boolean isDateInPast() {
        return this.isDateInPast(this.getCalendar());
    }

    public boolean isDateInPast(Calendar calendar) {
        if (this.getMaxDaysInFuture() > 0) {
            this.updateReferenceCalendar();
            return calendar.before(referenceCalendar);
        }
        return false;
    }

    public boolean isDateValid() {
        if (this.getModeMaxDaysInFuture() > 0) {
            this.updateReferenceCalendar();
            this.daysIncreased = DateSettingsWidgetController.calculateDistanceInDays(referenceCalendar, this.getCalendar());
            if (this.daysIncreased < 0 || this.daysIncreased > this.getMaxDaysInFuture()) {
                return false;
            }
        }
        return true;
    }

    public boolean isInEditableMode() {
        return this.isInEditableMode;
    }

    public boolean isShowDayOfWeek() {
        switch (this.getFormat()) {
            case 20: 
            case 23: 
            case 26: {
                return false;
            }
            case 21: 
            case 24: 
            case 27: {
                return true;
            }
        }
        menuItemLogCh.log(10000, "DateSettingsWidget#isShowDayOfWeek Format %1 not supported.", (long)this.getFormat());
        return false;
    }

    public void keyReleased(KeyEvent keyEvent) {
        menuItemLogCh.log(10000000, "DateSettingsWidget#keyReleased KeyCode = %1", (long)keyEvent.getKeyCode());
        if (this.dds_pressed && keyEvent.getKeyCode() == 17) {
            if (this.getCurrentVisState() == 1) {
                this.enterEditableMode();
            } else if (this.getCurrentVisState() == 3) {
                if (this.cursorPosition == cursorPosDay) {
                    switch (this.getModeMaxDaysInFuture()) {
                        case -1: 
                        case 2: {
                            this.cursorPosition = cursorPosMonth;
                            break;
                        }
                        case 1: 
                        case 6: {
                            this.exitEditableMode();
                            break;
                        }
                        default: {
                            menuItemLogCh.log(10000, "DateSettingsWidgetController#keyReleased No case defined for modeMaxDaysInFuture = %1.", (long)this.getModeMaxDaysInFuture());
                            break;
                        }
                    }
                } else if (this.cursorPosition == cursorPosMonth) {
                    switch (this.getModeMaxDaysInFuture()) {
                        case -1: {
                            this.cursorPosition = cursorPosYear;
                            break;
                        }
                        case 2: {
                            this.exitEditableMode();
                            break;
                        }
                        default: {
                            menuItemLogCh.log(10000, "DateSettingsWidgetController#keyReleased No case defined for modeMaxDaysInFuture = %1.", (long)this.getModeMaxDaysInFuture());
                            break;
                        }
                    }
                } else if (this.cursorPosition == cursorPosYear) {
                    this.exitEditableMode();
                } else {
                    menuItemLogCh.log(10000, "DateSettingsWidgetController#keyReleased No case defined for cursorPosition = %1.", (long)this.cursorPosition);
                }
            }
            this.setCompositesDirty(true);
            this.dds_pressed = false;
            keyEvent.consume();
        } else if (keyEvent.getKeyCode() == 15 && this.isInEditableMode()) {
            this.exitEditableModeWithoutSavings();
            this.setCompositesDirty(true);
            keyEvent.consume();
        }
    }

    /*
     * Unable to fully structure code
     */
    public void keyTurned1(WheelButtonEvent var1_1) {
        block17: {
            block19: {
                block20: {
                    block18: {
                        if (this.getCurrentVisState() != 3) break block17;
                        if (this.cursorPosition != DateSettingsWidgetController.cursorPosDay) break block18;
                        var3_3 = this.getModeMaxDaysInFuture();
                        if (var3_3 == -1) {
                            this.dayOfMonth = this.roll(this.dayOfMonth, var2_2, 31);
                        } else {
                            var4_5 = -1;
                            switch (var3_3) {
                                case 2: {
                                    var4_5 = 365;
                                    break;
                                }
                                case 1: {
                                    var4_5 = 30;
                                    break;
                                }
                                case 6: {
                                    var4_5 = 6;
                                    break;
                                }
                                default: {
                                    DateSettingsWidgetController.menuItemLogCh.log(10000, "DateSettingsWidgetController#keyTurned modeMaxDaysInFuture %1 is not valid.", (long)this.maxDaysInFuture);
                                }
                            }
                            if (var4_5 != -1 && (var2_2 = var2_2 > 0 ? Math.min(var4_5 - this.daysIncreased, var2_2) : Math.max(-this.daysIncreased, var2_2)) != 0) {
                                this.getCalendar().add(5, var2_2);
                                this.daysIncreased += var2_2;
                                if (this.isDateInPast()) {
                                    this.getCalendar().add(5, 1);
                                    ++this.daysIncreased;
                                }
                            }
                            this.readCalendarIntoLocalMemory();
                        }
                        break block19;
                    }
                    if (this.cursorPosition != DateSettingsWidgetController.cursorPosMonth) break block20;
                    switch (this.getModeMaxDaysInFuture()) {
                        case -1: {
                            this.month = this.roll(this.month, var2_2, 12);
                            break;
                        }
                        case 2: {
                            var3_4 = this.getCalendar();
                            if (var2_2 <= 0) ** GOTO lbl49
                            for (var2_2 = var1_1.getClickCount(); var2_2 > 0; --var2_2) {
                                var4_6 = DateSettingsWidgetController.getNumberOfDaysInMonth(var3_4.get(2), var3_4.get(1));
                                var5_8 = Math.min(365 - this.daysIncreased, var4_6);
                                if (var5_8 >= var4_6) ** GOTO lbl45
                                var3_4.add(5, var5_8);
                                this.daysIncreased += var5_8;
                                ** GOTO lbl62
lbl45:
                                // 1 sources

                                var3_4.add(2, 1);
                                this.daysIncreased += var5_8;
                            }
                            ** GOTO lbl62
lbl49:
                            // 2 sources

                            while (var2_2 < 0) {
                                var3_4.add(2, -1);
                                var4_7 = DateSettingsWidgetController.getNumberOfDaysInMonth(var3_4.get(2), var3_4.get(1));
                                var5_9 = Math.max(-this.daysIncreased, -var4_7);
                                var3_4.add(2, 1);
                                if (var5_9 <= -var4_7) ** GOTO lbl58
                                var3_4.add(5, var5_9);
                                this.daysIncreased += var5_9;
                                break;
lbl58:
                                // 1 sources

                                var3_4.add(2, -1);
                                this.daysIncreased += var5_9;
                                ++var2_2;
                            }
lbl62:
                            // 4 sources

                            this.readCalendarIntoLocalMemory();
                            break;
                        }
                        default: {
                            DateSettingsWidgetController.menuItemLogCh.log(10000, "DateSettingsWidgetController#keyReleased No case defined for modeMaxDaysInFuture = %1.", (long)this.getModeMaxDaysInFuture());
                            break;
                        }
                    }
                    break block19;
                }
                if (this.cursorPosition == DateSettingsWidgetController.cursorPosYear) {
                    var2_2 = Math.max(2000 - this.year, var2_2);
                    this.year += var2_2;
                    this.year = Math.min(2254, this.year);
                } else {
                    DateSettingsWidgetController.menuItemLogCh.log(10000, "DateSettingsWidgetController#keyTurned No case defined for cursorPosition = %1.", (long)this.cursorPosition);
                }
            }
            this.setCompositesDirty(true);
            var1_1.consume();
        }
    }

    public int mapFormatToArrayIndex() {
        return (this.getFormat() - 20) / 3;
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        menuItemLogCh.log(10000000, "DateSettingsWidgetController#processModelUpdateEvent type = %1", (long)modelUpdateEvent.getUpdateType());
        if (modelUpdateEvent.getModelType() == 9) {
            switch (modelUpdateEvent.getUpdateType()) {
                case 1: 
                case 14: {
                    if (this.getCursorPos() != -1) break;
                    if (this.preventPastDateTime) {
                        this.preventPastDateTime(this.model);
                    }
                    this.readDataFromModel(this.model, this.getCalendar());
                    this.readCalendarIntoLocalMemory();
                    this.setCompositesDirty(true);
                    break;
                }
                case 13: {
                    DateMetric dateMetric = (DateMetric)((MetricsModel)this.model).getMetric();
                    this.setFormat(dateMetric.getDateFormat());
                    this.setCompositesDirty(true);
                    this.invalidateParentLayout();
                    break;
                }
            }
        }
    }

    private void preventPastDateTime(Object object) {
        Date date;
        DateMetric dateMetric;
        Date date2;
        int n;
        MetricsModel metricsModel;
        if (object instanceof MetricsModel && (metricsModel = (MetricsModel)object).getMetric() instanceof DateMetric && (n = (date2 = (dateMetric = (DateMetric)metricsModel.getMetric()).getDate()).compareTo(date = referenceCalendar.getTime())) < 0) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(date2.getTime());
            calendar.add(12, 1);
            boolean bl = calendar.getTime().before(date);
            calendar.setTimeInMillis(date2.getTime());
            if (bl) {
                calendar.add(5, 1);
            }
            dateMetric.setDate(calendar.getTimeInMillis());
        }
    }

    private void readCalendarIntoLocalMemory() {
        Calendar calendar = this.getCalendar();
        this.dayOfMonth = calendar.get(5);
        this.month = calendar.get(2) + 1;
        this.year = calendar.get(1);
        this.dayOfWeek = calendar.get(7) - 1;
    }

    private int roll(int n, int n2, int n3) {
        while (n2 < 0) {
            n2 += n3;
        }
        while (n2 >= n3) {
            n2 -= n3;
        }
        n += n2;
        while (n > n3) {
            n -= n3;
        }
        return n;
    }

    private void setFormat(int n) {
        this.format = n;
    }

    public void setMaxDaysInFuture(int n) {
        if (n == -1 || n == 1 || n == 2 || n == 6) {
            if (n != -1) {
                this.preventPastDateTime = true;
            }
            this.maxDaysInFuture = n;
        } else {
            menuItemLogCh.log(10000, "DateSettingsWidget#setMaxDaysInFuture Unknown format: %1", (long)n);
        }
    }

    public void setRenderer(ITimeDateSetttingsRenderer iTimeDateSetttingsRenderer) {
        this.renderer = iTimeDateSetttingsRenderer;
        if (iTimeDateSetttingsRenderer != null) {
            iTimeDateSetttingsRenderer.setClipping(false);
        }
    }

    public void setTextIds(int[] nArray) {
        this.textIds = nArray;
    }

    private String getSeparatorString() {
        if (this.getFormat() != -1) {
            return separators[this.mapFormatToArrayIndex()];
        }
        return "";
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void updateReferenceCalendar() {
        AbstractMetrics abstractMetrics;
        HMIModel hMIModel = hmiService.getModel(55);
        if (hMIModel instanceof MetricsModel && (abstractMetrics = ((MetricsModel)hMIModel).getMetric()) instanceof DateMetric) {
            Calendar calendar = referenceCalendar;
            synchronized (calendar) {
                referenceCalendar.setTime(((DateMetric)abstractMetrics).getDate());
            }
            menuItemLogCh.log(10000000, "DateSettingsWidgetController#connected Initialize reference calendar with date %1", (Object)referenceCalendar.getTime());
        }
    }

    private void writeLocalMemoryIntoCalendar() {
        if (this.localReference == null) {
            this.localReference = Calendar.getInstance();
        }
        Calendar calendar = this.localReference;
        calendar.set(this.year, this.month - 1, this.dayOfMonth);
        int n = calendar.get(5);
        int n2 = calendar.get(2) + 1;
        int n3 = calendar.get(1);
        if (this.dayOfMonth == n && this.month == n2 && this.year == n3) {
            this.getCalendar().set(this.year, this.month - 1, this.dayOfMonth);
        } else {
            this.readCalendarIntoLocalMemory();
        }
    }
}

