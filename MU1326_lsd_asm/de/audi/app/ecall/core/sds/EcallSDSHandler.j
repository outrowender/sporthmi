.version 50 0 
.class public super [184] 
.super [186] 
.implements [188] 
.implements [190] 
.field private volatile [191] [192] 
.field private volatile [193] [194] 
.field static synthetic [195] [196] 

.method public [198] : [199] 
    .attribute [197] .code stack 7 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [32] 
L6:     aload_0 
L7:     new [37] 
L10:    dup 
L11:    aload_0 
L12:    invokevirtual [22] 
L15:    invokeinterface [38] 0 
L20:    getstatic [6] 
L23:    ifnonnull L38 
L26:    ldc [7] 
L28:    invokestatic [8] 
L31:    dup 
L32:    putstatic [33] 
L35:    goto L41 
L38:    getstatic [6] 
L41:    invokevirtual [23] 
L44:    aload_0 
L45:    aload_0 
L46:    getfield [24] 
L49:    invokespecial [34] 
L52:    putfield [39] 
L55:    aload_0 
L56:    new [40] 
L59:    dup 
L60:    aload_0 
L61:    invokevirtual [26] 
L64:    invokespecial [35] 
L67:    putfield [41] 
L70:    return 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [200] : [201] 
    .attribute [197] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [25] 
L4:     invokevirtual [28] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [202] : [203] 
    .attribute [197] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [25] 
L4:     invokevirtual [29] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [204] : [205] 
    .attribute [197] .code stack 2 locals 1 
L0:     aload_0 
L1:     invokevirtual [22] 
L4:     invokeinterface [38] 0 
L9:     aload_1 
L10:    invokeinterface [42] 0 
L15:    astore_2 
L16:    aload_2 
L17:    instanceof [10] 
L20:    ifeq L33 
L23:    aload_0 
L24:    aload_2 
L25:    checkcast [10] 
L28:    putfield [41] 
L31:    aload_2 
L32:    areturn 
L33:    aload_0 
L34:    invokevirtual [22] 
L37:    invokeinterface [38] 0 
L42:    aload_1 
L43:    invokeinterface [43] 0 
L48:    pop 
L49:    aconst_null 
L50:    areturn 
L51:    nop 
L52:    
    .end code 
.end method 

.method public enum [206] : [207] 
    .attribute [197] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [208] : [209] 
    .attribute [197] .code stack 4 locals 0 
L0:     aload_2 
L1:     instanceof [11] 
L4:     ifeq L38 
L7:     aload_0 
L8:     invokevirtual [22] 
L11:    invokeinterface [38] 0 
L16:    aload_1 
L17:    invokeinterface [43] 0 
L22:    pop 
L23:    aload_0 
L24:    new [40] 
L27:    dup 
L28:    aload_0 
L29:    invokevirtual [26] 
L32:    invokespecial [35] 
L35:    putfield [41] 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [210] : [211] 
    .attribute [197] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     ldc [12] 
L6:     ldc [13] 
L8:     invokevirtual [30] 
L11:    pop 
L12:    aload_0 
L13:    getfield [27] 
L16:    iconst_0 
L17:    iconst_1 
L18:    iconst_3 
L19:    invokeinterface [44] 0 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [212] : [213] 
    .attribute [197] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     ldc [12] 
L6:     ldc [14] 
L8:     invokevirtual [30] 
L11:    pop 
L12:    aload_0 
L13:    getfield [27] 
L16:    iconst_1 
L17:    iconst_1 
L18:    iconst_3 
L19:    invokeinterface [44] 0 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method static synthetic [214] : [215] 
    .attribute [197] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [36] 
L9:     dup 
L10:    invokespecial [31] 
L13:    aload_1 
L14:    invokevirtual [21] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [45] [46] 
.const [3] = Class [47] 
.const [4] = Class [48] 
.const [5] = Class [49] 
.const [6] = Field [50] [51] 
.const [7] = String [52] 
.const [8] = Method [53] [54] 
.const [9] = Class [55] 
.const [10] = Class [56] 
.const [11] = Class [57] 
.const [12] = Int 1078071040 
.const [13] = String [58] 
.const [14] = String [59] 
.const [15] = Class [60] 
.const [16] = Class [61] 
.const [17] = Class [62] 
.const [18] = Class [63] 
.const [19] = Class [64] 
.const [20] = Class [65] 
.const [21] = Method [66] [67] 
.const [22] = Method [68] [69] 
.const [23] = Method [70] [71] 
.const [24] = Field [72] [73] 
.const [25] = Field [74] [75] 
.const [26] = Method [76] [77] 
.const [27] = Field [78] [79] 
.const [28] = Method [80] [81] 
.const [29] = Method [82] [83] 
.const [30] = Method [84] [85] 
.const [31] = Method [86] [87] 
.const [32] = Method [88] [89] 
.const [33] = Field [90] [91] 
.const [34] = Method [92] [93] 
.const [35] = Method [94] [95] 
.const [36] = Class [96] 
.const [37] = Class [97] 
.const [38] = InterfaceMethod [98] [99] 
.const [39] = Field [100] [101] 
.const [40] = Class [102] 
.const [41] = Field [103] [104] 
.const [42] = InterfaceMethod [105] [106] 
.const [43] = InterfaceMethod [107] [108] 
.const [44] = InterfaceMethod [109] [110] 
.const [45] = Class [111] 
.const [46] = NameAndType [112] [113] 
.const [47] = Utf8 java/lang/ClassNotFoundException 
.const [48] = Utf8 java/lang/NoClassDefFoundError 
.const [49] = Utf8 de/audi/app/ecall/core/osgi/EcallServiceTracker 
.const [50] = Class [114] 
.const [51] = NameAndType [115] [116] 
.const [52] = Utf8 'de.audi.atip.interapp.SDSService' 
.const [53] = Class [117] 
.const [54] = NameAndType [118] [119] 
.const [55] = Utf8 de/audi/atip/interapp/def/NullSDSService 
.const [56] = Utf8 de/audi/atip/interapp/SDSService 
.const [57] = Utf8 de/audi/atip/interapp/AbstractSDSService 
.const [58] = Utf8 'EcallSDSHandler#enablePTT(): called' 
.const [59] = Utf8 'EcallSDSHandler#disablePTT(): called' 
.const [60] = Utf8 de/audi/app/ecall/core/sds/EcallSDSHandler 
.const [61] = Utf8 de/audi/app/ecall/core/AbstractEcallComponent 
.const [62] = Utf8 java/lang/Class 
.const [63] = Utf8 de/audi/app/ecall/core/IEcallApplication 
.const [64] = Utf8 org/osgi/framework/BundleContext 
.const [65] = Utf8 de/audi/atip/log/LogChannel 
.const [66] = Class [120] 
.const [67] = NameAndType [121] [122] 
.const [68] = Class [123] 
.const [69] = NameAndType [124] [125] 
.const [70] = Class [126] 
.const [71] = NameAndType [127] [128] 
.const [72] = Class [129] 
.const [73] = NameAndType [130] [131] 
.const [74] = Class [132] 
.const [75] = NameAndType [133] [134] 
.const [76] = Class [135] 
.const [77] = NameAndType [136] [137] 
.const [78] = Class [138] 
.const [79] = NameAndType [139] [140] 
.const [80] = Class [141] 
.const [81] = NameAndType [142] [143] 
.const [82] = Class [144] 
.const [83] = NameAndType [145] [146] 
.const [84] = Class [147] 
.const [85] = NameAndType [148] [149] 
.const [86] = Class [150] 
.const [87] = NameAndType [151] [152] 
.const [88] = Class [153] 
.const [89] = NameAndType [154] [155] 
.const [90] = Class [156] 
.const [91] = NameAndType [157] [158] 
.const [92] = Class [159] 
.const [93] = NameAndType [160] [161] 
.const [94] = Class [162] 
.const [95] = NameAndType [163] [164] 
.const [96] = Utf8 java/lang/NoClassDefFoundError 
.const [97] = Utf8 de/audi/app/ecall/core/osgi/EcallServiceTracker 
.const [98] = Class [165] 
.const [99] = NameAndType [166] [167] 
.const [100] = Class [168] 
.const [101] = NameAndType [169] [170] 
.const [102] = Utf8 de/audi/atip/interapp/def/NullSDSService 
.const [103] = Class [171] 
.const [104] = NameAndType [172] [173] 
.const [105] = Class [174] 
.const [106] = NameAndType [175] [176] 
.const [107] = Class [177] 
.const [108] = NameAndType [178] [179] 
.const [109] = Class [180] 
.const [110] = NameAndType [181] [182] 
.const [111] = Utf8 java/lang/Class 
.const [112] = Utf8 forName 
.const [113] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [114] = Utf8 de/audi/app/ecall/core/sds/EcallSDSHandler 
.const [115] = Utf8 class$de$audi$atip$interapp$SDSService 
.const [116] = Utf8 Ljava/lang/Class; 
.const [117] = Utf8 de/audi/app/ecall/core/sds/EcallSDSHandler 
.const [118] = Utf8 class$ 
.const [119] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [120] = Utf8 java/lang/NoClassDefFoundError 
.const [121] = Utf8 initCause 
.const [122] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [123] = Utf8 de/audi/app/ecall/core/sds/EcallSDSHandler 
.const [124] = Utf8 getApplication 
.const [125] = Utf8 ()Lde/audi/app/ecall/core/IEcallApplication; 
.const [126] = Utf8 java/lang/Class 
.const [127] = Utf8 getName 
.const [128] = Utf8 ()Ljava/lang/String; 
.const [129] = Utf8 de/audi/app/ecall/core/sds/EcallSDSHandler 
.const [130] = Utf8 log 
.const [131] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [132] = Utf8 de/audi/app/ecall/core/sds/EcallSDSHandler 
.const [133] = Utf8 sdsPhoneServiceListenerTracker 
.const [134] = Utf8 Lde/audi/app/ecall/core/osgi/EcallServiceTracker; 
.const [135] = Utf8 de/audi/app/ecall/core/sds/EcallSDSHandler 
.const [136] = Utf8 getLogger 
.const [137] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [138] = Utf8 de/audi/app/ecall/core/sds/EcallSDSHandler 
.const [139] = Utf8 sdsService 
.const [140] = Utf8 Lde/audi/atip/interapp/SDSService; 
.const [141] = Utf8 de/audi/app/ecall/core/osgi/EcallServiceTracker 
.const [142] = Utf8 openTracker 
.const [143] = Utf8 ()V 
.const [144] = Utf8 de/audi/app/ecall/core/osgi/EcallServiceTracker 
.const [145] = Utf8 closeTracker 
.const [146] = Utf8 ()V 
.const [147] = Utf8 de/audi/atip/log/LogChannel 
.const [148] = Utf8 log 
.const [149] = Utf8 (ILjava/lang/String;)Z 
.const [150] = Utf8 java/lang/NoClassDefFoundError 
.const [151] = Utf8 <init> 
.const [152] = Utf8 ()V 
.const [153] = Utf8 de/audi/app/ecall/core/AbstractEcallComponent 
.const [154] = Utf8 <init> 
.const [155] = Utf8 (Lde/audi/app/ecall/core/IEcallApplication;Ljava/lang/String;)V 
.const [156] = Utf8 de/audi/app/ecall/core/sds/EcallSDSHandler 
.const [157] = Utf8 class$de$audi$atip$interapp$SDSService 
.const [158] = Utf8 Ljava/lang/Class; 
.const [159] = Utf8 de/audi/app/ecall/core/osgi/EcallServiceTracker 
.const [160] = Utf8 <init> 
.const [161] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;Lde/audi/atip/log/LogChannel;)V 
.const [162] = Utf8 de/audi/atip/interapp/def/NullSDSService 
.const [163] = Utf8 <init> 
.const [164] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [165] = Utf8 de/audi/app/ecall/core/IEcallApplication 
.const [166] = Utf8 getBundleContext 
.const [167] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [168] = Utf8 de/audi/app/ecall/core/sds/EcallSDSHandler 
.const [169] = Utf8 sdsPhoneServiceListenerTracker 
.const [170] = Utf8 Lde/audi/app/ecall/core/osgi/EcallServiceTracker; 
.const [171] = Utf8 de/audi/app/ecall/core/sds/EcallSDSHandler 
.const [172] = Utf8 sdsService 
.const [173] = Utf8 Lde/audi/atip/interapp/SDSService; 
.const [174] = Utf8 org/osgi/framework/BundleContext 
.const [175] = Utf8 getService 
.const [176] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [177] = Utf8 org/osgi/framework/BundleContext 
.const [178] = Utf8 ungetService 
.const [179] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [180] = Utf8 de/audi/atip/interapp/SDSService 
.const [181] = Utf8 disablePTT 
.const [182] = Utf8 (ZZB)V 
.const [183] = Utf8 de/audi/app/ecall/core/sds/EcallSDSHandler 
.const [184] = Class [183] 
.const [185] = Utf8 de/audi/app/ecall/core/AbstractEcallComponent 
.const [186] = Class [185] 
.const [187] = Utf8 de/audi/app/ecall/core/sds/SDSHandler 
.const [188] = Class [187] 
.const [189] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [190] = Class [189] 
.const [191] = Utf8 sdsPhoneServiceListenerTracker 
.const [192] = Utf8 Lde/audi/app/ecall/core/osgi/EcallServiceTracker; 
.const [193] = Utf8 sdsService 
.const [194] = Utf8 Lde/audi/atip/interapp/SDSService; 
.const [195] = Utf8 class$de$audi$atip$interapp$SDSService 
.const [196] = Utf8 Ljava/lang/Class; 
.const [197] = Utf8 Code 
.const [198] = Utf8 <init> 
.const [199] = Utf8 (Lde/audi/app/ecall/core/IEcallApplication;Ljava/lang/String;)V 
.const [200] = Utf8 init 
.const [201] = Utf8 ()V 
.const [202] = Utf8 deinit 
.const [203] = Utf8 ()V 
.const [204] = Utf8 addingService 
.const [205] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [206] = Utf8 modifiedService 
.const [207] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [208] = Utf8 removedService 
.const [209] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [210] = Utf8 enablePTT 
.const [211] = Utf8 ()V 
.const [212] = Utf8 disablePTT 
.const [213] = Utf8 ()V 
.const [214] = Utf8 class$ 
.const [215] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
