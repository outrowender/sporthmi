.version 50 0 
.class public super abstract [118] 
.super [120] 
.field private static [121] [122] 
.field private static [123] [124] 
.field private static final [125] [126] 
.field private static final [127] [128] 

.method public annotation [130] : [131] 
    .attribute [129] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [20] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [132] : [133] 
    .attribute [129] .code stack 4 locals 0 
L0:     lload_0 
L1:     lconst_0 
L2:     lcmp 
L3:     ifle L25 
L6:     getstatic [2] 
L9:     lload_0 
L10:    l2f 
L11:    ldc [3] 
L13:    fdiv 
L14:    invokevirtual [13] 
L17:    getstatic [2] 
L20:    iconst_1 
L21:    invokevirtual [14] 
L24:    areturn 
L25:    ldc [4] 
L27:    areturn 
L28:    
    .end code 
.end method 

.method public static [134] : [135] 
    .attribute [129] .code stack 6 locals 5 
L0:     lload_0 
L1:     ldc_w [1] 
L4:     ldiv 
L5:     lstore_2 
L6:     lload_0 
L7:     lload_2 
L8:     ldc_w [1] 
L11:    lmul 
L12:    lsub 
L13:    lstore_0 
L14:    lload_0 
L15:    ldc_w [1] 
L18:    ldiv 
L19:    lstore 4 
L21:    lload_0 
L22:    lload 4 
L24:    ldc_w [1] 
L27:    lmul 
L28:    lsub 
L29:    lstore_0 
L30:    new [26] 
L33:    dup 
L34:    bipush 30 
L36:    invokespecial [22] 
L39:    astore 6 
L41:    lload_2 
L42:    lconst_0 
L43:    lcmp 
L44:    ifle L62 
L47:    aload 6 
L49:    lload_2 
L50:    invokevirtual [15] 
L53:    pop 
L54:    aload 6 
L56:    ldc [6] 
L58:    invokevirtual [16] 
L61:    pop 
L62:    lload 4 
L64:    lconst_0 
L65:    lcmp 
L66:    ifle L85 
L69:    aload 6 
L71:    lload 4 
L73:    invokevirtual [15] 
L76:    pop 
L77:    aload 6 
L79:    ldc [7] 
L81:    invokevirtual [16] 
L84:    pop 
L85:    aload 6 
L87:    invokevirtual [17] 
L90:    areturn 
L91:    nop 
L92:    
    .end code 
.end method 

.method static [136] : [137] 
    .attribute [129] .code stack 3 locals 0 
L0:     getstatic [8] 
L3:     lload_0 
L4:     l2f 
L5:     invokevirtual [18] 
L8:     getstatic [8] 
L11:    invokevirtual [19] 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method static [138] : [139] 
    .attribute [129] .code stack 4 locals 0 
L0:     new [27] 
L3:     dup 
L4:     fconst_0 
L5:     iconst_1 
L6:     invokespecial [24] 
L9:     putstatic [21] 
L12:    new [28] 
L15:    dup 
L16:    fconst_0 
L17:    iconst_1 
L18:    invokespecial [25] 
L21:    putstatic [23] 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [31] [32] 
.const [3] = Int 31300 
.const [4] = String [33] 
.const [5] = Class [34] 
.const [6] = String [35] 
.const [7] = String [36] 
.const [8] = Field [37] [38] 
.const [9] = Class [39] 
.const [10] = Class [40] 
.const [11] = Class [41] 
.const [12] = Class [42] 
.const [13] = Method [43] [44] 
.const [14] = Method [45] [46] 
.const [15] = Method [47] [48] 
.const [16] = Method [49] [50] 
.const [17] = Method [51] [52] 
.const [18] = Method [53] [54] 
.const [19] = Method [55] [56] 
.const [20] = Method [57] [58] 
.const [21] = Field [59] [60] 
.const [22] = Method [61] [62] 
.const [23] = Field [63] [64] 
.const [24] = Method [65] [66] 
.const [25] = Method [67] [68] 
.const [26] = Class [69] 
.const [27] = Class [70] 
.const [28] = Class [71] 
.const [29] = Int -2131872256 
.const [30] = Int 1625948160 
.const [31] = Class [72] 
.const [32] = NameAndType [73] [74] 
.const [33] = Utf8 '' 
.const [34] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [35] = Utf8 ' h ' 
.const [36] = Utf8 ' min' 
.const [37] = Class [75] 
.const [38] = NameAndType [76] [77] 
.const [39] = Utf8 de/audi/atip/metrics/Distance 
.const [40] = Utf8 de/audi/atip/metrics/Speed 
.const [41] = Utf8 de/audi/tghu/online/app/remotehmi/RemoteHMICalculationHelper 
.const [42] = Utf8 java/lang/Object 
.const [43] = Class [78] 
.const [44] = NameAndType [79] [80] 
.const [45] = Class [81] 
.const [46] = NameAndType [82] [83] 
.const [47] = Class [84] 
.const [48] = NameAndType [85] [86] 
.const [49] = Class [87] 
.const [50] = NameAndType [88] [89] 
.const [51] = Class [90] 
.const [52] = NameAndType [91] [92] 
.const [53] = Class [93] 
.const [54] = NameAndType [94] [95] 
.const [55] = Class [96] 
.const [56] = NameAndType [97] [98] 
.const [57] = Class [99] 
.const [58] = NameAndType [100] [101] 
.const [59] = Class [102] 
.const [60] = NameAndType [103] [104] 
.const [61] = Class [105] 
.const [62] = NameAndType [106] [107] 
.const [63] = Class [108] 
.const [64] = NameAndType [109] [110] 
.const [65] = Class [111] 
.const [66] = NameAndType [112] [113] 
.const [67] = Class [114] 
.const [68] = NameAndType [115] [116] 
.const [69] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [70] = Utf8 de/audi/atip/metrics/Distance 
.const [71] = Utf8 de/audi/atip/metrics/Speed 
.const [72] = Utf8 de/audi/tghu/online/app/remotehmi/RemoteHMICalculationHelper 
.const [73] = Utf8 distanceMetric 
.const [74] = Utf8 Lde/audi/atip/metrics/Distance; 
.const [75] = Utf8 de/audi/tghu/online/app/remotehmi/RemoteHMICalculationHelper 
.const [76] = Utf8 speedMetric 
.const [77] = Utf8 Lde/audi/atip/metrics/Speed; 
.const [78] = Utf8 de/audi/atip/metrics/Distance 
.const [79] = Utf8 setValue 
.const [80] = Utf8 (F)V 
.const [81] = Utf8 de/audi/atip/metrics/Distance 
.const [82] = Utf8 formatByMode 
.const [83] = Utf8 (I)Ljava/lang/String; 
.const [84] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [85] = Utf8 append 
.const [86] = Utf8 (J)Lde/esolutions/fw/util/commons/Buffer; 
.const [87] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [88] = Utf8 append 
.const [89] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [90] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [91] = Utf8 toString 
.const [92] = Utf8 ()Ljava/lang/String; 
.const [93] = Utf8 de/audi/atip/metrics/Speed 
.const [94] = Utf8 setValue 
.const [95] = Utf8 (F)V 
.const [96] = Utf8 de/audi/atip/metrics/Speed 
.const [97] = Utf8 format 
.const [98] = Utf8 ()Ljava/lang/String; 
.const [99] = Utf8 java/lang/Object 
.const [100] = Utf8 <init> 
.const [101] = Utf8 ()V 
.const [102] = Utf8 de/audi/tghu/online/app/remotehmi/RemoteHMICalculationHelper 
.const [103] = Utf8 distanceMetric 
.const [104] = Utf8 Lde/audi/atip/metrics/Distance; 
.const [105] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [106] = Utf8 <init> 
.const [107] = Utf8 (I)V 
.const [108] = Utf8 de/audi/tghu/online/app/remotehmi/RemoteHMICalculationHelper 
.const [109] = Utf8 speedMetric 
.const [110] = Utf8 Lde/audi/atip/metrics/Speed; 
.const [111] = Utf8 de/audi/atip/metrics/Distance 
.const [112] = Utf8 <init> 
.const [113] = Utf8 (FI)V 
.const [114] = Utf8 de/audi/atip/metrics/Speed 
.const [115] = Utf8 <init> 
.const [116] = Utf8 (FI)V 
.const [117] = Utf8 de/audi/tghu/online/app/remotehmi/RemoteHMICalculationHelper 
.const [118] = Class [117] 
.const [119] = Utf8 java/lang/Object 
.const [120] = Class [119] 
.const [121] = Utf8 distanceMetric 
.const [122] = Utf8 Lde/audi/atip/metrics/Distance; 
.const [123] = Utf8 speedMetric 
.const [124] = Utf8 Lde/audi/atip/metrics/Speed; 
.const [125] = Utf8 MSEC_MINUTES 
.const [126] = Utf8 I 
.const [127] = Utf8 MSEC_HOURS 
.const [128] = Utf8 I 
.const [129] = Utf8 Code 
.const [130] = Utf8 <init> 
.const [131] = Utf8 ()V 
.const [132] = Utf8 calculateDistance 
.const [133] = Utf8 (J)Ljava/lang/String; 
.const [134] = Utf8 calculateTime 
.const [135] = Utf8 (J)Ljava/lang/String; 
.const [136] = Utf8 calculateSpeed 
.const [137] = Utf8 (J)Ljava/lang/String; 
.const [138] = Utf8 <clinit> 
.const [139] = Utf8 ()V 
.end class 
