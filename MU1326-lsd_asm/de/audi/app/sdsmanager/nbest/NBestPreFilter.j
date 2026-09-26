.version 50 0 
.class public super [153] 
.super [155] 

.method public annotation [157] : [158] 
    .attribute [156] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [34] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [159] : [160] 
    .attribute [156] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [22] 
L5:     aload_1 
L6:     invokevirtual [23] 
L9:     aload_1 
L10:    invokevirtual [24] 
L13:    aload_2 
L14:    invokestatic [2] 
L17:    putfield [36] 
L20:    aload_0 
L21:    aload_0 
L22:    aload_2 
L23:    invokestatic [3] 
L26:    putfield [37] 
L29:    aload_0 
L30:    areturn 
L31:    nop 
L32:    
    .end code 
.end method 

.method private static [161] : [162] 
    .attribute [156] .code stack 5 locals 6 
L0:     aload_0 
L1:     ifnull L12 
L4:     aload_0 
L5:     arraylength 
L6:     dup 
L7:     istore 4 
L9:     ifne L23 
L12:    aload_3 
L13:    ldc [4] 
L15:    ldc [5] 
L17:    invokevirtual [26] 
L20:    pop 
L21:    aload_0 
L22:    areturn 
L23:    aload_0 
L24:    iconst_0 
L25:    aaload 
L26:    ifnonnull L40 
L29:    aload_3 
L30:    ldc [4] 
L32:    ldc [6] 
L34:    invokevirtual [26] 
L37:    pop 
L38:    aload_0 
L39:    areturn 
L40:    aload_0 
L41:    iconst_0 
L42:    aaload 
L43:    getfield [27] 
L46:    i2f 
L47:    fstore 5 
L49:    new [38] 
L52:    dup 
L53:    iload 4 
L55:    invokespecial [35] 
L58:    astore 6 
L60:    aload 6 
L62:    aload_0 
L63:    iconst_0 
L64:    aaload 
L65:    invokevirtual [28] 
L68:    pop 
L69:    iconst_1 
L70:    istore 7 
L72:    iload 7 
L74:    iload 4 
L76:    if_icmpge L197 
L79:    aload_0 
L80:    iload 7 
L82:    aaload 
L83:    ifnull L179 
L86:    aload_0 
L87:    iload 7 
L89:    aaload 
L90:    getfield [27] 
L93:    i2f 
L94:    fstore 8 
L96:    aload_0 
L97:    iload 7 
L99:    iconst_1 
L100:   isub 
L101:   aaload 
L102:   getfield [27] 
L105:   i2f 
L106:   fstore 9 
L108:   fload 5 
L110:   fload 8 
L112:   fsub 
L113:   fload 5 
L115:   fdiv 
L116:   fload_1 
L117:   fcmpl 
L118:   ifle L137 
L121:   aload_3 
L122:   ldc [8] 
L124:   ldc [9] 
L126:   aload_0 
L127:   iload 7 
L129:   aaload 
L130:   invokevirtual [29] 
L133:   pop 
L134:   goto L197 
L137:   fload 9 
L139:   fload 8 
L141:   fsub 
L142:   fload 9 
L144:   fdiv 
L145:   fload_2 
L146:   fcmpl 
L147:   ifle L166 
L150:   aload_3 
L151:   ldc [8] 
L153:   ldc [10] 
L155:   aload_0 
L156:   iload 7 
L158:   aaload 
L159:   invokevirtual [29] 
L162:   pop 
L163:   goto L197 
L166:   aload 6 
L168:   aload_0 
L169:   iload 7 
L171:   aaload 
L172:   invokevirtual [28] 
L175:   pop 
L176:   goto L191 
L179:   aload_3 
L180:   ldc [4] 
L182:   ldc [11] 
L184:   iload 7 
L186:   i2l 
L187:   invokevirtual [30] 
L190:   pop 
L191:   iinc 7 1 
L194:   goto L72 
L197:   aload 6 
L199:   aload 6 
L201:   invokevirtual [31] 
L204:   anewarray [12] 
L207:   invokevirtual [32] 
L210:   checkcast [13] 
L213:   checkcast [13] 
L216:   areturn 
L217:   nop 
L218:   nop 
L219:   nop 
L220:   
    .end code 
.end method 

.method private static [163] : [164] 
    .attribute [156] .code stack 5 locals 8 
L0:     aload_0 
L1:     getfield [25] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [22] 
L9:     astore_3 
L10:    aload_2 
L11:    ifnull L18 
L14:    aload_3 
L15:    ifnonnull L20 
L18:    aload_2 
L19:    areturn 
L20:    aload_2 
L21:    arraylength 
L22:    istore 4 
L24:    new [38] 
L27:    dup 
L28:    iload 4 
L30:    invokespecial [35] 
L33:    astore 5 
L35:    iconst_0 
L36:    istore 7 
L38:    iload 7 
L40:    iload 4 
L42:    if_icmpge L131 
L45:    aload_2 
L46:    iload 7 
L48:    aaload 
L49:    astore 8 
L51:    aload 8 
L53:    ifnull L113 
L56:    iconst_0 
L57:    istore 6 
L59:    iconst_0 
L60:    istore 9 
L62:    iload 9 
L64:    aload_3 
L65:    arraylength 
L66:    if_icmpge L90 
L69:    aload_3 
L70:    iload 9 
L72:    aaload 
L73:    invokevirtual [33] 
L76:    iload 7 
L78:    if_icmpne L84 
L81:    iinc 6 1 
L84:    iinc 9 1 
L87:    goto L62 
L90:    iload 6 
L92:    ifle L125 
L95:    aload 8 
L97:    iload 6 
L99:    putfield [39] 
L102:   aload 5 
L104:   aload 8 
L106:   invokevirtual [28] 
L109:   pop 
L110:   goto L125 
L113:   aload_1 
L114:   ldc [4] 
L116:   ldc [14] 
L118:   iload 7 
L120:   i2l 
L121:   invokevirtual [30] 
L124:   pop 
L125:   iinc 7 1 
L128:   goto L38 
L131:   aload 5 
L133:   aload 5 
L135:   invokevirtual [31] 
L138:   anewarray [15] 
L141:   invokevirtual [32] 
L144:   checkcast [16] 
L147:   checkcast [16] 
L150:   areturn 
L151:   nop 
L152:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [40] [41] 
.const [3] = Method [42] [43] 
.const [4] = Int -1601830656 
.const [5] = String [44] 
.const [6] = String [45] 
.const [7] = Class [46] 
.const [8] = Int -2137614336 
.const [9] = String [47] 
.const [10] = String [48] 
.const [11] = String [49] 
.const [12] = Class [50] 
.const [13] = Class [51] 
.const [14] = String [52] 
.const [15] = Class [53] 
.const [16] = Class [54] 
.const [17] = Class [55] 
.const [18] = Class [56] 
.const [19] = Class [57] 
.const [20] = Class [58] 
.const [21] = Class [59] 
.const [22] = Field [60] [61] 
.const [23] = Method [62] [63] 
.const [24] = Method [64] [65] 
.const [25] = Field [66] [67] 
.const [26] = Method [68] [69] 
.const [27] = Field [70] [71] 
.const [28] = Method [72] [73] 
.const [29] = Method [74] [75] 
.const [30] = Method [76] [77] 
.const [31] = Method [78] [79] 
.const [32] = Method [80] [81] 
.const [33] = Method [82] [83] 
.const [34] = Method [84] [85] 
.const [35] = Method [86] [87] 
.const [36] = Field [88] [89] 
.const [37] = Field [90] [91] 
.const [38] = Class [92] 
.const [39] = Field [93] [94] 
.const [40] = Class [95] 
.const [41] = NameAndType [96] [97] 
.const [42] = Class [98] 
.const [43] = NameAndType [99] [100] 
.const [44] = Utf8 'NBestPreFilter#filterEntries: no entry. nothing to do here' 
.const [45] = Utf8 'NBestPreFilter#filterEntries: top entry was null' 
.const [46] = Utf8 java/util/ArrayList 
.const [47] = Utf8 'NBestPreFilter#filterEntries: entry %1 is filtered out. Confidence is ABOVE the top entry threshold!' 
.const [48] = Utf8 'NBestPreFilter#filterEntries: entry %1 is filtered out. Confidence is ABOVE the followup entry threshold!' 
.const [49] = Utf8 'NBestPreFilter#filterEntries: entry %1 is null!' 
.const [50] = Utf8 org/dsi/ifc/speechrec/NBestListEntry 
.const [51] = Utf8 [Lorg/dsi/ifc/speechrec/NBestListEntry; 
.const [52] = Utf8 'NBestPreFilter#correctGraphemicGroups: GG with index=%1 was null' 
.const [53] = Utf8 org/dsi/ifc/speechrec/GraphemicGroup 
.const [54] = Utf8 [Lorg/dsi/ifc/speechrec/GraphemicGroup; 
.const [55] = Utf8 de/audi/app/sdsmanager/nbest/NBestPreFilter 
.const [56] = Utf8 java/lang/Object 
.const [57] = Utf8 org/dsi/ifc/speechrec/NBestList 
.const [58] = Utf8 de/audi/app/sdsmanager/apps/SDSAdapter 
.const [59] = Utf8 de/audi/atip/log/LogChannel 
.const [60] = Class [101] 
.const [61] = NameAndType [102] [103] 
.const [62] = Class [104] 
.const [63] = NameAndType [105] [106] 
.const [64] = Class [107] 
.const [65] = NameAndType [108] [109] 
.const [66] = Class [110] 
.const [67] = NameAndType [111] [112] 
.const [68] = Class [113] 
.const [69] = NameAndType [114] [115] 
.const [70] = Class [116] 
.const [71] = NameAndType [117] [118] 
.const [72] = Class [119] 
.const [73] = NameAndType [120] [121] 
.const [74] = Class [122] 
.const [75] = NameAndType [123] [124] 
.const [76] = Class [125] 
.const [77] = NameAndType [126] [127] 
.const [78] = Class [128] 
.const [79] = NameAndType [129] [130] 
.const [80] = Class [131] 
.const [81] = NameAndType [132] [133] 
.const [82] = Class [134] 
.const [83] = NameAndType [135] [136] 
.const [84] = Class [137] 
.const [85] = NameAndType [138] [139] 
.const [86] = Class [140] 
.const [87] = NameAndType [141] [142] 
.const [88] = Class [143] 
.const [89] = NameAndType [144] [145] 
.const [90] = Class [146] 
.const [91] = NameAndType [147] [148] 
.const [92] = Utf8 java/util/ArrayList 
.const [93] = Class [149] 
.const [94] = NameAndType [150] [151] 
.const [95] = Utf8 de/audi/app/sdsmanager/nbest/NBestPreFilter 
.const [96] = Utf8 filterEntries 
.const [97] = Utf8 ([Lorg/dsi/ifc/speechrec/NBestListEntry;FFLde/audi/atip/log/LogChannel;)[Lorg/dsi/ifc/speechrec/NBestListEntry; 
.const [98] = Utf8 de/audi/app/sdsmanager/nbest/NBestPreFilter 
.const [99] = Utf8 correctGraphemicGroups 
.const [100] = Utf8 (Lorg/dsi/ifc/speechrec/NBestList;Lde/audi/atip/log/LogChannel;)[Lorg/dsi/ifc/speechrec/GraphemicGroup; 
.const [101] = Utf8 org/dsi/ifc/speechrec/NBestList 
.const [102] = Utf8 entries 
.const [103] = Utf8 [Lorg/dsi/ifc/speechrec/NBestListEntry; 
.const [104] = Utf8 de/audi/app/sdsmanager/apps/SDSAdapter 
.const [105] = Utf8 getTopEntryThreshold 
.const [106] = Utf8 ()F 
.const [107] = Utf8 de/audi/app/sdsmanager/apps/SDSAdapter 
.const [108] = Utf8 getFollowupEntryThreshold 
.const [109] = Utf8 ()F 
.const [110] = Utf8 org/dsi/ifc/speechrec/NBestList 
.const [111] = Utf8 graphemicGroups 
.const [112] = Utf8 [Lorg/dsi/ifc/speechrec/GraphemicGroup; 
.const [113] = Utf8 de/audi/atip/log/LogChannel 
.const [114] = Utf8 log 
.const [115] = Utf8 (ILjava/lang/String;)Z 
.const [116] = Utf8 org/dsi/ifc/speechrec/NBestListEntry 
.const [117] = Utf8 confidence 
.const [118] = Utf8 I 
.const [119] = Utf8 java/util/ArrayList 
.const [120] = Utf8 add 
.const [121] = Utf8 (Ljava/lang/Object;)Z 
.const [122] = Utf8 de/audi/atip/log/LogChannel 
.const [123] = Utf8 log 
.const [124] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [125] = Utf8 de/audi/atip/log/LogChannel 
.const [126] = Utf8 log 
.const [127] = Utf8 (ILjava/lang/String;J)Z 
.const [128] = Utf8 java/util/ArrayList 
.const [129] = Utf8 size 
.const [130] = Utf8 ()I 
.const [131] = Utf8 java/util/ArrayList 
.const [132] = Utf8 toArray 
.const [133] = Utf8 ([Ljava/lang/Object;)[Ljava/lang/Object; 
.const [134] = Utf8 org/dsi/ifc/speechrec/NBestListEntry 
.const [135] = Utf8 getGraphemicGroupIndex 
.const [136] = Utf8 ()I 
.const [137] = Utf8 java/lang/Object 
.const [138] = Utf8 <init> 
.const [139] = Utf8 ()V 
.const [140] = Utf8 java/util/ArrayList 
.const [141] = Utf8 <init> 
.const [142] = Utf8 (I)V 
.const [143] = Utf8 org/dsi/ifc/speechrec/NBestList 
.const [144] = Utf8 entries 
.const [145] = Utf8 [Lorg/dsi/ifc/speechrec/NBestListEntry; 
.const [146] = Utf8 org/dsi/ifc/speechrec/NBestList 
.const [147] = Utf8 graphemicGroups 
.const [148] = Utf8 [Lorg/dsi/ifc/speechrec/GraphemicGroup; 
.const [149] = Utf8 org/dsi/ifc/speechrec/GraphemicGroup 
.const [150] = Utf8 graphemicGroupSize 
.const [151] = Utf8 I 
.const [152] = Utf8 de/audi/app/sdsmanager/nbest/NBestPreFilter 
.const [153] = Class [152] 
.const [154] = Utf8 java/lang/Object 
.const [155] = Class [154] 
.const [156] = Utf8 Code 
.const [157] = Utf8 <init> 
.const [158] = Utf8 ()V 
.const [159] = Utf8 filterLowConfidenceEntries 
.const [160] = Utf8 (Lorg/dsi/ifc/speechrec/NBestList;Lde/audi/app/sdsmanager/apps/SDSAdapter;Lde/audi/atip/log/LogChannel;)Lorg/dsi/ifc/speechrec/NBestList; 
.const [161] = Utf8 filterEntries 
.const [162] = Utf8 ([Lorg/dsi/ifc/speechrec/NBestListEntry;FFLde/audi/atip/log/LogChannel;)[Lorg/dsi/ifc/speechrec/NBestListEntry; 
.const [163] = Utf8 correctGraphemicGroups 
.const [164] = Utf8 (Lorg/dsi/ifc/speechrec/NBestList;Lde/audi/atip/log/LogChannel;)[Lorg/dsi/ifc/speechrec/GraphemicGroup; 
.end class 
