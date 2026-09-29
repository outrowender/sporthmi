/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.combi.ddp2;

import de.audi.atip.hmi.combi.AbstractCombiElement;
import de.esolutions.fw.util.commons.Buffer;

public class CombiCompassElement
extends AbstractCombiElement {
    public int format;
    public int vehicleDirection = 0;
    public int destinationDirection = 0;
    public int offroadWaypoint = 0;

    public final void copyTo(CombiCompassElement combiCompassElement) {
        super.copyTo(combiCompassElement);
        combiCompassElement.format = this.format;
        combiCompassElement.vehicleDirection = this.vehicleDirection;
        combiCompassElement.destinationDirection = this.destinationDirection;
        combiCompassElement.offroadWaypoint = this.offroadWaypoint;
    }

    @Override
    public void reset() {
        this.format = 0;
        this.vehicleDirection = 0;
        this.destinationDirection = 0;
        this.offroadWaypoint = 0;
    }

    public short[] getData() {
        return new short[]{(short)this.format, 0, (short)this.vehicleDirection, (short)this.destinationDirection, 0, (short)this.offroadWaypoint, 0};
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("format: ").append(this.format);
        buffer.append(" | vehicleDir: ").append(this.vehicleDirection);
        buffer.append(" | destDir: ").append(this.destinationDirection);
        buffer.append(" | offroadWP: ").append(this.offroadWaypoint);
        return buffer.toString();
    }
}

