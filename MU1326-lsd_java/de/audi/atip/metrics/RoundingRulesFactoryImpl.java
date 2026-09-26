/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.metrics;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.metrics.DistanceRoundingRulesCommon;
import de.audi.atip.metrics.DistanceRoundingRulesCommonNar;
import de.audi.atip.metrics.DistanceRoundingRulesPorsche;
import de.audi.atip.metrics.DistanceRoundingRulesPorscheNar;
import de.audi.atip.metrics.RoundingRules;
import de.audi.atip.metrics.RoundingRulesFactory;
import de.audi.atip.metrics.ZoomRoundingRulesCommon;
import de.audi.atip.metrics.ZoomRoundingRulesCommonNar;
import de.audi.atip.metrics.ZoomRoundingRulesPorscheAsia;
import de.audi.atip.metrics.ZoomRoundingRulesPorscheEceRow;
import de.audi.atip.metrics.ZoomRoundingRulesPorscheNar;

public class RoundingRulesFactoryImpl
implements RoundingRulesFactory {
    private static RoundingRulesFactoryImpl instance = null;
    private static StringBuffer diagnosisInformation = new StringBuffer("-not initialized-");
    private final RoundingRules zoomRoundingRules;
    private final RoundingRules distanceRoundingRules;

    public static synchronized RoundingRulesFactory getInstance(IFrameworkAccess iFrameworkAccess) {
        if (instance == null) {
            instance = new RoundingRulesFactoryImpl(iFrameworkAccess);
        }
        return instance;
    }

    public static void reset() {
        instance = null;
    }

    private RoundingRulesFactoryImpl(IFrameworkAccess iFrameworkAccess) {
        diagnosisInformation = new StringBuffer(158);
        if (iFrameworkAccess == null) {
            this.zoomRoundingRules = new ZoomRoundingRulesCommon();
            this.distanceRoundingRules = new DistanceRoundingRulesCommon();
            diagnosisInformation.append("framework == null\nZoomRules --> ZoomRoundingRulesCommon\nDistanceRules --> DistanceRoundingRulesCommon\n");
            return;
        }
        if (!iFrameworkAccess.isPorsche()) {
            diagnosisInformation.append("isPorsche == false\n");
            if (iFrameworkAccess.isNar()) {
                this.zoomRoundingRules = new ZoomRoundingRulesCommonNar();
                diagnosisInformation.append("isNar == true\nZoomRules --> ZoomRoundingRulesCommonNar\n");
            } else {
                this.zoomRoundingRules = new ZoomRoundingRulesCommon();
                diagnosisInformation.append("isNar == false\nZoomRules --> ZoomRoundingRulesCommon\n");
            }
        } else {
            diagnosisInformation.append("isPorsche == true\n");
            if (iFrameworkAccess.isNar()) {
                this.zoomRoundingRules = new ZoomRoundingRulesPorscheNar();
                diagnosisInformation.append("isNar == true\nZoomRules --> ZoomRoundingRulesPorscheNar\n");
            } else if (iFrameworkAccess.isAsia()) {
                this.zoomRoundingRules = new ZoomRoundingRulesPorscheAsia();
                diagnosisInformation.append("isAsia == true\nZoomRules --> ZoomRoundingRulesPorscheAsia\n");
            } else {
                this.zoomRoundingRules = new ZoomRoundingRulesPorscheEceRow();
                diagnosisInformation.append("isNar / isAsia == false\nZoomRules --> ZoomRoundingRulesPorscheEceRow\n");
            }
        }
        if (!iFrameworkAccess.isPorsche()) {
            if (iFrameworkAccess.isNar()) {
                this.distanceRoundingRules = new DistanceRoundingRulesCommonNar();
                diagnosisInformation.append("DistanceRules --> DistanceRoundingRulesCommonNar\n");
            } else {
                this.distanceRoundingRules = new DistanceRoundingRulesCommon();
                diagnosisInformation.append("DistanceRules --> DistanceRoundingRulesCommon\n");
            }
        } else if (iFrameworkAccess.isNar()) {
            this.distanceRoundingRules = new DistanceRoundingRulesPorscheNar();
            diagnosisInformation.append("DistanceRules --> DistanceRoundingRulesPorscheNar\n");
        } else {
            this.distanceRoundingRules = new DistanceRoundingRulesPorsche();
            diagnosisInformation.append("DistanceRules --> DistanceRoundingRulesPorsche\n");
        }
    }

    @Override
    public RoundingRules getZoomRoundingRules() {
        return this.zoomRoundingRules;
    }

    @Override
    public RoundingRules getDistanceRoundingRules() {
        return this.distanceRoundingRules;
    }

    @Override
    public String getDiagnosisData() {
        return diagnosisInformation.toString();
    }
}

