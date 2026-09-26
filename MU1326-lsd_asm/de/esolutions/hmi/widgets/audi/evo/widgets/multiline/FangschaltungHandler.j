.version 50 0 
.class public super [168] 
.super [170] 
.field public static final [171] [172] 
.field public static final [173] [174] 
.field public static final [175] [176] 
.field public static final [177] [178] 
.field public static final [179] [180] 
.field public static final [181] [182] 
.field public static final [183] [184] 
.field public static final [185] [186] 
.field private [187] [188] 
.field private [189] [190] 
.field private [191] [192] 
.field private [193] [194] 
.field private [195] [196] 
.field private [197] [198] 
.field private [199] [200] 
.field private [201] [202] 
.field private [203] [204] 

.method public [206] : [207] 
    .attribute [205] .code stack 8 locals 0 
L0:     aload_0 
L1:     invokespecial [21] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [23] 
L9:     aload_0 
L10:    aconst_null 
L11:    putfield [24] 
L14:    aload_0 
L15:    iconst_2 
L16:    newarray long 
L18:    putfield [25] 
L21:    aload_0 
L22:    iconst_2 
L23:    newarray boolean 
L25:    dup 
L26:    iconst_0 
L27:    iconst_0 
L28:    bastore 
L29:    dup 
L30:    iconst_1 
L31:    iconst_0 
L32:    bastore 
L33:    putfield [26] 
L36:    aload_0 
L37:    iconst_2 
L38:    newarray int 
L40:    dup 
L41:    iconst_0 
L42:    sipush 500 
L45:    iastore 
L46:    dup 
L47:    iconst_1 
L48:    sipush 500 
L51:    iastore 
L52:    putfield [27] 
L55:    aload_0 
L56:    iconst_2 
L57:    anewarray [2] 
L60:    dup 
L61:    iconst_0 
L62:    new [28] 
L65:    dup 
L66:    aload_0 
L67:    aconst_null 
L68:    invokespecial [22] 
L71:    aastore 
L72:    dup 
L73:    iconst_1 
L74:    new [28] 
L77:    dup 
L78:    aload_0 
L79:    aconst_null 
L80:    invokespecial [22] 
L83:    aastore 
L84:    putfield [29] 
L87:    aload_0 
L88:    aconst_null 
L89:    putfield [30] 
L92:    aload_0 
L93:    iconst_0 
L94:    putfield [31] 
L97:    aload_0 
L98:    aload_1 
L99:    putfield [32] 
L102:   return 
L103:   nop 
L104:   
    .end code 
.end method 

.method public [208] : [209] 
    .attribute [205] .code stack 5 locals 0 
L0:     aload_0 
L1:     iconst_2 
L2:     newarray int 
L4:     dup 
L5:     iconst_0 
L6:     iconst_0 
L7:     iastore 
L8:     dup 
L9:     iconst_1 
L10:    iconst_0 
L11:    iastore 
L12:    putfield [23] 
L15:    aload_0 
L16:    iconst_2 
L17:    newarray int 
L19:    dup 
L20:    iconst_0 
L21:    iconst_0 
L22:    iastore 
L23:    dup 
L24:    iconst_1 
L25:    iconst_0 
L26:    iastore 
L27:    putfield [24] 
L30:    aload_0 
L31:    aload_1 
L32:    aload_0 
L33:    getfield [13] 
L36:    aload_0 
L37:    getfield [12] 
L40:    aload_0 
L41:    getfield [14] 
L44:    invokestatic [4] 
L47:    putfield [30] 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [210] : [211] 
    .attribute [205] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     ifnull L14 
L7:     aload_0 
L8:     getfield [15] 
L11:    invokevirtual [18] 
L14:    aload_0 
L15:    aconst_null 
L16:    putfield [30] 
L19:    return 
L20:    
    .end code 
.end method 

.method public interface [212] : [213] 
    .attribute [205] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [214] : [215] 
    .attribute [205] .code stack 4 locals 5 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [31] 
L5:     iload_2 
L6:     ifne L13 
L9:     iconst_1 
L10:    goto L14 
L13:    iconst_0 
L14:    istore_3 
L15:    iload_1 
L16:    ifeq L52 
L19:    aload_0 
L20:    getfield [10] 
L23:    iload_2 
L24:    iconst_1 
L25:    iastore 
L26:    aload_0 
L27:    getfield [10] 
L30:    iload_3 
L31:    iconst_0 
L32:    iastore 
L33:    aload_0 
L34:    getfield [15] 
L37:    iload_2 
L38:    invokevirtual [19] 
L41:    aload_0 
L42:    getfield [15] 
L45:    iload_3 
L46:    invokevirtual [19] 
L49:    goto L201 
L52:    aload_0 
L53:    getfield [10] 
L56:    iload_2 
L57:    iaload 
L58:    iconst_1 
L59:    if_icmpne L100 
L62:    aload_0 
L63:    getfield [15] 
L66:    iload_2 
L67:    invokevirtual [20] 
L70:    pop 
L71:    aload_0 
L72:    getfield [10] 
L75:    iload_2 
L76:    iconst_2 
L77:    iastore 
L78:    aload_0 
L79:    getfield [11] 
L82:    iload_2 
L83:    aload_0 
L84:    getfield [17] 
L87:    invokeinterface [33] 0 
L92:    lastore 
L93:    iconst_1 
L94:    istore_1 
L95:    aload_0 
L96:    iconst_1 
L97:    putfield [31] 
L100:   aload_0 
L101:   getfield [10] 
L104:   iload_2 
L105:   iaload 
L106:   iconst_2 
L107:   if_icmpne L201 
L110:   aload_0 
L111:   getfield [9] 
L114:   iload_2 
L115:   iaload 
L116:   iconst_1 
L117:   if_icmpeq L137 
L120:   aload_0 
L121:   getfield [10] 
L124:   iload_2 
L125:   iconst_0 
L126:   iastore 
L127:   iconst_0 
L128:   istore_1 
L129:   aload_0 
L130:   iconst_1 
L131:   putfield [31] 
L134:   goto L201 
L137:   aload_0 
L138:   getfield [17] 
L141:   invokeinterface [33] 0 
L146:   lstore 4 
L148:   lload 4 
L150:   aload_0 
L151:   getfield [11] 
L154:   iload_2 
L155:   laload 
L156:   lsub 
L157:   lstore 6 
L159:   lload 6 
L161:   ldc_w [1] 
L164:   lcmp 
L165:   ifle L186 
L168:   aload_0 
L169:   getfield [15] 
L172:   iload_2 
L173:   invokevirtual [19] 
L176:   aload_0 
L177:   getfield [10] 
L180:   iload_2 
L181:   iconst_0 
L182:   iastore 
L183:   goto L196 
L186:   aload_0 
L187:   getfield [11] 
L190:   iload_2 
L191:   lload 4 
L193:   lastore 
L194:   iconst_1 
L195:   istore_1 
L196:   aload_0 
L197:   iconst_1 
L198:   putfield [31] 
L201:   iload_1 
L202:   areturn 
L203:   nop 
L204:   
    .end code 
.end method 

.method static synthetic [216] : [217] 
    .attribute [205] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [35] 
.const [3] = Class [36] 
.const [4] = Method [37] [38] 
.const [5] = Class [39] 
.const [6] = Class [40] 
.const [7] = Class [41] 
.const [8] = Class [42] 
.const [9] = Field [43] [44] 
.const [10] = Field [45] [46] 
.const [11] = Field [47] [48] 
.const [12] = Field [49] [50] 
.const [13] = Field [51] [52] 
.const [14] = Field [53] [54] 
.const [15] = Field [55] [56] 
.const [16] = Field [57] [58] 
.const [17] = Field [59] [60] 
.const [18] = Method [61] [62] 
.const [19] = Method [63] [64] 
.const [20] = Method [65] [66] 
.const [21] = Method [67] [68] 
.const [22] = Method [69] [70] 
.const [23] = Field [71] [72] 
.const [24] = Field [73] [74] 
.const [25] = Field [75] [76] 
.const [26] = Field [77] [78] 
.const [27] = Field [79] [80] 
.const [28] = Class [81] 
.const [29] = Field [82] [83] 
.const [30] = Field [84] [85] 
.const [31] = Field [86] [87] 
.const [32] = Field [88] [89] 
.const [33] = InterfaceMethod [90] [91] 
.const [34] = Int -939524096 
.const [35] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/ITimer 
.const [36] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/FangschaltungHandler$TimerOp 
.const [37] = Class [92] 
.const [38] = NameAndType [93] [94] 
.const [39] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/FangschaltungHandler 
.const [40] = Utf8 java/lang/Object 
.const [41] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/TimerHandler 
.const [42] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [43] = Class [95] 
.const [44] = NameAndType [96] [97] 
.const [45] = Class [98] 
.const [46] = NameAndType [99] [100] 
.const [47] = Class [101] 
.const [48] = NameAndType [102] [103] 
.const [49] = Class [104] 
.const [50] = NameAndType [105] [106] 
.const [51] = Class [107] 
.const [52] = NameAndType [108] [109] 
.const [53] = Class [110] 
.const [54] = NameAndType [111] [112] 
.const [55] = Class [113] 
.const [56] = NameAndType [114] [115] 
.const [57] = Class [116] 
.const [58] = NameAndType [117] [118] 
.const [59] = Class [119] 
.const [60] = NameAndType [120] [121] 
.const [61] = Class [122] 
.const [62] = NameAndType [123] [124] 
.const [63] = Class [125] 
.const [64] = NameAndType [126] [127] 
.const [65] = Class [128] 
.const [66] = NameAndType [129] [130] 
.const [67] = Class [131] 
.const [68] = NameAndType [132] [133] 
.const [69] = Class [134] 
.const [70] = NameAndType [135] [136] 
.const [71] = Class [137] 
.const [72] = NameAndType [138] [139] 
.const [73] = Class [140] 
.const [74] = NameAndType [141] [142] 
.const [75] = Class [143] 
.const [76] = NameAndType [144] [145] 
.const [77] = Class [146] 
.const [78] = NameAndType [147] [148] 
.const [79] = Class [149] 
.const [80] = NameAndType [150] [151] 
.const [81] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/FangschaltungHandler$TimerOp 
.const [82] = Class [152] 
.const [83] = NameAndType [153] [154] 
.const [84] = Class [155] 
.const [85] = NameAndType [156] [157] 
.const [86] = Class [158] 
.const [87] = NameAndType [159] [160] 
.const [88] = Class [161] 
.const [89] = NameAndType [162] [163] 
.const [90] = Class [164] 
.const [91] = NameAndType [165] [166] 
.const [92] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/TimerHandler 
.const [93] = Utf8 newInstance 
.const [94] = Utf8 (Lde/audi/atip/hmi/event/EventDispatcher;[I[Z[Lde/esolutions/hmi/widgets/audi/evo/widgets/multiline/ITimer;)Lde/esolutions/hmi/widgets/audi/evo/widgets/multiline/TimerHandler; 
.const [95] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/FangschaltungHandler 
.const [96] = Utf8 m_timerState 
.const [97] = Utf8 [I 
.const [98] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/FangschaltungHandler 
.const [99] = Utf8 m_fangschaltungState 
.const [100] = Utf8 [I 
.const [101] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/FangschaltungHandler 
.const [102] = Utf8 m_fangschaltungLastClick 
.const [103] = Utf8 [J 
.const [104] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/FangschaltungHandler 
.const [105] = Utf8 timerResets 
.const [106] = Utf8 [Z 
.const [107] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/FangschaltungHandler 
.const [108] = Utf8 timerDelays 
.const [109] = Utf8 [I 
.const [110] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/FangschaltungHandler 
.const [111] = Utf8 timerOps 
.const [112] = Utf8 [Lde/esolutions/hmi/widgets/audi/evo/widgets/multiline/ITimer; 
.const [113] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/FangschaltungHandler 
.const [114] = Utf8 m_timerHandler 
.const [115] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/multiline/TimerHandler; 
.const [116] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/FangschaltungHandler 
.const [117] = Utf8 shouldBreak 
.const [118] = Utf8 Z 
.const [119] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/FangschaltungHandler 
.const [120] = Utf8 m_framework 
.const [121] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [122] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/TimerHandler 
.const [123] = Utf8 cancelTimers 
.const [124] = Utf8 ()V 
.const [125] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/TimerHandler 
.const [126] = Utf8 cancelTimer 
.const [127] = Utf8 (I)V 
.const [128] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/TimerHandler 
.const [129] = Utf8 enqueueTimer 
.const [130] = Utf8 (I)Z 
.const [131] = Utf8 java/lang/Object 
.const [132] = Utf8 <init> 
.const [133] = Utf8 ()V 
.const [134] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/FangschaltungHandler$TimerOp 
.const [135] = Utf8 <init> 
.const [136] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/multiline/FangschaltungHandler;Lde/esolutions/hmi/widgets/audi/evo/widgets/multiline/FangschaltungHandler$1;)V 
.const [137] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/FangschaltungHandler 
.const [138] = Utf8 m_timerState 
.const [139] = Utf8 [I 
.const [140] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/FangschaltungHandler 
.const [141] = Utf8 m_fangschaltungState 
.const [142] = Utf8 [I 
.const [143] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/FangschaltungHandler 
.const [144] = Utf8 m_fangschaltungLastClick 
.const [145] = Utf8 [J 
.const [146] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/FangschaltungHandler 
.const [147] = Utf8 timerResets 
.const [148] = Utf8 [Z 
.const [149] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/FangschaltungHandler 
.const [150] = Utf8 timerDelays 
.const [151] = Utf8 [I 
.const [152] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/FangschaltungHandler 
.const [153] = Utf8 timerOps 
.const [154] = Utf8 [Lde/esolutions/hmi/widgets/audi/evo/widgets/multiline/ITimer; 
.const [155] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/FangschaltungHandler 
.const [156] = Utf8 m_timerHandler 
.const [157] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/multiline/TimerHandler; 
.const [158] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/FangschaltungHandler 
.const [159] = Utf8 shouldBreak 
.const [160] = Utf8 Z 
.const [161] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/FangschaltungHandler 
.const [162] = Utf8 m_framework 
.const [163] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [164] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [165] = Utf8 getMonotonicTime 
.const [166] = Utf8 ()J 
.const [167] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/FangschaltungHandler 
.const [168] = Class [167] 
.const [169] = Utf8 java/lang/Object 
.const [170] = Class [169] 
.const [171] = Utf8 TIMER_IDLE 
.const [172] = Utf8 I 
.const [173] = Utf8 TIMER_RUNNING 
.const [174] = Utf8 I 
.const [175] = Utf8 TIMER_TIMED_OUT 
.const [176] = Utf8 I 
.const [177] = Utf8 TIMER_CANCELED 
.const [178] = Utf8 I 
.const [179] = Utf8 FANGSCHALTUNG_DISABLED 
.const [180] = Utf8 I 
.const [181] = Utf8 FANGSCHALTUNG_ACTIVATE_ON_REACHING_EDGE 
.const [182] = Utf8 I 
.const [183] = Utf8 FANGSCHALTUNG_WAIT_FOR_TIMEOUT 
.const [184] = Utf8 I 
.const [185] = Utf8 FANGSCHALTUNG_CANCEL_TIMERS_DELTA_BETWEEN_CLICKS 
.const [186] = Utf8 J 
.const [187] = Utf8 m_timerState 
.const [188] = Utf8 [I 
.const [189] = Utf8 m_fangschaltungState 
.const [190] = Utf8 [I 
.const [191] = Utf8 m_fangschaltungLastClick 
.const [192] = Utf8 [J 
.const [193] = Utf8 timerResets 
.const [194] = Utf8 [Z 
.const [195] = Utf8 timerDelays 
.const [196] = Utf8 [I 
.const [197] = Utf8 m_framework 
.const [198] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [199] = Utf8 timerOps 
.const [200] = Utf8 [Lde/esolutions/hmi/widgets/audi/evo/widgets/multiline/ITimer; 
.const [201] = Utf8 m_timerHandler 
.const [202] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/multiline/TimerHandler; 
.const [203] = Utf8 shouldBreak 
.const [204] = Utf8 Z 
.const [205] = Utf8 Code 
.const [206] = Utf8 <init> 
.const [207] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)V 
.const [208] = Utf8 init 
.const [209] = Utf8 (Lde/audi/atip/hmi/event/EventDispatcher;)V 
.const [210] = Utf8 deinit 
.const [211] = Utf8 ()V 
.const [212] = Utf8 doBreak 
.const [213] = Utf8 ()Z 
.const [214] = Utf8 handleFangschaltung 
.const [215] = Utf8 (ZI)Z 
.const [216] = Utf8 access$000 
.const [217] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/multiline/FangschaltungHandler;)[I 
.end class 
