/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.seat;

import de.audi.app.earlyfunc.core.seat.ISeatPopinModelRow;

public class SeatDisplayContent {
    private final ISeatPopinModelRow seatPopinContent;
    private boolean verticalArrowsAvailable;
    private boolean horizontalArrowsAvailable;
    private boolean contentAvailable;

    public SeatDisplayContent(ISeatPopinModelRow iSeatPopinModelRow) {
        this.seatPopinContent = iSeatPopinModelRow;
    }

    public ISeatPopinModelRow getSeatPopinContent() {
        return this.seatPopinContent;
    }

    public boolean areVerticalArrowsAvailable() {
        return this.verticalArrowsAvailable;
    }

    public void setVerticalArrowsAvailable(boolean bl) {
        this.verticalArrowsAvailable = bl;
    }

    public boolean areHorizontalArrowsAvailable() {
        return this.horizontalArrowsAvailable;
    }

    public void setHorizontalArrowsAvailable(boolean bl) {
        this.horizontalArrowsAvailable = bl;
    }

    public boolean isContentAvailable() {
        return this.contentAvailable;
    }

    public void setContentAvailable(boolean bl) {
        this.contentAvailable = bl;
    }
}

