.version 50 0 
.class public super [67] 
.super [69] 
.field public static final [70] [71] 
.field public static final [72] [73] 
.field public static final [74] [75] 
.field public static final [76] [77] 
.field public static final [78] [79] 
.field public static final [80] [81] 
.field public static final [82] [83] 
.field public static final [84] [85] 
.field public static final [86] [87] 
.field public static final [88] [89] 
.field public [90] [91] 
.field public [92] [93] 

.method public annotation [95] : [96] 
    .attribute [94] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [13] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [97] : [98] 
    .attribute [94] .code stack 3 locals 2 
L0:     aload_0 
L1:     invokespecial [13] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [9] 
L9:     i2b 
L10:    putfield [14] 
L13:    iconst_3 
L14:    newarray byte 
L16:    astore_2 
L17:    aload_1 
L18:    aload_2 
L19:    invokevirtual [11] 
L22:    pop 
L23:    aload_2 
L24:    iconst_0 
L25:    iconst_3 
L26:    invokestatic [6] 
L29:    l2i 
L30:    istore_3 
L31:    aload_0 
L32:    iload_3 
L33:    newarray byte 
L35:    putfield [15] 
L38:    aload_1 
L39:    aload_0 
L40:    getfield [12] 
L43:    invokevirtual [11] 
L46:    pop 
L47:    return 
L48:    
    .end code 
.end method 

.method public [99] : [100] 
    .attribute [94] .code stack 5 locals 2 
L0:     aload_0 
L1:     invokespecial [13] 
L4:     aload_0 
L5:     aload_1 
L6:     iconst_0 
L7:     baload 
L8:     putfield [14] 
L11:    aload_1 
L12:    iconst_1 
L13:    iconst_3 
L14:    invokestatic [6] 
L17:    l2i 
L18:    istore_2 
L19:    iload_2 
L20:    newarray byte 
L22:    astore_3 
L23:    aload_1 
L24:    iconst_4 
L25:    aload_3 
L26:    iconst_0 
L27:    iload_2 
L28:    invokestatic [8] 
L31:    return 
L32:    
    .end code 
.end method 

.method public [101] : [102] 
    .attribute [94] .code stack 5 locals 1 
L0:     iconst_4 
L1:     aload_0 
L2:     getfield [12] 
L5:     arraylength 
L6:     iadd 
L7:     newarray byte 
L9:     astore_1 
L10:    aload_1 
L11:    iconst_0 
L12:    aload_0 
L13:    getfield [10] 
L16:    bastore 
L17:    aload_1 
L18:    iconst_1 
L19:    aload_0 
L20:    getfield [12] 
L23:    arraylength 
L24:    bipush 16 
L26:    ishr 
L27:    sipush 255 
L30:    iand 
L31:    i2b 
L32:    bastore 
L33:    aload_1 
L34:    iconst_2 
L35:    aload_0 
L36:    getfield [12] 
L39:    arraylength 
L40:    bipush 8 
L42:    ishr 
L43:    sipush 255 
L46:    iand 
L47:    i2b 
L48:    bastore 
L49:    aload_1 
L50:    iconst_3 
L51:    aload_0 
L52:    getfield [12] 
L55:    arraylength 
L56:    sipush 255 
L59:    iand 
L60:    i2b 
L61:    bastore 
L62:    aload_0 
L63:    getfield [12] 
L66:    iconst_0 
L67:    aload_1 
L68:    iconst_4 
L69:    aload_0 
L70:    getfield [12] 
L73:    arraylength 
L74:    invokestatic [8] 
L77:    aload_1 
L78:    areturn 
L79:    nop 
L80:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [16] 
.const [3] = Class [17] 
.const [4] = Class [18] 
.const [5] = Class [19] 
.const [6] = Method [20] [21] 
.const [7] = Class [22] 
.const [8] = Method [23] [24] 
.const [9] = Method [25] [26] 
.const [10] = Field [27] [28] 
.const [11] = Method [29] [30] 
.const [12] = Field [31] [32] 
.const [13] = Method [33] [34] 
.const [14] = Field [35] [36] 
.const [15] = Field [37] [38] 
.const [16] = Utf8 com/ibm/j9/ssl/HandshakeMessage 
.const [17] = Utf8 java/lang/Object 
.const [18] = Utf8 java/io/InputStream 
.const [19] = Utf8 com/ibm/j9/ssl/Util 
.const [20] = Class [39] 
.const [21] = NameAndType [40] [41] 
.const [22] = Utf8 java/lang/System 
.const [23] = Class [42] 
.const [24] = NameAndType [43] [44] 
.const [25] = Class [45] 
.const [26] = NameAndType [46] [47] 
.const [27] = Class [48] 
.const [28] = NameAndType [49] [50] 
.const [29] = Class [51] 
.const [30] = NameAndType [52] [53] 
.const [31] = Class [54] 
.const [32] = NameAndType [55] [56] 
.const [33] = Class [57] 
.const [34] = NameAndType [58] [59] 
.const [35] = Class [60] 
.const [36] = NameAndType [61] [62] 
.const [37] = Class [63] 
.const [38] = NameAndType [64] [65] 
.const [39] = Utf8 com/ibm/j9/ssl/Util 
.const [40] = Utf8 getLong 
.const [41] = Utf8 ([BII)J 
.const [42] = Utf8 java/lang/System 
.const [43] = Utf8 arraycopy 
.const [44] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [45] = Utf8 java/io/InputStream 
.const [46] = Utf8 read 
.const [47] = Utf8 ()I 
.const [48] = Utf8 com/ibm/j9/ssl/HandshakeMessage 
.const [49] = Utf8 type 
.const [50] = Utf8 B 
.const [51] = Utf8 java/io/InputStream 
.const [52] = Utf8 read 
.const [53] = Utf8 ([B)I 
.const [54] = Utf8 com/ibm/j9/ssl/HandshakeMessage 
.const [55] = Utf8 rawData 
.const [56] = Utf8 [B 
.const [57] = Utf8 java/lang/Object 
.const [58] = Utf8 <init> 
.const [59] = Utf8 ()V 
.const [60] = Utf8 com/ibm/j9/ssl/HandshakeMessage 
.const [61] = Utf8 type 
.const [62] = Utf8 B 
.const [63] = Utf8 com/ibm/j9/ssl/HandshakeMessage 
.const [64] = Utf8 rawData 
.const [65] = Utf8 [B 
.const [66] = Utf8 com/ibm/j9/ssl/HandshakeMessage 
.const [67] = Class [66] 
.const [68] = Utf8 java/lang/Object 
.const [69] = Class [68] 
.const [70] = Utf8 HELLO_REQUEST 
.const [71] = Utf8 B 
.const [72] = Utf8 CLIENT_HELLO 
.const [73] = Utf8 B 
.const [74] = Utf8 SERVER_HELLO 
.const [75] = Utf8 B 
.const [76] = Utf8 CERTIFICATE 
.const [77] = Utf8 B 
.const [78] = Utf8 SERVER_KEY_EXCHANGE 
.const [79] = Utf8 B 
.const [80] = Utf8 CERTIFICATE_REQUEST 
.const [81] = Utf8 B 
.const [82] = Utf8 SERVER_HELLO_DONE 
.const [83] = Utf8 B 
.const [84] = Utf8 CERTIFICATE_VERIFY 
.const [85] = Utf8 B 
.const [86] = Utf8 CLIENT_KEY_EXCHANGE 
.const [87] = Utf8 B 
.const [88] = Utf8 FINISHED 
.const [89] = Utf8 B 
.const [90] = Utf8 type 
.const [91] = Utf8 B 
.const [92] = Utf8 rawData 
.const [93] = Utf8 [B 
.const [94] = Utf8 Code 
.const [95] = Utf8 <init> 
.const [96] = Utf8 ()V 
.const [97] = Utf8 <init> 
.const [98] = Utf8 (Ljava/io/InputStream;)V 
.const [99] = Utf8 <init> 
.const [100] = Utf8 ([B)V 
.const [101] = Utf8 toByteArray 
.const [102] = Utf8 ()[B 
.end class 
