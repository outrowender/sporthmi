.version 50 0 
.class public super [243] 
.super [245] 
.implements [247] 
.field public static final [248] [249] 
.field private static final [250] [251] 
.field private final [252] [253] 
.field private final [254] [255] 
.field private final [256] [257] 
.field static synthetic [258] [259] 
.field static synthetic [260] [261] 

.method public [263] : [264] 
    .attribute [262] .code stack 6 locals 0 
L0:     aload_0 
L1:     invokespecial [43] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [51] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [52] 
L14:    aload_0 
L15:    new [53] 
L18:    dup 
L19:    aload_2 
L20:    getstatic [6] 
L23:    ifnonnull L38 
L26:    ldc [7] 
L28:    invokestatic [8] 
L31:    dup 
L32:    putstatic [44] 
L35:    goto L41 
L38:    getstatic [6] 
L41:    invokevirtual [35] 
L44:    aload_0 
L45:    invokespecial [45] 
L48:    putfield [54] 
L51:    return 
L52:    
    .end code 
.end method 

.method public [265] : [266] 
    .attribute [262] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [36] 
L4:     invokevirtual [37] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [267] : [268] 
    .attribute [262] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [36] 
L4:     invokevirtual [38] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [269] : [270] 
    .attribute [262] .code stack 4 locals 5 
L0:     aload_0 
L1:     getfield [34] 
L4:     aload_1 
L5:     invokeinterface [55] 0 
L10:    astore_2 
L11:    aload_2 
L12:    instanceof [9] 
L15:    ifeq L125 
L18:    aload_1 
L19:    getstatic [10] 
L22:    invokeinterface [56] 0 
L27:    astore_3 
L28:    aload_3 
L29:    instanceof [11] 
L32:    ifeq L112 
L35:    aload_3 
L36:    checkcast [11] 
L39:    astore 4 
L41:    aload_2 
L42:    checkcast [9] 
L45:    astore 5 
L47:    getstatic [12] 
L50:    iconst_0 
L51:    ldc [13] 
L53:    aload 4 
L55:    invokeinterface [57] 0 
L60:    invokevirtual [39] 
L63:    pop 
        .catch [14] from L64 to L75 using L78 
L64:    aload_0 
L65:    getfield [33] 
L68:    aload 4 
L70:    aload 5 
L72:    invokevirtual [40] 
L75:    goto L92 
L78:    astore 6 
L80:    getstatic [12] 
L83:    iconst_4 
L84:    ldc [15] 
L86:    aload 6 
L88:    invokevirtual [39] 
L91:    pop 
L92:    getstatic [12] 
L95:    iconst_0 
L96:    ldc [16] 
L98:    aload 4 
L100:   invokeinterface [57] 0 
L105:   invokevirtual [39] 
L108:   pop 
L109:   goto L125 
L112:   getstatic [12] 
L115:   iconst_4 
L116:   ldc [17] 
L118:   getstatic [10] 
L121:   invokevirtual [39] 
L124:   pop 
L125:   aload_2 
L126:   areturn 
L127:   nop 
L128:   
    .end code 
.end method 

.method public enum [271] : [272] 
    .attribute [262] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [273] : [274] 
    .attribute [262] .code stack 4 locals 4 
L0:     aload_0 
L1:     getfield [34] 
L4:     aload_1 
L5:     invokeinterface [58] 0 
L10:    pop 
L11:    aload_2 
L12:    instanceof [9] 
L15:    ifeq L125 
L18:    aload_1 
L19:    getstatic [10] 
L22:    invokeinterface [56] 0 
L27:    astore_3 
L28:    aload_3 
L29:    instanceof [11] 
L32:    ifeq L112 
L35:    aload_3 
L36:    checkcast [11] 
L39:    astore 4 
L41:    aload_2 
L42:    checkcast [9] 
L45:    astore 5 
L47:    getstatic [12] 
L50:    iconst_0 
L51:    ldc [18] 
L53:    aload 4 
L55:    invokeinterface [57] 0 
L60:    invokevirtual [39] 
L63:    pop 
        .catch [14] from L64 to L75 using L78 
L64:    aload_0 
L65:    getfield [33] 
L68:    aload 4 
L70:    aload 5 
L72:    invokevirtual [41] 
L75:    goto L92 
L78:    astore 6 
L80:    getstatic [12] 
L83:    iconst_4 
L84:    ldc [19] 
L86:    aload 6 
L88:    invokevirtual [39] 
L91:    pop 
L92:    getstatic [12] 
L95:    iconst_0 
L96:    ldc [20] 
L98:    aload 4 
L100:   invokeinterface [57] 0 
L105:   invokevirtual [39] 
L108:   pop 
L109:   goto L125 
L112:   getstatic [12] 
L115:   iconst_4 
L116:   ldc [21] 
L118:   getstatic [10] 
L121:   invokevirtual [39] 
L124:   pop 
L125:   return 
L126:   nop 
L127:   nop 
L128:   
    .end code 
.end method 

.method static synthetic [275] : [276] 
    .attribute [262] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [50] 
L9:     dup 
L10:    invokespecial [42] 
L13:    aload_1 
L14:    invokevirtual [32] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static [277] : [278] 
    .attribute [262] .code stack 3 locals 0 
L0:     getstatic [22] 
L3:     ifnonnull L18 
L6:     ldc [23] 
L8:     invokestatic [8] 
L11:    dup 
L12:    putstatic [48] 
L15:    goto L21 
L18:    getstatic [22] 
L21:    invokevirtual [35] 
L24:    putstatic [46] 
L27:    new [59] 
L30:    dup 
L31:    ldc [25] 
L33:    invokespecial [49] 
L36:    putstatic [47] 
L39:    return 
L40:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [60] [61] 
.const [3] = Class [62] 
.const [4] = Class [63] 
.const [5] = Class [64] 
.const [6] = Field [65] [66] 
.const [7] = String [67] 
.const [8] = Method [68] [69] 
.const [9] = Class [70] 
.const [10] = Field [71] [72] 
.const [11] = Class [73] 
.const [12] = Field [74] [75] 
.const [13] = String [76] 
.const [14] = Class [77] 
.const [15] = String [78] 
.const [16] = String [79] 
.const [17] = String [80] 
.const [18] = String [81] 
.const [19] = String [82] 
.const [20] = String [83] 
.const [21] = String [84] 
.const [22] = Field [85] [86] 
.const [23] = String [87] 
.const [24] = Class [88] 
.const [25] = String [89] 
.const [26] = Class [90] 
.const [27] = Class [91] 
.const [28] = Class [92] 
.const [29] = Class [93] 
.const [30] = Class [94] 
.const [31] = Class [95] 
.const [32] = Method [96] [97] 
.const [33] = Field [98] [99] 
.const [34] = Field [100] [101] 
.const [35] = Method [102] [103] 
.const [36] = Field [104] [105] 
.const [37] = Method [106] [107] 
.const [38] = Method [108] [109] 
.const [39] = Method [110] [111] 
.const [40] = Method [112] [113] 
.const [41] = Method [114] [115] 
.const [42] = Method [116] [117] 
.const [43] = Method [118] [119] 
.const [44] = Field [120] [121] 
.const [45] = Method [122] [123] 
.const [46] = Field [124] [125] 
.const [47] = Field [126] [127] 
.const [48] = Field [128] [129] 
.const [49] = Method [130] [131] 
.const [50] = Class [132] 
.const [51] = Field [133] [134] 
.const [52] = Field [135] [136] 
.const [53] = Class [137] 
.const [54] = Field [138] [139] 
.const [55] = InterfaceMethod [140] [141] 
.const [56] = InterfaceMethod [142] [143] 
.const [57] = InterfaceMethod [144] [145] 
.const [58] = InterfaceMethod [146] [147] 
.const [59] = Class [148] 
.const [60] = Class [149] 
.const [61] = NameAndType [150] [151] 
.const [62] = Utf8 java/lang/ClassNotFoundException 
.const [63] = Utf8 java/lang/NoClassDefFoundError 
.const [64] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [65] = Class [152] 
.const [66] = NameAndType [153] [154] 
.const [67] = Utf8 'de.esolutions.fw.comm.core.IServiceListener' 
.const [68] = Class [155] 
.const [69] = NameAndType [156] [157] 
.const [70] = Utf8 de/esolutions/fw/comm/core/IServiceListener 
.const [71] = Class [158] 
.const [72] = NameAndType [159] [160] 
.const [73] = Utf8 de/esolutions/fw/comm/core/IService 
.const [74] = Class [161] 
.const [75] = NameAndType [162] [163] 
.const [76] = Utf8 '+ registering IServiceListener for %1' 
.const [77] = Utf8 java/lang/Exception 
.const [78] = Utf8 'Failed ServiceListener Registration: %1' 
.const [79] = Utf8 '- registering IServiceListener for %1' 
.const [80] = Utf8 "can't register listener: No IService property found: %1" 
.const [81] = Utf8 '+ unregistering IServiceListener for %1' 
.const [82] = Utf8 'Failed ServiceListener Unregistration: %1' 
.const [83] = Utf8 '- unregistering IServiceListener for %1' 
.const [84] = Utf8 "can't unregister listener: No IService property found: %1" 
.const [85] = Class [164] 
.const [86] = NameAndType [165] [166] 
.const [87] = Utf8 'de.esolutions.fw.comm.core.IService' 
.const [88] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [89] = Utf8 'comm.agent.osgi.ServiceListenerTracker' 
.const [90] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceListenerTracker 
.const [91] = Utf8 java/lang/Object 
.const [92] = Utf8 java/lang/Class 
.const [93] = Utf8 org/osgi/framework/BundleContext 
.const [94] = Utf8 org/osgi/framework/ServiceReference 
.const [95] = Utf8 de/esolutions/fw/comm/agent/Agent 
.const [96] = Class [167] 
.const [97] = NameAndType [168] [169] 
.const [98] = Class [170] 
.const [99] = NameAndType [171] [172] 
.const [100] = Class [173] 
.const [101] = NameAndType [174] [175] 
.const [102] = Class [176] 
.const [103] = NameAndType [177] [178] 
.const [104] = Class [179] 
.const [105] = NameAndType [180] [181] 
.const [106] = Class [182] 
.const [107] = NameAndType [183] [184] 
.const [108] = Class [185] 
.const [109] = NameAndType [186] [187] 
.const [110] = Class [188] 
.const [111] = NameAndType [189] [190] 
.const [112] = Class [191] 
.const [113] = NameAndType [192] [193] 
.const [114] = Class [194] 
.const [115] = NameAndType [195] [196] 
.const [116] = Class [197] 
.const [117] = NameAndType [198] [199] 
.const [118] = Class [200] 
.const [119] = NameAndType [201] [202] 
.const [120] = Class [203] 
.const [121] = NameAndType [204] [205] 
.const [122] = Class [206] 
.const [123] = NameAndType [207] [208] 
.const [124] = Class [209] 
.const [125] = NameAndType [210] [211] 
.const [126] = Class [212] 
.const [127] = NameAndType [213] [214] 
.const [128] = Class [215] 
.const [129] = NameAndType [216] [217] 
.const [130] = Class [218] 
.const [131] = NameAndType [219] [220] 
.const [132] = Utf8 java/lang/NoClassDefFoundError 
.const [133] = Class [221] 
.const [134] = NameAndType [222] [223] 
.const [135] = Class [224] 
.const [136] = NameAndType [225] [226] 
.const [137] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [138] = Class [227] 
.const [139] = NameAndType [228] [229] 
.const [140] = Class [230] 
.const [141] = NameAndType [231] [232] 
.const [142] = Class [233] 
.const [143] = NameAndType [234] [235] 
.const [144] = Class [236] 
.const [145] = NameAndType [237] [238] 
.const [146] = Class [239] 
.const [147] = NameAndType [240] [241] 
.const [148] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [149] = Utf8 java/lang/Class 
.const [150] = Utf8 forName 
.const [151] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [152] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceListenerTracker 
.const [153] = Utf8 class$de$esolutions$fw$comm$core$IServiceListener 
.const [154] = Utf8 Ljava/lang/Class; 
.const [155] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceListenerTracker 
.const [156] = Utf8 class$ 
.const [157] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [158] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceListenerTracker 
.const [159] = Utf8 ISERVICE_PROPERTY 
.const [160] = Utf8 Ljava/lang/String; 
.const [161] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceListenerTracker 
.const [162] = Utf8 trace 
.const [163] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [164] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceListenerTracker 
.const [165] = Utf8 class$de$esolutions$fw$comm$core$IService 
.const [166] = Utf8 Ljava/lang/Class; 
.const [167] = Utf8 java/lang/NoClassDefFoundError 
.const [168] = Utf8 initCause 
.const [169] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [170] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceListenerTracker 
.const [171] = Utf8 agent 
.const [172] = Utf8 Lde/esolutions/fw/comm/agent/Agent; 
.const [173] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceListenerTracker 
.const [174] = Utf8 bundleContext 
.const [175] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [176] = Utf8 java/lang/Class 
.const [177] = Utf8 getName 
.const [178] = Utf8 ()Ljava/lang/String; 
.const [179] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceListenerTracker 
.const [180] = Utf8 tracker 
.const [181] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [182] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [183] = Utf8 'open' 
.const [184] = Utf8 ()V 
.const [185] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [186] = Utf8 close 
.const [187] = Utf8 ()V 
.const [188] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [189] = Utf8 log 
.const [190] = Utf8 (SLjava/lang/String;Ljava/lang/Object;)Z 
.const [191] = Utf8 de/esolutions/fw/comm/agent/Agent 
.const [192] = Utf8 registerServiceListener 
.const [193] = Utf8 (Lde/esolutions/fw/comm/core/IService;Lde/esolutions/fw/comm/core/IServiceListener;)V 
.const [194] = Utf8 de/esolutions/fw/comm/agent/Agent 
.const [195] = Utf8 unregisterServiceListener 
.const [196] = Utf8 (Lde/esolutions/fw/comm/core/IService;Lde/esolutions/fw/comm/core/IServiceListener;)V 
.const [197] = Utf8 java/lang/NoClassDefFoundError 
.const [198] = Utf8 <init> 
.const [199] = Utf8 ()V 
.const [200] = Utf8 java/lang/Object 
.const [201] = Utf8 <init> 
.const [202] = Utf8 ()V 
.const [203] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceListenerTracker 
.const [204] = Utf8 class$de$esolutions$fw$comm$core$IServiceListener 
.const [205] = Utf8 Ljava/lang/Class; 
.const [206] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [207] = Utf8 <init> 
.const [208] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [209] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceListenerTracker 
.const [210] = Utf8 ISERVICE_PROPERTY 
.const [211] = Utf8 Ljava/lang/String; 
.const [212] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceListenerTracker 
.const [213] = Utf8 trace 
.const [214] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [215] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceListenerTracker 
.const [216] = Utf8 class$de$esolutions$fw$comm$core$IService 
.const [217] = Utf8 Ljava/lang/Class; 
.const [218] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [219] = Utf8 <init> 
.const [220] = Utf8 (Ljava/lang/String;)V 
.const [221] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceListenerTracker 
.const [222] = Utf8 agent 
.const [223] = Utf8 Lde/esolutions/fw/comm/agent/Agent; 
.const [224] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceListenerTracker 
.const [225] = Utf8 bundleContext 
.const [226] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [227] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceListenerTracker 
.const [228] = Utf8 tracker 
.const [229] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [230] = Utf8 org/osgi/framework/BundleContext 
.const [231] = Utf8 getService 
.const [232] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [233] = Utf8 org/osgi/framework/ServiceReference 
.const [234] = Utf8 getProperty 
.const [235] = Utf8 (Ljava/lang/String;)Ljava/lang/Object; 
.const [236] = Utf8 de/esolutions/fw/comm/core/IService 
.const [237] = Utf8 getInstanceID 
.const [238] = Utf8 ()Lde/esolutions/fw/comm/core/ServiceInstanceID; 
.const [239] = Utf8 org/osgi/framework/BundleContext 
.const [240] = Utf8 ungetService 
.const [241] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [242] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceListenerTracker 
.const [243] = Class [242] 
.const [244] = Utf8 java/lang/Object 
.const [245] = Class [244] 
.const [246] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [247] = Class [246] 
.const [248] = Utf8 ISERVICE_PROPERTY 
.const [249] = Utf8 Ljava/lang/String; 
.const [250] = Utf8 trace 
.const [251] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [252] = Utf8 agent 
.const [253] = Utf8 Lde/esolutions/fw/comm/agent/Agent; 
.const [254] = Utf8 bundleContext 
.const [255] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [256] = Utf8 tracker 
.const [257] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [258] = Utf8 class$de$esolutions$fw$comm$core$IService 
.const [259] = Utf8 Ljava/lang/Class; 
.const [260] = Utf8 class$de$esolutions$fw$comm$core$IServiceListener 
.const [261] = Utf8 Ljava/lang/Class; 
.const [262] = Utf8 Code 
.const [263] = Utf8 <init> 
.const [264] = Utf8 (Lde/esolutions/fw/comm/agent/Agent;Lorg/osgi/framework/BundleContext;)V 
.const [265] = Utf8 'open' 
.const [266] = Utf8 ()V 
.const [267] = Utf8 close 
.const [268] = Utf8 ()V 
.const [269] = Utf8 addingService 
.const [270] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [271] = Utf8 modifiedService 
.const [272] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [273] = Utf8 removedService 
.const [274] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [275] = Utf8 class$ 
.const [276] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [277] = Utf8 <clinit> 
.const [278] = Utf8 ()V 
.end class 
