.version 50 0 
.class super [121] 
.super [123] 
.implements [125] 
.field private final synthetic [126] [127] 
.field private final synthetic [128] [129] 

.method [131] : [132] 
    .attribute [130] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [24] 
L5:     aload_0 
L6:     aload_2 
L7:     putfield [25] 
L10:    aload_0 
L11:    invokespecial [23] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [133] : [134] 
    .attribute [130] .code stack 2 locals 2 
L0:     aconst_null 
L1:     astore_2 
        .catch [9] from L2 to L89 using L103 
L2:     aload_0 
L3:     getfield [19] 
L6:     aload_1 
L7:     invokeinterface [26] 0 
L12:    astore_2 
L13:    aload_2 
L14:    instanceof [2] 
L17:    ifeq L90 
L20:    aload_0 
L21:    getfield [18] 
L24:    aload_2 
L25:    checkcast [2] 
L28:    invokevirtual [20] 
L31:    aload_2 
L32:    instanceof [3] 
L35:    ifeq L69 
L38:    aload_0 
L39:    getfield [18] 
L42:    aload_2 
L43:    checkcast [3] 
L46:    invokestatic [4] 
L49:    pop 
L50:    aload_0 
L51:    getfield [18] 
L54:    invokestatic [5] 
L57:    aload_0 
L58:    getfield [18] 
L61:    invokestatic [6] 
L64:    invokeinterface [27] 0 
L69:    aload_2 
L70:    instanceof [7] 
L73:    ifeq L88 
L76:    aload_0 
L77:    getfield [18] 
L80:    aload_2 
L81:    checkcast [7] 
L84:    invokestatic [8] 
L87:    pop 
L88:    aload_2 
L89:    areturn 
        .catch [9] from L90 to L102 using L103 
L90:    aload_0 
L91:    getfield [19] 
L94:    aload_1 
L95:    invokeinterface [28] 0 
L100:   pop 
L101:   aconst_null 
L102:   areturn 
L103:   astore_3 
L104:   aload_2 
L105:   ifnull L119 
L108:   aload_0 
L109:   getfield [19] 
L112:   aload_1 
L113:   invokeinterface [28] 0 
L118:   pop 
L119:   aconst_null 
L120:   areturn 
L121:   nop 
L122:   nop 
L123:   nop 
L124:   
    .end code 
.end method 

.method public enum [135] : [136] 
    .attribute [130] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [137] : [138] 
    .attribute [130] .code stack 4 locals 1 
        .catch [9] from L0 to L45 using L48 
L0:     aload_0 
L1:     getfield [19] 
L4:     aload_1 
L5:     invokeinterface [28] 0 
L10:    pop 
L11:    aload_2 
L12:    instanceof [2] 
L15:    ifeq L45 
L18:    aload_0 
L19:    getfield [18] 
L22:    aload_2 
L23:    checkcast [2] 
L26:    invokevirtual [21] 
L29:    aload_2 
L30:    instanceof [3] 
L33:    ifeq L45 
L36:    aload_0 
L37:    getfield [18] 
L40:    aconst_null 
L41:    invokestatic [4] 
L44:    pop 
L45:    goto L62 
L48:    astore_3 
L49:    getstatic [10] 
L52:    sipush 10000 
L55:    ldc [11] 
L57:    aload_3 
L58:    invokevirtual [22] 
L61:    pop 
L62:    return 
L63:    nop 
L64:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [29] 
.const [3] = Class [30] 
.const [4] = Method [31] [32] 
.const [5] = Method [33] [34] 
.const [6] = Method [35] [36] 
.const [7] = Class [37] 
.const [8] = Method [38] [39] 
.const [9] = Class [40] 
.const [10] = Field [41] [42] 
.const [11] = String [43] 
.const [12] = Class [44] 
.const [13] = Class [45] 
.const [14] = Class [46] 
.const [15] = Class [47] 
.const [16] = Class [48] 
.const [17] = Class [49] 
.const [18] = Field [50] [51] 
.const [19] = Field [52] [53] 
.const [20] = Method [54] [55] 
.const [21] = Method [56] [57] 
.const [22] = Method [58] [59] 
.const [23] = Method [60] [61] 
.const [24] = Field [62] [63] 
.const [25] = Field [64] [65] 
.const [26] = InterfaceMethod [66] [67] 
.const [27] = InterfaceMethod [68] [69] 
.const [28] = InterfaceMethod [70] [71] 
.const [29] = Utf8 de/audi/atip/preset/IAppPresetDefinitionHandler 
.const [30] = Utf8 de/audi/atip/preset/ITunerNARHandler 
.const [31] = Class [72] 
.const [32] = NameAndType [73] [74] 
.const [33] = Class [75] 
.const [34] = NameAndType [76] [77] 
.const [35] = Class [78] 
.const [36] = NameAndType [79] [80] 
.const [37] = Utf8 de/audi/atip/preset/IOnlinePresetHandler 
.const [38] = Class [81] 
.const [39] = NameAndType [82] [83] 
.const [40] = Utf8 java/lang/Exception 
.const [41] = Class [84] 
.const [42] = NameAndType [85] [86] 
.const [43] = Utf8 'PresetDefinitionHandlerRegistry#ServiceTracker#removedService %1' 
.const [44] = Utf8 de/eso/widgets/preset/PresetDefinitionHandlerRegistry$1 
.const [45] = Utf8 java/lang/Object 
.const [46] = Utf8 org/osgi/framework/BundleContext 
.const [47] = Utf8 de/eso/widgets/preset/PresetDefinitionHandlerRegistry 
.const [48] = Utf8 de/esolutions/hmi/widgets/audi/base/IWidgetLogChannel 
.const [49] = Utf8 de/audi/atip/log/LogChannel 
.const [50] = Class [87] 
.const [51] = NameAndType [88] [89] 
.const [52] = Class [90] 
.const [53] = NameAndType [91] [92] 
.const [54] = Class [93] 
.const [55] = NameAndType [94] [95] 
.const [56] = Class [96] 
.const [57] = NameAndType [97] [98] 
.const [58] = Class [99] 
.const [59] = NameAndType [100] [101] 
.const [60] = Class [102] 
.const [61] = NameAndType [103] [104] 
.const [62] = Class [105] 
.const [63] = NameAndType [106] [107] 
.const [64] = Class [108] 
.const [65] = NameAndType [109] [110] 
.const [66] = Class [111] 
.const [67] = NameAndType [112] [113] 
.const [68] = Class [114] 
.const [69] = NameAndType [115] [116] 
.const [70] = Class [117] 
.const [71] = NameAndType [118] [119] 
.const [72] = Utf8 de/eso/widgets/preset/PresetDefinitionHandlerRegistry 
.const [73] = Utf8 access$002 
.const [74] = Utf8 (Lde/eso/widgets/preset/PresetDefinitionHandlerRegistry;Lde/audi/atip/preset/ITunerNARHandler;)Lde/audi/atip/preset/ITunerNARHandler; 
.const [75] = Utf8 de/eso/widgets/preset/PresetDefinitionHandlerRegistry 
.const [76] = Utf8 access$000 
.const [77] = Utf8 (Lde/eso/widgets/preset/PresetDefinitionHandlerRegistry;)Lde/audi/atip/preset/ITunerNARHandler; 
.const [78] = Utf8 de/eso/widgets/preset/PresetDefinitionHandlerRegistry 
.const [79] = Utf8 access$100 
.const [80] = Utf8 (Lde/eso/widgets/preset/PresetDefinitionHandlerRegistry;)Lde/eso/widgets/preset/PresetManager; 
.const [81] = Utf8 de/eso/widgets/preset/PresetDefinitionHandlerRegistry 
.const [82] = Utf8 access$202 
.const [83] = Utf8 (Lde/eso/widgets/preset/PresetDefinitionHandlerRegistry;Lde/audi/atip/preset/IOnlinePresetHandler;)Lde/audi/atip/preset/IOnlinePresetHandler; 
.const [84] = Utf8 de/esolutions/hmi/widgets/audi/base/IWidgetLogChannel 
.const [85] = Utf8 logPreset 
.const [86] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [87] = Utf8 de/eso/widgets/preset/PresetDefinitionHandlerRegistry$1 
.const [88] = Utf8 this$0 
.const [89] = Utf8 Lde/eso/widgets/preset/PresetDefinitionHandlerRegistry; 
.const [90] = Utf8 de/eso/widgets/preset/PresetDefinitionHandlerRegistry$1 
.const [91] = Utf8 val$context 
.const [92] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [93] = Utf8 de/eso/widgets/preset/PresetDefinitionHandlerRegistry 
.const [94] = Utf8 registerPresetDefinitionHandler 
.const [95] = Utf8 (Lde/audi/atip/preset/IAppPresetDefinitionHandler;)V 
.const [96] = Utf8 de/eso/widgets/preset/PresetDefinitionHandlerRegistry 
.const [97] = Utf8 unregisterPresetDefinitionHandler 
.const [98] = Utf8 (Lde/audi/atip/preset/IAppPresetDefinitionHandler;)V 
.const [99] = Utf8 de/audi/atip/log/LogChannel 
.const [100] = Utf8 log 
.const [101] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [102] = Utf8 java/lang/Object 
.const [103] = Utf8 <init> 
.const [104] = Utf8 ()V 
.const [105] = Utf8 de/eso/widgets/preset/PresetDefinitionHandlerRegistry$1 
.const [106] = Utf8 this$0 
.const [107] = Utf8 Lde/eso/widgets/preset/PresetDefinitionHandlerRegistry; 
.const [108] = Utf8 de/eso/widgets/preset/PresetDefinitionHandlerRegistry$1 
.const [109] = Utf8 val$context 
.const [110] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [111] = Utf8 org/osgi/framework/BundleContext 
.const [112] = Utf8 getService 
.const [113] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [114] = Utf8 de/audi/atip/preset/ITunerNARHandler 
.const [115] = Utf8 injectPresetManager 
.const [116] = Utf8 (Lde/audi/atip/preset/IPresetManager;)V 
.const [117] = Utf8 org/osgi/framework/BundleContext 
.const [118] = Utf8 ungetService 
.const [119] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [120] = Utf8 de/eso/widgets/preset/PresetDefinitionHandlerRegistry$1 
.const [121] = Class [120] 
.const [122] = Utf8 java/lang/Object 
.const [123] = Class [122] 
.const [124] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [125] = Class [124] 
.const [126] = Utf8 val$context 
.const [127] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [128] = Utf8 this$0 
.const [129] = Utf8 Lde/eso/widgets/preset/PresetDefinitionHandlerRegistry; 
.const [130] = Utf8 Code 
.const [131] = Utf8 <init> 
.const [132] = Utf8 (Lde/eso/widgets/preset/PresetDefinitionHandlerRegistry;Lorg/osgi/framework/BundleContext;)V 
.const [133] = Utf8 addingService 
.const [134] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [135] = Utf8 modifiedService 
.const [136] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [137] = Utf8 removedService 
.const [138] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.end class 
