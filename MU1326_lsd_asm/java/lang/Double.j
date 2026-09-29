.version 50 0 
.class public final super [122] 
.super [124] 
.implements [126] 
.field private static final [127] [128] 
.field final [129] [130] 
.field public static final [131] [132] 
.field public static final [133] [134] 
.field public static final [135] [136] 
.field public static final [137] [138] 
.field public static final [139] [140] 
.field public static final [141] [142] 

.method static [144] : [145] 
    .attribute [143] .code stack 2 locals 0 
L0:     ldc2_w [29] 
L3:     putstatic [18] 
L6:     iconst_0 
L7:     newarray double 
L9:     invokespecial [19] 
L12:    invokevirtual [15] 
L15:    putstatic [20] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [146] : [147] 
    .attribute [143] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [21] 
L4:     aload_0 
L5:     dload_1 
L6:     putfield [24] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [148] : [149] 
    .attribute [143] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokestatic [6] 
L5:     invokespecial [22] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [150] : [151] 
    .attribute [143] .code stack 4 locals 6 
L0:     ldc2_w [30] 
L3:     invokestatic [7] 
L6:     lstore 6 
L8:     aload_0 
L9:     getfield [16] 
L12:    invokestatic [7] 
L15:    dup2 
L16:    lstore_2 
L17:    lload 6 
L19:    lcmp 
L20:    ifne L40 
L23:    aload_1 
L24:    getfield [16] 
L27:    invokestatic [7] 
L30:    lload 6 
L32:    lcmp 
L33:    ifne L38 
L36:    iconst_0 
L37:    areturn 
L38:    iconst_1 
L39:    areturn 
L40:    aload_1 
L41:    getfield [16] 
L44:    invokestatic [7] 
L47:    dup2 
L48:    lstore 4 
L50:    lload 6 
L52:    lcmp 
L53:    ifne L58 
L56:    iconst_m1 
L57:    areturn 
L58:    aload_0 
L59:    getfield [16] 
L62:    aload_1 
L63:    getfield [16] 
L66:    dcmpl 
L67:    ifne L92 
L70:    lload_2 
L71:    lload 4 
L73:    lcmp 
L74:    ifne L79 
L77:    iconst_0 
L78:    areturn 
L79:    lload_2 
L80:    lload 4 
L82:    lcmp 
L83:    ifle L90 
L86:    iconst_1 
L87:    goto L91 
L90:    iconst_m1 
L91:    areturn 
L92:    aload_0 
L93:    getfield [16] 
L96:    aload_1 
L97:    getfield [16] 
L100:   dcmpl 
L101:   ifle L108 
L104:   iconst_1 
L105:   goto L109 
L108:   iconst_m1 
L109:   areturn 
L110:   nop 
L111:   nop 
L112:   
    .end code 
.end method 

.method public [152] : [153] 
    .attribute [143] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     checkcast [2] 
L5:     invokevirtual [17] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [154] : [155] 
    .attribute [143] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     d2i 
L5:     i2b 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static native [156] : [157] 
    .attribute [143] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public static native [158] : [159] 
    .attribute [143] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public interface [160] : [161] 
    .attribute [143] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     freturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [162] : [163] 
    .attribute [143] .code stack 4 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     if_acmpeq L35 
L5:     aload_1 
L6:     instanceof [2] 
L9:     ifeq L33 
L12:    aload_0 
L13:    getfield [16] 
L16:    invokestatic [7] 
L19:    aload_1 
L20:    checkcast [2] 
L23:    getfield [16] 
L26:    invokestatic [7] 
L29:    lcmp 
L30:    ifeq L35 
L33:    iconst_0 
L34:    areturn 
L35:    iconst_1 
L36:    areturn 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [164] : [165] 
    .attribute [143] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     d2f 
L5:     areturn 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [166] : [167] 
    .attribute [143] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [16] 
L4:     invokestatic [7] 
L7:     lstore_1 
L8:     lload_1 
L9:     lload_1 
L10:    bipush 32 
L12:    lushr 
L13:    lxor 
L14:    l2i 
L15:    areturn 
L16:    
    .end code 
.end method 

.method public [168] : [169] 
    .attribute [143] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     d2i 
L5:     areturn 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [170] : [171] 
    .attribute [143] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     invokestatic [8] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public static [172] : [173] 
    .attribute [143] .code stack 4 locals 0 
L0:     dload_0 
L1:     ldc2_w [25] 
L4:     dcmpl 
L5:     ifeq L18 
L8:     dload_0 
L9:     ldc2_w [27] 
L12:    dcmpl 
L13:    ifeq L18 
L16:    iconst_0 
L17:    areturn 
L18:    iconst_1 
L19:    areturn 
L20:    
    .end code 
.end method 

.method public [174] : [175] 
    .attribute [143] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     invokestatic [9] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public static [176] : [177] 
    .attribute [143] .code stack 4 locals 0 
L0:     dload_0 
L1:     dload_0 
L2:     dcmpl 
L3:     ifeq L8 
L6:     iconst_1 
L7:     areturn 
L8:     iconst_0 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public static native [178] : [179] 
    .attribute [143] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [180] : [181] 
    .attribute [143] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     d2l 
L5:     freturn 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [182] : [183] 
    .attribute [143] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokestatic [11] 
L4:     freturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [184] : [185] 
    .attribute [143] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     d2i 
L5:     i2s 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [186] : [187] 
    .attribute [143] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     invokestatic [12] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public static [188] : [189] 
    .attribute [143] .code stack 2 locals 0 
L0:     dload_0 
L1:     invokestatic [14] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [190] : [191] 
    .attribute [143] .code stack 4 locals 0 
L0:     new [23] 
L3:     dup 
L4:     aload_0 
L5:     invokestatic [6] 
L8:     invokespecial [22] 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public static [192] : [193] 
    .attribute [143] .code stack 4 locals 6 
L0:     ldc2_w [32] 
L3:     invokestatic [7] 
L6:     lstore 8 
L8:     dload_0 
L9:     invokestatic [7] 
L12:    dup2 
L13:    lstore 4 
L15:    lload 8 
L17:    lcmp 
L18:    ifne L35 
L21:    dload_2 
L22:    invokestatic [7] 
L25:    lload 8 
L27:    lcmp 
L28:    ifne L33 
L31:    iconst_0 
L32:    areturn 
L33:    iconst_1 
L34:    areturn 
L35:    dload_2 
L36:    invokestatic [7] 
L39:    dup2 
L40:    lstore 6 
L42:    lload 8 
L44:    lcmp 
L45:    ifne L50 
L48:    iconst_m1 
L49:    areturn 
L50:    dload_0 
L51:    dload_2 
L52:    dcmpl 
L53:    ifne L80 
L56:    lload 4 
L58:    lload 6 
L60:    lcmp 
L61:    ifne L66 
L64:    iconst_0 
L65:    areturn 
L66:    lload 4 
L68:    lload 6 
L70:    lcmp 
L71:    ifle L78 
L74:    iconst_1 
L75:    goto L79 
L78:    iconst_m1 
L79:    areturn 
L80:    dload_0 
L81:    dload_2 
L82:    dcmpl 
L83:    ifle L90 
L86:    iconst_1 
L87:    goto L91 
L90:    iconst_m1 
L91:    areturn 
L92:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [34] 
.const [3] = Class [35] 
.const [4] = Class [36] 
.const [5] = Class [37] 
.const [6] = Method [38] [39] 
.const [7] = Method [40] [41] 
.const [8] = Method [42] [43] 
.const [9] = Method [44] [45] 
.const [10] = Class [46] 
.const [11] = Method [47] [48] 
.const [12] = Method [49] [50] 
.const [13] = Class [51] 
.const [14] = Method [52] [53] 
.const [15] = Method [54] [55] 
.const [16] = Field [56] [57] 
.const [17] = Method [58] [59] 
.const [18] = Field [60] [61] 
.const [19] = Method [62] [63] 
.const [20] = Field [64] [65] 
.const [21] = Method [66] [67] 
.const [22] = Method [68] [69] 
.const [23] = Class [70] 
.const [24] = Field [71] [72] 
.const [25] = Double +Infinity 
.const [27] = Double -Infinity 
.const [29] = Double +0x100000067FF800p-1059 
.const [32] = Double +NaN<0x7FF8000000000000> 
.const [34] = Utf8 java/lang/Double 
.const [35] = Utf8 java/lang/Number 
.const [36] = Utf8 java/lang/Object 
.const [37] = Utf8 java/lang/Class 
.const [38] = Class [73] 
.const [39] = NameAndType [74] [75] 
.const [40] = Class [76] 
.const [41] = NameAndType [77] [78] 
.const [42] = Class [79] 
.const [43] = NameAndType [80] [81] 
.const [44] = Class [82] 
.const [45] = NameAndType [83] [84] 
.const [46] = Utf8 com/ibm/oti/util/FloatingPointParser 
.const [47] = Class [85] 
.const [48] = NameAndType [86] [87] 
.const [49] = Class [88] 
.const [50] = NameAndType [89] [90] 
.const [51] = Utf8 com/ibm/oti/util/NumberConverter 
.const [52] = Class [91] 
.const [53] = NameAndType [92] [93] 
.const [54] = Class [94] 
.const [55] = NameAndType [95] [96] 
.const [56] = Class [97] 
.const [57] = NameAndType [98] [99] 
.const [58] = Class [100] 
.const [59] = NameAndType [101] [102] 
.const [60] = Class [103] 
.const [61] = NameAndType [104] [105] 
.const [62] = Class [106] 
.const [63] = NameAndType [107] [108] 
.const [64] = Class [109] 
.const [65] = NameAndType [110] [111] 
.const [66] = Class [112] 
.const [67] = NameAndType [113] [114] 
.const [68] = Class [115] 
.const [69] = NameAndType [116] [117] 
.const [70] = Utf8 java/lang/Double 
.const [71] = Class [118] 
.const [72] = NameAndType [119] [120] 
.const [73] = Utf8 java/lang/Double 
.const [74] = Utf8 parseDouble 
.const [75] = Utf8 (Ljava/lang/String;)D 
.const [76] = Utf8 java/lang/Double 
.const [77] = Utf8 doubleToLongBits 
.const [78] = Utf8 (D)J 
.const [79] = Utf8 java/lang/Double 
.const [80] = Utf8 isInfinite 
.const [81] = Utf8 (D)Z 
.const [82] = Utf8 java/lang/Double 
.const [83] = Utf8 isNaN 
.const [84] = Utf8 (D)Z 
.const [85] = Utf8 com/ibm/oti/util/FloatingPointParser 
.const [86] = Utf8 parseDouble 
.const [87] = Utf8 (Ljava/lang/String;)D 
.const [88] = Utf8 java/lang/Double 
.const [89] = Utf8 toString 
.const [90] = Utf8 (D)Ljava/lang/String; 
.const [91] = Utf8 com/ibm/oti/util/NumberConverter 
.const [92] = Utf8 convert 
.const [93] = Utf8 (D)Ljava/lang/String; 
.const [94] = Utf8 java/lang/Class 
.const [95] = Utf8 getComponentType 
.const [96] = Utf8 ()Ljava/lang/Class; 
.const [97] = Utf8 java/lang/Double 
.const [98] = Utf8 value 
.const [99] = Utf8 D 
.const [100] = Utf8 java/lang/Double 
.const [101] = Utf8 compareTo 
.const [102] = Utf8 (Ljava/lang/Double;)I 
.const [103] = Utf8 java/lang/Double 
.const [104] = Utf8 MIN_VALUE 
.const [105] = Utf8 D 
.const [106] = Utf8 java/lang/Object 
.const [107] = Utf8 getClass 
.const [108] = Utf8 ()Ljava/lang/Class; 
.const [109] = Utf8 java/lang/Double 
.const [110] = Utf8 TYPE 
.const [111] = Utf8 Ljava/lang/Class; 
.const [112] = Utf8 java/lang/Number 
.const [113] = Utf8 <init> 
.const [114] = Utf8 ()V 
.const [115] = Utf8 java/lang/Double 
.const [116] = Utf8 <init> 
.const [117] = Utf8 (D)V 
.const [118] = Utf8 java/lang/Double 
.const [119] = Utf8 value 
.const [120] = Utf8 D 
.const [121] = Utf8 java/lang/Double 
.const [122] = Class [121] 
.const [123] = Utf8 java/lang/Number 
.const [124] = Class [123] 
.const [125] = Utf8 java/lang/Comparable 
.const [126] = Class [125] 
.const [127] = Utf8 serialVersionUID 
.const [128] = Utf8 J 
.const [129] = Utf8 value 
.const [130] = Utf8 D 
.const [131] = Utf8 MAX_VALUE 
.const [132] = Utf8 D 
.const [133] = Utf8 MIN_VALUE 
.const [134] = Utf8 D 
.const [135] = Utf8 NaN 
.const [136] = Utf8 D 
.const [137] = Utf8 POSITIVE_INFINITY 
.const [138] = Utf8 D 
.const [139] = Utf8 NEGATIVE_INFINITY 
.const [140] = Utf8 D 
.const [141] = Utf8 TYPE 
.const [142] = Utf8 Ljava/lang/Class; 
.const [143] = Utf8 Code 
.const [144] = Utf8 <clinit> 
.const [145] = Utf8 ()V 
.const [146] = Utf8 <init> 
.const [147] = Utf8 (D)V 
.const [148] = Utf8 <init> 
.const [149] = Utf8 (Ljava/lang/String;)V 
.const [150] = Utf8 compareTo 
.const [151] = Utf8 (Ljava/lang/Double;)I 
.const [152] = Utf8 compareTo 
.const [153] = Utf8 (Ljava/lang/Object;)I 
.const [154] = Utf8 byteValue 
.const [155] = Utf8 ()B 
.const [156] = Utf8 doubleToLongBits 
.const [157] = Utf8 (D)J 
.const [158] = Utf8 doubleToRawLongBits 
.const [159] = Utf8 (D)J 
.const [160] = Utf8 doubleValue 
.const [161] = Utf8 ()D 
.const [162] = Utf8 equals 
.const [163] = Utf8 (Ljava/lang/Object;)Z 
.const [164] = Utf8 floatValue 
.const [165] = Utf8 ()F 
.const [166] = Utf8 hashCode 
.const [167] = Utf8 ()I 
.const [168] = Utf8 intValue 
.const [169] = Utf8 ()I 
.const [170] = Utf8 isInfinite 
.const [171] = Utf8 ()Z 
.const [172] = Utf8 isInfinite 
.const [173] = Utf8 (D)Z 
.const [174] = Utf8 isNaN 
.const [175] = Utf8 ()Z 
.const [176] = Utf8 isNaN 
.const [177] = Utf8 (D)Z 
.const [178] = Utf8 longBitsToDouble 
.const [179] = Utf8 (J)D 
.const [180] = Utf8 longValue 
.const [181] = Utf8 ()J 
.const [182] = Utf8 parseDouble 
.const [183] = Utf8 (Ljava/lang/String;)D 
.const [184] = Utf8 shortValue 
.const [185] = Utf8 ()S 
.const [186] = Utf8 toString 
.const [187] = Utf8 ()Ljava/lang/String; 
.const [188] = Utf8 toString 
.const [189] = Utf8 (D)Ljava/lang/String; 
.const [190] = Utf8 valueOf 
.const [191] = Utf8 (Ljava/lang/String;)Ljava/lang/Double; 
.const [192] = Utf8 compare 
.const [193] = Utf8 (DD)I 
.end class 
