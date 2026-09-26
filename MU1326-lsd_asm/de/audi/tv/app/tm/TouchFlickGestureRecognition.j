.version 50 0 
.class public super [194] 
.super [196] 
.field public static final [197] [198] 
.field public static final [199] [200] 
.field public [201] [202] 
.field private [203] [204] 
.field private [205] [206] 
.field private [207] [208] 
.field private [209] [210] 
.field private [211] [212] 
.field private [213] [214] 
.field private [215] [216] 

.method public [218] : [219] 
    .attribute [217] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     new [23] 
L5:     dup 
L6:     aconst_null 
L7:     invokespecial [19] 
L10:    invokespecial [20] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method [220] : [221] 
    .attribute [217] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [21] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [24] 
L9:     aload_0 
L10:    lconst_0 
L11:    putfield [25] 
L14:    aload_0 
L15:    aload_1 
L16:    putfield [26] 
L19:    aload_0 
L20:    aload_2 
L21:    putfield [27] 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [222] : [223] 
    .attribute [217] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [14] 
L5:     invokeinterface [28] 0 
L10:    putfield [25] 
L13:    aload_0 
L14:    iconst_0 
L15:    putfield [29] 
L18:    aload_0 
L19:    iconst_0 
L20:    putfield [30] 
L23:    aload_0 
L24:    iconst_0 
L25:    putfield [31] 
L28:    aload_0 
L29:    iconst_0 
L30:    putfield [32] 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [224] : [225] 
    .attribute [217] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     ifeq L28 
L7:     aload_0 
L8:     getfield [14] 
L11:    invokeinterface [28] 0 
L16:    aload_0 
L17:    getfield [12] 
L20:    lsub 
L21:    ldc_w [1] 
L24:    lcmp 
L25:    ifle L56 
L28:    aload_0 
L29:    aload_0 
L30:    getfield [14] 
L33:    invokeinterface [28] 0 
L38:    putfield [25] 
L41:    aload_0 
L42:    iconst_1 
L43:    putfield [24] 
L46:    aload_0 
L47:    iload_1 
L48:    putfield [29] 
L51:    aload_0 
L52:    iload_2 
L53:    putfield [31] 
L56:    aload_0 
L57:    iload_3 
L58:    putfield [30] 
L61:    aload_0 
L62:    iload 4 
L64:    putfield [32] 
L67:    return 
L68:    
    .end code 
.end method 

.method public [226] : [227] 
    .attribute [217] .code stack 5 locals 5 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [24] 
L5:     aload_0 
L6:     getfield [14] 
L9:     invokeinterface [28] 0 
L14:    aload_0 
L15:    getfield [12] 
L18:    lsub 
L19:    lstore_1 
L20:    aload_0 
L21:    aload_0 
L22:    getfield [15] 
L25:    aload_0 
L26:    getfield [17] 
L29:    aload_0 
L30:    getfield [16] 
L33:    aload_0 
L34:    getfield [18] 
L37:    invokespecial [22] 
L40:    istore_3 
L41:    aload_0 
L42:    getfield [16] 
L45:    aload_0 
L46:    getfield [15] 
L49:    isub 
L50:    istore 4 
L52:    aload_0 
L53:    getfield [18] 
L56:    aload_0 
L57:    getfield [17] 
L60:    isub 
L61:    istore 5 
L63:    lload_1 
L64:    ldc_w [1] 
L67:    lcmp 
L68:    ifge L148 
L71:    iload_3 
L72:    bipush 80 
L74:    if_icmple L148 
L77:    iload 4 
L79:    invokestatic [3] 
L82:    iload 5 
L84:    invokestatic [3] 
L87:    if_icmple L119 
L90:    iload 4 
L92:    ifle L107 
L95:    aload_0 
L96:    getfield [13] 
L99:    invokeinterface [33] 0 
L104:   goto L157 
L107:   aload_0 
L108:   getfield [13] 
L111:   invokeinterface [34] 0 
L116:   goto L157 
L119:   iload 5 
L121:   ifle L136 
L124:   aload_0 
L125:   getfield [13] 
L128:   invokeinterface [35] 0 
L133:   goto L157 
L136:   aload_0 
L137:   getfield [13] 
L140:   invokeinterface [36] 0 
L145:   goto L157 
L148:   aload_0 
L149:   getfield [13] 
L152:   invokeinterface [37] 0 
L157:   return 
L158:   nop 
L159:   nop 
L160:   
    .end code 
.end method 

.method private [228] : [229] 
    .attribute [217] .code stack 6 locals 0 
L0:     iload_1 
L1:     iload_3 
L2:     isub 
L3:     i2d 
L4:     ldc2_w [39] 
L7:     invokestatic [4] 
L10:    iload_2 
L11:    iload 4 
L13:    isub 
L14:    i2d 
L15:    ldc2_w [39] 
L18:    invokestatic [4] 
L21:    dadd 
L22:    invokestatic [5] 
L25:    d2i 
L26:    areturn 
L27:    nop 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [41] 
.const [3] = Method [42] [43] 
.const [4] = Method [44] [45] 
.const [5] = Method [46] [47] 
.const [6] = Class [48] 
.const [7] = Class [49] 
.const [8] = Class [50] 
.const [9] = Class [51] 
.const [10] = Class [52] 
.const [11] = Field [53] [54] 
.const [12] = Field [55] [56] 
.const [13] = Field [57] [58] 
.const [14] = Field [59] [60] 
.const [15] = Field [61] [62] 
.const [16] = Field [63] [64] 
.const [17] = Field [65] [66] 
.const [18] = Field [67] [68] 
.const [19] = Method [69] [70] 
.const [20] = Method [71] [72] 
.const [21] = Method [73] [74] 
.const [22] = Method [75] [76] 
.const [23] = Class [77] 
.const [24] = Field [78] [79] 
.const [25] = Field [80] [81] 
.const [26] = Field [82] [83] 
.const [27] = Field [84] [85] 
.const [28] = InterfaceMethod [86] [87] 
.const [29] = Field [88] [89] 
.const [30] = Field [90] [91] 
.const [31] = Field [92] [93] 
.const [32] = Field [94] [95] 
.const [33] = InterfaceMethod [96] [97] 
.const [34] = InterfaceMethod [98] [99] 
.const [35] = InterfaceMethod [100] [101] 
.const [36] = InterfaceMethod [102] [103] 
.const [37] = InterfaceMethod [104] [105] 
.const [38] = Int -100663296 
.const [39] = Double +0x10000000000000p-51 
.const [41] = Utf8 de/audi/tv/app/tm/TouchFlickGestureRecognition$RealClock 
.const [42] = Class [106] 
.const [43] = NameAndType [107] [108] 
.const [44] = Class [109] 
.const [45] = NameAndType [110] [111] 
.const [46] = Class [112] 
.const [47] = NameAndType [113] [114] 
.const [48] = Utf8 de/audi/tv/app/tm/TouchFlickGestureRecognition 
.const [49] = Utf8 java/lang/Object 
.const [50] = Utf8 de/audi/tv/app/tm/TouchFlickGestureRecognition$Clock 
.const [51] = Utf8 java/lang/Math 
.const [52] = Utf8 de/audi/tv/app/tm/ITouchFlickGestureRecognitionListener 
.const [53] = Class [115] 
.const [54] = NameAndType [116] [117] 
.const [55] = Class [118] 
.const [56] = NameAndType [119] [120] 
.const [57] = Class [121] 
.const [58] = NameAndType [122] [123] 
.const [59] = Class [124] 
.const [60] = NameAndType [125] [126] 
.const [61] = Class [127] 
.const [62] = NameAndType [128] [129] 
.const [63] = Class [130] 
.const [64] = NameAndType [131] [132] 
.const [65] = Class [133] 
.const [66] = NameAndType [134] [135] 
.const [67] = Class [136] 
.const [68] = NameAndType [137] [138] 
.const [69] = Class [139] 
.const [70] = NameAndType [140] [141] 
.const [71] = Class [142] 
.const [72] = NameAndType [143] [144] 
.const [73] = Class [145] 
.const [74] = NameAndType [146] [147] 
.const [75] = Class [148] 
.const [76] = NameAndType [149] [150] 
.const [77] = Utf8 de/audi/tv/app/tm/TouchFlickGestureRecognition$RealClock 
.const [78] = Class [151] 
.const [79] = NameAndType [152] [153] 
.const [80] = Class [154] 
.const [81] = NameAndType [155] [156] 
.const [82] = Class [157] 
.const [83] = NameAndType [158] [159] 
.const [84] = Class [160] 
.const [85] = NameAndType [161] [162] 
.const [86] = Class [163] 
.const [87] = NameAndType [164] [165] 
.const [88] = Class [166] 
.const [89] = NameAndType [167] [168] 
.const [90] = Class [169] 
.const [91] = NameAndType [170] [171] 
.const [92] = Class [172] 
.const [93] = NameAndType [173] [174] 
.const [94] = Class [175] 
.const [95] = NameAndType [176] [177] 
.const [96] = Class [178] 
.const [97] = NameAndType [179] [180] 
.const [98] = Class [181] 
.const [99] = NameAndType [182] [183] 
.const [100] = Class [184] 
.const [101] = NameAndType [185] [186] 
.const [102] = Class [187] 
.const [103] = NameAndType [188] [189] 
.const [104] = Class [190] 
.const [105] = NameAndType [191] [192] 
.const [106] = Utf8 java/lang/Math 
.const [107] = Utf8 abs 
.const [108] = Utf8 (I)I 
.const [109] = Utf8 java/lang/Math 
.const [110] = Utf8 pow 
.const [111] = Utf8 (DD)D 
.const [112] = Utf8 java/lang/Math 
.const [113] = Utf8 sqrt 
.const [114] = Utf8 (D)D 
.const [115] = Utf8 de/audi/tv/app/tm/TouchFlickGestureRecognition 
.const [116] = Utf8 moving 
.const [117] = Utf8 Z 
.const [118] = Utf8 de/audi/tv/app/tm/TouchFlickGestureRecognition 
.const [119] = Utf8 startTime 
.const [120] = Utf8 J 
.const [121] = Utf8 de/audi/tv/app/tm/TouchFlickGestureRecognition 
.const [122] = Utf8 listener 
.const [123] = Utf8 Lde/audi/tv/app/tm/ITouchFlickGestureRecognitionListener; 
.const [124] = Utf8 de/audi/tv/app/tm/TouchFlickGestureRecognition 
.const [125] = Utf8 clock 
.const [126] = Utf8 Lde/audi/tv/app/tm/TouchFlickGestureRecognition$Clock; 
.const [127] = Utf8 de/audi/tv/app/tm/TouchFlickGestureRecognition 
.const [128] = Utf8 startX 
.const [129] = Utf8 I 
.const [130] = Utf8 de/audi/tv/app/tm/TouchFlickGestureRecognition 
.const [131] = Utf8 currX 
.const [132] = Utf8 I 
.const [133] = Utf8 de/audi/tv/app/tm/TouchFlickGestureRecognition 
.const [134] = Utf8 startY 
.const [135] = Utf8 I 
.const [136] = Utf8 de/audi/tv/app/tm/TouchFlickGestureRecognition 
.const [137] = Utf8 currY 
.const [138] = Utf8 I 
.const [139] = Utf8 de/audi/tv/app/tm/TouchFlickGestureRecognition$RealClock 
.const [140] = Utf8 <init> 
.const [141] = Utf8 (Lde/audi/tv/app/tm/TouchFlickGestureRecognition$1;)V 
.const [142] = Utf8 de/audi/tv/app/tm/TouchFlickGestureRecognition 
.const [143] = Utf8 <init> 
.const [144] = Utf8 (Lde/audi/tv/app/tm/ITouchFlickGestureRecognitionListener;Lde/audi/tv/app/tm/TouchFlickGestureRecognition$Clock;)V 
.const [145] = Utf8 java/lang/Object 
.const [146] = Utf8 <init> 
.const [147] = Utf8 ()V 
.const [148] = Utf8 de/audi/tv/app/tm/TouchFlickGestureRecognition 
.const [149] = Utf8 euclideanDistance 
.const [150] = Utf8 (IIII)I 
.const [151] = Utf8 de/audi/tv/app/tm/TouchFlickGestureRecognition 
.const [152] = Utf8 moving 
.const [153] = Utf8 Z 
.const [154] = Utf8 de/audi/tv/app/tm/TouchFlickGestureRecognition 
.const [155] = Utf8 startTime 
.const [156] = Utf8 J 
.const [157] = Utf8 de/audi/tv/app/tm/TouchFlickGestureRecognition 
.const [158] = Utf8 listener 
.const [159] = Utf8 Lde/audi/tv/app/tm/ITouchFlickGestureRecognitionListener; 
.const [160] = Utf8 de/audi/tv/app/tm/TouchFlickGestureRecognition 
.const [161] = Utf8 clock 
.const [162] = Utf8 Lde/audi/tv/app/tm/TouchFlickGestureRecognition$Clock; 
.const [163] = Utf8 de/audi/tv/app/tm/TouchFlickGestureRecognition$Clock 
.const [164] = Utf8 getTime 
.const [165] = Utf8 ()J 
.const [166] = Utf8 de/audi/tv/app/tm/TouchFlickGestureRecognition 
.const [167] = Utf8 startX 
.const [168] = Utf8 I 
.const [169] = Utf8 de/audi/tv/app/tm/TouchFlickGestureRecognition 
.const [170] = Utf8 currX 
.const [171] = Utf8 I 
.const [172] = Utf8 de/audi/tv/app/tm/TouchFlickGestureRecognition 
.const [173] = Utf8 startY 
.const [174] = Utf8 I 
.const [175] = Utf8 de/audi/tv/app/tm/TouchFlickGestureRecognition 
.const [176] = Utf8 currY 
.const [177] = Utf8 I 
.const [178] = Utf8 de/audi/tv/app/tm/ITouchFlickGestureRecognitionListener 
.const [179] = Utf8 flickRight 
.const [180] = Utf8 ()V 
.const [181] = Utf8 de/audi/tv/app/tm/ITouchFlickGestureRecognitionListener 
.const [182] = Utf8 flickLeft 
.const [183] = Utf8 ()V 
.const [184] = Utf8 de/audi/tv/app/tm/ITouchFlickGestureRecognitionListener 
.const [185] = Utf8 flickDown 
.const [186] = Utf8 ()V 
.const [187] = Utf8 de/audi/tv/app/tm/ITouchFlickGestureRecognitionListener 
.const [188] = Utf8 flickUp 
.const [189] = Utf8 ()V 
.const [190] = Utf8 de/audi/tv/app/tm/ITouchFlickGestureRecognitionListener 
.const [191] = Utf8 tap 
.const [192] = Utf8 ()V 
.const [193] = Utf8 de/audi/tv/app/tm/TouchFlickGestureRecognition 
.const [194] = Class [193] 
.const [195] = Utf8 java/lang/Object 
.const [196] = Class [195] 
.const [197] = Utf8 THRESHOLD_DISTANCE 
.const [198] = Utf8 I 
.const [199] = Utf8 THRESHOLD_TIME 
.const [200] = Utf8 I 
.const [201] = Utf8 clock 
.const [202] = Utf8 Lde/audi/tv/app/tm/TouchFlickGestureRecognition$Clock; 
.const [203] = Utf8 listener 
.const [204] = Utf8 Lde/audi/tv/app/tm/ITouchFlickGestureRecognitionListener; 
.const [205] = Utf8 moving 
.const [206] = Utf8 Z 
.const [207] = Utf8 startTime 
.const [208] = Utf8 J 
.const [209] = Utf8 startX 
.const [210] = Utf8 I 
.const [211] = Utf8 startY 
.const [212] = Utf8 I 
.const [213] = Utf8 currX 
.const [214] = Utf8 I 
.const [215] = Utf8 currY 
.const [216] = Utf8 I 
.const [217] = Utf8 Code 
.const [218] = Utf8 <init> 
.const [219] = Utf8 (Lde/audi/tv/app/tm/ITouchFlickGestureRecognitionListener;)V 
.const [220] = Utf8 <init> 
.const [221] = Utf8 (Lde/audi/tv/app/tm/ITouchFlickGestureRecognitionListener;Lde/audi/tv/app/tm/TouchFlickGestureRecognition$Clock;)V 
.const [222] = Utf8 startMove 
.const [223] = Utf8 ()V 
.const [224] = Utf8 move 
.const [225] = Utf8 (IIII)V 
.const [226] = Utf8 stopMove 
.const [227] = Utf8 ()V 
.const [228] = Utf8 euclideanDistance 
.const [229] = Utf8 (IIII)I 
.end class 
