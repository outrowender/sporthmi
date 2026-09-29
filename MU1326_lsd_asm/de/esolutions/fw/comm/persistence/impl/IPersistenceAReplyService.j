.version 50 0 
.class public super [347] 
.super [349] 
.field private static final [350] [351] 
.field private static [352] [353] 
.field private [354] [355] 

.method public [357] : [358] 
    .attribute [356] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [37] 
L4:     dup 
L5:     ldc [3] 
L7:     invokestatic [4] 
L10:    ldc [5] 
L12:    ldc [6] 
L14:    invokespecial [31] 
L17:    invokespecial [32] 
L20:    aload_0 
L21:    aload_1 
L22:    putfield [38] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private static synchronized [359] : [360] 
    .attribute [356] .code stack 2 locals 1 
L0:     getstatic [7] 
L3:     iconst_1 
L4:     iadd 
L5:     dup 
L6:     putstatic [33] 
L9:     istore_0 
L10:    iload_0 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [361] : [362] 
    .attribute [356] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [363] : [364] 
    .attribute [356] .code stack 7 locals 9 
        .catch [15] from L0 to L1397 using L1400 
L0:     iload_1 
L1:     tableswitch 52 
            L422 
            L1136 
            L244 
            L1310 
            L1250 
            L452 
            L512 
            L482 
            L1370 
            L792 
            L1370 
            L842 
            L1370 
            L592 
            L1370 
            L642 
            L1370 
            L692 
            L1370 
            L742 
            L1086 
            L194 
            L144 
            L390 
            L358 
            L552 
            L956 
            L1036 
            L1370 
            L996 
            L316 
            L274 
            default : L1370 

L144:   aload_2 
L145:   invokeinterface [39] 0 
L150:   lstore 7 
L152:   aload_2 
L153:   invokeinterface [40] 0 
L158:   astore 9 
L160:   aload_2 
L161:   invokestatic [9] 
L164:   astore 10 
L166:   aload_2 
L167:   invokeinterface [41] 0 
L172:   istore 11 
L174:   aload_0 
L175:   getfield [26] 
L178:   lload 7 
L180:   aload 9 
L182:   aload 10 
L184:   iload 11 
L186:   invokeinterface [42] 0 
L191:   goto L1397 
L194:   aload_2 
L195:   invokeinterface [40] 0 
L200:   astore 7 
L202:   aload_2 
L203:   invokeinterface [40] 0 
L208:   astore 8 
L210:   aload_2 
L211:   invokestatic [9] 
L214:   astore 9 
L216:   aload_2 
L217:   invokeinterface [41] 0 
L222:   istore 10 
L224:   aload_0 
L225:   getfield [26] 
L228:   aload 7 
L230:   aload 8 
L232:   aload 9 
L234:   iload 10 
L236:   invokeinterface [43] 0 
L241:   goto L1397 
L244:   aload_2 
L245:   invokestatic [9] 
L248:   astore 7 
L250:   aload_2 
L251:   invokeinterface [41] 0 
L256:   istore 8 
L258:   aload_0 
L259:   getfield [26] 
L262:   aload 7 
L264:   iload 8 
L266:   invokeinterface [44] 0 
L271:   goto L1397 
L274:   aload_2 
L275:   invokeinterface [39] 0 
L280:   lstore 7 
L282:   aload_2 
L283:   invokeinterface [40] 0 
L288:   astore 9 
L290:   aload_2 
L291:   invokeinterface [41] 0 
L296:   istore 10 
L298:   aload_0 
L299:   getfield [26] 
L302:   lload 7 
L304:   aload 9 
L306:   iload 10 
L308:   invokeinterface [45] 0 
L313:   goto L1397 
L316:   aload_2 
L317:   invokeinterface [40] 0 
L322:   astore 7 
L324:   aload_2 
L325:   invokeinterface [40] 0 
L330:   astore 8 
L332:   aload_2 
L333:   invokeinterface [41] 0 
L338:   istore 9 
L340:   aload_0 
L341:   getfield [26] 
L344:   aload 7 
L346:   aload 8 
L348:   iload 9 
L350:   invokeinterface [46] 0 
L355:   goto L1397 
L358:   aload_2 
L359:   invokeinterface [39] 0 
L364:   lstore 7 
L366:   aload_2 
L367:   invokeinterface [41] 0 
L372:   istore 9 
L374:   aload_0 
L375:   getfield [26] 
L378:   lload 7 
L380:   iload 9 
L382:   invokeinterface [47] 0 
L387:   goto L1397 
L390:   aload_2 
L391:   invokeinterface [40] 0 
L396:   astore 7 
L398:   aload_2 
L399:   invokeinterface [41] 0 
L404:   istore 8 
L406:   aload_0 
L407:   getfield [26] 
L410:   aload 7 
L412:   iload 8 
L414:   invokeinterface [48] 0 
L419:   goto L1397 
L422:   aload_2 
L423:   invokestatic [9] 
L426:   astore 7 
L428:   aload_2 
L429:   invokeinterface [41] 0 
L434:   istore 8 
L436:   aload_0 
L437:   getfield [26] 
L440:   aload 7 
L442:   iload 8 
L444:   invokeinterface [49] 0 
L449:   goto L1397 
L452:   aload_2 
L453:   invokestatic [9] 
L456:   astore 7 
L458:   aload_2 
L459:   invokeinterface [41] 0 
L464:   istore 8 
L466:   aload_0 
L467:   getfield [26] 
L470:   aload 7 
L472:   iload 8 
L474:   invokeinterface [50] 0 
L479:   goto L1397 
L482:   aload_2 
L483:   invokestatic [9] 
L486:   astore 7 
L488:   aload_2 
L489:   invokeinterface [41] 0 
L494:   istore 8 
L496:   aload_0 
L497:   getfield [26] 
L500:   aload 7 
L502:   iload 8 
L504:   invokeinterface [51] 0 
L509:   goto L1397 
L512:   aload_2 
L513:   invokestatic [9] 
L516:   astore 7 
L518:   aload_2 
L519:   invokeinterface [39] 0 
L524:   lstore 8 
L526:   aload_2 
L527:   invokeinterface [41] 0 
L532:   istore 10 
L534:   aload_0 
L535:   getfield [26] 
L538:   aload 7 
L540:   lload 8 
L542:   iload 10 
L544:   invokeinterface [52] 0 
L549:   goto L1397 
L552:   aload_2 
L553:   invokestatic [9] 
L556:   astore 7 
L558:   aload_2 
L559:   invokeinterface [39] 0 
L564:   lstore 8 
L566:   aload_2 
L567:   invokeinterface [41] 0 
L572:   istore 10 
L574:   aload_0 
L575:   getfield [26] 
L578:   aload 7 
L580:   lload 8 
L582:   iload 10 
L584:   invokeinterface [53] 0 
L589:   goto L1397 
L592:   aload_2 
L593:   invokestatic [9] 
L596:   astore 7 
L598:   aload_2 
L599:   invokeinterface [39] 0 
L604:   lstore 8 
L606:   aload_2 
L607:   invokeinterface [39] 0 
L612:   lstore 10 
L614:   aload_2 
L615:   invokeinterface [41] 0 
L620:   istore 12 
L622:   aload_0 
L623:   getfield [26] 
L626:   aload 7 
L628:   lload 8 
L630:   lload 10 
L632:   iload 12 
L634:   invokeinterface [54] 0 
L639:   goto L1397 
L642:   aload_2 
L643:   invokestatic [9] 
L646:   astore 7 
L648:   aload_2 
L649:   invokeinterface [55] 0 
L654:   astore 8 
L656:   aload_2 
L657:   invokeinterface [55] 0 
L662:   astore 9 
L664:   aload_2 
L665:   invokeinterface [56] 0 
L670:   astore 10 
L672:   aload_0 
L673:   getfield [26] 
L676:   aload 7 
L678:   aload 8 
L680:   aload 9 
L682:   aload 10 
L684:   invokeinterface [57] 0 
L689:   goto L1397 
L692:   aload_2 
L693:   invokestatic [9] 
L696:   astore 7 
L698:   aload_2 
L699:   invokeinterface [39] 0 
L704:   lstore 8 
L706:   aload_2 
L707:   invokeinterface [40] 0 
L712:   astore 10 
L714:   aload_2 
L715:   invokeinterface [41] 0 
L720:   istore 11 
L722:   aload_0 
L723:   getfield [26] 
L726:   aload 7 
L728:   lload 8 
L730:   aload 10 
L732:   iload 11 
L734:   invokeinterface [58] 0 
L739:   goto L1397 
L742:   aload_2 
L743:   invokestatic [9] 
L746:   astore 7 
L748:   aload_2 
L749:   invokeinterface [55] 0 
L754:   astore 8 
L756:   aload_2 
L757:   invokeinterface [59] 0 
L762:   astore 9 
L764:   aload_2 
L765:   invokeinterface [56] 0 
L770:   astore 10 
L772:   aload_0 
L773:   getfield [26] 
L776:   aload 7 
L778:   aload 8 
L780:   aload 9 
L782:   aload 10 
L784:   invokeinterface [60] 0 
L789:   goto L1397 
L792:   aload_2 
L793:   invokestatic [9] 
L796:   astore 7 
L798:   aload_2 
L799:   invokeinterface [39] 0 
L804:   lstore 8 
L806:   aload_2 
L807:   invokeinterface [61] 0 
L812:   astore 10 
L814:   aload_2 
L815:   invokeinterface [41] 0 
L820:   istore 11 
L822:   aload_0 
L823:   getfield [26] 
L826:   aload 7 
L828:   lload 8 
L830:   aload 10 
L832:   iload 11 
L834:   invokeinterface [62] 0 
L839:   goto L1397 
L842:   aload_2 
L843:   invokestatic [9] 
L846:   astore 7 
L848:   aload_2 
L849:   invokeinterface [55] 0 
L854:   astore 8 
L856:   aload_2 
L857:   invokeinterface [63] 0 
L862:   ifne L869 
L865:   iconst_1 
L866:   goto L870 
L869:   iconst_0 
L870:   istore 4 
L872:   aconst_null 
L873:   checkcast [10] 
L876:   astore 9 
L878:   iload 4 
L880:   ifeq L928 
L883:   aload_2 
L884:   invokeinterface [39] 0 
L889:   lstore 5 
L891:   lload 5 
L893:   l2i 
L894:   anewarray [11] 
L897:   astore 9 
L899:   iconst_0 
L900:   istore 10 
L902:   iload 10 
L904:   i2l 
L905:   lload 5 
L907:   lcmp 
L908:   ifge L928 
L911:   aload 9 
L913:   iload 10 
L915:   aload_2 
L916:   invokeinterface [61] 0 
L921:   aastore 
L922:   iinc 10 1 
L925:   goto L902 
L928:   aload_2 
L929:   invokeinterface [56] 0 
L934:   astore 10 
L936:   aload_0 
L937:   getfield [26] 
L940:   aload 7 
L942:   aload 8 
L944:   aload 9 
L946:   aload 10 
L948:   invokeinterface [64] 0 
L953:   goto L1397 
L956:   aload_2 
L957:   invokestatic [9] 
L960:   astore 7 
L962:   aload_2 
L963:   invokeinterface [39] 0 
L968:   lstore 8 
L970:   aload_2 
L971:   invokeinterface [41] 0 
L976:   istore 10 
L978:   aload_0 
L979:   getfield [26] 
L982:   aload 7 
L984:   lload 8 
L986:   iload 10 
L988:   invokeinterface [65] 0 
L993:   goto L1397 
L996:   aload_2 
L997:   invokestatic [9] 
L1000:  astore 7 
L1002:  aload_2 
L1003:  invokeinterface [55] 0 
L1008:  astore 8 
L1010:  aload_2 
L1011:  invokeinterface [56] 0 
L1016:  astore 9 
L1018:  aload_0 
L1019:  getfield [26] 
L1022:  aload 7 
L1024:  aload 8 
L1026:  aload 9 
L1028:  invokeinterface [66] 0 
L1033:  goto L1397 
L1036:  aload_2 
L1037:  invokestatic [9] 
L1040:  astore 7 
L1042:  aload_2 
L1043:  invokeinterface [55] 0 
L1048:  astore 8 
L1050:  aload_2 
L1051:  invokeinterface [59] 0 
L1056:  astore 9 
L1058:  aload_2 
L1059:  invokeinterface [56] 0 
L1064:  astore 10 
L1066:  aload_0 
L1067:  getfield [26] 
L1070:  aload 7 
L1072:  aload 8 
L1074:  aload 9 
L1076:  aload 10 
L1078:  invokeinterface [67] 0 
L1083:  goto L1397 
L1086:  aload_2 
L1087:  invokestatic [9] 
L1090:  astore 7 
L1092:  aload_2 
L1093:  invokeinterface [55] 0 
L1098:  astore 8 
L1100:  aload_2 
L1101:  invokeinterface [55] 0 
L1106:  astore 9 
L1108:  aload_2 
L1109:  invokeinterface [56] 0 
L1114:  astore 10 
L1116:  aload_0 
L1117:  getfield [26] 
L1120:  aload 7 
L1122:  aload 8 
L1124:  aload 9 
L1126:  aload 10 
L1128:  invokeinterface [68] 0 
L1133:  goto L1397 
L1136:  aload_2 
L1137:  invokestatic [9] 
L1140:  astore 7 
L1142:  aload_2 
L1143:  invokeinterface [55] 0 
L1148:  astore 8 
L1150:  aload_2 
L1151:  invokeinterface [63] 0 
L1156:  ifne L1163 
L1159:  iconst_1 
L1160:  goto L1164 
L1163:  iconst_0 
L1164:  istore 4 
L1166:  aconst_null 
L1167:  checkcast [10] 
L1170:  astore 9 
L1172:  iload 4 
L1174:  ifeq L1222 
L1177:  aload_2 
L1178:  invokeinterface [39] 0 
L1183:  lstore 5 
L1185:  lload 5 
L1187:  l2i 
L1188:  anewarray [11] 
L1191:  astore 9 
L1193:  iconst_0 
L1194:  istore 10 
L1196:  iload 10 
L1198:  i2l 
L1199:  lload 5 
L1201:  lcmp 
L1202:  ifge L1222 
L1205:  aload 9 
L1207:  iload 10 
L1209:  aload_2 
L1210:  invokeinterface [61] 0 
L1215:  aastore 
L1216:  iinc 10 1 
L1219:  goto L1196 
L1222:  aload_2 
L1223:  invokeinterface [56] 0 
L1228:  astore 10 
L1230:  aload_0 
L1231:  getfield [26] 
L1234:  aload 7 
L1236:  aload 8 
L1238:  aload 9 
L1240:  aload 10 
L1242:  invokeinterface [69] 0 
L1247:  goto L1397 
L1250:  aload_2 
L1251:  invokeinterface [39] 0 
L1256:  lstore 7 
L1258:  aload_2 
L1259:  invokeinterface [40] 0 
L1264:  astore 9 
L1266:  aload_2 
L1267:  invokeinterface [40] 0 
L1272:  astore 10 
L1274:  aload_2 
L1275:  invokestatic [9] 
L1278:  astore 11 
L1280:  aload_2 
L1281:  invokeinterface [41] 0 
L1286:  istore 12 
L1288:  aload_0 
L1289:  getfield [26] 
L1292:  lload 7 
L1294:  aload 9 
L1296:  aload 10 
L1298:  aload 11 
L1300:  iload 12 
L1302:  invokeinterface [70] 0 
L1307:  goto L1397 
L1310:  aload_2 
L1311:  invokeinterface [40] 0 
L1316:  astore 7 
L1318:  aload_2 
L1319:  invokeinterface [40] 0 
L1324:  astore 8 
L1326:  aload_2 
L1327:  invokeinterface [40] 0 
L1332:  astore 9 
L1334:  aload_2 
L1335:  invokestatic [9] 
L1338:  astore 10 
L1340:  aload_2 
L1341:  invokeinterface [41] 0 
L1346:  istore 11 
L1348:  aload_0 
L1349:  getfield [26] 
L1352:  aload 7 
L1354:  aload 8 
L1356:  aload 9 
L1358:  aload 10 
L1360:  iload 11 
L1362:  invokeinterface [71] 0 
L1367:  goto L1397 
L1370:  new [72] 
L1373:  dup 
L1374:  new [73] 
L1377:  dup 
L1378:  invokespecial [35] 
L1381:  ldc [14] 
L1383:  invokevirtual [27] 
L1386:  iload_1 
L1387:  invokevirtual [28] 
L1390:  invokevirtual [29] 
L1393:  invokespecial [36] 
L1396:  athrow 
L1397:  goto L1442 
L1400:  astore 4 
L1402:  new [72] 
L1405:  dup 
L1406:  new [73] 
L1409:  dup 
L1410:  invokespecial [35] 
L1413:  ldc [16] 
L1415:  invokevirtual [27] 
L1418:  iload_1 
L1419:  invokevirtual [28] 
L1422:  ldc [17] 
L1424:  invokevirtual [27] 
L1427:  aload 4 
L1429:  invokevirtual [30] 
L1432:  invokevirtual [27] 
L1435:  invokevirtual [29] 
L1438:  invokespecial [36] 
L1441:  athrow 
L1442:  return 
L1443:  nop 
L1444:  
    .end code 
.end method 

.method static [365] : [366] 
    .attribute [356] .code stack 1 locals 0 
L0:     ldc [18] 
L2:     invokestatic [19] 
L5:     putstatic [34] 
L8:     iconst_0 
L9:     putstatic [33] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [74] 
.const [3] = String [75] 
.const [4] = Method [76] [77] 
.const [5] = String [78] 
.const [6] = String [79] 
.const [7] = Field [80] [81] 
.const [8] = Field [82] [83] 
.const [9] = Method [84] [85] 
.const [10] = Class [86] 
.const [11] = Class [87] 
.const [12] = Class [88] 
.const [13] = Class [89] 
.const [14] = String [90] 
.const [15] = Class [91] 
.const [16] = String [92] 
.const [17] = String [93] 
.const [18] = String [94] 
.const [19] = Method [95] [96] 
.const [20] = Class [97] 
.const [21] = Class [98] 
.const [22] = Class [99] 
.const [23] = Class [100] 
.const [24] = Class [101] 
.const [25] = Class [102] 
.const [26] = Field [103] [104] 
.const [27] = Method [105] [106] 
.const [28] = Method [107] [108] 
.const [29] = Method [109] [110] 
.const [30] = Method [111] [112] 
.const [31] = Method [113] [114] 
.const [32] = Method [115] [116] 
.const [33] = Field [117] [118] 
.const [34] = Field [119] [120] 
.const [35] = Method [121] [122] 
.const [36] = Method [123] [124] 
.const [37] = Class [125] 
.const [38] = Field [126] [127] 
.const [39] = InterfaceMethod [128] [129] 
.const [40] = InterfaceMethod [130] [131] 
.const [41] = InterfaceMethod [132] [133] 
.const [42] = InterfaceMethod [134] [135] 
.const [43] = InterfaceMethod [136] [137] 
.const [44] = InterfaceMethod [138] [139] 
.const [45] = InterfaceMethod [140] [141] 
.const [46] = InterfaceMethod [142] [143] 
.const [47] = InterfaceMethod [144] [145] 
.const [48] = InterfaceMethod [146] [147] 
.const [49] = InterfaceMethod [148] [149] 
.const [50] = InterfaceMethod [150] [151] 
.const [51] = InterfaceMethod [152] [153] 
.const [52] = InterfaceMethod [154] [155] 
.const [53] = InterfaceMethod [156] [157] 
.const [54] = InterfaceMethod [158] [159] 
.const [55] = InterfaceMethod [160] [161] 
.const [56] = InterfaceMethod [162] [163] 
.const [57] = InterfaceMethod [164] [165] 
.const [58] = InterfaceMethod [166] [167] 
.const [59] = InterfaceMethod [168] [169] 
.const [60] = InterfaceMethod [170] [171] 
.const [61] = InterfaceMethod [172] [173] 
.const [62] = InterfaceMethod [174] [175] 
.const [63] = InterfaceMethod [176] [177] 
.const [64] = InterfaceMethod [178] [179] 
.const [65] = InterfaceMethod [180] [181] 
.const [66] = InterfaceMethod [182] [183] 
.const [67] = InterfaceMethod [184] [185] 
.const [68] = InterfaceMethod [186] [187] 
.const [69] = InterfaceMethod [188] [189] 
.const [70] = InterfaceMethod [190] [191] 
.const [71] = InterfaceMethod [192] [193] 
.const [72] = Class [194] 
.const [73] = Class [195] 
.const [74] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [75] = Utf8 f4ac6df9-a35a-4f1c-a334-9c2890a41c09 
.const [76] = Class [196] 
.const [77] = NameAndType [197] [198] 
.const [78] = Utf8 '21034d62-3469-5d3a-b904-de8a9709a4ed' 
.const [79] = Utf8 'persistence.IPersistenceA' 
.const [80] = Class [199] 
.const [81] = NameAndType [200] [201] 
.const [82] = Class [202] 
.const [83] = NameAndType [203] [204] 
.const [84] = Class [205] 
.const [85] = NameAndType [206] [207] 
.const [86] = Utf8 [[S 
.const [87] = Utf8 [S 
.const [88] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [89] = Utf8 java/lang/StringBuffer 
.const [90] = Utf8 'Invalid Method Id ' 
.const [91] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [92] = Utf8 'Deserialization failed: method=' 
.const [93] = Utf8 ', error=' 
.const [94] = Utf8 'STUB.persistence.IPersistenceA' 
.const [95] = Class [208] 
.const [96] = NameAndType [209] [210] 
.const [97] = Utf8 de/esolutions/fw/comm/persistence/impl/IPersistenceAReplyService 
.const [98] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [99] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [100] = Utf8 de/esolutions/fw/comm/persistence/impl/PartitionHandleSerializer 
.const [101] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAReply 
.const [102] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [103] = Class [211] 
.const [104] = NameAndType [212] [213] 
.const [105] = Class [214] 
.const [106] = NameAndType [215] [216] 
.const [107] = Class [217] 
.const [108] = NameAndType [218] [219] 
.const [109] = Class [220] 
.const [110] = NameAndType [221] [222] 
.const [111] = Class [223] 
.const [112] = NameAndType [224] [225] 
.const [113] = Class [226] 
.const [114] = NameAndType [227] [228] 
.const [115] = Class [229] 
.const [116] = NameAndType [230] [231] 
.const [117] = Class [232] 
.const [118] = NameAndType [233] [234] 
.const [119] = Class [235] 
.const [120] = NameAndType [236] [237] 
.const [121] = Class [238] 
.const [122] = NameAndType [239] [240] 
.const [123] = Class [241] 
.const [124] = NameAndType [242] [243] 
.const [125] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [126] = Class [244] 
.const [127] = NameAndType [245] [246] 
.const [128] = Class [247] 
.const [129] = NameAndType [248] [249] 
.const [130] = Class [250] 
.const [131] = NameAndType [251] [252] 
.const [132] = Class [253] 
.const [133] = NameAndType [254] [255] 
.const [134] = Class [256] 
.const [135] = NameAndType [257] [258] 
.const [136] = Class [259] 
.const [137] = NameAndType [260] [261] 
.const [138] = Class [262] 
.const [139] = NameAndType [263] [264] 
.const [140] = Class [265] 
.const [141] = NameAndType [266] [267] 
.const [142] = Class [268] 
.const [143] = NameAndType [269] [270] 
.const [144] = Class [271] 
.const [145] = NameAndType [272] [273] 
.const [146] = Class [274] 
.const [147] = NameAndType [275] [276] 
.const [148] = Class [277] 
.const [149] = NameAndType [278] [279] 
.const [150] = Class [280] 
.const [151] = NameAndType [281] [282] 
.const [152] = Class [283] 
.const [153] = NameAndType [284] [285] 
.const [154] = Class [286] 
.const [155] = NameAndType [287] [288] 
.const [156] = Class [289] 
.const [157] = NameAndType [290] [291] 
.const [158] = Class [292] 
.const [159] = NameAndType [293] [294] 
.const [160] = Class [295] 
.const [161] = NameAndType [296] [297] 
.const [162] = Class [298] 
.const [163] = NameAndType [299] [300] 
.const [164] = Class [301] 
.const [165] = NameAndType [302] [303] 
.const [166] = Class [304] 
.const [167] = NameAndType [305] [306] 
.const [168] = Class [307] 
.const [169] = NameAndType [308] [309] 
.const [170] = Class [310] 
.const [171] = NameAndType [311] [312] 
.const [172] = Class [313] 
.const [173] = NameAndType [314] [315] 
.const [174] = Class [316] 
.const [175] = NameAndType [317] [318] 
.const [176] = Class [319] 
.const [177] = NameAndType [320] [321] 
.const [178] = Class [322] 
.const [179] = NameAndType [323] [324] 
.const [180] = Class [325] 
.const [181] = NameAndType [326] [327] 
.const [182] = Class [328] 
.const [183] = NameAndType [329] [330] 
.const [184] = Class [331] 
.const [185] = NameAndType [332] [333] 
.const [186] = Class [334] 
.const [187] = NameAndType [335] [336] 
.const [188] = Class [337] 
.const [189] = NameAndType [338] [339] 
.const [190] = Class [340] 
.const [191] = NameAndType [341] [342] 
.const [192] = Class [343] 
.const [193] = NameAndType [344] [345] 
.const [194] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [195] = Utf8 java/lang/StringBuffer 
.const [196] = Utf8 de/esolutions/fw/comm/persistence/impl/IPersistenceAReplyService 
.const [197] = Utf8 nextDynamicHandle 
.const [198] = Utf8 ()I 
.const [199] = Utf8 de/esolutions/fw/comm/persistence/impl/IPersistenceAReplyService 
.const [200] = Utf8 dynamicHandle 
.const [201] = Utf8 I 
.const [202] = Utf8 de/esolutions/fw/comm/persistence/impl/IPersistenceAReplyService 
.const [203] = Utf8 context 
.const [204] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [205] = Utf8 de/esolutions/fw/comm/persistence/impl/PartitionHandleSerializer 
.const [206] = Utf8 getOptionalPartitionHandle 
.const [207] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/persistence/PartitionHandle; 
.const [208] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [209] = Utf8 getContext 
.const [210] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [211] = Utf8 de/esolutions/fw/comm/persistence/impl/IPersistenceAReplyService 
.const [212] = Utf8 p_IPersistenceAReply 
.const [213] = Utf8 Lde/esolutions/fw/comm/persistence/IPersistenceAReply; 
.const [214] = Utf8 java/lang/StringBuffer 
.const [215] = Utf8 append 
.const [216] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [217] = Utf8 java/lang/StringBuffer 
.const [218] = Utf8 append 
.const [219] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [220] = Utf8 java/lang/StringBuffer 
.const [221] = Utf8 toString 
.const [222] = Utf8 ()Ljava/lang/String; 
.const [223] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [224] = Utf8 getMessage 
.const [225] = Utf8 ()Ljava/lang/String; 
.const [226] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [227] = Utf8 <init> 
.const [228] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [229] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [230] = Utf8 <init> 
.const [231] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [232] = Utf8 de/esolutions/fw/comm/persistence/impl/IPersistenceAReplyService 
.const [233] = Utf8 dynamicHandle 
.const [234] = Utf8 I 
.const [235] = Utf8 de/esolutions/fw/comm/persistence/impl/IPersistenceAReplyService 
.const [236] = Utf8 context 
.const [237] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [238] = Utf8 java/lang/StringBuffer 
.const [239] = Utf8 <init> 
.const [240] = Utf8 ()V 
.const [241] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [242] = Utf8 <init> 
.const [243] = Utf8 (Ljava/lang/String;)V 
.const [244] = Utf8 de/esolutions/fw/comm/persistence/impl/IPersistenceAReplyService 
.const [245] = Utf8 p_IPersistenceAReply 
.const [246] = Utf8 Lde/esolutions/fw/comm/persistence/IPersistenceAReply; 
.const [247] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [248] = Utf8 getUInt32 
.const [249] = Utf8 ()J 
.const [250] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [251] = Utf8 getOptionalString 
.const [252] = Utf8 ()Ljava/lang/String; 
.const [253] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [254] = Utf8 getEnum 
.const [255] = Utf8 ()I 
.const [256] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAReply 
.const [257] = Utf8 openResult 
.const [258] = Utf8 (JLjava/lang/String;Lde/esolutions/fw/comm/persistence/PartitionHandle;I)V 
.const [259] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAReply 
.const [260] = Utf8 openResult 
.const [261] = Utf8 (Ljava/lang/String;Ljava/lang/String;Lde/esolutions/fw/comm/persistence/PartitionHandle;I)V 
.const [262] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAReply 
.const [263] = Utf8 closeResult 
.const [264] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;I)V 
.const [265] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAReply 
.const [266] = Utf8 versionResult 
.const [267] = Utf8 (JLjava/lang/String;I)V 
.const [268] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAReply 
.const [269] = Utf8 versionResult 
.const [270] = Utf8 (Ljava/lang/String;Ljava/lang/String;I)V 
.const [271] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAReply 
.const [272] = Utf8 purgeResult 
.const [273] = Utf8 (JI)V 
.const [274] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAReply 
.const [275] = Utf8 purgeResult 
.const [276] = Utf8 (Ljava/lang/String;I)V 
.const [277] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAReply 
.const [278] = Utf8 beginTransactionResult 
.const [279] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;I)V 
.const [280] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAReply 
.const [281] = Utf8 endTransactionResult 
.const [282] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;I)V 
.const [283] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAReply 
.const [284] = Utf8 flushResult 
.const [285] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;I)V 
.const [286] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAReply 
.const [287] = Utf8 existsResult 
.const [288] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;JI)V 
.const [289] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAReply 
.const [290] = Utf8 removeResult 
.const [291] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;JI)V 
.const [292] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAReply 
.const [293] = Utf8 getIntResult 
.const [294] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;JJI)V 
.const [295] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [296] = Utf8 getOptionalUInt32VarArray 
.const [297] = Utf8 ()[J 
.const [298] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [299] = Utf8 getOptionalEnumVarArray 
.const [300] = Utf8 ()[I 
.const [301] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAReply 
.const [302] = Utf8 getIntsResult 
.const [303] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;[J[J[I)V 
.const [304] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAReply 
.const [305] = Utf8 getStringResult 
.const [306] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;JLjava/lang/String;I)V 
.const [307] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [308] = Utf8 getOptionalStringVarArray 
.const [309] = Utf8 ()[Ljava/lang/String; 
.const [310] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAReply 
.const [311] = Utf8 getStringsResult 
.const [312] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;[J[Ljava/lang/String;[I)V 
.const [313] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [314] = Utf8 getOptionalUInt8VarArray 
.const [315] = Utf8 ()[S 
.const [316] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAReply 
.const [317] = Utf8 getBlobResult 
.const [318] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;J[SI)V 
.const [319] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [320] = Utf8 getBool 
.const [321] = Utf8 ()Z 
.const [322] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAReply 
.const [323] = Utf8 getBlobsResult 
.const [324] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;[J[[S[I)V 
.const [325] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAReply 
.const [326] = Utf8 setResult 
.const [327] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;JI)V 
.const [328] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAReply 
.const [329] = Utf8 unsubscribeResult 
.const [330] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;[J[I)V 
.const [331] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAReply 
.const [332] = Utf8 stringValues 
.const [333] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;[J[Ljava/lang/String;[I)V 
.const [334] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAReply 
.const [335] = Utf8 intValues 
.const [336] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;[J[J[I)V 
.const [337] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAReply 
.const [338] = Utf8 blobValues 
.const [339] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;[J[[S[I)V 
.const [340] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAReply 
.const [341] = Utf8 convertResult 
.const [342] = Utf8 (JLjava/lang/String;Ljava/lang/String;Lde/esolutions/fw/comm/persistence/PartitionHandle;I)V 
.const [343] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAReply 
.const [344] = Utf8 convertResult 
.const [345] = Utf8 (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lde/esolutions/fw/comm/persistence/PartitionHandle;I)V 
.const [346] = Utf8 de/esolutions/fw/comm/persistence/impl/IPersistenceAReplyService 
.const [347] = Class [346] 
.const [348] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [349] = Class [348] 
.const [350] = Utf8 context 
.const [351] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [352] = Utf8 dynamicHandle 
.const [353] = Utf8 I 
.const [354] = Utf8 p_IPersistenceAReply 
.const [355] = Utf8 Lde/esolutions/fw/comm/persistence/IPersistenceAReply; 
.const [356] = Utf8 Code 
.const [357] = Utf8 <init> 
.const [358] = Utf8 (Lde/esolutions/fw/comm/persistence/IPersistenceAReply;)V 
.const [359] = Utf8 nextDynamicHandle 
.const [360] = Utf8 ()I 
.const [361] = Utf8 getCallContext 
.const [362] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [363] = Utf8 handleCallMethod 
.const [364] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [365] = Utf8 <clinit> 
.const [366] = Utf8 ()V 
.end class 
