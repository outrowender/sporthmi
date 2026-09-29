/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.metrics.AbstractMetrics;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.metrics.Distance;
import de.audi.atip.metrics.GeoMetric;
import de.audi.atip.metrics.Speed;
import de.audi.atip.metrics.Temperature;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.evo.LineElement;
import java.util.ArrayList;
import java.util.List;

public class MetricsFormatter
implements IWidgetLogChannel,
WidgetConstants {
    public static final int PREFIX_MINUS;
    public static final int PREFIX_PLUS;

    public static String format(AbstractMetrics abstractMetrics, int n, int n2) {
        if (abstractMetrics == null) {
            return "";
        }
        if (abstractMetrics instanceof DateMetric) {
            int n3 = n;
            abstractMetrics = MetricsFormatter.getTempDateMetricForFormatting((DateMetric)abstractMetrics, n3);
        }
        if (n2 == -1) {
            return abstractMetrics.format();
        }
        if (abstractMetrics instanceof Distance) {
            if (n2 == 8) {
                ((Distance)abstractMetrics).setNumberOfDecimalPlaces(1);
            }
            return ((Distance)abstractMetrics).format(Distance.getSystemUnit(), n2);
        }
        if (abstractMetrics instanceof DateMetric) {
            return ((DateMetric)abstractMetrics).format(n2);
        }
        if (abstractMetrics instanceof Speed) {
            return ((Speed)abstractMetrics).formatWithMetricsMode(n2);
        }
        if (abstractMetrics instanceof GeoMetric) {
            return ((GeoMetric)abstractMetrics).format(-1, n2);
        }
        if (abstractMetrics instanceof Temperature) {
            return ((Temperature)abstractMetrics).formatWithMetricsMode(n2);
        }
        return abstractMetrics.format(n2);
    }

    public static String[] getStringValueAndUnit(AbstractMetrics abstractMetrics, int n, int n2) {
        if (abstractMetrics == null) {
            return new String[]{"", ""};
        }
        if (abstractMetrics instanceof DateMetric) {
            int n3 = n;
            abstractMetrics = MetricsFormatter.getTempDateMetricForFormatting((DateMetric)abstractMetrics, n3);
        }
        if (n2 == -1) {
            return abstractMetrics.getStringValueAndUnit();
        }
        if (abstractMetrics instanceof Distance) {
            return ((Distance)abstractMetrics).getStringValueAndUnit(Distance.getSystemUnit(), n2);
        }
        if (abstractMetrics instanceof DateMetric) {
            return abstractMetrics.getStringValueAndUnit(n2);
        }
        if (abstractMetrics instanceof Speed) {
            return null;
        }
        if (abstractMetrics instanceof GeoMetric) {
            return null;
        }
        if (abstractMetrics instanceof Temperature) {
            return null;
        }
        return abstractMetrics.getStringValueAndUnit(n2);
    }

    public static List getLineDescriptor(int n, AbstractMetrics abstractMetrics, int n2, int n3, boolean bl) {
        int n4;
        Object object;
        int n5 = 2;
        int n6 = 0;
        int n7 = 1;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        if (abstractMetrics instanceof DateMetric) {
            int n8;
            bl4 = DateMetric.timeFormat == 11;
            object = (DateMetric)abstractMetrics;
            int n9 = n8 = n2 == -1 ? ((DateMetric)object).getType() : n2;
            if (bl4 && (n8 == 1 || n8 == 6)) {
                n4 = ((DateMetric)object).getDecoration();
                if (n4) {
                    bl3 = true;
                }
                bl2 = true;
            }
        }
        object = MetricsFormatter.getStringValueAndUnit(abstractMetrics, n2, n3);
        object[n7] = object[n7].trim();
        ArrayList arrayList = new ArrayList();
        n4 = abstractMetrics instanceof Distance || abstractMetrics instanceof DateMetric ? 1 : 0;
        arrayList.add(new LineElement((String)object[n6], 0, n4 != 0, bl || n == -1 ? n5 : 0));
        arrayList.add(!bl && bl4 ? 0 : 1, new LineElement((String)object[n7], bl2 ? 2 : 1, 1, bl3));
        if (n != -1) {
            String string = "";
            if (n < 0) {
                switch (n) {
                    case -2: {
                        string = "-";
                        break;
                    }
                    case -3: {
                        string = "+";
                        break;
                    }
                }
            } else {
                string = AbstractWidget.hmiService.getText(n);
            }
            int n10 = 0;
            int n11 = n5;
            if (!bl) {
                if (n < 0) {
                    n10 = 1;
                }
            } else if (n < 0) {
                n11 = 0;
            }
            arrayList.add(n10, new LineElement(string, 1, n11));
            textDescriptorLogCh.log(-2137614336, "MetricsFormatter#getLineDescriptor add prefix %2, %1", (Object)string, (long)n);
        }
        return arrayList;
    }

    private static DateMetric getTempDateMetricForFormatting(DateMetric dateMetric, int n) {
        if (n == -1) {
            return dateMetric;
        }
        DateMetric dateMetric2 = new DateMetric(dateMetric.getDate(), n);
        dateMetric2.setDateValid(dateMetric.isDateValid());
        return dateMetric2;
    }
}

