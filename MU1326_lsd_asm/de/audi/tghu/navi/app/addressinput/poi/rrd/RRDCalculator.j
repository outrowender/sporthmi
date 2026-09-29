.version 50 0 
.class public super [144] 
.super [146] 
.field private final [147] [148] 
.field private [149] [150] 

.method public [152] : [153] 
    .attribute [151] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [32] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [24] 
L9:     putfield [36] 
L12:    aload_0 
L13:    aload_2 
L14:    putfield [37] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [154] : [155] 
    .attribute [151] .code stack 3 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [26] 
L5:     astore_2 
L6:     aload_2 
L7:     ifnull L19 
L10:    aload_2 
L11:    ldc [2] 
L13:    invokevirtual [27] 
L16:    goto L31 
L19:    aload_0 
L20:    getfield [23] 
L23:    ldc [3] 
L25:    ldc [4] 
L27:    invokevirtual [28] 
L30:    pop 
L31:    return 
L32:    
    .end code 
.end method 

.method public [156] : [157] 
    .attribute [151] .code stack 6 locals 1 
L0:     aload_1 
L1:     ifnonnull L18 
L4:     aload_0 
L5:     getfield [23] 
L8:     ldc [3] 
L10:    ldc [5] 
L12:    invokevirtual [28] 
L15:    pop 
L16:    aconst_null 
L17:    areturn 
L18:    aload_0 
L19:    getfield [23] 
L22:    ldc [6] 
L24:    ldc [7] 
L26:    invokevirtual [28] 
L29:    pop 
L30:    aload_0 
L31:    getfield [25] 
L34:    iconst_1 
L35:    invokeinterface [38] 0 
L40:    astore_2 
L41:    aload_2 
L42:    new [39] 
L45:    dup 
L46:    aload_0 
L47:    ldc [9] 
L49:    aload_1 
L50:    invokespecial [33] 
L53:    invokevirtual [29] 
L56:    pop 
L57:    aload_2 
L58:    areturn 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [158] : [159] 
    .attribute [151] .code stack 6 locals 1 
L0:     aload_1 
L1:     ifnull L9 
L4:     aload_1 
L5:     arraylength 
L6:     ifgt L24 
L9:     aload_0 
L10:    getfield [23] 
L13:    ldc [3] 
L15:    ldc [10] 
L17:    aload_1 
L18:    invokevirtual [30] 
L21:    pop 
L22:    aconst_null 
L23:    areturn 
L24:    aload_0 
L25:    getfield [23] 
L28:    ldc [6] 
L30:    ldc [11] 
L32:    aload_1 
L33:    aload_1 
L34:    arraylength 
L35:    i2l 
L36:    invokevirtual [31] 
L39:    pop 
L40:    aload_0 
L41:    getfield [25] 
L44:    iconst_1 
L45:    invokeinterface [38] 0 
L50:    astore_2 
L51:    aload_2 
L52:    new [40] 
L55:    dup 
L56:    invokespecial [34] 
L59:    invokevirtual [29] 
L62:    pop 
L63:    aload_2 
L64:    new [41] 
L67:    dup 
L68:    aload_1 
L69:    invokespecial [35] 
L72:    invokevirtual [29] 
L75:    pop 
L76:    aload_2 
L77:    areturn 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 

.method public [160] : [161] 
    .attribute [151] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [23] 
L4:     ldc [14] 
L6:     ldc [15] 
L8:     invokevirtual [28] 
L11:    pop 
L12:    aload_0 
L13:    getfield [25] 
L16:    iconst_1 
L17:    invokeinterface [38] 0 
L22:    astore_1 
L23:    aload_1 
L24:    new [40] 
L27:    dup 
L28:    invokespecial [34] 
L31:    invokevirtual [29] 
L34:    pop 
L35:    aload_1 
L36:    ldc [16] 
L38:    invokevirtual [27] 
L41:    return 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method static synthetic [162] : [163] 
    .attribute [151] .code stack 1 locals 0 
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
.const [2] = String [42] 
.const [3] = Int -1601830656 
.const [4] = String [43] 
.const [5] = String [44] 
.const [6] = Int 1078071040 
.const [7] = String [45] 
.const [8] = Class [46] 
.const [9] = String [47] 
.const [10] = String [48] 
.const [11] = String [49] 
.const [12] = Class [50] 
.const [13] = Class [51] 
.const [14] = Int -2137614336 
.const [15] = String [52] 
.const [16] = String [53] 
.const [17] = Class [54] 
.const [18] = Class [55] 
.const [19] = Class [56] 
.const [20] = Class [57] 
.const [21] = Class [58] 
.const [22] = Class [59] 
.const [23] = Field [60] [61] 
.const [24] = Method [62] [63] 
.const [25] = Field [64] [65] 
.const [26] = Method [66] [67] 
.const [27] = Method [68] [69] 
.const [28] = Method [70] [71] 
.const [29] = Method [72] [73] 
.const [30] = Method [74] [75] 
.const [31] = Method [76] [77] 
.const [32] = Method [78] [79] 
.const [33] = Method [80] [81] 
.const [34] = Method [82] [83] 
.const [35] = Method [84] [85] 
.const [36] = Field [86] [87] 
.const [37] = Field [88] [89] 
.const [38] = InterfaceMethod [90] [91] 
.const [39] = Class [92] 
.const [40] = Class [93] 
.const [41] = Class [94] 
.const [42] = Utf8 'RRDCalculator#startRRDCalculation' 
.const [43] = Utf8 'RRDCalculator#startRRDCalculation() - no list to start' 
.const [44] = Utf8 'RRDCalculator#startRRDCalculation() - calculation not started. IRRDListProvider is null! ' 
.const [45] = Utf8 'RRDCalculator#startRRDCalculation() ' 
.const [46] = Utf8 de/audi/tghu/navi/app/addressinput/poi/rrd/RRDCalculator$1 
.const [47] = Utf8 GetRRDListForCalculation 
.const [48] = Utf8 'RRDCalculator#createStartRRDCalculation() - calculation not started. NavLocationWgs84 array is null or empty: %1 ! ' 
.const [49] = Utf8 'RRDCalculator#createStartRRDCalculation() - prepare calculation for: %1 with size %2! ' 
.const [50] = Utf8 de/audi/tghu/navi/app/command/poi/RRDStopCalculationCommand 
.const [51] = Utf8 de/audi/tghu/navi/app/command/poi/RRDStartCalculationForPositionCommand 
.const [52] = Utf8 'RRDCalculator#stopRRDCalculation() ' 
.const [53] = Utf8 'RRDCalculator#stopRRDCalculation' 
.const [54] = Utf8 de/audi/tghu/navi/app/addressinput/poi/rrd/RRDCalculator 
.const [55] = Utf8 java/lang/Object 
.const [56] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [57] = Utf8 de/audi/tghu/command/CommandList 
.const [58] = Utf8 de/audi/atip/log/LogChannel 
.const [59] = Utf8 de/audi/tghu/command/ICommandListFactory 
.const [60] = Class [95] 
.const [61] = NameAndType [96] [97] 
.const [62] = Class [98] 
.const [63] = NameAndType [99] [100] 
.const [64] = Class [101] 
.const [65] = NameAndType [102] [103] 
.const [66] = Class [104] 
.const [67] = NameAndType [105] [106] 
.const [68] = Class [107] 
.const [69] = NameAndType [108] [109] 
.const [70] = Class [110] 
.const [71] = NameAndType [111] [112] 
.const [72] = Class [113] 
.const [73] = NameAndType [114] [115] 
.const [74] = Class [116] 
.const [75] = NameAndType [117] [118] 
.const [76] = Class [119] 
.const [77] = NameAndType [120] [121] 
.const [78] = Class [122] 
.const [79] = NameAndType [123] [124] 
.const [80] = Class [125] 
.const [81] = NameAndType [126] [127] 
.const [82] = Class [128] 
.const [83] = NameAndType [129] [130] 
.const [84] = Class [131] 
.const [85] = NameAndType [132] [133] 
.const [86] = Class [134] 
.const [87] = NameAndType [135] [136] 
.const [88] = Class [137] 
.const [89] = NameAndType [138] [139] 
.const [90] = Class [140] 
.const [91] = NameAndType [141] [142] 
.const [92] = Utf8 de/audi/tghu/navi/app/addressinput/poi/rrd/RRDCalculator$1 
.const [93] = Utf8 de/audi/tghu/navi/app/command/poi/RRDStopCalculationCommand 
.const [94] = Utf8 de/audi/tghu/navi/app/command/poi/RRDStartCalculationForPositionCommand 
.const [95] = Utf8 de/audi/tghu/navi/app/addressinput/poi/rrd/RRDCalculator 
.const [96] = Utf8 logChannel 
.const [97] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [98] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [99] = Utf8 getPOILogChannel 
.const [100] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [101] = Utf8 de/audi/tghu/navi/app/addressinput/poi/rrd/RRDCalculator 
.const [102] = Utf8 commandListFactory 
.const [103] = Utf8 Lde/audi/tghu/command/ICommandListFactory; 
.const [104] = Utf8 de/audi/tghu/navi/app/addressinput/poi/rrd/RRDCalculator 
.const [105] = Utf8 createStartRRDCalculation 
.const [106] = Utf8 (Lde/audi/tghu/navi/app/addressinput/poi/rrd/IRRDListProvider;)Lde/audi/tghu/command/CommandList; 
.const [107] = Utf8 de/audi/tghu/command/CommandList 
.const [108] = Utf8 execute 
.const [109] = Utf8 (Ljava/lang/String;)V 
.const [110] = Utf8 de/audi/atip/log/LogChannel 
.const [111] = Utf8 log 
.const [112] = Utf8 (ILjava/lang/String;)Z 
.const [113] = Utf8 de/audi/tghu/command/CommandList 
.const [114] = Utf8 add 
.const [115] = Utf8 (Lde/audi/tghu/command/Command;)Lde/audi/tghu/command/ICommandList; 
.const [116] = Utf8 de/audi/atip/log/LogChannel 
.const [117] = Utf8 log 
.const [118] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [119] = Utf8 de/audi/atip/log/LogChannel 
.const [120] = Utf8 log 
.const [121] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [122] = Utf8 java/lang/Object 
.const [123] = Utf8 <init> 
.const [124] = Utf8 ()V 
.const [125] = Utf8 de/audi/tghu/navi/app/addressinput/poi/rrd/RRDCalculator$1 
.const [126] = Utf8 <init> 
.const [127] = Utf8 (Lde/audi/tghu/navi/app/addressinput/poi/rrd/RRDCalculator;Ljava/lang/String;Lde/audi/tghu/navi/app/addressinput/poi/rrd/IRRDListProvider;)V 
.const [128] = Utf8 de/audi/tghu/navi/app/command/poi/RRDStopCalculationCommand 
.const [129] = Utf8 <init> 
.const [130] = Utf8 ()V 
.const [131] = Utf8 de/audi/tghu/navi/app/command/poi/RRDStartCalculationForPositionCommand 
.const [132] = Utf8 <init> 
.const [133] = Utf8 ([Lorg/dsi/ifc/global/NavLocationWgs84;)V 
.const [134] = Utf8 de/audi/tghu/navi/app/addressinput/poi/rrd/RRDCalculator 
.const [135] = Utf8 logChannel 
.const [136] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [137] = Utf8 de/audi/tghu/navi/app/addressinput/poi/rrd/RRDCalculator 
.const [138] = Utf8 commandListFactory 
.const [139] = Utf8 Lde/audi/tghu/command/ICommandListFactory; 
.const [140] = Utf8 de/audi/tghu/command/ICommandListFactory 
.const [141] = Utf8 createCommandList 
.const [142] = Utf8 (I)Lde/audi/tghu/command/CommandList; 
.const [143] = Utf8 de/audi/tghu/navi/app/addressinput/poi/rrd/RRDCalculator 
.const [144] = Class [143] 
.const [145] = Utf8 java/lang/Object 
.const [146] = Class [145] 
.const [147] = Utf8 commandListFactory 
.const [148] = Utf8 Lde/audi/tghu/command/ICommandListFactory; 
.const [149] = Utf8 logChannel 
.const [150] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [151] = Utf8 Code 
.const [152] = Utf8 <init> 
.const [153] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/tghu/command/ICommandListFactory;)V 
.const [154] = Utf8 startRRDCalculation 
.const [155] = Utf8 (Lde/audi/tghu/navi/app/addressinput/poi/rrd/IRRDListProvider;)V 
.const [156] = Utf8 createStartRRDCalculation 
.const [157] = Utf8 (Lde/audi/tghu/navi/app/addressinput/poi/rrd/IRRDListProvider;)Lde/audi/tghu/command/CommandList; 
.const [158] = Utf8 createStartRRDCalculation 
.const [159] = Utf8 ([Lorg/dsi/ifc/global/NavLocationWgs84;)Lde/audi/tghu/command/CommandList; 
.const [160] = Utf8 stopRRDCalculation 
.const [161] = Utf8 ()V 
.const [162] = Utf8 access$000 
.const [163] = Utf8 (Lde/audi/tghu/navi/app/addressinput/poi/rrd/RRDCalculator;)Lde/audi/atip/log/LogChannel; 
.end class 
