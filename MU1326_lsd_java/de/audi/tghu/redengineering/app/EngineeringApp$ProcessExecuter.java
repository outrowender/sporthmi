/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.redengineering.app;

import de.audi.tghu.redengineering.app.EngineeringApp;
import de.audi.tghu.redengineering.app.EngineeringApp$ProcessReader;
import java.io.IOException;

class EngineeringApp$ProcessExecuter
implements Runnable {
    private final String command;
    private final /* synthetic */ EngineeringApp this$0;

    public EngineeringApp$ProcessExecuter(EngineeringApp engineeringApp, String string) {
        this.this$0 = engineeringApp;
        this.command = string;
    }

    @Override
    public void run() {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec(this.command);
            Thread thread = new Thread(new EngineeringApp$ProcessReader(this.this$0, process, true));
            thread.start();
            Thread thread2 = new Thread(new EngineeringApp$ProcessReader(this.this$0, process, false));
            thread2.start();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
}

