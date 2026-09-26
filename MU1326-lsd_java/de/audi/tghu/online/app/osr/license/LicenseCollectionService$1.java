/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.license;

import java.util.HashMap;

final class LicenseCollectionService$1
extends HashMap {
    LicenseCollectionService$1() {
        this.put("poi_haptic", "service_dsi_poi");
        this.put("poi_sds", "service_dsi_poi");
        this.put("zieleinspeisung", "service_dsi_destimport");
        this.put("dictation", "dictation");
        this.put("lic_traffic", "service_dsi_onlinetraffic");
        this.put("trafficlightsinfo_v1", "service_trafficlight");
        this.put("weatherGrid", "weatherinmaponlineservice");
        this.put("satellitemaps", "service_dsi_satellitemaps");
        this.put("satellitemaps_eb", "ebnav");
        this.put("satellitemaps", "awnavicore");
        this.put("poicall", "service_dsi_operatorcall");
        this.put("breakdowncall", "service_dsi_operatorcall");
        this.put("service_picnav", "service_picnav");
        this.put("hotspotwlan", "hotspotwlan");
        this.put("esim", "service_core");
        this.put("gracenote", "online_metadata_service_app");
        this.put("lic_uota_ppoi", "UpdateOverTheAir");
        this.put("lic_uota_nav", "UpdateOverTheAir");
    }
}

