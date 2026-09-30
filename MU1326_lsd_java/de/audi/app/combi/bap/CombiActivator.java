/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap;

import de.audi.app.bap.AbstractBAPApplication;
import de.audi.app.bap.fw.AbstractBAPModule;
import de.audi.app.combi.bap.AbstractCombiActivator;
import de.audi.app.combi.bap.AbstractCombiBAPApplication;
import de.audi.app.combi.bap.CombiBAPApplicationEvo;
import de.audi.app.combi.bap.app.audio.CombiModuleAudio;
import de.audi.app.combi.bap.app.mfl.CombiModuleMFL;
import de.audi.app.combi.bap.app.navi.CombiModuleNavi;
import de.audi.app.combi.bap.app.phone.CombiModulePhone;
import de.audi.app.combi.bap.app.phone2.CombiModulePhone2;
import de.audi.app.combi.bap.functionlists.FunctionListAudioEvo;
import de.audi.app.combi.bap.functionlists.FunctionListMFLEvo;
import de.audi.app.combi.bap.functionlists.FunctionListNaviEvo;
import de.audi.app.combi.bap.functionlists.FunctionListPhone2Evo;
import de.audi.app.combi.bap.functionlists.FunctionListPhoneEvo;
import de.audi.atip.base.IFrameworkAccess;

public class CombiActivator
extends AbstractCombiActivator {
    protected String getApplicationName() {
        return "AppCombiBAPEvo";
    }

    protected AbstractBAPApplication createApplication(IFrameworkAccess iFrameworkAccess) {
        return new CombiBAPApplicationEvo(iFrameworkAccess);
    }

    protected AbstractBAPModule[] createModules(AbstractBAPApplication abstractBAPApplication) {
        AbstractCombiBAPApplication abstractCombiBAPApplication = (AbstractCombiBAPApplication)abstractBAPApplication;
        AbstractBAPModule[] abstractBAPModuleArray = new AbstractBAPModule[]{new CombiModuleAudio(abstractCombiBAPApplication, new FunctionListAudioEvo()), new CombiModuleNavi(abstractCombiBAPApplication, new FunctionListNaviEvo()), new CombiModulePhone(abstractCombiBAPApplication, new FunctionListPhoneEvo()), new CombiModulePhone2(abstractCombiBAPApplication, new FunctionListPhone2Evo()), new CombiModuleMFL(abstractCombiBAPApplication, new FunctionListMFLEvo())};
        return abstractBAPModuleArray;
    }
}

