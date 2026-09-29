.version 50 0 
.class public super [140] 
.super [142] 
.field private static final [143] [144] 
.field private static final [145] [146] 
.field private static final [147] [148] 
.field private static final [149] [150] 
.field private static final [151] [152] 
.field private static final [153] [154] 
.field private static final [155] [156] 
.field private static final [157] [158] 
.field private static final [159] [160] 
.field private static final [161] [162] 
.field private [163] [164] 

.method public [166] : [167] 
    .attribute [165] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [32] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [35] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [168] : [169] 
    .attribute [165] .code stack 3 locals 0 
L0:     aload_0 
L1:     ldc [2] 
L3:     fload_1 
L4:     invokevirtual [24] 
L7:     pop 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [170] : [171] 
    .attribute [165] .code stack 3 locals 0 
L0:     aload_0 
L1:     ldc [3] 
L3:     fload_1 
L4:     invokevirtual [24] 
L7:     pop 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private static [172] : [173] 
    .attribute [165] .code stack 3 locals 0 
L0:     fload_2 
L1:     fload_0 
L2:     fsub 
L3:     fload_1 
L4:     fload_0 
L5:     fsub 
L6:     fdiv 
L7:     areturn 
L8:     
    .end code 
.end method 

.method protected [174] : [175] 
    .attribute [165] .code stack 9 locals 4 
L0:     aload_0 
L1:     getfield [25] 
L4:     aload_0 
L5:     getfield [23] 
L8:     invokevirtual [26] 
L11:    i2f 
L12:    aload_0 
L13:    getfield [23] 
L16:    invokevirtual [27] 
L19:    i2f 
L20:    fconst_0 
L21:    invokeinterface [36] 0 
L26:    aload_0 
L27:    getfield [23] 
L30:    invokevirtual [28] 
L33:    lookupswitch 
            1 : L72 
            2 : L60 
            default : L84 

L60:    fconst_0 
L61:    fstore_2 
L62:    ldc [4] 
L64:    fstore_3 
L65:    ldc [5] 
L67:    fstore 4 
L69:    goto L104 
L72:    fconst_1 
L73:    fstore_2 
L74:    ldc [6] 
L76:    fstore_3 
L77:    ldc [7] 
L79:    fstore 4 
L81:    goto L104 
L84:    getstatic [8] 
L87:    ldc [9] 
L89:    ldc [10] 
L91:    aload_0 
L92:    getfield [23] 
L95:    invokevirtual [28] 
L98:    i2l 
L99:    invokevirtual [29] 
L102:   pop 
L103:   return 
L104:   aload_0 
L105:   fload_2 
L106:   invokespecial [33] 
L109:   aload_0 
L110:   getfield [23] 
L113:   invokevirtual [30] 
L116:   fstore 5 
L118:   fload 5 
L120:   fload_3 
L121:   fcmpg 
L122:   iflt L133 
L125:   fload 5 
L127:   fload 4 
L129:   fcmpl 
L130:   ifle L164 
L133:   getstatic [8] 
L136:   ldc [9] 
L138:   ldc [11] 
L140:   fload 5 
L142:   f2d 
L143:   fload_3 
L144:   f2d 
L145:   fload 4 
L147:   f2d 
L148:   invokevirtual [31] 
L151:   fload 5 
L153:   fload_3 
L154:   invokestatic [12] 
L157:   fload 4 
L159:   invokestatic [13] 
L162:   fstore 5 
L164:   aload_0 
L165:   fload_3 
L166:   fload 4 
L168:   fload 5 
L170:   invokestatic [14] 
L173:   invokespecial [34] 
L176:   return 
L177:   nop 
L178:   nop 
L179:   nop 
L180:   
    .end code 
.end method 

.method protected [176] : [177] 
    .attribute [165] .code stack 1 locals 0 
L0:     ldc [15] 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected [178] : [179] 
    .attribute [165] .code stack 1 locals 0 
L0:     ldc [16] 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected [180] : [181] 
    .attribute [165] .code stack 1 locals 0 
L0:     bipush 21 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public interface [182] : [183] 
    .attribute [165] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [37] 
.const [3] = String [38] 
.const [4] = Int 58946 
.const [5] = Int 8428867 
.const [6] = Int 13378 
.const [7] = Int 9539 
.const [8] = Field [39] [40] 
.const [9] = Int -1601830656 
.const [10] = String [41] 
.const [11] = String [42] 
.const [12] = Method [43] [44] 
.const [13] = Method [45] [46] 
.const [14] = Method [47] [48] 
.const [15] = String [49] 
.const [16] = String [50] 
.const [17] = Class [51] 
.const [18] = Class [52] 
.const [19] = Class [53] 
.const [20] = Class [54] 
.const [21] = Class [55] 
.const [22] = Class [56] 
.const [23] = Field [57] [58] 
.const [24] = Method [59] [60] 
.const [25] = Field [61] [62] 
.const [26] = Method [63] [64] 
.const [27] = Method [65] [66] 
.const [28] = Method [67] [68] 
.const [29] = Method [69] [70] 
.const [30] = Method [71] [72] 
.const [31] = Method [73] [74] 
.const [32] = Method [75] [76] 
.const [33] = Method [77] [78] 
.const [34] = Method [79] [80] 
.const [35] = Field [81] [82] 
.const [36] = InterfaceMethod [83] [84] 
.const [37] = Utf8 tg_barLength 
.const [38] = Utf8 eg_bc_degreeUnit 
.const [39] = Class [85] 
.const [40] = NameAndType [86] [87] 
.const [41] = Utf8 'OilTemperatureGaugeRendererHigh#applyProperties: unknown temperature unit: %1' 
.const [42] = Utf8 'OilTemperatureGaugeRendererHigh#applyProperties: Oil temperature of %1 degrees out of displayable range between %2 and %3' 
.const [43] = Class [88] 
.const [44] = NameAndType [89] [90] 
.const [45] = Class [91] 
.const [46] = NameAndType [92] [93] 
.const [47] = Class [94] 
.const [48] = NameAndType [95] [96] 
.const [49] = Utf8 Prefabs/tg_temp 
.const [50] = Utf8 tg_temp 
.const [51] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/sport/OilTemperatureGaugeRendererHigh 
.const [52] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AbstractKanziTemplateRenderer 
.const [53] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/OilTemperatureGaugeController 
.const [54] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/IWrappedNode3D 
.const [55] = Utf8 de/audi/atip/log/LogChannel 
.const [56] = Utf8 java/lang/Math 
.const [57] = Class [97] 
.const [58] = NameAndType [98] [99] 
.const [59] = Class [100] 
.const [60] = NameAndType [101] [102] 
.const [61] = Class [103] 
.const [62] = NameAndType [104] [105] 
.const [63] = Class [106] 
.const [64] = NameAndType [107] [108] 
.const [65] = Class [109] 
.const [66] = NameAndType [110] [111] 
.const [67] = Class [112] 
.const [68] = NameAndType [113] [114] 
.const [69] = Class [115] 
.const [70] = NameAndType [116] [117] 
.const [71] = Class [118] 
.const [72] = NameAndType [119] [120] 
.const [73] = Class [121] 
.const [74] = NameAndType [122] [123] 
.const [75] = Class [124] 
.const [76] = NameAndType [125] [126] 
.const [77] = Class [127] 
.const [78] = NameAndType [128] [129] 
.const [79] = Class [130] 
.const [80] = NameAndType [131] [132] 
.const [81] = Class [133] 
.const [82] = NameAndType [134] [135] 
.const [83] = Class [136] 
.const [84] = NameAndType [137] [138] 
.const [85] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/sport/OilTemperatureGaugeRendererHigh 
.const [86] = Utf8 logChannel 
.const [87] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [88] = Utf8 java/lang/Math 
.const [89] = Utf8 max 
.const [90] = Utf8 (FF)F 
.const [91] = Utf8 java/lang/Math 
.const [92] = Utf8 min 
.const [93] = Utf8 (FF)F 
.const [94] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/sport/OilTemperatureGaugeRendererHigh 
.const [95] = Utf8 computeBarLength 
.const [96] = Utf8 (FFF)F 
.const [97] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/sport/OilTemperatureGaugeRendererHigh 
.const [98] = Utf8 controller 
.const [99] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/sport/OilTemperatureGaugeController; 
.const [100] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/sport/OilTemperatureGaugeRendererHigh 
.const [101] = Utf8 setProperty 
.const [102] = Utf8 (Ljava/lang/String;F)Z 
.const [103] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/sport/OilTemperatureGaugeRendererHigh 
.const [104] = Utf8 node 
.const [105] = Utf8 Lde/esolutions/hmi/widgets/audi/base/eal/IWrappedNode3D; 
.const [106] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/OilTemperatureGaugeController 
.const [107] = Utf8 getX 
.const [108] = Utf8 ()I 
.const [109] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/OilTemperatureGaugeController 
.const [110] = Utf8 getY 
.const [111] = Utf8 ()I 
.const [112] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/OilTemperatureGaugeController 
.const [113] = Utf8 getTemperatureUnit 
.const [114] = Utf8 ()I 
.const [115] = Utf8 de/audi/atip/log/LogChannel 
.const [116] = Utf8 log 
.const [117] = Utf8 (ILjava/lang/String;J)Z 
.const [118] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/OilTemperatureGaugeController 
.const [119] = Utf8 getTemperature 
.const [120] = Utf8 ()F 
.const [121] = Utf8 de/audi/atip/log/LogChannel 
.const [122] = Utf8 log 
.const [123] = Utf8 (ILjava/lang/String;DDD)V 
.const [124] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AbstractKanziTemplateRenderer 
.const [125] = Utf8 <init> 
.const [126] = Utf8 ()V 
.const [127] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/sport/OilTemperatureGaugeRendererHigh 
.const [128] = Utf8 setTemperatureUnitProperty 
.const [129] = Utf8 (F)V 
.const [130] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/sport/OilTemperatureGaugeRendererHigh 
.const [131] = Utf8 setBarLengthProperty 
.const [132] = Utf8 (F)V 
.const [133] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/sport/OilTemperatureGaugeRendererHigh 
.const [134] = Utf8 controller 
.const [135] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/sport/OilTemperatureGaugeController; 
.const [136] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/IWrappedNode3D 
.const [137] = Utf8 setPosition 
.const [138] = Utf8 (FFF)V 
.const [139] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/sport/OilTemperatureGaugeRendererHigh 
.const [140] = Class [139] 
.const [141] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AbstractKanziTemplateRenderer 
.const [142] = Class [141] 
.const [143] = Utf8 TEMPLATE_NODE_PATH 
.const [144] = Utf8 Ljava/lang/String; 
.const [145] = Utf8 EAL_NODE_NAME 
.const [146] = Utf8 Ljava/lang/String; 
.const [147] = Utf8 KZB_FAHRENHEIT_UNIT 
.const [148] = Utf8 F 
.const [149] = Utf8 FAHRENHEIT_MIN_TEMPERATURE 
.const [150] = Utf8 F 
.const [151] = Utf8 FAHRENHEIT_MAX_TEMPERATURE 
.const [152] = Utf8 F 
.const [153] = Utf8 KZB_CELSIUS_UNIT 
.const [154] = Utf8 F 
.const [155] = Utf8 CELSIUS_MIN_TEMPERATURE 
.const [156] = Utf8 F 
.const [157] = Utf8 CELSIUS_MAX_TEMPERATURE 
.const [158] = Utf8 F 
.const [159] = Utf8 TEMPERATURE_UNIT_PROPERTY 
.const [160] = Utf8 Ljava/lang/String; 
.const [161] = Utf8 BAR_LENGTH_PROPERTY 
.const [162] = Utf8 Ljava/lang/String; 
.const [163] = Utf8 controller 
.const [164] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/sport/OilTemperatureGaugeController; 
.const [165] = Utf8 Code 
.const [166] = Utf8 <init> 
.const [167] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/sport/OilTemperatureGaugeController;)V 
.const [168] = Utf8 setBarLengthProperty 
.const [169] = Utf8 (F)V 
.const [170] = Utf8 setTemperatureUnitProperty 
.const [171] = Utf8 (F)V 
.const [172] = Utf8 computeBarLength 
.const [173] = Utf8 (FFF)F 
.const [174] = Utf8 applyProperties 
.const [175] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/high/RedrawContextHigh;)V 
.const [176] = Utf8 getTemplateNodePath 
.const [177] = Utf8 ()Ljava/lang/String; 
.const [178] = Utf8 getEALNodeName 
.const [179] = Utf8 ()Ljava/lang/String; 
.const [180] = Utf8 getKzbConstant 
.const [181] = Utf8 ()I 
.const [182] = Utf8 getAbstractController 
.const [183] = Utf8 ()Lde/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController; 
.end class 
