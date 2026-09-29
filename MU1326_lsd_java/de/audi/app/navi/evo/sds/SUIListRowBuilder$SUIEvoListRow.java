/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.sds;

import de.audi.app.navi.evo.sds.SUIListRowBuilder;
import de.audi.app.navi.evo.sds.SUIListRowBuilder$1;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.NaviService$NaviSUIDetails;
import de.audi.atip.metrics.Distance;
import de.audi.tghu.navi.app.addressinput.poi.PoiUtil;
import de.audi.tghu.navi.app.rows.LiValueListRow;
import de.audi.tghu.navi.app.slidinglist.poi.DistanceDifferentiationRow;
import de.audi.tghu.navi.app.util.TextUtil;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.AddressFormatter;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.navigation.LIExtData;
import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.navigation.PosPosition;

class SUIListRowBuilder$SUIEvoListRow
extends LiValueListRow
implements DistanceDifferentiationRow {
    private int index;
    private NaviService$NaviSUIDetails details;
    private long id;
    private boolean flagRRD;
    private int distance;
    private final /* synthetic */ SUIListRowBuilder this$0;

    private SUIListRowBuilder$SUIEvoListRow(SUIListRowBuilder sUIListRowBuilder, LIValueListElement lIValueListElement, NaviService$NaviSUIDetails naviService$NaviSUIDetails, int n, PosPosition posPosition) {
        this.this$0 = sUIListRowBuilder;
        super(n, 7, lIValueListElement);
        this.index = n;
        this.details = naviService$NaviSUIDetails;
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

    private SUIListRowBuilder$SUIEvoListRow(SUIListRowBuilder sUIListRowBuilder, SUIListRowBuilder$SUIEvoListRow sUIListRowBuilder$SUIEvoListRow) {
        this.this$0 = sUIListRowBuilder;
        super(sUIListRowBuilder$SUIEvoListRow);
        this.index = sUIListRowBuilder$SUIEvoListRow.index;
        this.details = sUIListRowBuilder$SUIEvoListRow.details;
        this.flagRRD = sUIListRowBuilder$SUIEvoListRow.isMarkedAsRRD();
        if (sUIListRowBuilder$SUIEvoListRow.getElement() != null) {
            this.createListRowForElement();
        } else if (this.details != null) {
            this.createListRowForDetails();
        }
    }

    private void createListRowForElement() {
        LIValueListElement lIValueListElement = this.getElement();
        int n = SUIListRowBuilder.access$200(this.this$0).resolvePOIIconResourceID(lIValueListElement.getIconIndex(), lIValueListElement.getSubIconIndex());
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
        SUIListRowBuilder.access$300(this.this$0).log(-2137614336, "SUIListRowBuilder#createForAdbDetails() - adb entry: %1, %2 ", (Object)this.details.adbName, this.details.adbID);
        this.setInteger(0, 1);
        this.setInteger(1, 0);
        this.setText(2, this.details.adbName);
        this.id = this.details.adbID;
    }

    private void createForVDEDetails() {
        SUIListRowBuilder.access$300(this.this$0).log(-2137614336, "SUIListRowBuilder#createForVDEDetails()");
        String string = AddressFormatter.formatTwoLines(this.details, SUIListRowBuilder.access$400(this.this$0)).getFirstLineAsText();
        if (Util.isEmpty(string)) {
            this.setInteger(0, 6);
        } else {
            this.setInteger(0, 0);
        }
        this.setInteger(1, 1);
        if (Util.isHURegionJP() || Util.isHURegionKR()) {
            this.setText(2, this.details.provinceOrPrefecture);
            this.setText(3, AddressFormatter.formatOneLine(this.details, SUIListRowBuilder.access$400(this.this$0)).getFirstLineAsText());
        } else if (Util.isHURegionCN()) {
            this.setText(2, string);
            this.setText(3, AddressFormatter.formatTwoLines(this.details, SUIListRowBuilder.access$400(this.this$0)).getSecondLineAsText());
        } else {
            this.setText(2, this.details.city);
            this.setText(3, string);
        }
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (!(object instanceof SUIListRowBuilder$SUIEvoListRow)) {
            return false;
        }
        int n = ((SUIListRowBuilder$SUIEvoListRow)object).index;
        return n == this.index;
    }

    @Override
    public int hashCode() {
        return this.index;
    }

    @Override
    public EvoListRow copy() {
        return new SUIListRowBuilder$SUIEvoListRow(this.this$0, this);
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
            this.setDirection(n2);
        }
    }

    @Override
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

    @Override
    public void reformatDistance() {
        this.setMetrics(5, new Distance(this.distance, 5));
    }

    @Override
    public int getDistance() {
        return this.distance;
    }

    @Override
    public boolean isMarkedAsRRD() {
        return this.flagRRD;
    }

    @Override
    public synchronized void setDirection(int n) {
        this.setInteger(6, this.flagRRD ? n + 8 : n);
    }

    @Override
    public int getDirection() {
        int n = this.getInteger(6);
        if (this.flagRRD) {
            n -= 8;
        }
        return n;
    }

    @Override
    public int getLongitude() {
        return this.getElement().getLongitude();
    }

    @Override
    public int getLatitude() {
        return this.getElement().getLatitude();
    }

    @Override
    public synchronized void updateDirection(PosPosition posPosition) {
        this.doUpdateDirection(posPosition);
    }

    private synchronized void doUpdateDirection(PosPosition posPosition) {
        int n = Util.computeAbsoluteDirection(posPosition, this.getLongitude(), this.getLatitude());
        int n2 = Util.convertRotatingDirection(n, posPosition.directionAngle);
        this.setDirection(n2);
    }

    @Override
    public synchronized void updateAirDistance(PosPosition posPosition) {
        this.doUpdateAirDistance(posPosition);
    }

    private synchronized void doUpdateAirDistance(PosPosition posPosition) {
        if (!this.flagRRD) {
            int n = Util.computeAirDistance(posPosition.getLongitude(), posPosition.getLatitude(), this.getLongitude(), this.getLatitude());
            this.doSetAirDistance(n);
        }
    }

    /* synthetic */ SUIListRowBuilder$SUIEvoListRow(SUIListRowBuilder sUIListRowBuilder, LIValueListElement lIValueListElement, NaviService$NaviSUIDetails naviService$NaviSUIDetails, int n, PosPosition posPosition, SUIListRowBuilder$1 sUIListRowBuilder$1) {
        this(sUIListRowBuilder, lIValueListElement, naviService$NaviSUIDetails, n, posPosition);
    }

    static /* synthetic */ long access$100(SUIListRowBuilder$SUIEvoListRow sUIListRowBuilder$SUIEvoListRow) {
        return sUIListRowBuilder$SUIEvoListRow.id;
    }
}

