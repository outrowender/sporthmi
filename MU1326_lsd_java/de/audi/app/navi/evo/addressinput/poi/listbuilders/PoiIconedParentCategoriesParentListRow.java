/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listbuilders;

import de.audi.app.navi.evo.addressinput.poi.PoiScreensEvo;
import de.audi.app.navi.evo.addressinput.poi.listbuilders.PoiIconedParentCategoriesListRow;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.slidinglist.poi.DistanceDifferentiationRow;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.navigation.PosPosition;

public class PoiIconedParentCategoriesParentListRow
extends PoiIconedParentCategoriesListRow
implements DistanceDifferentiationRow {
    protected int distance;
    protected volatile boolean flagRRD;

    public PoiIconedParentCategoriesParentListRow(IconHandler iconHandler, LIValueListElement lIValueListElement, int n, PosPosition posPosition, NavigationEnv navigationEnv) {
        super(iconHandler, lIValueListElement, n, posPosition);
        int n2 = PoiScreensEvo.getCategoryPropertyForActivePoiContext(navigationEnv);
        this.setPropertyCell(5, new PropertyListCell(n2, new int[0]));
        this.setInteger(0, 0);
        this.setInteger(4, 1);
        if (posPosition != null) {
            this.doUpdateAirDistance(posPosition);
            this.doUpdateDirection(posPosition);
        }
    }

    protected PoiIconedParentCategoriesParentListRow(PoiIconedParentCategoriesListRow poiIconedParentCategoriesListRow) {
        super(poiIconedParentCategoriesListRow);
    }

    public EvoListRow copy() {
        return new PoiIconedParentCategoriesParentListRow(this);
    }

    public int getDistance() {
        return this.distance;
    }

    public synchronized void setRRDDistance(int n) {
        this.distance = n;
        this.reformatDistance();
        if (!this.flagRRD) {
            int n2 = this.getDirection();
            this.flagRRD = true;
            this.setDirection(n2);
        }
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
            this.doSetDirection(n2);
        }
    }

    public void reformatDistance() {
        this.setText(7, Util.formatDistance(this.distance, 1));
    }

    public int getDirection() {
        int n = this.getInteger(6);
        if (this.flagRRD) {
            n -= 8;
        }
        return n;
    }

    public void setDirection(int n) {
        this.doSetDirection(n);
    }

    private void doSetDirection(int n) {
        this.setInteger(6, this.flagRRD ? n + 8 : n);
    }

    public final boolean isMarkedAsRRD() {
        return this.flagRRD;
    }

    public int getLatitude() {
        return this.doGetLatitude();
    }

    private int doGetLatitude() {
        if (this.getElement() == null) {
            return 0;
        }
        return this.getElement().getLatitude();
    }

    public int getLongitude() {
        return this.doGetLongitude();
    }

    private int doGetLongitude() {
        if (this.getElement() == null) {
            return 0;
        }
        return this.getElement().getLongitude();
    }

    public synchronized void updateDirection(PosPosition posPosition) {
        this.doUpdateDirection(posPosition);
    }

    private synchronized void doUpdateDirection(PosPosition posPosition) {
        int n = Util.computeAbsoluteDirection(posPosition, this.doGetLongitude(), this.doGetLatitude());
        int n2 = Util.convertRotatingDirection(n, posPosition.directionAngle);
        this.doSetDirection(n2);
    }

    public synchronized void updateAirDistance(PosPosition posPosition) {
        this.doUpdateAirDistance(posPosition);
    }

    private synchronized void doUpdateAirDistance(PosPosition posPosition) {
        if (!this.isMarkedAsRRD()) {
            int n = Util.computeAirDistance(posPosition.getLongitude(), posPosition.getLatitude(), this.doGetLongitude(), this.doGetLatitude());
            this.doSetAirDistance(n);
        }
    }
}

