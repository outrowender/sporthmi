.version 50 0 
.class super [87] 
.super [89] 
.implements [91] 
.field private final synthetic [92] [93] 
.field private final synthetic [94] [95] 

.method [97] : [98] 
    .attribute [96] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [18] 
L5:     aload_0 
L6:     aload_2 
L7:     putfield [19] 
L10:    aload_0 
L11:    invokespecial [17] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [99] : [100] 
    .attribute [96] .code stack 2 locals 2 
L0:     aconst_null 
L1:     astore_2 
        .catch [4] from L2 to L32 using L46 
L2:     aload_0 
L3:     getfield [14] 
L6:     aload_1 
L7:     invokeinterface [20] 0 
L12:    astore_2 
L13:    aload_2 
L14:    instanceof [2] 
L17:    ifeq L33 
L20:    aload_0 
L21:    getfield [13] 
L24:    aload_2 
L25:    checkcast [2] 
L28:    invokestatic [3] 
L31:    aload_2 
L32:    areturn 
        .catch [4] from L33 to L45 using L46 
L33:    aload_0 
L34:    getfield [14] 
L37:    aload_1 
L38:    invokeinterface [21] 0 
L43:    pop 
L44:    aconst_null 
L45:    areturn 
L46:    astore_3 
L47:    aload_2 
L48:    ifnull L62 
L51:    aload_0 
L52:    getfield [14] 
L55:    aload_1 
L56:    invokeinterface [21] 0 
L61:    pop 
L62:    aconst_null 
L63:    areturn 
L64:    
    .end code 
.end method 

.method public enum [101] : [102] 
    .attribute [96] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [103] : [104] 
    .attribute [96] .code stack 4 locals 1 
        .catch [4] from L0 to L29 using L32 
L0:     aload_0 
L1:     getfield [14] 
L4:     aload_1 
L5:     invokeinterface [21] 0 
L10:    pop 
L11:    aload_2 
L12:    instanceof [2] 
L15:    ifeq L29 
L18:    aload_0 
L19:    getfield [13] 
L22:    aload_2 
L23:    checkcast [2] 
L26:    invokevirtual [15] 
L29:    goto L46 
L32:    astore_3 
L33:    getstatic [5] 
L36:    sipush 10000 
L39:    ldc [6] 
L41:    aload_3 
L42:    invokevirtual [16] 
L45:    pop 
L46:    return 
L47:    nop 
L48:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [22] 
.const [3] = Method [23] [24] 
.const [4] = Class [25] 
.const [5] = Field [26] [27] 
.const [6] = String [28] 
.const [7] = Class [29] 
.const [8] = Class [30] 
.const [9] = Class [31] 
.const [10] = Class [32] 
.const [11] = Class [33] 
.const [12] = Class [34] 
.const [13] = Field [35] [36] 
.const [14] = Field [37] [38] 
.const [15] = Method [39] [40] 
.const [16] = Method [41] [42] 
.const [17] = Method [43] [44] 
.const [18] = Field [45] [46] 
.const [19] = Field [47] [48] 
.const [20] = InterfaceMethod [49] [50] 
.const [21] = InterfaceMethod [51] [52] 
.const [22] = Utf8 de/audi/atip/preset/IAppPresetExecutionHandler 
.const [23] = Class [53] 
.const [24] = NameAndType [54] [55] 
.const [25] = Utf8 java/lang/Exception 
.const [26] = Class [56] 
.const [27] = NameAndType [57] [58] 
.const [28] = Utf8 'PresetExecutionHandlerRegistry#ServiceTracker#removedService %1' 
.const [29] = Utf8 de/eso/widgets/preset/PresetExecutionHandlerRegistry$1 
.const [30] = Utf8 java/lang/Object 
.const [31] = Utf8 org/osgi/framework/BundleContext 
.const [32] = Utf8 de/eso/widgets/preset/PresetExecutionHandlerRegistry 
.const [33] = Utf8 de/esolutions/hmi/widgets/audi/base/IWidgetLogChannel 
.const [34] = Utf8 de/audi/atip/log/LogChannel 
.const [35] = Class [59] 
.const [36] = NameAndType [60] [61] 
.const [37] = Class [62] 
.const [38] = NameAndType [63] [64] 
.const [39] = Class [65] 
.const [40] = NameAndType [66] [67] 
.const [41] = Class [68] 
.const [42] = NameAndType [69] [70] 
.const [43] = Class [71] 
.const [44] = NameAndType [72] [73] 
.const [45] = Class [74] 
.const [46] = NameAndType [75] [76] 
.const [47] = Class [77] 
.const [48] = NameAndType [78] [79] 
.const [49] = Class [80] 
.const [50] = NameAndType [81] [82] 
.const [51] = Class [83] 
.const [52] = NameAndType [84] [85] 
.const [53] = Utf8 de/eso/widgets/preset/PresetExecutionHandlerRegistry 
.const [54] = Utf8 access$000 
.const [55] = Utf8 (Lde/eso/widgets/preset/PresetExecutionHandlerRegistry;Lde/audi/atip/preset/IAppPresetExecutionHandler;)V 
.const [56] = Utf8 de/esolutions/hmi/widgets/audi/base/IWidgetLogChannel 
.const [57] = Utf8 logPreset 
.const [58] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [59] = Utf8 de/eso/widgets/preset/PresetExecutionHandlerRegistry$1 
.const [60] = Utf8 this$0 
.const [61] = Utf8 Lde/eso/widgets/preset/PresetExecutionHandlerRegistry; 
.const [62] = Utf8 de/eso/widgets/preset/PresetExecutionHandlerRegistry$1 
.const [63] = Utf8 val$context 
.const [64] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [65] = Utf8 de/eso/widgets/preset/PresetExecutionHandlerRegistry 
.const [66] = Utf8 unregisterExecutionHandler 
.const [67] = Utf8 (Lde/audi/atip/preset/IAppPresetExecutionHandler;)V 
.const [68] = Utf8 de/audi/atip/log/LogChannel 
.const [69] = Utf8 log 
.const [70] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [71] = Utf8 java/lang/Object 
.const [72] = Utf8 <init> 
.const [73] = Utf8 ()V 
.const [74] = Utf8 de/eso/widgets/preset/PresetExecutionHandlerRegistry$1 
.const [75] = Utf8 this$0 
.const [76] = Utf8 Lde/eso/widgets/preset/PresetExecutionHandlerRegistry; 
.const [77] = Utf8 de/eso/widgets/preset/PresetExecutionHandlerRegistry$1 
.const [78] = Utf8 val$context 
.const [79] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [80] = Utf8 org/osgi/framework/BundleContext 
.const [81] = Utf8 getService 
.const [82] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [83] = Utf8 org/osgi/framework/BundleContext 
.const [84] = Utf8 ungetService 
.const [85] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [86] = Utf8 de/eso/widgets/preset/PresetExecutionHandlerRegistry$1 
.const [87] = Class [86] 
.const [88] = Utf8 java/lang/Object 
.const [89] = Class [88] 
.const [90] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [91] = Class [90] 
.const [92] = Utf8 val$context 
.const [93] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [94] = Utf8 this$0 
.const [95] = Utf8 Lde/eso/widgets/preset/PresetExecutionHandlerRegistry; 
.const [96] = Utf8 Code 
.const [97] = Utf8 <init> 
.const [98] = Utf8 (Lde/eso/widgets/preset/PresetExecutionHandlerRegistry;Lorg/osgi/framework/BundleContext;)V 
.const [99] = Utf8 addingService 
.const [100] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [101] = Utf8 modifiedService 
.const [102] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [103] = Utf8 removedService 
.const [104] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.end class 
