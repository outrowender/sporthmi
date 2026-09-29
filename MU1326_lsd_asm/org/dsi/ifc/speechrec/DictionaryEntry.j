.version 50 0 
.class public super [101] 
.super [103] 
.field public [104] [105] 
.field public [106] [107] 
.field public [108] [109] 

.method public [111] : [112] 
    .attribute [110] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [19] 
L4:     aload_0 
L5:     ldc [2] 
L7:     putfield [21] 
L10:    aload_0 
L11:    iconst_0 
L12:    putfield [22] 
L15:    aload_0 
L16:    iconst_0 
L17:    anewarray [3] 
L20:    putfield [23] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [113] : [114] 
    .attribute [110] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [19] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [21] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [22] 
L14:    aload_0 
L15:    aload_3 
L16:    putfield [23] 
L19:    return 
L20:    
    .end code 
.end method 

.method public interface [115] : [116] 
    .attribute [110] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [117] : [118] 
    .attribute [110] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [119] : [120] 
    .attribute [110] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [121] : [122] 
    .attribute [110] .code stack 3 locals 4 
L0:     new [24] 
L3:     dup 
L4:     sipush 200 
L7:     invokespecial [20] 
L10:    astore_1 
L11:    aload_1 
L12:    ldc [5] 
L14:    invokevirtual [14] 
L17:    pop 
L18:    aload_1 
L19:    bipush 40 
L21:    invokevirtual [15] 
L24:    pop 
L25:    aload_1 
L26:    ldc [6] 
L28:    invokevirtual [14] 
L31:    pop 
L32:    aload_1 
L33:    bipush 61 
L35:    invokevirtual [15] 
L38:    pop 
L39:    aload_1 
L40:    bipush 34 
L42:    invokevirtual [15] 
L45:    pop 
L46:    aload_1 
L47:    aload_0 
L48:    getfield [11] 
L51:    invokevirtual [14] 
L54:    pop 
L55:    aload_1 
L56:    bipush 34 
L58:    invokevirtual [15] 
L61:    pop 
L62:    aload_1 
L63:    bipush 44 
L65:    invokevirtual [15] 
L68:    pop 
L69:    aload_1 
L70:    ldc [7] 
L72:    invokevirtual [14] 
L75:    pop 
L76:    aload_1 
L77:    bipush 61 
L79:    invokevirtual [15] 
L82:    pop 
L83:    aload_1 
L84:    aload_0 
L85:    getfield [12] 
L88:    invokevirtual [16] 
L91:    pop 
L92:    aload_1 
L93:    bipush 44 
L95:    invokevirtual [15] 
L98:    pop 
L99:    aload_1 
L100:   ldc [8] 
L102:   invokevirtual [14] 
L105:   pop 
L106:   aload_1 
L107:   bipush 91 
L109:   invokevirtual [15] 
L112:   pop 
L113:   aload_0 
L114:   getfield [13] 
L117:   ifnull L130 
L120:   aload_1 
L121:   aload_0 
L122:   getfield [13] 
L125:   arraylength 
L126:   invokevirtual [16] 
L129:   pop 
L130:   aload_1 
L131:   bipush 93 
L133:   invokevirtual [15] 
L136:   pop 
L137:   aload_1 
L138:   bipush 61 
L140:   invokevirtual [15] 
L143:   pop 
L144:   aload_1 
L145:   bipush 123 
L147:   invokevirtual [15] 
L150:   pop 
L151:   aload_0 
L152:   getfield [13] 
L155:   ifnull L211 
L158:   aload_0 
L159:   getfield [13] 
L162:   arraylength 
L163:   istore_2 
L164:   iload_2 
L165:   iconst_1 
L166:   isub 
L167:   istore_3 
L168:   iconst_0 
L169:   istore 4 
L171:   iload 4 
L173:   iload_2 
L174:   if_icmpge L208 
L177:   aload_1 
L178:   aload_0 
L179:   getfield [13] 
L182:   iload 4 
L184:   aaload 
L185:   invokevirtual [17] 
L188:   pop 
L189:   iload 4 
L191:   iload_3 
L192:   if_icmpge L202 
L195:   aload_1 
L196:   bipush 44 
L198:   invokevirtual [15] 
L201:   pop 
L202:   iinc 4 1 
L205:   goto L171 
L208:   goto L220 
L211:   aload_1 
L212:   aload_0 
L213:   getfield [13] 
L216:   invokevirtual [17] 
L219:   pop 
L220:   aload_1 
L221:   bipush 125 
L223:   invokevirtual [15] 
L226:   pop 
L227:   aload_1 
L228:   bipush 41 
L230:   invokevirtual [15] 
L233:   pop 
L234:   aload_1 
L235:   invokevirtual [18] 
L238:   areturn 
L239:   nop 
L240:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [25] 
.const [3] = Class [26] 
.const [4] = Class [27] 
.const [5] = String [28] 
.const [6] = String [29] 
.const [7] = String [30] 
.const [8] = String [31] 
.const [9] = Class [32] 
.const [10] = Class [33] 
.const [11] = Field [34] [35] 
.const [12] = Field [36] [37] 
.const [13] = Field [38] [39] 
.const [14] = Method [40] [41] 
.const [15] = Method [42] [43] 
.const [16] = Method [44] [45] 
.const [17] = Method [46] [47] 
.const [18] = Method [48] [49] 
.const [19] = Method [50] [51] 
.const [20] = Method [52] [53] 
.const [21] = Field [54] [55] 
.const [22] = Field [56] [57] 
.const [23] = Field [58] [59] 
.const [24] = Class [60] 
.const [25] = Utf8 '' 
.const [26] = Utf8 org/dsi/ifc/speechrec/PhoneticEntry 
.const [27] = Utf8 java/lang/StringBuffer 
.const [28] = Utf8 DictionaryEntry 
.const [29] = Utf8 orthography 
.const [30] = Utf8 ttsTransIndex 
.const [31] = Utf8 phoneticList 
.const [32] = Utf8 org/dsi/ifc/speechrec/DictionaryEntry 
.const [33] = Utf8 java/lang/Object 
.const [34] = Class [61] 
.const [35] = NameAndType [62] [63] 
.const [36] = Class [64] 
.const [37] = NameAndType [65] [66] 
.const [38] = Class [67] 
.const [39] = NameAndType [68] [69] 
.const [40] = Class [70] 
.const [41] = NameAndType [71] [72] 
.const [42] = Class [73] 
.const [43] = NameAndType [74] [75] 
.const [44] = Class [76] 
.const [45] = NameAndType [77] [78] 
.const [46] = Class [79] 
.const [47] = NameAndType [80] [81] 
.const [48] = Class [82] 
.const [49] = NameAndType [83] [84] 
.const [50] = Class [85] 
.const [51] = NameAndType [86] [87] 
.const [52] = Class [88] 
.const [53] = NameAndType [89] [90] 
.const [54] = Class [91] 
.const [55] = NameAndType [92] [93] 
.const [56] = Class [94] 
.const [57] = NameAndType [95] [96] 
.const [58] = Class [97] 
.const [59] = NameAndType [98] [99] 
.const [60] = Utf8 java/lang/StringBuffer 
.const [61] = Utf8 org/dsi/ifc/speechrec/DictionaryEntry 
.const [62] = Utf8 orthography 
.const [63] = Utf8 Ljava/lang/String; 
.const [64] = Utf8 org/dsi/ifc/speechrec/DictionaryEntry 
.const [65] = Utf8 ttsTransIndex 
.const [66] = Utf8 I 
.const [67] = Utf8 org/dsi/ifc/speechrec/DictionaryEntry 
.const [68] = Utf8 phoneticList 
.const [69] = Utf8 [Lorg/dsi/ifc/speechrec/PhoneticEntry; 
.const [70] = Utf8 java/lang/StringBuffer 
.const [71] = Utf8 append 
.const [72] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [73] = Utf8 java/lang/StringBuffer 
.const [74] = Utf8 append 
.const [75] = Utf8 (C)Ljava/lang/StringBuffer; 
.const [76] = Utf8 java/lang/StringBuffer 
.const [77] = Utf8 append 
.const [78] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [79] = Utf8 java/lang/StringBuffer 
.const [80] = Utf8 append 
.const [81] = Utf8 (Ljava/lang/Object;)Ljava/lang/StringBuffer; 
.const [82] = Utf8 java/lang/StringBuffer 
.const [83] = Utf8 toString 
.const [84] = Utf8 ()Ljava/lang/String; 
.const [85] = Utf8 java/lang/Object 
.const [86] = Utf8 <init> 
.const [87] = Utf8 ()V 
.const [88] = Utf8 java/lang/StringBuffer 
.const [89] = Utf8 <init> 
.const [90] = Utf8 (I)V 
.const [91] = Utf8 org/dsi/ifc/speechrec/DictionaryEntry 
.const [92] = Utf8 orthography 
.const [93] = Utf8 Ljava/lang/String; 
.const [94] = Utf8 org/dsi/ifc/speechrec/DictionaryEntry 
.const [95] = Utf8 ttsTransIndex 
.const [96] = Utf8 I 
.const [97] = Utf8 org/dsi/ifc/speechrec/DictionaryEntry 
.const [98] = Utf8 phoneticList 
.const [99] = Utf8 [Lorg/dsi/ifc/speechrec/PhoneticEntry; 
.const [100] = Utf8 org/dsi/ifc/speechrec/DictionaryEntry 
.const [101] = Class [100] 
.const [102] = Utf8 java/lang/Object 
.const [103] = Class [102] 
.const [104] = Utf8 orthography 
.const [105] = Utf8 Ljava/lang/String; 
.const [106] = Utf8 ttsTransIndex 
.const [107] = Utf8 I 
.const [108] = Utf8 phoneticList 
.const [109] = Utf8 [Lorg/dsi/ifc/speechrec/PhoneticEntry; 
.const [110] = Utf8 Code 
.const [111] = Utf8 <init> 
.const [112] = Utf8 ()V 
.const [113] = Utf8 <init> 
.const [114] = Utf8 (Ljava/lang/String;I[Lorg/dsi/ifc/speechrec/PhoneticEntry;)V 
.const [115] = Utf8 getOrthography 
.const [116] = Utf8 ()Ljava/lang/String; 
.const [117] = Utf8 getTtsTransIndex 
.const [118] = Utf8 ()I 
.const [119] = Utf8 getPhoneticList 
.const [120] = Utf8 ()[Lorg/dsi/ifc/speechrec/PhoneticEntry; 
.const [121] = Utf8 toString 
.const [122] = Utf8 ()Ljava/lang/String; 
.end class 
