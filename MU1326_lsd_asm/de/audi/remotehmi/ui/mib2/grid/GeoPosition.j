.version 50 0 
.class public super [149] 
.super [151] 
.field public static final [152] [153] 
.field public static final [154] [155] 
.field public static final [156] [157] 
.field private final [158] [159] 
.field private final [160] [161] 
.field private final [162] [163] 
.field private [164] [165] 

.method public static [167] : [168] 
    .attribute [166] .code stack 6 locals 0 
L0:     dload_0 
L1:     ldc2_w [29] 
L4:     dcmpl 
L5:     ifeq L16 
L8:     dload_2 
L9:     ldc2_w [29] 
L12:    dcmpl 
L13:    ifne L20 
L16:    getstatic [2] 
L19:    areturn 
L20:    new [23] 
L23:    dup 
L24:    dload_0 
L25:    dload_2 
L26:    invokespecial [20] 
L29:    areturn 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method private [169] : [170] 
    .attribute [166] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [21] 
L4:     aload_0 
L5:     bipush 24 
L7:     putfield [24] 
L10:    aload_0 
L11:    dload_1 
L12:    putfield [25] 
L15:    aload_0 
L16:    dload_3 
L17:    putfield [26] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public interface [171] : [172] 
    .attribute [166] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     freturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [173] : [174] 
    .attribute [166] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     freturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [175] : [176] 
    .attribute [166] .code stack 4 locals 1 
L0:     iconst_2 
L1:     newarray double 
L3:     astore_1 
L4:     aload_1 
L5:     iconst_0 
L6:     aload_0 
L7:     getfield [11] 
L10:    dastore 
L11:    aload_1 
L12:    iconst_1 
L13:    aload_0 
L14:    getfield [12] 
L17:    dastore 
L18:    aload_1 
L19:    areturn 
L20:    
    .end code 
.end method 

.method public static [177] : [178] 
    .attribute [166] .code stack 4 locals 0 
L0:     aload_0 
L1:     ifnull L10 
L4:     aload_0 
L5:     arraylength 
L6:     iconst_2 
L7:     if_icmpge L16 
L10:    getstatic [2] 
L13:    goto L25 
L16:    aload_0 
L17:    iconst_0 
L18:    daload 
L19:    aload_0 
L20:    iconst_1 
L21:    daload 
L22:    invokestatic [4] 
L25:    areturn 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [179] : [180] 
    .attribute [166] .code stack 6 locals 4 
L0:     iconst_1 
L1:     istore_2 
L2:     aload_0 
L3:     getfield [11] 
L6:     invokestatic [5] 
L9:     lstore_3 
L10:    bipush 31 
L12:    iload_2 
L13:    imul 
L14:    lload_3 
L15:    lload_3 
L16:    bipush 32 
L18:    lushr 
L19:    lxor 
L20:    l2i 
L21:    iadd 
L22:    istore_2 
L23:    aload_0 
L24:    getfield [12] 
L27:    invokestatic [5] 
L30:    lstore_3 
L31:    bipush 31 
L33:    iload_2 
L34:    imul 
L35:    lload_3 
L36:    lload_3 
L37:    bipush 32 
L39:    lushr 
L40:    lxor 
L41:    l2i 
L42:    iadd 
L43:    istore_2 
L44:    iload_2 
L45:    areturn 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [181] : [182] 
    .attribute [166] .code stack 4 locals 1 
L0:     aload_1 
L1:     instanceof [3] 
L4:     ifne L9 
L7:     iconst_0 
L8:     areturn 
L9:     aload_1 
L10:    checkcast [3] 
L13:    astore_2 
L14:    aload_0 
L15:    getfield [11] 
L18:    aload_2 
L19:    getfield [11] 
L22:    dcmpl 
L23:    ifne L42 
L26:    aload_0 
L27:    getfield [12] 
L30:    aload_2 
L31:    getfield [12] 
L34:    dcmpl 
L35:    ifne L42 
L38:    iconst_1 
L39:    goto L43 
L42:    iconst_0 
L43:    areturn 
L44:    
    .end code 
.end method 

.method public static [183] : [184] 
    .attribute [166] .code stack 2 locals 0 
L0:     aload_0 
L1:     ifnonnull L14 
L4:     aload_1 
L5:     ifnonnull L12 
L8:     iconst_1 
L9:     goto L13 
L12:    iconst_0 
L13:    areturn 
L14:    aload_1 
L15:    ifnonnull L20 
L18:    iconst_0 
L19:    areturn 
L20:    aload_0 
L21:    aload_1 
L22:    invokevirtual [13] 
L25:    areturn 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [185] : [186] 
    .attribute [166] .code stack 2 locals 0 
L0:     aload_0 
L1:     bipush 120 
L3:     invokevirtual [14] 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [187] : [188] 
    .attribute [166] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [15] 
L4:     ifnull L12 
L7:     aload_0 
L8:     getfield [15] 
L11:    areturn 
L12:    new [28] 
L15:    dup 
L16:    bipush 49 
L18:    invokespecial [22] 
L21:    astore_2 
L22:    aload_2 
L23:    aload_0 
L24:    getfield [11] 
L27:    invokestatic [7] 
L30:    invokevirtual [16] 
L33:    iload_1 
L34:    invokevirtual [17] 
L37:    aload_0 
L38:    getfield [12] 
L41:    invokestatic [7] 
L44:    invokevirtual [16] 
L47:    pop 
L48:    aload_0 
L49:    aload_2 
L50:    invokevirtual [18] 
L53:    putfield [27] 
L56:    aload_0 
L57:    getfield [15] 
L60:    areturn 
L61:    nop 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method public static [189] : [190] 
    .attribute [166] .code stack 6 locals 2 
L0:     new [23] 
L3:     dup 
L4:     dconst_1 
L5:     ldc2_w [31] 
L8:     invokespecial [20] 
L11:    astore_1 
L12:    new [23] 
L15:    dup 
L16:    ldc2_w [33] 
L19:    ldc2_w [35] 
L22:    invokespecial [20] 
L25:    astore_2 
L26:    aload_1 
L27:    aload_2 
L28:    invokestatic [8] 
L31:    pop 
L32:    return 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method static [191] : [192] 
    .attribute [166] .code stack 6 locals 0 
L0:     new [23] 
L3:     dup 
L4:     ldc2_w [29] 
L7:     ldc2_w [29] 
L10:    invokespecial [20] 
L13:    putstatic [19] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [37] [38] 
.const [3] = Class [39] 
.const [4] = Method [40] [41] 
.const [5] = Method [42] [43] 
.const [6] = Class [44] 
.const [7] = Method [45] [46] 
.const [8] = Method [47] [48] 
.const [9] = Class [49] 
.const [10] = Class [50] 
.const [11] = Field [51] [52] 
.const [12] = Field [53] [54] 
.const [13] = Method [55] [56] 
.const [14] = Method [57] [58] 
.const [15] = Field [59] [60] 
.const [16] = Method [61] [62] 
.const [17] = Method [63] [64] 
.const [18] = Method [65] [66] 
.const [19] = Field [67] [68] 
.const [20] = Method [69] [70] 
.const [21] = Method [71] [72] 
.const [22] = Method [73] [74] 
.const [23] = Class [75] 
.const [24] = Field [76] [77] 
.const [25] = Field [78] [79] 
.const [26] = Field [80] [81] 
.const [27] = Field [82] [83] 
.const [28] = Class [84] 
.const [29] = Double +0x1FFFFFFFFFFFFFp971 
.const [31] = Double +0x10000000000000p-51 
.const [33] = Double +0x18000000000000p-51 
.const [35] = Double +0x10000000000000p-50 
.const [37] = Class [85] 
.const [38] = NameAndType [86] [87] 
.const [39] = Utf8 de/audi/remotehmi/ui/mib2/grid/GeoPosition 
.const [40] = Class [88] 
.const [41] = NameAndType [89] [90] 
.const [42] = Class [91] 
.const [43] = NameAndType [92] [93] 
.const [44] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [45] = Class [94] 
.const [46] = NameAndType [95] [96] 
.const [47] = Class [97] 
.const [48] = NameAndType [98] [99] 
.const [49] = Utf8 java/lang/Object 
.const [50] = Utf8 java/lang/Double 
.const [51] = Class [100] 
.const [52] = NameAndType [101] [102] 
.const [53] = Class [103] 
.const [54] = NameAndType [104] [105] 
.const [55] = Class [106] 
.const [56] = NameAndType [107] [108] 
.const [57] = Class [109] 
.const [58] = NameAndType [110] [111] 
.const [59] = Class [112] 
.const [60] = NameAndType [113] [114] 
.const [61] = Class [115] 
.const [62] = NameAndType [116] [117] 
.const [63] = Class [118] 
.const [64] = NameAndType [119] [120] 
.const [65] = Class [121] 
.const [66] = NameAndType [122] [123] 
.const [67] = Class [124] 
.const [68] = NameAndType [125] [126] 
.const [69] = Class [127] 
.const [70] = NameAndType [128] [129] 
.const [71] = Class [130] 
.const [72] = NameAndType [131] [132] 
.const [73] = Class [133] 
.const [74] = NameAndType [134] [135] 
.const [75] = Utf8 de/audi/remotehmi/ui/mib2/grid/GeoPosition 
.const [76] = Class [136] 
.const [77] = NameAndType [137] [138] 
.const [78] = Class [139] 
.const [79] = NameAndType [140] [141] 
.const [80] = Class [142] 
.const [81] = NameAndType [143] [144] 
.const [82] = Class [145] 
.const [83] = NameAndType [146] [147] 
.const [84] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [85] = Utf8 de/audi/remotehmi/ui/mib2/grid/GeoPosition 
.const [86] = Utf8 UNDEFINED_POSITION 
.const [87] = Utf8 Lde/audi/remotehmi/ui/mib2/grid/GeoPosition; 
.const [88] = Utf8 de/audi/remotehmi/ui/mib2/grid/GeoPosition 
.const [89] = Utf8 createPosition 
.const [90] = Utf8 (DD)Lde/audi/remotehmi/ui/mib2/grid/GeoPosition; 
.const [91] = Utf8 java/lang/Double 
.const [92] = Utf8 doubleToLongBits 
.const [93] = Utf8 (D)J 
.const [94] = Utf8 java/lang/Double 
.const [95] = Utf8 toString 
.const [96] = Utf8 (D)Ljava/lang/String; 
.const [97] = Utf8 de/audi/remotehmi/ui/mib2/grid/GeoPosition 
.const [98] = Utf8 equals 
.const [99] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Z 
.const [100] = Utf8 de/audi/remotehmi/ui/mib2/grid/GeoPosition 
.const [101] = Utf8 latitude 
.const [102] = Utf8 D 
.const [103] = Utf8 de/audi/remotehmi/ui/mib2/grid/GeoPosition 
.const [104] = Utf8 longitude 
.const [105] = Utf8 D 
.const [106] = Utf8 java/lang/Object 
.const [107] = Utf8 equals 
.const [108] = Utf8 (Ljava/lang/Object;)Z 
.const [109] = Utf8 de/audi/remotehmi/ui/mib2/grid/GeoPosition 
.const [110] = Utf8 toString 
.const [111] = Utf8 (C)Ljava/lang/String; 
.const [112] = Utf8 de/audi/remotehmi/ui/mib2/grid/GeoPosition 
.const [113] = Utf8 debugInfo 
.const [114] = Utf8 Ljava/lang/String; 
.const [115] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [116] = Utf8 append 
.const [117] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [118] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [119] = Utf8 append 
.const [120] = Utf8 (C)Lde/esolutions/fw/util/commons/Buffer; 
.const [121] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [122] = Utf8 toString 
.const [123] = Utf8 ()Ljava/lang/String; 
.const [124] = Utf8 de/audi/remotehmi/ui/mib2/grid/GeoPosition 
.const [125] = Utf8 UNDEFINED_POSITION 
.const [126] = Utf8 Lde/audi/remotehmi/ui/mib2/grid/GeoPosition; 
.const [127] = Utf8 de/audi/remotehmi/ui/mib2/grid/GeoPosition 
.const [128] = Utf8 <init> 
.const [129] = Utf8 (DD)V 
.const [130] = Utf8 java/lang/Object 
.const [131] = Utf8 <init> 
.const [132] = Utf8 ()V 
.const [133] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [134] = Utf8 <init> 
.const [135] = Utf8 (I)V 
.const [136] = Utf8 de/audi/remotehmi/ui/mib2/grid/GeoPosition 
.const [137] = Utf8 MAX_LENGTH_FOR_DOUBLE_AS_STRING 
.const [138] = Utf8 I 
.const [139] = Utf8 de/audi/remotehmi/ui/mib2/grid/GeoPosition 
.const [140] = Utf8 latitude 
.const [141] = Utf8 D 
.const [142] = Utf8 de/audi/remotehmi/ui/mib2/grid/GeoPosition 
.const [143] = Utf8 longitude 
.const [144] = Utf8 D 
.const [145] = Utf8 de/audi/remotehmi/ui/mib2/grid/GeoPosition 
.const [146] = Utf8 debugInfo 
.const [147] = Utf8 Ljava/lang/String; 
.const [148] = Utf8 de/audi/remotehmi/ui/mib2/grid/GeoPosition 
.const [149] = Class [148] 
.const [150] = Utf8 java/lang/Object 
.const [151] = Class [150] 
.const [152] = Utf8 UNDEFINED_COORDINATE 
.const [153] = Utf8 D 
.const [154] = Utf8 UNDEFINED_COORDINATE_WGS 
.const [155] = Utf8 I 
.const [156] = Utf8 UNDEFINED_POSITION 
.const [157] = Utf8 Lde/audi/remotehmi/ui/mib2/grid/GeoPosition; 
.const [158] = Utf8 MAX_LENGTH_FOR_DOUBLE_AS_STRING 
.const [159] = Utf8 I 
.const [160] = Utf8 latitude 
.const [161] = Utf8 D 
.const [162] = Utf8 longitude 
.const [163] = Utf8 D 
.const [164] = Utf8 debugInfo 
.const [165] = Utf8 Ljava/lang/String; 
.const [166] = Utf8 Code 
.const [167] = Utf8 createPosition 
.const [168] = Utf8 (DD)Lde/audi/remotehmi/ui/mib2/grid/GeoPosition; 
.const [169] = Utf8 <init> 
.const [170] = Utf8 (DD)V 
.const [171] = Utf8 getLatitude 
.const [172] = Utf8 ()D 
.const [173] = Utf8 getLongitude 
.const [174] = Utf8 ()D 
.const [175] = Utf8 asDoubleArray 
.const [176] = Utf8 ()[D 
.const [177] = Utf8 fromDoubleArray 
.const [178] = Utf8 ([D)Lde/audi/remotehmi/ui/mib2/grid/GeoPosition; 
.const [179] = Utf8 hashCode 
.const [180] = Utf8 ()I 
.const [181] = Utf8 equals 
.const [182] = Utf8 (Ljava/lang/Object;)Z 
.const [183] = Utf8 equals 
.const [184] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Z 
.const [185] = Utf8 toString 
.const [186] = Utf8 ()Ljava/lang/String; 
.const [187] = Utf8 toString 
.const [188] = Utf8 (C)Ljava/lang/String; 
.const [189] = Utf8 main 
.const [190] = Utf8 ([Ljava/lang/String;)V 
.const [191] = Utf8 <clinit> 
.const [192] = Utf8 ()V 
.end class 
