/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.core;

import de.audi.app.connectivity.core.IApplication;
import de.audi.app.connectivity.core.IApplicationComponent;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.hmi.modelaccess.TextfieldModelApp;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;

public abstract class AbstractApplicationComponent
implements IApplicationComponent {
    protected final BundleContext bundleContext;
    protected final LogChannel log;
    private final IHMIServiceApp hmiService;

    protected AbstractApplicationComponent(IApplication iApplication) {
        this.bundleContext = iApplication.getBundleContext();
        this.log = iApplication.getLogChannel();
        this.hmiService = iApplication.getFramework().getHmiServiceApp();
    }

    protected BaseListModelApp getBaseListModel(int n) {
        return this.hmiService.getBaseListModel(n);
    }

    protected ButtonModelApp getButtonModel(int n) {
        return this.hmiService.getButtonModel(n);
    }

    protected ChoiceModelApp getChoiceModel(int n) {
        return this.hmiService.getChoiceModel(n);
    }

    protected LabelModelApp getLabelModel(int n) {
        return this.hmiService.getLabelModel(n);
    }

    protected MetricsModelApp getMetricsModel(int n) {
        return this.hmiService.getMetricsModel(n);
    }

    protected SpellerModelApp getSpellerModel(int n) {
        return this.hmiService.getSpellerModel(n);
    }

    protected TextfieldModelApp getTextfieldModel(int n) {
        return this.hmiService.getTextfieldModel(n);
    }
}

