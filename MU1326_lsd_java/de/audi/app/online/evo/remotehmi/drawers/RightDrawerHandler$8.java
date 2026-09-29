/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.remotehmi.drawers;

import de.audi.app.online.evo.remotehmi.drawers.RightDrawerHandler;
import de.audi.atip.interapp.PortalAuthenticationService;
import de.audi.remotehmi.textconstants.ITextConstantsConverter;
import de.audi.remotehmi.textconstants.TextConstantUtil;
import de.audi.tghu.online.app.remotehmi.I18NTextComponent;

class RightDrawerHandler$8
implements ITextConstantsConverter {
    private final /* synthetic */ RightDrawerHandler this$0;

    RightDrawerHandler$8(RightDrawerHandler rightDrawerHandler) {
        this.this$0 = rightDrawerHandler;
    }

    @Override
    public String getText(String string) {
        I18NTextComponent i18NTextComponent = (I18NTextComponent)RightDrawerHandler.access$900(this.this$0).getI18NTextComponent();
        PortalAuthenticationService portalAuthenticationService = RightDrawerHandler.access$900(this.this$0).getAuthenticationService();
        if (portalAuthenticationService == null) {
            return i18NTextComponent.getText(TextConstantUtil.REMOTEHMI_TEXT_LOGIN);
        }
        boolean bl = RightDrawerHandler.access$900(this.this$0).getAuthenticationService().isAuthenticated();
        String string2 = bl ? TextConstantUtil.REMOTEHMI_TEXT_LOGOFF : TextConstantUtil.REMOTEHMI_TEXT_LOGIN;
        return i18NTextComponent.getText(string2);
    }
}

