package cn.com.taiji.service.Impl;

import cn.com.taiji.domain.state.*;
import cn.com.taiji.repository.state.*;
import cn.com.taiji.service.InitScoreRuleDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InitScoreRuleDataServiceImpl implements InitScoreRuleDataService {

    @Autowired
    private DataCatalogRepo dataCatalogRepo;
    @Autowired
    private DataTypeRepo dataTypeRepo;
    @Autowired
    private BaseNormTypeRepo baseNormTypeRepo;
    @Autowired
    private SchemeRepo schemeRepo;
    @Autowired
    private NormOfSchemeRepo normOfSchemeRepo;

    @Override
    public void initRuleData() {
        // 初始化分组分类及各监控项
        this.initDataCataLogData();
        // 初始化监控项，包括监控项编码名称等和监控项的分组
        this.initDataTypeData();
        // 初始化指标项， 包括配置各个指标项的计算公式
        this.initBaseNormTypeData();
        // 初始化方案
        this.initSchemeData();
        // 初始化配置方案
        this.initNormOfSchemeData();
    }

    public void initDataCataLogData(){

        // 指标： 包括自观、雷达等评分大项
        DataCatalog log1 = new DataCatalog("网络连接状态", DataCatalog.NormGroupType.NORM, 1);
        DataCatalog log2 = new DataCatalog("自观", DataCatalog.NormGroupType.NORM, 2);
        DataCatalog log3 = new DataCatalog("报文", DataCatalog.NormGroupType.NORM, 3);
        DataCatalog log4 = new DataCatalog("雷达图", DataCatalog.NormGroupType.NORM, 4);
        DataCatalog log5 = new DataCatalog("卫星图", DataCatalog.NormGroupType.NORM, 5);

        DataCatalog log6 = new DataCatalog("自观报警", DataCatalog.NormGroupType.DATATYPE, 6);
        DataCatalog log7 = new DataCatalog("自观警告", DataCatalog.NormGroupType.DATATYPE, 7);
        DataCatalog log8 = new DataCatalog("自观过期", DataCatalog.NormGroupType.DATATYPE, 8);
        DataCatalog log9 = new DataCatalog("雷达报警", DataCatalog.NormGroupType.DATATYPE, 9);
        DataCatalog log10 = new DataCatalog("雷达过期", DataCatalog.NormGroupType.DATATYPE, 10);
        DataCatalog log11 = new DataCatalog("卫星图报警", DataCatalog.NormGroupType.DATATYPE, 11);
        DataCatalog log12 = new DataCatalog("报文实时应到", DataCatalog.NormGroupType.DATATYPE, 12);
        DataCatalog log13 = new DataCatalog("报文迟到报", DataCatalog.NormGroupType.DATATYPE, 13);
        DataCatalog log14 = new DataCatalog("报文错误报", DataCatalog.NormGroupType.DATATYPE, 14);

        List<DataCatalog> dataList = new ArrayList<DataCatalog>();
        dataList.add(log1);
        dataList.add(log2);
        dataList.add(log3);
        dataList.add(log4);
        dataList.add(log5);
        dataList.add(log6);
        dataList.add(log7);
        dataList.add(log8);
        dataList.add(log9);
        dataList.add(log10);
        dataList.add(log11);
        dataList.add(log12);
        dataList.add(log13);
        dataList.add(log14);

        dataCatalogRepo.saveAll(dataList);
        System.out.println("============添加列表管理结束==============");
    }

    public void initDataTypeData() {

        // 加入指标为自观分组的监控项，找到自观分组DataCatalog

        List<DataType> dataTypes = new ArrayList<DataType>();

        // 添加自观报警监控项
        DataCatalog awosWarnlog = null;
        List<DataCatalog> logs = dataCatalogRepo.findByInfo("自观报警");

        if (logs != null && logs.size() > 0){
            awosWarnlog = logs.get(0);
            DataType type1 = new DataType(awosWarnlog, "AWOS_CT25K_WARN", "CT25K设备状态报警", DataType.ValueType.NUM, -5, 0);
            DataType type2 = new DataType(awosWarnlog, "AWOS_MITRAS_EX_WARN", "MITRAS发射机报警", DataType.ValueType.NUM, -5, 0);
            DataType type3 = new DataType(awosWarnlog, "AWOS_MITRAS_RX_WARN", "MITRAS接收机报警", DataType.ValueType.NUM, -5, 0);
            DataType type4 = new DataType(awosWarnlog, "AWOS_LT31_WARN", "LT31总体状态报警", DataType.ValueType.NUM, -5, 0);
            DataType type5 = new DataType(awosWarnlog, "AWOS_MOR_WRAN", "MOR（气象光学能见度）状态报警", DataType.ValueType.NUM,-5, 0);
            DataType type6 = new DataType(awosWarnlog, "AWOS_LT31_EX_WARN", "LT31发射机状态报警", DataType.ValueType.NUM, -5, 0);
            DataType type7 = new DataType(awosWarnlog, "AWOS_LT31_RX_WARN", "LT31接收机状态报警", DataType.ValueType.NUM, -5, 0);
            DataType type8 = new DataType(awosWarnlog, "AWOS_LT31_PWD_WARN", "LT31 PWD 状态报警", DataType.ValueType.NUM, -5, 0);
            DataType type9 = new DataType(awosWarnlog, "AWOS_LM21_WARN", "LM21背景亮度仪报警", DataType.ValueType.NUM, -5, 0);
            DataType type10 = new DataType(awosWarnlog, "AWOS_FD12_WARN", "FD12设备状态报警", DataType.ValueType.NUM, -5, 0);
            DataType type11 = new DataType(awosWarnlog, "AWOS_FD12P_WARN", "FD12P设备状态报警", DataType.ValueType.NUM, -5, 0);
            DataType type12 = new DataType(awosWarnlog, "AWOS_FS11_WARN", "FS11设备状态报警", DataType.ValueType.NUM, -5, 0);
            DataType type13 = new DataType(awosWarnlog, "AWOS_MILOS500_WARN", "MILOS500自动气象站报警", DataType.ValueType.NUM, -5, 0);
            DataType type14 = new DataType(awosWarnlog, "AWOS_CBME80B_WARN", "CBME80B设备状态报警", DataType.ValueType.NUM, -5, 0);
            DataType type15 = new DataType(awosWarnlog, "AWOS_PTB330_WARN", "PTB330气压计模块报警", DataType.ValueType.NUM, -5, 0);
            DataType type16 = new DataType(awosWarnlog, "AWOS_APOS300_WARN", "APOS300自动站离线报警", DataType.ValueType.NUM, -5, 0);
            DataType type17 = new DataType(awosWarnlog, "AWOS_TR30_WARN", "TR30大气透射仪报警", DataType.ValueType.NUM, -5, 0);

            dataTypes.add(type1);
            dataTypes.add(type2);
            dataTypes.add(type3);
            dataTypes.add(type4);
            dataTypes.add(type5);
            dataTypes.add(type6);
            dataTypes.add(type7);
            dataTypes.add(type8);
            dataTypes.add(type9);
            dataTypes.add(type10);
            dataTypes.add(type11);
            dataTypes.add(type12);
            dataTypes.add(type13);
            dataTypes.add(type14);
            dataTypes.add(type15);
            dataTypes.add(type16);
            dataTypes.add(type17);

        }else{
            System.out.println("------------新建自观报警分组下的监控项时，没有找到自观报警分组-------------------");
        }


        // 添加自观警告监控项
        DataCatalog awosAlarmLog = null;
        logs = dataCatalogRepo.findByInfo("自观警告");
        if (logs != null && logs.size() > 0){
            awosAlarmLog = logs.get(0);
            DataType type18 = new DataType(awosAlarmLog, "AWOS_LT31_EX_ALARM", "LT31总体状态警告", DataType.ValueType.NUM,-5, 0);
            DataType type19 = new DataType(awosAlarmLog, "AWOS_LT31_RX_ALARM", "LT31发射机状态警告", DataType.ValueType.NUM, -5, 0);
            DataType type20 = new DataType(awosAlarmLog, "AWOS_LT31 PWD_ALARM", "LT31 PWD 状态警告", DataType.ValueType.NUM, -5, 0);
            DataType type21 = new DataType(awosAlarmLog, "AWOS_LM21_ALARM", "LM21背景亮度仪警告", DataType.ValueType.NUM, -5, 0);
            DataType type22 = new DataType(awosAlarmLog, "AWOS_FD12_ALARM", "FD12前散射式能见度仪警告", DataType.ValueType.NUM, -5, 0);
            DataType type23 = new DataType(awosAlarmLog, "AWOS_FD12P_ALARM", "FD12P前散射式能见度仪报警", DataType.ValueType.NUM, -5, 0);
            DataType type24 = new DataType(awosAlarmLog, "AWOS_FS11_ALARM", "FS11前向散射仪警告", DataType.ValueType.NUM, -5, 0);
            DataType type25 = new DataType(awosAlarmLog, "AWOS_MILOS500_ALARM", "MILOS500自动气象站警告", DataType.ValueType.NUM, -5, 0);
            DataType type26 = new DataType(awosAlarmLog, "AWOS_MAWS301_ALARM", "MAWS301自动气象站警告", DataType.ValueType.NUM, -5, 0);
            DataType type27 = new DataType(awosAlarmLog, "AWOS_CBME80B_ALARM", "CBME80B设备状态警告", DataType.ValueType.NUM, -5, 0);
            DataType type28 = new DataType(awosAlarmLog, "AWOS_TR30_ALARM", "TR30大气透射仪警告", DataType.ValueType.NUM, -5, 0);

            dataTypes.add(type18);
            dataTypes.add(type19);
            dataTypes.add(type20);
            dataTypes.add(type21);
            dataTypes.add(type22);
            dataTypes.add(type23);
            dataTypes.add(type24);
            dataTypes.add(type25);
            dataTypes.add(type26);
            dataTypes.add(type27);
            dataTypes.add(type28);

        } else{
            System.out.println("------------新建自观警告分组下的监控项时，没有找到自观警告分组-------------------");
        }


        // 添加雷达报警监控项
        DataCatalog radarWarnLog = null;
        logs = dataCatalogRepo.findByInfo("雷达报警");
        if (logs != null && logs.size() > 0){
            radarWarnLog = logs.get(0);
            DataType type29 = new DataType(radarWarnLog, "RADAR_GLC_18_LAUCH_WARN", "GLC-18发射系统报警", DataType.ValueType.NUM, -5, 0);
            DataType type30 = new DataType(radarWarnLog, "RADAR_GLC_18_RECEIVE_WARN", "GLC-18接收系统报警", DataType.ValueType.NUM, -5, 0);
            DataType type31 = new DataType(radarWarnLog, "RADAR_GLC_18_SERVO_WARN", "GLC-18伺服系统报警", DataType.ValueType.NUM, -5, 0);
            DataType type32 = new DataType(radarWarnLog, "RADAR_ADWR_LAUCH_WARN", "ADWR发射系统报警", DataType.ValueType.NUM, -5, 0);
            DataType type33 = new DataType(radarWarnLog, "RADAR_ADWR_RECEIVE_WARN", "ADWR接收系统报警", DataType.ValueType.NUM, -5, 0);
            DataType type34 = new DataType(radarWarnLog, "RADAR_ADWR_SIGNAL_WARN", "ADWR信号处理和监控系统报警", DataType.ValueType.NUM, -5, 0);
            DataType type35 = new DataType(radarWarnLog, "RADAR_ADWR_SERVO_WARN", "ADWR伺服系统报警", DataType.ValueType.NUM, -5, 0);
            DataType type36 = new DataType(radarWarnLog, "RADAR_714CDN_LAUCH_WARN", "714CDN发射系统报警", DataType.ValueType.NUM, -5, 0);
            DataType type37 = new DataType(radarWarnLog, "RADAR_714CDN_RECEIVE_WARN", "714CDN接收系统报警", DataType.ValueType.NUM, -5, 0);
            DataType type38 = new DataType(radarWarnLog, "RADAR_714CDN_SIGNAL_WARN", "714CDN信号处理系统报警", DataType.ValueType.NUM, -5, 0);
            DataType type39 = new DataType(radarWarnLog, "RADAR_714CDN_SERVO_WARN", "714CDN伺服系统报警", DataType.ValueType.NUM, -5, 0);
            DataType type40 = new DataType(radarWarnLog, "RADAR_714CDN_DISTRIBU_WARN", "714CDN配电系统报警", DataType.ValueType.NUM, -5, 0);

            dataTypes.add(type29);
            dataTypes.add(type30);
            dataTypes.add(type31);
            dataTypes.add(type32);
            dataTypes.add(type33);
            dataTypes.add(type34);
            dataTypes.add(type35);
            dataTypes.add(type36);
            dataTypes.add(type37);
            dataTypes.add(type38);
            dataTypes.add(type39);
            dataTypes.add(type40);

        } else{
            System.out.println("------------新建雷达报警分组下的监控项时，没有找到雷达报警分组-------------------");
        }


        // 添加报文实时应到监控项
        DataCatalog messageArrivedLog = null;
        logs = dataCatalogRepo.findByInfo("报文实时应到");
        if (logs != null && logs.size() > 0) {
            messageArrivedLog = logs.get(0);
            DataType type41 = new DataType(messageArrivedLog, "MESSAGE_FC_AMOUNT", "FC报文实时应到数量", DataType.ValueType.NUM, -25,0);
            DataType type42 = new DataType(messageArrivedLog, "MESSAGE_FT_AMOUNT", "FT报文实时应到数量", DataType.ValueType.NUM, -25,0);
            DataType type43 = new DataType(messageArrivedLog, "MESSAGE_SA_AMOUNT", "SA报文实时应到数量", DataType.ValueType.NUM, -25,0);
            DataType type44 = new DataType(messageArrivedLog, "MESSAGE_SP_AMOUNT", "SP报文实时应到数量", DataType.ValueType.NUM, -25,0);

            dataTypes.add(type41);
            dataTypes.add(type42);
            dataTypes.add(type43);
            dataTypes.add(type44);

        } else {
            System.out.println("------------新建报文实时应到分组下的监控项时，没有找到报文实时应到分组-------------------");
        }


        // 添加报文迟到监控项
        DataCatalog messageLateLog = null;
        logs = dataCatalogRepo.findByInfo("报文迟到报");
        if (logs != null && logs.size() > 0) {
            messageLateLog = logs.get(0);
            DataType type42 = new DataType(messageArrivedLog, "MESSAGE_SA_LATE", "SA迟到报", DataType.ValueType.NUM, -25,0);
            DataType type43 = new DataType(messageArrivedLog, "MESSAGE_SA_HALF_LATE", "SA半点报迟到报", DataType.ValueType.NUM, -25,0);
            DataType type44 = new DataType(messageArrivedLog, "MESSAGE_FC_LATE", "FC迟到报", DataType.ValueType.NUM, -25,0);
            DataType type45 = new DataType(messageArrivedLog, "MESSAGE_FT_LATE", "FT迟到报", DataType.ValueType.NUM, -25,0);

            dataTypes.add(type42);
            dataTypes.add(type43);
            dataTypes.add(type44);
            dataTypes.add(type45);

        } else {
            System.out.println("------------新建报文迟到报分组下的监控项时，没有找到报文迟到报分组-------------------");
        }


        // 添加报文迟到监控项
        DataCatalog messageErrorLog = null;
        logs = dataCatalogRepo.findByInfo("报文错误报");
        if (logs != null && logs.size() > 0) {
            messageErrorLog = logs.get(0);
            DataType type43 = new DataType(messageErrorLog, "MESSAGE_DATA_AMOUNT", "数据库数量", DataType.ValueType.NUM, -33,0);
            DataType type44 = new DataType(messageErrorLog, "MESSAGE_CALL_COUNT", "总拨打电话次数", DataType.ValueType.NUM,-33,0);
            DataType type45 = new DataType(messageErrorLog, "MESSAGE_FILE_AMOUNT", "留底文件数量", DataType.ValueType.NUM,-33,0);

            dataTypes.add(type43);
            dataTypes.add(type44);
            dataTypes.add(type45);

        } else {
            System.out.println("------------新建报文错误报分组下的监控项时，没有找到报文错误报分组-------------------");
        }

        // 添加报文迟到监控项
        DataCatalog satelErronLog = null;
        logs = dataCatalogRepo.findByInfo("卫星图报警");
        if (logs != null && logs.size() > 0) {
            satelErronLog = logs.get(0);
            DataType type44 = new DataType(satelErronLog, "SATEL_WIND2_STATE", "风云2卫星图状态", DataType.ValueType.NUM, -33,0);
            DataType type45 = new DataType(satelErronLog, "SATEL_WIND4_STATE", "风云4卫星图状态", DataType.ValueType.NUM, -33,0);
            DataType type46 = new DataType(satelErronLog, "SATEL_KH8_STATE", "葵花8卫星图监控状态", DataType.ValueType.NUM, -34,0);
            dataTypes.add(type44);
            dataTypes.add(type45);
            dataTypes.add(type46);
        }else {
            System.out.println("------------新建卫星图错误报分组下的监控项时，没有找到卫星图错误报分组-------------------");
        }



        dataTypeRepo.saveAll(dataTypes);
        System.out.println("=============添加监控项结束===========");

    }

    // 添加具体指标， 把监控项添加进指标中来用于评分。
    public void initBaseNormTypeData(){

        System.out.println("=============添加指标项开始===========");

        List<BaseNormType> baseNromTypes = new ArrayList<BaseNormType>();


        // 自观分组下的指标
        DataCatalog awosLog = null;
        List<DataCatalog> logs = dataCatalogRepo.findByInfo("自观");
        if (logs != null && logs.size() > 0) {
            awosLog = logs.get(0);
            BaseNormType type1 = new BaseNormType(awosLog, "前向散射仪监控状态", "=AWOS_FS11_WARN", 1, "前向散射仪FS11", BaseNormType.ScoreType.HUNDRED);
            BaseNormType type2 = new BaseNormType(awosLog, "跑道现场环境实时状态", "=AWOS_LT31_WARN", 2, "LT31监控跑道实时环境", BaseNormType.ScoreType.HUNDRED);
            BaseNormType type3 = new BaseNormType(awosLog, "大气透射仪监控状态", "=AWOS_LT31_EX_WARN+AWOS_MOR_WRAN+AWOS_LT31_RX_WARN", 3, "大气透射仪实时状态监控", BaseNormType.ScoreType.HUNDRED);
            baseNromTypes.add(type1);
            baseNromTypes.add(type2);
            baseNromTypes.add(type3);

        } else {
            System.out.println("------------新建自观分组下的监控项时，没有找到自观分组-------------------");
        }


        // 雷达分组下的指标
        DataCatalog radarLog = null;
        logs = dataCatalogRepo.findByInfo("雷达图");
        if (logs != null && logs.size() > 0) {
            radarLog = logs.get(0);
            BaseNormType type4 = new BaseNormType(radarLog, "场内各雷达发射机状态", "=RADAR_ADWR_LAUCH_WARN+RADAR_714CDN_LAUCH_WARN+RADAR_GLC_18_LAUCH_WARN", 1, "前向散射仪FS11", BaseNormType.ScoreType.HUNDRED);
            BaseNormType type5 = new BaseNormType(radarLog, "场内各雷达接收机状态", "=RADAR_GLC_18_RECEIVE_WARN+RADAR_ADWR_RECEIVE_WARN+RADAR_714CDN_RECEIVE_WARN", 1, "前向散射仪FS11", BaseNormType.ScoreType.HUNDRED);
            BaseNormType type6 = new BaseNormType(radarLog, "场内各雷达信号处理和监控系统状态", "=RADAR_714CDN_SIGNAL_WARN+RADAR_714CDN_SIGNAL_WARN", 1, "前向散射仪FS11", BaseNormType.ScoreType.HUNDRED);
            baseNromTypes.add(type4);
            baseNromTypes.add(type5);
            baseNromTypes.add(type6);

        } else {
            System.out.println("------------新建雷达图分组下的监控项时，没有找到雷达图分组-------------------");
        }

        // 卫星图分组下的指标项
        DataCatalog satelLog = null;
        logs = dataCatalogRepo.findByInfo("卫星图");
        if (logs != null && logs.size() > 0) {
            satelLog = logs.get(0);
            BaseNormType type7 = new BaseNormType(satelLog, "风云2卫星图监控状态", "=SATEL_WIND2_STATE", 1, "风云2卫星", BaseNormType.ScoreType.HUNDRED);
            BaseNormType type8 = new BaseNormType(satelLog, "风云4卫星图监控状态", "=SATEL_WIND4_STATE", 1, "风云4卫星", BaseNormType.ScoreType.HUNDRED);
            BaseNormType type9 = new BaseNormType(satelLog, "葵花8卫星图监控状态", "=SATEL_KH8_STATE", 1, "葵花8卫星", BaseNormType.ScoreType.HUNDRED);
            baseNromTypes.add(type7);
            baseNromTypes.add(type8);
            baseNromTypes.add(type9);

        } else {
            System.out.println("------------新建卫星图分组下的监控项时，没有找到卫星图分组-------------------");
        }

        // 报文分组下的指标项
        DataCatalog messageLog = null;
        logs = dataCatalogRepo.findByInfo("报文");
        if (logs != null && logs.size() > 0) {
            messageLog = logs.get(0);
            BaseNormType type10 = new BaseNormType(messageLog, "报文实时数量监控", "=MESSAGE_FC_AMOUNT+MESSAGE_FT_AMOUNT+MESSAGE_SA_AMOUNT+MESSAGE_SP_AMOUNT", 1, "报文实时数量", BaseNormType.ScoreType.HUNDRED);
            BaseNormType type11 = new BaseNormType(messageLog, "迟到报监控状态", "=MESSAGE_SA_LATE+MESSAGE_SA_HALF_LATE+MESSAGE_FC_LATE+MESSAGE_FT_LATE", 1, "迟到报监控", BaseNormType.ScoreType.HUNDRED);
            BaseNormType type12 = new BaseNormType(messageLog, "错误报监控状态", "=MESSAGE_DATA_AMOUNT+MESSAGE_CALL_COUNT+MESSAGE_FILE_AMOUNT", 1, "错误报监控", BaseNormType.ScoreType.HUNDRED);
            baseNromTypes.add(type10);
            baseNromTypes.add(type11);
            baseNromTypes.add(type12);

        }else{
            System.out.println("------------新建报文分组下的监控项时，没有找到报文分组-------------------");
        }

        baseNormTypeRepo.saveAll(baseNromTypes);

        System.out.println("===============保存指标列表结束================");
    }

    public void initSchemeData(){
        List<Scheme> schemes = new ArrayList<Scheme>();

        // 新建解决方案-
        Scheme scheme = new Scheme("方案一", "全部指标项方案",true);
        schemeRepo.save(scheme);
        System.out.println("===============保存方案结束================");

    }

    public void initNormOfSchemeData(){
        List<NormOfScheme> normOfSchemes = new ArrayList<NormOfScheme>();
        Scheme scheme = null;
        List<Scheme> schemes = schemeRepo.findByName("方案一");
        if (schemes != null && schemes.size() > 0){
            scheme = schemes.get(0);
            List<BaseNormType> baseNormTypes = baseNormTypeRepo.findAll();
            if (baseNormTypes != null && baseNormTypes.size() > 0){
                int weight = 100/baseNormTypes.size();   // 计算每一得分指标项的百分比
                for(BaseNormType type : baseNormTypes){
                    normOfSchemeRepo.save(new NormOfScheme(scheme, type, weight, true));
                }
            }

            NormOfScheme nrom = new NormOfScheme();
        }else{
            System.out.println("------------新建方案配置项时，没有找到方案分组-------------------");
        }

    }
}
