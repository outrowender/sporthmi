.version 50 0 
.class public super [164] 
.super [166] 
.field public final [167] [168] 
.field private final [169] [170] 
.field private final [171] [172] 
.field private final [173] [174] 
.field private volatile [175] [176] 

.method public [178] : [179] 
    .attribute [177] .code stack 5 locals 0 
L0:     aload_0 
L1:     invokespecial [24] 
L4:     aload_0 
L5:     new [27] 
L8:     dup 
L9:     aload_0 
L10:    aconst_null 
L11:    invokespecial [25] 
L14:    putfield [28] 
L17:    aload_0 
L18:    new [29] 
L21:    dup 
L22:    invokespecial [24] 
L25:    putfield [30] 
L28:    aload_0 
L29:    new [31] 
L32:    dup 
L33:    iconst_2 
L34:    invokespecial [26] 
L37:    putfield [32] 
L40:    aload_0 
L41:    aload_1 
L42:    putfield [33] 
L45:    return 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [180] : [181] 
    .attribute [177] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [13] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L18 using L21 
L7:     aload_0 
L8:     getfield [14] 
L11:    aload_1 
L12:    invokevirtual [16] 
L15:    pop 
L16:    aload_2 
L17:    monitorexit 
L18:    goto L26 
        .catch [0] from L21 to L24 using L21 
L21:    astore_3 
L22:    aload_2 
L23:    monitorexit 
L24:    aload_3 
L25:    athrow 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method public interface [182] : [183] 
    .attribute [177] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     freturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [184] : [185] 
    .attribute [177] .code stack 5 locals 5 
L0:     aload_0 
L1:     getfield [15] 
L4:     ldc [5] 
L6:     ldc [6] 
L8:     aload_1 
L9:     getfield [18] 
L12:    f2d 
L13:    invokevirtual [19] 
L16:    aload_0 
L17:    getfield [15] 
L20:    ldc [5] 
L22:    ldc [7] 
L24:    aload_1 
L25:    getfield [20] 
L28:    invokevirtual [21] 
L31:    pop 
L32:    aload_1 
L33:    getfield [18] 
L36:    aload_1 
L37:    getfield [20] 
L40:    ifeq L47 
L43:    iconst_1 
L44:    goto L48 
L47:    iconst_0 
L48:    i2f 
L49:    fadd 
L50:    f2l 
L51:    ldc_w [1] 
L54:    lmul 
L55:    ldc_w [1] 
L58:    lmul 
L59:    lstore_2 
L60:    aload_0 
L61:    lload_2 
L62:    putfield [34] 
L65:    aload_0 
L66:    getfield [13] 
L69:    dup 
L70:    astore 4 
L72:    monitorenter 
        .catch [0] from L73 to L114 using L117 
L73:    aload_0 
L74:    getfield [14] 
L77:    invokevirtual [22] 
L80:    astore 5 
L82:    aload 5 
L84:    invokeinterface [35] 0 
L89:    ifeq L111 
L92:    aload 5 
L94:    invokeinterface [36] 0 
L99:    checkcast [8] 
L102:   lload_2 
L103:   invokeinterface [37] 0 
L108:   goto L82 
L111:   aload 4 
L113:   monitorexit 
L114:   goto L125 
        .catch [0] from L117 to L122 using L117 
L117:   astore 6 
L119:   aload 4 
L121:   monitorexit 
L122:   aload 6 
L124:   athrow 
L125:   return 
L126:   nop 
L127:   nop 
L128:   
    .end code 
.end method 

.method static synthetic [186] : [187] 
    .attribute [177] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [23] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [40] 
.const [3] = Class [41] 
.const [4] = Class [42] 
.const [5] = Int -2137614336 
.const [6] = String [43] 
.const [7] = String [44] 
.const [8] = Class [45] 
.const [9] = Class [46] 
.const [10] = Class [47] 
.const [11] = Class [48] 
.const [12] = Class [49] 
.const [13] = Field [50] [51] 
.const [14] = Field [52] [53] 
.const [15] = Field [54] [55] 
.const [16] = Method [56] [57] 
.const [17] = Field [58] [59] 
.const [18] = Field [60] [61] 
.const [19] = Method [62] [63] 
.const [20] = Field [64] [65] 
.const [21] = Method [66] [67] 
.const [22] = Method [68] [69] 
.const [23] = Method [70] [71] 
.const [24] = Method [72] [73] 
.const [25] = Method [74] [75] 
.const [26] = Method [76] [77] 
.const [27] = Class [78] 
.const [28] = Field [79] [80] 
.const [29] = Class [81] 
.const [30] = Field [82] [83] 
.const [31] = Class [84] 
.const [32] = Field [85] [86] 
.const [33] = Field [87] [88] 
.const [34] = Field [89] [90] 
.const [35] = InterfaceMethod [91] [92] 
.const [36] = InterfaceMethod [93] [94] 
.const [37] = InterfaceMethod [95] [96] 
.const [38] = Int 269352960 
.const [39] = Int -402456576 
.const [40] = Utf8 de/audi/tuner/app/epg/ClockTimeZoneOffsetHandler$DSICarTimeUnitsLanguageListenerImpl 
.const [41] = Utf8 java/lang/Object 
.const [42] = Utf8 java/util/ArrayList 
.const [43] = Utf8 '[ClockTimeZoneOffsetHandler.onDSUpdateClockTime] offset: %1 ' 
.const [44] = Utf8 '[ClockTimeZoneOffsetHandler.onDSUpdateClockTime] summertime: %1' 
.const [45] = Utf8 de/audi/tuner/app/epg/ClockTimeZoneOffsetHandler$IClockTimeZoneOffsetListener 
.const [46] = Utf8 de/audi/tuner/app/epg/ClockTimeZoneOffsetHandler 
.const [47] = Utf8 org/dsi/ifc/cartimeunitslanguage/ClockTime 
.const [48] = Utf8 de/audi/atip/log/LogChannel 
.const [49] = Utf8 java/util/Iterator 
.const [50] = Class [97] 
.const [51] = NameAndType [98] [99] 
.const [52] = Class [100] 
.const [53] = NameAndType [101] [102] 
.const [54] = Class [103] 
.const [55] = NameAndType [104] [105] 
.const [56] = Class [106] 
.const [57] = NameAndType [107] [108] 
.const [58] = Class [109] 
.const [59] = NameAndType [110] [111] 
.const [60] = Class [112] 
.const [61] = NameAndType [113] [114] 
.const [62] = Class [115] 
.const [63] = NameAndType [116] [117] 
.const [64] = Class [118] 
.const [65] = NameAndType [119] [120] 
.const [66] = Class [121] 
.const [67] = NameAndType [122] [123] 
.const [68] = Class [124] 
.const [69] = NameAndType [125] [126] 
.const [70] = Class [127] 
.const [71] = NameAndType [128] [129] 
.const [72] = Class [130] 
.const [73] = NameAndType [131] [132] 
.const [74] = Class [133] 
.const [75] = NameAndType [134] [135] 
.const [76] = Class [136] 
.const [77] = NameAndType [137] [138] 
.const [78] = Utf8 de/audi/tuner/app/epg/ClockTimeZoneOffsetHandler$DSICarTimeUnitsLanguageListenerImpl 
.const [79] = Class [139] 
.const [80] = NameAndType [140] [141] 
.const [81] = Utf8 java/lang/Object 
.const [82] = Class [142] 
.const [83] = NameAndType [143] [144] 
.const [84] = Utf8 java/util/ArrayList 
.const [85] = Class [145] 
.const [86] = NameAndType [146] [147] 
.const [87] = Class [148] 
.const [88] = NameAndType [149] [150] 
.const [89] = Class [151] 
.const [90] = NameAndType [152] [153] 
.const [91] = Class [154] 
.const [92] = NameAndType [155] [156] 
.const [93] = Class [157] 
.const [94] = NameAndType [158] [159] 
.const [95] = Class [160] 
.const [96] = NameAndType [161] [162] 
.const [97] = Utf8 de/audi/tuner/app/epg/ClockTimeZoneOffsetHandler 
.const [98] = Utf8 mutex 
.const [99] = Utf8 Ljava/lang/Object; 
.const [100] = Utf8 de/audi/tuner/app/epg/ClockTimeZoneOffsetHandler 
.const [101] = Utf8 clockTimeZoneOffsetListeners 
.const [102] = Utf8 Ljava/util/ArrayList; 
.const [103] = Utf8 de/audi/tuner/app/epg/ClockTimeZoneOffsetHandler 
.const [104] = Utf8 lc 
.const [105] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [106] = Utf8 java/util/ArrayList 
.const [107] = Utf8 add 
.const [108] = Utf8 (Ljava/lang/Object;)Z 
.const [109] = Utf8 de/audi/tuner/app/epg/ClockTimeZoneOffsetHandler 
.const [110] = Utf8 timeZoneOffset 
.const [111] = Utf8 J 
.const [112] = Utf8 org/dsi/ifc/cartimeunitslanguage/ClockTime 
.const [113] = Utf8 timeZone 
.const [114] = Utf8 F 
.const [115] = Utf8 de/audi/atip/log/LogChannel 
.const [116] = Utf8 log 
.const [117] = Utf8 (ILjava/lang/String;D)V 
.const [118] = Utf8 org/dsi/ifc/cartimeunitslanguage/ClockTime 
.const [119] = Utf8 summerTime 
.const [120] = Utf8 Z 
.const [121] = Utf8 de/audi/atip/log/LogChannel 
.const [122] = Utf8 log 
.const [123] = Utf8 (ILjava/lang/String;Z)Z 
.const [124] = Utf8 java/util/ArrayList 
.const [125] = Utf8 iterator 
.const [126] = Utf8 ()Ljava/util/Iterator; 
.const [127] = Utf8 de/audi/tuner/app/epg/ClockTimeZoneOffsetHandler 
.const [128] = Utf8 onDSUpdateClockTime 
.const [129] = Utf8 (Lorg/dsi/ifc/cartimeunitslanguage/ClockTime;)V 
.const [130] = Utf8 java/lang/Object 
.const [131] = Utf8 <init> 
.const [132] = Utf8 ()V 
.const [133] = Utf8 de/audi/tuner/app/epg/ClockTimeZoneOffsetHandler$DSICarTimeUnitsLanguageListenerImpl 
.const [134] = Utf8 <init> 
.const [135] = Utf8 (Lde/audi/tuner/app/epg/ClockTimeZoneOffsetHandler;Lde/audi/tuner/app/epg/ClockTimeZoneOffsetHandler$1;)V 
.const [136] = Utf8 java/util/ArrayList 
.const [137] = Utf8 <init> 
.const [138] = Utf8 (I)V 
.const [139] = Utf8 de/audi/tuner/app/epg/ClockTimeZoneOffsetHandler 
.const [140] = Utf8 dsiListener 
.const [141] = Utf8 Lorg/dsi/ifc/cartimeunitslanguage/DSICarTimeUnitsLanguageListener; 
.const [142] = Utf8 de/audi/tuner/app/epg/ClockTimeZoneOffsetHandler 
.const [143] = Utf8 mutex 
.const [144] = Utf8 Ljava/lang/Object; 
.const [145] = Utf8 de/audi/tuner/app/epg/ClockTimeZoneOffsetHandler 
.const [146] = Utf8 clockTimeZoneOffsetListeners 
.const [147] = Utf8 Ljava/util/ArrayList; 
.const [148] = Utf8 de/audi/tuner/app/epg/ClockTimeZoneOffsetHandler 
.const [149] = Utf8 lc 
.const [150] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [151] = Utf8 de/audi/tuner/app/epg/ClockTimeZoneOffsetHandler 
.const [152] = Utf8 timeZoneOffset 
.const [153] = Utf8 J 
.const [154] = Utf8 java/util/Iterator 
.const [155] = Utf8 hasNext 
.const [156] = Utf8 ()Z 
.const [157] = Utf8 java/util/Iterator 
.const [158] = Utf8 next 
.const [159] = Utf8 ()Ljava/lang/Object; 
.const [160] = Utf8 de/audi/tuner/app/epg/ClockTimeZoneOffsetHandler$IClockTimeZoneOffsetListener 
.const [161] = Utf8 offsetChanged 
.const [162] = Utf8 (J)V 
.const [163] = Utf8 de/audi/tuner/app/epg/ClockTimeZoneOffsetHandler 
.const [164] = Class [163] 
.const [165] = Utf8 java/lang/Object 
.const [166] = Class [165] 
.const [167] = Utf8 dsiListener 
.const [168] = Utf8 Lorg/dsi/ifc/cartimeunitslanguage/DSICarTimeUnitsLanguageListener; 
.const [169] = Utf8 mutex 
.const [170] = Utf8 Ljava/lang/Object; 
.const [171] = Utf8 lc 
.const [172] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [173] = Utf8 clockTimeZoneOffsetListeners 
.const [174] = Utf8 Ljava/util/ArrayList; 
.const [175] = Utf8 timeZoneOffset 
.const [176] = Utf8 J 
.const [177] = Utf8 Code 
.const [178] = Utf8 <init> 
.const [179] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [180] = Utf8 addClockTimeZoneOffsetListener 
.const [181] = Utf8 (Lde/audi/tuner/app/epg/ClockTimeZoneOffsetHandler$IClockTimeZoneOffsetListener;)V 
.const [182] = Utf8 getOffset 
.const [183] = Utf8 ()J 
.const [184] = Utf8 onDSUpdateClockTime 
.const [185] = Utf8 (Lorg/dsi/ifc/cartimeunitslanguage/ClockTime;)V 
.const [186] = Utf8 access$100 
.const [187] = Utf8 (Lde/audi/tuner/app/epg/ClockTimeZoneOffsetHandler;Lorg/dsi/ifc/cartimeunitslanguage/ClockTime;)V 
.end class 
