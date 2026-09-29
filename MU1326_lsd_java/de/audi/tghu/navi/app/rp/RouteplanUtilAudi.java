/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rp;

import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.DateMetric;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Date;

public class RouteplanUtilAudi {
    private DateMetric etaDateMetric;
    protected LogChannel logChannel;

    public RouteplanUtilAudi(NavigationEnv navigationEnv, int n) {
        this.logChannel = navigationEnv.getLogChannel();
        this.etaDateMetric = new DateMetric(new Date(), 1);
    }

    public void refreshRouteDestinationData(int n, boolean bl, boolean bl2, long l, boolean bl3, int n2) {
        Buffer buffer = new Buffer();
        if (bl) {
            String string;
            String string2 = bl3 ? Util.formatDistance(n2, 1) : Util.getInvalidDistance();
            if (bl2) {
                this.etaDateMetric.setDate(l);
                string = this.etaDateMetric.format();
            } else {
                string = "--:--";
            }
            buffer.append(string2);
            if (buffer.length() > 0) {
                buffer.append(", ");
            }
            buffer.append(string);
        } else {
            buffer.append(Util.getInvalidDistance());
            buffer.append(", ");
            buffer.append("--:--");
        }
    }
}

