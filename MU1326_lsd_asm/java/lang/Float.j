.version 50 0 
.class public final super [111] 
.super [113] 
.implements [115] 
.field private static final [116] [117] 
.field final [118] [119] 
.field public static final [120] [121] 
.field public static final [122] [123] 
.field public static final [124] [125] 
.field public static final [126] [127] 
.field public static final [128] [129] 
.field public static final [130] [131] 

.method static [133] : [134] 
    .attribute [132] .code stack 1 locals 0 
L0:     iconst_0 
L1:     newarray float 
L3:     invokespecial [22] 
L6:     invokevirtual [19] 
L9:     putstatic [23] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [135] : [136] 
    .attribute [132] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [24] 
L4:     aload_0 
L5:     fload_1 
L6:     putfield [27] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [137] : [138] 
    .attribute [132] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [24] 
L4:     aload_0 
L5:     dload_1 
L6:     d2f 
L7:     putfield [27] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [139] : [140] 
    .attribute [132] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokestatic [8] 
L5:     invokespecial [25] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [141] : [142] 
    .attribute [132] .code stack 2 locals 3 
L0:     ldc [9] 
L2:     invokestatic [10] 
L5:     istore 4 
L7:     aload_0 
L8:     getfield [20] 
L11:    invokestatic [10] 
L14:    dup 
L15:    istore_2 
L16:    iload 4 
L18:    if_icmpne L37 
L21:    aload_1 
L22:    getfield [20] 
L25:    invokestatic [10] 
L28:    iload 4 
L30:    if_icmpne L35 
L33:    iconst_0 
L34:    areturn 
L35:    iconst_1 
L36:    areturn 
L37:    aload_1 
L38:    getfield [20] 
L41:    invokestatic [10] 
L44:    dup 
L45:    istore_3 
L46:    iload 4 
L48:    if_icmpne L53 
L51:    iconst_m1 
L52:    areturn 
L53:    aload_0 
L54:    getfield [20] 
L57:    aload_1 
L58:    getfield [20] 
L61:    fcmpl 
L62:    ifne L83 
L65:    iload_2 
L66:    iload_3 
L67:    if_icmpne L72 
L70:    iconst_0 
L71:    areturn 
L72:    iload_2 
L73:    iload_3 
L74:    if_icmple L81 
L77:    iconst_1 
L78:    goto L82 
L81:    iconst_m1 
L82:    areturn 
L83:    aload_0 
L84:    getfield [20] 
L87:    aload_1 
L88:    getfield [20] 
L91:    fcmpl 
L92:    ifle L99 
L95:    iconst_1 
L96:    goto L100 
L99:    iconst_m1 
L100:   areturn 
L101:   nop 
L102:   nop 
L103:   nop 
L104:   
    .end code 
.end method 

.method public [143] : [144] 
    .attribute [132] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     checkcast [2] 
L5:     invokevirtual [21] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [145] : [146] 
    .attribute [132] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     f2i 
L5:     i2b 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [147] : [148] 
    .attribute [132] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     f2d 
L5:     freturn 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [149] : [150] 
    .attribute [132] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     if_acmpeq L34 
L5:     aload_1 
L6:     instanceof [2] 
L9:     ifeq L32 
L12:    aload_0 
L13:    getfield [20] 
L16:    invokestatic [10] 
L19:    aload_1 
L20:    checkcast [2] 
L23:    getfield [20] 
L26:    invokestatic [10] 
L29:    if_icmpeq L34 
L32:    iconst_0 
L33:    areturn 
L34:    iconst_1 
L35:    areturn 
L36:    
    .end code 
.end method 

.method public static native [151] : [152] 
    .attribute [132] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public static native [153] : [154] 
    .attribute [132] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public interface [155] : [156] 
    .attribute [132] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [157] : [158] 
    .attribute [132] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     invokestatic [10] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public static native [159] : [160] 
    .attribute [132] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [161] : [162] 
    .attribute [132] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     f2i 
L5:     areturn 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [163] : [164] 
    .attribute [132] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     invokestatic [11] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public static [165] : [166] 
    .attribute [132] .code stack 2 locals 0 
L0:     fload_0 
L1:     ldc [4] 
L3:     fcmpl 
L4:     ifeq L16 
L7:     fload_0 
L8:     ldc [5] 
L10:    fcmpl 
L11:    ifeq L16 
L14:    iconst_0 
L15:    areturn 
L16:    iconst_1 
L17:    areturn 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [167] : [168] 
    .attribute [132] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     invokestatic [12] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public static [169] : [170] 
    .attribute [132] .code stack 2 locals 0 
L0:     fload_0 
L1:     fload_0 
L2:     fcmpl 
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

.method public [171] : [172] 
    .attribute [132] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     f2l 
L5:     freturn 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [173] : [174] 
    .attribute [132] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokestatic [14] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [175] : [176] 
    .attribute [132] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     f2i 
L5:     i2s 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [177] : [178] 
    .attribute [132] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     invokestatic [15] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public static [179] : [180] 
    .attribute [132] .code stack 1 locals 0 
L0:     fload_0 
L1:     invokestatic [17] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [181] : [182] 
    .attribute [132] .code stack 3 locals 0 
L0:     new [26] 
L3:     dup 
L4:     aload_0 
L5:     invokestatic [8] 
L8:     invokespecial [25] 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public static [183] : [184] 
    .attribute [132] .code stack 2 locals 3 
L0:     ldc [18] 
L2:     invokestatic [10] 
L5:     istore 4 
L7:     fload_0 
L8:     invokestatic [10] 
L11:    dup 
L12:    istore_2 
L13:    iload 4 
L15:    if_icmpne L31 
L18:    fload_1 
L19:    invokestatic [10] 
L22:    iload 4 
L24:    if_icmpne L29 
L27:    iconst_0 
L28:    areturn 
L29:    iconst_1 
L30:    areturn 
L31:    fload_1 
L32:    invokestatic [10] 
L35:    dup 
L36:    istore_3 
L37:    iload 4 
L39:    if_icmpne L44 
L42:    iconst_m1 
L43:    areturn 
L44:    fload_0 
L45:    fload_1 
L46:    fcmpl 
L47:    ifne L68 
L50:    iload_2 
L51:    iload_3 
L52:    if_icmpne L57 
L55:    iconst_0 
L56:    areturn 
L57:    iload_2 
L58:    iload_3 
L59:    if_icmple L66 
L62:    iconst_1 
L63:    goto L67 
L66:    iconst_m1 
L67:    areturn 
L68:    fload_0 
L69:    fload_1 
L70:    fcmpl 
L71:    ifle L78 
L74:    iconst_1 
L75:    goto L79 
L78:    iconst_m1 
L79:    areturn 
L80:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [28] 
.const [3] = Class [29] 
.const [4] = Int 32895 
.const [5] = Int 33023 
.const [6] = Class [30] 
.const [7] = Class [31] 
.const [8] = Method [32] [33] 
.const [9] = Int 49279 
.const [10] = Method [34] [35] 
.const [11] = Method [36] [37] 
.const [12] = Method [38] [39] 
.const [13] = Class [40] 
.const [14] = Method [41] [42] 
.const [15] = Method [43] [44] 
.const [16] = Class [45] 
.const [17] = Method [46] [47] 
.const [18] = Int 49279 
.const [19] = Method [48] [49] 
.const [20] = Field [50] [51] 
.const [21] = Method [52] [53] 
.const [22] = Method [54] [55] 
.const [23] = Field [56] [57] 
.const [24] = Method [58] [59] 
.const [25] = Method [60] [61] 
.const [26] = Class [62] 
.const [27] = Field [63] [64] 
.const [28] = Utf8 java/lang/Float 
.const [29] = Utf8 java/lang/Number 
.const [30] = Utf8 java/lang/Object 
.const [31] = Utf8 java/lang/Class 
.const [32] = Class [65] 
.const [33] = NameAndType [66] [67] 
.const [34] = Class [68] 
.const [35] = NameAndType [69] [70] 
.const [36] = Class [71] 
.const [37] = NameAndType [72] [73] 
.const [38] = Class [74] 
.const [39] = NameAndType [75] [76] 
.const [40] = Utf8 com/ibm/oti/util/FloatingPointParser 
.const [41] = Class [77] 
.const [42] = NameAndType [78] [79] 
.const [43] = Class [80] 
.const [44] = NameAndType [81] [82] 
.const [45] = Utf8 com/ibm/oti/util/NumberConverter 
.const [46] = Class [83] 
.const [47] = NameAndType [84] [85] 
.const [48] = Class [86] 
.const [49] = NameAndType [87] [88] 
.const [50] = Class [89] 
.const [51] = NameAndType [90] [91] 
.const [52] = Class [92] 
.const [53] = NameAndType [93] [94] 
.const [54] = Class [95] 
.const [55] = NameAndType [96] [97] 
.const [56] = Class [98] 
.const [57] = NameAndType [99] [100] 
.const [58] = Class [101] 
.const [59] = NameAndType [102] [103] 
.const [60] = Class [104] 
.const [61] = NameAndType [105] [106] 
.const [62] = Utf8 java/lang/Float 
.const [63] = Class [107] 
.const [64] = NameAndType [108] [109] 
.const [65] = Utf8 java/lang/Float 
.const [66] = Utf8 parseFloat 
.const [67] = Utf8 (Ljava/lang/String;)F 
.const [68] = Utf8 java/lang/Float 
.const [69] = Utf8 floatToIntBits 
.const [70] = Utf8 (F)I 
.const [71] = Utf8 java/lang/Float 
.const [72] = Utf8 isInfinite 
.const [73] = Utf8 (F)Z 
.const [74] = Utf8 java/lang/Float 
.const [75] = Utf8 isNaN 
.const [76] = Utf8 (F)Z 
.const [77] = Utf8 com/ibm/oti/util/FloatingPointParser 
.const [78] = Utf8 parseFloat 
.const [79] = Utf8 (Ljava/lang/String;)F 
.const [80] = Utf8 java/lang/Float 
.const [81] = Utf8 toString 
.const [82] = Utf8 (F)Ljava/lang/String; 
.const [83] = Utf8 com/ibm/oti/util/NumberConverter 
.const [84] = Utf8 convert 
.const [85] = Utf8 (F)Ljava/lang/String; 
.const [86] = Utf8 java/lang/Class 
.const [87] = Utf8 getComponentType 
.const [88] = Utf8 ()Ljava/lang/Class; 
.const [89] = Utf8 java/lang/Float 
.const [90] = Utf8 value 
.const [91] = Utf8 F 
.const [92] = Utf8 java/lang/Float 
.const [93] = Utf8 compareTo 
.const [94] = Utf8 (Ljava/lang/Float;)I 
.const [95] = Utf8 java/lang/Object 
.const [96] = Utf8 getClass 
.const [97] = Utf8 ()Ljava/lang/Class; 
.const [98] = Utf8 java/lang/Float 
.const [99] = Utf8 TYPE 
.const [100] = Utf8 Ljava/lang/Class; 
.const [101] = Utf8 java/lang/Number 
.const [102] = Utf8 <init> 
.const [103] = Utf8 ()V 
.const [104] = Utf8 java/lang/Float 
.const [105] = Utf8 <init> 
.const [106] = Utf8 (F)V 
.const [107] = Utf8 java/lang/Float 
.const [108] = Utf8 value 
.const [109] = Utf8 F 
.const [110] = Utf8 java/lang/Float 
.const [111] = Class [110] 
.const [112] = Utf8 java/lang/Number 
.const [113] = Class [112] 
.const [114] = Utf8 java/lang/Comparable 
.const [115] = Class [114] 
.const [116] = Utf8 serialVersionUID 
.const [117] = Utf8 J 
.const [118] = Utf8 value 
.const [119] = Utf8 F 
.const [120] = Utf8 MAX_VALUE 
.const [121] = Utf8 F 
.const [122] = Utf8 MIN_VALUE 
.const [123] = Utf8 F 
.const [124] = Utf8 NaN 
.const [125] = Utf8 F 
.const [126] = Utf8 POSITIVE_INFINITY 
.const [127] = Utf8 F 
.const [128] = Utf8 NEGATIVE_INFINITY 
.const [129] = Utf8 F 
.const [130] = Utf8 TYPE 
.const [131] = Utf8 Ljava/lang/Class; 
.const [132] = Utf8 Code 
.const [133] = Utf8 <clinit> 
.const [134] = Utf8 ()V 
.const [135] = Utf8 <init> 
.const [136] = Utf8 (F)V 
.const [137] = Utf8 <init> 
.const [138] = Utf8 (D)V 
.const [139] = Utf8 <init> 
.const [140] = Utf8 (Ljava/lang/String;)V 
.const [141] = Utf8 compareTo 
.const [142] = Utf8 (Ljava/lang/Float;)I 
.const [143] = Utf8 compareTo 
.const [144] = Utf8 (Ljava/lang/Object;)I 
.const [145] = Utf8 byteValue 
.const [146] = Utf8 ()B 
.const [147] = Utf8 doubleValue 
.const [148] = Utf8 ()D 
.const [149] = Utf8 equals 
.const [150] = Utf8 (Ljava/lang/Object;)Z 
.const [151] = Utf8 floatToIntBits 
.const [152] = Utf8 (F)I 
.const [153] = Utf8 floatToRawIntBits 
.const [154] = Utf8 (F)I 
.const [155] = Utf8 floatValue 
.const [156] = Utf8 ()F 
.const [157] = Utf8 hashCode 
.const [158] = Utf8 ()I 
.const [159] = Utf8 intBitsToFloat 
.const [160] = Utf8 (I)F 
.const [161] = Utf8 intValue 
.const [162] = Utf8 ()I 
.const [163] = Utf8 isInfinite 
.const [164] = Utf8 ()Z 
.const [165] = Utf8 isInfinite 
.const [166] = Utf8 (F)Z 
.const [167] = Utf8 isNaN 
.const [168] = Utf8 ()Z 
.const [169] = Utf8 isNaN 
.const [170] = Utf8 (F)Z 
.const [171] = Utf8 longValue 
.const [172] = Utf8 ()J 
.const [173] = Utf8 parseFloat 
.const [174] = Utf8 (Ljava/lang/String;)F 
.const [175] = Utf8 shortValue 
.const [176] = Utf8 ()S 
.const [177] = Utf8 toString 
.const [178] = Utf8 ()Ljava/lang/String; 
.const [179] = Utf8 toString 
.const [180] = Utf8 (F)Ljava/lang/String; 
.const [181] = Utf8 valueOf 
.const [182] = Utf8 (Ljava/lang/String;)Ljava/lang/Float; 
.const [183] = Utf8 compare 
.const [184] = Utf8 (FF)I 
.end class 
