.version 50 0 
.class public final super [105] 
.super [107] 
.field private static [108] [109] 

.method private annotation [111] : [112] 
    .attribute [110] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [22] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [113] : [114] 
    .attribute [110] .code stack 8 locals 7 
L0:     iload_0 
L1:     istore_1 
L2:     iload_1 
L3:     ldc [2] 
L5:     idiv 
L6:     istore_2 
L7:     iload_1 
L8:     ldc [2] 
L10:    irem 
L11:    istore_1 
L12:    iload_1 
L13:    ldc [3] 
L15:    idiv 
L16:    istore_3 
L17:    iload_1 
L18:    ldc [3] 
L20:    irem 
L21:    istore_1 
L22:    iload_1 
L23:    i2d 
L24:    ldc2_w [28] 
L27:    ddiv 
L28:    dstore 4 
L30:    iload_2 
L31:    i2d 
L32:    iload_3 
L33:    i2d 
L34:    dload 4 
L36:    ldc2_w [30] 
L39:    ddiv 
L40:    dadd 
L41:    ldc2_w [30] 
L44:    ddiv 
L45:    dadd 
L46:    dstore 6 
L48:    dload 6 
L50:    freturn 
L51:    nop 
L52:    
    .end code 
.end method 

.method public static [115] : [116] 
    .attribute [110] .code stack 5 locals 6 
L0:     dload_0 
L1:     dconst_0 
L2:     dcmpl 
L3:     ifle L10 
L6:     iconst_1 
L7:     goto L11 
L10:    iconst_m1 
L11:    istore_2 
L12:    dload_0 
L13:    invokestatic [4] 
L16:    dstore_0 
L17:    dload_0 
L18:    d2i 
L19:    istore_3 
L20:    dload_0 
L21:    iload_3 
L22:    i2d 
L23:    dsub 
L24:    ldc2_w [30] 
L27:    dmul 
L28:    dstore_0 
L29:    dload_0 
L30:    d2i 
L31:    istore 4 
L33:    dload_0 
L34:    iload 4 
L36:    i2d 
L37:    dsub 
L38:    ldc2_w [30] 
L41:    dmul 
L42:    dstore_0 
L43:    dload_0 
L44:    dstore 5 
L46:    iload_3 
L47:    ldc [2] 
L49:    imul 
L50:    iload 4 
L52:    ldc [3] 
L54:    imul 
L55:    iadd 
L56:    dload 5 
L58:    ldc2_w [28] 
L61:    dmul 
L62:    d2i 
L63:    iadd 
L64:    istore 7 
L66:    iload 7 
L68:    iload_2 
L69:    imul 
L70:    areturn 
L71:    nop 
L72:    
    .end code 
.end method 

.method public static [117] : [118] 
    .attribute [110] .code stack 5 locals 0 
L0:     getstatic [5] 
L3:     dload_0 
L4:     ldc2_w [32] 
L7:     drem 
L8:     invokevirtual [19] 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public static [119] : [120] 
    .attribute [110] .code stack 3 locals 0 
L0:     getstatic [6] 
L3:     ldc [7] 
L5:     invokestatic [8] 
L8:     invokestatic [9] 
L11:    invokevirtual [20] 
L14:    getstatic [6] 
L17:    ldc [10] 
L19:    invokestatic [8] 
L22:    invokestatic [9] 
L25:    invokevirtual [20] 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method static [121] : [122] 
    .attribute [110] .code stack 4 locals 1 
L0:     new [26] 
L3:     dup 
L4:     invokespecial [24] 
L7:     astore_0 
L8:     aload_0 
L9:     bipush 46 
L11:    invokevirtual [21] 
L14:    new [27] 
L17:    dup 
L18:    ldc [13] 
L20:    aload_0 
L21:    invokespecial [25] 
L24:    putstatic [23] 
L27:    return 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1611380224 
.const [3] = Int -1190657280 
.const [4] = Method [34] [35] 
.const [5] = Field [36] [37] 
.const [6] = Field [38] [39] 
.const [7] = Int -925587455 
.const [8] = Method [40] [41] 
.const [9] = Method [42] [43] 
.const [10] = Int 1325055522 
.const [11] = Class [44] 
.const [12] = Class [45] 
.const [13] = String [46] 
.const [14] = Class [47] 
.const [15] = Class [48] 
.const [16] = Class [49] 
.const [17] = Class [50] 
.const [18] = Class [51] 
.const [19] = Method [52] [53] 
.const [20] = Method [54] [55] 
.const [21] = Method [56] [57] 
.const [22] = Method [58] [59] 
.const [23] = Field [60] [61] 
.const [24] = Method [62] [63] 
.const [25] = Method [64] [65] 
.const [26] = Class [66] 
.const [27] = Class [67] 
.const [28] = Double +0x19E40000000000p-41 
.const [30] = Double +0x1E000000000000p-47 
.const [32] = Double +0x16800000000000p-44 
.const [34] = Class [68] 
.const [35] = NameAndType [69] [70] 
.const [36] = Class [71] 
.const [37] = NameAndType [72] [73] 
.const [38] = Class [74] 
.const [39] = NameAndType [75] [76] 
.const [40] = Class [77] 
.const [41] = NameAndType [78] [79] 
.const [42] = Class [80] 
.const [43] = NameAndType [81] [82] 
.const [44] = Utf8 java/text/DecimalFormatSymbols 
.const [45] = Utf8 java/text/DecimalFormat 
.const [46] = Utf8 '0.000' 
.const [47] = Utf8 de/audi/atip/interapp/NavigationUtilities 
.const [48] = Utf8 java/lang/Object 
.const [49] = Utf8 java/lang/Math 
.const [50] = Utf8 java/lang/System 
.const [51] = Utf8 java/io/PrintStream 
.const [52] = Class [83] 
.const [53] = NameAndType [84] [85] 
.const [54] = Class [86] 
.const [55] = NameAndType [87] [88] 
.const [56] = Class [89] 
.const [57] = NameAndType [90] [91] 
.const [58] = Class [92] 
.const [59] = NameAndType [93] [94] 
.const [60] = Class [95] 
.const [61] = NameAndType [96] [97] 
.const [62] = Class [98] 
.const [63] = NameAndType [99] [100] 
.const [64] = Class [101] 
.const [65] = NameAndType [102] [103] 
.const [66] = Utf8 java/text/DecimalFormatSymbols 
.const [67] = Utf8 java/text/DecimalFormat 
.const [68] = Utf8 java/lang/Math 
.const [69] = Utf8 abs 
.const [70] = Utf8 (D)D 
.const [71] = Utf8 de/audi/atip/interapp/NavigationUtilities 
.const [72] = Utf8 degreeStringFormat 
.const [73] = Utf8 Ljava/text/DecimalFormat; 
.const [74] = Utf8 java/lang/System 
.const [75] = Utf8 out 
.const [76] = Utf8 Ljava/io/PrintStream; 
.const [77] = Utf8 de/audi/atip/interapp/NavigationUtilities 
.const [78] = Utf8 wgs84ToDegree 
.const [79] = Utf8 (I)D 
.const [80] = Utf8 de/audi/atip/interapp/NavigationUtilities 
.const [81] = Utf8 formatDegree 
.const [82] = Utf8 (D)Ljava/lang/String; 
.const [83] = Utf8 java/text/DecimalFormat 
.const [84] = Utf8 format 
.const [85] = Utf8 (D)Ljava/lang/String; 
.const [86] = Utf8 java/io/PrintStream 
.const [87] = Utf8 println 
.const [88] = Utf8 (Ljava/lang/String;)V 
.const [89] = Utf8 java/text/DecimalFormatSymbols 
.const [90] = Utf8 setDecimalSeparator 
.const [91] = Utf8 (C)V 
.const [92] = Utf8 java/lang/Object 
.const [93] = Utf8 <init> 
.const [94] = Utf8 ()V 
.const [95] = Utf8 de/audi/atip/interapp/NavigationUtilities 
.const [96] = Utf8 degreeStringFormat 
.const [97] = Utf8 Ljava/text/DecimalFormat; 
.const [98] = Utf8 java/text/DecimalFormatSymbols 
.const [99] = Utf8 <init> 
.const [100] = Utf8 ()V 
.const [101] = Utf8 java/text/DecimalFormat 
.const [102] = Utf8 <init> 
.const [103] = Utf8 (Ljava/lang/String;Ljava/text/DecimalFormatSymbols;)V 
.const [104] = Utf8 de/audi/atip/interapp/NavigationUtilities 
.const [105] = Class [104] 
.const [106] = Utf8 java/lang/Object 
.const [107] = Class [106] 
.const [108] = Utf8 degreeStringFormat 
.const [109] = Utf8 Ljava/text/DecimalFormat; 
.const [110] = Utf8 Code 
.const [111] = Utf8 <init> 
.const [112] = Utf8 ()V 
.const [113] = Utf8 wgs84ToDegree 
.const [114] = Utf8 (I)D 
.const [115] = Utf8 degreeToWgs84 
.const [116] = Utf8 (D)I 
.const [117] = Utf8 formatDegree 
.const [118] = Utf8 (D)Ljava/lang/String; 
.const [119] = Utf8 main 
.const [120] = Utf8 ([Ljava/lang/String;)V 
.const [121] = Utf8 <clinit> 
.const [122] = Utf8 ()V 
.end class 
