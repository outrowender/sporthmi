.version 50 0 
.class public super [117] 
.super [119] 
.field private [120] [121] 
.field private [122] [123] 
.field private static [124] [125] 

.method static [127] : [128] 
    .attribute [126] .code stack 1 locals 0 
L0:     invokestatic [4] 
L3:     putstatic [15] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [129] : [130] 
    .attribute [126] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [16] 
L4:     aload_0 
L5:     ldc2_w [24] 
L8:     putfield [21] 
L11:    return 
L12:    
    .end code 
.end method 

.method public [131] : [132] 
    .attribute [126] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [22] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [133] : [134] 
    .attribute [126] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private static native [135] : [136] 
    .attribute [126] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method native [137] : [138] 
    .attribute [126] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public static [139] : [140] 
    .attribute [126] .code stack 1 locals 0 
L0:     getstatic [5] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [141] : [142] 
    .attribute [126] .code stack 7 locals 0 
L0:     iload_2 
L1:     iflt L46 
L4:     iload_2 
L5:     aload_1 
L6:     arraylength 
L7:     if_icmpgt L46 
L10:    iload_3 
L11:    iflt L46 
L14:    iload_3 
L15:    aload_1 
L16:    arraylength 
L17:    iload_2 
L18:    isub 
L19:    if_icmpgt L46 
L22:    iload_3 
L23:    ifne L30 
L26:    iconst_0 
L27:    newarray byte 
L29:    areturn 
L30:    aload_0 
L31:    aload_1 
L32:    iload_2 
L33:    iload_3 
L34:    aload_0 
L35:    getfield [9] 
L38:    aload_0 
L39:    getfield [8] 
L42:    invokespecial [17] 
L45:    areturn 
L46:    new [23] 
L49:    dup 
L50:    invokespecial [18] 
L53:    athrow 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method private native [143] : [144] 
    .attribute [126] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [145] : [146] 
    .attribute [126] .code stack 7 locals 0 
L0:     iload_2 
L1:     iflt L46 
L4:     iload_2 
L5:     aload_1 
L6:     arraylength 
L7:     if_icmpgt L46 
L10:    iload_3 
L11:    iflt L46 
L14:    iload_3 
L15:    aload_1 
L16:    arraylength 
L17:    iload_2 
L18:    isub 
L19:    if_icmpgt L46 
L22:    iload_3 
L23:    ifne L30 
L26:    iconst_0 
L27:    newarray char 
L29:    areturn 
L30:    aload_0 
L31:    aload_1 
L32:    iload_2 
L33:    iload_3 
L34:    aload_0 
L35:    getfield [9] 
L38:    aload_0 
L39:    getfield [8] 
L42:    invokespecial [19] 
L45:    areturn 
L46:    new [23] 
L49:    dup 
L50:    invokespecial [18] 
L53:    athrow 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method private native [147] : [148] 
    .attribute [126] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [149] : [150] 
    .attribute [126] .code stack 11 locals 2 
L0:     iconst_0 
L1:     istore 5 
L3:     iconst_1 
L4:     newarray int 
L6:     astore 6 
L8:     aload 6 
L10:    iconst_0 
L11:    aload 4 
L13:    invokevirtual [10] 
L16:    iastore 
L17:    iload_2 
L18:    iflt L85 
L21:    iload_2 
L22:    aload_1 
L23:    arraylength 
L24:    if_icmpgt L85 
L27:    iload_3 
L28:    iflt L85 
L31:    iload_3 
L32:    aload_1 
L33:    arraylength 
L34:    iload_2 
L35:    isub 
L36:    if_icmpgt L85 
L39:    aload_0 
L40:    aload_1 
L41:    iload_2 
L42:    iload_3 
L43:    aload 4 
L45:    invokevirtual [11] 
L48:    aload 4 
L50:    invokevirtual [12] 
L53:    aload 4 
L55:    invokevirtual [13] 
L58:    aload 6 
L60:    aload_0 
L61:    getfield [9] 
L64:    aload_0 
L65:    getfield [8] 
L68:    invokespecial [20] 
L71:    istore 5 
L73:    aload 4 
L75:    aload 6 
L77:    iconst_0 
L78:    iaload 
L79:    invokevirtual [14] 
L82:    iload 5 
L84:    areturn 
L85:    new [23] 
L88:    dup 
L89:    invokespecial [18] 
L92:    athrow 
L93:    nop 
L94:    nop 
L95:    nop 
L96:    
    .end code 
.end method 

.method private native [151] : [152] 
    .attribute [126] .code stack 0 locals 0 
L0:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [26] 
.const [3] = Class [27] 
.const [4] = Method [28] [29] 
.const [5] = Field [30] [31] 
.const [6] = Class [32] 
.const [7] = Class [33] 
.const [8] = Field [34] [35] 
.const [9] = Field [36] [37] 
.const [10] = Method [38] [39] 
.const [11] = Method [40] [41] 
.const [12] = Method [42] [43] 
.const [13] = Method [44] [45] 
.const [14] = Method [46] [47] 
.const [15] = Field [48] [49] 
.const [16] = Method [50] [51] 
.const [17] = Method [52] [53] 
.const [18] = Method [54] [55] 
.const [19] = Method [56] [57] 
.const [20] = Method [58] [59] 
.const [21] = Field [60] [61] 
.const [22] = Field [62] [63] 
.const [23] = Class [64] 
.const [24] = Long -1L 
.const [26] = Utf8 com/ibm/oti/io/NativeCharacterConverter 
.const [27] = Utf8 com/ibm/oti/io/CharacterConverter 
.const [28] = Class [65] 
.const [29] = NameAndType [66] [67] 
.const [30] = Class [68] 
.const [31] = NameAndType [69] [70] 
.const [32] = Utf8 java/lang/IndexOutOfBoundsException 
.const [33] = Utf8 com/ibm/oti/io/CharBuffer 
.const [34] = Class [71] 
.const [35] = NameAndType [72] [73] 
.const [36] = Class [74] 
.const [37] = NameAndType [75] [76] 
.const [38] = Class [77] 
.const [39] = NameAndType [78] [79] 
.const [40] = Class [80] 
.const [41] = NameAndType [81] [82] 
.const [42] = Class [83] 
.const [43] = NameAndType [84] [85] 
.const [44] = Class [86] 
.const [45] = NameAndType [87] [88] 
.const [46] = Class [89] 
.const [47] = NameAndType [90] [91] 
.const [48] = Class [92] 
.const [49] = NameAndType [93] [94] 
.const [50] = Class [95] 
.const [51] = NameAndType [96] [97] 
.const [52] = Class [98] 
.const [53] = NameAndType [99] [100] 
.const [54] = Class [101] 
.const [55] = NameAndType [102] [103] 
.const [56] = Class [104] 
.const [57] = NameAndType [105] [106] 
.const [58] = Class [107] 
.const [59] = NameAndType [108] [109] 
.const [60] = Class [110] 
.const [61] = NameAndType [111] [112] 
.const [62] = Class [113] 
.const [63] = NameAndType [114] [115] 
.const [64] = Utf8 java/lang/IndexOutOfBoundsException 
.const [65] = Utf8 com/ibm/oti/io/NativeCharacterConverter 
.const [66] = Utf8 supportsNativeCharConv 
.const [67] = Utf8 ()Z 
.const [68] = Utf8 com/ibm/oti/io/NativeCharacterConverter 
.const [69] = Utf8 supportsNativeConv 
.const [70] = Utf8 Z 
.const [71] = Utf8 com/ibm/oti/io/NativeCharacterConverter 
.const [72] = Utf8 osCodePage 
.const [73] = Utf8 J 
.const [74] = Utf8 com/ibm/oti/io/NativeCharacterConverter 
.const [75] = Utf8 javaEncoding 
.const [76] = Utf8 Ljava/lang/String; 
.const [77] = Utf8 com/ibm/oti/io/CharBuffer 
.const [78] = Utf8 getPos 
.const [79] = Utf8 ()I 
.const [80] = Utf8 com/ibm/oti/io/CharBuffer 
.const [81] = Utf8 getChars 
.const [82] = Utf8 ()[C 
.const [83] = Utf8 com/ibm/oti/io/CharBuffer 
.const [84] = Utf8 getOffset 
.const [85] = Utf8 ()I 
.const [86] = Utf8 com/ibm/oti/io/CharBuffer 
.const [87] = Utf8 getSize 
.const [88] = Utf8 ()I 
.const [89] = Utf8 com/ibm/oti/io/CharBuffer 
.const [90] = Utf8 setPos 
.const [91] = Utf8 (I)V 
.const [92] = Utf8 com/ibm/oti/io/NativeCharacterConverter 
.const [93] = Utf8 supportsNativeConv 
.const [94] = Utf8 Z 
.const [95] = Utf8 com/ibm/oti/io/CharacterConverter 
.const [96] = Utf8 <init> 
.const [97] = Utf8 ()V 
.const [98] = Utf8 com/ibm/oti/io/NativeCharacterConverter 
.const [99] = Utf8 convertCharsToBytesImpl 
.const [100] = Utf8 ([CIILjava/lang/String;J)[B 
.const [101] = Utf8 java/lang/IndexOutOfBoundsException 
.const [102] = Utf8 <init> 
.const [103] = Utf8 ()V 
.const [104] = Utf8 com/ibm/oti/io/NativeCharacterConverter 
.const [105] = Utf8 convertBytesToCharsImpl 
.const [106] = Utf8 ([BIILjava/lang/String;J)[C 
.const [107] = Utf8 com/ibm/oti/io/NativeCharacterConverter 
.const [108] = Utf8 convertStreamBytesToCharsImpl 
.const [109] = Utf8 ([BII[CII[ILjava/lang/String;J)I 
.const [110] = Utf8 com/ibm/oti/io/NativeCharacterConverter 
.const [111] = Utf8 osCodePage 
.const [112] = Utf8 J 
.const [113] = Utf8 com/ibm/oti/io/NativeCharacterConverter 
.const [114] = Utf8 javaEncoding 
.const [115] = Utf8 Ljava/lang/String; 
.const [116] = Utf8 com/ibm/oti/io/NativeCharacterConverter 
.const [117] = Class [116] 
.const [118] = Utf8 com/ibm/oti/io/CharacterConverter 
.const [119] = Class [118] 
.const [120] = Utf8 javaEncoding 
.const [121] = Utf8 Ljava/lang/String; 
.const [122] = Utf8 osCodePage 
.const [123] = Utf8 J 
.const [124] = Utf8 supportsNativeConv 
.const [125] = Utf8 Z 
.const [126] = Utf8 Code 
.const [127] = Utf8 <clinit> 
.const [128] = Utf8 ()V 
.const [129] = Utf8 <init> 
.const [130] = Utf8 ()V 
.const [131] = Utf8 setJavaEncoding 
.const [132] = Utf8 (Ljava/lang/String;)V 
.const [133] = Utf8 getJavaEncoding 
.const [134] = Utf8 ()Ljava/lang/String; 
.const [135] = Utf8 supportsNativeCharConv 
.const [136] = Utf8 ()Z 
.const [137] = Utf8 supportsCodePage 
.const [138] = Utf8 (Ljava/lang/String;)Z 
.const [139] = Utf8 supportsNativeConversion 
.const [140] = Utf8 ()Z 
.const [141] = Utf8 convert 
.const [142] = Utf8 ([CII)[B 
.const [143] = Utf8 convertCharsToBytesImpl 
.const [144] = Utf8 ([CIILjava/lang/String;J)[B 
.const [145] = Utf8 convert 
.const [146] = Utf8 ([BII)[C 
.const [147] = Utf8 convertBytesToCharsImpl 
.const [148] = Utf8 ([BIILjava/lang/String;J)[C 
.const [149] = Utf8 convert 
.const [150] = Utf8 ([BIILcom/ibm/oti/io/CharBuffer;)I 
.const [151] = Utf8 convertStreamBytesToCharsImpl 
.const [152] = Utf8 ([BII[CII[ILjava/lang/String;J)I 
.end class 
