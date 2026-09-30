/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.atip.utils.reactive.properties.PropertyFactory;
import de.audi.tv.app.SourceManager;
import de.audi.tv.app.TVSpeedDisclaimer;
import de.audi.tv.app.audio.AudioFocusClient;
import de.audi.tv.app.base.TVEventDispatcher;
import de.audi.tv.app.dsi.DsiProperties;
import de.audi.tv.app.settings.TVSettings;
import de.audi.tv.app.settings.parental.ChildlockProperties;
import de.audi.tv.app.tm.handling.DisplayContextHandler;
import de.audi.tv.app.tm.handling.DisplayManagerHandler;
import de.audi.tv.app.tm.handling.DisplayModeHandler;
import de.audi.tv.app.tm.handling.TerminalAndScreenModeHandler;

public class PropertyBank {
    public final TerminalAndScreenModeHandler.Properties terminalMode;
    public final DisplayManagerHandler.Properties dmComponent;
    public final SourceManager.Properties source;
    public final DisplayModeHandler.Properties displayMode;
    public final TVSettings.Properties settings;
    public final DsiProperties.Properties dsiProperties;
    public final DisplayContextHandler.Properties displayContext;
    public final TVSpeedDisclaimer.Properties speedDisclaimer;
    public final ChildlockProperties.Properties childlock;
    public final TVEventDispatcher.Properties eventDispatcher;
    public final AudioFocusClient.Properties audioFocus;

    public PropertyBank(PropertyFactory propertyFactory) {
        this.terminalMode = new TerminalAndScreenModeHandler.Properties(propertyFactory);
        this.dmComponent = new DisplayManagerHandler.Properties(propertyFactory);
        this.source = new SourceManager.Properties(propertyFactory);
        this.displayMode = new DisplayModeHandler.Properties(propertyFactory);
        this.settings = new TVSettings.Properties(propertyFactory);
        this.dsiProperties = new DsiProperties.Properties(propertyFactory);
        this.displayContext = new DisplayContextHandler.Properties(propertyFactory);
        this.speedDisclaimer = new TVSpeedDisclaimer.Properties(propertyFactory);
        this.childlock = new ChildlockProperties.Properties(propertyFactory);
        this.eventDispatcher = new TVEventDispatcher.Properties(propertyFactory);
        this.audioFocus = new AudioFocusClient.Properties(propertyFactory);
    }
}

