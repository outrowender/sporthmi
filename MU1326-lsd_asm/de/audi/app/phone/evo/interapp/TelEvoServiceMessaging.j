.version 50 0 
.class public super [28] 
.super [30] 
.field private static final [31] [32] 
.field private static final [33] [34] 

.method public annotation [36] : [37] 
    .attribute [35] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [7] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [38] : [39] 
    .attribute [35] .code stack 2 locals 1 
L0:     iload_1 
L1:     ifne L8 
L4:     iconst_4 
L5:     goto L10 
L8:     bipush 6 
L10:    istore_2 
L11:    aload_0 
L12:    ldc [2] 
L14:    invokevirtual [6] 
L17:    iload_2 
L18:    invokeinterface [8] 0 
L23:    return 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -1399454720 
.const [3] = Class [9] 
.const [4] = Class [10] 
.const [5] = Class [11] 
.const [6] = Method [12] [13] 
.const [7] = Method [14] [15] 
.const [8] = InterfaceMethod [16] [17] 
.const [9] = Utf8 de/audi/app/phone/evo/interapp/TelEvoServiceMessaging 
.const [10] = Utf8 de/audi/app/phone/core/interapp/TelServiceMessaging 
.const [11] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [12] = Class [18] 
.const [13] = NameAndType [19] [20] 
.const [14] = Class [21] 
.const [15] = NameAndType [22] [23] 
.const [16] = Class [24] 
.const [17] = NameAndType [25] [26] 
.const [18] = Utf8 de/audi/app/phone/evo/interapp/TelEvoServiceMessaging 
.const [19] = Utf8 getChoiceModel 
.const [20] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [21] = Utf8 de/audi/app/phone/core/interapp/TelServiceMessaging 
.const [22] = Utf8 <init> 
.const [23] = Utf8 (Lde/audi/app/phone/core/ITelApplication;)V 
.const [24] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [25] = Utf8 setValue 
.const [26] = Utf8 (I)V 
.const [27] = Utf8 de/audi/app/phone/evo/interapp/TelEvoServiceMessaging 
.const [28] = Class [27] 
.const [29] = Utf8 de/audi/app/phone/core/interapp/TelServiceMessaging 
.const [30] = Class [29] 
.const [31] = Utf8 CONTEXT_SMS 
.const [32] = Utf8 I 
.const [33] = Utf8 CONTEXT_EMAIL 
.const [34] = Utf8 I 
.const [35] = Utf8 Code 
.const [36] = Utf8 <init> 
.const [37] = Utf8 (Lde/audi/app/phone/core/ITelApplication;)V 
.const [38] = Utf8 notifyActiveContextMessaging 
.const [39] = Utf8 (I)V 
.end class 
