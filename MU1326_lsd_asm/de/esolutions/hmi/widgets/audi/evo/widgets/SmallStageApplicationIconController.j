.version 50 0 
.class public super [168] 
.super [170] 
.field private static final [171] [172] 
.field private static final [173] [174] 
.field private static final [175] [176] 
.field private static final [177] [178] 
.field private static final [179] [180] 
.field private static final [181] [182] 
.field private static final [183] [184] 
.field private static final [185] [186] 
.field private static final [187] [188] 
.field private static final [189] [190] 
.field private static [191] [192] 

.method public annotation [194] : [195] 
    .attribute [193] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [28] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [196] : [197] 
    .attribute [193] .code stack 2 locals 1 
L0:     aload_0 
L1:     invokespecial [29] 
L4:     aload_0 
L5:     invokevirtual [18] 
L8:     ifeq L49 
L11:    aload_0 
L12:    getfield [19] 
L15:    invokevirtual [20] 
L18:    instanceof [2] 
L21:    ifeq L49 
L24:    aload_0 
L25:    getfield [19] 
L28:    invokevirtual [20] 
L31:    checkcast [2] 
L34:    invokevirtual [21] 
L37:    astore_1 
L38:    aload_1 
L39:    ifnull L49 
L42:    aload_1 
L43:    aload_0 
L44:    invokeinterface [35] 0 
L49:    return 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method private [198] : [199] 
    .attribute [193] .code stack 1 locals 3 
L0:     aload_0 
L1:     getfield [22] 
L4:     invokevirtual [23] 
L7:     invokeinterface [36] 0 
L12:    istore_1 
L13:    invokestatic [3] 
L16:    istore_2 
L17:    iload_1 
L18:    tableswitch 20 
            L132 
            L146 
            L206 
            L206 
            L206 
            L206 
            L206 
            L206 
            L206 
            L206 
            L206 
            L206 
            L206 
            L206 
            L206 
            L206 
            L206 
            L206 
            L206 
            L206 
            L161 
            L176 
            L161 
            L191 
            L161 
            default : L206 

L132:   iload_2 
L133:   ifeq L141 
L136:   bipush 10 
L138:   goto L142 
L141:   iconst_0 
L142:   istore_3 
L143:   goto L208 
L146:   iload_2 
L147:   ifeq L155 
L150:   bipush 12 
L152:   goto L157 
L155:   bipush 11 
L157:   istore_3 
L158:   goto L208 
L161:   iload_2 
L162:   ifeq L170 
L165:   bipush 14 
L167:   goto L172 
L170:   bipush 13 
L172:   istore_3 
L173:   goto L208 
L176:   iload_2 
L177:   ifeq L185 
L180:   bipush 16 
L182:   goto L187 
L185:   bipush 15 
L187:   istore_3 
L188:   goto L208 
L191:   iload_2 
L192:   ifeq L200 
L195:   bipush 18 
L197:   goto L202 
L200:   bipush 17 
L202:   istore_3 
L203:   goto L208 
L206:   iconst_0 
L207:   istore_3 
L208:   iload_3 
L209:   areturn 
L210:   nop 
L211:   nop 
L212:   
    .end code 
.end method 

.method public [200] : [201] 
    .attribute [193] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokevirtual [18] 
L4:     ifne L12 
L7:     aload_0 
L8:     aload_1 
L9:     invokespecial [30] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [202] : [203] 
    .attribute [193] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [24] 
L4:     instanceof [4] 
L7:     ifeq L71 
L10:    aload_0 
L11:    getfield [24] 
L14:    checkcast [4] 
L17:    invokeinterface [37] 0 
L22:    istore_1 
L23:    iload_1 
L24:    ifne L62 
L27:    getstatic [5] 
L30:    iconst_m1 
L31:    if_icmpne L41 
L34:    aload_0 
L35:    invokespecial [32] 
L38:    putstatic [31] 
L41:    aload_0 
L42:    getstatic [5] 
L45:    invokevirtual [25] 
L48:    ifeq L62 
L51:    new [38] 
L54:    dup 
L55:    getstatic [5] 
L58:    invokespecial [33] 
L61:    areturn 
L62:    new [38] 
L65:    dup 
L66:    iload_1 
L67:    invokespecial [33] 
L70:    areturn 
L71:    getstatic [7] 
L74:    ldc [8] 
L76:    ldc [9] 
L78:    invokevirtual [26] 
L81:    pop 
L82:    aload_0 
L83:    invokespecial [34] 
L86:    areturn 
L87:    nop 
L88:    
    .end code 
.end method 

.method protected [204] : [205] 
    .attribute [193] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     ifnull L21 
L7:     aload_0 
L8:     getfield [27] 
L11:    sipush 138 
L14:    if_icmpne L21 
L17:    iconst_1 
L18:    goto L22 
L21:    iconst_0 
L22:    areturn 
L23:    nop 
L24:    
    .end code 
.end method 

.method static [206] : [207] 
    .attribute [193] .code stack 1 locals 0 
L0:     iconst_m1 
L1:     putstatic [31] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [39] 
.const [3] = Method [40] [41] 
.const [4] = Class [42] 
.const [5] = Field [43] [44] 
.const [6] = Class [45] 
.const [7] = Field [46] [47] 
.const [8] = Int -2137614336 
.const [9] = String [48] 
.const [10] = Class [49] 
.const [11] = Class [50] 
.const [12] = Class [51] 
.const [13] = Class [52] 
.const [14] = Class [53] 
.const [15] = Class [54] 
.const [16] = Class [55] 
.const [17] = Class [56] 
.const [18] = Method [57] [58] 
.const [19] = Field [59] [60] 
.const [20] = Method [61] [62] 
.const [21] = Method [63] [64] 
.const [22] = Field [65] [66] 
.const [23] = Method [67] [68] 
.const [24] = Field [69] [70] 
.const [25] = Method [71] [72] 
.const [26] = Method [73] [74] 
.const [27] = Field [75] [76] 
.const [28] = Method [77] [78] 
.const [29] = Method [79] [80] 
.const [30] = Method [81] [82] 
.const [31] = Field [83] [84] 
.const [32] = Method [85] [86] 
.const [33] = Method [87] [88] 
.const [34] = Method [89] [90] 
.const [35] = InterfaceMethod [91] [92] 
.const [36] = InterfaceMethod [93] [94] 
.const [37] = InterfaceMethod [95] [96] 
.const [38] = Class [97] 
.const [39] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractScreenWidget 
.const [40] = Class [98] 
.const [41] = NameAndType [99] [100] 
.const [42] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelGUI 
.const [43] = Class [101] 
.const [44] = NameAndType [102] [103] 
.const [45] = Utf8 java/lang/Integer 
.const [46] = Class [104] 
.const [47] = NameAndType [105] [106] 
.const [48] = Utf8 'SmallStageApplicatoinIconController#calculateModelContent internal model is not a choice model (expected).' 
.const [49] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/SmallStageApplicationIconController 
.const [50] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/IconController 
.const [51] = Utf8 de/esolutions/hmi/widgets/audi/base/InitializationContext 
.const [52] = Utf8 de/esolutions/hmi/widgets/audi/base/ScreenMainArea 
.const [53] = Utf8 de/esolutions/hmi/widgets/audi/base/HMITerminalImpl 
.const [54] = Utf8 de/audi/tghu/hmi/evo/ICarCodingHelper 
.const [55] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
.const [56] = Utf8 de/audi/atip/log/LogChannel 
.const [57] = Class [107] 
.const [58] = NameAndType [108] [109] 
.const [59] = Class [110] 
.const [60] = NameAndType [111] [112] 
.const [61] = Class [113] 
.const [62] = NameAndType [114] [115] 
.const [63] = Class [116] 
.const [64] = NameAndType [117] [118] 
.const [65] = Class [119] 
.const [66] = NameAndType [120] [121] 
.const [67] = Class [122] 
.const [68] = NameAndType [123] [124] 
.const [69] = Class [125] 
.const [70] = NameAndType [126] [127] 
.const [71] = Class [128] 
.const [72] = NameAndType [129] [130] 
.const [73] = Class [131] 
.const [74] = NameAndType [132] [133] 
.const [75] = Class [134] 
.const [76] = NameAndType [135] [136] 
.const [77] = Class [137] 
.const [78] = NameAndType [138] [139] 
.const [79] = Class [140] 
.const [80] = NameAndType [141] [142] 
.const [81] = Class [143] 
.const [82] = NameAndType [144] [145] 
.const [83] = Class [146] 
.const [84] = NameAndType [147] [148] 
.const [85] = Class [149] 
.const [86] = NameAndType [150] [151] 
.const [87] = Class [152] 
.const [88] = NameAndType [153] [154] 
.const [89] = Class [155] 
.const [90] = NameAndType [156] [157] 
.const [91] = Class [158] 
.const [92] = NameAndType [159] [160] 
.const [93] = Class [161] 
.const [94] = NameAndType [162] [163] 
.const [95] = Class [164] 
.const [96] = NameAndType [165] [166] 
.const [97] = Utf8 java/lang/Integer 
.const [98] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
.const [99] = Utf8 isRightHandDrive 
.const [100] = Utf8 ()Z 
.const [101] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/SmallStageApplicationIconController 
.const [102] = Utf8 correctCarPictureIndex 
.const [103] = Utf8 I 
.const [104] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/SmallStageApplicationIconController 
.const [105] = Utf8 iconLogChannel 
.const [106] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [107] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/SmallStageApplicationIconController 
.const [108] = Utf8 isSmallStageApplicationIcon 
.const [109] = Utf8 ()Z 
.const [110] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/SmallStageApplicationIconController 
.const [111] = Utf8 initContext 
.const [112] = Utf8 Lde/esolutions/hmi/widgets/audi/base/InitializationContext; 
.const [113] = Utf8 de/esolutions/hmi/widgets/audi/base/InitializationContext 
.const [114] = Utf8 getScreen 
.const [115] = Utf8 ()Lde/audi/atip/hmi/view/Screen; 
.const [116] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractScreenWidget 
.const [117] = Utf8 getMainArea 
.const [118] = Utf8 ()Lde/esolutions/hmi/widgets/audi/base/ScreenMainArea; 
.const [119] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/SmallStageApplicationIconController 
.const [120] = Utf8 terminal 
.const [121] = Utf8 Lde/esolutions/hmi/widgets/audi/base/HMITerminalImpl; 
.const [122] = Utf8 de/esolutions/hmi/widgets/audi/base/HMITerminalImpl 
.const [123] = Utf8 getCarCodingHelper 
.const [124] = Utf8 ()Lde/audi/tghu/hmi/evo/ICarCodingHelper; 
.const [125] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/SmallStageApplicationIconController 
.const [126] = Utf8 model 
.const [127] = Utf8 Ljava/lang/Object; 
.const [128] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/SmallStageApplicationIconController 
.const [129] = Utf8 hasBitmap 
.const [130] = Utf8 (I)Z 
.const [131] = Utf8 de/audi/atip/log/LogChannel 
.const [132] = Utf8 log 
.const [133] = Utf8 (ILjava/lang/String;)Z 
.const [134] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/SmallStageApplicationIconController 
.const [135] = Utf8 modelID 
.const [136] = Utf8 I 
.const [137] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/IconController 
.const [138] = Utf8 <init> 
.const [139] = Utf8 ()V 
.const [140] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/IconController 
.const [141] = Utf8 initializeWidget 
.const [142] = Utf8 ()V 
.const [143] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/IconController 
.const [144] = Utf8 processModelUpdateEvent 
.const [145] = Utf8 (Lde/audi/atip/hmi/event/ModelUpdateEvent;)V 
.const [146] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/SmallStageApplicationIconController 
.const [147] = Utf8 correctCarPictureIndex 
.const [148] = Utf8 I 
.const [149] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/SmallStageApplicationIconController 
.const [150] = Utf8 calculateCorrectCarPictureIndex 
.const [151] = Utf8 ()I 
.const [152] = Utf8 java/lang/Integer 
.const [153] = Utf8 <init> 
.const [154] = Utf8 (I)V 
.const [155] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/IconController 
.const [156] = Utf8 calculateModelContent 
.const [157] = Utf8 ()Ljava/lang/Object; 
.const [158] = Utf8 de/esolutions/hmi/widgets/audi/base/ScreenMainArea 
.const [159] = Utf8 setNotFocusableIcon 
.const [160] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController;)V 
.const [161] = Utf8 de/audi/tghu/hmi/evo/ICarCodingHelper 
.const [162] = Utf8 getCarType 
.const [163] = Utf8 ()I 
.const [164] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelGUI 
.const [165] = Utf8 getValue 
.const [166] = Utf8 ()I 
.const [167] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/SmallStageApplicationIconController 
.const [168] = Class [167] 
.const [169] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/IconController 
.const [170] = Class [169] 
.const [171] = Utf8 INDEX_AU334_LHD 
.const [172] = Utf8 I 
.const [173] = Utf8 INDEX_AU334_RHD 
.const [174] = Utf8 I 
.const [175] = Utf8 INDEX_AU335_LHD 
.const [176] = Utf8 I 
.const [177] = Utf8 INDEX_AU335_RHD 
.const [178] = Utf8 I 
.const [179] = Utf8 INDEX_AU724_LHD 
.const [180] = Utf8 I 
.const [181] = Utf8 INDEX_AU724_RHD 
.const [182] = Utf8 I 
.const [183] = Utf8 INDEX_AU7248_LHD 
.const [184] = Utf8 I 
.const [185] = Utf8 INDEX_AU7248_RHD 
.const [186] = Utf8 I 
.const [187] = Utf8 INDEX_AU7258_LHD 
.const [188] = Utf8 I 
.const [189] = Utf8 INDEX_AU7258_RHD 
.const [190] = Utf8 I 
.const [191] = Utf8 correctCarPictureIndex 
.const [192] = Utf8 I 
.const [193] = Utf8 Code 
.const [194] = Utf8 <init> 
.const [195] = Utf8 ()V 
.const [196] = Utf8 initializeWidget 
.const [197] = Utf8 ()V 
.const [198] = Utf8 calculateCorrectCarPictureIndex 
.const [199] = Utf8 ()I 
.const [200] = Utf8 processModelUpdateEvent 
.const [201] = Utf8 (Lde/audi/atip/hmi/event/ModelUpdateEvent;)V 
.const [202] = Utf8 calculateModelContent 
.const [203] = Utf8 ()Ljava/lang/Object; 
.const [204] = Utf8 isSmallStageApplicationIcon 
.const [205] = Utf8 ()Z 
.const [206] = Utf8 <clinit> 
.const [207] = Utf8 ()V 
.end class 
