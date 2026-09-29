/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.disambiguation;

import de.audi.tghu.navi.app.addressinput.asia.DisambiguatedNavLocation;
import de.audi.tghu.navi.app.di.sequences.disambiguation.LocationDisambiguationWrapper$LocationDisambiguationWrapperFirstStep;
import de.audi.tghu.navi.app.di.sequences.disambiguation.LocationDisambiguationWrapper$LocationDisambiguationWrapperSteps;

public class LocationDisambiguationWrapper {
    private int action;
    private int modelId;
    private int terminalId;
    private DisambiguatedNavLocation[] locations;

    private LocationDisambiguationWrapper() {
    }

    public int getAction() {
        return this.action;
    }

    public DisambiguatedNavLocation[] getLocations() {
        return this.locations;
    }

    public int getModelId() {
        return this.modelId;
    }

    public int getTerminalId() {
        return this.terminalId;
    }

    private void setAction(int n) {
        this.action = n;
    }

    private void setLocations(DisambiguatedNavLocation[] disambiguatedNavLocationArray) {
        this.locations = disambiguatedNavLocationArray;
    }

    private void setModelId(int n) {
        this.modelId = n;
    }

    private void setTerminalId(int n) {
        this.terminalId = n;
    }

    public static LocationDisambiguationWrapperFirstStep newBuilder() {
        return new LocationDisambiguationWrapper$LocationDisambiguationWrapperSteps();
    }

    static /* synthetic */ void access$100(LocationDisambiguationWrapper locationDisambiguationWrapper, int n) {
        locationDisambiguationWrapper.setAction(n);
    }

    static /* synthetic */ void access$200(LocationDisambiguationWrapper locationDisambiguationWrapper, int n) {
        locationDisambiguationWrapper.setModelId(n);
    }

    static /* synthetic */ void access$300(LocationDisambiguationWrapper locationDisambiguationWrapper, int n) {
        locationDisambiguationWrapper.setTerminalId(n);
    }

    static /* synthetic */ void access$400(LocationDisambiguationWrapper locationDisambiguationWrapper, DisambiguatedNavLocation[] disambiguatedNavLocationArray) {
        locationDisambiguationWrapper.setLocations(disambiguatedNavLocationArray);
    }
}

