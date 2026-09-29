.version 50 0 
.class public super [197] 
.super [199] 
.implements [201] 
.implements [203] 
.field static synthetic [204] [205] 

.method public annotation [207] : [208] 
    .attribute [206] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [44] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [209] : [210] 
    .attribute [206] .code stack 1 locals 0 
L0:     aload_0 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected [211] : [212] 
    .attribute [206] .code stack 5 locals 0 
L0:     iconst_1 
L1:     anewarray [5] 
L4:     dup 
L5:     iconst_0 
L6:     getstatic [6] 
L9:     ifnonnull L24 
L12:    ldc [7] 
L14:    invokestatic [8] 
L17:    dup 
L18:    putstatic [45] 
L21:    goto L27 
L24:    getstatic [6] 
L27:    invokevirtual [36] 
L30:    aastore 
L31:    areturn 
L32:    
    .end code 
.end method 

.method protected [213] : [214] 
    .attribute [206] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [37] 
L4:     ldc [9] 
L6:     ldc [10] 
L8:     aload_1 
L9:     invokevirtual [38] 
L12:    pop 
L13:    aload_1 
L14:    instanceof [11] 
L17:    ifeq L22 
L20:    iconst_1 
L21:    areturn 
L22:    aload_0 
L23:    getfield [37] 
L26:    ldc [9] 
L28:    ldc [12] 
L30:    invokevirtual [39] 
L33:    pop 
L34:    iconst_0 
L35:    areturn 
L36:    
    .end code 
.end method 

.method protected [215] : [216] 
    .attribute [206] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [37] 
L4:     ldc [9] 
L6:     ldc [13] 
L8:     aload_1 
L9:     invokevirtual [38] 
L12:    pop 
L13:    aload_1 
L14:    instanceof [14] 
L17:    ifeq L22 
L20:    iconst_1 
L21:    areturn 
L22:    iconst_0 
L23:    areturn 
L24:    
    .end code 
.end method 

.method protected [217] : [218] 
    .attribute [206] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [37] 
L4:     ldc [9] 
L6:     ldc [15] 
L8:     invokevirtual [39] 
L11:    pop 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [219] : [220] 
    .attribute [206] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [37] 
L4:     ldc [9] 
L6:     ldc [16] 
L8:     invokevirtual [39] 
L11:    pop 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method private [221] : [222] 
    .attribute [206] .code stack 5 locals 4 
L0:     aload_0 
L1:     getfield [40] 
L4:     invokevirtual [41] 
L7:     astore_2 
L8:     aload_2 
L9:     ifnull L112 
L12:    aload_2 
L13:    arraylength 
L14:    ifle L112 
L17:    aload_0 
L18:    getfield [37] 
L21:    ldc [9] 
L23:    ldc [17] 
L25:    aload_2 
L26:    arraylength 
L27:    i2l 
L28:    invokevirtual [42] 
L31:    pop 
L32:    aload_2 
L33:    arraylength 
L34:    iconst_1 
L35:    if_icmple L53 
L38:    aload_0 
L39:    getfield [37] 
L42:    ldc [18] 
L44:    ldc [19] 
L46:    aload_2 
L47:    arraylength 
L48:    i2l 
L49:    invokevirtual [42] 
L52:    pop 
L53:    iconst_0 
L54:    istore_3 
L55:    iload_3 
L56:    aload_2 
L57:    arraylength 
L58:    if_icmpge L109 
L61:    aload_2 
L62:    iload_3 
L63:    aaload 
L64:    checkcast [11] 
L67:    astore 4 
        .catch [20] from L69 to L77 using L80 
L69:    aload_1 
L70:    aload 4 
L72:    invokeinterface [53] 0 
L77:    goto L103 
L80:    astore 5 
L82:    aload_0 
L83:    getfield [37] 
L86:    sipush 10000 
L89:    ldc [21] 
L91:    aload 4 
L93:    invokespecial [46] 
L96:    invokevirtual [36] 
L99:    invokevirtual [38] 
L102:   pop 
L103:   iinc 3 1 
L106:   goto L55 
L109:   goto L124 
L112:   aload_0 
L113:   getfield [37] 
L116:   ldc [9] 
L118:   ldc [22] 
L120:   invokevirtual [39] 
L123:   pop 
L124:   return 
L125:   nop 
L126:   nop 
L127:   nop 
L128:   
    .end code 
.end method 

.method public [223] : [224] 
    .attribute [206] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [37] 
L4:     ldc [9] 
L6:     ldc [23] 
L8:     aload_1 
L9:     invokevirtual [38] 
L12:    pop 
L13:    aload_0 
L14:    new [54] 
L17:    dup 
L18:    aload_0 
L19:    aload_1 
L20:    aload_2 
L21:    iload_3 
L22:    invokespecial [47] 
L25:    invokespecial [48] 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [225] : [226] 
    .attribute [206] .code stack 15 locals 0 
L0:     aload_0 
L1:     new [55] 
L4:     dup 
L5:     aload_0 
L6:     aload_1 
L7:     aload_2 
L8:     iload_3 
L9:     iload 4 
L11:    lload 5 
L13:    aload 7 
L15:    iload 8 
L17:    iload 9 
L19:    aload 10 
L21:    iload 11 
L23:    invokespecial [49] 
L26:    invokespecial [48] 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [227] : [228] 
    .attribute [206] .code stack 6 locals 0 
L0:     aload_0 
L1:     new [56] 
L4:     dup 
L5:     aload_0 
L6:     aload_1 
L7:     aload_2 
L8:     invokespecial [50] 
L11:    invokespecial [48] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [229] : [230] 
    .attribute [206] .code stack 14 locals 0 
L0:     aload_0 
L1:     new [57] 
L4:     dup 
L5:     aload_0 
L6:     aload_1 
L7:     aload_2 
L8:     iload_3 
L9:     iload 4 
L11:    lload 5 
L13:    aload 7 
L15:    iload 8 
L17:    iload 9 
L19:    aload 10 
L21:    invokespecial [51] 
L24:    invokespecial [48] 
L27:    return 
L28:    
    .end code 
.end method 

.method public enum [231] : [232] 
    .attribute [206] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method static synthetic [233] : [234] 
    .attribute [206] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [52] 
L9:     dup 
L10:    invokespecial [43] 
L13:    aload_1 
L14:    invokevirtual [35] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [58] [59] 
.const [3] = Class [60] 
.const [4] = Class [61] 
.const [5] = Class [62] 
.const [6] = Field [63] [64] 
.const [7] = String [65] 
.const [8] = Method [66] [67] 
.const [9] = Int -2137614336 
.const [10] = String [68] 
.const [11] = Class [69] 
.const [12] = String [70] 
.const [13] = String [71] 
.const [14] = Class [72] 
.const [15] = String [73] 
.const [16] = String [74] 
.const [17] = String [75] 
.const [18] = Int -1601830656 
.const [19] = String [76] 
.const [20] = Class [77] 
.const [21] = String [78] 
.const [22] = String [79] 
.const [23] = String [80] 
.const [24] = Class [81] 
.const [25] = Class [82] 
.const [26] = Class [83] 
.const [27] = Class [84] 
.const [28] = Class [85] 
.const [29] = Class [86] 
.const [30] = Class [87] 
.const [31] = Class [88] 
.const [32] = Class [89] 
.const [33] = Class [90] 
.const [34] = Class [91] 
.const [35] = Method [92] [93] 
.const [36] = Method [94] [95] 
.const [37] = Field [96] [97] 
.const [38] = Method [98] [99] 
.const [39] = Method [100] [101] 
.const [40] = Field [102] [103] 
.const [41] = Method [104] [105] 
.const [42] = Method [106] [107] 
.const [43] = Method [108] [109] 
.const [44] = Method [110] [111] 
.const [45] = Field [112] [113] 
.const [46] = Method [114] [115] 
.const [47] = Method [116] [117] 
.const [48] = Method [118] [119] 
.const [49] = Method [120] [121] 
.const [50] = Method [122] [123] 
.const [51] = Method [124] [125] 
.const [52] = Class [126] 
.const [53] = InterfaceMethod [127] [128] 
.const [54] = Class [129] 
.const [55] = Class [130] 
.const [56] = Class [131] 
.const [57] = Class [132] 
.const [58] = Class [133] 
.const [59] = NameAndType [134] [135] 
.const [60] = Utf8 java/lang/ClassNotFoundException 
.const [61] = Utf8 java/lang/NoClassDefFoundError 
.const [62] = Utf8 java/lang/String 
.const [63] = Class [136] 
.const [64] = NameAndType [137] [138] 
.const [65] = Utf8 'de.audi.atip.phone.ITelService' 
.const [66] = Class [139] 
.const [67] = NameAndType [140] [141] 
.const [68] = Utf8 'TelServiceController#trackedServiceAdded( %1 )' 
.const [69] = Utf8 de/audi/atip/phone/ITelService 
.const [70] = Utf8 'TelServiceController#trackedServiceAdded() - not an ITelServiceSDS' 
.const [71] = Utf8 'TelServiceController#trackedServiceRemoved( %1 )' 
.const [72] = Utf8 de/audi/atip/interapp/NaviServiceListener 
.const [73] = Utf8 'TelServiceController#onStart( )' 
.const [74] = Utf8 'TelServiceController#onStop( )' 
.const [75] = Utf8 'TelServiceController#traverseListeners - length: %1' 
.const [76] = Utf8 'TelServiceController#traverseListeners - More than 1 ITelService! - length: %1' 
.const [77] = Utf8 java/lang/Exception 
.const [78] = Utf8 'TelServiceController#traverseListeners - error during update. - %1' 
.const [79] = Utf8 'TelServiceController#traverseListeners - no services' 
.const [80] = Utf8 'TelServiceController#dialNumber - number: %1' 
.const [81] = Utf8 de/audi/tghu/navi/app/phone/TelServiceController$1 
.const [82] = Utf8 de/audi/tghu/navi/app/phone/TelServiceController$2 
.const [83] = Utf8 de/audi/tghu/navi/app/phone/TelServiceController$3 
.const [84] = Utf8 de/audi/tghu/navi/app/phone/TelServiceController$4 
.const [85] = Utf8 de/audi/tghu/navi/app/phone/TelServiceController 
.const [86] = Utf8 de/audi/tghu/navi/app/AbstractNaviServiceComponent 
.const [87] = Utf8 de/audi/tghu/navi/app/phone/TelServiceController$IOperation 
.const [88] = Utf8 java/lang/Class 
.const [89] = Utf8 de/audi/atip/log/LogChannel 
.const [90] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [91] = Utf8 java/lang/Object 
.const [92] = Class [142] 
.const [93] = NameAndType [143] [144] 
.const [94] = Class [145] 
.const [95] = NameAndType [146] [147] 
.const [96] = Class [148] 
.const [97] = NameAndType [149] [150] 
.const [98] = Class [151] 
.const [99] = NameAndType [152] [153] 
.const [100] = Class [154] 
.const [101] = NameAndType [155] [156] 
.const [102] = Class [157] 
.const [103] = NameAndType [158] [159] 
.const [104] = Class [160] 
.const [105] = NameAndType [161] [162] 
.const [106] = Class [163] 
.const [107] = NameAndType [164] [165] 
.const [108] = Class [166] 
.const [109] = NameAndType [167] [168] 
.const [110] = Class [169] 
.const [111] = NameAndType [170] [171] 
.const [112] = Class [172] 
.const [113] = NameAndType [173] [174] 
.const [114] = Class [175] 
.const [115] = NameAndType [176] [177] 
.const [116] = Class [178] 
.const [117] = NameAndType [179] [180] 
.const [118] = Class [181] 
.const [119] = NameAndType [182] [183] 
.const [120] = Class [184] 
.const [121] = NameAndType [185] [186] 
.const [122] = Class [187] 
.const [123] = NameAndType [188] [189] 
.const [124] = Class [190] 
.const [125] = NameAndType [191] [192] 
.const [126] = Utf8 java/lang/NoClassDefFoundError 
.const [127] = Class [193] 
.const [128] = NameAndType [194] [195] 
.const [129] = Utf8 de/audi/tghu/navi/app/phone/TelServiceController$1 
.const [130] = Utf8 de/audi/tghu/navi/app/phone/TelServiceController$2 
.const [131] = Utf8 de/audi/tghu/navi/app/phone/TelServiceController$3 
.const [132] = Utf8 de/audi/tghu/navi/app/phone/TelServiceController$4 
.const [133] = Utf8 java/lang/Class 
.const [134] = Utf8 forName 
.const [135] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [136] = Utf8 de/audi/tghu/navi/app/phone/TelServiceController 
.const [137] = Utf8 class$de$audi$atip$phone$ITelService 
.const [138] = Utf8 Ljava/lang/Class; 
.const [139] = Utf8 de/audi/tghu/navi/app/phone/TelServiceController 
.const [140] = Utf8 class$ 
.const [141] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [142] = Utf8 java/lang/NoClassDefFoundError 
.const [143] = Utf8 initCause 
.const [144] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [145] = Utf8 java/lang/Class 
.const [146] = Utf8 getName 
.const [147] = Utf8 ()Ljava/lang/String; 
.const [148] = Utf8 de/audi/tghu/navi/app/phone/TelServiceController 
.const [149] = Utf8 logChannel 
.const [150] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [151] = Utf8 de/audi/atip/log/LogChannel 
.const [152] = Utf8 log 
.const [153] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [154] = Utf8 de/audi/atip/log/LogChannel 
.const [155] = Utf8 log 
.const [156] = Utf8 (ILjava/lang/String;)Z 
.const [157] = Utf8 de/audi/tghu/navi/app/phone/TelServiceController 
.const [158] = Utf8 tracker 
.const [159] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [160] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [161] = Utf8 getServices 
.const [162] = Utf8 ()[Ljava/lang/Object; 
.const [163] = Utf8 de/audi/atip/log/LogChannel 
.const [164] = Utf8 log 
.const [165] = Utf8 (ILjava/lang/String;J)Z 
.const [166] = Utf8 java/lang/NoClassDefFoundError 
.const [167] = Utf8 <init> 
.const [168] = Utf8 ()V 
.const [169] = Utf8 de/audi/tghu/navi/app/AbstractNaviServiceComponent 
.const [170] = Utf8 <init> 
.const [171] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [172] = Utf8 de/audi/tghu/navi/app/phone/TelServiceController 
.const [173] = Utf8 class$de$audi$atip$phone$ITelService 
.const [174] = Utf8 Ljava/lang/Class; 
.const [175] = Utf8 java/lang/Object 
.const [176] = Utf8 getClass 
.const [177] = Utf8 ()Ljava/lang/Class; 
.const [178] = Utf8 de/audi/tghu/navi/app/phone/TelServiceController$1 
.const [179] = Utf8 <init> 
.const [180] = Utf8 (Lde/audi/tghu/navi/app/phone/TelServiceController;Ljava/lang/String;Lde/audi/atip/phone/ITelServiceListener;Z)V 
.const [181] = Utf8 de/audi/tghu/navi/app/phone/TelServiceController 
.const [182] = Utf8 traverseServices 
.const [183] = Utf8 (Lde/audi/tghu/navi/app/phone/TelServiceController$IOperation;)V 
.const [184] = Utf8 de/audi/tghu/navi/app/phone/TelServiceController$2 
.const [185] = Utf8 <init> 
.const [186] = Utf8 (Lde/audi/tghu/navi/app/phone/TelServiceController;Ljava/lang/String;Ljava/lang/String;SSJLorg/dsi/ifc/global/ResourceLocator;IILde/audi/atip/phone/ITelServiceListener;Z)V 
.const [187] = Utf8 de/audi/tghu/navi/app/phone/TelServiceController$3 
.const [188] = Utf8 <init> 
.const [189] = Utf8 (Lde/audi/tghu/navi/app/phone/TelServiceController;Ljava/lang/String;Lde/audi/atip/phone/ITelServiceListener;)V 
.const [190] = Utf8 de/audi/tghu/navi/app/phone/TelServiceController$4 
.const [191] = Utf8 <init> 
.const [192] = Utf8 (Lde/audi/tghu/navi/app/phone/TelServiceController;Ljava/lang/String;Ljava/lang/String;SSJLorg/dsi/ifc/global/ResourceLocator;IILde/audi/atip/phone/ITelServiceListener;)V 
.const [193] = Utf8 de/audi/tghu/navi/app/phone/TelServiceController$IOperation 
.const [194] = Utf8 execute 
.const [195] = Utf8 (Lde/audi/atip/phone/ITelService;)V 
.const [196] = Utf8 de/audi/tghu/navi/app/phone/TelServiceController 
.const [197] = Class [196] 
.const [198] = Utf8 de/audi/tghu/navi/app/AbstractNaviServiceComponent 
.const [199] = Class [198] 
.const [200] = Utf8 de/audi/atip/phone/ITelService 
.const [201] = Class [200] 
.const [202] = Utf8 de/audi/tghu/navi/app/phone/ITelServiceController 
.const [203] = Class [202] 
.const [204] = Utf8 class$de$audi$atip$phone$ITelService 
.const [205] = Utf8 Ljava/lang/Class; 
.const [206] = Utf8 Code 
.const [207] = Utf8 <init> 
.const [208] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [209] = Utf8 getTelService 
.const [210] = Utf8 ()Lde/audi/atip/phone/ITelService; 
.const [211] = Utf8 getTrackedService 
.const [212] = Utf8 ()[Ljava/lang/String; 
.const [213] = Utf8 trackedServiceAdded 
.const [214] = Utf8 (Ljava/lang/Object;)Z 
.const [215] = Utf8 trackedServiceRemoved 
.const [216] = Utf8 (Ljava/lang/Object;)Z 
.const [217] = Utf8 onStart 
.const [218] = Utf8 ()V 
.const [219] = Utf8 onStop 
.const [220] = Utf8 ()V 
.const [221] = Utf8 traverseServices 
.const [222] = Utf8 (Lde/audi/tghu/navi/app/phone/TelServiceController$IOperation;)V 
.const [223] = Utf8 dialNumber 
.const [224] = Utf8 (Ljava/lang/String;Lde/audi/atip/phone/ITelServiceListener;Z)V 
.const [225] = Utf8 dialNumberFromADBEntry 
.const [226] = Utf8 (Ljava/lang/String;Ljava/lang/String;SSJLorg/dsi/ifc/global/ResourceLocator;IILde/audi/atip/phone/ITelServiceListener;Z)V 
.const [227] = Utf8 prepareDialing 
.const [228] = Utf8 (Ljava/lang/String;Lde/audi/atip/phone/ITelServiceListener;)V 
.const [229] = Utf8 prepareDialing 
.const [230] = Utf8 (Ljava/lang/String;Ljava/lang/String;SSJLorg/dsi/ifc/global/ResourceLocator;IILde/audi/atip/phone/ITelServiceListener;)V 
.const [231] = Utf8 dialNumber 
.const [232] = Utf8 (Lde/audi/atip/interapp/phone/ITelCallSession;Z)V 
.const [233] = Utf8 class$ 
.const [234] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
