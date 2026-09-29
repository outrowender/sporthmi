.version 50 0 
.class public super [279] 
.super [281] 
.implements [283] 
.field private [284] [285] 
.field private [286] [287] 
.field private [288] [289] 
.field private [290] [291] 
.field private [292] [293] 
.field private [294] [295] 
.field static synthetic [296] [297] 
.field static synthetic [298] [299] 

.method public annotation [301] : [302] 
    .attribute [300] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [47] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [303] : [304] 
    .attribute [300] .code stack 6 locals 0 
L0:     ldc [5] 
L2:     ldc [6] 
L4:     iconst_1 
L5:     invokestatic [7] 
L8:     aload_0 
L9:     invokestatic [8] 
L12:    putfield [54] 
L15:    aload_0 
L16:    getfield [34] 
L19:    ifnonnull L31 
L22:    getstatic [9] 
L25:    ldc [10] 
L27:    invokevirtual [35] 
L30:    return 
L31:    aload_0 
L32:    aload_0 
L33:    getfield [34] 
L36:    invokevirtual [36] 
L39:    putfield [55] 
L42:    aload_0 
L43:    getfield [37] 
L46:    ifnull L151 
L49:    aload_0 
L50:    getfield [37] 
L53:    invokevirtual [38] 
L56:    ifeq L151 
L59:    aload_0 
L60:    aload_1 
L61:    getstatic [11] 
L64:    ifnonnull L79 
L67:    ldc [12] 
L69:    invokestatic [13] 
L72:    dup 
L73:    putstatic [48] 
L76:    goto L82 
L79:    getstatic [11] 
L82:    invokevirtual [39] 
L85:    invokestatic [8] 
L88:    new [56] 
L91:    dup 
L92:    invokespecial [49] 
L95:    invokeinterface [57] 0 
L100:   putfield [58] 
L103:   aload_0 
L104:   aload_1 
L105:   getstatic [15] 
L108:   ifnonnull L123 
L111:   ldc [16] 
L113:   invokestatic [13] 
L116:   dup 
L117:   putstatic [50] 
L120:   goto L126 
L123:   getstatic [15] 
L126:   invokevirtual [39] 
L129:   aload_0 
L130:   getfield [37] 
L133:   new [56] 
L136:   dup 
L137:   invokespecial [49] 
L140:   invokeinterface [57] 0 
L145:   putfield [59] 
L148:   goto L159 
L151:   getstatic [9] 
L154:   ldc [17] 
L156:   invokevirtual [35] 
L159:   aload_0 
L160:   aload_0 
L161:   getfield [34] 
L164:   ldc [18] 
L166:   new [60] 
L169:   dup 
L170:   ldc [20] 
L172:   invokespecial [51] 
L175:   invokevirtual [42] 
L178:   putfield [61] 
L181:   aload_0 
L182:   aload_0 
L183:   getfield [34] 
L186:   ldc [21] 
L188:   new [62] 
L191:   dup 
L192:   aload_0 
L193:   getfield [37] 
L196:   invokespecial [52] 
L199:   invokevirtual [42] 
L202:   putfield [63] 
L205:   return 
L206:   nop 
L207:   nop 
L208:   
    .end code 
.end method 

.method public [305] : [306] 
    .attribute [300] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [34] 
L4:     ifnull L31 
L7:     aload_0 
L8:     getfield [34] 
L11:    aload_0 
L12:    getfield [43] 
L15:    invokevirtual [45] 
L18:    pop 
L19:    aload_0 
L20:    getfield [34] 
L23:    aload_0 
L24:    getfield [44] 
L27:    invokevirtual [45] 
L30:    pop 
L31:    aload_0 
L32:    getfield [37] 
L35:    ifnull L94 
L38:    aload_0 
L39:    getfield [37] 
L42:    invokevirtual [38] 
L45:    ifeq L94 
L48:    aload_0 
L49:    getfield [40] 
L52:    ifnull L71 
L55:    aload_1 
L56:    aload_0 
L57:    getfield [40] 
L60:    invokeinterface [64] 0 
L65:    invokeinterface [65] 0 
L70:    pop 
L71:    aload_0 
L72:    getfield [41] 
L75:    ifnull L94 
L78:    aload_1 
L79:    aload_0 
L80:    getfield [41] 
L83:    invokeinterface [64] 0 
L88:    invokeinterface [65] 0 
L93:    pop 
L94:    invokestatic [23] 
L97:    return 
L98:    nop 
L99:    nop 
L100:   
    .end code 
.end method 

.method static synthetic [307] : [308] 
    .attribute [300] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [53] 
L9:     dup 
L10:    invokespecial [46] 
L13:    aload_1 
L14:    invokevirtual [33] 
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
.const [5] = String [70] 
.const [6] = String [71] 
.const [7] = Method [72] [73] 
.const [8] = Method [74] [75] 
.const [9] = Field [76] [77] 
.const [10] = String [78] 
.const [11] = Field [79] [80] 
.const [12] = String [81] 
.const [13] = Method [82] [83] 
.const [14] = Class [84] 
.const [15] = Field [85] [86] 
.const [16] = String [87] 
.const [17] = String [88] 
.const [18] = String [89] 
.const [19] = Class [90] 
.const [20] = String [91] 
.const [21] = String [92] 
.const [22] = Class [93] 
.const [23] = Method [94] [95] 
.const [24] = Class [96] 
.const [25] = Class [97] 
.const [26] = Class [98] 
.const [27] = Class [99] 
.const [28] = Class [100] 
.const [29] = Class [101] 
.const [30] = Class [102] 
.const [31] = Class [103] 
.const [32] = Class [104] 
.const [33] = Method [105] [106] 
.const [34] = Field [107] [108] 
.const [35] = Method [109] [110] 
.const [36] = Method [111] [112] 
.const [37] = Field [113] [114] 
.const [38] = Method [115] [116] 
.const [39] = Method [117] [118] 
.const [40] = Field [119] [120] 
.const [41] = Field [121] [122] 
.const [42] = Method [123] [124] 
.const [43] = Field [125] [126] 
.const [44] = Field [127] [128] 
.const [45] = Method [129] [130] 
.const [46] = Method [131] [132] 
.const [47] = Method [133] [134] 
.const [48] = Field [135] [136] 
.const [49] = Method [137] [138] 
.const [50] = Field [139] [140] 
.const [51] = Method [141] [142] 
.const [52] = Method [143] [144] 
.const [53] = Class [145] 
.const [54] = Field [146] [147] 
.const [55] = Field [148] [149] 
.const [56] = Class [150] 
.const [57] = InterfaceMethod [151] [152] 
.const [58] = Field [153] [154] 
.const [59] = Field [155] [156] 
.const [60] = Class [157] 
.const [61] = Field [158] [159] 
.const [62] = Class [160] 
.const [63] = Field [161] [162] 
.const [64] = InterfaceMethod [163] [164] 
.const [65] = InterfaceMethod [165] [166] 
.const [66] = Class [167] 
.const [67] = NameAndType [168] [169] 
.const [68] = Utf8 java/lang/ClassNotFoundException 
.const [69] = Utf8 java/lang/NoClassDefFoundError 
.const [70] = Utf8 hmi 
.const [71] = Utf8 client 
.const [72] = Class [170] 
.const [73] = NameAndType [171] [172] 
.const [74] = Class [173] 
.const [75] = NameAndType [174] [175] 
.const [76] = Class [176] 
.const [77] = NameAndType [177] [178] 
.const [78] = Utf8 'TracingActivator disabled. No client activated! Config problem?' 
.const [79] = Class [179] 
.const [80] = NameAndType [180] [181] 
.const [81] = Utf8 'de.esolutions.fw.util.tracing.TraceClient' 
.const [82] = Class [182] 
.const [83] = NameAndType [183] [184] 
.const [84] = Utf8 java/util/Hashtable 
.const [85] = Class [185] 
.const [86] = NameAndType [186] [187] 
.const [87] = Utf8 'de.esolutions.fw.util.tracing.frontend.TraceFrontend' 
.const [88] = Utf8 'TracingActivator disabled' 
.const [89] = Utf8 'Dump trace entity model' 
.const [90] = Utf8 de/esolutions/fw/util/tracing/osgi/DumpTraceEntityModelCallback 
.const [91] = Utf8 '/tmp' 
.const [92] = Utf8 'Inject Trace Error' 
.const [93] = Utf8 de/esolutions/fw/util/tracing/osgi/InjectErrorCallback 
.const [94] = Class [188] 
.const [95] = NameAndType [189] [190] 
.const [96] = Utf8 de/esolutions/fw/util/tracing/osgi/TracingActivator 
.const [97] = Utf8 java/lang/Object 
.const [98] = Utf8 java/lang/Class 
.const [99] = Utf8 de/esolutions/fw/util/tracing/TraceClient 
.const [100] = Utf8 java/lang/System 
.const [101] = Utf8 java/io/PrintStream 
.const [102] = Utf8 de/esolutions/fw/util/tracing/frontend/TraceFrontend 
.const [103] = Utf8 org/osgi/framework/BundleContext 
.const [104] = Utf8 org/osgi/framework/ServiceRegistration 
.const [105] = Class [191] 
.const [106] = NameAndType [192] [193] 
.const [107] = Class [194] 
.const [108] = NameAndType [195] [196] 
.const [109] = Class [197] 
.const [110] = NameAndType [198] [199] 
.const [111] = Class [200] 
.const [112] = NameAndType [201] [202] 
.const [113] = Class [203] 
.const [114] = NameAndType [204] [205] 
.const [115] = Class [206] 
.const [116] = NameAndType [207] [208] 
.const [117] = Class [209] 
.const [118] = NameAndType [210] [211] 
.const [119] = Class [212] 
.const [120] = NameAndType [213] [214] 
.const [121] = Class [215] 
.const [122] = NameAndType [216] [217] 
.const [123] = Class [218] 
.const [124] = NameAndType [219] [220] 
.const [125] = Class [221] 
.const [126] = NameAndType [222] [223] 
.const [127] = Class [224] 
.const [128] = NameAndType [225] [226] 
.const [129] = Class [227] 
.const [130] = NameAndType [228] [229] 
.const [131] = Class [230] 
.const [132] = NameAndType [231] [232] 
.const [133] = Class [233] 
.const [134] = NameAndType [234] [235] 
.const [135] = Class [236] 
.const [136] = NameAndType [237] [238] 
.const [137] = Class [239] 
.const [138] = NameAndType [240] [241] 
.const [139] = Class [242] 
.const [140] = NameAndType [243] [244] 
.const [141] = Class [245] 
.const [142] = NameAndType [246] [247] 
.const [143] = Class [248] 
.const [144] = NameAndType [249] [250] 
.const [145] = Utf8 java/lang/NoClassDefFoundError 
.const [146] = Class [251] 
.const [147] = NameAndType [252] [253] 
.const [148] = Class [254] 
.const [149] = NameAndType [255] [256] 
.const [150] = Utf8 java/util/Hashtable 
.const [151] = Class [257] 
.const [152] = NameAndType [258] [259] 
.const [153] = Class [260] 
.const [154] = NameAndType [261] [262] 
.const [155] = Class [263] 
.const [156] = NameAndType [264] [265] 
.const [157] = Utf8 de/esolutions/fw/util/tracing/osgi/DumpTraceEntityModelCallback 
.const [158] = Class [266] 
.const [159] = NameAndType [267] [268] 
.const [160] = Utf8 de/esolutions/fw/util/tracing/osgi/InjectErrorCallback 
.const [161] = Class [269] 
.const [162] = NameAndType [270] [271] 
.const [163] = Class [272] 
.const [164] = NameAndType [273] [274] 
.const [165] = Class [275] 
.const [166] = NameAndType [276] [277] 
.const [167] = Utf8 java/lang/Class 
.const [168] = Utf8 forName 
.const [169] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [170] = Utf8 de/esolutions/fw/util/tracing/TraceClient 
.const [171] = Utf8 init 
.const [172] = Utf8 (Ljava/lang/String;Ljava/lang/String;Z)V 
.const [173] = Utf8 de/esolutions/fw/util/tracing/TraceClient 
.const [174] = Utf8 getTraceClient 
.const [175] = Utf8 ()Lde/esolutions/fw/util/tracing/TraceClient; 
.const [176] = Utf8 java/lang/System 
.const [177] = Utf8 out 
.const [178] = Utf8 Ljava/io/PrintStream; 
.const [179] = Utf8 de/esolutions/fw/util/tracing/osgi/TracingActivator 
.const [180] = Utf8 class$de$esolutions$fw$util$tracing$TraceClient 
.const [181] = Utf8 Ljava/lang/Class; 
.const [182] = Utf8 de/esolutions/fw/util/tracing/osgi/TracingActivator 
.const [183] = Utf8 class$ 
.const [184] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [185] = Utf8 de/esolutions/fw/util/tracing/osgi/TracingActivator 
.const [186] = Utf8 class$de$esolutions$fw$util$tracing$frontend$TraceFrontend 
.const [187] = Utf8 Ljava/lang/Class; 
.const [188] = Utf8 de/esolutions/fw/util/tracing/TraceClient 
.const [189] = Utf8 exit 
.const [190] = Utf8 ()V 
.const [191] = Utf8 java/lang/NoClassDefFoundError 
.const [192] = Utf8 initCause 
.const [193] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [194] = Utf8 de/esolutions/fw/util/tracing/osgi/TracingActivator 
.const [195] = Utf8 client 
.const [196] = Utf8 Lde/esolutions/fw/util/tracing/TraceClient; 
.const [197] = Utf8 java/io/PrintStream 
.const [198] = Utf8 println 
.const [199] = Utf8 (Ljava/lang/String;)V 
.const [200] = Utf8 de/esolutions/fw/util/tracing/TraceClient 
.const [201] = Utf8 getFrontend 
.const [202] = Utf8 ()Lde/esolutions/fw/util/tracing/frontend/TraceFrontend; 
.const [203] = Utf8 de/esolutions/fw/util/tracing/osgi/TracingActivator 
.const [204] = Utf8 frontend 
.const [205] = Utf8 Lde/esolutions/fw/util/tracing/frontend/TraceFrontend; 
.const [206] = Utf8 de/esolutions/fw/util/tracing/frontend/TraceFrontend 
.const [207] = Utf8 isEnabled 
.const [208] = Utf8 ()Z 
.const [209] = Utf8 java/lang/Class 
.const [210] = Utf8 getName 
.const [211] = Utf8 ()Ljava/lang/String; 
.const [212] = Utf8 de/esolutions/fw/util/tracing/osgi/TracingActivator 
.const [213] = Utf8 clientService 
.const [214] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [215] = Utf8 de/esolutions/fw/util/tracing/osgi/TracingActivator 
.const [216] = Utf8 frontendService 
.const [217] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [218] = Utf8 de/esolutions/fw/util/tracing/TraceClient 
.const [219] = Utf8 registerCallback 
.const [220] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/tracing/ITraceCallback;)I 
.const [221] = Utf8 de/esolutions/fw/util/tracing/osgi/TracingActivator 
.const [222] = Utf8 dumpModelCB 
.const [223] = Utf8 I 
.const [224] = Utf8 de/esolutions/fw/util/tracing/osgi/TracingActivator 
.const [225] = Utf8 injectErrorCB 
.const [226] = Utf8 I 
.const [227] = Utf8 de/esolutions/fw/util/tracing/TraceClient 
.const [228] = Utf8 unregisterCallback 
.const [229] = Utf8 (I)Z 
.const [230] = Utf8 java/lang/NoClassDefFoundError 
.const [231] = Utf8 <init> 
.const [232] = Utf8 ()V 
.const [233] = Utf8 java/lang/Object 
.const [234] = Utf8 <init> 
.const [235] = Utf8 ()V 
.const [236] = Utf8 de/esolutions/fw/util/tracing/osgi/TracingActivator 
.const [237] = Utf8 class$de$esolutions$fw$util$tracing$TraceClient 
.const [238] = Utf8 Ljava/lang/Class; 
.const [239] = Utf8 java/util/Hashtable 
.const [240] = Utf8 <init> 
.const [241] = Utf8 ()V 
.const [242] = Utf8 de/esolutions/fw/util/tracing/osgi/TracingActivator 
.const [243] = Utf8 class$de$esolutions$fw$util$tracing$frontend$TraceFrontend 
.const [244] = Utf8 Ljava/lang/Class; 
.const [245] = Utf8 de/esolutions/fw/util/tracing/osgi/DumpTraceEntityModelCallback 
.const [246] = Utf8 <init> 
.const [247] = Utf8 (Ljava/lang/String;)V 
.const [248] = Utf8 de/esolutions/fw/util/tracing/osgi/InjectErrorCallback 
.const [249] = Utf8 <init> 
.const [250] = Utf8 (Lde/esolutions/fw/util/tracing/frontend/TraceFrontend;)V 
.const [251] = Utf8 de/esolutions/fw/util/tracing/osgi/TracingActivator 
.const [252] = Utf8 client 
.const [253] = Utf8 Lde/esolutions/fw/util/tracing/TraceClient; 
.const [254] = Utf8 de/esolutions/fw/util/tracing/osgi/TracingActivator 
.const [255] = Utf8 frontend 
.const [256] = Utf8 Lde/esolutions/fw/util/tracing/frontend/TraceFrontend; 
.const [257] = Utf8 org/osgi/framework/BundleContext 
.const [258] = Utf8 registerService 
.const [259] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [260] = Utf8 de/esolutions/fw/util/tracing/osgi/TracingActivator 
.const [261] = Utf8 clientService 
.const [262] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [263] = Utf8 de/esolutions/fw/util/tracing/osgi/TracingActivator 
.const [264] = Utf8 frontendService 
.const [265] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [266] = Utf8 de/esolutions/fw/util/tracing/osgi/TracingActivator 
.const [267] = Utf8 dumpModelCB 
.const [268] = Utf8 I 
.const [269] = Utf8 de/esolutions/fw/util/tracing/osgi/TracingActivator 
.const [270] = Utf8 injectErrorCB 
.const [271] = Utf8 I 
.const [272] = Utf8 org/osgi/framework/ServiceRegistration 
.const [273] = Utf8 getReference 
.const [274] = Utf8 ()Lorg/osgi/framework/ServiceReference; 
.const [275] = Utf8 org/osgi/framework/BundleContext 
.const [276] = Utf8 ungetService 
.const [277] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [278] = Utf8 de/esolutions/fw/util/tracing/osgi/TracingActivator 
.const [279] = Class [278] 
.const [280] = Utf8 java/lang/Object 
.const [281] = Class [280] 
.const [282] = Utf8 org/osgi/framework/BundleActivator 
.const [283] = Class [282] 
.const [284] = Utf8 clientService 
.const [285] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [286] = Utf8 frontendService 
.const [287] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [288] = Utf8 client 
.const [289] = Utf8 Lde/esolutions/fw/util/tracing/TraceClient; 
.const [290] = Utf8 frontend 
.const [291] = Utf8 Lde/esolutions/fw/util/tracing/frontend/TraceFrontend; 
.const [292] = Utf8 dumpModelCB 
.const [293] = Utf8 I 
.const [294] = Utf8 injectErrorCB 
.const [295] = Utf8 I 
.const [296] = Utf8 class$de$esolutions$fw$util$tracing$TraceClient 
.const [297] = Utf8 Ljava/lang/Class; 
.const [298] = Utf8 class$de$esolutions$fw$util$tracing$frontend$TraceFrontend 
.const [299] = Utf8 Ljava/lang/Class; 
.const [300] = Utf8 Code 
.const [301] = Utf8 <init> 
.const [302] = Utf8 ()V 
.const [303] = Utf8 start 
.const [304] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [305] = Utf8 stop 
.const [306] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [307] = Utf8 class$ 
.const [308] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
