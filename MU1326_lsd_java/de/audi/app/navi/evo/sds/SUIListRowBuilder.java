/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.sds;

import de.audi.app.navi.evo.addressinput.poi.listbuilders.EvoRRDInitialPositionHandler;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.Distance;
import de.audi.tghu.navi.app.IListRowBuilder;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.PoiUtil;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.rows.LiValueListRow;
import de.audi.tghu.navi.app.sds.ISUIListRowBuilder;
import de.audi.tghu.navi.app.slidinglist.poi.DistanceDifferentiationRow;
import de.audi.tghu.navi.app.slidinglist.poi.RRDInitialPositionHandler;
import de.audi.tghu.navi.app.util.TextUtil;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.AddressFormatter;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.navigation.LIExtData;
import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.navigation.PosPosition;

public class SUIListRowBuilder
implements ISUIListRowBuilder,
IListRowBuilder {
    static final int LAYOUT_VDE_ADDRESSES = 0;
    static final int LAYOUT_ADB_CONTACT = 1;
    static final int LAYOUT_POI_CATEGORY_DYNAMIC = 2;
    static final int LAYOUT_POI_CATEGORY_STATIC = 3;
    static final int LAYOUT_POI_RESULT_DYNAMIC = 4;
    static final int LAYOUT_POI_RESULT_STATIC = 5;
    static final int LAYOUT_VDE_ADDRESSES_SINGLE_LINE = 6;
    static final int COLUMN_LAYOUT = 0;
    static final int COLUMN_ICON = 1;
    static final int COLUMN_TEXT_LINE1 = 2;
    static final int COLUMN_TEXT_LINE2 = 3;
    static final int COLUMN_DISTANCE = 5;
    static final int COLUMN_DIRECTION_ARROW = 6;
    final int COLUMN_COUNT;
    final int ICON_ADB;
    final int ICON_VDE;
    private final LogChannel logChannel;
    private final IconHandler iconHandler;
    private final NavigationEnv env;
    private RRDInitialPositionHandler rrdInitialPositionHandler;

    private SUIListRowBuilder(LogChannel logChannel, IconHandler iconHandler, NavigationEnv navigationEnv) {
        this.COLUMN_COUNT = 7;
        this.ICON_ADB = 0;
        this.ICON_VDE = 1;
        this.logChannel = logChannel;
        this.iconHandler = iconHandler;
        this.env = navigationEnv;
    }

    private SUIListRowBuilder(LogChannel logChannel, IconHandler iconHandler, IRouteManager iRouteManager, NavigationEnv navigationEnv, IVehicle iVehicle) {
        this(logChannel, iconHandler, navigationEnv);
        this.rrdInitialPositionHandler = new EvoRRDInitialPositionHandler(iRouteManager, navigationEnv, iVehicle);
    }

    public static SUIListRowBuilder createSUIListRowBuilderDistanceFromCCP(LogChannel logChannel, IconHandler iconHandler, IRouteManager iRouteManager, NavigationEnv navigationEnv, IVehicle iVehicle) {
        return new SUIListRowBuilder(logChannel, iconHandler, iRouteManager, navigationEnv, iVehicle);
    }

    public EvoListRow buildEvoListRow(NaviService.NaviSUIDetails naviSUIDetails, int n) {
        return new SUIEvoListRow(null, naviSUIDetails, n, this.rrdInitialPositionHandler.getInitialPosition());
    }

    public EvoListRow buildEvoListRow(LIValueListElement lIValueListElement, int n) {
        return new SUIEvoListRow(lIValueListElement, null, n, this.rrdInitialPositionHandler.getInitialPosition());
    }

    public ListCell[] buildListRow(LIValueListElement lIValueListElement, int n) {
        this.logChannel.log(100000, "SUIEvoListRow#buildListRow() returning ListCell[] is not supported");
        return new ListCell[0];
    }

    public int getColumnCount() {
        return 7;
    }

    public static String getName(EvoListRow evoListRow) {
        return evoListRow.getText(2);
    }

    public static Distance getDistance(EvoListRow evoListRow) {
        return (Distance)evoListRow.getMetrics(5);
    }

    public static LIValueListElement getLiValueListElement(EvoListRow evoListRow) {
        return ((SUIEvoListRow)evoListRow).getElement();
    }

    public static int getIconResourceId(EvoListRow evoListRow) {
        return ((HMIResourceLocator)evoListRow.getCell(1)).getResourceID();
    }

    public static String getCategoryName(EvoListRow evoListRow) {
        return evoListRow.getText(2);
    }

    public static long getId(EvoListRow evoListRow) {
        return ((SUIEvoListRow)evoListRow).id;
    }

    private class SUIEvoListRow
    extends LiValueListRow
    implements DistanceDifferentiationRow {
        private int index;
        private NaviService.NaviSUIDetails details;
        private long id;
        private boolean flagRRD;
        private int distance;

        private SUIEvoListRow(LIValueListElement lIValueListElement, NaviService.NaviSUIDetails naviSUIDetails, int n, PosPosition posPosition) {
            super(n, 7, lIValueListElement);
            this.index = n;
            this.details = naviSUIDetails;
            this.flagRRD = false;
            if (lIValueListElement != null) {
                this.createListRowForElement();
                if (posPosition != null) {
                    this.doUpdateAirDistance(posPosition);
                    this.doUpdateDirection(posPosition);
                }
            } else if (this.details != null) {
                this.createListRowForDetails();
            }
        }

        private SUIEvoListRow(SUIEvoListRow sUIEvoListRow) {
            super(sUIEvoListRow);
            this.index = sUIEvoListRow.index;
            this.details = sUIEvoListRow.details;
            this.flagRRD = sUIEvoListRow.isMarkedAsRRD();
            if (sUIEvoListRow.getElement() != null) {
                this.createListRowForElement();
            } else if (this.details != null) {
                this.createListRowForDetails();
            }
        }

        private void createListRowForElement() {
            LIValueListElement lIValueListElement = this.getElement();
            int n = SUIListRowBuilder.this.iconHandler.resolvePOIIconResourceID(lIValueListElement.getIconIndex(), lIValueListElement.getSubIconIndex());
            this.setInteger(0, 4);
            IconCell iconCell = new IconCell(new HMIResourceLocator(n));
            this.setIconCell(1, iconCell);
            String string = null;
            String string2 = lIValueListElement.getData();
            LIExtData[] lIExtDataArray = lIValueListElement.getExtendedData();
            for (int i2 = 0; i2 < lIExtDataArray.length; ++i2) {
                if (lIExtDataArray[i2].getType() == 15) {
                    string2 = lIExtDataArray[i2].getData();
                    continue;
                }
                if (lIExtDataArray[i2].getType() != 16) continue;
                string = lIExtDataArray[i2].getData();
            }
            Buffer buffer = new Buffer(string2);
            if (Util.isHURegionNAR() && PoiUtil.isPoi24h(lIValueListElement)) {
                buffer.append(" ").append(TextUtil.getPoi24hMarker());
            }
            this.setText(2, buffer.toString());
            if (string != null) {
                this.setText(3, string);
            }
        }

        private void createListRowForDetails() {
            if (this.details.poiID != -1L && !Util.isEmpty(this.details.poiName)) {
                this.createForPoiCategory();
            } else if (this.details.adbID != -1L && !Util.isEmpty(this.details.adbName)) {
                this.createForAdbDetails();
            } else {
                this.createForVDEDetails();
            }
        }

        private void createForPoiCategory() {
            if (Util.isEmpty(this.details.city)) {
                this.setInteger(0, 3);
            } else {
                this.setInteger(0, 5);
                this.setText(3, this.details.city);
            }
            this.setInteger(1, (int)this.details.poiIconID);
            this.setText(2, this.details.poiName);
            this.id = this.details.poiID;
        }

        private void createForAdbDetails() {
            SUIListRowBuilder.this.logChannel.log(10000000, "SUIListRowBuilder#createForAdbDetails() - adb entry: %1, %2 ", (Object)this.details.adbName, this.details.adbID);
            this.setInteger(0, 1);
            this.setInteger(1, 0);
            this.setText(2, this.details.adbName);
            this.id = this.details.adbID;
        }

        private void createForVDEDetails() {
            SUIListRowBuilder.this.logChannel.log(10000000, "SUIListRowBuilder#createForVDEDetails()");
            String string = AddressFormatter.formatTwoLines(this.details, SUIListRowBuilder.this.env).getFirstLineAsText();
            if (Util.isEmpty(string)) {
                this.setInteger(0, 6);
            } else {
                this.setInteger(0, 0);
            }
            this.setInteger(1, 1);
            if (Util.isHURegionJP() || Util.isHURegionKR()) {
                this.setText(2, this.details.provinceOrPrefecture);
                this.setText(3, AddressFormatter.formatOneLine(this.details, SUIListRowBuilder.this.env).getFirstLineAsText());
            } else if (Util.isHURegionCN()) {
                this.setText(2, string);
                this.setText(3, AddressFormatter.formatTwoLines(this.details, SUIListRowBuilder.this.env).getSecondLineAsText());
            } else {
                this.setText(2, this.details.city);
                this.setText(3, string);
            }
        }

        public boolean equals(Object object) {
            if (object == null) {
                return false;
            }
            if (!(object instanceof SUIEvoListRow)) {
                return false;
            }
            int n = ((SUIEvoListRow)object).index;
            return n == this.index;
        }

        public int hashCode() {
            return this.index;
        }

        public EvoListRow copy() {
            return new SUIEvoListRow(this);
        }

        public synchronized void setAirDistance(int n) {
            this.doSetAirDistance(n);
        }

        private synchronized void doSetAirDistance(int n) {
            this.distance = n;
            this.reformatDistance();
            if (this.flagRRD) {
                int n2 = this.getDirection();
                this.flagRRD = false;
                this.setDirection(n2);
            }
        }

        public synchronized void setRRDDistance(int n) {
            this.doSetRRDDistance(n);
        }

        private synchronized void doSetRRDDistance(int n) {
            this.distance = n;
            this.reformatDistance();
            if (!this.flagRRD) {
                int n2 = this.getDirection();
                this.flagRRD = true;
                this.setDirection(n2);
            }
        }

        public void reformatDistance() {
            this.setMetrics(5, new Distance(this.distance, 5));
        }

        public int getDistance() {
            return this.distance;
        }

        public boolean isMarkedAsRRD() {
            return this.flagRRD;
        }

        public synchronized void setDirection(int n) {
            this.setInteger(6, this.flagRRD ? n + 8 : n);
        }

        public int getDirection() {
            int n = this.getInteger(6);
            if (this.flagRRD) {
                n -= 8;
            }
            return n;
        }

        public int getLongitude() {
            return this.getElement().getLongitude();
        }

        public int getLatitude() {
            return this.getElement().getLatitude();
        }

        public synchronized void updateDirection(PosPosition posPosition) {
            this.doUpdateDirection(posPosition);
        }

        private synchronized void doUpdateDirection(PosPosition posPosition) {
            int n = Util.computeAbsoluteDirection(posPosition, this.getLongitude(), this.getLatitude());
            int n2 = Util.convertRotatingDirection(n, posPosition.directionAngle);
            this.setDirection(n2);
        }

        public synchronized void updateAirDistance(PosPosition posPosition) {
            this.doUpdateAirDistance(posPosition);
        }

        private synchronized void doUpdateAirDistance(PosPosition posPosition) {
            if (!this.flagRRD) {
                int n = Util.computeAirDistance(posPosition.getLongitude(), posPosition.getLatitude(), this.getLongitude(), this.getLatitude());
                this.doSetAirDistance(n);
            }
        }
    }
}

