.version 50 0 
.class public super abstract [135] 
.super [137] 
.implements [139] 
.field private final [140] [141] 
.field private final [142] [143] 

.method public [145] : [146] 
    .attribute [144] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [26] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [30] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [31] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public final [147] : [148] 
    .attribute [144] .code stack 6 locals 3 
L0:     aload_0 
L1:     getfield [20] 
L4:     aload_1 
L5:     invokeinterface [32] 0 
L10:    astore_2 
L11:    aload_0 
L12:    getfield [19] 
L15:    ldc [2] 
L17:    ldc [3] 
L19:    aload_0 
L20:    aload_1 
L21:    invokespecial [27] 
L24:    aload_0 
L25:    aload_2 
L26:    invokespecial [28] 
L29:    invokevirtual [21] 
L32:    iconst_0 
L33:    istore_3 
        .catch [4] from L34 to L42 using L45 
L34:    aload_0 
L35:    aload_1 
L36:    aload_2 
L37:    invokevirtual [22] 
L40:    iconst_1 
L41:    istore_3 
L42:    goto L73 
L45:    astore 4 
L47:    aload_0 
L48:    getfield [19] 
L51:    sipush 10000 
L54:    ldc [5] 
L56:    aload 4 
L58:    invokevirtual [23] 
L61:    pop 
L62:    aload_0 
L63:    getfield [20] 
L66:    aload_1 
L67:    invokeinterface [33] 0 
L72:    pop 
L73:    iload_3 
L74:    ifeq L81 
L77:    aload_2 
L78:    goto L82 
L81:    aconst_null 
L82:    areturn 
L83:    nop 
L84:    
    .end code 
.end method 

.method public final enum [149] : [150] 
    .attribute [144] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public final [151] : [152] 
    .attribute [144] .code stack 6 locals 1 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [6] 
L6:     ldc [7] 
L8:     aload_0 
L9:     aload_1 
L10:    invokespecial [27] 
L13:    aload_0 
L14:    aload_2 
L15:    invokespecial [28] 
L18:    invokevirtual [21] 
        .catch [4] from L21 to L27 using L30 
L21:    aload_0 
L22:    aload_1 
L23:    aload_2 
L24:    invokevirtual [24] 
L27:    goto L45 
L30:    astore_3 
L31:    aload_0 
L32:    getfield [19] 
L35:    sipush 10000 
L38:    ldc [8] 
L40:    aload_3 
L41:    invokevirtual [23] 
L44:    pop 
L45:    aload_0 
L46:    getfield [20] 
L49:    aload_1 
L50:    invokeinterface [33] 0 
L55:    pop 
L56:    return 
L57:    nop 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method protected abstract [153] : [154] 
    .attribute [144] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [155] : [156] 
    .attribute [144] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method private [157] : [158] 
    .attribute [144] .code stack 2 locals 1 
L0:     aload_1 
L1:     ldc [9] 
L3:     invokeinterface [34] 0 
L8:     checkcast [10] 
L11:    checkcast [10] 
L14:    astore_2 
L15:    aload_2 
L16:    iconst_0 
L17:    invokestatic [11] 
L20:    areturn 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method private [159] : [160] 
    .attribute [144] .code stack 1 locals 0 
L0:     aload_1 
L1:     invokespecial [29] 
L4:     invokevirtual [25] 
L7:     areturn 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [35] 
.const [4] = Class [36] 
.const [5] = String [37] 
.const [6] = Int -1601830656 
.const [7] = String [38] 
.const [8] = String [39] 
.const [9] = String [40] 
.const [10] = Class [41] 
.const [11] = Method [42] [43] 
.const [12] = Class [44] 
.const [13] = Class [45] 
.const [14] = Class [46] 
.const [15] = Class [47] 
.const [16] = Class [48] 
.const [17] = Class [49] 
.const [18] = Class [50] 
.const [19] = Field [51] [52] 
.const [20] = Field [53] [54] 
.const [21] = Method [55] [56] 
.const [22] = Method [57] [58] 
.const [23] = Method [59] [60] 
.const [24] = Method [61] [62] 
.const [25] = Method [63] [64] 
.const [26] = Method [65] [66] 
.const [27] = Method [67] [68] 
.const [28] = Method [69] [70] 
.const [29] = Method [71] [72] 
.const [30] = Field [73] [74] 
.const [31] = Field [75] [76] 
.const [32] = InterfaceMethod [77] [78] 
.const [33] = InterfaceMethod [79] [80] 
.const [34] = InterfaceMethod [81] [82] 
.const [35] = Utf8 '[AbtractTrackerCustomizer#addingService] Service interfaces = %1, service implementation = %2' 
.const [36] = Utf8 java/lang/Exception 
.const [37] = Utf8 '[AbtractTrackerCustomizer#addingService] Error adding service: %1' 
.const [38] = Utf8 '[AbtractTrackerCustomizer#removedService] Service interfaces = %1, service implementation = %2' 
.const [39] = Utf8 '[AbtractTrackerCustomizer#removedService] Error removing service: %1' 
.const [40] = Utf8 objectClass 
.const [41] = Utf8 [Ljava/lang/String; 
.const [42] = Class [83] 
.const [43] = NameAndType [84] [85] 
.const [44] = Utf8 de/audi/app/sdsmanager/dictation/osgi/AbstractTrackerCustomizer 
.const [45] = Utf8 java/lang/Object 
.const [46] = Utf8 org/osgi/framework/BundleContext 
.const [47] = Utf8 de/audi/atip/log/LogChannel 
.const [48] = Utf8 org/osgi/framework/ServiceReference 
.const [49] = Utf8 de/audi/app/sdsmanager/dictation/util/DictationUtil 
.const [50] = Utf8 java/lang/Class 
.const [51] = Class [86] 
.const [52] = NameAndType [87] [88] 
.const [53] = Class [89] 
.const [54] = NameAndType [90] [91] 
.const [55] = Class [92] 
.const [56] = NameAndType [93] [94] 
.const [57] = Class [95] 
.const [58] = NameAndType [96] [97] 
.const [59] = Class [98] 
.const [60] = NameAndType [99] [100] 
.const [61] = Class [101] 
.const [62] = NameAndType [102] [103] 
.const [63] = Class [104] 
.const [64] = NameAndType [105] [106] 
.const [65] = Class [107] 
.const [66] = NameAndType [108] [109] 
.const [67] = Class [110] 
.const [68] = NameAndType [111] [112] 
.const [69] = Class [113] 
.const [70] = NameAndType [114] [115] 
.const [71] = Class [116] 
.const [72] = NameAndType [117] [118] 
.const [73] = Class [119] 
.const [74] = NameAndType [120] [121] 
.const [75] = Class [122] 
.const [76] = NameAndType [123] [124] 
.const [77] = Class [125] 
.const [78] = NameAndType [126] [127] 
.const [79] = Class [128] 
.const [80] = NameAndType [129] [130] 
.const [81] = Class [131] 
.const [82] = NameAndType [132] [133] 
.const [83] = Utf8 de/audi/app/sdsmanager/dictation/util/DictationUtil 
.const [84] = Utf8 arrayToString 
.const [85] = Utf8 ([Ljava/lang/Object;Z)Ljava/lang/String; 
.const [86] = Utf8 de/audi/app/sdsmanager/dictation/osgi/AbstractTrackerCustomizer 
.const [87] = Utf8 log 
.const [88] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [89] = Utf8 de/audi/app/sdsmanager/dictation/osgi/AbstractTrackerCustomizer 
.const [90] = Utf8 bundleContext 
.const [91] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [92] = Utf8 de/audi/atip/log/LogChannel 
.const [93] = Utf8 log 
.const [94] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [95] = Utf8 de/audi/app/sdsmanager/dictation/osgi/AbstractTrackerCustomizer 
.const [96] = Utf8 addService 
.const [97] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [98] = Utf8 de/audi/atip/log/LogChannel 
.const [99] = Utf8 log 
.const [100] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [101] = Utf8 de/audi/app/sdsmanager/dictation/osgi/AbstractTrackerCustomizer 
.const [102] = Utf8 removeService 
.const [103] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [104] = Utf8 java/lang/Class 
.const [105] = Utf8 getName 
.const [106] = Utf8 ()Ljava/lang/String; 
.const [107] = Utf8 java/lang/Object 
.const [108] = Utf8 <init> 
.const [109] = Utf8 ()V 
.const [110] = Utf8 de/audi/app/sdsmanager/dictation/osgi/AbstractTrackerCustomizer 
.const [111] = Utf8 getServiceInterfaces 
.const [112] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/String; 
.const [113] = Utf8 de/audi/app/sdsmanager/dictation/osgi/AbstractTrackerCustomizer 
.const [114] = Utf8 getServiceClass 
.const [115] = Utf8 (Ljava/lang/Object;)Ljava/lang/String; 
.const [116] = Utf8 java/lang/Object 
.const [117] = Utf8 getClass 
.const [118] = Utf8 ()Ljava/lang/Class; 
.const [119] = Utf8 de/audi/app/sdsmanager/dictation/osgi/AbstractTrackerCustomizer 
.const [120] = Utf8 log 
.const [121] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [122] = Utf8 de/audi/app/sdsmanager/dictation/osgi/AbstractTrackerCustomizer 
.const [123] = Utf8 bundleContext 
.const [124] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [125] = Utf8 org/osgi/framework/BundleContext 
.const [126] = Utf8 getService 
.const [127] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [128] = Utf8 org/osgi/framework/BundleContext 
.const [129] = Utf8 ungetService 
.const [130] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [131] = Utf8 org/osgi/framework/ServiceReference 
.const [132] = Utf8 getProperty 
.const [133] = Utf8 (Ljava/lang/String;)Ljava/lang/Object; 
.const [134] = Utf8 de/audi/app/sdsmanager/dictation/osgi/AbstractTrackerCustomizer 
.const [135] = Class [134] 
.const [136] = Utf8 java/lang/Object 
.const [137] = Class [136] 
.const [138] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [139] = Class [138] 
.const [140] = Utf8 log 
.const [141] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [142] = Utf8 bundleContext 
.const [143] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [144] = Utf8 Code 
.const [145] = Utf8 <init> 
.const [146] = Utf8 (Lde/audi/atip/log/LogChannel;Lorg/osgi/framework/BundleContext;)V 
.const [147] = Utf8 addingService 
.const [148] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [149] = Utf8 modifiedService 
.const [150] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [151] = Utf8 removedService 
.const [152] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [153] = Utf8 addService 
.const [154] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [155] = Utf8 removeService 
.const [156] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [157] = Utf8 getServiceInterfaces 
.const [158] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/String; 
.const [159] = Utf8 getServiceClass 
.const [160] = Utf8 (Ljava/lang/Object;)Ljava/lang/String; 
.end class 
