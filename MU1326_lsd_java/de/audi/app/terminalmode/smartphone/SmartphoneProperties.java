/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.smartphone.BTState;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.audi.app.terminalmode.smartphone.SPIServiceState;
import de.audi.atip.utils.reactive.properties.LoggingPropertyFactory;
import de.audi.atip.utils.reactive.properties.Property;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class SmartphoneProperties
implements IDSISmartphoneManager.ISmartphoneProperties {
    private final LoggingPropertyFactory propertyFactory;
    private final Property<Boolean> mainunitPhonecallActive;
    private final Property<Boolean> mainunitHFPPhonecallActive;
    private final Property<Boolean> ecallOnMUActive;
    private final Property<Boolean> mainunitRVCActive;
    private final Property<SPIServiceState> serviceState;
    private final Property<BTState> bluetoothState;

    public SmartphoneProperties(IContext iContext) {
        this.propertyFactory = LoggingPropertyFactory.create(iContext.getLogger().hmi(), 100000000);
        this.mainunitPhonecallActive = this.propertyFactory.createProperty("MainunitPhonecallActive");
        this.mainunitHFPPhonecallActive = this.propertyFactory.createProperty("MainunitHFPPhonecallActive");
        this.mainunitRVCActive = this.propertyFactory.createProperty("MainunitRVCActive", new Boolean(false));
        this.ecallOnMUActive = this.propertyFactory.createProperty("EcallOnMuActive");
        this.serviceState = this.propertyFactory.createProperty("ServiceState");
        this.serviceState.accept(SPIServiceState.NOT_STARTED);
        this.bluetoothState = this.propertyFactory.createProperty("BluethoothState");
    }

    @Override
    public Property<Boolean> getPropertyMUPhonecallActive() {
        return this.mainunitPhonecallActive;
    }

    @Override
    public Property<Boolean> getPropertyMUHFPPhonecallActive() {
        return this.mainunitHFPPhonecallActive;
    }

    @Override
    public Property<Boolean> getPropertyMURVCActive() {
        return this.mainunitRVCActive;
    }

    @Override
    public Property<SPIServiceState> getPropertySPIServiceState() {
        return this.serviceState;
    }

    @Override
    public Property<BTState> getPropertyBluetooth() {
        return this.bluetoothState;
    }
}

