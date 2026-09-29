.version 50 0 
.class public super [417] 
.super [419] 
.field private static final [420] [421] 
.field private static [422] [423] 
.field private [424] [425] 

.method public [427] : [428] 
    .attribute [426] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [56] 
L4:     dup 
L5:     ldc [3] 
L7:     invokestatic [4] 
L10:    ldc [5] 
L12:    ldc [6] 
L14:    invokespecial [50] 
L17:    invokespecial [51] 
L20:    aload_0 
L21:    aload_1 
L22:    putfield [57] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private static synchronized [429] : [430] 
    .attribute [426] .code stack 2 locals 1 
L0:     getstatic [7] 
L3:     iconst_1 
L4:     iadd 
L5:     dup 
L6:     putstatic [52] 
L9:     istore_0 
L10:    iload_0 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [431] : [432] 
    .attribute [426] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [433] : [434] 
    .attribute [426] .code stack 9 locals 8 
        .catch [24] from L0 to L1313 using L1316 
L0:     iload_1 
L1:     tableswitch 0 
            L1212 
            L1286 
            L1286 
            L1286 
            L906 
            L1286 
            L1286 
            L1286 
            L1286 
            L686 
            L1286 
            L998 
            L1286 
            L1286 
            L1286 
            L1286 
            L1286 
            L592 
            L1286 
            L938 
            L1286 
            L968 
            L1286 
            L1286 
            L1286 
            L812 
            L1286 
            L1286 
            L1286 
            L1286 
            L1286 
            L790 
            L1286 
            L1286 
            L1286 
            L1286 
            L1286 
            L1286 
            L1286 
            L1286 
            L408 
            L1254 
            L1286 
            L1286 
            L1286 
            L1286 
            L388 
            L1286 
            L1286 
            L1286 
            L1286 
            L1286 
            L1286 
            L1286 
            L876 
            L1286 
            L656 
            L1286 
            L1286 
            L1160 
            L1286 
            L1286 
            L1286 
            L1286 
            L624 
            L1286 
            L368 
            L348 
            L470 
            L1020 
            L1072 
            L522 
            L1286 
            L1286 
            L844 
            L1286 
            L728 
            L1286 
            L1286 
            L1286 
            L1182 
            L440 
            L760 
            default : L1286 

L348:   aload_2 
L349:   invokestatic [9] 
L352:   astore 4 
L354:   aload_0 
L355:   getfield [45] 
L358:   aload 4 
L360:   invokeinterface [58] 0 
L365:   goto L1313 
L368:   aload_2 
L369:   invokestatic [10] 
L372:   astore 4 
L374:   aload_0 
L375:   getfield [45] 
L378:   aload 4 
L380:   invokeinterface [59] 0 
L385:   goto L1313 
L388:   aload_2 
L389:   invokestatic [11] 
L392:   astore 4 
L394:   aload_0 
L395:   getfield [45] 
L398:   aload 4 
L400:   invokeinterface [60] 0 
L405:   goto L1313 
L408:   aload_2 
L409:   invokeinterface [61] 0 
L414:   istore 4 
L416:   aload_2 
L417:   invokeinterface [62] 0 
L422:   istore 5 
L424:   aload_0 
L425:   getfield [45] 
L428:   iload 4 
L430:   iload 5 
L432:   invokeinterface [63] 0 
L437:   goto L1313 
L440:   aload_2 
L441:   invokestatic [12] 
L444:   astore 4 
L446:   aload_2 
L447:   invokeinterface [62] 0 
L452:   istore 5 
L454:   aload_0 
L455:   getfield [45] 
L458:   aload 4 
L460:   iload 5 
L462:   invokeinterface [64] 0 
L467:   goto L1313 
L470:   aload_2 
L471:   invokeinterface [61] 0 
L476:   istore 4 
L478:   aload_2 
L479:   invokeinterface [65] 0 
L484:   astore 5 
L486:   aload_2 
L487:   invokeinterface [62] 0 
L492:   istore 6 
L494:   aload_2 
L495:   invokeinterface [62] 0 
L500:   istore 7 
L502:   aload_0 
L503:   getfield [45] 
L506:   iload 4 
L508:   aload 5 
L510:   iload 6 
L512:   iload 7 
L514:   invokeinterface [66] 0 
L519:   goto L1313 
L522:   aload_2 
L523:   invokeinterface [62] 0 
L528:   istore 4 
L530:   aload_2 
L531:   invokeinterface [62] 0 
L536:   istore 5 
L538:   aload_2 
L539:   invokestatic [13] 
L542:   astore 6 
L544:   aload_2 
L545:   invokeinterface [62] 0 
L550:   istore 7 
L552:   aload_2 
L553:   invokeinterface [62] 0 
L558:   istore 8 
L560:   aload_2 
L561:   invokeinterface [62] 0 
L566:   istore 9 
L568:   aload_0 
L569:   getfield [45] 
L572:   iload 4 
L574:   iload 5 
L576:   aload 6 
L578:   iload 7 
L580:   iload 8 
L582:   iload 9 
L584:   invokeinterface [67] 0 
L589:   goto L1313 
L592:   aload_2 
L593:   invokeinterface [62] 0 
L598:   istore 4 
L600:   aload_2 
L601:   invokeinterface [62] 0 
L606:   istore 5 
L608:   aload_0 
L609:   getfield [45] 
L612:   iload 4 
L614:   iload 5 
L616:   invokeinterface [68] 0 
L621:   goto L1313 
L624:   aload_2 
L625:   invokeinterface [62] 0 
L630:   istore 4 
L632:   aload_2 
L633:   invokeinterface [62] 0 
L638:   istore 5 
L640:   aload_0 
L641:   getfield [45] 
L644:   iload 4 
L646:   iload 5 
L648:   invokeinterface [69] 0 
L653:   goto L1313 
L656:   aload_2 
L657:   invokestatic [10] 
L660:   astore 4 
L662:   aload_2 
L663:   invokeinterface [62] 0 
L668:   istore 5 
L670:   aload_0 
L671:   getfield [45] 
L674:   aload 4 
L676:   iload 5 
L678:   invokeinterface [70] 0 
L683:   goto L1313 
L686:   aload_2 
L687:   invokeinterface [62] 0 
L692:   istore 4 
L694:   aload_2 
L695:   invokeinterface [62] 0 
L700:   istore 5 
L702:   aload_2 
L703:   invokeinterface [62] 0 
L708:   istore 6 
L710:   aload_0 
L711:   getfield [45] 
L714:   iload 4 
L716:   iload 5 
L718:   iload 6 
L720:   invokeinterface [71] 0 
L725:   goto L1313 
L728:   aload_2 
L729:   invokeinterface [62] 0 
L734:   istore 4 
L736:   aload_2 
L737:   invokeinterface [62] 0 
L742:   istore 5 
L744:   aload_0 
L745:   getfield [45] 
L748:   iload 4 
L750:   iload 5 
L752:   invokeinterface [72] 0 
L757:   goto L1313 
L760:   aload_2 
L761:   invokeinterface [62] 0 
L766:   istore 4 
L768:   aload_2 
L769:   invokestatic [14] 
L772:   astore 5 
L774:   aload_0 
L775:   getfield [45] 
L778:   iload 4 
L780:   aload 5 
L782:   invokeinterface [73] 0 
L787:   goto L1313 
L790:   aload_2 
L791:   invokeinterface [62] 0 
L796:   istore 4 
L798:   aload_0 
L799:   getfield [45] 
L802:   iload 4 
L804:   invokeinterface [74] 0 
L809:   goto L1313 
L812:   aload_2 
L813:   invokeinterface [62] 0 
L818:   istore 4 
L820:   aload_2 
L821:   invokeinterface [65] 0 
L826:   astore 5 
L828:   aload_0 
L829:   getfield [45] 
L832:   iload 4 
L834:   aload 5 
L836:   invokeinterface [75] 0 
L841:   goto L1313 
L844:   aload_2 
L845:   invokeinterface [62] 0 
L850:   istore 4 
L852:   aload_2 
L853:   invokeinterface [65] 0 
L858:   astore 5 
L860:   aload_0 
L861:   getfield [45] 
L864:   iload 4 
L866:   aload 5 
L868:   invokeinterface [76] 0 
L873:   goto L1313 
L876:   aload_2 
L877:   invokeinterface [62] 0 
L882:   istore 4 
L884:   aload_2 
L885:   invokestatic [15] 
L888:   astore 5 
L890:   aload_0 
L891:   getfield [45] 
L894:   iload 4 
L896:   aload 5 
L898:   invokeinterface [77] 0 
L903:   goto L1313 
L906:   aload_2 
L907:   invokeinterface [62] 0 
L912:   istore 4 
L914:   aload_2 
L915:   invokeinterface [62] 0 
L920:   istore 5 
L922:   aload_0 
L923:   getfield [45] 
L926:   iload 4 
L928:   iload 5 
L930:   invokeinterface [78] 0 
L935:   goto L1313 
L938:   aload_2 
L939:   invokeinterface [62] 0 
L944:   istore 4 
L946:   aload_2 
L947:   invokestatic [16] 
L950:   astore 5 
L952:   aload_0 
L953:   getfield [45] 
L956:   iload 4 
L958:   aload 5 
L960:   invokeinterface [79] 0 
L965:   goto L1313 
L968:   aload_2 
L969:   invokeinterface [62] 0 
L974:   istore 4 
L976:   aload_2 
L977:   invokestatic [17] 
L980:   astore 5 
L982:   aload_0 
L983:   getfield [45] 
L986:   iload 4 
L988:   aload 5 
L990:   invokeinterface [80] 0 
L995:   goto L1313 
L998:   aload_2 
L999:   invokeinterface [62] 0 
L1004:  istore 4 
L1006:  aload_0 
L1007:  getfield [45] 
L1010:  iload 4 
L1012:  invokeinterface [81] 0 
L1017:  goto L1313 
L1020:  aload_2 
L1021:  invokeinterface [62] 0 
L1026:  istore 4 
L1028:  aload_2 
L1029:  invokeinterface [62] 0 
L1034:  istore 5 
L1036:  aload_2 
L1037:  invokeinterface [62] 0 
L1042:  istore 6 
L1044:  aload_2 
L1045:  invokeinterface [65] 0 
L1050:  astore 7 
L1052:  aload_0 
L1053:  getfield [45] 
L1056:  iload 4 
L1058:  iload 5 
L1060:  iload 6 
L1062:  aload 7 
L1064:  invokeinterface [82] 0 
L1069:  goto L1313 
L1072:  aload_2 
L1073:  invokeinterface [83] 0 
L1078:  astore 4 
L1080:  aload_2 
L1081:  invokeinterface [62] 0 
L1086:  istore 5 
L1088:  aload_2 
L1089:  invokeinterface [62] 0 
L1094:  istore 6 
L1096:  aload_2 
L1097:  invokestatic [18] 
L1100:  astore 7 
L1102:  aload_2 
L1103:  invokeinterface [65] 0 
L1108:  astore 8 
L1110:  aload_2 
L1111:  invokeinterface [65] 0 
L1116:  astore 9 
L1118:  aload_2 
L1119:  invokestatic [19] 
L1122:  astore 10 
L1124:  aload_2 
L1125:  invokeinterface [62] 0 
L1130:  istore 11 
L1132:  aload_0 
L1133:  getfield [45] 
L1136:  aload 4 
L1138:  iload 5 
L1140:  iload 6 
L1142:  aload 7 
L1144:  aload 8 
L1146:  aload 9 
L1148:  aload 10 
L1150:  iload 11 
L1152:  invokeinterface [84] 0 
L1157:  goto L1313 
L1160:  aload_2 
L1161:  invokeinterface [62] 0 
L1166:  istore 4 
L1168:  aload_0 
L1169:  getfield [45] 
L1172:  iload 4 
L1174:  invokeinterface [85] 0 
L1179:  goto L1313 
L1182:  aload_2 
L1183:  invokeinterface [62] 0 
L1188:  istore 4 
L1190:  aload_2 
L1191:  invokestatic [20] 
L1194:  astore 5 
L1196:  aload_0 
L1197:  getfield [45] 
L1200:  iload 4 
L1202:  aload 5 
L1204:  invokeinterface [86] 0 
L1209:  goto L1313 
L1212:  aload_2 
L1213:  invokeinterface [62] 0 
L1218:  istore 4 
L1220:  aload_2 
L1221:  invokeinterface [65] 0 
L1226:  astore 5 
L1228:  aload_2 
L1229:  invokeinterface [62] 0 
L1234:  istore 6 
L1236:  aload_0 
L1237:  getfield [45] 
L1240:  iload 4 
L1242:  aload 5 
L1244:  iload 6 
L1246:  invokeinterface [87] 0 
L1251:  goto L1313 
L1254:  aload_2 
L1255:  invokeinterface [65] 0 
L1260:  astore 4 
L1262:  aload_2 
L1263:  invokeinterface [65] 0 
L1268:  astore 5 
L1270:  aload_0 
L1271:  getfield [45] 
L1274:  aload 4 
L1276:  aload 5 
L1278:  invokeinterface [88] 0 
L1283:  goto L1313 
L1286:  new [89] 
L1289:  dup 
L1290:  new [90] 
L1293:  dup 
L1294:  invokespecial [54] 
L1297:  ldc [23] 
L1299:  invokevirtual [46] 
L1302:  iload_1 
L1303:  invokevirtual [47] 
L1306:  invokevirtual [48] 
L1309:  invokespecial [55] 
L1312:  athrow 
L1313:  goto L1358 
L1316:  astore 4 
L1318:  new [89] 
L1321:  dup 
L1322:  new [90] 
L1325:  dup 
L1326:  invokespecial [54] 
L1329:  ldc [25] 
L1331:  invokevirtual [46] 
L1334:  iload_1 
L1335:  invokevirtual [47] 
L1338:  ldc [26] 
L1340:  invokevirtual [46] 
L1343:  aload 4 
L1345:  invokevirtual [49] 
L1348:  invokevirtual [46] 
L1351:  invokevirtual [48] 
L1354:  invokespecial [55] 
L1357:  athrow 
L1358:  return 
L1359:  nop 
L1360:  
    .end code 
.end method 

.method static [435] : [436] 
    .attribute [426] .code stack 1 locals 0 
L0:     ldc [27] 
L2:     invokestatic [28] 
L5:     putstatic [53] 
L8:     iconst_0 
L9:     putstatic [52] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [91] 
.const [3] = String [92] 
.const [4] = Method [93] [94] 
.const [5] = String [95] 
.const [6] = String [96] 
.const [7] = Field [97] [98] 
.const [8] = Field [99] [100] 
.const [9] = Method [101] [102] 
.const [10] = Method [103] [104] 
.const [11] = Method [105] [106] 
.const [12] = Method [107] [108] 
.const [13] = Method [109] [110] 
.const [14] = Method [111] [112] 
.const [15] = Method [113] [114] 
.const [16] = Method [115] [116] 
.const [17] = Method [117] [118] 
.const [18] = Method [119] [120] 
.const [19] = Method [121] [122] 
.const [20] = Method [123] [124] 
.const [21] = Class [125] 
.const [22] = Class [126] 
.const [23] = String [127] 
.const [24] = Class [128] 
.const [25] = String [129] 
.const [26] = String [130] 
.const [27] = String [131] 
.const [28] = Method [132] [133] 
.const [29] = Class [134] 
.const [30] = Class [135] 
.const [31] = Class [136] 
.const [32] = Class [137] 
.const [33] = Class [138] 
.const [34] = Class [139] 
.const [35] = Class [140] 
.const [36] = Class [141] 
.const [37] = Class [142] 
.const [38] = Class [143] 
.const [39] = Class [144] 
.const [40] = Class [145] 
.const [41] = Class [146] 
.const [42] = Class [147] 
.const [43] = Class [148] 
.const [44] = Class [149] 
.const [45] = Field [150] [151] 
.const [46] = Method [152] [153] 
.const [47] = Method [154] [155] 
.const [48] = Method [156] [157] 
.const [49] = Method [158] [159] 
.const [50] = Method [160] [161] 
.const [51] = Method [162] [163] 
.const [52] = Field [164] [165] 
.const [53] = Field [166] [167] 
.const [54] = Method [168] [169] 
.const [55] = Method [170] [171] 
.const [56] = Class [172] 
.const [57] = Field [173] [174] 
.const [58] = InterfaceMethod [175] [176] 
.const [59] = InterfaceMethod [177] [178] 
.const [60] = InterfaceMethod [179] [180] 
.const [61] = InterfaceMethod [181] [182] 
.const [62] = InterfaceMethod [183] [184] 
.const [63] = InterfaceMethod [185] [186] 
.const [64] = InterfaceMethod [187] [188] 
.const [65] = InterfaceMethod [189] [190] 
.const [66] = InterfaceMethod [191] [192] 
.const [67] = InterfaceMethod [193] [194] 
.const [68] = InterfaceMethod [195] [196] 
.const [69] = InterfaceMethod [197] [198] 
.const [70] = InterfaceMethod [199] [200] 
.const [71] = InterfaceMethod [201] [202] 
.const [72] = InterfaceMethod [203] [204] 
.const [73] = InterfaceMethod [205] [206] 
.const [74] = InterfaceMethod [207] [208] 
.const [75] = InterfaceMethod [209] [210] 
.const [76] = InterfaceMethod [211] [212] 
.const [77] = InterfaceMethod [213] [214] 
.const [78] = InterfaceMethod [215] [216] 
.const [79] = InterfaceMethod [217] [218] 
.const [80] = InterfaceMethod [219] [220] 
.const [81] = InterfaceMethod [221] [222] 
.const [82] = InterfaceMethod [223] [224] 
.const [83] = InterfaceMethod [225] [226] 
.const [84] = InterfaceMethod [227] [228] 
.const [85] = InterfaceMethod [229] [230] 
.const [86] = InterfaceMethod [231] [232] 
.const [87] = InterfaceMethod [233] [234] 
.const [88] = InterfaceMethod [235] [236] 
.const [89] = Class [237] 
.const [90] = Class [238] 
.const [91] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [92] = Utf8 de638f1a-b4f1-53c5-ae36-09e21251513b 
.const [93] = Class [239] 
.const [94] = NameAndType [240] [241] 
.const [95] = Utf8 '7feed9a5-c7e8-572a-b6fd-2d260b6f2aa6' 
.const [96] = Utf8 'dsi.messaging.DSIMessaging' 
.const [97] = Class [242] 
.const [98] = NameAndType [243] [244] 
.const [99] = Class [245] 
.const [100] = NameAndType [246] [247] 
.const [101] = Class [248] 
.const [102] = NameAndType [249] [250] 
.const [103] = Class [251] 
.const [104] = NameAndType [252] [253] 
.const [105] = Class [254] 
.const [106] = NameAndType [255] [256] 
.const [107] = Class [257] 
.const [108] = NameAndType [258] [259] 
.const [109] = Class [260] 
.const [110] = NameAndType [261] [262] 
.const [111] = Class [263] 
.const [112] = NameAndType [264] [265] 
.const [113] = Class [266] 
.const [114] = NameAndType [267] [268] 
.const [115] = Class [269] 
.const [116] = NameAndType [270] [271] 
.const [117] = Class [272] 
.const [118] = NameAndType [273] [274] 
.const [119] = Class [275] 
.const [120] = NameAndType [276] [277] 
.const [121] = Class [278] 
.const [122] = NameAndType [279] [280] 
.const [123] = Class [281] 
.const [124] = NameAndType [282] [283] 
.const [125] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [126] = Utf8 java/lang/StringBuffer 
.const [127] = Utf8 'Invalid Method Id ' 
.const [128] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [129] = Utf8 'Deserialization failed: method=' 
.const [130] = Utf8 ', error=' 
.const [131] = Utf8 'STUB.dsi.messaging.DSIMessaging' 
.const [132] = Class [284] 
.const [133] = NameAndType [285] [286] 
.const [134] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingReplyService 
.const [135] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [136] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/StatusInformationSerializer 
.const [137] = Utf8 de/esolutions/fw/comm/dsi/messaging/DSIMessagingReply 
.const [138] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/FolderEntrySerializer 
.const [139] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/ListChangedInformationSerializer 
.const [140] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [141] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/MessagingAccountSerializer 
.const [142] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/ListEntrySerializer 
.const [143] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/MessageDetailsSerializer 
.const [144] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/ExtractedItemSerializer 
.const [145] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/TemplateSerializer 
.const [146] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/RecipientListSerializer 
.const [147] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/AttachmentInformationSerializer 
.const [148] = Utf8 de/esolutions/fw/comm/dsi/global/impl/ResourceLocatorSerializer 
.const [149] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [150] = Class [287] 
.const [151] = NameAndType [288] [289] 
.const [152] = Class [290] 
.const [153] = NameAndType [291] [292] 
.const [154] = Class [293] 
.const [155] = NameAndType [294] [295] 
.const [156] = Class [296] 
.const [157] = NameAndType [297] [298] 
.const [158] = Class [299] 
.const [159] = NameAndType [300] [301] 
.const [160] = Class [302] 
.const [161] = NameAndType [303] [304] 
.const [162] = Class [305] 
.const [163] = NameAndType [306] [307] 
.const [164] = Class [308] 
.const [165] = NameAndType [309] [310] 
.const [166] = Class [311] 
.const [167] = NameAndType [312] [313] 
.const [168] = Class [314] 
.const [169] = NameAndType [315] [316] 
.const [170] = Class [317] 
.const [171] = NameAndType [318] [319] 
.const [172] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [173] = Class [320] 
.const [174] = NameAndType [321] [322] 
.const [175] = Class [323] 
.const [176] = NameAndType [324] [325] 
.const [177] = Class [326] 
.const [178] = NameAndType [327] [328] 
.const [179] = Class [329] 
.const [180] = NameAndType [330] [331] 
.const [181] = Class [332] 
.const [182] = NameAndType [333] [334] 
.const [183] = Class [335] 
.const [184] = NameAndType [336] [337] 
.const [185] = Class [338] 
.const [186] = NameAndType [339] [340] 
.const [187] = Class [341] 
.const [188] = NameAndType [342] [343] 
.const [189] = Class [344] 
.const [190] = NameAndType [345] [346] 
.const [191] = Class [347] 
.const [192] = NameAndType [348] [349] 
.const [193] = Class [350] 
.const [194] = NameAndType [351] [352] 
.const [195] = Class [353] 
.const [196] = NameAndType [354] [355] 
.const [197] = Class [356] 
.const [198] = NameAndType [357] [358] 
.const [199] = Class [359] 
.const [200] = NameAndType [360] [361] 
.const [201] = Class [362] 
.const [202] = NameAndType [363] [364] 
.const [203] = Class [365] 
.const [204] = NameAndType [366] [367] 
.const [205] = Class [368] 
.const [206] = NameAndType [369] [370] 
.const [207] = Class [371] 
.const [208] = NameAndType [372] [373] 
.const [209] = Class [374] 
.const [210] = NameAndType [375] [376] 
.const [211] = Class [377] 
.const [212] = NameAndType [378] [379] 
.const [213] = Class [380] 
.const [214] = NameAndType [381] [382] 
.const [215] = Class [383] 
.const [216] = NameAndType [384] [385] 
.const [217] = Class [386] 
.const [218] = NameAndType [387] [388] 
.const [219] = Class [389] 
.const [220] = NameAndType [390] [391] 
.const [221] = Class [392] 
.const [222] = NameAndType [393] [394] 
.const [223] = Class [395] 
.const [224] = NameAndType [396] [397] 
.const [225] = Class [398] 
.const [226] = NameAndType [399] [400] 
.const [227] = Class [401] 
.const [228] = NameAndType [402] [403] 
.const [229] = Class [404] 
.const [230] = NameAndType [405] [406] 
.const [231] = Class [407] 
.const [232] = NameAndType [408] [409] 
.const [233] = Class [410] 
.const [234] = NameAndType [411] [412] 
.const [235] = Class [413] 
.const [236] = NameAndType [414] [415] 
.const [237] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [238] = Utf8 java/lang/StringBuffer 
.const [239] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingReplyService 
.const [240] = Utf8 nextDynamicHandle 
.const [241] = Utf8 ()I 
.const [242] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingReplyService 
.const [243] = Utf8 dynamicHandle 
.const [244] = Utf8 I 
.const [245] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingReplyService 
.const [246] = Utf8 context 
.const [247] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [248] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/StatusInformationSerializer 
.const [249] = Utf8 getOptionalStatusInformation 
.const [250] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/messaging/StatusInformation; 
.const [251] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/FolderEntrySerializer 
.const [252] = Utf8 getOptionalFolderEntry 
.const [253] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/messaging/FolderEntry; 
.const [254] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/ListChangedInformationSerializer 
.const [255] = Utf8 getOptionalListChangedInformation 
.const [256] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/messaging/ListChangedInformation; 
.const [257] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/MessagingAccountSerializer 
.const [258] = Utf8 getOptionalMessagingAccountVarArray 
.const [259] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/messaging/MessagingAccount; 
.const [260] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/ListEntrySerializer 
.const [261] = Utf8 getOptionalListEntryVarArray 
.const [262] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/messaging/ListEntry; 
.const [263] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/MessageDetailsSerializer 
.const [264] = Utf8 getOptionalMessageDetails 
.const [265] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/messaging/MessageDetails; 
.const [266] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/ExtractedItemSerializer 
.const [267] = Utf8 getOptionalExtractedItemVarArray 
.const [268] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/messaging/ExtractedItem; 
.const [269] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/TemplateSerializer 
.const [270] = Utf8 getOptionalTemplate 
.const [271] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/messaging/Template; 
.const [272] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/TemplateSerializer 
.const [273] = Utf8 getOptionalTemplateVarArray 
.const [274] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/messaging/Template; 
.const [275] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/RecipientListSerializer 
.const [276] = Utf8 getOptionalRecipientList 
.const [277] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/messaging/RecipientList; 
.const [278] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/AttachmentInformationSerializer 
.const [279] = Utf8 getOptionalAttachmentInformationVarArray 
.const [280] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/messaging/AttachmentInformation; 
.const [281] = Utf8 de/esolutions/fw/comm/dsi/global/impl/ResourceLocatorSerializer 
.const [282] = Utf8 getOptionalResourceLocator 
.const [283] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/global/ResourceLocator; 
.const [284] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [285] = Utf8 getContext 
.const [286] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [287] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingReplyService 
.const [288] = Utf8 p_DSIMessagingReply 
.const [289] = Utf8 Lde/esolutions/fw/comm/dsi/messaging/DSIMessagingReply; 
.const [290] = Utf8 java/lang/StringBuffer 
.const [291] = Utf8 append 
.const [292] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [293] = Utf8 java/lang/StringBuffer 
.const [294] = Utf8 append 
.const [295] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [296] = Utf8 java/lang/StringBuffer 
.const [297] = Utf8 toString 
.const [298] = Utf8 ()Ljava/lang/String; 
.const [299] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [300] = Utf8 getMessage 
.const [301] = Utf8 ()Ljava/lang/String; 
.const [302] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [303] = Utf8 <init> 
.const [304] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [305] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [306] = Utf8 <init> 
.const [307] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [308] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingReplyService 
.const [309] = Utf8 dynamicHandle 
.const [310] = Utf8 I 
.const [311] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingReplyService 
.const [312] = Utf8 context 
.const [313] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [314] = Utf8 java/lang/StringBuffer 
.const [315] = Utf8 <init> 
.const [316] = Utf8 ()V 
.const [317] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [318] = Utf8 <init> 
.const [319] = Utf8 (Ljava/lang/String;)V 
.const [320] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingReplyService 
.const [321] = Utf8 p_DSIMessagingReply 
.const [322] = Utf8 Lde/esolutions/fw/comm/dsi/messaging/DSIMessagingReply; 
.const [323] = Utf8 de/esolutions/fw/comm/dsi/messaging/DSIMessagingReply 
.const [324] = Utf8 indicateMessageStatus 
.const [325] = Utf8 (Lorg/dsi/ifc/messaging/StatusInformation;)V 
.const [326] = Utf8 de/esolutions/fw/comm/dsi/messaging/DSIMessagingReply 
.const [327] = Utf8 indicateFolderInformation 
.const [328] = Utf8 (Lorg/dsi/ifc/messaging/FolderEntry;)V 
.const [329] = Utf8 de/esolutions/fw/comm/dsi/messaging/DSIMessagingReply 
.const [330] = Utf8 indicateListChanged 
.const [331] = Utf8 (Lorg/dsi/ifc/messaging/ListChangedInformation;)V 
.const [332] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [333] = Utf8 getBool 
.const [334] = Utf8 ()Z 
.const [335] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [336] = Utf8 getInt32 
.const [337] = Utf8 ()I 
.const [338] = Utf8 de/esolutions/fw/comm/dsi/messaging/DSIMessagingReply 
.const [339] = Utf8 updateSynchInProgress 
.const [340] = Utf8 (ZI)V 
.const [341] = Utf8 de/esolutions/fw/comm/dsi/messaging/DSIMessagingReply 
.const [342] = Utf8 updateMessagingAccounts 
.const [343] = Utf8 ([Lorg/dsi/ifc/messaging/MessagingAccount;I)V 
.const [344] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [345] = Utf8 getOptionalString 
.const [346] = Utf8 ()Ljava/lang/String; 
.const [347] = Utf8 de/esolutions/fw/comm/dsi/messaging/DSIMessagingReply 
.const [348] = Utf8 indicateNewMessage 
.const [349] = Utf8 (ZLjava/lang/String;II)V 
.const [350] = Utf8 de/esolutions/fw/comm/dsi/messaging/DSIMessagingReply 
.const [351] = Utf8 listEntriesResponse 
.const [352] = Utf8 (II[Lorg/dsi/ifc/messaging/ListEntry;III)V 
.const [353] = Utf8 de/esolutions/fw/comm/dsi/messaging/DSIMessagingReply 
.const [354] = Utf8 getPositionOfMessageResponse 
.const [355] = Utf8 (II)V 
.const [356] = Utf8 de/esolutions/fw/comm/dsi/messaging/DSIMessagingReply 
.const [357] = Utf8 getPositionOfFolderResponse 
.const [358] = Utf8 (II)V 
.const [359] = Utf8 de/esolutions/fw/comm/dsi/messaging/DSIMessagingReply 
.const [360] = Utf8 changeFolderResponse 
.const [361] = Utf8 (Lorg/dsi/ifc/messaging/FolderEntry;I)V 
.const [362] = Utf8 de/esolutions/fw/comm/dsi/messaging/DSIMessagingReply 
.const [363] = Utf8 deleteMessageResponse 
.const [364] = Utf8 (III)V 
.const [365] = Utf8 de/esolutions/fw/comm/dsi/messaging/DSIMessagingReply 
.const [366] = Utf8 sendMessageResponse 
.const [367] = Utf8 (II)V 
.const [368] = Utf8 de/esolutions/fw/comm/dsi/messaging/DSIMessagingReply 
.const [369] = Utf8 getMessageContentsResponse 
.const [370] = Utf8 (ILorg/dsi/ifc/messaging/MessageDetails;)V 
.const [371] = Utf8 de/esolutions/fw/comm/dsi/messaging/DSIMessagingReply 
.const [372] = Utf8 setMessageReadStatusResponse 
.const [373] = Utf8 (I)V 
.const [374] = Utf8 de/esolutions/fw/comm/dsi/messaging/DSIMessagingReply 
.const [375] = Utf8 parseVCardResponse 
.const [376] = Utf8 (ILjava/lang/String;)V 
.const [377] = Utf8 de/esolutions/fw/comm/dsi/messaging/DSIMessagingReply 
.const [378] = Utf8 saveAsDraftResponse 
.const [379] = Utf8 (ILjava/lang/String;)V 
.const [380] = Utf8 de/esolutions/fw/comm/dsi/messaging/DSIMessagingReply 
.const [381] = Utf8 extractInformationResponse 
.const [382] = Utf8 (I[Lorg/dsi/ifc/messaging/ExtractedItem;)V 
.const [383] = Utf8 de/esolutions/fw/comm/dsi/messaging/DSIMessagingReply 
.const [384] = Utf8 changeTemplateResponse 
.const [385] = Utf8 (II)V 
.const [386] = Utf8 de/esolutions/fw/comm/dsi/messaging/DSIMessagingReply 
.const [387] = Utf8 getTemplateResponse 
.const [388] = Utf8 (ILorg/dsi/ifc/messaging/Template;)V 
.const [389] = Utf8 de/esolutions/fw/comm/dsi/messaging/DSIMessagingReply 
.const [390] = Utf8 getTemplatesResponse 
.const [391] = Utf8 (I[Lorg/dsi/ifc/messaging/Template;)V 
.const [392] = Utf8 de/esolutions/fw/comm/dsi/messaging/DSIMessagingReply 
.const [393] = Utf8 deleteTemplateResponse 
.const [394] = Utf8 (I)V 
.const [395] = Utf8 de/esolutions/fw/comm/dsi/messaging/DSIMessagingReply 
.const [396] = Utf8 indicatePushMessageFailed 
.const [397] = Utf8 (IIILjava/lang/String;)V 
.const [398] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [399] = Utf8 getOptionalInt32VarArray 
.const [400] = Utf8 ()[I 
.const [401] = Utf8 de/esolutions/fw/comm/dsi/messaging/DSIMessagingReply 
.const [402] = Utf8 indicateSendMessage 
.const [403] = Utf8 ([IIILorg/dsi/ifc/messaging/RecipientList;Ljava/lang/String;Ljava/lang/String;[Lorg/dsi/ifc/messaging/AttachmentInformation;I)V 
.const [404] = Utf8 de/esolutions/fw/comm/dsi/messaging/DSIMessagingReply 
.const [405] = Utf8 deleteSimCardMessagesResponse 
.const [406] = Utf8 (I)V 
.const [407] = Utf8 de/esolutions/fw/comm/dsi/messaging/DSIMessagingReply 
.const [408] = Utf8 decodeAttachmentResponse 
.const [409] = Utf8 (ILorg/dsi/ifc/global/ResourceLocator;)V 
.const [410] = Utf8 de/esolutions/fw/comm/dsi/messaging/DSIMessagingReply 
.const [411] = Utf8 asyncException 
.const [412] = Utf8 (ILjava/lang/String;I)V 
.const [413] = Utf8 de/esolutions/fw/comm/dsi/messaging/DSIMessagingReply 
.const [414] = Utf8 yyIndication 
.const [415] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [416] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingReplyService 
.const [417] = Class [416] 
.const [418] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [419] = Class [418] 
.const [420] = Utf8 context 
.const [421] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [422] = Utf8 dynamicHandle 
.const [423] = Utf8 I 
.const [424] = Utf8 p_DSIMessagingReply 
.const [425] = Utf8 Lde/esolutions/fw/comm/dsi/messaging/DSIMessagingReply; 
.const [426] = Utf8 Code 
.const [427] = Utf8 <init> 
.const [428] = Utf8 (Lde/esolutions/fw/comm/dsi/messaging/DSIMessagingReply;)V 
.const [429] = Utf8 nextDynamicHandle 
.const [430] = Utf8 ()I 
.const [431] = Utf8 getCallContext 
.const [432] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [433] = Utf8 handleCallMethod 
.const [434] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [435] = Utf8 <clinit> 
.const [436] = Utf8 ()V 
.end class 
