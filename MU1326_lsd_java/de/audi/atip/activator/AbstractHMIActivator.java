/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.activator;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.hmi.HMIBundle;
import de.audi.atip.hmi.HMIModelBank;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.hmi.view.IDrawerController;
import de.audi.atip.hmi.view.IPartialPopupController;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.i18n.I18NTarget;
import de.audi.atip.i18n.Language;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import org.osgi.framework.BundleContext;

public abstract class AbstractHMIActivator
extends AbstractActivator
implements HMIBundle,
I18NTarget {
    private final int moduleId;
    private final String appName;
    private final String skinName;
    private final HMIModelBank modelBank;
    private AbstractScreenFactory cashedScreenFactory;
    static /* synthetic */ Class class$de$audi$atip$hmi$HMIModelBank;
    static /* synthetic */ Class class$de$audi$atip$hmi$HMIBundle;
    static /* synthetic */ Class class$de$audi$atip$i18n$I18NTarget;

    protected AbstractHMIActivator(int n, String string, String string2) {
        this(n, string, string2, null);
    }

    protected AbstractHMIActivator(int n, String string, String string2, HMIModelBank hMIModelBank) {
        this.moduleId = n;
        this.appName = string;
        this.skinName = string2;
        this.modelBank = hMIModelBank;
    }

    public String getName() {
        return new StringBuffer().append("HMI").append(this.appName).append(this.skinName).toString();
    }

    public void start(BundleContext bundleContext) {
        Hashtable hashtable;
        super.start(bundleContext);
        if (this.modelBank != null) {
            hashtable = new Hashtable();
            hashtable.put("ApplicationName", this.appName);
            hashtable.put("moduleID", new Integer(this.modelBank.getId()));
            this.registerService((class$de$audi$atip$hmi$HMIModelBank == null ? (class$de$audi$atip$hmi$HMIModelBank = AbstractHMIActivator.class$("de.audi.atip.hmi.HMIModelBank")) : class$de$audi$atip$hmi$HMIModelBank).getName(), (Object)this.modelBank, (Dictionary)hashtable);
            this.modelBank.waitForRegistration(this.getFramework());
        }
        hashtable = new Hashtable();
        hashtable.put("ApplicationName", this.appName);
        hashtable.put("Skin", this.getSkin());
        hashtable.put("LANG_COMPONENT_TYPE", "LANG_COMPONENT_HMI");
        this.registerService(new String[]{(class$de$audi$atip$hmi$HMIBundle == null ? (class$de$audi$atip$hmi$HMIBundle = AbstractHMIActivator.class$("de.audi.atip.hmi.HMIBundle")) : class$de$audi$atip$hmi$HMIBundle).getName(), (class$de$audi$atip$i18n$I18NTarget == null ? (class$de$audi$atip$i18n$I18NTarget = AbstractHMIActivator.class$("de.audi.atip.i18n.I18NTarget")) : class$de$audi$atip$i18n$I18NTarget).getName()}, (Object)this, (Dictionary)hashtable);
    }

    public void stop(BundleContext bundleContext) {
        if (this.modelBank != null) {
            this.modelBank.resetAllModelListeners();
        }
        super.stop(bundleContext);
    }

    public String getSkin() {
        return this.skinName;
    }

    public int getId() {
        return this.moduleId;
    }

    protected abstract AbstractScreenFactory getScreenFactory();

    private AbstractScreenFactory getCashedScreenFactory() {
        if (this.cashedScreenFactory == null) {
            this.cashedScreenFactory = this.getScreenFactory();
        }
        return this.cashedScreenFactory;
    }

    public URL getKzbUrlFromClassloader(String string) {
        return this.getCashedScreenFactory().getKzbUrlFromClassloader(string);
    }

    public URL getKzbUrlFromClassloader(int n) {
        return this.getCashedScreenFactory().getKzbUrlFromClassloader(n);
    }

    public URL getImageUrlFromClassloader(int n) {
        return this.getCashedScreenFactory().getImageUrlFromClassloader(n);
    }

    public URL getImageUrlFromClassloader(int n, int n2) {
        return this.getCashedScreenFactory().getImageUrlFromClassloader(n, n2);
    }

    public String getImagePath(int n, int n2) {
        return this.getCashedScreenFactory().getImagePath(n, n2);
    }

    public String getKzbPath(String string) {
        return this.getCashedScreenFactory().getKzbPath(string);
    }

    public String getKzbPath(int n, int n2) {
        return this.getCashedScreenFactory().getKzbPath(n, n2);
    }

    public String getText(int n) {
        return this.getCashedScreenFactory().getText(n);
    }

    public Screen getScreen(int n, int n2) {
        return this.getCashedScreenFactory().getScreen(n, n2);
    }

    public void setLanguage(Language language) {
        this.getCashedScreenFactory().setLanguage(language);
    }

    public IDrawerController[] getSelectionDrawers(int n) {
        return this.getCashedScreenFactory().getSelectionDrawers(n);
    }

    public IDrawerController[] getOptionDrawers(int n) {
        return this.getCashedScreenFactory().getOptionDrawers(n);
    }

    public IDrawerController getEntertainmentDrawer(int n) {
        return this.getCashedScreenFactory().getEntertainmentDrawer(n);
    }

    public List getEntertainmentDrawerContent(int n) {
        Object[] objectArray = this.getCashedScreenFactory().getEntertainmentDrawerContents(n);
        if (objectArray != null && objectArray.length > 0) {
            return Arrays.asList(objectArray);
        }
        return Collections.EMPTY_LIST;
    }

    public IPartialPopupController getPartialPopup(int n, int n2) {
        return this.getScreenFactory().getPartialPopup(n, n2);
    }

    public IPartialPopupController[] getPartialPopupStubs(int n) {
        return this.getScreenFactory().getPartialPopupStubs(n);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

