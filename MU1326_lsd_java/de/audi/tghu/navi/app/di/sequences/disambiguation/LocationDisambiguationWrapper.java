/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.disambiguation;

import de.audi.tghu.navi.app.addressinput.asia.DisambiguatedNavLocation;

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
        return new LocationDisambiguationWrapperSteps();
    }

    public static class LocationDisambiguationWrapperSteps
    implements LocationDisambiguationWrapperFirstStep,
    LocationDisambiguationWrapperActionStep,
    LocationDisambiguationWrapperModelIdStep,
    LocationDisambiguationWrapperTerminalIdStep,
    LocationDisambiguationWrapperBuildStep {
        private int action;
        private int modelId;
        private int terminalId;
        private DisambiguatedNavLocation[] locations;

        public LocationDisambiguationWrapper build() {
            LocationDisambiguationWrapper locationDisambiguationWrapper = new LocationDisambiguationWrapper();
            locationDisambiguationWrapper.setAction(this.action);
            locationDisambiguationWrapper.setModelId(this.modelId);
            locationDisambiguationWrapper.setTerminalId(this.terminalId);
            locationDisambiguationWrapper.setLocations(this.locations);
            return locationDisambiguationWrapper;
        }

        public LocationDisambiguationWrapperBuildStep addTerminalId(int n) {
            this.terminalId = n;
            return this;
        }

        public LocationDisambiguationWrapperBuildStep useDefaultTerminal() {
            this.terminalId = 0;
            return this;
        }

        public LocationDisambiguationWrapperTerminalIdStep addModelId(int n) {
            this.modelId = n;
            return this;
        }

        public LocationDisambiguationWrapperTerminalIdStep skipModelId() {
            this.modelId = -1;
            return this;
        }

        public LocationDisambiguationWrapperModelIdStep addAction(int n) {
            this.action = n;
            return this;
        }

        public LocationDisambiguationWrapperActionStep addDisambiguatedLocations(DisambiguatedNavLocation[] disambiguatedNavLocationArray) {
            if (disambiguatedNavLocationArray == null || disambiguatedNavLocationArray.length == 0) {
                throw new IllegalArgumentException("DisambiguatedNavLocation array must not be null or empty!");
            }
            this.locations = disambiguatedNavLocationArray;
            return this;
        }
    }

    public static interface LocationDisambiguationWrapperBuildStep {
        public LocationDisambiguationWrapper build();
    }

    public static interface LocationDisambiguationWrapperFirstStep {
        public LocationDisambiguationWrapperActionStep addDisambiguatedLocations(DisambiguatedNavLocation[] var1);
    }

    public static interface LocationDisambiguationWrapperActionStep {
        public LocationDisambiguationWrapperModelIdStep addAction(int var1);
    }

    public static interface LocationDisambiguationWrapperModelIdStep {
        public LocationDisambiguationWrapperTerminalIdStep addModelId(int var1);

        public LocationDisambiguationWrapperTerminalIdStep skipModelId();
    }

    public static interface LocationDisambiguationWrapperTerminalIdStep {
        public LocationDisambiguationWrapperBuildStep addTerminalId(int var1);

        public LocationDisambiguationWrapperBuildStep useDefaultTerminal();
    }
}

