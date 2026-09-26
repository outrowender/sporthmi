/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.disambiguation;

import de.audi.tghu.navi.app.addressinput.asia.DisambiguatedNavLocation;
import de.audi.tghu.navi.app.di.sequences.disambiguation.LocationDisambiguationWrapper;
import de.audi.tghu.navi.app.di.sequences.disambiguation.LocationDisambiguationWrapper$LocationDisambiguationWrapperActionStep;
import de.audi.tghu.navi.app.di.sequences.disambiguation.LocationDisambiguationWrapper$LocationDisambiguationWrapperBuildStep;
import de.audi.tghu.navi.app.di.sequences.disambiguation.LocationDisambiguationWrapper$LocationDisambiguationWrapperFirstStep;
import de.audi.tghu.navi.app.di.sequences.disambiguation.LocationDisambiguationWrapper$LocationDisambiguationWrapperModelIdStep;
import de.audi.tghu.navi.app.di.sequences.disambiguation.LocationDisambiguationWrapper$LocationDisambiguationWrapperTerminalIdStep;

public class LocationDisambiguationWrapper$LocationDisambiguationWrapperSteps
implements LocationDisambiguationWrapper$LocationDisambiguationWrapperFirstStep,
LocationDisambiguationWrapper$LocationDisambiguationWrapperActionStep,
LocationDisambiguationWrapper$LocationDisambiguationWrapperModelIdStep,
LocationDisambiguationWrapper$LocationDisambiguationWrapperTerminalIdStep,
LocationDisambiguationWrapper$LocationDisambiguationWrapperBuildStep {
    private int action;
    private int modelId;
    private int terminalId;
    private DisambiguatedNavLocation[] locations;

    @Override
    public LocationDisambiguationWrapper build() {
        LocationDisambiguationWrapper locationDisambiguationWrapper = new LocationDisambiguationWrapper();
        LocationDisambiguationWrapper.access$100(locationDisambiguationWrapper, this.action);
        LocationDisambiguationWrapper.access$200(locationDisambiguationWrapper, this.modelId);
        LocationDisambiguationWrapper.access$300(locationDisambiguationWrapper, this.terminalId);
        LocationDisambiguationWrapper.access$400(locationDisambiguationWrapper, this.locations);
        return locationDisambiguationWrapper;
    }

    @Override
    public LocationDisambiguationWrapper$LocationDisambiguationWrapperBuildStep addTerminalId(int n) {
        this.terminalId = n;
        return this;
    }

    @Override
    public LocationDisambiguationWrapper$LocationDisambiguationWrapperBuildStep useDefaultTerminal() {
        this.terminalId = 0;
        return this;
    }

    @Override
    public LocationDisambiguationWrapper$LocationDisambiguationWrapperTerminalIdStep addModelId(int n) {
        this.modelId = n;
        return this;
    }

    @Override
    public LocationDisambiguationWrapper$LocationDisambiguationWrapperTerminalIdStep skipModelId() {
        this.modelId = -1;
        return this;
    }

    @Override
    public LocationDisambiguationWrapper$LocationDisambiguationWrapperModelIdStep addAction(int n) {
        this.action = n;
        return this;
    }

    @Override
    public LocationDisambiguationWrapper$LocationDisambiguationWrapperActionStep addDisambiguatedLocations(DisambiguatedNavLocation[] disambiguatedNavLocationArray) {
        if (disambiguatedNavLocationArray == null || disambiguatedNavLocationArray.length == 0) {
            throw new IllegalArgumentException("DisambiguatedNavLocation array must not be null or empty!");
        }
        this.locations = disambiguatedNavLocationArray;
        return this;
    }
}

