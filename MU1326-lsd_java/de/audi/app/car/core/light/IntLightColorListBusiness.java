/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.light;

import de.audi.app.car.core.light.BaseListModelWatcherTimer;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.carlight.DSICarLight;
import org.dsi.ifc.carlight.IntLightRGBColorListRA0;
import org.dsi.ifc.carlight.IntLightRGBValues;

public class IntLightColorListBusiness
implements BaseListModelListener {
    private static final int MAX_COLUMNS;
    protected static final int COL_RED_VALUE;
    protected static final int COL_GREEN_VALUE;
    protected static final int COL_BLUE_VALUE;
    protected BaseListModel model;
    protected DSICarLight dsi;
    protected LogChannel logger;
    protected BaseListModelWatcherTimer watchedModelTimer;
    protected IntLightRGBValues selectedColor;

    public IntLightColorListBusiness(DSICarLight dSICarLight, LogChannel logChannel, BaseListModel baseListModel) {
        this.model = baseListModel;
        this.dsi = dSICarLight;
        this.logger = logChannel;
        this.init();
    }

    private void init() {
        this.model.setListener(this);
        this.watchedModelTimer = new BaseListModelWatcherTimer("IntLightColorRotaryValue", this.model, 0, this.logger);
    }

    public void deinit() {
        this.model.resetListener();
    }

    public void fillBaseListModels(IntLightRGBColorListRA0[] intLightRGBColorListRA0Array) {
        int n;
        if (intLightRGBColorListRA0Array == null || intLightRGBColorListRA0Array.length == 0) {
            this.logger.log(10000, "[IntLightColorListBusiness] color data array is null or data.length==0");
            return;
        }
        this.model.removeAll();
        for (n = 0; n < intLightRGBColorListRA0Array.length; ++n) {
            if (intLightRGBColorListRA0Array[n] != null) {
                IntLightRGBValues intLightRGBValues = intLightRGBColorListRA0Array[n].getValues();
                this.logger.log(1078071040, "[IntLightColorListBusiness] insert %1 at (%2|%3)", (Object)intLightRGBValues, (long)n, (long)intLightRGBColorListRA0Array[n].getPos());
                EvoListRow evoListRow = new EvoListRow(n, 3);
                evoListRow.setInteger(0, intLightRGBValues.getBaseColorRed());
                evoListRow.setInteger(1, intLightRGBValues.getBaseColorGreen());
                evoListRow.setInteger(2, intLightRGBValues.getBaseColorBlue());
                this.model.append(evoListRow);
                continue;
            }
            this.logger.log(-1601830656, new StringBuffer().append("[IntLightColorListBusiness] IntLightRGBColorListRA0 data[").append(n).append("] is null").toString());
        }
        if (this.selectedColor != null) {
            n = this.getColorDataIndex(this.selectedColor);
            if (n >= 0) {
                this.watchedModelTimer.setValidValue(n);
            } else {
                this.watchedModelTimer.setValidValue(0);
            }
        }
        this.model.setListener(this);
    }

    public int getColorDataIndex(IntLightRGBValues intLightRGBValues) {
        if (this.model != null) {
            int n = this.model.getLength();
            this.logger.log(-1601830656, "[IntLightColorListBusiness] getColorIndex of color=%1", (Object)intLightRGBValues);
            for (int i2 = 0; i2 < n; ++i2) {
                EvoListRow evoListRow = this.model.getRow(i2);
                if (evoListRow.getInteger(2) != intLightRGBValues.getBaseColorBlue() || evoListRow.getInteger(1) != intLightRGBValues.getBaseColorGreen() || evoListRow.getInteger(0) != intLightRGBValues.getBaseColorRed()) continue;
                return i2;
            }
        } else if (this.model == null) {
            this.logger.log(-1601830656, "Model for color is null");
        }
        return -1;
    }

    public void setSelectedColor(IntLightRGBValues intLightRGBValues) {
        this.selectedColor = intLightRGBValues;
    }

    public int getValidSelectedIndex() {
        return this.watchedModelTimer.getValidValue();
    }

    public void setValidSelectedIndex(int n) {
        if (n > -1) {
            this.watchedModelTimer.setValidValue(n);
        }
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logger.log(-1601830656, "[IntLightColorListBusiness] itemSelected: %1", (long)n2);
        this.model.fireEvent(0);
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        if (n == this.model.getID()) {
            int n5 = evoListRow.getInteger(0);
            int n6 = evoListRow.getInteger(1);
            int n7 = evoListRow.getInteger(2);
            IntLightRGBValues intLightRGBValues = new IntLightRGBValues(n5, n6, n7);
            this.logger.log(-2137614336, "[IntLightColorListBusiness] itemFocused: %1", (long)n2);
            if (n == 2066483456) {
                this.logger.log(-2137614336, "[IntLightColorListBusiness] itemFocused: dsi.setIntLightAmbientLightColor(%1)", (Object)intLightRGBValues);
                this.dsi.setIntLightAmbientLightColor(intLightRGBValues);
                if (n2 > -1) {
                    this.watchedModelTimer.setTempValue(n2);
                }
            } else if (n == 2083260672) {
                this.logger.log(-2137614336, "[IntLightColorListBusiness] itemFocused: dsi.setIntLightContourLightColor(%1)", (Object)intLightRGBValues);
                this.dsi.setIntLightContourLightColor(intLightRGBValues);
                if (n2 > -1) {
                    this.watchedModelTimer.setTempValue(n2);
                }
            } else {
                this.logger.log(-1601830656, "[IntLightColorListBusiness] itemFocused: model id is not contour light ord ambient light color model");
            }
        }
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public BaseListModelWatcherTimer getWatcherTimer() {
        return this.watchedModelTimer;
    }
}

