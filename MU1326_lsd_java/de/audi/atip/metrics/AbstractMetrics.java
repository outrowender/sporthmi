/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.metrics;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.metrics.IMetricsTextConstants;
import de.audi.atip.metrics.IMetricsTextHandler;
import de.esolutions.fw.util.commons.Buffer;

public abstract class AbstractMetrics
implements IMetricsTextConstants {
    static final boolean LOGGING_ENABLED = Boolean.getBoolean("logMetricsToConsole");
    public static final int CODING_DEFAULT;
    public static final int CODING_CLUSTER;
    public static final int CODING_CLUSTER_MIB2;
    public static final String TEXT_SEPARATOR_COMMA;
    public static final String TEXT_SEPARATOR_DOT;
    public static final String TEXT_SEPARATOR_COLON;
    public static final String TEXT_SEPARATOR_EMPTY_SPACE;
    public static final String TEXT_SEPARATOR_PIPE;
    public static final String TEXT_PLUS;
    public static final String TEXT_MINUS;
    public static final String EMPTY_STRING;
    protected static boolean isPorsche;
    protected float value;
    protected final int unit;
    protected String lastFormat;
    protected boolean useInstanceUnit;
    protected volatile boolean isMetricValid = true;
    private static IMetricsTextHandler textHandler;
    protected static IFrameworkAccess frameworkAccess;

    public static void setTextHandler(IMetricsTextHandler iMetricsTextHandler) {
        textHandler = iMetricsTextHandler;
    }

    public static void setFrameworkAccess(IFrameworkAccess iFrameworkAccess) {
        frameworkAccess = iFrameworkAccess;
    }

    public AbstractMetrics(float f2, int n) {
        this.value = f2;
        this.unit = n;
    }

    public abstract void setValue(float f2) {
    }

    public abstract float getValue() {
    }

    public int getUnit() {
        return this.unit;
    }

    public abstract float getValue(int n) {
    }

    public abstract String format() {
    }

    public abstract String format(int n) {
    }

    protected static boolean contentEquals(String string, Buffer buffer) {
        if (string == null || buffer == null) {
            return false;
        }
        if (string.length() != buffer.length()) {
            return false;
        }
        int n = string.length();
        for (int i2 = 0; i2 < n; ++i2) {
            if (string.charAt(i2) == buffer.charAt(i2)) continue;
            return false;
        }
        return true;
    }

    public void setUseInstanceUnit(boolean bl) {
        this.useInstanceUnit = bl;
    }

    public void setMetricValid(boolean bl) {
        this.isMetricValid = bl;
    }

    public boolean isMetricvalid() {
        return this.isMetricValid;
    }

    public abstract String getInvalidText() {
    }

    protected static String getText(int n) {
        String string = null;
        if (textHandler != null) {
            string = textHandler.getText(n);
        }
        return string;
    }

    public String[] getStringValueAndUnit() {
        return new String[]{"", ""};
    }

    public String[] getStringValueAndUnit(int n) {
        return this.getStringValueAndUnit();
    }

    public abstract String getFormattedMetricUnit() {
    }

    public abstract String getFormattedUnit(int n) {
    }

    public abstract String getFormattedValue() {
    }

    public abstract String getFormattedValue(int n) {
    }

    public static void setPorsche(boolean bl) {
        isPorsche = bl;
    }

    static void println(Buffer buffer) {
        if (LOGGING_ENABLED) {
            System.out.println(new StringBuffer().append("[METRICS] ").append(buffer).toString());
        }
    }

    static {
        isPorsche = false;
    }
}

