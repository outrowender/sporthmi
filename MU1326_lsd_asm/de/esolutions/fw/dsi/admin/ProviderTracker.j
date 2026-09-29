.version 50 0 
.class public super [157] 
.super [159] 
.field private static [160] [161] 
.field private [162] [163] 

.method private [165] : [166] 
    .attribute [164] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [33] 
L4:     aload_0 
L5:     getstatic [2] 
L8:     putfield [37] 
L11:    return 
L12:    
    .end code 
.end method 

.method public static [167] : [168] 
    .attribute [164] .code stack 2 locals 0 
L0:     getstatic [3] 
L3:     ifnonnull L16 
L6:     new [38] 
L9:     dup 
L10:    invokespecial [35] 
L13:    putstatic [34] 
L16:    getstatic [3] 
L19:    areturn 
L20:    
    .end code 
.end method 

.method public [169] : [170] 
    .attribute [164] .code stack 7 locals 5 
L0:     aload_0 
L1:     getfield [24] 
L4:     iconst_0 
L5:     ldc [5] 
L7:     aload_1 
L8:     iload_2 
L9:     invokestatic [6] 
L12:    invokevirtual [25] 
L15:    pop 
L16:    getstatic [7] 
L19:    astore_3 
L20:    new [39] 
L23:    dup 
L24:    invokespecial [36] 
L27:    astore 4 
L29:    aload 4 
L31:    ldc [9] 
L33:    invokevirtual [26] 
L36:    ldc [10] 
L38:    invokevirtual [26] 
L41:    ldc [11] 
L43:    invokevirtual [26] 
L46:    iload_2 
L47:    invokevirtual [27] 
L50:    ldc [12] 
L52:    invokevirtual [26] 
L55:    pop 
L56:    aconst_null 
L57:    astore 6 
        .catch [16] from L59 to L163 using L166 
L59:    aload_3 
L60:    aload_1 
L61:    aload 4 
L63:    invokevirtual [28] 
L66:    invokeinterface [40] 0 
L71:    astore 5 
L73:    aload 5 
L75:    arraylength 
L76:    iconst_1 
L77:    if_icmpne L107 
L80:    aload 5 
L82:    iconst_0 
L83:    aaload 
L84:    astore 6 
L86:    aload_0 
L87:    getfield [24] 
L90:    iconst_0 
L91:    ldc [13] 
L93:    aload_1 
L94:    iload_2 
L95:    invokestatic [6] 
L98:    aload 6 
L100:   invokevirtual [29] 
L103:   pop 
L104:   goto L163 
L107:   aload 5 
L109:   arraylength 
L110:   iconst_1 
L111:   if_icmple L147 
L114:   aload 5 
L116:   iconst_0 
L117:   aaload 
L118:   astore 6 
L120:   aload_0 
L121:   getfield [24] 
L124:   iconst_3 
L125:   ldc [14] 
L127:   aload_1 
L128:   iload_2 
L129:   invokestatic [6] 
L132:   aload 5 
L134:   arraylength 
L135:   invokestatic [6] 
L138:   aload 6 
L140:   invokevirtual [30] 
L143:   pop 
L144:   goto L163 
L147:   aload_0 
L148:   getfield [24] 
L151:   iconst_0 
L152:   ldc [15] 
L154:   aload_1 
L155:   iload_2 
L156:   invokestatic [6] 
L159:   invokevirtual [25] 
L162:   pop 
L163:   goto L184 
L166:   astore 7 
L168:   aload_0 
L169:   getfield [24] 
L172:   iconst_4 
L173:   ldc [17] 
L175:   aload 7 
L177:   invokevirtual [31] 
L180:   invokevirtual [32] 
L183:   pop 
L184:   aload 6 
L186:   areturn 
L187:   nop 
L188:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [41] [42] 
.const [3] = Field [43] [44] 
.const [4] = Class [45] 
.const [5] = String [46] 
.const [6] = Method [47] [48] 
.const [7] = Field [49] [50] 
.const [8] = Class [51] 
.const [9] = String [52] 
.const [10] = String [53] 
.const [11] = String [54] 
.const [12] = String [55] 
.const [13] = String [56] 
.const [14] = String [57] 
.const [15] = String [58] 
.const [16] = Class [59] 
.const [17] = String [60] 
.const [18] = Class [61] 
.const [19] = Class [62] 
.const [20] = Class [63] 
.const [21] = Class [64] 
.const [22] = Class [65] 
.const [23] = Class [66] 
.const [24] = Field [67] [68] 
.const [25] = Method [69] [70] 
.const [26] = Method [71] [72] 
.const [27] = Method [73] [74] 
.const [28] = Method [75] [76] 
.const [29] = Method [77] [78] 
.const [30] = Method [79] [80] 
.const [31] = Method [81] [82] 
.const [32] = Method [83] [84] 
.const [33] = Method [85] [86] 
.const [34] = Field [87] [88] 
.const [35] = Method [89] [90] 
.const [36] = Method [91] [92] 
.const [37] = Field [93] [94] 
.const [38] = Class [95] 
.const [39] = Class [96] 
.const [40] = InterfaceMethod [97] [98] 
.const [41] = Class [99] 
.const [42] = NameAndType [100] [101] 
.const [43] = Class [102] 
.const [44] = NameAndType [103] [104] 
.const [45] = Utf8 de/esolutions/fw/dsi/admin/ProviderTracker 
.const [46] = Utf8 'Search provider for: serviceName=%1, serviceInstance=%2' 
.const [47] = Class [105] 
.const [48] = NameAndType [106] [107] 
.const [49] = Class [108] 
.const [50] = NameAndType [109] [110] 
.const [51] = Utf8 java/lang/StringBuffer 
.const [52] = Utf8 ( 
.const [53] = Utf8 DEVICE_INSTANCE 
.const [54] = Utf8 '=' 
.const [55] = Utf8 ')' 
.const [56] = Utf8 'Provider found for: serviceName=%1, serviceInstance=%2 -> ref=%3' 
.const [57] = Utf8 'More then one providers found for: serviceName=%1, serviceInstance=%2 -> providers=%3, ref=%4' 
.const [58] = Utf8 'No providers found for: serviceName=%1, serviceInstance=%2' 
.const [59] = Utf8 org/osgi/framework/InvalidSyntaxException 
.const [60] = Utf8 'Error during search of provider references: message=%1' 
.const [61] = Utf8 java/lang/Object 
.const [62] = Utf8 de/esolutions/fw/dsi/tracing/Channels 
.const [63] = Utf8 java/lang/String 
.const [64] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [65] = Utf8 de/esolutions/fw/dsi/AdapterActivator 
.const [66] = Utf8 org/osgi/framework/BundleContext 
.const [67] = Class [111] 
.const [68] = NameAndType [112] [113] 
.const [69] = Class [114] 
.const [70] = NameAndType [115] [116] 
.const [71] = Class [117] 
.const [72] = NameAndType [118] [119] 
.const [73] = Class [120] 
.const [74] = NameAndType [121] [122] 
.const [75] = Class [123] 
.const [76] = NameAndType [124] [125] 
.const [77] = Class [126] 
.const [78] = NameAndType [127] [128] 
.const [79] = Class [129] 
.const [80] = NameAndType [130] [131] 
.const [81] = Class [132] 
.const [82] = NameAndType [133] [134] 
.const [83] = Class [135] 
.const [84] = NameAndType [136] [137] 
.const [85] = Class [138] 
.const [86] = NameAndType [139] [140] 
.const [87] = Class [141] 
.const [88] = NameAndType [142] [143] 
.const [89] = Class [144] 
.const [90] = NameAndType [145] [146] 
.const [91] = Class [147] 
.const [92] = NameAndType [148] [149] 
.const [93] = Class [150] 
.const [94] = NameAndType [151] [152] 
.const [95] = Utf8 de/esolutions/fw/dsi/admin/ProviderTracker 
.const [96] = Utf8 java/lang/StringBuffer 
.const [97] = Class [153] 
.const [98] = NameAndType [154] [155] 
.const [99] = Utf8 de/esolutions/fw/dsi/tracing/Channels 
.const [100] = Utf8 PROVIDER_TRACKER 
.const [101] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [102] = Utf8 de/esolutions/fw/dsi/admin/ProviderTracker 
.const [103] = Utf8 providerTracker 
.const [104] = Utf8 Lde/esolutions/fw/dsi/admin/ProviderTracker; 
.const [105] = Utf8 java/lang/String 
.const [106] = Utf8 valueOf 
.const [107] = Utf8 (I)Ljava/lang/String; 
.const [108] = Utf8 de/esolutions/fw/dsi/AdapterActivator 
.const [109] = Utf8 bundleContext 
.const [110] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [111] = Utf8 de/esolutions/fw/dsi/admin/ProviderTracker 
.const [112] = Utf8 tracer 
.const [113] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [114] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [115] = Utf8 log 
.const [116] = Utf8 (SLjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)Z 
.const [117] = Utf8 java/lang/StringBuffer 
.const [118] = Utf8 append 
.const [119] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [120] = Utf8 java/lang/StringBuffer 
.const [121] = Utf8 append 
.const [122] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [123] = Utf8 java/lang/StringBuffer 
.const [124] = Utf8 toString 
.const [125] = Utf8 ()Ljava/lang/String; 
.const [126] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [127] = Utf8 log 
.const [128] = Utf8 (SLjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z 
.const [129] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [130] = Utf8 log 
.const [131] = Utf8 (SLjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z 
.const [132] = Utf8 org/osgi/framework/InvalidSyntaxException 
.const [133] = Utf8 getMessage 
.const [134] = Utf8 ()Ljava/lang/String; 
.const [135] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [136] = Utf8 log 
.const [137] = Utf8 (SLjava/lang/String;Ljava/lang/Object;)Z 
.const [138] = Utf8 java/lang/Object 
.const [139] = Utf8 <init> 
.const [140] = Utf8 ()V 
.const [141] = Utf8 de/esolutions/fw/dsi/admin/ProviderTracker 
.const [142] = Utf8 providerTracker 
.const [143] = Utf8 Lde/esolutions/fw/dsi/admin/ProviderTracker; 
.const [144] = Utf8 de/esolutions/fw/dsi/admin/ProviderTracker 
.const [145] = Utf8 <init> 
.const [146] = Utf8 ()V 
.const [147] = Utf8 java/lang/StringBuffer 
.const [148] = Utf8 <init> 
.const [149] = Utf8 ()V 
.const [150] = Utf8 de/esolutions/fw/dsi/admin/ProviderTracker 
.const [151] = Utf8 tracer 
.const [152] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [153] = Utf8 org/osgi/framework/BundleContext 
.const [154] = Utf8 getServiceReferences 
.const [155] = Utf8 (Ljava/lang/String;Ljava/lang/String;)[Lorg/osgi/framework/ServiceReference; 
.const [156] = Utf8 de/esolutions/fw/dsi/admin/ProviderTracker 
.const [157] = Class [156] 
.const [158] = Utf8 java/lang/Object 
.const [159] = Class [158] 
.const [160] = Utf8 providerTracker 
.const [161] = Utf8 Lde/esolutions/fw/dsi/admin/ProviderTracker; 
.const [162] = Utf8 tracer 
.const [163] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [164] = Utf8 Code 
.const [165] = Utf8 <init> 
.const [166] = Utf8 ()V 
.const [167] = Utf8 getInstance 
.const [168] = Utf8 ()Lde/esolutions/fw/dsi/admin/ProviderTracker; 
.const [169] = Utf8 getDSIProvider 
.const [170] = Utf8 (Ljava/lang/String;I)Lorg/osgi/framework/ServiceReference; 
.end class 
