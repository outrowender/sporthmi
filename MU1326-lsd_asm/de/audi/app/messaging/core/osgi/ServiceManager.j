.version 50 0 
.class public final super [219] 
.super [221] 
.implements [223] 
.field private final [224] [225] 
.field private final [226] [227] 
.field private final [228] [229] 
.field private final [230] [231] 
.field private final [232] [233] 
.field private [234] [235] 

.method public [237] : [238] 
    .attribute [236] .code stack 3 locals 2 
L0:     aload_0 
L1:     invokespecial [27] 
L4:     aload_0 
L5:     new [31] 
L8:     dup 
L9:     invokespecial [28] 
L12:    putfield [32] 
L15:    aload_0 
L16:    new [31] 
L19:    dup 
L20:    invokespecial [28] 
L23:    putfield [33] 
L26:    aload_0 
L27:    new [31] 
L30:    dup 
L31:    invokespecial [28] 
L34:    putfield [34] 
L37:    aload_0 
L38:    aload_1 
L39:    invokevirtual [18] 
L42:    putfield [35] 
L45:    aload_0 
L46:    aload_1 
L47:    invokevirtual [20] 
L50:    putfield [36] 
L53:    aload_0 
L54:    dup 
L55:    astore_2 
L56:    monitorenter 
        .catch [0] from L57 to L64 using L67 
L57:    aload_0 
L58:    iconst_0 
L59:    putfield [37] 
L62:    aload_2 
L63:    monitorexit 
L64:    goto L72 
        .catch [0] from L67 to L70 using L67 
L67:    astore_3 
L68:    aload_2 
L69:    monitorexit 
L70:    aload_3 
L71:    athrow 
L72:    return 
L73:    nop 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 

.method public synchronized [239] : [240] 
    .attribute [236] .code stack 4 locals 1 
L0:     aload_0 
L1:     invokespecial [29] 
L4:     aload_0 
L5:     getfield [21] 
L8:     aload_1 
L9:     aload_2 
L10:    aload_3 
L11:    invokeinterface [38] 0 
L16:    astore 4 
L18:    aload_0 
L19:    getfield [15] 
L22:    aload 4 
L24:    invokeinterface [39] 0 
L29:    pop 
L30:    aload 4 
L32:    areturn 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public synchronized [241] : [242] 
    .attribute [236] .code stack 4 locals 1 
L0:     aload_0 
L1:     invokespecial [29] 
L4:     aload_0 
L5:     getfield [21] 
L8:     aload_1 
L9:     aload_2 
L10:    aload_3 
L11:    invokeinterface [40] 0 
L16:    astore 4 
L18:    aload_0 
L19:    getfield [15] 
L22:    aload 4 
L24:    invokeinterface [39] 0 
L29:    pop 
L30:    aload 4 
L32:    areturn 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public synchronized [243] : [244] 
    .attribute [236] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [29] 
L4:     aload_1 
L5:     invokevirtual [23] 
L8:     aload_0 
L9:     getfield [16] 
L12:    aload_1 
L13:    invokeinterface [39] 0 
L18:    pop 
L19:    return 
L20:    
    .end code 
.end method 

.method public synchronized [245] : [246] 
    .attribute [236] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [29] 
L4:     aload_0 
L5:     getfield [19] 
L8:     aload_1 
L9:     invokevirtual [24] 
L12:    aload_1 
L13:    invokevirtual [25] 
L16:    invokeinterface [41] 0 
L21:    pop 
L22:    aload_0 
L23:    getfield [17] 
L26:    aload_1 
L27:    invokeinterface [39] 0 
L32:    pop 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public synchronized [247] : [248] 
    .attribute [236] .code stack 3 locals 2 
L0:     aload_0 
L1:     invokespecial [29] 
L4:     aload_0 
L5:     iconst_1 
L6:     putfield [37] 
L9:     aload_0 
L10:    getfield [15] 
L13:    invokeinterface [42] 0 
L18:    astore_1 
L19:    aload_1 
L20:    invokeinterface [43] 0 
L25:    ifeq L45 
L28:    aload_1 
L29:    invokeinterface [44] 0 
L34:    checkcast [3] 
L37:    invokeinterface [45] 0 
L42:    goto L19 
L45:    aload_0 
L46:    getfield [16] 
L49:    invokeinterface [42] 0 
L54:    astore_1 
L55:    aload_1 
L56:    invokeinterface [43] 0 
L61:    ifeq L79 
L64:    aload_1 
L65:    invokeinterface [44] 0 
L70:    checkcast [4] 
L73:    invokevirtual [26] 
L76:    goto L55 
L79:    aload_0 
L80:    getfield [17] 
L83:    invokeinterface [42] 0 
L88:    astore_1 
L89:    aload_1 
L90:    invokeinterface [43] 0 
L95:    ifeq L128 
L98:    aload_1 
L99:    invokeinterface [44] 0 
L104:   checkcast [5] 
L107:   astore_2 
L108:   aload_0 
L109:   getfield [19] 
L112:   aload_2 
L113:   invokevirtual [24] 
L116:   aload_2 
L117:   invokevirtual [25] 
L120:   invokeinterface [46] 0 
L125:   goto L89 
L128:   return 
L129:   nop 
L130:   nop 
L131:   nop 
L132:   
    .end code 
.end method 

.method private synchronized [249] : [250] 
    .attribute [236] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     ifeq L17 
L7:     new [47] 
L10:    dup 
L11:    ldc [7] 
L13:    invokespecial [30] 
L16:    athrow 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [48] 
.const [3] = Class [49] 
.const [4] = Class [50] 
.const [5] = Class [51] 
.const [6] = Class [52] 
.const [7] = String [53] 
.const [8] = Class [54] 
.const [9] = Class [55] 
.const [10] = Class [56] 
.const [11] = Class [57] 
.const [12] = Class [58] 
.const [13] = Class [59] 
.const [14] = Class [60] 
.const [15] = Field [61] [62] 
.const [16] = Field [63] [64] 
.const [17] = Field [65] [66] 
.const [18] = Method [67] [68] 
.const [19] = Field [69] [70] 
.const [20] = Method [71] [72] 
.const [21] = Field [73] [74] 
.const [22] = Field [75] [76] 
.const [23] = Method [77] [78] 
.const [24] = Method [79] [80] 
.const [25] = Method [81] [82] 
.const [26] = Method [83] [84] 
.const [27] = Method [85] [86] 
.const [28] = Method [87] [88] 
.const [29] = Method [89] [90] 
.const [30] = Method [91] [92] 
.const [31] = Class [93] 
.const [32] = Field [94] [95] 
.const [33] = Field [96] [97] 
.const [34] = Field [98] [99] 
.const [35] = Field [100] [101] 
.const [36] = Field [102] [103] 
.const [37] = Field [104] [105] 
.const [38] = InterfaceMethod [106] [107] 
.const [39] = InterfaceMethod [108] [109] 
.const [40] = InterfaceMethod [110] [111] 
.const [41] = InterfaceMethod [112] [113] 
.const [42] = InterfaceMethod [114] [115] 
.const [43] = InterfaceMethod [116] [117] 
.const [44] = InterfaceMethod [118] [119] 
.const [45] = InterfaceMethod [120] [121] 
.const [46] = InterfaceMethod [122] [123] 
.const [47] = Class [124] 
.const [48] = Utf8 java/util/ArrayList 
.const [49] = Utf8 org/osgi/framework/ServiceRegistration 
.const [50] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [51] = Utf8 de/audi/app/messaging/core/osgi/DsiDescriptor 
.const [52] = Utf8 java/lang/IllegalStateException 
.const [53] = Utf8 'Registry has already been disconnected and is therefore no longer operational.' 
.const [54] = Utf8 de/audi/app/messaging/core/osgi/ServiceManager 
.const [55] = Utf8 java/lang/Object 
.const [56] = Utf8 de/audi/app/messaging/core/osgi/MessagingBundleContext 
.const [57] = Utf8 org/osgi/framework/BundleContext 
.const [58] = Utf8 java/util/List 
.const [59] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [60] = Utf8 java/util/Iterator 
.const [61] = Class [125] 
.const [62] = NameAndType [126] [127] 
.const [63] = Class [128] 
.const [64] = NameAndType [129] [130] 
.const [65] = Class [131] 
.const [66] = NameAndType [132] [133] 
.const [67] = Class [134] 
.const [68] = NameAndType [135] [136] 
.const [69] = Class [137] 
.const [70] = NameAndType [138] [139] 
.const [71] = Class [140] 
.const [72] = NameAndType [141] [142] 
.const [73] = Class [143] 
.const [74] = NameAndType [144] [145] 
.const [75] = Class [146] 
.const [76] = NameAndType [147] [148] 
.const [77] = Class [149] 
.const [78] = NameAndType [150] [151] 
.const [79] = Class [152] 
.const [80] = NameAndType [153] [154] 
.const [81] = Class [155] 
.const [82] = NameAndType [156] [157] 
.const [83] = Class [158] 
.const [84] = NameAndType [159] [160] 
.const [85] = Class [161] 
.const [86] = NameAndType [162] [163] 
.const [87] = Class [164] 
.const [88] = NameAndType [165] [166] 
.const [89] = Class [167] 
.const [90] = NameAndType [168] [169] 
.const [91] = Class [170] 
.const [92] = NameAndType [171] [172] 
.const [93] = Utf8 java/util/ArrayList 
.const [94] = Class [173] 
.const [95] = NameAndType [174] [175] 
.const [96] = Class [176] 
.const [97] = NameAndType [177] [178] 
.const [98] = Class [179] 
.const [99] = NameAndType [180] [181] 
.const [100] = Class [182] 
.const [101] = NameAndType [183] [184] 
.const [102] = Class [185] 
.const [103] = NameAndType [186] [187] 
.const [104] = Class [188] 
.const [105] = NameAndType [189] [190] 
.const [106] = Class [191] 
.const [107] = NameAndType [192] [193] 
.const [108] = Class [194] 
.const [109] = NameAndType [195] [196] 
.const [110] = Class [197] 
.const [111] = NameAndType [198] [199] 
.const [112] = Class [200] 
.const [113] = NameAndType [201] [202] 
.const [114] = Class [203] 
.const [115] = NameAndType [204] [205] 
.const [116] = Class [206] 
.const [117] = NameAndType [207] [208] 
.const [118] = Class [209] 
.const [119] = NameAndType [210] [211] 
.const [120] = Class [212] 
.const [121] = NameAndType [213] [214] 
.const [122] = Class [215] 
.const [123] = NameAndType [216] [217] 
.const [124] = Utf8 java/lang/IllegalStateException 
.const [125] = Utf8 de/audi/app/messaging/core/osgi/ServiceManager 
.const [126] = Utf8 services 
.const [127] = Utf8 Ljava/util/List; 
.const [128] = Utf8 de/audi/app/messaging/core/osgi/ServiceManager 
.const [129] = Utf8 trackers 
.const [130] = Utf8 Ljava/util/List; 
.const [131] = Utf8 de/audi/app/messaging/core/osgi/ServiceManager 
.const [132] = Utf8 dsis 
.const [133] = Utf8 Ljava/util/List; 
.const [134] = Utf8 de/audi/app/messaging/core/osgi/MessagingBundleContext 
.const [135] = Utf8 getFramework 
.const [136] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [137] = Utf8 de/audi/app/messaging/core/osgi/ServiceManager 
.const [138] = Utf8 framework 
.const [139] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [140] = Utf8 de/audi/app/messaging/core/osgi/MessagingBundleContext 
.const [141] = Utf8 getBundleContext 
.const [142] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [143] = Utf8 de/audi/app/messaging/core/osgi/ServiceManager 
.const [144] = Utf8 bundleContext 
.const [145] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [146] = Utf8 de/audi/app/messaging/core/osgi/ServiceManager 
.const [147] = Utf8 disconnected 
.const [148] = Utf8 Z 
.const [149] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [150] = Utf8 'open' 
.const [151] = Utf8 ()V 
.const [152] = Utf8 de/audi/app/messaging/core/osgi/DsiDescriptor 
.const [153] = Utf8 getInterfaceName 
.const [154] = Utf8 ()Ljava/lang/String; 
.const [155] = Utf8 de/audi/app/messaging/core/osgi/DsiDescriptor 
.const [156] = Utf8 getInstanceId 
.const [157] = Utf8 ()I 
.const [158] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [159] = Utf8 close 
.const [160] = Utf8 ()V 
.const [161] = Utf8 java/lang/Object 
.const [162] = Utf8 <init> 
.const [163] = Utf8 ()V 
.const [164] = Utf8 java/util/ArrayList 
.const [165] = Utf8 <init> 
.const [166] = Utf8 ()V 
.const [167] = Utf8 de/audi/app/messaging/core/osgi/ServiceManager 
.const [168] = Utf8 assertConnected 
.const [169] = Utf8 ()V 
.const [170] = Utf8 java/lang/IllegalStateException 
.const [171] = Utf8 <init> 
.const [172] = Utf8 (Ljava/lang/String;)V 
.const [173] = Utf8 de/audi/app/messaging/core/osgi/ServiceManager 
.const [174] = Utf8 services 
.const [175] = Utf8 Ljava/util/List; 
.const [176] = Utf8 de/audi/app/messaging/core/osgi/ServiceManager 
.const [177] = Utf8 trackers 
.const [178] = Utf8 Ljava/util/List; 
.const [179] = Utf8 de/audi/app/messaging/core/osgi/ServiceManager 
.const [180] = Utf8 dsis 
.const [181] = Utf8 Ljava/util/List; 
.const [182] = Utf8 de/audi/app/messaging/core/osgi/ServiceManager 
.const [183] = Utf8 framework 
.const [184] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [185] = Utf8 de/audi/app/messaging/core/osgi/ServiceManager 
.const [186] = Utf8 bundleContext 
.const [187] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [188] = Utf8 de/audi/app/messaging/core/osgi/ServiceManager 
.const [189] = Utf8 disconnected 
.const [190] = Utf8 Z 
.const [191] = Utf8 org/osgi/framework/BundleContext 
.const [192] = Utf8 registerService 
.const [193] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [194] = Utf8 java/util/List 
.const [195] = Utf8 add 
.const [196] = Utf8 (Ljava/lang/Object;)Z 
.const [197] = Utf8 org/osgi/framework/BundleContext 
.const [198] = Utf8 registerService 
.const [199] = Utf8 ([Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [200] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [201] = Utf8 startDSIService 
.const [202] = Utf8 (Ljava/lang/String;I)Z 
.const [203] = Utf8 java/util/List 
.const [204] = Utf8 iterator 
.const [205] = Utf8 ()Ljava/util/Iterator; 
.const [206] = Utf8 java/util/Iterator 
.const [207] = Utf8 hasNext 
.const [208] = Utf8 ()Z 
.const [209] = Utf8 java/util/Iterator 
.const [210] = Utf8 next 
.const [211] = Utf8 ()Ljava/lang/Object; 
.const [212] = Utf8 org/osgi/framework/ServiceRegistration 
.const [213] = Utf8 unregister 
.const [214] = Utf8 ()V 
.const [215] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [216] = Utf8 stopDSIService 
.const [217] = Utf8 (Ljava/lang/String;I)V 
.const [218] = Utf8 de/audi/app/messaging/core/osgi/ServiceManager 
.const [219] = Class [218] 
.const [220] = Utf8 java/lang/Object 
.const [221] = Class [220] 
.const [222] = Utf8 de/audi/app/messaging/core/osgi/IServiceRegistry 
.const [223] = Class [222] 
.const [224] = Utf8 framework 
.const [225] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [226] = Utf8 bundleContext 
.const [227] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [228] = Utf8 services 
.const [229] = Utf8 Ljava/util/List; 
.const [230] = Utf8 trackers 
.const [231] = Utf8 Ljava/util/List; 
.const [232] = Utf8 dsis 
.const [233] = Utf8 Ljava/util/List; 
.const [234] = Utf8 disconnected 
.const [235] = Utf8 Z 
.const [236] = Utf8 Code 
.const [237] = Utf8 <init> 
.const [238] = Utf8 (Lde/audi/app/messaging/core/osgi/MessagingBundleContext;)V 
.const [239] = Utf8 registerService 
.const [240] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [241] = Utf8 registerService 
.const [242] = Utf8 ([Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [243] = Utf8 addTracker 
.const [244] = Utf8 (Lorg/osgi/util/tracker/ServiceTracker;)V 
.const [245] = Utf8 startDsiService 
.const [246] = Utf8 (Lde/audi/app/messaging/core/osgi/DsiDescriptor;)V 
.const [247] = Utf8 disconnect 
.const [248] = Utf8 ()V 
.const [249] = Utf8 assertConnected 
.const [250] = Utf8 ()V 
.end class 
