.version 50 0 
.class super [97] 
.super [99] 
.field [100] [101] 
.field final synthetic [102] [103] 

.method public [105] : [106] 
    .attribute [104] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [15] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [18] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [19] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [107] : [108] 
    .attribute [104] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [7] 
L4:     invokevirtual [9] 
L7:     aload_0 
L8:     iconst_0 
L9:     putfield [19] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [109] : [110] 
    .attribute [104] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [7] 
L4:     getfield [10] 
L7:     invokevirtual [11] 
L10:    istore_1 
L11:    iload_1 
L12:    aload_0 
L13:    getfield [8] 
L16:    if_icmple L24 
L19:    aload_0 
L20:    getfield [8] 
L23:    areturn 
L24:    iload_1 
L25:    areturn 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [111] : [112] 
    .attribute [104] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [8] 
L4:     ifgt L9 
L7:     iconst_m1 
L8:     areturn 
L9:     aload_0 
L10:    getfield [7] 
L13:    getfield [10] 
L16:    invokevirtual [12] 
L19:    istore_1 
L20:    aload_0 
L21:    dup 
L22:    getfield [8] 
L25:    iconst_1 
L26:    isub 
L27:    putfield [19] 
L30:    iload_1 
L31:    areturn 
L32:    
    .end code 
.end method 

.method public [113] : [114] 
    .attribute [104] .code stack 4 locals 1 
L0:     aload_1 
L1:     ifnonnull L12 
L4:     new [20] 
L7:     dup 
L8:     invokespecial [16] 
L11:    athrow 
L12:    iload_2 
L13:    iflt L34 
L16:    iload_3 
L17:    iflt L34 
L20:    iload_2 
L21:    aload_1 
L22:    arraylength 
L23:    if_icmpgt L34 
L26:    aload_1 
L27:    arraylength 
L28:    iload_2 
L29:    isub 
L30:    iload_3 
L31:    if_icmpge L42 
L34:    new [21] 
L37:    dup 
L38:    invokespecial [17] 
L41:    athrow 
L42:    aload_0 
L43:    getfield [8] 
L46:    ifgt L51 
L49:    iconst_m1 
L50:    areturn 
L51:    iload_3 
L52:    aload_0 
L53:    getfield [8] 
L56:    if_icmple L64 
L59:    aload_0 
L60:    getfield [8] 
L63:    istore_3 
L64:    aload_0 
L65:    getfield [7] 
L68:    getfield [10] 
L71:    aload_1 
L72:    iload_2 
L73:    iload_3 
L74:    invokevirtual [13] 
L77:    istore 4 
L79:    iload 4 
L81:    ifle L95 
L84:    aload_0 
L85:    dup 
L86:    getfield [8] 
L89:    iload 4 
L91:    isub 
L92:    putfield [19] 
L95:    iload 4 
L97:    areturn 
L98:    nop 
L99:    nop 
L100:   
    .end code 
.end method 

.method public [115] : [116] 
    .attribute [104] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [8] 
L4:     ifgt L11 
L7:     ldc2_w [22] 
L10:    freturn 
L11:    iload_1 
L12:    aload_0 
L13:    getfield [8] 
L16:    if_icmple L24 
L19:    aload_0 
L20:    getfield [8] 
L23:    istore_1 
L24:    aload_0 
L25:    getfield [7] 
L28:    getfield [10] 
L31:    iload_1 
L32:    i2l 
L33:    invokevirtual [14] 
L36:    lstore_2 
L37:    lload_2 
L38:    lconst_0 
L39:    lcmp 
L40:    ifle L55 
L43:    aload_0 
L44:    dup 
L45:    getfield [8] 
L48:    i2l 
L49:    lload_2 
L50:    lsub 
L51:    l2i 
L52:    putfield [19] 
L55:    lload_2 
L56:    freturn 
L57:    nop 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [24] 
.const [3] = Class [25] 
.const [4] = Class [26] 
.const [5] = Class [27] 
.const [6] = Class [28] 
.const [7] = Field [29] [30] 
.const [8] = Field [31] [32] 
.const [9] = Method [33] [34] 
.const [10] = Field [35] [36] 
.const [11] = Method [37] [38] 
.const [12] = Method [39] [40] 
.const [13] = Method [41] [42] 
.const [14] = Method [43] [44] 
.const [15] = Method [45] [46] 
.const [16] = Method [47] [48] 
.const [17] = Method [49] [50] 
.const [18] = Field [51] [52] 
.const [19] = Field [53] [54] 
.const [20] = Class [55] 
.const [21] = Class [56] 
.const [22] = Long -1L 
.const [24] = Utf8 com/ibm/oti/net/www/protocol/http/HttpURLConnection$LimitedInputStream 
.const [25] = Utf8 java/io/InputStream 
.const [26] = Utf8 com/ibm/oti/net/www/protocol/http/HttpURLConnection 
.const [27] = Utf8 java/lang/NullPointerException 
.const [28] = Utf8 java/lang/ArrayIndexOutOfBoundsException 
.const [29] = Class [57] 
.const [30] = NameAndType [58] [59] 
.const [31] = Class [60] 
.const [32] = NameAndType [61] [62] 
.const [33] = Class [63] 
.const [34] = NameAndType [64] [65] 
.const [35] = Class [66] 
.const [36] = NameAndType [67] [68] 
.const [37] = Class [69] 
.const [38] = NameAndType [70] [71] 
.const [39] = Class [72] 
.const [40] = NameAndType [73] [74] 
.const [41] = Class [75] 
.const [42] = NameAndType [76] [77] 
.const [43] = Class [78] 
.const [44] = NameAndType [79] [80] 
.const [45] = Class [81] 
.const [46] = NameAndType [82] [83] 
.const [47] = Class [84] 
.const [48] = NameAndType [85] [86] 
.const [49] = Class [87] 
.const [50] = NameAndType [88] [89] 
.const [51] = Class [90] 
.const [52] = NameAndType [91] [92] 
.const [53] = Class [93] 
.const [54] = NameAndType [94] [95] 
.const [55] = Utf8 java/lang/NullPointerException 
.const [56] = Utf8 java/lang/ArrayIndexOutOfBoundsException 
.const [57] = Utf8 com/ibm/oti/net/www/protocol/http/HttpURLConnection$LimitedInputStream 
.const [58] = Utf8 this$0 
.const [59] = Utf8 Lcom/ibm/oti/net/www/protocol/http/HttpURLConnection; 
.const [60] = Utf8 com/ibm/oti/net/www/protocol/http/HttpURLConnection$LimitedInputStream 
.const [61] = Utf8 bytesRemaining 
.const [62] = Utf8 I 
.const [63] = Utf8 com/ibm/oti/net/www/protocol/http/HttpURLConnection 
.const [64] = Utf8 closeSocket 
.const [65] = Utf8 ()V 
.const [66] = Utf8 com/ibm/oti/net/www/protocol/http/HttpURLConnection 
.const [67] = Utf8 is 
.const [68] = Utf8 Ljava/io/InputStream; 
.const [69] = Utf8 java/io/InputStream 
.const [70] = Utf8 available 
.const [71] = Utf8 ()I 
.const [72] = Utf8 java/io/InputStream 
.const [73] = Utf8 read 
.const [74] = Utf8 ()I 
.const [75] = Utf8 java/io/InputStream 
.const [76] = Utf8 read 
.const [77] = Utf8 ([BII)I 
.const [78] = Utf8 java/io/InputStream 
.const [79] = Utf8 skip 
.const [80] = Utf8 (J)J 
.const [81] = Utf8 java/io/InputStream 
.const [82] = Utf8 <init> 
.const [83] = Utf8 ()V 
.const [84] = Utf8 java/lang/NullPointerException 
.const [85] = Utf8 <init> 
.const [86] = Utf8 ()V 
.const [87] = Utf8 java/lang/ArrayIndexOutOfBoundsException 
.const [88] = Utf8 <init> 
.const [89] = Utf8 ()V 
.const [90] = Utf8 com/ibm/oti/net/www/protocol/http/HttpURLConnection$LimitedInputStream 
.const [91] = Utf8 this$0 
.const [92] = Utf8 Lcom/ibm/oti/net/www/protocol/http/HttpURLConnection; 
.const [93] = Utf8 com/ibm/oti/net/www/protocol/http/HttpURLConnection$LimitedInputStream 
.const [94] = Utf8 bytesRemaining 
.const [95] = Utf8 I 
.const [96] = Utf8 com/ibm/oti/net/www/protocol/http/HttpURLConnection$LimitedInputStream 
.const [97] = Class [96] 
.const [98] = Utf8 java/io/InputStream 
.const [99] = Class [98] 
.const [100] = Utf8 bytesRemaining 
.const [101] = Utf8 I 
.const [102] = Utf8 this$0 
.const [103] = Utf8 Lcom/ibm/oti/net/www/protocol/http/HttpURLConnection; 
.const [104] = Utf8 Code 
.const [105] = Utf8 <init> 
.const [106] = Utf8 (Lcom/ibm/oti/net/www/protocol/http/HttpURLConnection;I)V 
.const [107] = Utf8 close 
.const [108] = Utf8 ()V 
.const [109] = Utf8 available 
.const [110] = Utf8 ()I 
.const [111] = Utf8 read 
.const [112] = Utf8 ()I 
.const [113] = Utf8 read 
.const [114] = Utf8 ([BII)I 
.const [115] = Utf8 skip 
.const [116] = Utf8 (I)J 
.end class 
