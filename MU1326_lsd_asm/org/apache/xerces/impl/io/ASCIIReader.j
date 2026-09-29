.version 50 0 
.class public super [141] 
.super [143] 
.field public static final [144] [145] 
.field protected final [146] [147] 
.field protected final [148] [149] 
.field private final [150] [151] 
.field private final [152] [153] 

.method public [155] : [156] 
    .attribute [154] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     sipush 2048 
L5:     aload_2 
L6:     aload_3 
L7:     invokespecial [22] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [157] : [158] 
    .attribute [154] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iload_2 
L3:     newarray byte 
L5:     aload_3 
L6:     aload 4 
L8:     invokespecial [23] 
L11:    return 
L12:    
    .end code 
.end method 

.method public [159] : [160] 
    .attribute [154] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [24] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [26] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [27] 
L14:    aload_0 
L15:    aload_3 
L16:    putfield [28] 
L19:    aload_0 
L20:    aload 4 
L22:    putfield [29] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [161] : [162] 
    .attribute [154] .code stack 10 locals 1 
L0:     aload_0 
L1:     getfield [11] 
L4:     invokevirtual [15] 
L7:     istore_1 
L8:     iload_1 
L9:     sipush 128 
L12:    if_icmplt L46 
L15:    new [30] 
L18:    dup 
L19:    aload_0 
L20:    getfield [13] 
L23:    aload_0 
L24:    getfield [14] 
L27:    ldc [3] 
L29:    ldc [4] 
L31:    iconst_1 
L32:    anewarray [5] 
L35:    dup 
L36:    iconst_0 
L37:    iload_1 
L38:    invokestatic [6] 
L41:    aastore 
L42:    invokespecial [25] 
L45:    athrow 
L46:    iload_1 
L47:    areturn 
L48:    
    .end code 
.end method 

.method public [163] : [164] 
    .attribute [154] .code stack 11 locals 3 
L0:     iload_3 
L1:     aload_0 
L2:     getfield [12] 
L5:     arraylength 
L6:     if_icmple L15 
L9:     aload_0 
L10:    getfield [12] 
L13:    arraylength 
L14:    istore_3 
L15:    aload_0 
L16:    getfield [11] 
L19:    aload_0 
L20:    getfield [12] 
L23:    iconst_0 
L24:    iload_3 
L25:    invokevirtual [16] 
L28:    istore 4 
L30:    iconst_0 
L31:    istore 5 
L33:    iload 5 
L35:    iload 4 
L37:    if_icmpge L105 
L40:    aload_0 
L41:    getfield [12] 
L44:    iload 5 
L46:    baload 
L47:    istore 6 
L49:    iload 6 
L51:    ifge L90 
L54:    new [30] 
L57:    dup 
L58:    aload_0 
L59:    getfield [13] 
L62:    aload_0 
L63:    getfield [14] 
L66:    ldc [3] 
L68:    ldc [4] 
L70:    iconst_1 
L71:    anewarray [5] 
L74:    dup 
L75:    iconst_0 
L76:    iload 6 
L78:    sipush 255 
L81:    iand 
L82:    invokestatic [6] 
L85:    aastore 
L86:    invokespecial [25] 
L89:    athrow 
L90:    aload_1 
L91:    iload_2 
L92:    iload 5 
L94:    iadd 
L95:    iload 6 
L97:    i2c 
L98:    castore 
L99:    iinc 5 1 
L102:   goto L33 
L105:   iload 4 
L107:   areturn 
L108:   
    .end code 
.end method 

.method public [165] : [166] 
    .attribute [154] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     lload_1 
L5:     invokevirtual [17] 
L8:     freturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [167] : [168] 
    .attribute [154] .code stack 1 locals 0 
L0:     iconst_0 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [169] : [170] 
    .attribute [154] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     invokevirtual [18] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [171] : [172] 
    .attribute [154] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     iload_1 
L5:     invokevirtual [19] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [173] : [174] 
    .attribute [154] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     invokevirtual [20] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [175] : [176] 
    .attribute [154] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     invokevirtual [21] 
L7:     return 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [31] 
.const [3] = String [32] 
.const [4] = String [33] 
.const [5] = Class [34] 
.const [6] = Method [35] [36] 
.const [7] = Class [37] 
.const [8] = Class [38] 
.const [9] = Class [39] 
.const [10] = Class [40] 
.const [11] = Field [41] [42] 
.const [12] = Field [43] [44] 
.const [13] = Field [45] [46] 
.const [14] = Field [47] [48] 
.const [15] = Method [49] [50] 
.const [16] = Method [51] [52] 
.const [17] = Method [53] [54] 
.const [18] = Method [55] [56] 
.const [19] = Method [57] [58] 
.const [20] = Method [59] [60] 
.const [21] = Method [61] [62] 
.const [22] = Method [63] [64] 
.const [23] = Method [65] [66] 
.const [24] = Method [67] [68] 
.const [25] = Method [69] [70] 
.const [26] = Field [71] [72] 
.const [27] = Field [73] [74] 
.const [28] = Field [75] [76] 
.const [29] = Field [77] [78] 
.const [30] = Class [79] 
.const [31] = Utf8 org/apache/xerces/impl/io/MalformedByteSequenceException 
.const [32] = Utf8 'http://www.w3.org/TR/1998/REC-xml-19980210' 
.const [33] = Utf8 InvalidASCII 
.const [34] = Utf8 java/lang/Object 
.const [35] = Class [80] 
.const [36] = NameAndType [81] [82] 
.const [37] = Utf8 org/apache/xerces/impl/io/ASCIIReader 
.const [38] = Utf8 java/io/Reader 
.const [39] = Utf8 java/io/InputStream 
.const [40] = Utf8 java/lang/Integer 
.const [41] = Class [83] 
.const [42] = NameAndType [84] [85] 
.const [43] = Class [86] 
.const [44] = NameAndType [87] [88] 
.const [45] = Class [89] 
.const [46] = NameAndType [90] [91] 
.const [47] = Class [92] 
.const [48] = NameAndType [93] [94] 
.const [49] = Class [95] 
.const [50] = NameAndType [96] [97] 
.const [51] = Class [98] 
.const [52] = NameAndType [99] [100] 
.const [53] = Class [101] 
.const [54] = NameAndType [102] [103] 
.const [55] = Class [104] 
.const [56] = NameAndType [105] [106] 
.const [57] = Class [107] 
.const [58] = NameAndType [108] [109] 
.const [59] = Class [110] 
.const [60] = NameAndType [111] [112] 
.const [61] = Class [113] 
.const [62] = NameAndType [114] [115] 
.const [63] = Class [116] 
.const [64] = NameAndType [117] [118] 
.const [65] = Class [119] 
.const [66] = NameAndType [120] [121] 
.const [67] = Class [122] 
.const [68] = NameAndType [123] [124] 
.const [69] = Class [125] 
.const [70] = NameAndType [126] [127] 
.const [71] = Class [128] 
.const [72] = NameAndType [129] [130] 
.const [73] = Class [131] 
.const [74] = NameAndType [132] [133] 
.const [75] = Class [134] 
.const [76] = NameAndType [135] [136] 
.const [77] = Class [137] 
.const [78] = NameAndType [138] [139] 
.const [79] = Utf8 org/apache/xerces/impl/io/MalformedByteSequenceException 
.const [80] = Utf8 java/lang/Integer 
.const [81] = Utf8 toString 
.const [82] = Utf8 (I)Ljava/lang/String; 
.const [83] = Utf8 org/apache/xerces/impl/io/ASCIIReader 
.const [84] = Utf8 fInputStream 
.const [85] = Utf8 Ljava/io/InputStream; 
.const [86] = Utf8 org/apache/xerces/impl/io/ASCIIReader 
.const [87] = Utf8 fBuffer 
.const [88] = Utf8 [B 
.const [89] = Utf8 org/apache/xerces/impl/io/ASCIIReader 
.const [90] = Utf8 fFormatter 
.const [91] = Utf8 Lorg/apache/xerces/util/MessageFormatter; 
.const [92] = Utf8 org/apache/xerces/impl/io/ASCIIReader 
.const [93] = Utf8 fLocale 
.const [94] = Utf8 Ljava/util/Locale; 
.const [95] = Utf8 java/io/InputStream 
.const [96] = Utf8 read 
.const [97] = Utf8 ()I 
.const [98] = Utf8 java/io/InputStream 
.const [99] = Utf8 read 
.const [100] = Utf8 ([BII)I 
.const [101] = Utf8 java/io/InputStream 
.const [102] = Utf8 skip 
.const [103] = Utf8 (J)J 
.const [104] = Utf8 java/io/InputStream 
.const [105] = Utf8 markSupported 
.const [106] = Utf8 ()Z 
.const [107] = Utf8 java/io/InputStream 
.const [108] = Utf8 mark 
.const [109] = Utf8 (I)V 
.const [110] = Utf8 java/io/InputStream 
.const [111] = Utf8 reset 
.const [112] = Utf8 ()V 
.const [113] = Utf8 java/io/InputStream 
.const [114] = Utf8 close 
.const [115] = Utf8 ()V 
.const [116] = Utf8 org/apache/xerces/impl/io/ASCIIReader 
.const [117] = Utf8 <init> 
.const [118] = Utf8 (Ljava/io/InputStream;ILorg/apache/xerces/util/MessageFormatter;Ljava/util/Locale;)V 
.const [119] = Utf8 org/apache/xerces/impl/io/ASCIIReader 
.const [120] = Utf8 <init> 
.const [121] = Utf8 (Ljava/io/InputStream;[BLorg/apache/xerces/util/MessageFormatter;Ljava/util/Locale;)V 
.const [122] = Utf8 java/io/Reader 
.const [123] = Utf8 <init> 
.const [124] = Utf8 ()V 
.const [125] = Utf8 org/apache/xerces/impl/io/MalformedByteSequenceException 
.const [126] = Utf8 <init> 
.const [127] = Utf8 (Lorg/apache/xerces/util/MessageFormatter;Ljava/util/Locale;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V 
.const [128] = Utf8 org/apache/xerces/impl/io/ASCIIReader 
.const [129] = Utf8 fInputStream 
.const [130] = Utf8 Ljava/io/InputStream; 
.const [131] = Utf8 org/apache/xerces/impl/io/ASCIIReader 
.const [132] = Utf8 fBuffer 
.const [133] = Utf8 [B 
.const [134] = Utf8 org/apache/xerces/impl/io/ASCIIReader 
.const [135] = Utf8 fFormatter 
.const [136] = Utf8 Lorg/apache/xerces/util/MessageFormatter; 
.const [137] = Utf8 org/apache/xerces/impl/io/ASCIIReader 
.const [138] = Utf8 fLocale 
.const [139] = Utf8 Ljava/util/Locale; 
.const [140] = Utf8 org/apache/xerces/impl/io/ASCIIReader 
.const [141] = Class [140] 
.const [142] = Utf8 java/io/Reader 
.const [143] = Class [142] 
.const [144] = Utf8 DEFAULT_BUFFER_SIZE 
.const [145] = Utf8 I 
.const [146] = Utf8 fInputStream 
.const [147] = Utf8 Ljava/io/InputStream; 
.const [148] = Utf8 fBuffer 
.const [149] = Utf8 [B 
.const [150] = Utf8 fFormatter 
.const [151] = Utf8 Lorg/apache/xerces/util/MessageFormatter; 
.const [152] = Utf8 fLocale 
.const [153] = Utf8 Ljava/util/Locale; 
.const [154] = Utf8 Code 
.const [155] = Utf8 <init> 
.const [156] = Utf8 (Ljava/io/InputStream;Lorg/apache/xerces/util/MessageFormatter;Ljava/util/Locale;)V 
.const [157] = Utf8 <init> 
.const [158] = Utf8 (Ljava/io/InputStream;ILorg/apache/xerces/util/MessageFormatter;Ljava/util/Locale;)V 
.const [159] = Utf8 <init> 
.const [160] = Utf8 (Ljava/io/InputStream;[BLorg/apache/xerces/util/MessageFormatter;Ljava/util/Locale;)V 
.const [161] = Utf8 read 
.const [162] = Utf8 ()I 
.const [163] = Utf8 read 
.const [164] = Utf8 ([CII)I 
.const [165] = Utf8 skip 
.const [166] = Utf8 (J)J 
.const [167] = Utf8 ready 
.const [168] = Utf8 ()Z 
.const [169] = Utf8 markSupported 
.const [170] = Utf8 ()Z 
.const [171] = Utf8 mark 
.const [172] = Utf8 (I)V 
.const [173] = Utf8 reset 
.const [174] = Utf8 ()V 
.const [175] = Utf8 close 
.const [176] = Utf8 ()V 
.end class 
