.version 50 0 
.class public super [188] 
.super [190] 
.field private static final [191] [192] 
.field private static final [193] [194] 
.field private static final [195] [196] 
.field private static final [197] [198] 
.field private static final [199] [200] 
.field private static final [201] [202] 
.field private static final [203] [204] 
.field private [205] [206] 

.method public [208] : [209] 
    .attribute [207] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [44] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [49] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [210] : [211] 
    .attribute [207] .code stack 5 locals 0 
L0:     fload_1 
L1:     fconst_0 
L2:     fcmpg 
L3:     iflt L13 
L6:     fload_1 
L7:     ldc [2] 
L9:     fcmpl 
L10:    ifle L26 
L13:    getstatic [3] 
L16:    ldc [4] 
L18:    ldc [5] 
L20:    fload_1 
L21:    f2d 
L22:    invokevirtual [34] 
L25:    return 
L26:    aload_0 
L27:    ldc [6] 
L29:    fload_1 
L30:    invokevirtual [35] 
L33:    pop 
L34:    aload_0 
L35:    ldc [7] 
L37:    fload_1 
L38:    invokestatic [8] 
L41:    i2f 
L42:    invokevirtual [35] 
L45:    pop 
L46:    return 
L47:    nop 
L48:    
    .end code 
.end method 

.method private [212] : [213] 
    .attribute [207] .code stack 5 locals 0 
L0:     fload_3 
L1:     fconst_0 
L2:     fcmpg 
L3:     iflt L13 
L6:     fload_3 
L7:     ldc [2] 
L9:     fcmpl 
L10:    ifle L26 
L13:    getstatic [3] 
L16:    ldc [4] 
L18:    ldc [9] 
L20:    fload_3 
L21:    f2d 
L22:    invokevirtual [34] 
L25:    return 
L26:    iload_1 
L27:    iflt L35 
L30:    iload_1 
L31:    iconst_5 
L32:    if_icmplt L49 
L35:    getstatic [3] 
L38:    ldc [4] 
L40:    ldc [10] 
L42:    iload_1 
L43:    i2l 
L44:    invokevirtual [36] 
L47:    pop 
L48:    return 
L49:    aload_0 
L50:    getstatic [11] 
L53:    iload_1 
L54:    aaload 
L55:    iload_2 
L56:    ifeq L63 
L59:    fconst_1 
L60:    goto L64 
L63:    fconst_0 
L64:    invokevirtual [35] 
L67:    pop 
L68:    aload_0 
L69:    getstatic [12] 
L72:    iload_1 
L73:    aaload 
L74:    fload_3 
L75:    invokevirtual [35] 
L78:    pop 
L79:    return 
L80:    
    .end code 
.end method 

.method protected [214] : [215] 
    .attribute [207] .code stack 7 locals 1 
L0:     aload_0 
L1:     getfield [37] 
L4:     aload_0 
L5:     getfield [33] 
L8:     invokevirtual [38] 
L11:    i2f 
L12:    aload_0 
L13:    getfield [33] 
L16:    invokevirtual [39] 
L19:    i2f 
L20:    fconst_0 
L21:    invokeinterface [50] 0 
L26:    aload_0 
L27:    aload_0 
L28:    getfield [33] 
L31:    invokevirtual [40] 
L34:    invokespecial [47] 
L37:    iconst_0 
L38:    istore_2 
L39:    iload_2 
L40:    iconst_5 
L41:    if_icmpge L85 
L44:    iload_2 
L45:    aload_0 
L46:    getfield [33] 
L49:    invokevirtual [41] 
L52:    if_icmpge L72 
L55:    aload_0 
L56:    iload_2 
L57:    iconst_1 
L58:    aload_0 
L59:    getfield [33] 
L62:    iload_2 
L63:    invokevirtual [42] 
L66:    invokespecial [48] 
L69:    goto L79 
L72:    aload_0 
L73:    iload_2 
L74:    iconst_0 
L75:    fconst_0 
L76:    invokespecial [48] 
L79:    iinc 2 1 
L82:    goto L39 
L85:    aload_0 
L86:    getfield [33] 
L89:    invokevirtual [41] 
L92:    iconst_5 
L93:    if_icmple L118 
L96:    getstatic [3] 
L99:    ldc [4] 
L101:   ldc [13] 
L103:   ldc_w [1] 
L106:   aload_0 
L107:   getfield [33] 
L110:   invokevirtual [41] 
L113:   i2l 
L114:   invokevirtual [43] 
L117:   pop 
L118:   return 
L119:   nop 
L120:   
    .end code 
.end method 

.method protected [216] : [217] 
    .attribute [207] .code stack 1 locals 0 
L0:     ldc [14] 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected [218] : [219] 
    .attribute [207] .code stack 1 locals 0 
L0:     ldc [15] 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected [220] : [221] 
    .attribute [207] .code stack 1 locals 0 
L0:     bipush 21 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public interface [222] : [223] 
    .attribute [207] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [33] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static [224] : [225] 
    .attribute [207] .code stack 4 locals 0 
L0:     iconst_5 
L1:     anewarray [16] 
L4:     dup 
L5:     iconst_0 
L6:     ldc [17] 
L8:     aastore 
L9:     dup 
L10:    iconst_1 
L11:    ldc [18] 
L13:    aastore 
L14:    dup 
L15:    iconst_2 
L16:    ldc [19] 
L18:    aastore 
L19:    dup 
L20:    iconst_3 
L21:    ldc [20] 
L23:    aastore 
L24:    dup 
L25:    iconst_4 
L26:    ldc [21] 
L28:    aastore 
L29:    putstatic [45] 
L32:    iconst_5 
L33:    anewarray [16] 
L36:    dup 
L37:    iconst_0 
L38:    ldc [22] 
L40:    aastore 
L41:    dup 
L42:    iconst_1 
L43:    ldc [23] 
L45:    aastore 
L46:    dup 
L47:    iconst_2 
L48:    ldc [24] 
L50:    aastore 
L51:    dup 
L52:    iconst_3 
L53:    ldc [25] 
L55:    aastore 
L56:    dup 
L57:    iconst_4 
L58:    ldc [26] 
L60:    aastore 
L61:    putstatic [46] 
L64:    return 
L65:    nop 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 51266 
.const [3] = Field [52] [53] 
.const [4] = Int -1601830656 
.const [5] = String [54] 
.const [6] = String [55] 
.const [7] = String [56] 
.const [8] = Method [57] [58] 
.const [9] = String [59] 
.const [10] = String [60] 
.const [11] = Field [61] [62] 
.const [12] = Field [63] [64] 
.const [13] = String [65] 
.const [14] = String [66] 
.const [15] = String [67] 
.const [16] = Class [68] 
.const [17] = String [69] 
.const [18] = String [70] 
.const [19] = String [71] 
.const [20] = String [72] 
.const [21] = String [73] 
.const [22] = String [74] 
.const [23] = String [75] 
.const [24] = String [76] 
.const [25] = String [77] 
.const [26] = String [78] 
.const [27] = Class [79] 
.const [28] = Class [80] 
.const [29] = Class [81] 
.const [30] = Class [82] 
.const [31] = Class [83] 
.const [32] = Class [84] 
.const [33] = Field [85] [86] 
.const [34] = Method [87] [88] 
.const [35] = Method [89] [90] 
.const [36] = Method [91] [92] 
.const [37] = Field [93] [94] 
.const [38] = Method [95] [96] 
.const [39] = Method [97] [98] 
.const [40] = Method [99] [100] 
.const [41] = Method [101] [102] 
.const [42] = Method [103] [104] 
.const [43] = Method [105] [106] 
.const [44] = Method [107] [108] 
.const [45] = Field [109] [110] 
.const [46] = Field [111] [112] 
.const [47] = Method [113] [114] 
.const [48] = Method [115] [116] 
.const [49] = Field [117] [118] 
.const [50] = InterfaceMethod [119] [120] 
.const [51] = Int 83886080 
.const [52] = Class [121] 
.const [53] = NameAndType [122] [123] 
.const [54] = Utf8 'CircularGaugeRendererHigh#setSliverValueProperties: percentage %1 not between 0 and 100' 
.const [55] = Utf8 sg_value 
.const [56] = Utf8 sg_value_digit 
.const [57] = Class [124] 
.const [58] = NameAndType [125] [126] 
.const [59] = Utf8 'CircularGaugeRendererHigh#setPeakProperties: percentage %1 not between 0 and 100' 
.const [60] = Utf8 'CircularGaugeRendererHigh#setPeakProperties: peak %1 not between 0 and 4' 
.const [61] = Class [127] 
.const [62] = NameAndType [128] [129] 
.const [63] = Class [130] 
.const [64] = NameAndType [131] [132] 
.const [65] = Utf8 'CircularGaugeRendererHigh#applyProperties: Can only display %1 peaks out of %2' 
.const [66] = Utf8 Prefabs/sportgauge_large 
.const [67] = Utf8 sportgauge_large 
.const [68] = Utf8 java/lang/String 
.const [69] = Utf8 sg_peak1_blend 
.const [70] = Utf8 sg_peak2_blend 
.const [71] = Utf8 sg_peak3_blend 
.const [72] = Utf8 sg_peak4_blend 
.const [73] = Utf8 sg_peak5_blend 
.const [74] = Utf8 sg_peak1_value 
.const [75] = Utf8 sg_peak2_value 
.const [76] = Utf8 sg_peak3_value 
.const [77] = Utf8 sg_peak4_value 
.const [78] = Utf8 sg_peak5_value 
.const [79] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/sport/CircularGaugeRendererHigh 
.const [80] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AbstractKanziTemplateRenderer 
.const [81] = Utf8 de/audi/atip/log/LogChannel 
.const [82] = Utf8 java/lang/Math 
.const [83] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/CircularGaugeController 
.const [84] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/IWrappedNode3D 
.const [85] = Class [133] 
.const [86] = NameAndType [134] [135] 
.const [87] = Class [136] 
.const [88] = NameAndType [137] [138] 
.const [89] = Class [139] 
.const [90] = NameAndType [140] [141] 
.const [91] = Class [142] 
.const [92] = NameAndType [143] [144] 
.const [93] = Class [145] 
.const [94] = NameAndType [146] [147] 
.const [95] = Class [148] 
.const [96] = NameAndType [149] [150] 
.const [97] = Class [151] 
.const [98] = NameAndType [152] [153] 
.const [99] = Class [154] 
.const [100] = NameAndType [155] [156] 
.const [101] = Class [157] 
.const [102] = NameAndType [158] [159] 
.const [103] = Class [160] 
.const [104] = NameAndType [161] [162] 
.const [105] = Class [163] 
.const [106] = NameAndType [164] [165] 
.const [107] = Class [166] 
.const [108] = NameAndType [167] [168] 
.const [109] = Class [169] 
.const [110] = NameAndType [170] [171] 
.const [111] = Class [172] 
.const [112] = NameAndType [173] [174] 
.const [113] = Class [175] 
.const [114] = NameAndType [176] [177] 
.const [115] = Class [178] 
.const [116] = NameAndType [179] [180] 
.const [117] = Class [181] 
.const [118] = NameAndType [182] [183] 
.const [119] = Class [184] 
.const [120] = NameAndType [185] [186] 
.const [121] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/sport/CircularGaugeRendererHigh 
.const [122] = Utf8 logChannel 
.const [123] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [124] = Utf8 java/lang/Math 
.const [125] = Utf8 round 
.const [126] = Utf8 (F)I 
.const [127] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/sport/CircularGaugeRendererHigh 
.const [128] = Utf8 PEAK_BLEND_PROPERTIES 
.const [129] = Utf8 [Ljava/lang/String; 
.const [130] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/sport/CircularGaugeRendererHigh 
.const [131] = Utf8 PEAK_VALUE_PROPERTIES 
.const [132] = Utf8 [Ljava/lang/String; 
.const [133] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/sport/CircularGaugeRendererHigh 
.const [134] = Utf8 controller 
.const [135] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/sport/CircularGaugeController; 
.const [136] = Utf8 de/audi/atip/log/LogChannel 
.const [137] = Utf8 log 
.const [138] = Utf8 (ILjava/lang/String;D)V 
.const [139] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/sport/CircularGaugeRendererHigh 
.const [140] = Utf8 setProperty 
.const [141] = Utf8 (Ljava/lang/String;F)Z 
.const [142] = Utf8 de/audi/atip/log/LogChannel 
.const [143] = Utf8 log 
.const [144] = Utf8 (ILjava/lang/String;J)Z 
.const [145] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/sport/CircularGaugeRendererHigh 
.const [146] = Utf8 node 
.const [147] = Utf8 Lde/esolutions/hmi/widgets/audi/base/eal/IWrappedNode3D; 
.const [148] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/CircularGaugeController 
.const [149] = Utf8 getX 
.const [150] = Utf8 ()I 
.const [151] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/CircularGaugeController 
.const [152] = Utf8 getY 
.const [153] = Utf8 ()I 
.const [154] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/CircularGaugeController 
.const [155] = Utf8 getSliderPercentageValue 
.const [156] = Utf8 ()F 
.const [157] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/CircularGaugeController 
.const [158] = Utf8 getPeakCount 
.const [159] = Utf8 ()I 
.const [160] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/CircularGaugeController 
.const [161] = Utf8 getPeakPercentageValue 
.const [162] = Utf8 (I)F 
.const [163] = Utf8 de/audi/atip/log/LogChannel 
.const [164] = Utf8 log 
.const [165] = Utf8 (ILjava/lang/String;JJ)Z 
.const [166] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AbstractKanziTemplateRenderer 
.const [167] = Utf8 <init> 
.const [168] = Utf8 ()V 
.const [169] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/sport/CircularGaugeRendererHigh 
.const [170] = Utf8 PEAK_BLEND_PROPERTIES 
.const [171] = Utf8 [Ljava/lang/String; 
.const [172] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/sport/CircularGaugeRendererHigh 
.const [173] = Utf8 PEAK_VALUE_PROPERTIES 
.const [174] = Utf8 [Ljava/lang/String; 
.const [175] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/sport/CircularGaugeRendererHigh 
.const [176] = Utf8 setSliderValueProperties 
.const [177] = Utf8 (F)V 
.const [178] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/sport/CircularGaugeRendererHigh 
.const [179] = Utf8 setPeakProperties 
.const [180] = Utf8 (IZF)V 
.const [181] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/sport/CircularGaugeRendererHigh 
.const [182] = Utf8 controller 
.const [183] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/sport/CircularGaugeController; 
.const [184] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/IWrappedNode3D 
.const [185] = Utf8 setPosition 
.const [186] = Utf8 (FFF)V 
.const [187] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/sport/CircularGaugeRendererHigh 
.const [188] = Class [187] 
.const [189] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AbstractKanziTemplateRenderer 
.const [190] = Class [189] 
.const [191] = Utf8 TEMPLATE_NODE_PATH 
.const [192] = Utf8 Ljava/lang/String; 
.const [193] = Utf8 EAL_NODE_NAME 
.const [194] = Utf8 Ljava/lang/String; 
.const [195] = Utf8 MAX_PEAKS 
.const [196] = Utf8 I 
.const [197] = Utf8 SLIDER_POSITION_PROPERTY 
.const [198] = Utf8 Ljava/lang/String; 
.const [199] = Utf8 PERCENTAGE_DIGITS_PROPERTY 
.const [200] = Utf8 Ljava/lang/String; 
.const [201] = Utf8 PEAK_BLEND_PROPERTIES 
.const [202] = Utf8 [Ljava/lang/String; 
.const [203] = Utf8 PEAK_VALUE_PROPERTIES 
.const [204] = Utf8 [Ljava/lang/String; 
.const [205] = Utf8 controller 
.const [206] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/sport/CircularGaugeController; 
.const [207] = Utf8 Code 
.const [208] = Utf8 <init> 
.const [209] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/sport/CircularGaugeController;)V 
.const [210] = Utf8 setSliderValueProperties 
.const [211] = Utf8 (F)V 
.const [212] = Utf8 setPeakProperties 
.const [213] = Utf8 (IZF)V 
.const [214] = Utf8 applyProperties 
.const [215] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/high/RedrawContextHigh;)V 
.const [216] = Utf8 getTemplateNodePath 
.const [217] = Utf8 ()Ljava/lang/String; 
.const [218] = Utf8 getEALNodeName 
.const [219] = Utf8 ()Ljava/lang/String; 
.const [220] = Utf8 getKzbConstant 
.const [221] = Utf8 ()I 
.const [222] = Utf8 getAbstractController 
.const [223] = Utf8 ()Lde/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController; 
.const [224] = Utf8 <clinit> 
.const [225] = Utf8 ()V 
.end class 
