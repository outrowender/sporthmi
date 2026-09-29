.version 50 0 
.class public super abstract [181] 
.super [183] 
.field [184] [185] 
.field [186] [187] 

.method protected annotation [189] : [190] 
    .attribute [188] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iload_2 
L3:     invokespecial [33] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method final [191] : [192] 
    .attribute [188] .code stack 2 locals 1 
L0:     aload_1 
L1:     instanceof [4] 
L4:     ifeq L24 
L7:     aload_1 
L8:     checkcast [4] 
L11:    astore_2 
L12:    aload_2 
L13:    getfield [24] 
L16:    invokevirtual [25] 
L19:    aload_2 
L20:    aconst_null 
L21:    putfield [37] 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method final [193] : [194] 
    .attribute [188] .code stack 5 locals 0 
L0:     aload_1 
L1:     instanceof [4] 
L4:     ifne L20 
L7:     new [38] 
L10:    dup 
L11:    ldc [7] 
L13:    invokestatic [9] 
L16:    invokespecial [34] 
L19:    athrow 
L20:    aload_0 
L21:    iload_2 
L22:    putfield [39] 
L25:    aload_0 
L26:    iload_3 
L27:    invokevirtual [27] 
L30:    ifne L46 
L33:    new [38] 
L36:    dup 
L37:    ldc [10] 
L39:    invokestatic [9] 
L42:    invokespecial [34] 
L45:    athrow 
L46:    aload 4 
L48:    ifnull L61 
L51:    aload 4 
L53:    arraylength 
L54:    aload_0 
L55:    invokevirtual [28] 
L58:    if_icmpeq L74 
L61:    new [38] 
L64:    dup 
L65:    ldc [11] 
L67:    invokestatic [9] 
L70:    invokespecial [34] 
L73:    athrow 
L74:    aload_0 
L75:    aload_0 
L76:    invokevirtual [28] 
L79:    newarray byte 
L81:    putfield [40] 
L84:    aload 4 
L86:    iconst_0 
L87:    aload_0 
L88:    getfield [29] 
L91:    iconst_0 
L92:    aload_0 
L93:    invokevirtual [28] 
L96:    invokestatic [13] 
L99:    return 
L100:   
    .end code 
.end method 

.method [195] : [196] 
    .attribute [188] .code stack 6 locals 0 
L0:     aload_1 
L1:     instanceof [4] 
L4:     ifne L20 
L7:     new [38] 
L10:    dup 
L11:    ldc [7] 
L13:    invokestatic [9] 
L16:    invokespecial [34] 
L19:    athrow 
L20:    aload_0 
L21:    getfield [26] 
L24:    iconst_1 
L25:    if_icmpne L43 
L28:    aload_0 
L29:    aload_1 
L30:    checkcast [4] 
L33:    aload_2 
L34:    iload_3 
L35:    iload 4 
L37:    iload 5 
L39:    invokespecial [35] 
L42:    areturn 
L43:    aload_0 
L44:    aload_1 
L45:    checkcast [4] 
L48:    aload_2 
L49:    iload_3 
L50:    iload 4 
L52:    iload 5 
L54:    invokespecial [36] 
L57:    areturn 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method [197] : [198] 
    .attribute [188] .code stack 2 locals 0 
L0:     iload_1 
L1:     iconst_4 
L2:     if_icmpeq L17 
L5:     iload_1 
L6:     iconst_3 
L7:     if_icmpeq L17 
L10:    iload_1 
L11:    iconst_2 
L12:    if_icmpeq L17 
L15:    iconst_0 
L16:    areturn 
L17:    iconst_1 
L18:    areturn 
L19:    nop 
L20:    
    .end code 
.end method 

.method final [199] : [200] 
    .attribute [188] .code stack 10 locals 5 
L0:     iload 4 
L2:     aload_0 
L3:     invokevirtual [30] 
L6:     idiv 
L7:     istore 6 
L9:     iload 4 
L11:    aload_0 
L12:    invokevirtual [30] 
L15:    irem 
L16:    istore 7 
L18:    iload 6 
L20:    aload_0 
L21:    invokevirtual [30] 
L24:    imul 
L25:    istore 8 
L27:    iload 5 
L29:    ifne L50 
L32:    iload 7 
L34:    ifeq L50 
L37:    new [38] 
L40:    dup 
L41:    ldc [14] 
L43:    invokestatic [9] 
L46:    invokespecial [34] 
L49:    athrow 
L50:    iload 5 
L52:    ifeq L71 
L55:    iload 6 
L57:    iconst_1 
L58:    iadd 
L59:    aload_0 
L60:    invokevirtual [30] 
L63:    imul 
L64:    newarray byte 
L66:    astore 9 
L68:    goto L77 
L71:    iload 8 
L73:    newarray byte 
L75:    astore 9 
L77:    aload_0 
L78:    aload_1 
L79:    getfield [24] 
L82:    iconst_0 
L83:    aload_0 
L84:    getfield [29] 
L87:    iconst_0 
L88:    aload_2 
L89:    iload_3 
L90:    aload 9 
L92:    iconst_0 
L93:    iload 8 
L95:    invokevirtual [31] 
L98:    iload 5 
L100:   ifeq L219 
L103:   aconst_null 
L104:   checkcast [15] 
L107:   astore 10 
L109:   aload_1 
L110:   getfield [32] 
L113:   tableswitch 2 
            L178 
            L140 
            L159 
            default : L194 

L140:   aload_2 
L141:   iload_3 
L142:   iload 8 
L144:   iadd 
L145:   iload 7 
L147:   aload_0 
L148:   invokevirtual [30] 
L151:   invokestatic [17] 
L154:   astore 10 
L156:   goto L194 
L159:   aload_2 
L160:   iload_3 
L161:   iload 8 
L163:   iadd 
L164:   iload 7 
L166:   aload_0 
L167:   invokevirtual [30] 
L170:   invokestatic [18] 
L173:   astore 10 
L175:   goto L194 
L178:   aload_2 
L179:   iload_3 
L180:   iload 8 
L182:   iadd 
L183:   iload 7 
L185:   aload_0 
L186:   invokevirtual [30] 
L189:   invokestatic [19] 
L192:   astore 10 
L194:   aload_0 
L195:   aload_1 
L196:   getfield [24] 
L199:   iconst_0 
L200:   aload_0 
L201:   getfield [29] 
L204:   iconst_0 
L205:   aload 10 
L207:   iconst_0 
L208:   aload 9 
L210:   iload 8 
L212:   aload_0 
L213:   invokevirtual [30] 
L216:   invokevirtual [31] 
L219:   aload 9 
L221:   areturn 
L222:   nop 
L223:   nop 
L224:   
    .end code 
.end method 

.method abstract [201] : [202] 
    .attribute [188] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method final [203] : [204] 
    .attribute [188] .code stack 11 locals 5 
L0:     iload 4 
L2:     aload_0 
L3:     invokevirtual [30] 
L6:     irem 
L7:     ifeq L23 
L10:    new [38] 
L13:    dup 
L14:    ldc [14] 
L16:    invokestatic [9] 
L19:    invokespecial [34] 
L22:    athrow 
L23:    iload 4 
L25:    aload_0 
L26:    invokevirtual [30] 
L29:    idiv 
L30:    istore 6 
L32:    iload 6 
L34:    iconst_1 
L35:    isub 
L36:    aload_0 
L37:    invokevirtual [30] 
L40:    imul 
L41:    istore 7 
L43:    iload 5 
L45:    ifeq L51 
L48:    iinc 6 -1 
L51:    iload 6 
L53:    aload_0 
L54:    invokevirtual [30] 
L57:    imul 
L58:    newarray byte 
L60:    astore 8 
L62:    aload_0 
L63:    aload_1 
L64:    getfield [24] 
L67:    iconst_1 
L68:    aload_0 
L69:    getfield [29] 
L72:    iconst_0 
L73:    aload_2 
L74:    iload_3 
L75:    aload 8 
L77:    iconst_0 
L78:    iload 6 
L80:    aload_0 
L81:    invokevirtual [30] 
L84:    imul 
L85:    invokevirtual [31] 
L88:    iload 5 
L90:    ifeq L199 
L93:    aload_0 
L94:    invokevirtual [30] 
L97:    newarray byte 
L99:    astore 9 
L101:   aload_0 
L102:   aload_1 
L103:   getfield [24] 
L106:   iconst_1 
L107:   aload_0 
L108:   getfield [29] 
L111:   iconst_0 
L112:   aload_2 
L113:   iload_3 
L114:   iload 7 
L116:   iadd 
L117:   aload 9 
L119:   iconst_0 
L120:   aload_0 
L121:   invokevirtual [30] 
L124:   invokevirtual [31] 
L127:   aconst_null 
L128:   checkcast [15] 
L131:   astore 10 
L133:   aload_1 
L134:   getfield [32] 
L137:   tableswitch 2 
            L184 
            L174 
            L164 
            default : L191 

L164:   aload 9 
L166:   invokestatic [20] 
L169:   astore 10 
L171:   goto L191 
L174:   aload 9 
L176:   invokestatic [21] 
L179:   astore 10 
L181:   goto L191 
L184:   aload 9 
L186:   invokestatic [22] 
L189:   astore 10 
L191:   aload 8 
L193:   aload 10 
L195:   invokestatic [23] 
L198:   areturn 
L199:   aload 8 
L201:   areturn 
L202:   nop 
L203:   nop 
L204:   
    .end code 
.end method 

.method public abstract [205] : [206] 
    .attribute [188] .code stack 0 locals 0 
L0:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [41] 
.const [3] = Class [42] 
.const [4] = Class [43] 
.const [5] = Class [44] 
.const [6] = Class [45] 
.const [7] = String [46] 
.const [8] = Class [47] 
.const [9] = Method [48] [49] 
.const [10] = String [50] 
.const [11] = String [51] 
.const [12] = Class [52] 
.const [13] = Method [53] [54] 
.const [14] = String [55] 
.const [15] = Class [56] 
.const [16] = Class [57] 
.const [17] = Method [58] [59] 
.const [18] = Method [60] [61] 
.const [19] = Method [62] [63] 
.const [20] = Method [64] [65] 
.const [21] = Method [66] [67] 
.const [22] = Method [68] [69] 
.const [23] = Method [70] [71] 
.const [24] = Field [72] [73] 
.const [25] = Method [74] [75] 
.const [26] = Field [76] [77] 
.const [27] = Method [78] [79] 
.const [28] = Method [80] [81] 
.const [29] = Field [82] [83] 
.const [30] = Method [84] [85] 
.const [31] = Method [86] [87] 
.const [32] = Field [88] [89] 
.const [33] = Method [90] [91] 
.const [34] = Method [92] [93] 
.const [35] = Method [94] [95] 
.const [36] = Method [96] [97] 
.const [37] = Field [98] [99] 
.const [38] = Class [100] 
.const [39] = Field [101] [102] 
.const [40] = Field [103] [104] 
.const [41] = Utf8 com/ibm/oti/crypto/CL3BasedProvider 
.const [42] = Utf8 com/ibm/oti/crypto/Provider 
.const [43] = Utf8 com/ibm/oti/crypto/CL3BasedKey 
.const [44] = Utf8 com/ibm/j9/bluez/crypto/CL3Key 
.const [45] = Utf8 java/io/IOException 
.const [46] = Utf8 K01fa 
.const [47] = Utf8 com/ibm/oti/util/Msg 
.const [48] = Class [105] 
.const [49] = NameAndType [106] [107] 
.const [50] = Utf8 K01f7 
.const [51] = Utf8 K01f6 
.const [52] = Utf8 java/lang/System 
.const [53] = Class [108] 
.const [54] = NameAndType [109] [110] 
.const [55] = Utf8 K0170 
.const [56] = Utf8 [B 
.const [57] = Utf8 com/ibm/oti/crypto/Util 
.const [58] = Class [111] 
.const [59] = NameAndType [112] [113] 
.const [60] = Class [114] 
.const [61] = NameAndType [115] [116] 
.const [62] = Class [117] 
.const [63] = NameAndType [118] [119] 
.const [64] = Class [120] 
.const [65] = NameAndType [121] [122] 
.const [66] = Class [123] 
.const [67] = NameAndType [124] [125] 
.const [68] = Class [126] 
.const [69] = NameAndType [127] [128] 
.const [70] = Class [129] 
.const [71] = NameAndType [130] [131] 
.const [72] = Class [132] 
.const [73] = NameAndType [133] [134] 
.const [74] = Class [135] 
.const [75] = NameAndType [136] [137] 
.const [76] = Class [138] 
.const [77] = NameAndType [139] [140] 
.const [78] = Class [141] 
.const [79] = NameAndType [142] [143] 
.const [80] = Class [144] 
.const [81] = NameAndType [145] [146] 
.const [82] = Class [147] 
.const [83] = NameAndType [148] [149] 
.const [84] = Class [150] 
.const [85] = NameAndType [151] [152] 
.const [86] = Class [153] 
.const [87] = NameAndType [154] [155] 
.const [88] = Class [156] 
.const [89] = NameAndType [157] [158] 
.const [90] = Class [159] 
.const [91] = NameAndType [160] [161] 
.const [92] = Class [162] 
.const [93] = NameAndType [163] [164] 
.const [94] = Class [165] 
.const [95] = NameAndType [166] [167] 
.const [96] = Class [168] 
.const [97] = NameAndType [169] [170] 
.const [98] = Class [171] 
.const [99] = NameAndType [172] [173] 
.const [100] = Utf8 java/io/IOException 
.const [101] = Class [174] 
.const [102] = NameAndType [175] [176] 
.const [103] = Class [177] 
.const [104] = NameAndType [178] [179] 
.const [105] = Utf8 com/ibm/oti/util/Msg 
.const [106] = Utf8 getString 
.const [107] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [108] = Utf8 java/lang/System 
.const [109] = Utf8 arraycopy 
.const [110] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [111] = Utf8 com/ibm/oti/crypto/Util 
.const [112] = Utf8 padSSL 
.const [113] = Utf8 ([BIII)[B 
.const [114] = Utf8 com/ibm/oti/crypto/Util 
.const [115] = Utf8 padTLS10 
.const [116] = Utf8 ([BIII)[B 
.const [117] = Utf8 com/ibm/oti/crypto/Util 
.const [118] = Utf8 padPKCS5 
.const [119] = Utf8 ([BIII)[B 
.const [120] = Utf8 com/ibm/oti/crypto/Util 
.const [121] = Utf8 unpadTLS10 
.const [122] = Utf8 ([B)[B 
.const [123] = Utf8 com/ibm/oti/crypto/Util 
.const [124] = Utf8 unpadSSL 
.const [125] = Utf8 ([B)[B 
.const [126] = Utf8 com/ibm/oti/crypto/Util 
.const [127] = Utf8 unpadPKCS5 
.const [128] = Utf8 ([B)[B 
.const [129] = Utf8 com/ibm/oti/crypto/Util 
.const [130] = Utf8 concatenate 
.const [131] = Utf8 ([B[B)[B 
.const [132] = Utf8 com/ibm/oti/crypto/CL3BasedKey 
.const [133] = Utf8 workingKey 
.const [134] = Utf8 Lcom/ibm/j9/bluez/crypto/CL3Key; 
.const [135] = Utf8 com/ibm/j9/bluez/crypto/CL3Key 
.const [136] = Utf8 dispose 
.const [137] = Utf8 ()V 
.const [138] = Utf8 com/ibm/oti/crypto/CL3BasedProvider 
.const [139] = Utf8 mode 
.const [140] = Utf8 I 
.const [141] = Utf8 com/ibm/oti/crypto/CL3BasedProvider 
.const [142] = Utf8 isValidPadType 
.const [143] = Utf8 (I)Z 
.const [144] = Utf8 com/ibm/oti/crypto/CL3BasedProvider 
.const [145] = Utf8 getIVLength 
.const [146] = Utf8 ()I 
.const [147] = Utf8 com/ibm/oti/crypto/CL3BasedProvider 
.const [148] = Utf8 iv 
.const [149] = Utf8 [B 
.const [150] = Utf8 com/ibm/oti/crypto/CL3BasedProvider 
.const [151] = Utf8 getBlockLength 
.const [152] = Utf8 ()I 
.const [153] = Utf8 com/ibm/oti/crypto/CL3BasedProvider 
.const [154] = Utf8 cl3Call 
.const [155] = Utf8 (Lcom/ibm/j9/bluez/crypto/CL3Key;I[BI[BI[BII)V 
.const [156] = Utf8 com/ibm/oti/crypto/CL3BasedKey 
.const [157] = Utf8 padtype 
.const [158] = Utf8 I 
.const [159] = Utf8 com/ibm/oti/crypto/Provider 
.const [160] = Utf8 <init> 
.const [161] = Utf8 (II)V 
.const [162] = Utf8 java/io/IOException 
.const [163] = Utf8 <init> 
.const [164] = Utf8 (Ljava/lang/String;)V 
.const [165] = Utf8 com/ibm/oti/crypto/CL3BasedProvider 
.const [166] = Utf8 encryptImpl 
.const [167] = Utf8 (Lcom/ibm/oti/crypto/CL3BasedKey;[BIIZ)[B 
.const [168] = Utf8 com/ibm/oti/crypto/CL3BasedProvider 
.const [169] = Utf8 decryptImpl 
.const [170] = Utf8 (Lcom/ibm/oti/crypto/CL3BasedKey;[BIIZ)[B 
.const [171] = Utf8 com/ibm/oti/crypto/CL3BasedKey 
.const [172] = Utf8 workingKey 
.const [173] = Utf8 Lcom/ibm/j9/bluez/crypto/CL3Key; 
.const [174] = Utf8 com/ibm/oti/crypto/CL3BasedProvider 
.const [175] = Utf8 mode 
.const [176] = Utf8 I 
.const [177] = Utf8 com/ibm/oti/crypto/CL3BasedProvider 
.const [178] = Utf8 iv 
.const [179] = Utf8 [B 
.const [180] = Utf8 com/ibm/oti/crypto/CL3BasedProvider 
.const [181] = Class [180] 
.const [182] = Utf8 com/ibm/oti/crypto/Provider 
.const [183] = Class [182] 
.const [184] = Utf8 mode 
.const [185] = Utf8 I 
.const [186] = Utf8 iv 
.const [187] = Utf8 [B 
.const [188] = Utf8 Code 
.const [189] = Utf8 <init> 
.const [190] = Utf8 (II)V 
.const [191] = Utf8 destroyKey 
.const [192] = Utf8 (Lcom/ibm/oti/crypto/Key;)V 
.const [193] = Utf8 cryptInit 
.const [194] = Utf8 (Lcom/ibm/oti/crypto/Key;II[B)V 
.const [195] = Utf8 cryptUpdate 
.const [196] = Utf8 (Lcom/ibm/oti/crypto/Key;[BIIZ)[B 
.const [197] = Utf8 isValidPadType 
.const [198] = Utf8 (I)Z 
.const [199] = Utf8 encryptImpl 
.const [200] = Utf8 (Lcom/ibm/oti/crypto/CL3BasedKey;[BIIZ)[B 
.const [201] = Utf8 cl3Call 
.const [202] = Utf8 (Lcom/ibm/j9/bluez/crypto/CL3Key;I[BI[BI[BII)V 
.const [203] = Utf8 decryptImpl 
.const [204] = Utf8 (Lcom/ibm/oti/crypto/CL3BasedKey;[BIIZ)[B 
.const [205] = Utf8 createKey 
.const [206] = Utf8 ([B)Lcom/ibm/oti/crypto/Key; 
.end class 
