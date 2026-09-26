.version 50 0 
.class public super [115] 
.super [117] 
.field private static final [118] [119] 
.field private static final [120] [121] 
.field private transient [122] [123] 
.field private [124] [125] 
.field private [126] [127] 

.method static [129] : [130] 
    .attribute [128] .code stack 1 locals 0 
L0:     iconst_0 
L1:     newarray byte 
L3:     putstatic [16] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [131] : [132] 
    .attribute [128] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [17] 
L4:     aload_0 
L5:     new [21] 
L8:     dup 
L9:     invokespecial [18] 
L12:    putfield [22] 
L15:    aload_0 
L16:    bipush 20 
L18:    putfield [23] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method protected [133] : [134] 
    .attribute [128] .code stack 3 locals 2 
L0:     iload_1 
L1:     ifge L12 
L4:     new [24] 
L7:     dup 
L8:     invokespecial [19] 
L11:    athrow 
L12:    iload_1 
L13:    newarray byte 
L15:    astore_2 
L16:    iconst_0 
L17:    istore_3 
L18:    goto L31 
L21:    aload_2 
L22:    iload_3 
L23:    invokestatic [7] 
L26:    i2b 
L27:    bastore 
L28:    iinc 3 1 
L31:    iload_3 
L32:    aload_2 
L33:    arraylength 
L34:    if_icmplt L21 
L37:    aload_2 
L38:    areturn 
L39:    nop 
L40:    
    .end code 
.end method 

.method protected [135] : [136] 
    .attribute [128] .code stack 5 locals 4 
L0:     aload_0 
L1:     getfield [12] 
L4:     ifnonnull L17 
L7:     aload_0 
L8:     aload_0 
L9:     bipush 20 
L11:    invokevirtual [13] 
L14:    putfield [25] 
L17:    aload_1 
L18:    arraylength 
L19:    istore_2 
L20:    iconst_0 
L21:    istore_3 
L22:    bipush 20 
L24:    aload_0 
L25:    getfield [11] 
L28:    isub 
L29:    istore 4 
L31:    goto L110 
L34:    aload_0 
L35:    getfield [11] 
L38:    aload_0 
L39:    getfield [12] 
L42:    arraylength 
L43:    if_icmplt L63 
L46:    aload_0 
L47:    aload_0 
L48:    getfield [12] 
L51:    invokespecial [20] 
L54:    aload_0 
L55:    iconst_0 
L56:    putfield [23] 
L59:    bipush 20 
L61:    istore 4 
L63:    iload_2 
L64:    iload_3 
L65:    isub 
L66:    istore 5 
L68:    iload 5 
L70:    iload 4 
L72:    if_icmple L79 
L75:    iload 4 
L77:    istore 5 
L79:    aload_0 
L80:    getfield [12] 
L83:    aload_0 
L84:    getfield [11] 
L87:    aload_1 
L88:    iload_3 
L89:    iload 5 
L91:    invokestatic [9] 
L94:    iload_3 
L95:    iload 5 
L97:    iadd 
L98:    istore_3 
L99:    aload_0 
L100:   dup 
L101:   getfield [11] 
L104:   iload 5 
L106:   iadd 
L107:   putfield [23] 
L110:   iload_3 
L111:   iload_2 
L112:   if_icmplt L34 
L115:   return 
L116:   
    .end code 
.end method 

.method protected [137] : [138] 
    .attribute [128] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     ifnull L24 
L7:     aload_0 
L8:     getfield [10] 
L11:    aload_0 
L12:    getfield [12] 
L15:    iconst_0 
L16:    aload_0 
L17:    getfield [12] 
L20:    arraylength 
L21:    invokevirtual [14] 
L24:    aload_0 
L25:    aload_1 
L26:    invokespecial [20] 
L29:    aload_0 
L30:    bipush 20 
L32:    putfield [23] 
L35:    return 
L36:    
    .end code 
.end method 

.method private [139] : [140] 
    .attribute [128] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     aload_1 
L5:     iconst_0 
L6:     aload_1 
L7:     arraylength 
L8:     invokevirtual [14] 
L11:    aload_0 
L12:    aload_0 
L13:    getfield [10] 
L16:    invokevirtual [15] 
L19:    putfield [25] 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [26] 
.const [3] = Class [27] 
.const [4] = Class [28] 
.const [5] = Class [29] 
.const [6] = Class [30] 
.const [7] = Method [31] [32] 
.const [8] = Class [33] 
.const [9] = Method [34] [35] 
.const [10] = Field [36] [37] 
.const [11] = Field [38] [39] 
.const [12] = Field [40] [41] 
.const [13] = Method [42] [43] 
.const [14] = Method [44] [45] 
.const [15] = Method [46] [47] 
.const [16] = Field [48] [49] 
.const [17] = Method [50] [51] 
.const [18] = Method [52] [53] 
.const [19] = Method [54] [55] 
.const [20] = Method [56] [57] 
.const [21] = Class [58] 
.const [22] = Field [59] [60] 
.const [23] = Field [61] [62] 
.const [24] = Class [63] 
.const [25] = Field [64] [65] 
.const [26] = Utf8 com/ibm/oti/security/provider/SecureRandomSHA1PRNG 
.const [27] = Utf8 java/security/SecureRandomSpi 
.const [28] = Utf8 com/ibm/oti/util/SHAOutputStream 
.const [29] = Utf8 java/lang/IllegalArgumentException 
.const [30] = Utf8 com/ibm/j9/bluez/crypto/CL3 
.const [31] = Class [66] 
.const [32] = NameAndType [67] [68] 
.const [33] = Utf8 java/lang/System 
.const [34] = Class [69] 
.const [35] = NameAndType [70] [71] 
.const [36] = Class [72] 
.const [37] = NameAndType [73] [74] 
.const [38] = Class [75] 
.const [39] = NameAndType [76] [77] 
.const [40] = Class [78] 
.const [41] = NameAndType [79] [80] 
.const [42] = Class [81] 
.const [43] = NameAndType [82] [83] 
.const [44] = Class [84] 
.const [45] = NameAndType [85] [86] 
.const [46] = Class [87] 
.const [47] = NameAndType [88] [89] 
.const [48] = Class [90] 
.const [49] = NameAndType [91] [92] 
.const [50] = Class [93] 
.const [51] = NameAndType [94] [95] 
.const [52] = Class [96] 
.const [53] = NameAndType [97] [98] 
.const [54] = Class [99] 
.const [55] = NameAndType [100] [101] 
.const [56] = Class [102] 
.const [57] = NameAndType [103] [104] 
.const [58] = Utf8 com/ibm/oti/util/SHAOutputStream 
.const [59] = Class [105] 
.const [60] = NameAndType [106] [107] 
.const [61] = Class [108] 
.const [62] = NameAndType [109] [110] 
.const [63] = Utf8 java/lang/IllegalArgumentException 
.const [64] = Class [111] 
.const [65] = NameAndType [112] [113] 
.const [66] = Utf8 com/ibm/j9/bluez/crypto/CL3 
.const [67] = Utf8 trngNextByte 
.const [68] = Utf8 ()I 
.const [69] = Utf8 java/lang/System 
.const [70] = Utf8 arraycopy 
.const [71] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [72] = Utf8 com/ibm/oti/security/provider/SecureRandomSHA1PRNG 
.const [73] = Utf8 sha 
.const [74] = Utf8 Lcom/ibm/oti/util/SHAOutputStream; 
.const [75] = Utf8 com/ibm/oti/security/provider/SecureRandomSHA1PRNG 
.const [76] = Utf8 count 
.const [77] = Utf8 I 
.const [78] = Utf8 com/ibm/oti/security/provider/SecureRandomSHA1PRNG 
.const [79] = Utf8 state 
.const [80] = Utf8 [B 
.const [81] = Utf8 com/ibm/oti/security/provider/SecureRandomSHA1PRNG 
.const [82] = Utf8 engineGenerateSeed 
.const [83] = Utf8 (I)[B 
.const [84] = Utf8 com/ibm/oti/util/SHAOutputStream 
.const [85] = Utf8 write 
.const [86] = Utf8 ([BII)V 
.const [87] = Utf8 com/ibm/oti/util/SHAOutputStream 
.const [88] = Utf8 getHashAsBytes 
.const [89] = Utf8 ()[B 
.const [90] = Utf8 com/ibm/oti/security/provider/SecureRandomSHA1PRNG 
.const [91] = Utf8 NO_SEED 
.const [92] = Utf8 [B 
.const [93] = Utf8 java/security/SecureRandomSpi 
.const [94] = Utf8 <init> 
.const [95] = Utf8 ()V 
.const [96] = Utf8 com/ibm/oti/util/SHAOutputStream 
.const [97] = Utf8 <init> 
.const [98] = Utf8 ()V 
.const [99] = Utf8 java/lang/IllegalArgumentException 
.const [100] = Utf8 <init> 
.const [101] = Utf8 ()V 
.const [102] = Utf8 com/ibm/oti/security/provider/SecureRandomSHA1PRNG 
.const [103] = Utf8 digestData 
.const [104] = Utf8 ([B)V 
.const [105] = Utf8 com/ibm/oti/security/provider/SecureRandomSHA1PRNG 
.const [106] = Utf8 sha 
.const [107] = Utf8 Lcom/ibm/oti/util/SHAOutputStream; 
.const [108] = Utf8 com/ibm/oti/security/provider/SecureRandomSHA1PRNG 
.const [109] = Utf8 count 
.const [110] = Utf8 I 
.const [111] = Utf8 com/ibm/oti/security/provider/SecureRandomSHA1PRNG 
.const [112] = Utf8 state 
.const [113] = Utf8 [B 
.const [114] = Utf8 com/ibm/oti/security/provider/SecureRandomSHA1PRNG 
.const [115] = Class [114] 
.const [116] = Utf8 java/security/SecureRandomSpi 
.const [117] = Class [116] 
.const [118] = Utf8 SHA_SIZE 
.const [119] = Utf8 I 
.const [120] = Utf8 NO_SEED 
.const [121] = Utf8 [B 
.const [122] = Utf8 sha 
.const [123] = Utf8 Lcom/ibm/oti/util/SHAOutputStream; 
.const [124] = Utf8 count 
.const [125] = Utf8 I 
.const [126] = Utf8 state 
.const [127] = Utf8 [B 
.const [128] = Utf8 Code 
.const [129] = Utf8 <clinit> 
.const [130] = Utf8 ()V 
.const [131] = Utf8 <init> 
.const [132] = Utf8 ()V 
.const [133] = Utf8 engineGenerateSeed 
.const [134] = Utf8 (I)[B 
.const [135] = Utf8 engineNextBytes 
.const [136] = Utf8 ([B)V 
.const [137] = Utf8 engineSetSeed 
.const [138] = Utf8 ([B)V 
.const [139] = Utf8 digestData 
.const [140] = Utf8 ([B)V 
.end class 
