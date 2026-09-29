.version 50 0 
.class public super [273] 
.super [275] 
.implements [277] 
.field private final [278] [279] 
.field private [280] [281] 
.field private [282] [283] 
.field static synthetic [284] [285] 

.method public [287] : [288] 
    .attribute [286] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [47] 
L4:     aload_0 
L5:     getstatic [5] 
L8:     putfield [54] 
L11:    aload_0 
L12:    getfield [33] 
L15:    iconst_0 
L16:    ldc [6] 
L18:    invokevirtual [34] 
L21:    pop 
L22:    aload_0 
L23:    getstatic [7] 
L26:    putfield [55] 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [289] : [290] 
    .attribute [286] .code stack 6 locals 0 
L0:     aload_0 
L1:     new [56] 
L4:     dup 
L5:     aload_0 
L6:     getfield [35] 
L9:     getstatic [9] 
L12:    ifnonnull L27 
L15:    ldc [10] 
L17:    invokestatic [11] 
L20:    dup 
L21:    putstatic [48] 
L24:    goto L30 
L27:    getstatic [9] 
L30:    invokevirtual [36] 
L33:    aconst_null 
L34:    invokespecial [49] 
L37:    putfield [57] 
L40:    aload_0 
L41:    getfield [37] 
L44:    invokevirtual [38] 
L47:    return 
L48:    
    .end code 
.end method 

.method public [291] : [292] 
    .attribute [286] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [37] 
L4:     invokevirtual [39] 
L7:     return 
L8:     
    .end code 
.end method 

.method private [293] : [294] 
    .attribute [286] .code stack 8 locals 8 
L0:     aload_0 
L1:     getfield [33] 
L4:     iconst_0 
L5:     ldc [12] 
L7:     aload_1 
L8:     iload_2 
L9:     invokestatic [13] 
L12:    invokevirtual [40] 
L15:    pop 
L16:    new [58] 
L19:    dup 
L20:    invokespecial [50] 
L23:    astore_3 
L24:    aload_0 
L25:    getfield [37] 
L28:    invokevirtual [41] 
L31:    astore 4 
L33:    aload 4 
L35:    ifnull L258 
L38:    aload 4 
L40:    arraylength 
L41:    ifeq L258 
L44:    iconst_0 
L45:    istore 5 
L47:    iload 5 
L49:    aload 4 
L51:    arraylength 
L52:    if_icmpge L202 
L55:    aload_0 
L56:    getfield [35] 
L59:    aload 4 
L61:    iload 5 
L63:    aaload 
L64:    invokeinterface [59] 0 
L69:    astore 6 
L71:    aload 4 
L73:    iload 5 
L75:    aaload 
L76:    ldc [15] 
L78:    invokeinterface [60] 0 
L83:    astore 7 
L85:    aload 4 
L87:    iload 5 
L89:    aaload 
L90:    ldc [16] 
L92:    invokeinterface [60] 0 
L97:    astore 8 
L99:    aload 7 
L101:   ifnull L153 
L104:   aload 8 
L106:   ifnull L153 
L109:   aload 7 
L111:   checkcast [17] 
L114:   astore 9 
L116:   aload 8 
L118:   checkcast [18] 
L121:   invokevirtual [42] 
L124:   istore 10 
L126:   aload 9 
L128:   aload_1 
L129:   invokevirtual [43] 
L132:   ifeq L150 
L135:   iload 10 
L137:   iload_2 
L138:   if_icmpne L150 
L141:   aload_3 
L142:   aload 6 
L144:   invokeinterface [61] 0 
L149:   pop 
L150:   goto L181 
L153:   aload_0 
L154:   getfield [33] 
L157:   iconst_4 
L158:   ldc [19] 
L160:   aload 6 
L162:   invokespecial [51] 
L165:   invokevirtual [36] 
L168:   aload_1 
L169:   iload_2 
L170:   invokestatic [13] 
L173:   aload 7 
L175:   aload 8 
L177:   invokevirtual [44] 
L180:   pop 
L181:   aload_0 
L182:   getfield [35] 
L185:   aload 4 
L187:   iload 5 
L189:   aaload 
L190:   invokeinterface [62] 0 
L195:   pop 
L196:   iinc 5 1 
L199:   goto L47 
L202:   aload_3 
L203:   invokeinterface [63] 0 
L208:   ifle L239 
L211:   aload_0 
L212:   getfield [33] 
L215:   iconst_0 
L216:   ldc [20] 
L218:   aload_1 
L219:   iload_2 
L220:   invokestatic [13] 
L223:   aload_3 
L224:   invokeinterface [63] 0 
L229:   invokestatic [13] 
L232:   invokevirtual [45] 
L235:   pop 
L236:   goto L274 
L239:   aload_0 
L240:   getfield [33] 
L243:   iconst_3 
L244:   ldc [21] 
L246:   aload_1 
L247:   iload_2 
L248:   invokestatic [13] 
L251:   invokevirtual [40] 
L254:   pop 
L255:   goto L274 
L258:   aload_0 
L259:   getfield [33] 
L262:   iconst_3 
L263:   ldc [22] 
L265:   aload_1 
L266:   iload_2 
L267:   invokestatic [13] 
L270:   invokevirtual [40] 
L273:   pop 
L274:   aload_3 
L275:   invokeinterface [64] 0 
L280:   areturn 
L281:   nop 
L282:   nop 
L283:   nop 
L284:   
    .end code 
.end method 

.method public [295] : [296] 
    .attribute [286] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iload_2 
L3:     invokespecial [52] 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method public enum [297] : [298] 
    .attribute [286] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method static synthetic [299] : [300] 
    .attribute [286] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [53] 
L9:     dup 
L10:    invokespecial [46] 
L13:    aload_1 
L14:    invokevirtual [32] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [65] [66] 
.const [3] = Class [67] 
.const [4] = Class [68] 
.const [5] = Field [69] [70] 
.const [6] = String [71] 
.const [7] = Field [72] [73] 
.const [8] = Class [74] 
.const [9] = Field [75] [76] 
.const [10] = String [77] 
.const [11] = Method [78] [79] 
.const [12] = String [80] 
.const [13] = Method [81] [82] 
.const [14] = Class [83] 
.const [15] = String [84] 
.const [16] = String [85] 
.const [17] = Class [86] 
.const [18] = Class [87] 
.const [19] = String [88] 
.const [20] = String [89] 
.const [21] = String [90] 
.const [22] = String [91] 
.const [23] = Class [92] 
.const [24] = Class [93] 
.const [25] = Class [94] 
.const [26] = Class [95] 
.const [27] = Class [96] 
.const [28] = Class [97] 
.const [29] = Class [98] 
.const [30] = Class [99] 
.const [31] = Class [100] 
.const [32] = Method [101] [102] 
.const [33] = Field [103] [104] 
.const [34] = Method [105] [106] 
.const [35] = Field [107] [108] 
.const [36] = Method [109] [110] 
.const [37] = Field [111] [112] 
.const [38] = Method [113] [114] 
.const [39] = Method [115] [116] 
.const [40] = Method [117] [118] 
.const [41] = Method [119] [120] 
.const [42] = Method [121] [122] 
.const [43] = Method [123] [124] 
.const [44] = Method [125] [126] 
.const [45] = Method [127] [128] 
.const [46] = Method [129] [130] 
.const [47] = Method [131] [132] 
.const [48] = Field [133] [134] 
.const [49] = Method [135] [136] 
.const [50] = Method [137] [138] 
.const [51] = Method [139] [140] 
.const [52] = Method [141] [142] 
.const [53] = Class [143] 
.const [54] = Field [144] [145] 
.const [55] = Field [146] [147] 
.const [56] = Class [148] 
.const [57] = Field [149] [150] 
.const [58] = Class [151] 
.const [59] = InterfaceMethod [152] [153] 
.const [60] = InterfaceMethod [154] [155] 
.const [61] = InterfaceMethod [156] [157] 
.const [62] = InterfaceMethod [158] [159] 
.const [63] = InterfaceMethod [160] [161] 
.const [64] = InterfaceMethod [162] [163] 
.const [65] = Class [164] 
.const [66] = NameAndType [165] [166] 
.const [67] = Utf8 java/lang/ClassNotFoundException 
.const [68] = Utf8 java/lang/NoClassDefFoundError 
.const [69] = Class [167] 
.const [70] = NameAndType [168] [169] 
.const [71] = Utf8 'Using ListenerTrackerOSGi ' 
.const [72] = Class [170] 
.const [73] = NameAndType [171] [172] 
.const [74] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [75] = Class [173] 
.const [76] = NameAndType [174] [175] 
.const [77] = Utf8 'org.dsi.ifc.base.DSIListener' 
.const [78] = Class [176] 
.const [79] = NameAndType [177] [178] 
.const [80] = Utf8 'Search listeners for: serviceName=%1, serviceInstance=%2' 
.const [81] = Class [179] 
.const [82] = NameAndType [180] [181] 
.const [83] = Utf8 java/util/ArrayList 
.const [84] = Utf8 DEVICE_NAME 
.const [85] = Utf8 DEVICE_INSTANCE 
.const [86] = Utf8 java/lang/String 
.const [87] = Utf8 java/lang/Integer 
.const [88] = Utf8 'Invalid service properties: objectClassName=%1, serviceClassName=%2, serviceInstance=%3, serviceNameProperty=%4, serviceInstanceProperty=%5' 
.const [89] = Utf8 'Listeners found for: serviceName=%1, serviceInstance=%2, listeners=%3' 
.const [90] = Utf8 'No listeners found for: serviceName=%1, serviceInstance=%2' 
.const [91] = Utf8 'No service references found for: serviceName=%1, serviceInstance=%2' 
.const [92] = Utf8 de/esolutions/fw/dsi/admin/ListenerTrackerOSGi 
.const [93] = Utf8 java/lang/Object 
.const [94] = Utf8 java/lang/Class 
.const [95] = Utf8 de/esolutions/fw/dsi/tracing/Channels 
.const [96] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [97] = Utf8 de/esolutions/fw/dsi/AdapterActivator 
.const [98] = Utf8 org/osgi/framework/BundleContext 
.const [99] = Utf8 org/osgi/framework/ServiceReference 
.const [100] = Utf8 java/util/List 
.const [101] = Class [182] 
.const [102] = NameAndType [183] [184] 
.const [103] = Class [185] 
.const [104] = NameAndType [186] [187] 
.const [105] = Class [188] 
.const [106] = NameAndType [189] [190] 
.const [107] = Class [191] 
.const [108] = NameAndType [192] [193] 
.const [109] = Class [194] 
.const [110] = NameAndType [195] [196] 
.const [111] = Class [197] 
.const [112] = NameAndType [198] [199] 
.const [113] = Class [200] 
.const [114] = NameAndType [201] [202] 
.const [115] = Class [203] 
.const [116] = NameAndType [204] [205] 
.const [117] = Class [206] 
.const [118] = NameAndType [207] [208] 
.const [119] = Class [209] 
.const [120] = NameAndType [210] [211] 
.const [121] = Class [212] 
.const [122] = NameAndType [213] [214] 
.const [123] = Class [215] 
.const [124] = NameAndType [216] [217] 
.const [125] = Class [218] 
.const [126] = NameAndType [219] [220] 
.const [127] = Class [221] 
.const [128] = NameAndType [222] [223] 
.const [129] = Class [224] 
.const [130] = NameAndType [225] [226] 
.const [131] = Class [227] 
.const [132] = NameAndType [228] [229] 
.const [133] = Class [230] 
.const [134] = NameAndType [231] [232] 
.const [135] = Class [233] 
.const [136] = NameAndType [234] [235] 
.const [137] = Class [236] 
.const [138] = NameAndType [237] [238] 
.const [139] = Class [239] 
.const [140] = NameAndType [240] [241] 
.const [141] = Class [242] 
.const [142] = NameAndType [243] [244] 
.const [143] = Utf8 java/lang/NoClassDefFoundError 
.const [144] = Class [245] 
.const [145] = NameAndType [246] [247] 
.const [146] = Class [248] 
.const [147] = NameAndType [249] [250] 
.const [148] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [149] = Class [251] 
.const [150] = NameAndType [252] [253] 
.const [151] = Utf8 java/util/ArrayList 
.const [152] = Class [254] 
.const [153] = NameAndType [255] [256] 
.const [154] = Class [257] 
.const [155] = NameAndType [258] [259] 
.const [156] = Class [260] 
.const [157] = NameAndType [261] [262] 
.const [158] = Class [263] 
.const [159] = NameAndType [264] [265] 
.const [160] = Class [266] 
.const [161] = NameAndType [267] [268] 
.const [162] = Class [269] 
.const [163] = NameAndType [270] [271] 
.const [164] = Utf8 java/lang/Class 
.const [165] = Utf8 forName 
.const [166] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [167] = Utf8 de/esolutions/fw/dsi/tracing/Channels 
.const [168] = Utf8 LISTENER_TRACKER 
.const [169] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [170] = Utf8 de/esolutions/fw/dsi/AdapterActivator 
.const [171] = Utf8 bundleContext 
.const [172] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [173] = Utf8 de/esolutions/fw/dsi/admin/ListenerTrackerOSGi 
.const [174] = Utf8 class$org$dsi$ifc$base$DSIListener 
.const [175] = Utf8 Ljava/lang/Class; 
.const [176] = Utf8 de/esolutions/fw/dsi/admin/ListenerTrackerOSGi 
.const [177] = Utf8 class$ 
.const [178] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [179] = Utf8 java/lang/String 
.const [180] = Utf8 valueOf 
.const [181] = Utf8 (I)Ljava/lang/String; 
.const [182] = Utf8 java/lang/NoClassDefFoundError 
.const [183] = Utf8 initCause 
.const [184] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [185] = Utf8 de/esolutions/fw/dsi/admin/ListenerTrackerOSGi 
.const [186] = Utf8 tracer 
.const [187] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [188] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [189] = Utf8 log 
.const [190] = Utf8 (SLjava/lang/String;)Z 
.const [191] = Utf8 de/esolutions/fw/dsi/admin/ListenerTrackerOSGi 
.const [192] = Utf8 bundleContext 
.const [193] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [194] = Utf8 java/lang/Class 
.const [195] = Utf8 getName 
.const [196] = Utf8 ()Ljava/lang/String; 
.const [197] = Utf8 de/esolutions/fw/dsi/admin/ListenerTrackerOSGi 
.const [198] = Utf8 serviceTracker 
.const [199] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [200] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [201] = Utf8 'open' 
.const [202] = Utf8 ()V 
.const [203] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [204] = Utf8 close 
.const [205] = Utf8 ()V 
.const [206] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [207] = Utf8 log 
.const [208] = Utf8 (SLjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)Z 
.const [209] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [210] = Utf8 getServiceReferences 
.const [211] = Utf8 ()[Lorg/osgi/framework/ServiceReference; 
.const [212] = Utf8 java/lang/Integer 
.const [213] = Utf8 shortValue 
.const [214] = Utf8 ()S 
.const [215] = Utf8 java/lang/String 
.const [216] = Utf8 equals 
.const [217] = Utf8 (Ljava/lang/Object;)Z 
.const [218] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [219] = Utf8 log 
.const [220] = Utf8 (SLjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z 
.const [221] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [222] = Utf8 log 
.const [223] = Utf8 (SLjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z 
.const [224] = Utf8 java/lang/NoClassDefFoundError 
.const [225] = Utf8 <init> 
.const [226] = Utf8 ()V 
.const [227] = Utf8 java/lang/Object 
.const [228] = Utf8 <init> 
.const [229] = Utf8 ()V 
.const [230] = Utf8 de/esolutions/fw/dsi/admin/ListenerTrackerOSGi 
.const [231] = Utf8 class$org$dsi$ifc$base$DSIListener 
.const [232] = Utf8 Ljava/lang/Class; 
.const [233] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [234] = Utf8 <init> 
.const [235] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [236] = Utf8 java/util/ArrayList 
.const [237] = Utf8 <init> 
.const [238] = Utf8 ()V 
.const [239] = Utf8 java/lang/Object 
.const [240] = Utf8 getClass 
.const [241] = Utf8 ()Ljava/lang/Class; 
.const [242] = Utf8 de/esolutions/fw/dsi/admin/ListenerTrackerOSGi 
.const [243] = Utf8 getDSIListenerList 
.const [244] = Utf8 (Ljava/lang/String;I)[Ljava/lang/Object; 
.const [245] = Utf8 de/esolutions/fw/dsi/admin/ListenerTrackerOSGi 
.const [246] = Utf8 tracer 
.const [247] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [248] = Utf8 de/esolutions/fw/dsi/admin/ListenerTrackerOSGi 
.const [249] = Utf8 bundleContext 
.const [250] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [251] = Utf8 de/esolutions/fw/dsi/admin/ListenerTrackerOSGi 
.const [252] = Utf8 serviceTracker 
.const [253] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [254] = Utf8 org/osgi/framework/BundleContext 
.const [255] = Utf8 getService 
.const [256] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [257] = Utf8 org/osgi/framework/ServiceReference 
.const [258] = Utf8 getProperty 
.const [259] = Utf8 (Ljava/lang/String;)Ljava/lang/Object; 
.const [260] = Utf8 java/util/List 
.const [261] = Utf8 add 
.const [262] = Utf8 (Ljava/lang/Object;)Z 
.const [263] = Utf8 org/osgi/framework/BundleContext 
.const [264] = Utf8 ungetService 
.const [265] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [266] = Utf8 java/util/List 
.const [267] = Utf8 size 
.const [268] = Utf8 ()I 
.const [269] = Utf8 java/util/List 
.const [270] = Utf8 toArray 
.const [271] = Utf8 ()[Ljava/lang/Object; 
.const [272] = Utf8 de/esolutions/fw/dsi/admin/ListenerTrackerOSGi 
.const [273] = Class [272] 
.const [274] = Utf8 java/lang/Object 
.const [275] = Class [274] 
.const [276] = Utf8 de/esolutions/fw/dsi/admin/IListenerTracker 
.const [277] = Class [276] 
.const [278] = Utf8 tracer 
.const [279] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [280] = Utf8 bundleContext 
.const [281] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [282] = Utf8 serviceTracker 
.const [283] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [284] = Utf8 class$org$dsi$ifc$base$DSIListener 
.const [285] = Utf8 Ljava/lang/Class; 
.const [286] = Utf8 Code 
.const [287] = Utf8 <init> 
.const [288] = Utf8 ()V 
.const [289] = Utf8 'open' 
.const [290] = Utf8 ()V 
.const [291] = Utf8 close 
.const [292] = Utf8 ()V 
.const [293] = Utf8 getDSIListenerList 
.const [294] = Utf8 (Ljava/lang/String;I)[Ljava/lang/Object; 
.const [295] = Utf8 getDSIListener 
.const [296] = Utf8 (Ljava/lang/String;I)[Ljava/lang/Object; 
.const [297] = Utf8 setDSIAdmin 
.const [298] = Utf8 (Lde/esolutions/fw/dsi/admin/DSIAdmin;)V 
.const [299] = Utf8 class$ 
.const [300] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
