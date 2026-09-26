.version 50 0 
.class super [123] 
.super [125] 
.implements [127] 
.field private final synthetic [128] [129] 
.field private final synthetic [130] [131] 

.method [133] : [134] 
    .attribute [132] .code stack 2 locals 0 
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

.method public [135] : [136] 
    .attribute [132] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [18] 
L4:     invokestatic [2] 
L7:     aload_1 
L8:     invokeinterface [26] 0 
L13:    astore_2 
L14:    aload_2 
L15:    instanceof [3] 
L18:    ifeq L84 
        .catch [6] from L21 to L49 using L50 
L21:    aload_0 
L22:    getfield [19] 
L25:    aload_2 
L26:    checkcast [3] 
L29:    aload_0 
L30:    getfield [18] 
L33:    aload_1 
L34:    invokestatic [4] 
L37:    aload_0 
L38:    getfield [18] 
L41:    aload_1 
L42:    invokestatic [5] 
L45:    invokevirtual [20] 
L48:    aload_2 
L49:    areturn 
L50:    astore_3 
L51:    aload_0 
L52:    getfield [18] 
L55:    invokestatic [7] 
L58:    aload_1 
L59:    invokeinterface [27] 0 
L64:    pop 
L65:    aload_0 
L66:    getfield [18] 
L69:    invokestatic [8] 
L72:    sipush 10000 
L75:    ldc [9] 
L77:    aload_1 
L78:    invokevirtual [21] 
L81:    pop 
L82:    aconst_null 
L83:    areturn 
L84:    aload_0 
L85:    getfield [18] 
L88:    invokestatic [10] 
L91:    aload_1 
L92:    invokeinterface [27] 0 
L97:    pop 
L98:    aconst_null 
L99:    areturn 
L100:   
    .end code 
.end method 

.method public enum [137] : [138] 
    .attribute [132] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [139] : [140] 
    .attribute [132] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     invokestatic [11] 
L7:     aload_1 
L8:     invokeinterface [27] 0 
L13:    pop 
L14:    aload_0 
L15:    getfield [19] 
L18:    aload_2 
L19:    checkcast [3] 
L22:    aload_0 
L23:    getfield [18] 
L26:    aload_1 
L27:    invokestatic [4] 
L30:    aload_0 
L31:    getfield [18] 
L34:    aload_1 
L35:    invokestatic [5] 
L38:    invokevirtual [22] 
L41:    return 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [28] [29] 
.const [3] = Class [30] 
.const [4] = Method [31] [32] 
.const [5] = Method [33] [34] 
.const [6] = Class [35] 
.const [7] = Method [36] [37] 
.const [8] = Method [38] [39] 
.const [9] = String [40] 
.const [10] = Method [41] [42] 
.const [11] = Method [43] [44] 
.const [12] = Class [45] 
.const [13] = Class [46] 
.const [14] = Class [47] 
.const [15] = Class [48] 
.const [16] = Class [49] 
.const [17] = Class [50] 
.const [18] = Field [51] [52] 
.const [19] = Field [53] [54] 
.const [20] = Method [55] [56] 
.const [21] = Method [57] [58] 
.const [22] = Method [59] [60] 
.const [23] = Method [61] [62] 
.const [24] = Field [63] [64] 
.const [25] = Field [65] [66] 
.const [26] = InterfaceMethod [67] [68] 
.const [27] = InterfaceMethod [69] [70] 
.const [28] = Class [71] 
.const [29] = NameAndType [72] [73] 
.const [30] = Utf8 org/dsi/ifc/base/DSIBase 
.const [31] = Class [74] 
.const [32] = NameAndType [75] [76] 
.const [33] = Class [77] 
.const [34] = NameAndType [78] [79] 
.const [35] = Utf8 java/lang/Exception 
.const [36] = Class [80] 
.const [37] = NameAndType [81] [82] 
.const [38] = Class [83] 
.const [39] = NameAndType [84] [85] 
.const [40] = Utf8 'Incorrect property DEVICE_INSTANCE for a DSI reference %1' 
.const [41] = Class [86] 
.const [42] = NameAndType [87] [88] 
.const [43] = Class [89] 
.const [44] = NameAndType [90] [91] 
.const [45] = Utf8 de/audi/tghu/jdsi/JDSIActivator$2 
.const [46] = Utf8 java/lang/Object 
.const [47] = Utf8 de/audi/tghu/jdsi/JDSIActivator 
.const [48] = Utf8 org/osgi/framework/BundleContext 
.const [49] = Utf8 de/audi/tghu/jdsi/JDSIManager 
.const [50] = Utf8 de/audi/atip/log/LogChannel 
.const [51] = Class [92] 
.const [52] = NameAndType [93] [94] 
.const [53] = Class [95] 
.const [54] = NameAndType [96] [97] 
.const [55] = Class [98] 
.const [56] = NameAndType [99] [100] 
.const [57] = Class [101] 
.const [58] = NameAndType [102] [103] 
.const [59] = Class [104] 
.const [60] = NameAndType [105] [106] 
.const [61] = Class [107] 
.const [62] = NameAndType [108] [109] 
.const [63] = Class [110] 
.const [64] = NameAndType [111] [112] 
.const [65] = Class [113] 
.const [66] = NameAndType [114] [115] 
.const [67] = Class [116] 
.const [68] = NameAndType [117] [118] 
.const [69] = Class [119] 
.const [70] = NameAndType [120] [121] 
.const [71] = Utf8 de/audi/tghu/jdsi/JDSIActivator 
.const [72] = Utf8 access$500 
.const [73] = Utf8 (Lde/audi/tghu/jdsi/JDSIActivator;)Lorg/osgi/framework/BundleContext; 
.const [74] = Utf8 de/audi/tghu/jdsi/JDSIActivator 
.const [75] = Utf8 access$600 
.const [76] = Utf8 (Lde/audi/tghu/jdsi/JDSIActivator;Lorg/osgi/framework/ServiceReference;)Ljava/lang/String; 
.const [77] = Utf8 de/audi/tghu/jdsi/JDSIActivator 
.const [78] = Utf8 access$700 
.const [79] = Utf8 (Lde/audi/tghu/jdsi/JDSIActivator;Lorg/osgi/framework/ServiceReference;)I 
.const [80] = Utf8 de/audi/tghu/jdsi/JDSIActivator 
.const [81] = Utf8 access$800 
.const [82] = Utf8 (Lde/audi/tghu/jdsi/JDSIActivator;)Lorg/osgi/framework/BundleContext; 
.const [83] = Utf8 de/audi/tghu/jdsi/JDSIActivator 
.const [84] = Utf8 access$900 
.const [85] = Utf8 (Lde/audi/tghu/jdsi/JDSIActivator;)Lde/audi/atip/log/LogChannel; 
.const [86] = Utf8 de/audi/tghu/jdsi/JDSIActivator 
.const [87] = Utf8 access$1000 
.const [88] = Utf8 (Lde/audi/tghu/jdsi/JDSIActivator;)Lorg/osgi/framework/BundleContext; 
.const [89] = Utf8 de/audi/tghu/jdsi/JDSIActivator 
.const [90] = Utf8 access$1100 
.const [91] = Utf8 (Lde/audi/tghu/jdsi/JDSIActivator;)Lorg/osgi/framework/BundleContext; 
.const [92] = Utf8 de/audi/tghu/jdsi/JDSIActivator$2 
.const [93] = Utf8 this$0 
.const [94] = Utf8 Lde/audi/tghu/jdsi/JDSIActivator; 
.const [95] = Utf8 de/audi/tghu/jdsi/JDSIActivator$2 
.const [96] = Utf8 val$manager 
.const [97] = Utf8 Lde/audi/tghu/jdsi/JDSIManager; 
.const [98] = Utf8 de/audi/tghu/jdsi/JDSIManager 
.const [99] = Utf8 addDSIService 
.const [100] = Utf8 (Lorg/dsi/ifc/base/DSIBase;Ljava/lang/String;I)V 
.const [101] = Utf8 de/audi/atip/log/LogChannel 
.const [102] = Utf8 log 
.const [103] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [104] = Utf8 de/audi/tghu/jdsi/JDSIManager 
.const [105] = Utf8 removedDSIService 
.const [106] = Utf8 (Lorg/dsi/ifc/base/DSIBase;Ljava/lang/String;I)V 
.const [107] = Utf8 java/lang/Object 
.const [108] = Utf8 <init> 
.const [109] = Utf8 ()V 
.const [110] = Utf8 de/audi/tghu/jdsi/JDSIActivator$2 
.const [111] = Utf8 this$0 
.const [112] = Utf8 Lde/audi/tghu/jdsi/JDSIActivator; 
.const [113] = Utf8 de/audi/tghu/jdsi/JDSIActivator$2 
.const [114] = Utf8 val$manager 
.const [115] = Utf8 Lde/audi/tghu/jdsi/JDSIManager; 
.const [116] = Utf8 org/osgi/framework/BundleContext 
.const [117] = Utf8 getService 
.const [118] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [119] = Utf8 org/osgi/framework/BundleContext 
.const [120] = Utf8 ungetService 
.const [121] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [122] = Utf8 de/audi/tghu/jdsi/JDSIActivator$2 
.const [123] = Class [122] 
.const [124] = Utf8 java/lang/Object 
.const [125] = Class [124] 
.const [126] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [127] = Class [126] 
.const [128] = Utf8 val$manager 
.const [129] = Utf8 Lde/audi/tghu/jdsi/JDSIManager; 
.const [130] = Utf8 this$0 
.const [131] = Utf8 Lde/audi/tghu/jdsi/JDSIActivator; 
.const [132] = Utf8 Code 
.const [133] = Utf8 <init> 
.const [134] = Utf8 (Lde/audi/tghu/jdsi/JDSIActivator;Lde/audi/tghu/jdsi/JDSIManager;)V 
.const [135] = Utf8 addingService 
.const [136] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [137] = Utf8 modifiedService 
.const [138] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [139] = Utf8 removedService 
.const [140] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.end class 
