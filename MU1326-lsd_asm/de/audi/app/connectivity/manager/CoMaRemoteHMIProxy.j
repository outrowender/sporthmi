.version 50 0 
.class super [176] 
.super [178] 
.implements [180] 
.field private final [181] [182] 
.field private final [183] [184] 
.field private [185] [186] 
.field private [187] [188] 
.field static synthetic [189] [190] 

.method [192] : [193] 
    .attribute [191] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [28] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [32] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [33] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method [194] : [195] 
    .attribute [191] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     ifnull L20 
L7:     aload_0 
L8:     getfield [21] 
L11:    aload_1 
L12:    invokeinterface [35] 0 
L17:    goto L32 
L20:    aload_0 
L21:    getfield [20] 
L24:    ldc [5] 
L26:    ldc [6] 
L28:    invokevirtual [22] 
L31:    pop 
L32:    return 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method [196] : [197] 
    .attribute [191] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     ifnull L20 
L7:     aload_0 
L8:     getfield [21] 
L11:    aload_1 
L12:    invokeinterface [36] 0 
L17:    goto L32 
L20:    aload_0 
L21:    getfield [20] 
L24:    ldc [5] 
L26:    ldc [7] 
L28:    invokevirtual [22] 
L31:    pop 
L32:    return 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [198] : [199] 
    .attribute [191] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [19] 
L4:     aload_1 
L5:     invokeinterface [37] 0 
L10:    astore_2 
L11:    aload_2 
L12:    instanceof [8] 
L15:    ifeq L28 
L18:    aload_0 
L19:    aload_2 
L20:    checkcast [8] 
L23:    putfield [34] 
L26:    aload_2 
L27:    areturn 
L28:    aconst_null 
L29:    areturn 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [200] : [201] 
    .attribute [191] .code stack 2 locals 0 
L0:     aload_2 
L1:     instanceof [8] 
L4:     ifeq L23 
L7:     aload_0 
L8:     aconst_null 
L9:     putfield [34] 
L12:    aload_0 
L13:    getfield [19] 
L16:    aload_1 
L17:    invokeinterface [38] 0 
L22:    pop 
L23:    return 
L24:    
    .end code 
.end method 

.method public [202] : [203] 
    .attribute [191] .code stack 2 locals 0 
L0:     aload_2 
L1:     instanceof [8] 
L4:     ifeq L15 
L7:     aload_0 
L8:     aload_2 
L9:     checkcast [8] 
L12:    putfield [34] 
L15:    return 
L16:    
    .end code 
.end method 

.method [204] : [205] 
    .attribute [191] .code stack 6 locals 0 
L0:     aload_0 
L1:     new [39] 
L4:     dup 
L5:     aload_0 
L6:     getfield [19] 
L9:     getstatic [10] 
L12:    ifnonnull L27 
L15:    ldc [11] 
L17:    invokestatic [12] 
L20:    dup 
L21:    putstatic [29] 
L24:    goto L30 
L27:    getstatic [10] 
L30:    invokevirtual [23] 
L33:    aload_0 
L34:    invokespecial [30] 
L37:    putfield [40] 
L40:    aload_0 
L41:    getfield [24] 
L44:    invokevirtual [25] 
L47:    return 
L48:    
    .end code 
.end method 

.method [206] : [207] 
    .attribute [191] .code stack 2 locals 0 
L0:     aload_0 
L1:     aconst_null 
L2:     putfield [34] 
L5:     aload_0 
L6:     getfield [24] 
L9:     invokevirtual [26] 
L12:    aload_0 
L13:    aconst_null 
L14:    putfield [40] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static synthetic [208] : [209] 
    .attribute [191] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [31] 
L9:     dup 
L10:    invokespecial [27] 
L13:    aload_1 
L14:    invokevirtual [18] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [41] [42] 
.const [3] = Class [43] 
.const [4] = Class [44] 
.const [5] = Int -1601830656 
.const [6] = String [45] 
.const [7] = String [46] 
.const [8] = Class [47] 
.const [9] = Class [48] 
.const [10] = Field [49] [50] 
.const [11] = String [51] 
.const [12] = Method [52] [53] 
.const [13] = Class [54] 
.const [14] = Class [55] 
.const [15] = Class [56] 
.const [16] = Class [57] 
.const [17] = Class [58] 
.const [18] = Method [59] [60] 
.const [19] = Field [61] [62] 
.const [20] = Field [63] [64] 
.const [21] = Field [65] [66] 
.const [22] = Method [67] [68] 
.const [23] = Method [69] [70] 
.const [24] = Field [71] [72] 
.const [25] = Method [73] [74] 
.const [26] = Method [75] [76] 
.const [27] = Method [77] [78] 
.const [28] = Method [79] [80] 
.const [29] = Field [81] [82] 
.const [30] = Method [83] [84] 
.const [31] = Class [85] 
.const [32] = Field [86] [87] 
.const [33] = Field [88] [89] 
.const [34] = Field [90] [91] 
.const [35] = InterfaceMethod [92] [93] 
.const [36] = InterfaceMethod [94] [95] 
.const [37] = InterfaceMethod [96] [97] 
.const [38] = InterfaceMethod [98] [99] 
.const [39] = Class [100] 
.const [40] = Field [101] [102] 
.const [41] = Class [103] 
.const [42] = NameAndType [104] [105] 
.const [43] = Utf8 java/lang/ClassNotFoundException 
.const [44] = Utf8 java/lang/NoClassDefFoundError 
.const [45] = Utf8 'CoMaRemoteHMIProxy#connectAppServer(): IConnectivityRHMIService not available!' 
.const [46] = Utf8 'CoMaRemoteHMIProxy#disConnectAppServer(): IConnectivityRHMIService not available!' 
.const [47] = Utf8 de/audi/atip/interapp/IConnectivityRHMIService 
.const [48] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [49] = Class [106] 
.const [50] = NameAndType [107] [108] 
.const [51] = Utf8 'de.audi.atip.interapp.IConnectivityRHMIService' 
.const [52] = Class [109] 
.const [53] = NameAndType [110] [111] 
.const [54] = Utf8 de/audi/app/connectivity/manager/CoMaRemoteHMIProxy 
.const [55] = Utf8 java/lang/Object 
.const [56] = Utf8 java/lang/Class 
.const [57] = Utf8 de/audi/atip/log/LogChannel 
.const [58] = Utf8 org/osgi/framework/BundleContext 
.const [59] = Class [112] 
.const [60] = NameAndType [113] [114] 
.const [61] = Class [115] 
.const [62] = NameAndType [116] [117] 
.const [63] = Class [118] 
.const [64] = NameAndType [119] [120] 
.const [65] = Class [121] 
.const [66] = NameAndType [122] [123] 
.const [67] = Class [124] 
.const [68] = NameAndType [125] [126] 
.const [69] = Class [127] 
.const [70] = NameAndType [128] [129] 
.const [71] = Class [130] 
.const [72] = NameAndType [131] [132] 
.const [73] = Class [133] 
.const [74] = NameAndType [134] [135] 
.const [75] = Class [136] 
.const [76] = NameAndType [137] [138] 
.const [77] = Class [139] 
.const [78] = NameAndType [140] [141] 
.const [79] = Class [142] 
.const [80] = NameAndType [143] [144] 
.const [81] = Class [145] 
.const [82] = NameAndType [146] [147] 
.const [83] = Class [148] 
.const [84] = NameAndType [149] [150] 
.const [85] = Utf8 java/lang/NoClassDefFoundError 
.const [86] = Class [151] 
.const [87] = NameAndType [152] [153] 
.const [88] = Class [154] 
.const [89] = NameAndType [155] [156] 
.const [90] = Class [157] 
.const [91] = NameAndType [158] [159] 
.const [92] = Class [160] 
.const [93] = NameAndType [161] [162] 
.const [94] = Class [163] 
.const [95] = NameAndType [164] [165] 
.const [96] = Class [166] 
.const [97] = NameAndType [167] [168] 
.const [98] = Class [169] 
.const [99] = NameAndType [170] [171] 
.const [100] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [101] = Class [172] 
.const [102] = NameAndType [173] [174] 
.const [103] = Utf8 java/lang/Class 
.const [104] = Utf8 forName 
.const [105] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [106] = Utf8 de/audi/app/connectivity/manager/CoMaRemoteHMIProxy 
.const [107] = Utf8 class$de$audi$atip$interapp$IConnectivityRHMIService 
.const [108] = Utf8 Ljava/lang/Class; 
.const [109] = Utf8 de/audi/app/connectivity/manager/CoMaRemoteHMIProxy 
.const [110] = Utf8 class$ 
.const [111] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [112] = Utf8 java/lang/NoClassDefFoundError 
.const [113] = Utf8 initCause 
.const [114] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [115] = Utf8 de/audi/app/connectivity/manager/CoMaRemoteHMIProxy 
.const [116] = Utf8 bundleContext 
.const [117] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [118] = Utf8 de/audi/app/connectivity/manager/CoMaRemoteHMIProxy 
.const [119] = Utf8 log 
.const [120] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [121] = Utf8 de/audi/app/connectivity/manager/CoMaRemoteHMIProxy 
.const [122] = Utf8 rhmi 
.const [123] = Utf8 Lde/audi/atip/interapp/IConnectivityRHMIService; 
.const [124] = Utf8 de/audi/atip/log/LogChannel 
.const [125] = Utf8 log 
.const [126] = Utf8 (ILjava/lang/String;)Z 
.const [127] = Utf8 java/lang/Class 
.const [128] = Utf8 getName 
.const [129] = Utf8 ()Ljava/lang/String; 
.const [130] = Utf8 de/audi/app/connectivity/manager/CoMaRemoteHMIProxy 
.const [131] = Utf8 serviceTracker 
.const [132] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [133] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [134] = Utf8 'open' 
.const [135] = Utf8 ()V 
.const [136] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [137] = Utf8 close 
.const [138] = Utf8 ()V 
.const [139] = Utf8 java/lang/NoClassDefFoundError 
.const [140] = Utf8 <init> 
.const [141] = Utf8 ()V 
.const [142] = Utf8 java/lang/Object 
.const [143] = Utf8 <init> 
.const [144] = Utf8 ()V 
.const [145] = Utf8 de/audi/app/connectivity/manager/CoMaRemoteHMIProxy 
.const [146] = Utf8 class$de$audi$atip$interapp$IConnectivityRHMIService 
.const [147] = Utf8 Ljava/lang/Class; 
.const [148] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [149] = Utf8 <init> 
.const [150] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [151] = Utf8 de/audi/app/connectivity/manager/CoMaRemoteHMIProxy 
.const [152] = Utf8 bundleContext 
.const [153] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [154] = Utf8 de/audi/app/connectivity/manager/CoMaRemoteHMIProxy 
.const [155] = Utf8 log 
.const [156] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [157] = Utf8 de/audi/app/connectivity/manager/CoMaRemoteHMIProxy 
.const [158] = Utf8 rhmi 
.const [159] = Utf8 Lde/audi/atip/interapp/IConnectivityRHMIService; 
.const [160] = Utf8 de/audi/atip/interapp/IConnectivityRHMIService 
.const [161] = Utf8 activateSource 
.const [162] = Utf8 (Ljava/lang/String;)V 
.const [163] = Utf8 de/audi/atip/interapp/IConnectivityRHMIService 
.const [164] = Utf8 deactivateSource 
.const [165] = Utf8 (Ljava/lang/String;)V 
.const [166] = Utf8 org/osgi/framework/BundleContext 
.const [167] = Utf8 getService 
.const [168] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [169] = Utf8 org/osgi/framework/BundleContext 
.const [170] = Utf8 ungetService 
.const [171] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [172] = Utf8 de/audi/app/connectivity/manager/CoMaRemoteHMIProxy 
.const [173] = Utf8 serviceTracker 
.const [174] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [175] = Utf8 de/audi/app/connectivity/manager/CoMaRemoteHMIProxy 
.const [176] = Class [175] 
.const [177] = Utf8 java/lang/Object 
.const [178] = Class [177] 
.const [179] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [180] = Class [179] 
.const [181] = Utf8 bundleContext 
.const [182] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [183] = Utf8 log 
.const [184] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [185] = Utf8 serviceTracker 
.const [186] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [187] = Utf8 rhmi 
.const [188] = Utf8 Lde/audi/atip/interapp/IConnectivityRHMIService; 
.const [189] = Utf8 class$de$audi$atip$interapp$IConnectivityRHMIService 
.const [190] = Utf8 Ljava/lang/Class; 
.const [191] = Utf8 Code 
.const [192] = Utf8 <init> 
.const [193] = Utf8 (Lorg/osgi/framework/BundleContext;Lde/audi/atip/log/LogChannel;)V 
.const [194] = Utf8 connectAppServer 
.const [195] = Utf8 (Ljava/lang/String;)V 
.const [196] = Utf8 disconnectAppServer 
.const [197] = Utf8 (Ljava/lang/String;)V 
.const [198] = Utf8 addingService 
.const [199] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [200] = Utf8 removedService 
.const [201] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [202] = Utf8 modifiedService 
.const [203] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [204] = Utf8 init 
.const [205] = Utf8 ()V 
.const [206] = Utf8 deinit 
.const [207] = Utf8 ()V 
.const [208] = Utf8 class$ 
.const [209] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
