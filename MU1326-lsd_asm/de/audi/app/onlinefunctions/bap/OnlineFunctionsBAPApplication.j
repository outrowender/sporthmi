.version 50 0 
.class public super [253] 
.super [255] 
.implements [257] 
.field private [258] [259] 
.field static synthetic [260] [261] 
.field static synthetic [262] [263] 

.method protected [265] : [266] 
    .attribute [264] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [45] 
L6:     aload_0 
L7:     new [57] 
L10:    dup 
L11:    aload_0 
L12:    invokespecial [46] 
L15:    putfield [58] 
L18:    aload_0 
L19:    getfield [36] 
L22:    ldc [6] 
L24:    ldc [7] 
L26:    invokevirtual [37] 
L29:    pop 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [267] : [268] 
    .attribute [264] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     new [59] 
L5:     dup 
L6:     aload_1 
L7:     invokespecial [47] 
L10:    invokespecial [48] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [269] : [270] 
    .attribute [264] .code stack 1 locals 0 
L0:     ldc [9] 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected [271] : [272] 
    .attribute [264] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [49] 
L5:     aload_0 
L6:     getfield [35] 
L9:     ifnull L17 
L12:    aload_0 
L13:    aload_1 
L14:    invokespecial [50] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method private [273] : [274] 
    .attribute [264] .code stack 5 locals 1 
L0:     new [60] 
L3:     dup 
L4:     invokespecial [51] 
L7:     astore_2 
L8:     aload_2 
L9:     ldc [11] 
L11:    getstatic [12] 
L14:    ifnonnull L29 
L17:    ldc [13] 
L19:    invokestatic [14] 
L22:    dup 
L23:    putstatic [52] 
L26:    goto L32 
L29:    getstatic [12] 
L32:    invokevirtual [38] 
L35:    invokevirtual [39] 
L38:    pop 
L39:    aload_2 
L40:    ldc [15] 
L42:    new [61] 
L45:    dup 
L46:    iconst_0 
L47:    invokespecial [53] 
L50:    invokevirtual [39] 
L53:    pop 
L54:    aload_2 
L55:    ldc [17] 
L57:    new [61] 
L60:    dup 
L61:    bipush 20 
L63:    invokespecial [53] 
L66:    invokevirtual [39] 
L69:    pop 
L70:    aload_0 
L71:    getfield [36] 
L74:    ldc [6] 
L76:    ldc [18] 
L78:    aload_0 
L79:    getfield [35] 
L82:    invokespecial [54] 
L85:    invokevirtual [40] 
L88:    pop 
L89:    aload_1 
L90:    getstatic [12] 
L93:    ifnonnull L108 
L96:    ldc [13] 
L98:    invokestatic [14] 
L101:   dup 
L102:   putstatic [52] 
L105:   goto L111 
L108:   getstatic [12] 
L111:   invokevirtual [38] 
L114:   aload_0 
L115:   getfield [35] 
L118:   aload_2 
L119:   invokevirtual [41] 
L122:   return 
L123:   nop 
L124:   
    .end code 
.end method 

.method public interface [275] : [276] 
    .attribute [264] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [35] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [277] : [278] 
    .attribute [264] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [36] 
L4:     ldc [6] 
L6:     ldc [19] 
L8:     invokevirtual [37] 
L11:    pop 
L12:    aload_0 
L13:    invokevirtual [42] 
L16:    invokeinterface [62] 0 
L21:    aload_1 
L22:    invokeinterface [63] 0 
L27:    astore_2 
L28:    getstatic [20] 
L31:    ifnonnull L46 
L34:    ldc [21] 
L36:    invokestatic [14] 
L39:    dup 
L40:    putstatic [55] 
L43:    goto L49 
L46:    getstatic [20] 
L49:    aload_2 
L50:    invokespecial [54] 
L53:    invokevirtual [43] 
L56:    ifeq L101 
L59:    aload_2 
L60:    checkcast [22] 
L63:    astore_3 
L64:    aload_3 
L65:    iconst_3 
L66:    newarray int 
L68:    dup 
L69:    iconst_0 
L70:    iconst_1 
L71:    iastore 
L72:    dup 
L73:    iconst_1 
L74:    iconst_2 
L75:    iastore 
L76:    dup 
L77:    iconst_2 
L78:    iconst_3 
L79:    iastore 
L80:    aload_0 
L81:    getfield [35] 
L84:    invokeinterface [64] 0 
L89:    aload_0 
L90:    getfield [36] 
L93:    ldc [23] 
L95:    ldc [24] 
L97:    invokevirtual [37] 
L100:   pop 
L101:   aload_2 
L102:   areturn 
L103:   nop 
L104:   
    .end code 
.end method 

.method public enum [279] : [280] 
    .attribute [264] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [281] : [282] 
    .attribute [264] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [36] 
L4:     ldc [6] 
L6:     ldc [25] 
L8:     invokevirtual [37] 
L11:    pop 
L12:    aload_0 
L13:    invokevirtual [42] 
L16:    invokeinterface [62] 0 
L21:    aload_1 
L22:    invokeinterface [65] 0 
L27:    pop 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method static synthetic [283] : [284] 
    .attribute [264] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [56] 
L9:     dup 
L10:    invokespecial [44] 
L13:    aload_1 
L14:    invokevirtual [34] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [66] [67] 
.const [3] = Class [68] 
.const [4] = Class [69] 
.const [5] = Class [70] 
.const [6] = Int 1078071040 
.const [7] = String [71] 
.const [8] = Class [72] 
.const [9] = String [73] 
.const [10] = Class [74] 
.const [11] = String [75] 
.const [12] = Field [76] [77] 
.const [13] = String [78] 
.const [14] = Method [79] [80] 
.const [15] = String [81] 
.const [16] = Class [82] 
.const [17] = String [83] 
.const [18] = String [84] 
.const [19] = String [85] 
.const [20] = Field [86] [87] 
.const [21] = String [88] 
.const [22] = Class [89] 
.const [23] = Int -2137614336 
.const [24] = String [90] 
.const [25] = String [91] 
.const [26] = Class [92] 
.const [27] = Class [93] 
.const [28] = Class [94] 
.const [29] = Class [95] 
.const [30] = Class [96] 
.const [31] = Class [97] 
.const [32] = Class [98] 
.const [33] = Class [99] 
.const [34] = Method [100] [101] 
.const [35] = Field [102] [103] 
.const [36] = Field [104] [105] 
.const [37] = Method [106] [107] 
.const [38] = Method [108] [109] 
.const [39] = Method [110] [111] 
.const [40] = Method [112] [113] 
.const [41] = Method [114] [115] 
.const [42] = Method [116] [117] 
.const [43] = Method [118] [119] 
.const [44] = Method [120] [121] 
.const [45] = Method [122] [123] 
.const [46] = Method [124] [125] 
.const [47] = Method [126] [127] 
.const [48] = Method [128] [129] 
.const [49] = Method [130] [131] 
.const [50] = Method [132] [133] 
.const [51] = Method [134] [135] 
.const [52] = Field [136] [137] 
.const [53] = Method [138] [139] 
.const [54] = Method [140] [141] 
.const [55] = Field [142] [143] 
.const [56] = Class [144] 
.const [57] = Class [145] 
.const [58] = Field [146] [147] 
.const [59] = Class [148] 
.const [60] = Class [149] 
.const [61] = Class [150] 
.const [62] = InterfaceMethod [151] [152] 
.const [63] = InterfaceMethod [153] [154] 
.const [64] = InterfaceMethod [155] [156] 
.const [65] = InterfaceMethod [157] [158] 
.const [66] = Class [159] 
.const [67] = NameAndType [160] [161] 
.const [68] = Utf8 java/lang/ClassNotFoundException 
.const [69] = Utf8 java/lang/NoClassDefFoundError 
.const [70] = Utf8 de/audi/app/onlinefunctions/bap/DSIOnlineTrafficLightInfoListenerImpl 
.const [71] = Utf8 ' OnlineFunctionsBAPApplication has been started ' 
.const [72] = Utf8 de/audi/app/onlinefunctions/bap/LoggerOnlineFunctionsBAP 
.const [73] = Utf8 OnlineFunctionsBAPApplication 
.const [74] = Utf8 java/util/Hashtable 
.const [75] = Utf8 DEVICE_NAME 
.const [76] = Class [162] 
.const [77] = NameAndType [163] [164] 
.const [78] = Utf8 'org.dsi.ifc.online.DSIOnlineTrafficLightInfoListener' 
.const [79] = Class [165] 
.const [80] = NameAndType [166] [167] 
.const [81] = Utf8 DEVICE_INSTANCE 
.const [82] = Utf8 java/lang/Integer 
.const [83] = Utf8 moduleID 
.const [84] = Utf8 '[OnlineFunctionsBAPApplication#registerDSIListener] Registering %1' 
.const [85] = Utf8 '[OnlineFunctionsBAPApplication#addingService] called' 
.const [86] = Class [168] 
.const [87] = NameAndType [169] [170] 
.const [88] = Utf8 'org.dsi.ifc.online.DSIOnlineTrafficLightInfo' 
.const [89] = Utf8 org/dsi/ifc/online/DSIOnlineTrafficLightInfo 
.const [90] = Utf8 '[OnlineFunctionsBAPApplication#addingService] DSI notified' 
.const [91] = Utf8 ' OnlineFunctionsBAPApplication#removedService() service removed' 
.const [92] = Utf8 de/audi/app/onlinefunctions/bap/OnlineFunctionsBAPApplication 
.const [93] = Utf8 de/audi/app/bap/AbstractBAPApplication 
.const [94] = Utf8 java/lang/Class 
.const [95] = Utf8 de/audi/atip/log/LogChannel 
.const [96] = Utf8 java/lang/Object 
.const [97] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [98] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [99] = Utf8 org/osgi/framework/BundleContext 
.const [100] = Class [171] 
.const [101] = NameAndType [172] [173] 
.const [102] = Class [174] 
.const [103] = NameAndType [175] [176] 
.const [104] = Class [177] 
.const [105] = NameAndType [178] [179] 
.const [106] = Class [180] 
.const [107] = NameAndType [181] [182] 
.const [108] = Class [183] 
.const [109] = NameAndType [184] [185] 
.const [110] = Class [186] 
.const [111] = NameAndType [187] [188] 
.const [112] = Class [189] 
.const [113] = NameAndType [190] [191] 
.const [114] = Class [192] 
.const [115] = NameAndType [193] [194] 
.const [116] = Class [195] 
.const [117] = NameAndType [196] [197] 
.const [118] = Class [198] 
.const [119] = NameAndType [199] [200] 
.const [120] = Class [201] 
.const [121] = NameAndType [202] [203] 
.const [122] = Class [204] 
.const [123] = NameAndType [205] [206] 
.const [124] = Class [207] 
.const [125] = NameAndType [208] [209] 
.const [126] = Class [210] 
.const [127] = NameAndType [211] [212] 
.const [128] = Class [213] 
.const [129] = NameAndType [214] [215] 
.const [130] = Class [216] 
.const [131] = NameAndType [217] [218] 
.const [132] = Class [219] 
.const [133] = NameAndType [220] [221] 
.const [134] = Class [222] 
.const [135] = NameAndType [223] [224] 
.const [136] = Class [225] 
.const [137] = NameAndType [226] [227] 
.const [138] = Class [228] 
.const [139] = NameAndType [229] [230] 
.const [140] = Class [231] 
.const [141] = NameAndType [232] [233] 
.const [142] = Class [234] 
.const [143] = NameAndType [235] [236] 
.const [144] = Utf8 java/lang/NoClassDefFoundError 
.const [145] = Utf8 de/audi/app/onlinefunctions/bap/DSIOnlineTrafficLightInfoListenerImpl 
.const [146] = Class [237] 
.const [147] = NameAndType [238] [239] 
.const [148] = Utf8 de/audi/app/onlinefunctions/bap/LoggerOnlineFunctionsBAP 
.const [149] = Utf8 java/util/Hashtable 
.const [150] = Utf8 java/lang/Integer 
.const [151] = Class [240] 
.const [152] = NameAndType [241] [242] 
.const [153] = Class [243] 
.const [154] = NameAndType [244] [245] 
.const [155] = Class [246] 
.const [156] = NameAndType [247] [248] 
.const [157] = Class [249] 
.const [158] = NameAndType [250] [251] 
.const [159] = Utf8 java/lang/Class 
.const [160] = Utf8 forName 
.const [161] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [162] = Utf8 de/audi/app/onlinefunctions/bap/OnlineFunctionsBAPApplication 
.const [163] = Utf8 class$org$dsi$ifc$online$DSIOnlineTrafficLightInfoListener 
.const [164] = Utf8 Ljava/lang/Class; 
.const [165] = Utf8 de/audi/app/onlinefunctions/bap/OnlineFunctionsBAPApplication 
.const [166] = Utf8 class$ 
.const [167] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [168] = Utf8 de/audi/app/onlinefunctions/bap/OnlineFunctionsBAPApplication 
.const [169] = Utf8 class$org$dsi$ifc$online$DSIOnlineTrafficLightInfo 
.const [170] = Utf8 Ljava/lang/Class; 
.const [171] = Utf8 java/lang/NoClassDefFoundError 
.const [172] = Utf8 initCause 
.const [173] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [174] = Utf8 de/audi/app/onlinefunctions/bap/OnlineFunctionsBAPApplication 
.const [175] = Utf8 dsiTrafficLightInfoListener 
.const [176] = Utf8 Lorg/dsi/ifc/online/DSIOnlineTrafficLightInfoListener; 
.const [177] = Utf8 de/audi/app/onlinefunctions/bap/OnlineFunctionsBAPApplication 
.const [178] = Utf8 logChannel 
.const [179] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [180] = Utf8 de/audi/atip/log/LogChannel 
.const [181] = Utf8 log 
.const [182] = Utf8 (ILjava/lang/String;)Z 
.const [183] = Utf8 java/lang/Class 
.const [184] = Utf8 getName 
.const [185] = Utf8 ()Ljava/lang/String; 
.const [186] = Utf8 java/util/Hashtable 
.const [187] = Utf8 put 
.const [188] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [189] = Utf8 de/audi/atip/log/LogChannel 
.const [190] = Utf8 log 
.const [191] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [192] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [193] = Utf8 registerService 
.const [194] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)V 
.const [195] = Utf8 de/audi/app/onlinefunctions/bap/OnlineFunctionsBAPApplication 
.const [196] = Utf8 getFrameworkAccess 
.const [197] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [198] = Utf8 java/lang/Class 
.const [199] = Utf8 isAssignableFrom 
.const [200] = Utf8 (Ljava/lang/Class;)Z 
.const [201] = Utf8 java/lang/NoClassDefFoundError 
.const [202] = Utf8 <init> 
.const [203] = Utf8 ()V 
.const [204] = Utf8 de/audi/app/bap/AbstractBAPApplication 
.const [205] = Utf8 <init> 
.const [206] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;Lde/audi/app/bap/utils/IBAPLogger;)V 
.const [207] = Utf8 de/audi/app/onlinefunctions/bap/DSIOnlineTrafficLightInfoListenerImpl 
.const [208] = Utf8 <init> 
.const [209] = Utf8 (Lde/audi/app/bap/AbstractBAPApplication;)V 
.const [210] = Utf8 de/audi/app/onlinefunctions/bap/LoggerOnlineFunctionsBAP 
.const [211] = Utf8 <init> 
.const [212] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)V 
.const [213] = Utf8 de/audi/app/onlinefunctions/bap/OnlineFunctionsBAPApplication 
.const [214] = Utf8 <init> 
.const [215] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;Lde/audi/app/onlinefunctions/bap/LoggerOnlineFunctionsBAP;)V 
.const [216] = Utf8 de/audi/app/bap/AbstractBAPApplication 
.const [217] = Utf8 activate 
.const [218] = Utf8 (Lde/audi/atip/activator/AbstractActivator;)V 
.const [219] = Utf8 de/audi/app/onlinefunctions/bap/OnlineFunctionsBAPApplication 
.const [220] = Utf8 registerDSIListener 
.const [221] = Utf8 (Lde/audi/atip/activator/AbstractActivator;)V 
.const [222] = Utf8 java/util/Hashtable 
.const [223] = Utf8 <init> 
.const [224] = Utf8 ()V 
.const [225] = Utf8 de/audi/app/onlinefunctions/bap/OnlineFunctionsBAPApplication 
.const [226] = Utf8 class$org$dsi$ifc$online$DSIOnlineTrafficLightInfoListener 
.const [227] = Utf8 Ljava/lang/Class; 
.const [228] = Utf8 java/lang/Integer 
.const [229] = Utf8 <init> 
.const [230] = Utf8 (I)V 
.const [231] = Utf8 java/lang/Object 
.const [232] = Utf8 getClass 
.const [233] = Utf8 ()Ljava/lang/Class; 
.const [234] = Utf8 de/audi/app/onlinefunctions/bap/OnlineFunctionsBAPApplication 
.const [235] = Utf8 class$org$dsi$ifc$online$DSIOnlineTrafficLightInfo 
.const [236] = Utf8 Ljava/lang/Class; 
.const [237] = Utf8 de/audi/app/onlinefunctions/bap/OnlineFunctionsBAPApplication 
.const [238] = Utf8 dsiTrafficLightInfoListener 
.const [239] = Utf8 Lorg/dsi/ifc/online/DSIOnlineTrafficLightInfoListener; 
.const [240] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [241] = Utf8 getBundleCxt 
.const [242] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [243] = Utf8 org/osgi/framework/BundleContext 
.const [244] = Utf8 getService 
.const [245] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [246] = Utf8 org/dsi/ifc/online/DSIOnlineTrafficLightInfo 
.const [247] = Utf8 setNotification 
.const [248] = Utf8 ([ILorg/dsi/ifc/base/DSIListener;)V 
.const [249] = Utf8 org/osgi/framework/BundleContext 
.const [250] = Utf8 ungetService 
.const [251] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [252] = Utf8 de/audi/app/onlinefunctions/bap/OnlineFunctionsBAPApplication 
.const [253] = Class [252] 
.const [254] = Utf8 de/audi/app/bap/AbstractBAPApplication 
.const [255] = Class [254] 
.const [256] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [257] = Class [256] 
.const [258] = Utf8 dsiTrafficLightInfoListener 
.const [259] = Utf8 Lorg/dsi/ifc/online/DSIOnlineTrafficLightInfoListener; 
.const [260] = Utf8 class$org$dsi$ifc$online$DSIOnlineTrafficLightInfoListener 
.const [261] = Utf8 Ljava/lang/Class; 
.const [262] = Utf8 class$org$dsi$ifc$online$DSIOnlineTrafficLightInfo 
.const [263] = Utf8 Ljava/lang/Class; 
.const [264] = Utf8 Code 
.const [265] = Utf8 <init> 
.const [266] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;Lde/audi/app/onlinefunctions/bap/LoggerOnlineFunctionsBAP;)V 
.const [267] = Utf8 <init> 
.const [268] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)V 
.const [269] = Utf8 getName 
.const [270] = Utf8 ()Ljava/lang/String; 
.const [271] = Utf8 activate 
.const [272] = Utf8 (Lde/audi/atip/activator/AbstractActivator;)V 
.const [273] = Utf8 registerDSIListener 
.const [274] = Utf8 (Lde/audi/atip/activator/AbstractActivator;)V 
.const [275] = Utf8 getDSITrafficLightInfoListener 
.const [276] = Utf8 ()Lorg/dsi/ifc/online/DSIOnlineTrafficLightInfoListener; 
.const [277] = Utf8 addingService 
.const [278] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [279] = Utf8 modifiedService 
.const [280] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [281] = Utf8 removedService 
.const [282] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [283] = Utf8 class$ 
.const [284] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
