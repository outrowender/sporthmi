.version 50 0 
.class super [97] 
.super [99] 
.field [100] [101] 

.method public [103] : [104] 
    .attribute [102] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [17] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [22] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [105] : [106] 
    .attribute [102] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     invokevirtual [13] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [107] : [108] 
    .attribute [102] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     invokevirtual [14] 
L7:     aload_0 
L8:     invokespecial [18] 
L11:    return 
L12:    
    .end code 
.end method 

.method public [109] : [110] 
    .attribute [102] .code stack 4 locals 2 
L0:     iconst_1 
L1:     newarray byte 
L3:     astore_1 
L4:     aload_0 
L5:     getfield [12] 
L8:     aload_1 
L9:     iconst_0 
L10:    iconst_1 
L11:    invokevirtual [15] 
L14:    istore_2 
L15:    iconst_m1 
L16:    iload_2 
L17:    if_icmpne L24 
L20:    iload_2 
L21:    goto L31 
L24:    aload_1 
L25:    iconst_0 
L26:    baload 
L27:    sipush 255 
L30:    iand 
L31:    areturn 
L32:    
    .end code 
.end method 

.method public [111] : [112] 
    .attribute [102] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iconst_0 
L3:     aload_1 
L4:     arraylength 
L5:     invokevirtual [16] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [113] : [114] 
    .attribute [102] .code stack 4 locals 0 
L0:     aload_1 
L1:     ifnonnull L17 
L4:     new [23] 
L7:     dup 
L8:     ldc [6] 
L10:    invokestatic [8] 
L13:    invokespecial [19] 
L16:    athrow 
L17:    iload_3 
L18:    ifne L23 
L21:    iconst_0 
L22:    areturn 
L23:    iload_2 
L24:    iflt L33 
L27:    iload_2 
L28:    aload_1 
L29:    arraylength 
L30:    if_icmplt L46 
L33:    new [24] 
L36:    dup 
L37:    ldc [10] 
L39:    invokestatic [8] 
L42:    invokespecial [20] 
L45:    athrow 
L46:    iload_3 
L47:    iflt L58 
L50:    iload_2 
L51:    iload_3 
L52:    iadd 
L53:    aload_1 
L54:    arraylength 
L55:    if_icmple L71 
L58:    new [24] 
L61:    dup 
L62:    ldc [11] 
L64:    invokestatic [8] 
L67:    invokespecial [20] 
L70:    athrow 
L71:    aload_0 
L72:    getfield [12] 
L75:    aload_1 
L76:    iload_2 
L77:    iload_3 
L78:    invokevirtual [15] 
L81:    areturn 
L82:    nop 
L83:    nop 
L84:    
    .end code 
.end method 

.method public [115] : [116] 
    .attribute [102] .code stack 4 locals 0 
L0:     lconst_0 
L1:     lload_1 
L2:     lcmp 
L3:     ifne L10 
L6:     lconst_0 
L7:     goto L15 
L10:    aload_0 
L11:    lload_1 
L12:    invokespecial [21] 
L15:    freturn 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [25] 
.const [3] = Class [26] 
.const [4] = Class [27] 
.const [5] = Class [28] 
.const [6] = String [29] 
.const [7] = Class [30] 
.const [8] = Method [31] [32] 
.const [9] = Class [33] 
.const [10] = String [34] 
.const [11] = String [35] 
.const [12] = Field [36] [37] 
.const [13] = Method [38] [39] 
.const [14] = Method [40] [41] 
.const [15] = Method [42] [43] 
.const [16] = Method [44] [45] 
.const [17] = Method [46] [47] 
.const [18] = Method [48] [49] 
.const [19] = Method [50] [51] 
.const [20] = Method [52] [53] 
.const [21] = Method [54] [55] 
.const [22] = Field [56] [57] 
.const [23] = Class [58] 
.const [24] = Class [59] 
.const [25] = Utf8 java/net/SocketInputStream 
.const [26] = Utf8 java/io/InputStream 
.const [27] = Utf8 java/io/IOException 
.const [28] = Utf8 java/net/SocketImpl 
.const [29] = Utf8 K0047 
.const [30] = Utf8 com/ibm/oti/util/Msg 
.const [31] = Class [60] 
.const [32] = NameAndType [61] [62] 
.const [33] = Utf8 java/lang/ArrayIndexOutOfBoundsException 
.const [34] = Utf8 K002e 
.const [35] = Utf8 K002f 
.const [36] = Class [63] 
.const [37] = NameAndType [64] [65] 
.const [38] = Class [66] 
.const [39] = NameAndType [67] [68] 
.const [40] = Class [69] 
.const [41] = NameAndType [70] [71] 
.const [42] = Class [72] 
.const [43] = NameAndType [73] [74] 
.const [44] = Class [75] 
.const [45] = NameAndType [76] [77] 
.const [46] = Class [78] 
.const [47] = NameAndType [79] [80] 
.const [48] = Class [81] 
.const [49] = NameAndType [82] [83] 
.const [50] = Class [84] 
.const [51] = NameAndType [85] [86] 
.const [52] = Class [87] 
.const [53] = NameAndType [88] [89] 
.const [54] = Class [90] 
.const [55] = NameAndType [91] [92] 
.const [56] = Class [93] 
.const [57] = NameAndType [94] [95] 
.const [58] = Utf8 java/io/IOException 
.const [59] = Utf8 java/lang/ArrayIndexOutOfBoundsException 
.const [60] = Utf8 com/ibm/oti/util/Msg 
.const [61] = Utf8 getString 
.const [62] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [63] = Utf8 java/net/SocketInputStream 
.const [64] = Utf8 socket 
.const [65] = Utf8 Ljava/net/SocketImpl; 
.const [66] = Utf8 java/net/SocketImpl 
.const [67] = Utf8 available 
.const [68] = Utf8 ()I 
.const [69] = Utf8 java/net/SocketImpl 
.const [70] = Utf8 close 
.const [71] = Utf8 ()V 
.const [72] = Utf8 java/net/SocketImpl 
.const [73] = Utf8 read 
.const [74] = Utf8 ([BII)I 
.const [75] = Utf8 java/net/SocketInputStream 
.const [76] = Utf8 read 
.const [77] = Utf8 ([BII)I 
.const [78] = Utf8 java/io/InputStream 
.const [79] = Utf8 <init> 
.const [80] = Utf8 ()V 
.const [81] = Utf8 java/io/InputStream 
.const [82] = Utf8 close 
.const [83] = Utf8 ()V 
.const [84] = Utf8 java/io/IOException 
.const [85] = Utf8 <init> 
.const [86] = Utf8 (Ljava/lang/String;)V 
.const [87] = Utf8 java/lang/ArrayIndexOutOfBoundsException 
.const [88] = Utf8 <init> 
.const [89] = Utf8 (Ljava/lang/String;)V 
.const [90] = Utf8 java/io/InputStream 
.const [91] = Utf8 skip 
.const [92] = Utf8 (J)J 
.const [93] = Utf8 java/net/SocketInputStream 
.const [94] = Utf8 socket 
.const [95] = Utf8 Ljava/net/SocketImpl; 
.const [96] = Utf8 java/net/SocketInputStream 
.const [97] = Class [96] 
.const [98] = Utf8 java/io/InputStream 
.const [99] = Class [98] 
.const [100] = Utf8 socket 
.const [101] = Utf8 Ljava/net/SocketImpl; 
.const [102] = Utf8 Code 
.const [103] = Utf8 <init> 
.const [104] = Utf8 (Ljava/net/SocketImpl;)V 
.const [105] = Utf8 available 
.const [106] = Utf8 ()I 
.const [107] = Utf8 close 
.const [108] = Utf8 ()V 
.const [109] = Utf8 read 
.const [110] = Utf8 ()I 
.const [111] = Utf8 read 
.const [112] = Utf8 ([B)I 
.const [113] = Utf8 read 
.const [114] = Utf8 ([BII)I 
.const [115] = Utf8 skip 
.const [116] = Utf8 (J)J 
.end class 
