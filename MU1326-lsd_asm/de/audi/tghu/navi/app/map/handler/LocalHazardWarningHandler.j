.version 50 0 
.class public super [146] 
.super [148] 
.field private static final [149] [150] 
.field private static final [151] [152] 
.field private final [153] [154] 
.field private [155] [156] 

.method public [158] : [159] 
    .attribute [157] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [27] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [16] 
L9:     putfield [32] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public interface [160] : [161] 
    .attribute [157] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [162] : [163] 
    .attribute [157] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [33] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [164] : [165] 
    .attribute [157] .code stack 5 locals 0 
L0:     aload_1 
L1:     ifnonnull L17 
L4:     aload_0 
L5:     getfield [17] 
L8:     ldc [2] 
L10:    ldc [3] 
L12:    invokevirtual [19] 
L15:    pop 
L16:    return 
L17:    aload_0 
L18:    getfield [17] 
L21:    ldc [2] 
L23:    ldc [4] 
L25:    aload_1 
L26:    arraylength 
L27:    i2l 
L28:    invokevirtual [20] 
L31:    pop 
L32:    aload_0 
L33:    aload_1 
L34:    invokevirtual [21] 
L37:    aload_0 
L38:    aload_1 
L39:    invokespecial [28] 
L42:    return 
L43:    nop 
L44:    
    .end code 
.end method 

.method private [166] : [167] 
    .attribute [157] .code stack 3 locals 4 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [29] 
L5:     astore_2 
L6:     iconst_0 
L7:     istore_3 
L8:     iload_3 
L9:     aload_2 
L10:    arraylength 
L11:    if_icmpge L52 
L14:    aload_2 
L15:    iload_3 
L16:    aaload 
L17:    astore 4 
L19:    new [34] 
L22:    dup 
L23:    iconst_1 
L24:    anewarray [6] 
L27:    invokespecial [30] 
L30:    astore 5 
L32:    aload 5 
L34:    iconst_0 
L35:    aload 4 
L37:    invokevirtual [22] 
L40:    invokestatic [7] 
L43:    invokevirtual [23] 
L46:    iinc 3 1 
L49:    goto L8 
L52:    return 
L53:    nop 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method private [168] : [169] 
    .attribute [157] .code stack 2 locals 3 
L0:     new [35] 
L3:     dup 
L4:     invokespecial [31] 
L7:     astore_2 
L8:     iconst_0 
L9:     istore_3 
L10:    iload_3 
L11:    aload_1 
L12:    arraylength 
L13:    if_icmpge L68 
L16:    aload_1 
L17:    iload_3 
L18:    aaload 
L19:    astore 4 
L21:    aload 4 
L23:    ifnull L62 
L26:    aload 4 
L28:    invokevirtual [22] 
L31:    ifeq L62 
L34:    aload 4 
L36:    invokevirtual [22] 
L39:    iconst_1 
L40:    if_icmpeq L62 
L43:    aload 4 
L45:    invokevirtual [22] 
L48:    iconst_3 
L49:    if_icmpne L55 
L52:    goto L62 
L55:    aload_2 
L56:    aload 4 
L58:    invokevirtual [24] 
L61:    pop 
L62:    iinc 3 1 
L65:    goto L10 
L68:    aload_2 
L69:    aload_2 
L70:    invokevirtual [25] 
L73:    anewarray [9] 
L76:    invokevirtual [26] 
L79:    checkcast [10] 
L82:    checkcast [10] 
L85:    areturn 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [36] 
.const [4] = String [37] 
.const [5] = Class [38] 
.const [6] = Class [39] 
.const [7] = Method [40] [41] 
.const [8] = Class [42] 
.const [9] = Class [43] 
.const [10] = Class [44] 
.const [11] = Class [45] 
.const [12] = Class [46] 
.const [13] = Class [47] 
.const [14] = Class [48] 
.const [15] = Class [49] 
.const [16] = Method [50] [51] 
.const [17] = Field [52] [53] 
.const [18] = Field [54] [55] 
.const [19] = Method [56] [57] 
.const [20] = Method [58] [59] 
.const [21] = Method [60] [61] 
.const [22] = Method [62] [63] 
.const [23] = Method [64] [65] 
.const [24] = Method [66] [67] 
.const [25] = Method [68] [69] 
.const [26] = Method [70] [71] 
.const [27] = Method [72] [73] 
.const [28] = Method [74] [75] 
.const [29] = Method [76] [77] 
.const [30] = Method [78] [79] 
.const [31] = Method [80] [81] 
.const [32] = Field [82] [83] 
.const [33] = Field [84] [85] 
.const [34] = Class [86] 
.const [35] = Class [87] 
.const [36] = Utf8 'LocalHazardWarningHandler#updateLocalHazardInformation( null )' 
.const [37] = Utf8 'LocalHazardWarningHandler#updateLocalHazardInformation( %1 )' 
.const [38] = Utf8 de/audi/atip/hmi/model/BaseListRow 
.const [39] = Utf8 de/audi/atip/hmi/model/ListCell 
.const [40] = Class [88] 
.const [41] = NameAndType [89] [90] 
.const [42] = Utf8 java/util/Vector 
.const [43] = Utf8 org/dsi/ifc/tmc/LocalHazardInformation 
.const [44] = Utf8 [Lorg/dsi/ifc/tmc/LocalHazardInformation; 
.const [45] = Utf8 de/audi/tghu/navi/app/map/handler/LocalHazardWarningHandler 
.const [46] = Utf8 java/lang/Object 
.const [47] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [48] = Utf8 de/audi/atip/log/LogChannel 
.const [49] = Utf8 de/audi/atip/hmi/model/IntegerListCell 
.const [50] = Class [91] 
.const [51] = NameAndType [92] [93] 
.const [52] = Class [94] 
.const [53] = NameAndType [95] [96] 
.const [54] = Class [97] 
.const [55] = NameAndType [98] [99] 
.const [56] = Class [100] 
.const [57] = NameAndType [101] [102] 
.const [58] = Class [103] 
.const [59] = NameAndType [104] [105] 
.const [60] = Class [106] 
.const [61] = NameAndType [107] [108] 
.const [62] = Class [109] 
.const [63] = NameAndType [110] [111] 
.const [64] = Class [112] 
.const [65] = NameAndType [113] [114] 
.const [66] = Class [115] 
.const [67] = NameAndType [116] [117] 
.const [68] = Class [118] 
.const [69] = NameAndType [119] [120] 
.const [70] = Class [121] 
.const [71] = NameAndType [122] [123] 
.const [72] = Class [124] 
.const [73] = NameAndType [125] [126] 
.const [74] = Class [127] 
.const [75] = NameAndType [128] [129] 
.const [76] = Class [130] 
.const [77] = NameAndType [131] [132] 
.const [78] = Class [133] 
.const [79] = NameAndType [134] [135] 
.const [80] = Class [136] 
.const [81] = NameAndType [137] [138] 
.const [82] = Class [139] 
.const [83] = NameAndType [140] [141] 
.const [84] = Class [142] 
.const [85] = NameAndType [143] [144] 
.const [86] = Utf8 de/audi/atip/hmi/model/BaseListRow 
.const [87] = Utf8 java/util/Vector 
.const [88] = Utf8 de/audi/atip/hmi/model/IntegerListCell 
.const [89] = Utf8 create 
.const [90] = Utf8 (I)Lde/audi/atip/hmi/model/IntegerListCell; 
.const [91] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [92] = Utf8 getMapMainLogChannel 
.const [93] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [94] = Utf8 de/audi/tghu/navi/app/map/handler/LocalHazardWarningHandler 
.const [95] = Utf8 logChannel 
.const [96] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [97] = Utf8 de/audi/tghu/navi/app/map/handler/LocalHazardWarningHandler 
.const [98] = Utf8 localHazardWarnings 
.const [99] = Utf8 [Lorg/dsi/ifc/tmc/LocalHazardInformation; 
.const [100] = Utf8 de/audi/atip/log/LogChannel 
.const [101] = Utf8 log 
.const [102] = Utf8 (ILjava/lang/String;)Z 
.const [103] = Utf8 de/audi/atip/log/LogChannel 
.const [104] = Utf8 log 
.const [105] = Utf8 (ILjava/lang/String;J)Z 
.const [106] = Utf8 de/audi/tghu/navi/app/map/handler/LocalHazardWarningHandler 
.const [107] = Utf8 setLocalHazardWarnings 
.const [108] = Utf8 ([Lorg/dsi/ifc/tmc/LocalHazardInformation;)V 
.const [109] = Utf8 org/dsi/ifc/tmc/LocalHazardInformation 
.const [110] = Utf8 getEventType 
.const [111] = Utf8 ()I 
.const [112] = Utf8 de/audi/atip/hmi/model/BaseListRow 
.const [113] = Utf8 setCell 
.const [114] = Utf8 (ILde/audi/atip/hmi/model/ListCell;)V 
.const [115] = Utf8 java/util/Vector 
.const [116] = Utf8 add 
.const [117] = Utf8 (Ljava/lang/Object;)Z 
.const [118] = Utf8 java/util/Vector 
.const [119] = Utf8 size 
.const [120] = Utf8 ()I 
.const [121] = Utf8 java/util/Vector 
.const [122] = Utf8 toArray 
.const [123] = Utf8 ([Ljava/lang/Object;)[Ljava/lang/Object; 
.const [124] = Utf8 java/lang/Object 
.const [125] = Utf8 <init> 
.const [126] = Utf8 ()V 
.const [127] = Utf8 de/audi/tghu/navi/app/map/handler/LocalHazardWarningHandler 
.const [128] = Utf8 updateLgiListModel 
.const [129] = Utf8 ([Lorg/dsi/ifc/tmc/LocalHazardInformation;)V 
.const [130] = Utf8 de/audi/tghu/navi/app/map/handler/LocalHazardWarningHandler 
.const [131] = Utf8 filterForRelevantWarnings 
.const [132] = Utf8 ([Lorg/dsi/ifc/tmc/LocalHazardInformation;)[Lorg/dsi/ifc/tmc/LocalHazardInformation; 
.const [133] = Utf8 de/audi/atip/hmi/model/BaseListRow 
.const [134] = Utf8 <init> 
.const [135] = Utf8 ([Lde/audi/atip/hmi/model/ListCell;)V 
.const [136] = Utf8 java/util/Vector 
.const [137] = Utf8 <init> 
.const [138] = Utf8 ()V 
.const [139] = Utf8 de/audi/tghu/navi/app/map/handler/LocalHazardWarningHandler 
.const [140] = Utf8 logChannel 
.const [141] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [142] = Utf8 de/audi/tghu/navi/app/map/handler/LocalHazardWarningHandler 
.const [143] = Utf8 localHazardWarnings 
.const [144] = Utf8 [Lorg/dsi/ifc/tmc/LocalHazardInformation; 
.const [145] = Utf8 de/audi/tghu/navi/app/map/handler/LocalHazardWarningHandler 
.const [146] = Class [145] 
.const [147] = Utf8 java/lang/Object 
.const [148] = Class [147] 
.const [149] = Utf8 MAX_COLUMNS 
.const [150] = Utf8 I 
.const [151] = Utf8 CELL_LGI_EVENT_TYPE 
.const [152] = Utf8 I 
.const [153] = Utf8 logChannel 
.const [154] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [155] = Utf8 localHazardWarnings 
.const [156] = Utf8 [Lorg/dsi/ifc/tmc/LocalHazardInformation; 
.const [157] = Utf8 Code 
.const [158] = Utf8 <init> 
.const [159] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;)V 
.const [160] = Utf8 getLocalHazardWarnings 
.const [161] = Utf8 ()[Lorg/dsi/ifc/tmc/LocalHazardInformation; 
.const [162] = Utf8 setLocalHazardWarnings 
.const [163] = Utf8 ([Lorg/dsi/ifc/tmc/LocalHazardInformation;)V 
.const [164] = Utf8 updateLocalHazardInformation 
.const [165] = Utf8 ([Lorg/dsi/ifc/tmc/LocalHazardInformation;)V 
.const [166] = Utf8 updateLgiListModel 
.const [167] = Utf8 ([Lorg/dsi/ifc/tmc/LocalHazardInformation;)V 
.const [168] = Utf8 filterForRelevantWarnings 
.const [169] = Utf8 ([Lorg/dsi/ifc/tmc/LocalHazardInformation;)[Lorg/dsi/ifc/tmc/LocalHazardInformation; 
.end class 
