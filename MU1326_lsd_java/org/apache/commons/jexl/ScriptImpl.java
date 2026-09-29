/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl;

import org.apache.commons.jexl.JexlContext;
import org.apache.commons.jexl.Script;
import org.apache.commons.jexl.parser.ASTJexlScript;

class ScriptImpl
implements Script {
    private final String text;
    private final ASTJexlScript parsedScript;

    public ScriptImpl(String string, ASTJexlScript aSTJexlScript) {
        this.text = string;
        this.parsedScript = aSTJexlScript;
    }

    @Override
    public Object execute(JexlContext jexlContext) {
        return this.parsedScript.value(jexlContext);
    }

    @Override
    public String getText() {
        return this.text;
    }
}

