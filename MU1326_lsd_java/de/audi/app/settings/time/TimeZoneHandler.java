/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.time;

import de.audi.app.settings.SettingsEnv;
import de.audi.app.settings.time.TimeHandler;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.cartimeunitslanguage.ClockViewOptions;

public class TimeZoneHandler
implements ListListener,
ButtonListener {
    private boolean timeZoneAutomaticAvailible;
    private boolean timeZoneautomaticActive = true;
    private static final int RANGE_TIMEZONE_MAX;
    private static final int RANGE_TIMEZONE_MIN;
    private static final int RANGE_TIMEZONE_GMT;
    private final float[] timeZoneOffsetHours;
    private volatile int currentTimeZone = 18;
    private volatile int selectedTimeZone = 18;
    private final SettingsEnv env;
    private final TimeHandler timeHandler;
    private ListModelApp timeZoneList;
    private final LogChannel lc;
    private ClockViewOptions currClockViewOpts;

    public TimeZoneHandler(SettingsEnv settingsEnv, TimeHandler timeHandler) {
        this.env = settingsEnv;
        this.timeZoneOffsetHours = this.env.getTimeZoneOffsets();
        this.lc = settingsEnv.getFw().getLogChannel("App.Settings.Clock");
        this.timeHandler = timeHandler;
        this.getTimeZoneMenuEntryChoice().setValue(1);
        this.timeZoneList = settingsEnv.getListModel(-1731653632);
        this.timeZoneList.setMaxColumns(3);
        this.timeZoneList.setMaxRows(33);
        this.timeZoneList.setListListener(this);
        for (int i2 = 0; i2 <= 32; ++i2) {
            ListCell[] listCellArray = new ListCell[3];
            listCellArray[0] = IntegerListCell.create(i2);
            listCellArray[1] = IntegerListCell.create(i2);
            this.timeZoneList.addRow(listCellArray);
        }
        this.timeZoneList.setSelected(this.currentTimeZone);
        settingsEnv.getChoiceModel(-1765208064).setValue(this.currentTimeZone);
        settingsEnv.getChoiceModel(835325952).setValue(this.currentTimeZone);
        settingsEnv.getListModel(-1731653632).setCell(this.currentTimeZone, 2, IntegerListCell.create(1));
        this.timeZoneautomaticActive = settingsEnv.getFw().getStorageMgr().getBoolean(1011, 31, true);
        settingsEnv.getChoiceModel(-1798762496).setValue(this.timeZoneautomaticActive ? 1 : 0);
        settingsEnv.getButtonModel(-1698099200).setButtonListener(this);
        settingsEnv.getChoiceModel(-775352320).setValue(1);
        settingsEnv.getChoiceModel(-808906752).setValue(1);
    }

    private ChoiceModelApp getTimeZoneMenuEntryChoice() {
        return this.env.getChoiceModel(-1748430848);
    }

    public void setVisibility(ClockViewOptions clockViewOptions) {
        this.lc.log(-2137614336, "TimeZoneHandler.setVisibility");
        this.currClockViewOpts = clockViewOptions;
        if (this.timeHandler.getAutomaticModeHandler().isAutomaticModeAvailible() && clockViewOptions.timeZone != null && clockViewOptions.timeZone.state != 0) {
            if (clockViewOptions.timeZone.state == 2) {
                this.timeZoneAutomaticAvailible = true;
                this.env.getChoiceModel(-775352320).setValue(0);
            } else {
                this.timeZoneAutomaticAvailible = false;
                this.env.getChoiceModel(-775352320).setValue(2);
            }
        } else {
            this.timeZoneAutomaticAvailible = false;
            this.env.getChoiceModel(-775352320).setValue(1);
        }
        if (clockViewOptions.timeZone != null && clockViewOptions.timeZone.state != 0) {
            if (clockViewOptions.timeZone.state == 2) {
                if (!this.timeZoneAutomaticAvailible || this.timeZoneAutomaticAvailible && !this.isTimeZoneAutomaticActive()) {
                    this.getTimeZoneMenuEntryChoice().setValue(0);
                } else {
                    this.getTimeZoneMenuEntryChoice().setValue(2);
                }
            } else {
                this.getTimeZoneMenuEntryChoice().setValue(2);
            }
        } else {
            this.getTimeZoneMenuEntryChoice().setValue(1);
        }
    }

    private boolean isTimeZoneAutomaticActive() {
        return this.timeZoneautomaticActive;
    }

    public void setTimeZoneAutomaticCheckBox(boolean bl) {
        this.lc.log(-2137614336, "TimeZoneHandler.setTimeZoneAutomaticCheckBox(%1)", bl);
        this.timeZoneautomaticActive = bl;
        this.env.getChoiceModel(-1798762496).setValue(this.timeZoneautomaticActive ? 1 : 0);
        this.env.getFw().getStorageMgr().setBoolean(1011, 31, this.timeZoneautomaticActive);
        if (this.timeZoneautomaticActive) {
            this.disableTimeZoneMenuEntry();
            this.env.getNavigationListener().activateTimeZoneAutomatic();
        } else {
            this.activateTimeZoneMenuEntry();
        }
    }

    public void disableTimeZoneMenuEntry() {
        this.lc.log(-2137614336, "TimeZoneHandler.disableTimeZoneMenuEntry()");
        if (this.getTimeZoneMenuEntryChoice().getValue() != 1) {
            this.getTimeZoneMenuEntryChoice().setValue(2);
        }
    }

    public void activateTimeZoneMenuEntry() {
        this.lc.log(-2137614336, "TimeZoneHandler.activateTimeZoneMenuEntry()");
        if (this.getTimeZoneMenuEntryChoice().getValue() != 1 && !this.timeZoneautomaticActive) {
            this.getTimeZoneMenuEntryChoice().setValue(0);
        }
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.lc.log(-2137614336, "TimeZoneHandler.itemSelected row=%1", (long)n2);
        if (n2 > this.timeZoneOffsetHours.length) {
            this.lc.log(10000, "TimeZoneHandler.itemSelected row=%1 > MAX", (long)n2);
            return;
        }
        this.selectedTimeZone = n2;
        if (this.env.getChoiceModel(-825683968).getValue() != 0) {
            if (this.env.getChoiceModel(-1865871360).getValue() == 1 && !this.isSummerTimeAutomaticAvailable(n2) && this.currClockViewOpts.getClockConfig().getDayLightSavingMode() != 0) {
                this.env.getChoiceModel(-1681321984).setValue(1);
            } else {
                this.env.getChoiceModel(-1681321984).setValue(0);
                this.env.getDSIManager().getDSI().setClockTimeZoneOffset(this.timeZoneOffsetHours[n2]);
            }
        } else {
            this.env.getChoiceModel(-1681321984).setValue(0);
            this.env.getDSIManager().getDSI().setClockTimeZoneOffset(this.timeZoneOffsetHours[n2]);
        }
        this.env.getListModel(-1731653632).fireEvent(0);
    }

    @Override
    public void itemReleased(int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
        this.env.getChoiceModel(835325952).setValue(n2);
    }

    public void updateClockTimeZoneOffset(float f2) {
        this.lc.log(-2137614336, "TimeZoneHandler.updateClockTimeZoneOffset(%1)", (Object)Float.toString(f2));
        int n = this.findTimeZoneIndex(f2);
        if (n == -1) {
            this.lc.log(10000, "TimeZoneHandler.updateClockTimeZoneOffset wrong clockTimeZoneOffset=%1", (Object)Float.toString(f2));
            return;
        }
        this.env.getListModel(-1731653632).setCell(this.currentTimeZone, 2, IntegerListCell.create(0));
        this.env.getListModel(-1731653632).setCell(n, 2, IntegerListCell.create(1));
        this.currentTimeZone = n;
        this.timeZoneList.setSelected(n);
        this.env.getChoiceModel(-1765208064).setValue(n);
        this.env.getChoiceModel(835325952).setValue(n);
        if (this.isSummerTimeAutomaticAvailable(this.currentTimeZone)) {
            if (this.env.getChoiceModel(-808906752).getValue() == 2) {
                this.env.getChoiceModel(-808906752).setValue(0);
            }
        } else if (this.env.getChoiceModel(-808906752).getValue() == 0) {
            this.env.getChoiceModel(-808906752).setValue(2);
        }
    }

    public boolean isSummerTimeAutomaticAvailable(int n) {
        if (this.timeHandler.getAutomaticModeHandler().isAutomaticModeAvailible()) {
            return true;
        }
        boolean bl = false;
        if (this.currClockViewOpts != null && this.currClockViewOpts.getDayLightSaving() != null && this.currClockViewOpts.getDayLightSaving().getState() != 0) {
            if (this.currClockViewOpts.getClockConfig() != null && this.currClockViewOpts.getClockConfig().getDayLightSavingMode() == 2 && this.timeZoneOffsetHours[n] >= 0.0f && this.timeZoneOffsetHours[n] <= 2.0f) {
                bl = true;
            } else if (this.currClockViewOpts.getClockConfig() != null && this.currClockViewOpts.getClockConfig().getDayLightSavingMode() == 3 && this.timeZoneOffsetHours[n] <= 32960 && this.timeZoneOffsetHours[n] >= 4289) {
                bl = true;
            }
        }
        return bl;
    }

    private int findTimeZoneIndex(float f2) {
        int n = -1;
        for (int i2 = 0; i2 < this.timeZoneOffsetHours.length; ++i2) {
            n = i2;
            if (this.timeZoneOffsetHours[i2] == f2) break;
        }
        return n;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.env.getDSIManager().getDSI().setClockTimeZoneOffset(this.timeZoneOffsetHours[this.selectedTimeZone]);
        this.env.getDSIManager().getDSI().setClockDayLightSaving(false);
        this.env.getButtonModel(-1698099200).fireEvent(0);
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    public int getCurrenttimeZone() {
        return this.currentTimeZone;
    }
}

