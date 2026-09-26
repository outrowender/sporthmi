.version 50 0 
.class public final super [258] 
.super [260] 
.implements [262] 
.field private final [263] [264] 
.field private final [265] [266] 
.field private volatile [267] [268] 

.method public [270] : [271] 
    .attribute [269] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [27] 
L5:     aload_1 
L6:     invokevirtual [28] 
L9:     aload_1 
L10:    invokevirtual [28] 
L13:    ldc [2] 
L15:    invokeinterface [49] 0 
L20:    bipush 6 
L22:    invokespecial [47] 
L25:    aload_0 
L26:    new [50] 
L29:    dup 
L30:    invokespecial [48] 
L33:    putfield [51] 
L36:    aload_0 
L37:    getstatic [4] 
L40:    putfield [52] 
L43:    aload_0 
L44:    aload_0 
L45:    getfield [31] 
L48:    ldc [5] 
L50:    invokeinterface [49] 0 
L55:    putfield [53] 
L58:    return 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [272] : [273] 
    .attribute [269] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [29] 
L4:     aload_1 
L5:     invokevirtual [33] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public enum [274] : [275] 
    .attribute [269] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [276] : [277] 
    .attribute [269] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [278] : [279] 
    .attribute [269] .code stack 4 locals 1 
        .catch [6] from L0 to L12 using L15 
L0:     aload_0 
L1:     getfield [29] 
L4:     aload_1 
L5:     invokevirtual [34] 
L8:     aload_0 
L9:     invokevirtual [35] 
L12:    goto L30 
L15:    astore_2 
L16:    aload_0 
L17:    getfield [32] 
L20:    sipush 10000 
L23:    ldc [7] 
L25:    aload_2 
L26:    invokevirtual [36] 
L29:    pop 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [280] : [281] 
    .attribute [269] .code stack 4 locals 1 
        .catch [6] from L0 to L11 using L14 
L0:     aload_0 
L1:     getfield [29] 
L4:     invokevirtual [37] 
L7:     aload_0 
L8:     invokevirtual [38] 
L11:    goto L29 
L14:    astore_1 
L15:    aload_0 
L16:    getfield [32] 
L19:    sipush 10000 
L22:    ldc [8] 
L24:    aload_1 
L25:    invokevirtual [36] 
L28:    pop 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [282] : [283] 
    .attribute [269] .code stack 6 locals 7 
L0:     aload_2 
L1:     ifnull L8 
L4:     aload_2 
L5:     goto L11 
L8:     getstatic [4] 
L11:    astore_3 
L12:    aload_1 
L13:    aload_0 
L14:    invokevirtual [39] 
L17:    if_acmpeq L24 
L20:    iconst_1 
L21:    goto L25 
L24:    iconst_0 
L25:    istore 4 
L27:    aload_0 
L28:    getfield [30] 
L31:    aload_3 
L32:    if_acmpeq L39 
L35:    iconst_1 
L36:    goto L40 
L39:    iconst_0 
L40:    istore 5 
L42:    aload_0 
L43:    getfield [32] 
L46:    invokevirtual [40] 
L49:    ifeq L77 
L52:    aload_0 
L53:    getfield [32] 
L56:    ldc [9] 
L58:    ldc [10] 
L60:    aload_1 
L61:    invokestatic [11] 
L64:    iload 4 
L66:    invokestatic [12] 
L69:    iload 5 
L71:    invokestatic [12] 
L74:    invokevirtual [41] 
L77:    iload 4 
L79:    ifne L87 
L82:    iload 5 
L84:    ifeq L92 
L87:    aload_0 
L88:    invokevirtual [42] 
L91:    pop 
L92:    iload 5 
L94:    ifeq L175 
L97:    aload_0 
L98:    aload_3 
L99:    putfield [52] 
L102:   aload_3 
L103:   invokeinterface [54] 0 
L108:   invokeinterface [55] 0 
L113:   astore 6 
L115:   aload 6 
L117:   invokeinterface [56] 0 
L122:   ifeq L175 
L125:   aload 6 
L127:   invokeinterface [57] 0 
L132:   checkcast [13] 
L135:   astore 7 
L137:   aload 7 
L139:   invokeinterface [58] 0 
L144:   checkcast [14] 
L147:   invokevirtual [43] 
L150:   istore 8 
L152:   aload 7 
L154:   invokeinterface [59] 0 
L159:   checkcast [15] 
L162:   astore 9 
L164:   aload_0 
L165:   iload 8 
L167:   aload 9 
L169:   invokevirtual [44] 
L172:   goto L115 
L175:   iload 4 
L177:   ifeq L185 
L180:   aload_0 
L181:   aload_1 
L182:   invokevirtual [45] 
L185:   iload 4 
L187:   ifne L195 
L190:   iload 5 
L192:   ifeq L199 
L195:   aload_1 
L196:   invokevirtual [46] 
L199:   return 
L200:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [60] 
.const [3] = Class [61] 
.const [4] = Field [62] [63] 
.const [5] = String [64] 
.const [6] = Class [65] 
.const [7] = String [66] 
.const [8] = String [67] 
.const [9] = Int -2137614336 
.const [10] = String [68] 
.const [11] = Method [69] [70] 
.const [12] = Method [71] [72] 
.const [13] = Class [73] 
.const [14] = Class [74] 
.const [15] = Class [75] 
.const [16] = Class [76] 
.const [17] = Class [77] 
.const [18] = Class [78] 
.const [19] = Class [79] 
.const [20] = Class [80] 
.const [21] = Class [81] 
.const [22] = Class [82] 
.const [23] = Class [83] 
.const [24] = Class [84] 
.const [25] = Class [85] 
.const [26] = Class [86] 
.const [27] = Method [87] [88] 
.const [28] = Method [89] [90] 
.const [29] = Field [91] [92] 
.const [30] = Field [93] [94] 
.const [31] = Field [95] [96] 
.const [32] = Field [97] [98] 
.const [33] = Method [99] [100] 
.const [34] = Method [101] [102] 
.const [35] = Method [103] [104] 
.const [36] = Method [105] [106] 
.const [37] = Method [107] [108] 
.const [38] = Method [109] [110] 
.const [39] = Method [111] [112] 
.const [40] = Method [113] [114] 
.const [41] = Method [115] [116] 
.const [42] = Method [117] [118] 
.const [43] = Method [119] [120] 
.const [44] = Method [121] [122] 
.const [45] = Method [123] [124] 
.const [46] = Method [125] [126] 
.const [47] = Method [127] [128] 
.const [48] = Method [129] [130] 
.const [49] = InterfaceMethod [131] [132] 
.const [50] = Class [133] 
.const [51] = Field [134] [135] 
.const [52] = Field [136] [137] 
.const [53] = Field [138] [139] 
.const [54] = InterfaceMethod [140] [141] 
.const [55] = InterfaceMethod [142] [143] 
.const [56] = InterfaceMethod [144] [145] 
.const [57] = InterfaceMethod [146] [147] 
.const [58] = InterfaceMethod [148] [149] 
.const [59] = InterfaceMethod [150] [151] 
.const [60] = Utf8 'App.Messaging.Search' 
.const [61] = Utf8 de/audi/app/messaging/core/component/MessagingComponentCollection 
.const [62] = Class [152] 
.const [63] = NameAndType [153] [154] 
.const [64] = Utf8 'App.Messaging.Main' 
.const [65] = Utf8 java/lang/Exception 
.const [66] = Utf8 '[MessagingSearch#connect] An error occurred: ' 
.const [67] = Utf8 '[MessagingSearch#disconnect] An error occurred: ' 
.const [68] = Utf8 '[MessagingSearch#switchConfiguration] guiSearchHandler = %1, hasHandlerChanged = %2, haveSearchFiltersChanged = %3' 
.const [69] = Class [155] 
.const [70] = NameAndType [156] [157] 
.const [71] = Class [158] 
.const [72] = NameAndType [159] [160] 
.const [73] = Utf8 java/util/Map$Entry 
.const [74] = Utf8 java/lang/Integer 
.const [75] = Utf8 org/dsi/ifc/search/SearchFilter 
.const [76] = Utf8 de/audi/app/messaging/core/search/MessagingSearch 
.const [77] = Utf8 de/audi/atip/search/AbstractSearch 
.const [78] = Utf8 de/audi/app/messaging/core/osgi/MessagingBundleContext 
.const [79] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [80] = Utf8 java/util/Collections 
.const [81] = Utf8 de/audi/atip/log/LogChannel 
.const [82] = Utf8 java/lang/String 
.const [83] = Utf8 java/util/Map 
.const [84] = Utf8 java/util/Set 
.const [85] = Utf8 java/util/Iterator 
.const [86] = Utf8 de/audi/atip/search/AbstractGuiSearchHandler 
.const [87] = Class [161] 
.const [88] = NameAndType [162] [163] 
.const [89] = Class [164] 
.const [90] = NameAndType [165] [166] 
.const [91] = Class [167] 
.const [92] = NameAndType [168] [169] 
.const [93] = Class [170] 
.const [94] = NameAndType [171] [172] 
.const [95] = Class [173] 
.const [96] = NameAndType [174] [175] 
.const [97] = Class [176] 
.const [98] = NameAndType [177] [178] 
.const [99] = Class [179] 
.const [100] = NameAndType [180] [181] 
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
.const [133] = Utf8 de/audi/app/messaging/core/component/MessagingComponentCollection 
.const [134] = Class [230] 
.const [135] = NameAndType [231] [232] 
.const [136] = Class [233] 
.const [137] = NameAndType [234] [235] 
.const [138] = Class [236] 
.const [139] = NameAndType [237] [238] 
.const [140] = Class [239] 
.const [141] = NameAndType [240] [241] 
.const [142] = Class [242] 
.const [143] = NameAndType [243] [244] 
.const [144] = Class [245] 
.const [145] = NameAndType [246] [247] 
.const [146] = Class [248] 
.const [147] = NameAndType [249] [250] 
.const [148] = Class [251] 
.const [149] = NameAndType [252] [253] 
.const [150] = Class [254] 
.const [151] = NameAndType [255] [256] 
.const [152] = Utf8 java/util/Collections 
.const [153] = Utf8 EMPTY_MAP 
.const [154] = Utf8 Ljava/util/Map; 
.const [155] = Utf8 java/lang/String 
.const [156] = Utf8 valueOf 
.const [157] = Utf8 (Ljava/lang/Object;)Ljava/lang/String; 
.const [158] = Utf8 java/lang/String 
.const [159] = Utf8 valueOf 
.const [160] = Utf8 (Z)Ljava/lang/String; 
.const [161] = Utf8 de/audi/app/messaging/core/osgi/MessagingBundleContext 
.const [162] = Utf8 getBundleContext 
.const [163] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [164] = Utf8 de/audi/app/messaging/core/osgi/MessagingBundleContext 
.const [165] = Utf8 getFramework 
.const [166] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [167] = Utf8 de/audi/app/messaging/core/search/MessagingSearch 
.const [168] = Utf8 subcomponents 
.const [169] = Utf8 Lde/audi/app/messaging/core/component/MessagingComponentCollection; 
.const [170] = Utf8 de/audi/app/messaging/core/search/MessagingSearch 
.const [171] = Utf8 searchFilters 
.const [172] = Utf8 Ljava/util/Map; 
.const [173] = Utf8 de/audi/app/messaging/core/search/MessagingSearch 
.const [174] = Utf8 framework 
.const [175] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [176] = Utf8 de/audi/app/messaging/core/search/MessagingSearch 
.const [177] = Utf8 log 
.const [178] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [179] = Utf8 de/audi/app/messaging/core/component/MessagingComponentCollection 
.const [180] = Utf8 add 
.const [181] = Utf8 (Lde/audi/app/messaging/core/component/IMessagingComponent;)V 
.const [182] = Utf8 de/audi/app/messaging/core/component/MessagingComponentCollection 
.const [183] = Utf8 connectAll 
.const [184] = Utf8 (Lde/audi/app/messaging/core/osgi/IServiceRegistry;)V 
.const [185] = Utf8 de/audi/app/messaging/core/search/MessagingSearch 
.const [186] = Utf8 startDSI 
.const [187] = Utf8 ()V 
.const [188] = Utf8 de/audi/atip/log/LogChannel 
.const [189] = Utf8 log 
.const [190] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [191] = Utf8 de/audi/app/messaging/core/component/MessagingComponentCollection 
.const [192] = Utf8 disconnectAll 
.const [193] = Utf8 ()V 
.const [194] = Utf8 de/audi/app/messaging/core/search/MessagingSearch 
.const [195] = Utf8 stopDSI 
.const [196] = Utf8 ()V 
.const [197] = Utf8 de/audi/app/messaging/core/search/MessagingSearch 
.const [198] = Utf8 getActiveGuiSearchHandler 
.const [199] = Utf8 ()Lde/audi/atip/search/AbstractGuiSearchHandler; 
.const [200] = Utf8 de/audi/atip/log/LogChannel 
.const [201] = Utf8 isDebug 
.const [202] = Utf8 ()Z 
.const [203] = Utf8 de/audi/atip/log/LogChannel 
.const [204] = Utf8 log 
.const [205] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [206] = Utf8 de/audi/app/messaging/core/search/MessagingSearch 
.const [207] = Utf8 cancelQuery 
.const [208] = Utf8 ()Z 
.const [209] = Utf8 java/lang/Integer 
.const [210] = Utf8 intValue 
.const [211] = Utf8 ()I 
.const [212] = Utf8 de/audi/app/messaging/core/search/MessagingSearch 
.const [213] = Utf8 setSearchFilter 
.const [214] = Utf8 (ILorg/dsi/ifc/search/SearchFilter;)V 
.const [215] = Utf8 de/audi/app/messaging/core/search/MessagingSearch 
.const [216] = Utf8 setActiveGuiSearchHandler 
.const [217] = Utf8 (Lde/audi/atip/search/AbstractGuiSearchHandler;)V 
.const [218] = Utf8 de/audi/atip/search/AbstractGuiSearchHandler 
.const [219] = Utf8 refreshQuery 
.const [220] = Utf8 ()V 
.const [221] = Utf8 de/audi/atip/search/AbstractSearch 
.const [222] = Utf8 <init> 
.const [223] = Utf8 (Lorg/osgi/framework/BundleContext;Lde/audi/atip/base/IFrameworkAccess;Lde/audi/atip/log/LogChannel;I)V 
.const [224] = Utf8 de/audi/app/messaging/core/component/MessagingComponentCollection 
.const [225] = Utf8 <init> 
.const [226] = Utf8 ()V 
.const [227] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [228] = Utf8 getLogChannel 
.const [229] = Utf8 (Ljava/lang/String;)Lde/audi/atip/log/LogChannel; 
.const [230] = Utf8 de/audi/app/messaging/core/search/MessagingSearch 
.const [231] = Utf8 subcomponents 
.const [232] = Utf8 Lde/audi/app/messaging/core/component/MessagingComponentCollection; 
.const [233] = Utf8 de/audi/app/messaging/core/search/MessagingSearch 
.const [234] = Utf8 searchFilters 
.const [235] = Utf8 Ljava/util/Map; 
.const [236] = Utf8 de/audi/app/messaging/core/search/MessagingSearch 
.const [237] = Utf8 log 
.const [238] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [239] = Utf8 java/util/Map 
.const [240] = Utf8 entrySet 
.const [241] = Utf8 ()Ljava/util/Set; 
.const [242] = Utf8 java/util/Set 
.const [243] = Utf8 iterator 
.const [244] = Utf8 ()Ljava/util/Iterator; 
.const [245] = Utf8 java/util/Iterator 
.const [246] = Utf8 hasNext 
.const [247] = Utf8 ()Z 
.const [248] = Utf8 java/util/Iterator 
.const [249] = Utf8 next 
.const [250] = Utf8 ()Ljava/lang/Object; 
.const [251] = Utf8 java/util/Map$Entry 
.const [252] = Utf8 getKey 
.const [253] = Utf8 ()Ljava/lang/Object; 
.const [254] = Utf8 java/util/Map$Entry 
.const [255] = Utf8 getValue 
.const [256] = Utf8 ()Ljava/lang/Object; 
.const [257] = Utf8 de/audi/app/messaging/core/search/MessagingSearch 
.const [258] = Class [257] 
.const [259] = Utf8 de/audi/atip/search/AbstractSearch 
.const [260] = Class [259] 
.const [261] = Utf8 de/audi/app/messaging/core/component/IMessagingComponent 
.const [262] = Class [261] 
.const [263] = Utf8 log 
.const [264] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [265] = Utf8 subcomponents 
.const [266] = Utf8 Lde/audi/app/messaging/core/component/MessagingComponentCollection; 
.const [267] = Utf8 searchFilters 
.const [268] = Utf8 Ljava/util/Map; 
.const [269] = Utf8 Code 
.const [270] = Utf8 <init> 
.const [271] = Utf8 (Lde/audi/app/messaging/core/osgi/MessagingBundleContext;)V 
.const [272] = Utf8 addComponent 
.const [273] = Utf8 (Lde/audi/app/messaging/core/component/IMessagingComponent;)V 
.const [274] = Utf8 init 
.const [275] = Utf8 (Lde/audi/app/messaging/core/application/AbstractMsgApplication;)V 
.const [276] = Utf8 dispose 
.const [277] = Utf8 ()V 
.const [278] = Utf8 connect 
.const [279] = Utf8 (Lde/audi/app/messaging/core/osgi/IServiceRegistry;)V 
.const [280] = Utf8 disconnect 
.const [281] = Utf8 ()V 
.const [282] = Utf8 switchConfiguration 
.const [283] = Utf8 (Lde/audi/atip/search/AbstractGuiSearchHandler;Ljava/util/Map;)V 
.end class 
