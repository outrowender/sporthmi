.version 50 0 
.class public super [43] 
.super [45] 

.method protected annotation [47] : [48] 
    .attribute [46] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [8] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [49] : [50] 
    .attribute [46] .code stack 2 locals 3 
L0:     aload_0 
L1:     getfield [7] 
L4:     invokeinterface [9] 0 
L9:     sipush 5583 
L12:    invokeinterface [10] 0 
L17:    invokeinterface [11] 0 
L22:    istore_1 
L23:    aload_0 
L24:    getfield [7] 
L27:    invokeinterface [9] 0 
L32:    sipush 5602 
L35:    invokeinterface [10] 0 
L40:    invokeinterface [11] 0 
L45:    istore_2 
L46:    aload_0 
L47:    getfield [7] 
L50:    invokeinterface [9] 0 
L55:    sipush 5606 
L58:    invokeinterface [10] 0 
L63:    invokeinterface [11] 0 
L68:    istore_3 
L69:    iload_1 
L70:    iconst_1 
L71:    if_icmpne L88 
L74:    iload_2 
L75:    iconst_1 
L76:    if_icmpeq L84 
L79:    iload_3 
L80:    iconst_1 
L81:    if_icmpne L88 
L84:    iconst_1 
L85:    goto L89 
L88:    iconst_0 
L89:    areturn 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [12] 
.const [3] = Class [13] 
.const [4] = Class [14] 
.const [5] = Class [15] 
.const [6] = Class [16] 
.const [7] = Field [17] [18] 
.const [8] = Method [19] [20] 
.const [9] = InterfaceMethod [21] [22] 
.const [10] = InterfaceMethod [23] [24] 
.const [11] = InterfaceMethod [25] [26] 
.const [12] = Utf8 de/audi/app/messaging/core/compose/CoreEditorModeController 
.const [13] = Utf8 de/audi/app/messaging/core/component/AbstractMessagingComponent 
.const [14] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [15] = Utf8 de/audi/atip/hmi/HMIService 
.const [16] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [17] = Class [27] 
.const [18] = NameAndType [28] [29] 
.const [19] = Class [30] 
.const [20] = NameAndType [31] [32] 
.const [21] = Class [33] 
.const [22] = NameAndType [34] [35] 
.const [23] = Class [36] 
.const [24] = NameAndType [37] [38] 
.const [25] = Class [39] 
.const [26] = NameAndType [40] [41] 
.const [27] = Utf8 de/audi/app/messaging/core/compose/CoreEditorModeController 
.const [28] = Utf8 framework 
.const [29] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [30] = Utf8 de/audi/app/messaging/core/component/AbstractMessagingComponent 
.const [31] = Utf8 <init> 
.const [32] = Utf8 (Lde/audi/app/messaging/core/osgi/MessagingBundleContext;Ljava/lang/String;)V 
.const [33] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [34] = Utf8 getHMIService 
.const [35] = Utf8 ()Lde/audi/atip/hmi/HMIService; 
.const [36] = Utf8 de/audi/atip/hmi/HMIService 
.const [37] = Utf8 getChoiceModel 
.const [38] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [39] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [40] = Utf8 getValue 
.const [41] = Utf8 ()I 
.const [42] = Utf8 de/audi/app/messaging/core/compose/CoreEditorModeController 
.const [43] = Class [42] 
.const [44] = Utf8 de/audi/app/messaging/core/component/AbstractMessagingComponent 
.const [45] = Class [44] 
.const [46] = Utf8 Code 
.const [47] = Utf8 <init> 
.const [48] = Utf8 (Lde/audi/app/messaging/core/osgi/MessagingBundleContext;Ljava/lang/String;)V 
.const [49] = Utf8 isLockingAvailable 
.const [50] = Utf8 ()Z 
.end class 
