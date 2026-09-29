/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi.poiwarning;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.Distance;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.poi.poiwarning.IPoiWarningModelAccess;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.Category;

public abstract class PoiWarningModelAccess
implements IPoiWarningModelAccess {
    private final NavigationEnv env;
    private final LogChannel logChannel;
    private final IconHandler iconHandler;
    private final BaseListModelApp mainList;
    private final BaseListModelApp pPoiList;
    private Distance distance = new Distance(0.0f, 1);

    public PoiWarningModelAccess(NavigationEnv navigationEnv, IconHandler iconHandler) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getPoiApproachWarningLogChannel();
        this.iconHandler = iconHandler;
        this.mainList = navigationEnv.getBaseListModel(-333511168);
        this.pPoiList = navigationEnv.getBaseListModel(-299956736);
        navigationEnv.getMetricsModel(-65075712).setMetric(this.distance);
    }

    @Override
    public void updatePois(Category[] categoryArray, boolean bl) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "PoiWarningModelAccess#updatePois");
        }
        this.setPersonalCategoriesVisible(bl);
        if (null != categoryArray) {
            BaseListModelApp baseListModelApp = this.mainList.getEmptyCopy();
            BaseListModelApp baseListModelApp2 = this.pPoiList.getEmptyCopy();
            for (int i2 = 0; i2 < categoryArray.length; ++i2) {
                EvoListRow evoListRow = new EvoListRow(categoryArray[i2].getCategoryUid(), 3);
                int n = this.iconHandler.resolvePOIIconResourceID(categoryArray[i2].getIconIndex(), categoryArray[i2].getSubIconIndex());
                HMIResourceLocator hMIResourceLocator = new HMIResourceLocator(n);
                IconCell iconCell = new IconCell(hMIResourceLocator);
                evoListRow.setIconCell(0, iconCell);
                evoListRow.setText(1, categoryArray[i2].getDescription());
                evoListRow.setInteger(2, categoryArray[i2].isMonitored() ? 1 : 0);
                if (categoryArray[i2].isPersonal()) {
                    baseListModelApp2.append(evoListRow);
                    continue;
                }
                baseListModelApp.append(evoListRow);
            }
            this.mainList.update(baseListModelApp);
            if (bl) {
                this.pPoiList.update(baseListModelApp2);
            }
        } else if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "   --> Categories are NULL!");
        }
    }

    public boolean isMainPoiListEmpty() {
        return this.mainList == null || this.mainList.getLength() == 0;
    }

    @Override
    public void setPoiSelection(int n, boolean bl) {
        int n2;
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "PoiWarningModelAccess#setPoiSelection");
        }
        if ((n2 = this.mainList.getIndexForUniqueID(n)) == -1) {
            n2 = this.pPoiList.getIndexForUniqueID(n);
            if (this.logChannel.isDebug2()) {
                this.logChannel.log(14808325, "   --> rowIndex in PPOI List: %1", (long)n2);
            }
            EvoListRow evoListRow = this.pPoiList.getRow(n2);
            evoListRow.setInteger(2, bl ? 1 : 0);
            this.pPoiList.setRow(n2, evoListRow);
        } else {
            if (this.logChannel.isDebug2()) {
                this.logChannel.log(14808325, "   --> rowIndex in MAIN List: %1", (long)n2);
            }
            EvoListRow evoListRow = this.mainList.getRow(n2);
            evoListRow.setInteger(2, bl ? 1 : 0);
            this.mainList.setRow(n2, evoListRow);
        }
    }

    public void setCheckAllPoisSelected(boolean bl) {
        this.env.getChoiceModel(-702347776).setValue(bl ? 1 : 0);
    }

    @Override
    public void toggleApproachHint() {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "PoiWarningModelAccess#toggleApproachHint");
        }
        int n = this.env.getChoiceModel(-350288384).getValue();
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "   --> old Value: %1", (long)n);
        }
        if (n >= 1) {
            this.env.getChoiceModel(-350288384).setValue(0);
        } else {
            this.env.getChoiceModel(-350288384).setValue(1);
        }
    }

    @Override
    public void toggleSpeachHint() {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "PoiWarningModelAccess#toggleSpeachHint");
        }
        int n = this.env.getChoiceModel(-383842816).getValue();
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "   --> old Value: %1", (long)n);
        }
        if (n >= 1) {
            this.env.getChoiceModel(-383842816).setValue(0);
        } else {
            this.env.getChoiceModel(-383842816).setValue(1);
        }
    }

    @Override
    public void setSettings(int n, int n2) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "PoiWarningModelAccess#setSettings");
            this.logChannel.log(14808325, "   --> Set Approach Hint to: %1", (long)n);
            this.logChannel.log(14808325, "   --> Set Speach Hint to  : %1", (long)n2);
        }
        this.env.getChoiceModel(-350288384).setValue(n);
        this.env.getChoiceModel(-383842816).setValue(n2);
    }

    @Override
    public void setMaxSelectableCategories(int n) {
        String string = String.valueOf(n);
        this.env.getLabelModel(-132184576).setText(string);
    }

    @Override
    public void setPersonalCategoriesVisible(boolean bl) {
        if (bl) {
            this.env.getChoiceModel(-48298496).setValue(1);
        } else {
            this.env.getChoiceModel(-48298496).setValue(0);
        }
    }

    public String getPoiFallbackText() {
        return this.env.getTranslatedText(47, "POI");
    }

    @Override
    public void setPoiApproachValues(String string, float f2, int n, int n2) {
        if (this.logChannel.isDebug()) {
            this.logChannel.log(-2137614336, "PoiWarningModelAccess#setPoiApproachValues( %1, %2 m, %3, %4 )", (Object)string, (Object)Float.toString(f2), (Object)Util.directionToArrow(n), (long)n2);
        }
        this.distance.setValue(f2 / 31300);
        this.env.getLabelModel(-81852928).setText(string);
        this.env.getMetricsModel(-65075712).setMetric(this.distance);
        this.env.getLabelModel(-517995008).setText(this.distance.formatByMode(1));
        this.env.getChoiceModel(-31521280).setValue(n);
        this.env.getResourceLocatorModel(-2111568384).setResourceLocator(new HMIResourceLocator(n2));
    }

    public int[] selectAllPois(boolean bl) {
        int n;
        EvoListRow evoListRow;
        int n2;
        this.logChannel.log(14808325, "PoiWarningModelAccess#selectAllPois %1", bl);
        int[] nArray = new int[this.mainList.getLength() + this.pPoiList.getLength()];
        this.logChannel.log(14808325, "PoiWarningModelAccess#selectAllPois  mainlist length: %1", (long)this.mainList.getLength());
        for (n2 = 0; n2 < this.pPoiList.getLength(); ++n2) {
            evoListRow = this.pPoiList.getRow(n2);
            n = evoListRow.getInteger(2);
            this.logChannel.log(14808325, "PoiWarningModelAccess#selectAllPois row #%1 select: %2", (long)n2, (long)n);
            if (bl) {
                if (n == 0) {
                    this.logChannel.log(14808325, "PoiWarningModelAccess#selectAllPois row #%1", (long)n2);
                    evoListRow.setInteger(2, 1);
                    nArray[n2] = (int)evoListRow.getUniqueID();
                    this.pPoiList.setRow(n2, evoListRow);
                    continue;
                }
                nArray[n2] = -1;
                continue;
            }
            if (n != 1) continue;
            evoListRow.setInteger(2, 0);
            nArray[n2] = (int)evoListRow.getUniqueID();
            this.pPoiList.setRow(n2, evoListRow);
        }
        for (n2 = 0; n2 < this.mainList.getLength(); ++n2) {
            evoListRow = this.mainList.getRow(n2);
            n = evoListRow.getInteger(2);
            this.logChannel.log(14808325, "PoiWarningModelAccess#selectAllPois row #%1 select: %2", (long)n2, (long)n);
            if (bl) {
                if (n == 0) {
                    this.logChannel.log(14808325, "PoiWarningModelAccess#selectAllPois row #%1", (long)n2);
                    evoListRow.setInteger(2, 1);
                    nArray[this.pPoiList.getLength() + n2] = (int)evoListRow.getUniqueID();
                    this.mainList.setRow(n2, evoListRow);
                    continue;
                }
                nArray[this.pPoiList.getLength() + n2] = -1;
                continue;
            }
            if (n != 1) continue;
            evoListRow.setInteger(2, 0);
            nArray[this.pPoiList.getLength() + n2] = (int)evoListRow.getUniqueID();
            this.mainList.setRow(n2, evoListRow);
        }
        return nArray;
    }

    public int[] toggleAll(int n, int n2) {
        EvoListRow evoListRow;
        int n3;
        this.logChannel.log(-2137614336, "PoiWarningModelAccess#toggleAll - POI Type: %1, Value: %2", (long)n, (long)n2);
        int[] nArray = new int[this.mainList.getLength() + this.pPoiList.getLength()];
        for (n3 = 0; n3 < this.pPoiList.getLength(); ++n3) {
            evoListRow = this.pPoiList.getRow(n3);
            if (n == 1) {
                if (n2 == 1) {
                    this.logChannel.log(14808325, "PoiWarningModelAccess#toggleAll row #%1 - to ON", (long)n3);
                    evoListRow.setInteger(2, 1);
                    nArray[n3] = (int)evoListRow.getUniqueID();
                    this.pPoiList.setRow(n3, evoListRow);
                    continue;
                }
                evoListRow.setInteger(2, 0);
                nArray[n3] = -1;
                this.pPoiList.setRow(n3, evoListRow);
                continue;
            }
            nArray[n3] = this.pPoiList.getRow(n3).getInteger(2) == 1 ? (int)evoListRow.getUniqueID() : -1;
        }
        for (n3 = 0; n3 < this.mainList.getLength(); ++n3) {
            evoListRow = this.mainList.getRow(n3);
            if (n == 0) {
                if (n2 == 1) {
                    this.logChannel.log(14808325, "PoiWarningModelAccess#toggleAll row #%1 - to ON", (long)n3);
                    evoListRow.setInteger(2, 1);
                    nArray[this.pPoiList.getLength() + n3] = (int)evoListRow.getUniqueID();
                    this.mainList.setRow(n3, evoListRow);
                    continue;
                }
                evoListRow.setInteger(2, 0);
                nArray[this.pPoiList.getLength() + n3] = -1;
                this.mainList.setRow(n3, evoListRow);
                continue;
            }
            nArray[this.pPoiList.getLength() + n3] = this.mainList.getRow(n3).getInteger(2) == 1 ? (int)evoListRow.getUniqueID() : -1;
        }
        return nArray;
    }

    public int getNumberOfPois() {
        return this.mainList.getLength() + this.pPoiList.getLength();
    }

    public void setNumberOfSelectedPois(int n) {
        this.env.getChoiceModel(-14481920).setValue(n);
    }
}

