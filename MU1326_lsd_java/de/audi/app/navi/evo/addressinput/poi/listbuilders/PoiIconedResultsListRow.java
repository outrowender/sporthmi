/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listbuilders;

import de.audi.app.navi.evo.addressinput.poi.PoiScreensEvo;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.metrics.Distance;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.PoiUtil;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import de.audi.tghu.navi.app.rows.LiValueListRow;
import de.audi.tghu.navi.app.slidinglist.poi.DistanceDifferentiationRow;
import de.audi.tghu.navi.app.util.TextUtil;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.navigation.LIExtData;
import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.navigation.PosPosition;

public class PoiIconedResultsListRow
extends LiValueListRow
implements DistanceDifferentiationRow {
    public static final int COLUMN_ICON;
    public static final int COLUMN_CATEGORY_NAME;
    public static final int COLUMN_PROPERTY;
    public static final int COLUMN_DIRECTION_ARROW;
    public static final int COLUMN_DISTANCE;
    public static final int COLUMN_ADDRESS_INFO;
    public static final int COLUMN_LAYOUT_RECORD_SET;
    public static final int COLUMN_24_HOUR;
    public static final int COLUMN_ADDITIONAL_TRAVELGUIDE_INFO_AVAILABLE;
    public static final int COLUMN_PAYMENT_BY_CREDIT_CARD;
    public static final int COLUMN_DIESEL_OFFERED;
    public static final int COLUMN_COUNT;
    private static final int NORMAL_POI_ELEMENT;
    private static final int ASIA_PARENT_ELEMENT_WITHOUT_GEOCOORDINATES;
    private static final int ASIA_PARENT_CHILD_ELEMENT;
    private static final int AVAILABLE;
    private static final int NOT_AVAILABLE;
    private int distance;
    private boolean flagRRD;
    private final NavigationEnv env;

    public PoiIconedResultsListRow(IconHandler iconHandler, LIValueListElement lIValueListElement, int n, PosPosition posPosition, NavigationEnv navigationEnv) {
        super(n, 12, lIValueListElement);
        this.env = navigationEnv;
        int n2 = iconHandler.resolvePOIIconResourceID(lIValueListElement.getIconIndex(), lIValueListElement.getSubIconIndex());
        IconCell iconCell = new IconCell(new HMIResourceLocator(n2));
        this.setIconCell(0, iconCell);
        int n3 = PoiScreensEvo.getCategoryPropertyForActivePoiContext(navigationEnv);
        if (this.isAsiaParentPoi()) {
            this.setPropertyCell(3, PropertyListCell.EMPTY_CELL);
        } else {
            this.setPropertyCell(3, PropertyListCell.create(n3, new int[0]));
        }
        String string = null;
        String string2 = lIValueListElement.getData();
        this.setLayoutRecordSet();
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
        this.setText(1, buffer.toString());
        if (string != null) {
            this.setText(6, string);
        }
        this.setIntegerForColumnByBoolean(8, PoiUtil.isPoi24h(lIValueListElement));
        this.setIntegerForColumnByBoolean(9, PoiUtil.hasTravelGuideAdditionalInfo(lIValueListElement));
        this.setIntegerForColumnByBoolean(11, PoiUtil.isDieselAvailable(lIValueListElement));
        this.setIntegerForColumnByBoolean(10, PoiUtil.isPayByCreditCardPossible(lIValueListElement));
        if (posPosition != null) {
            this.doUpdateAirDistance(posPosition);
            this.doUpdateDirection(posPosition);
        }
    }

    private void setIntegerForColumnByBoolean(int n, boolean bl) {
        this.setInteger(n, bl ? 1 : 0);
    }

    protected PoiIconedResultsListRow(PoiIconedResultsListRow poiIconedResultsListRow) {
        super(poiIconedResultsListRow);
        this.env = poiIconedResultsListRow.env;
        this.flagRRD = poiIconedResultsListRow.isMarkedAsRRD();
    }

    @Override
    public EvoListRow copy() {
        return new PoiIconedResultsListRow(this);
    }

    @Override
    public int getDistance() {
        return this.distance;
    }

    @Override
    public synchronized void setRRDDistance(int n) {
        this.distance = n;
        this.reformatDistance();
        if (!this.flagRRD) {
            int n2 = this.getDirection();
            this.flagRRD = true;
            this.setDirection(n2);
        }
    }

    @Override
    public synchronized void setAirDistance(int n) {
        this.doSetAirDistance(n);
    }

    private synchronized void doSetAirDistance(int n) {
        this.distance = n;
        this.reformatDistance();
        if (this.flagRRD) {
            int n2 = this.getDirection();
            this.flagRRD = false;
            this.doSetDirection(n2);
        }
    }

    @Override
    public void reformatDistance() {
        this.setMetrics(5, new Distance(this.distance, 5));
    }

    @Override
    public int getDirection() {
        int n = this.getInteger(4);
        if (this.flagRRD) {
            n -= 8;
        }
        return n;
    }

    @Override
    public void setDirection(int n) {
        this.doSetDirection(n);
    }

    private void doSetDirection(int n) {
        this.setInteger(4, this.flagRRD ? n + 8 : n);
    }

    @Override
    public final boolean isMarkedAsRRD() {
        return this.flagRRD;
    }

    @Override
    public int getLatitude() {
        return this.doGetLatitude();
    }

    private int doGetLatitude() {
        return this.getElement().getLatitude();
    }

    private int doGetLongitude() {
        return this.getElement().getLongitude();
    }

    @Override
    public int getLongitude() {
        return this.doGetLongitude();
    }

    @Override
    public synchronized void updateDirection(PosPosition posPosition) {
        this.doUpdateDirection(posPosition);
    }

    private synchronized void doUpdateDirection(PosPosition posPosition) {
        int n = Util.computeAbsoluteDirection(posPosition, this.doGetLongitude(), this.doGetLatitude());
        int n2 = Util.convertRotatingDirection(n, posPosition.directionAngle);
        this.doSetDirection(n2);
    }

    @Override
    public synchronized void updateAirDistance(PosPosition posPosition) {
        this.doUpdateAirDistance(posPosition);
    }

    private synchronized void doUpdateAirDistance(PosPosition posPosition) {
        if (!this.isMarkedAsRRD()) {
            int n = Util.computeAirDistance(posPosition.getLongitude(), posPosition.getLatitude(), this.doGetLongitude(), this.doGetLatitude());
            this.doSetAirDistance(n);
        }
    }

    private void setLayoutRecordSet() {
        if (this.isAsiaParentPoi()) {
            this.setInteger(7, 1);
        } else if (this.isAsiaParentChild()) {
            this.setInteger(7, 1);
        } else {
            this.setInteger(7, 0);
        }
    }

    private boolean isAsiaParentPoi() {
        return Util.isHURegionAsia() && this.doGetLatitude() == 0 && this.doGetLongitude() == 0;
    }

    private boolean isAsiaParentChild() {
        SpellerContext spellerContext = SpellerStack.getInstance().getActiveSC();
        if (spellerContext != null) {
            return Util.isHURegionAsia() && spellerContext.getContextID() == 5;
        }
        return false;
    }
}

