.version 50 0 
.class final super [133] 
.super [135] 
.field private final [136] [137] 
.field final synthetic [138] [139] 

.method [141] : [142] 
    .attribute [140] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [23] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [25] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [26] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [143] : [144] 
    .attribute [140] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     getfield [12] 
L7:     iconst_2 
L8:     if_icmpne L24 
L11:    new [27] 
L14:    dup 
L15:    ldc [6] 
L17:    invokestatic [8] 
L20:    invokespecial [24] 
L23:    athrow 
L24:    aload_0 
L25:    getfield [11] 
L28:    invokevirtual [13] 
L31:    invokevirtual [14] 
L34:    ifne L60 
L37:    aload_0 
L38:    getfield [10] 
L41:    getfield [15] 
L44:    ifnonnull L60 
L47:    iconst_m1 
L48:    areturn 
L49:    goto L60 
L52:    aload_0 
L53:    getfield [10] 
L56:    invokevirtual [16] 
L59:    pop 
L60:    aload_0 
L61:    getfield [11] 
L64:    invokevirtual [13] 
L67:    invokevirtual [14] 
L70:    ifne L96 
L73:    aload_0 
L74:    getfield [10] 
L77:    getfield [15] 
L80:    ifnull L96 
L83:    aload_0 
L84:    getfield [10] 
L87:    getfield [15] 
L90:    invokevirtual [14] 
L93:    ifgt L52 
L96:    aload_0 
L97:    getfield [11] 
L100:   invokevirtual [13] 
L103:   invokevirtual [14] 
L106:   areturn 
L107:   nop 
L108:   
    .end code 
.end method 

.method public [145] : [146] 
    .attribute [140] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     getfield [12] 
L7:     iconst_2 
L8:     if_icmpne L35 
L11:    new [27] 
L14:    dup 
L15:    ldc [6] 
L17:    invokestatic [8] 
L20:    invokespecial [24] 
L23:    athrow 
L24:    goto L35 
L27:    aload_0 
L28:    getfield [10] 
L31:    invokevirtual [16] 
L34:    pop 
L35:    aload_0 
L36:    getfield [11] 
L39:    invokevirtual [13] 
L42:    invokevirtual [14] 
L45:    ifne L58 
L48:    aload_0 
L49:    getfield [10] 
L52:    getfield [15] 
L55:    ifnonnull L27 
L58:    aload_0 
L59:    getfield [11] 
L62:    invokevirtual [13] 
L65:    invokevirtual [14] 
L68:    ifne L83 
L71:    aload_0 
L72:    getfield [10] 
L75:    getfield [15] 
L78:    ifnonnull L83 
L81:    iconst_m1 
L82:    areturn 
L83:    aload_0 
L84:    getfield [11] 
L87:    invokevirtual [13] 
L90:    invokevirtual [17] 
L93:    areturn 
L94:    nop 
L95:    nop 
L96:    
    .end code 
.end method 

.method public [147] : [148] 
    .attribute [140] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     getfield [12] 
L7:     iconst_2 
L8:     if_icmpne L35 
L11:    new [27] 
L14:    dup 
L15:    ldc [6] 
L17:    invokestatic [8] 
L20:    invokespecial [24] 
L23:    athrow 
L24:    goto L35 
L27:    aload_0 
L28:    getfield [10] 
L31:    invokevirtual [16] 
L34:    pop 
L35:    aload_0 
L36:    getfield [11] 
L39:    invokevirtual [13] 
L42:    invokevirtual [14] 
L45:    ifne L69 
L48:    aload_0 
L49:    getfield [10] 
L52:    getfield [15] 
L55:    ifnonnull L27 
L58:    goto L69 
L61:    aload_0 
L62:    getfield [10] 
L65:    invokevirtual [16] 
L68:    pop 
L69:    aload_0 
L70:    getfield [10] 
L73:    getfield [15] 
L76:    ifnull L106 
L79:    aload_0 
L80:    getfield [10] 
L83:    getfield [15] 
L86:    invokevirtual [14] 
L89:    ifle L106 
L92:    aload_0 
L93:    getfield [11] 
L96:    invokevirtual [13] 
L99:    invokevirtual [14] 
L102:   iload_3 
L103:   if_icmplt L61 
L106:   aload_0 
L107:   getfield [10] 
L110:   getfield [15] 
L113:   ifnonnull L131 
L116:   aload_0 
L117:   getfield [11] 
L120:   invokevirtual [13] 
L123:   invokevirtual [14] 
L126:   ifne L131 
L129:   iconst_m1 
L130:   areturn 
L131:   aload_0 
L132:   getfield [11] 
L135:   invokevirtual [13] 
L138:   aload_1 
L139:   iload_2 
L140:   iload_3 
L141:   invokevirtual [18] 
L144:   areturn 
L145:   nop 
L146:   nop 
L147:   nop 
L148:   
    .end code 
.end method 

.method public [149] : [150] 
    .attribute [140] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iconst_0 
L3:     aload_1 
L4:     arraylength 
L5:     invokevirtual [19] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [151] : [152] 
    .attribute [140] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     getfield [12] 
L7:     iconst_2 
L8:     if_icmpeq L57 
L11:    aload_0 
L12:    getfield [10] 
L15:    iconst_2 
L16:    putfield [28] 
L19:    aload_0 
L20:    getfield [10] 
L23:    getfield [15] 
L26:    ifnull L39 
L29:    aload_0 
L30:    getfield [10] 
L33:    getfield [15] 
L36:    invokevirtual [20] 
L39:    aload_0 
L40:    getfield [10] 
L43:    getfield [21] 
L46:    iconst_2 
L47:    if_icmpne L57 
L50:    aload_0 
L51:    getfield [10] 
L54:    invokevirtual [22] 
L57:    return 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [29] 
.const [3] = Class [30] 
.const [4] = Class [31] 
.const [5] = Class [32] 
.const [6] = String [33] 
.const [7] = Class [34] 
.const [8] = Method [35] [36] 
.const [9] = Class [37] 
.const [10] = Field [38] [39] 
.const [11] = Field [40] [41] 
.const [12] = Field [42] [43] 
.const [13] = Method [44] [45] 
.const [14] = Method [46] [47] 
.const [15] = Field [48] [49] 
.const [16] = Method [50] [51] 
.const [17] = Method [52] [53] 
.const [18] = Method [54] [55] 
.const [19] = Method [56] [57] 
.const [20] = Method [58] [59] 
.const [21] = Field [60] [61] 
.const [22] = Method [62] [63] 
.const [23] = Method [64] [65] 
.const [24] = Method [66] [67] 
.const [25] = Field [68] [69] 
.const [26] = Field [70] [71] 
.const [27] = Class [72] 
.const [28] = Field [73] [74] 
.const [29] = Utf8 com/ibm/oti/connection/ssl/Connection$SSLInputStream 
.const [30] = Utf8 java/io/InputStream 
.const [31] = Utf8 java/io/IOException 
.const [32] = Utf8 com/ibm/oti/connection/ssl/Connection 
.const [33] = Utf8 K0059 
.const [34] = Utf8 com/ibm/oti/util/Msg 
.const [35] = Class [75] 
.const [36] = NameAndType [76] [77] 
.const [37] = Utf8 com/ibm/j9/ssl/StreamQueue 
.const [38] = Class [78] 
.const [39] = NameAndType [79] [80] 
.const [40] = Class [81] 
.const [41] = NameAndType [82] [83] 
.const [42] = Class [84] 
.const [43] = NameAndType [85] [86] 
.const [44] = Class [87] 
.const [45] = NameAndType [88] [89] 
.const [46] = Class [90] 
.const [47] = NameAndType [91] [92] 
.const [48] = Class [93] 
.const [49] = NameAndType [94] [95] 
.const [50] = Class [96] 
.const [51] = NameAndType [97] [98] 
.const [52] = Class [99] 
.const [53] = NameAndType [100] [101] 
.const [54] = Class [102] 
.const [55] = NameAndType [103] [104] 
.const [56] = Class [105] 
.const [57] = NameAndType [106] [107] 
.const [58] = Class [108] 
.const [59] = NameAndType [109] [110] 
.const [60] = Class [111] 
.const [61] = NameAndType [112] [113] 
.const [62] = Class [114] 
.const [63] = NameAndType [115] [116] 
.const [64] = Class [117] 
.const [65] = NameAndType [118] [119] 
.const [66] = Class [120] 
.const [67] = NameAndType [121] [122] 
.const [68] = Class [123] 
.const [69] = NameAndType [124] [125] 
.const [70] = Class [126] 
.const [71] = NameAndType [127] [128] 
.const [72] = Utf8 java/io/IOException 
.const [73] = Class [129] 
.const [74] = NameAndType [130] [131] 
.const [75] = Utf8 com/ibm/oti/util/Msg 
.const [76] = Utf8 getString 
.const [77] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [78] = Utf8 com/ibm/oti/connection/ssl/Connection$SSLInputStream 
.const [79] = Utf8 this$0 
.const [80] = Utf8 Lcom/ibm/oti/connection/ssl/Connection; 
.const [81] = Utf8 com/ibm/oti/connection/ssl/Connection$SSLInputStream 
.const [82] = Utf8 applicationDataInputQueue 
.const [83] = Utf8 Lcom/ibm/j9/ssl/StreamQueue; 
.const [84] = Utf8 com/ibm/oti/connection/ssl/Connection 
.const [85] = Utf8 inputStatus 
.const [86] = Utf8 I 
.const [87] = Utf8 com/ibm/j9/ssl/StreamQueue 
.const [88] = Utf8 getReadStream 
.const [89] = Utf8 ()Ljava/io/InputStream; 
.const [90] = Utf8 java/io/InputStream 
.const [91] = Utf8 available 
.const [92] = Utf8 ()I 
.const [93] = Utf8 com/ibm/oti/connection/ssl/Connection 
.const [94] = Utf8 inputStream 
.const [95] = Utf8 Ljava/io/InputStream; 
.const [96] = Utf8 com/ibm/oti/connection/ssl/Connection 
.const [97] = Utf8 readData 
.const [98] = Utf8 ()Z 
.const [99] = Utf8 java/io/InputStream 
.const [100] = Utf8 read 
.const [101] = Utf8 ()I 
.const [102] = Utf8 java/io/InputStream 
.const [103] = Utf8 read 
.const [104] = Utf8 ([BII)I 
.const [105] = Utf8 com/ibm/oti/connection/ssl/Connection$SSLInputStream 
.const [106] = Utf8 read 
.const [107] = Utf8 ([BII)I 
.const [108] = Utf8 java/io/InputStream 
.const [109] = Utf8 close 
.const [110] = Utf8 ()V 
.const [111] = Utf8 com/ibm/oti/connection/ssl/Connection 
.const [112] = Utf8 outputStatus 
.const [113] = Utf8 I 
.const [114] = Utf8 com/ibm/oti/connection/ssl/Connection 
.const [115] = Utf8 closeConnection 
.const [116] = Utf8 ()V 
.const [117] = Utf8 java/io/InputStream 
.const [118] = Utf8 <init> 
.const [119] = Utf8 ()V 
.const [120] = Utf8 java/io/IOException 
.const [121] = Utf8 <init> 
.const [122] = Utf8 (Ljava/lang/String;)V 
.const [123] = Utf8 com/ibm/oti/connection/ssl/Connection$SSLInputStream 
.const [124] = Utf8 this$0 
.const [125] = Utf8 Lcom/ibm/oti/connection/ssl/Connection; 
.const [126] = Utf8 com/ibm/oti/connection/ssl/Connection$SSLInputStream 
.const [127] = Utf8 applicationDataInputQueue 
.const [128] = Utf8 Lcom/ibm/j9/ssl/StreamQueue; 
.const [129] = Utf8 com/ibm/oti/connection/ssl/Connection 
.const [130] = Utf8 inputStatus 
.const [131] = Utf8 I 
.const [132] = Utf8 com/ibm/oti/connection/ssl/Connection$SSLInputStream 
.const [133] = Class [132] 
.const [134] = Utf8 java/io/InputStream 
.const [135] = Class [134] 
.const [136] = Utf8 applicationDataInputQueue 
.const [137] = Utf8 Lcom/ibm/j9/ssl/StreamQueue; 
.const [138] = Utf8 this$0 
.const [139] = Utf8 Lcom/ibm/oti/connection/ssl/Connection; 
.const [140] = Utf8 Code 
.const [141] = Utf8 <init> 
.const [142] = Utf8 (Lcom/ibm/oti/connection/ssl/Connection;Lcom/ibm/j9/ssl/StreamQueue;)V 
.const [143] = Utf8 available 
.const [144] = Utf8 ()I 
.const [145] = Utf8 read 
.const [146] = Utf8 ()I 
.const [147] = Utf8 read 
.const [148] = Utf8 ([BII)I 
.const [149] = Utf8 read 
.const [150] = Utf8 ([B)I 
.const [151] = Utf8 close 
.const [152] = Utf8 ()V 
.end class 
