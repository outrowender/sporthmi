/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.config.carcoding;

import de.audi.atip.sysapp.carcoding.IVariantInfo;
import de.esolutions.fw.util.commons.Buffer;
import java.util.StringTokenizer;

public class VariantInfo
implements IVariantInfo {
    private String headUnit;
    private String type;
    private String features;
    private String region = "EU";
    private String brand;
    private String topology;
    private boolean isMMIRadio = false;

    public VariantInfo(String string) {
        if (string == null) {
            return;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(string, "-");
        if (stringTokenizer.countTokens() == 6) {
            this.headUnit = stringTokenizer.nextToken();
            this.type = stringTokenizer.nextToken();
            this.features = stringTokenizer.nextToken();
            this.isMMIRadio = this.features.indexOf("M") != -1;
            this.region = stringTokenizer.nextToken();
            this.brand = stringTokenizer.nextToken();
            this.topology = stringTokenizer.nextToken();
        }
    }

    @Override
    public String getHeadUnit() {
        return this.headUnit;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String getFeatures() {
        return this.features;
    }

    @Override
    public String getBrand() {
        return this.brand;
    }

    @Override
    public String getTopology() {
        return this.topology;
    }

    @Override
    public String getRegion() {
        return this.region;
    }

    @Override
    public boolean isMMIRadio() {
        return this.isMMIRadio;
    }

    public String toString() {
        return new Buffer().append("\nVariantInfo: ").append(this.headUnit).append("-").append(this.type).append("-").append(this.features).append("-").append(this.region).append("-").append(this.brand).append("-").append(this.topology).toString();
    }
}

