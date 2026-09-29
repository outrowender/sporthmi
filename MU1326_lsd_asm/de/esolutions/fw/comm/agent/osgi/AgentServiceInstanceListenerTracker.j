.version 50 0 
.class public super [237] 
.super [239] 
.implements [241] 
.field public static final [242] [243] 
.field private static final [244] [245] 
.field private final [246] [247] 
.field private final [248] [249] 
.field private final [250] [251] 
.field static synthetic [252] [253] 
.field static synthetic [254] [255] 

.method public [257] : [258] 
    .attribute [256] .code stack 6 locals 0 
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

.method public [259] : [260] 
    .attribute [256] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [36] 
L4:     invokevirtual [37] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [261] : [262] 
    .attribute [256] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [36] 
L4:     invokevirtual [38] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [263] : [264] 
    .attribute [256] .code stack 4 locals 5 
L0:     aload_0 
L1:     getfield [34] 
L4:     aload_1 
L5:     invokeinterface [55] 0 
L10:    astore_2 
L11:    aload_2 
L12:    instanceof [9] 
L15:    ifeq L115 
L18:    aload_1 
L19:    getstatic [10] 
L22:    invokeinterface [56] 0 
L27:    astore_3 
L28:    aload_3 
L29:    instanceof [11] 
L32:    ifeq L102 
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
L55:    invokevirtual [39] 
L58:    pop 
        .catch [14] from L59 to L70 using L73 
L59:    aload_0 
L60:    getfield [33] 
L63:    aload 4 
L65:    aload 5 
L67:    invokevirtual [40] 
L70:    goto L87 
L73:    astore 6 
L75:    getstatic [12] 
L78:    iconst_4 
L79:    ldc [15] 
L81:    aload 6 
L83:    invokevirtual [39] 
L86:    pop 
L87:    getstatic [12] 
L90:    iconst_0 
L91:    ldc [16] 
L93:    aload 4 
L95:    invokevirtual [39] 
L98:    pop 
L99:    goto L115 
L102:   getstatic [12] 
L105:   iconst_4 
L106:   ldc [17] 
L108:   getstatic [10] 
L111:   invokevirtual [39] 
L114:   pop 
L115:   aload_2 
L116:   areturn 
L117:   nop 
L118:   nop 
L119:   nop 
L120:   
    .end code 
.end method 

.method public enum [265] : [266] 
    .attribute [256] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [267] : [268] 
    .attribute [256] .code stack 4 locals 4 
L0:     aload_0 
L1:     getfield [34] 
L4:     aload_1 
L5:     invokeinterface [57] 0 
L10:    pop 
L11:    aload_2 
L12:    instanceof [9] 
L15:    ifeq L115 
L18:    aload_1 
L19:    getstatic [10] 
L22:    invokeinterface [56] 0 
L27:    astore_3 
L28:    aload_3 
L29:    instanceof [11] 
L32:    ifeq L102 
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
L55:    invokevirtual [39] 
L58:    pop 
        .catch [14] from L59 to L70 using L73 
L59:    aload_0 
L60:    getfield [33] 
L63:    aload 4 
L65:    aload 5 
L67:    invokevirtual [41] 
L70:    goto L87 
L73:    astore 6 
L75:    getstatic [12] 
L78:    iconst_4 
L79:    ldc [19] 
L81:    aload 6 
L83:    invokevirtual [39] 
L86:    pop 
L87:    getstatic [12] 
L90:    iconst_0 
L91:    ldc [20] 
L93:    aload 4 
L95:    invokevirtual [39] 
L98:    pop 
L99:    goto L115 
L102:   getstatic [12] 
L105:   iconst_4 
L106:   ldc [21] 
L108:   getstatic [10] 
L111:   invokevirtual [39] 
L114:   pop 
L115:   return 
L116:   
    .end code 
.end method 

.method static synthetic [269] : [270] 
    .attribute [256] .code stack 2 locals 1 
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

.method static [271] : [272] 
    .attribute [256] .code stack 3 locals 0 
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
L27:    new [58] 
L30:    dup 
L31:    ldc [25] 
L33:    invokespecial [49] 
L36:    putstatic [47] 
L39:    return 
L40:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [59] [60] 
.const [3] = Class [61] 
.const [4] = Class [62] 
.const [5] = Class [63] 
.const [6] = Field [64] [65] 
.const [7] = String [66] 
.const [8] = Method [67] [68] 
.const [9] = Class [69] 
.const [10] = Field [70] [71] 
.const [11] = Class [72] 
.const [12] = Field [73] [74] 
.const [13] = String [75] 
.const [14] = Class [76] 
.const [15] = String [77] 
.const [16] = String [78] 
.const [17] = String [79] 
.const [18] = String [80] 
.const [19] = String [81] 
.const [20] = String [82] 
.const [21] = String [83] 
.const [22] = Field [84] [85] 
.const [23] = String [86] 
.const [24] = Class [87] 
.const [25] = String [88] 
.const [26] = Class [89] 
.const [27] = Class [90] 
.const [28] = Class [91] 
.const [29] = Class [92] 
.const [30] = Class [93] 
.const [31] = Class [94] 
.const [32] = Method [95] [96] 
.const [33] = Field [97] [98] 
.const [34] = Field [99] [100] 
.const [35] = Method [101] [102] 
.const [36] = Field [103] [104] 
.const [37] = Method [105] [106] 
.const [38] = Method [107] [108] 
.const [39] = Method [109] [110] 
.const [40] = Method [111] [112] 
.const [41] = Method [113] [114] 
.const [42] = Method [115] [116] 
.const [43] = Method [117] [118] 
.const [44] = Field [119] [120] 
.const [45] = Method [121] [122] 
.const [46] = Field [123] [124] 
.const [47] = Field [125] [126] 
.const [48] = Field [127] [128] 
.const [49] = Method [129] [130] 
.const [50] = Class [131] 
.const [51] = Field [132] [133] 
.const [52] = Field [134] [135] 
.const [53] = Class [136] 
.const [54] = Field [137] [138] 
.const [55] = InterfaceMethod [139] [140] 
.const [56] = InterfaceMethod [141] [142] 
.const [57] = InterfaceMethod [143] [144] 
.const [58] = Class [145] 
.const [59] = Class [146] 
.const [60] = NameAndType [147] [148] 
.const [61] = Utf8 java/lang/ClassNotFoundException 
.const [62] = Utf8 java/lang/NoClassDefFoundError 
.const [63] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [64] = Class [149] 
.const [65] = NameAndType [150] [151] 
.const [66] = Utf8 'de.esolutions.fw.comm.core.IServiceInstanceListener' 
.const [67] = Class [152] 
.const [68] = NameAndType [153] [154] 
.const [69] = Utf8 de/esolutions/fw/comm/core/IServiceInstanceListener 
.const [70] = Class [155] 
.const [71] = NameAndType [156] [157] 
.const [72] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [73] = Class [158] 
.const [74] = NameAndType [159] [160] 
.const [75] = Utf8 '+ registering IServiceInstanceListener for %1' 
.const [76] = Utf8 java/lang/Exception 
.const [77] = Utf8 'Failed ServiceInstanceListener Registration: %1' 
.const [78] = Utf8 '- registering IServiceInstanceListener for %1' 
.const [79] = Utf8 "can't register listener: No ServiceInstanceID property found: %1" 
.const [80] = Utf8 '+ unregistering IServiceInstanceListener for %1' 
.const [81] = Utf8 'Failed ServiceInstanceListener Unregistration: %1' 
.const [82] = Utf8 '- unregistering IServiceInstanceListener for %1' 
.const [83] = Utf8 "can't unregister listener: No IService property found: %1" 
.const [84] = Class [161] 
.const [85] = NameAndType [162] [163] 
.const [86] = Utf8 'de.esolutions.fw.comm.core.ServiceInstanceID' 
.const [87] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [88] = Utf8 'comm.agent.osgi.ServiceInstanceListenerTracker' 
.const [89] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceInstanceListenerTracker 
.const [90] = Utf8 java/lang/Object 
.const [91] = Utf8 java/lang/Class 
.const [92] = Utf8 org/osgi/framework/BundleContext 
.const [93] = Utf8 org/osgi/framework/ServiceReference 
.const [94] = Utf8 de/esolutions/fw/comm/agent/Agent 
.const [95] = Class [164] 
.const [96] = NameAndType [165] [166] 
.const [97] = Class [167] 
.const [98] = NameAndType [168] [169] 
.const [99] = Class [170] 
.const [100] = NameAndType [171] [172] 
.const [101] = Class [173] 
.const [102] = NameAndType [174] [175] 
.const [103] = Class [176] 
.const [104] = NameAndType [177] [178] 
.const [105] = Class [179] 
.const [106] = NameAndType [180] [181] 
.const [107] = Class [182] 
.const [108] = NameAndType [183] [184] 
.const [109] = Class [185] 
.const [110] = NameAndType [186] [187] 
.const [111] = Class [188] 
.const [112] = NameAndType [189] [190] 
.const [113] = Class [191] 
.const [114] = NameAndType [192] [193] 
.const [115] = Class [194] 
.const [116] = NameAndType [195] [196] 
.const [117] = Class [197] 
.const [118] = NameAndType [198] [199] 
.const [119] = Class [200] 
.const [120] = NameAndType [201] [202] 
.const [121] = Class [203] 
.const [122] = NameAndType [204] [205] 
.const [123] = Class [206] 
.const [124] = NameAndType [207] [208] 
.const [125] = Class [209] 
.const [126] = NameAndType [210] [211] 
.const [127] = Class [212] 
.const [128] = NameAndType [213] [214] 
.const [129] = Class [215] 
.const [130] = NameAndType [216] [217] 
.const [131] = Utf8 java/lang/NoClassDefFoundError 
.const [132] = Class [218] 
.const [133] = NameAndType [219] [220] 
.const [134] = Class [221] 
.const [135] = NameAndType [222] [223] 
.const [136] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [137] = Class [224] 
.const [138] = NameAndType [225] [226] 
.const [139] = Class [227] 
.const [140] = NameAndType [228] [229] 
.const [141] = Class [230] 
.const [142] = NameAndType [231] [232] 
.const [143] = Class [233] 
.const [144] = NameAndType [234] [235] 
.const [145] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [146] = Utf8 java/lang/Class 
.const [147] = Utf8 forName 
.const [148] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [149] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceInstanceListenerTracker 
.const [150] = Utf8 class$de$esolutions$fw$comm$core$IServiceInstanceListener 
.const [151] = Utf8 Ljava/lang/Class; 
.const [152] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceInstanceListenerTracker 
.const [153] = Utf8 class$ 
.const [154] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [155] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceInstanceListenerTracker 
.const [156] = Utf8 SERVICE_INSTANCE_ID_PROPERTY 
.const [157] = Utf8 Ljava/lang/String; 
.const [158] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceInstanceListenerTracker 
.const [159] = Utf8 trace 
.const [160] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [161] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceInstanceListenerTracker 
.const [162] = Utf8 class$de$esolutions$fw$comm$core$ServiceInstanceID 
.const [163] = Utf8 Ljava/lang/Class; 
.const [164] = Utf8 java/lang/NoClassDefFoundError 
.const [165] = Utf8 initCause 
.const [166] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [167] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceInstanceListenerTracker 
.const [168] = Utf8 agent 
.const [169] = Utf8 Lde/esolutions/fw/comm/agent/Agent; 
.const [170] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceInstanceListenerTracker 
.const [171] = Utf8 bundleContext 
.const [172] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [173] = Utf8 java/lang/Class 
.const [174] = Utf8 getName 
.const [175] = Utf8 ()Ljava/lang/String; 
.const [176] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceInstanceListenerTracker 
.const [177] = Utf8 tracker 
.const [178] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [179] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [180] = Utf8 'open' 
.const [181] = Utf8 ()V 
.const [182] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [183] = Utf8 close 
.const [184] = Utf8 ()V 
.const [185] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [186] = Utf8 log 
.const [187] = Utf8 (SLjava/lang/String;Ljava/lang/Object;)Z 
.const [188] = Utf8 de/esolutions/fw/comm/agent/Agent 
.const [189] = Utf8 registerServiceInstanceListener 
.const [190] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;Lde/esolutions/fw/comm/core/IServiceInstanceListener;)V 
.const [191] = Utf8 de/esolutions/fw/comm/agent/Agent 
.const [192] = Utf8 unregisterServiceInstanceListener 
.const [193] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;Lde/esolutions/fw/comm/core/IServiceInstanceListener;)V 
.const [194] = Utf8 java/lang/NoClassDefFoundError 
.const [195] = Utf8 <init> 
.const [196] = Utf8 ()V 
.const [197] = Utf8 java/lang/Object 
.const [198] = Utf8 <init> 
.const [199] = Utf8 ()V 
.const [200] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceInstanceListenerTracker 
.const [201] = Utf8 class$de$esolutions$fw$comm$core$IServiceInstanceListener 
.const [202] = Utf8 Ljava/lang/Class; 
.const [203] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [204] = Utf8 <init> 
.const [205] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [206] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceInstanceListenerTracker 
.const [207] = Utf8 SERVICE_INSTANCE_ID_PROPERTY 
.const [208] = Utf8 Ljava/lang/String; 
.const [209] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceInstanceListenerTracker 
.const [210] = Utf8 trace 
.const [211] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [212] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceInstanceListenerTracker 
.const [213] = Utf8 class$de$esolutions$fw$comm$core$ServiceInstanceID 
.const [214] = Utf8 Ljava/lang/Class; 
.const [215] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [216] = Utf8 <init> 
.const [217] = Utf8 (Ljava/lang/String;)V 
.const [218] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceInstanceListenerTracker 
.const [219] = Utf8 agent 
.const [220] = Utf8 Lde/esolutions/fw/comm/agent/Agent; 
.const [221] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceInstanceListenerTracker 
.const [222] = Utf8 bundleContext 
.const [223] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [224] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceInstanceListenerTracker 
.const [225] = Utf8 tracker 
.const [226] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [227] = Utf8 org/osgi/framework/BundleContext 
.const [228] = Utf8 getService 
.const [229] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [230] = Utf8 org/osgi/framework/ServiceReference 
.const [231] = Utf8 getProperty 
.const [232] = Utf8 (Ljava/lang/String;)Ljava/lang/Object; 
.const [233] = Utf8 org/osgi/framework/BundleContext 
.const [234] = Utf8 ungetService 
.const [235] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [236] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceInstanceListenerTracker 
.const [237] = Class [236] 
.const [238] = Utf8 java/lang/Object 
.const [239] = Class [238] 
.const [240] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [241] = Class [240] 
.const [242] = Utf8 SERVICE_INSTANCE_ID_PROPERTY 
.const [243] = Utf8 Ljava/lang/String; 
.const [244] = Utf8 trace 
.const [245] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [246] = Utf8 agent 
.const [247] = Utf8 Lde/esolutions/fw/comm/agent/Agent; 
.const [248] = Utf8 bundleContext 
.const [249] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [250] = Utf8 tracker 
.const [251] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [252] = Utf8 class$de$esolutions$fw$comm$core$ServiceInstanceID 
.const [253] = Utf8 Ljava/lang/Class; 
.const [254] = Utf8 class$de$esolutions$fw$comm$core$IServiceInstanceListener 
.const [255] = Utf8 Ljava/lang/Class; 
.const [256] = Utf8 Code 
.const [257] = Utf8 <init> 
.const [258] = Utf8 (Lde/esolutions/fw/comm/agent/Agent;Lorg/osgi/framework/BundleContext;)V 
.const [259] = Utf8 'open' 
.const [260] = Utf8 ()V 
.const [261] = Utf8 close 
.const [262] = Utf8 ()V 
.const [263] = Utf8 addingService 
.const [264] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [265] = Utf8 modifiedService 
.const [266] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [267] = Utf8 removedService 
.const [268] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [269] = Utf8 class$ 
.const [270] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [271] = Utf8 <clinit> 
.const [272] = Utf8 ()V 
.end class 
