package cn.com.taiji.service.Impl;

import cn.com.taiji.domain.state.*;
import cn.com.taiji.repository.state.*;
import cn.com.taiji.service.InitStateDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class InitStateDataServiceImpl implements InitStateDataService {

    @Autowired
    private AwosStateRepo awosStateRepo;
    @Autowired
    private MessageStateRepo messageStateRepo;
    @Autowired
    private RadarStateRepo radarStateRepo;
    @Autowired
    private SatelStateRepo satelStateRepo;
    @Autowired
    private TopologyStateRepo topologyStateRepo;
    @Autowired
    private TopologySpeedRepo topologySpeedRepo;

    @Override
    public void initStateData() {
        this.initAwosStateData();
        this.initMessageStateData();
        this.initRadarStateData();
        this.initSatelStateData();
        this.initTopologyStateData();
    }

    public void initAwosStateData(){
        LocalDateTime time = LocalDateTime.now();

        List<AwosState> awosStateList = new ArrayList<AwosState>();

        AwosState awosState1 = new AwosState("ZYTX", time, 56);
        AwosState awosState2 = new AwosState("ZYHB", time, 52);
        AwosState awosState3 = new AwosState("ZYTL", time, 48);
        AwosState awosState4 = new AwosState("ZYCC", time, 46);

        awosStateList.add(awosState1);
        awosStateList.add(awosState2);
        awosStateList.add(awosState3);
        awosStateList.add(awosState4);

        awosStateRepo.saveAll(awosStateList);
    }

    public void initMessageStateData(){
        LocalDateTime time = LocalDateTime.now();

        List<MessageState> stateList = new ArrayList<MessageState>();

        MessageState state1 = new MessageState("ZYTX",true, true,true,true, time);
        MessageState state2 = new MessageState("ZYHB",true, true,true,true, time);
        MessageState state3 = new MessageState("ZYTL",true, true,true,true, time);
        MessageState state4 = new MessageState("ZYCC",false,false,false,false,time);

        stateList.add(state1);
        stateList.add(state2);
        stateList.add(state3);
        stateList.add(state4);

        messageStateRepo.saveAll(stateList);
    }

    public void initRadarStateData(){
        LocalDateTime time = LocalDateTime.now();

        List<RadarState> stateList = new ArrayList<RadarState>();

        RadarState state1 = new RadarState("ZYTX", time, 56);
        RadarState state2 = new RadarState("ZYHB", time, 52);
        RadarState state3 = new RadarState("ZYTL", time, 48);
        RadarState state4 = new RadarState("ZYCC", time, 46);

        stateList.add(state1);
        stateList.add(state2);
        stateList.add(state3);
        stateList.add(state4);

        radarStateRepo.saveAll(stateList);
    }

    public void initSatelStateData(){
        LocalDateTime time = LocalDateTime.now();

        List<SatelState> stateList = new ArrayList<SatelState>();

        SatelState state1 = new SatelState("风云2", time, 56);
        SatelState state2 = new SatelState("风云4", time, 52);
        SatelState state3 = new SatelState("葵花8", time, 48);

        stateList.add(state1);
        stateList.add(state2);
        stateList.add(state3);

        satelStateRepo.saveAll(stateList);
    }


    public void initTopologyStateData(){

        List<TopologyState> stateList = new ArrayList<TopologyState>();

        TopologyState state1 = new TopologyState(TopologyState.DevType.EXCHANGE, true , "100.9.102.100");
        TopologyState state2 = new TopologyState(TopologyState.DevType.EXCHANGE, true , "100.9.102.101");
        TopologyState state3 = new TopologyState(TopologyState.DevType.EXCHANGE, true , "100.9.102.102");

        TopologyState state4 = new TopologyState(TopologyState.DevType.SERVER, true , "100.9.102.103");
        TopologyState state5 = new TopologyState(TopologyState.DevType.SERVER, true , "100.9.102.104");
        TopologyState state6 = new TopologyState(TopologyState.DevType.SERVER, true , "100.9.102.105");

        TopologyState state7 = new TopologyState(TopologyState.DevType.SERVER, true , "100.9.102.106");
        TopologyState state8 = new TopologyState(TopologyState.DevType.SERVER, true , "100.9.102.107");

        TopologyState state9 = new TopologyState(TopologyState.DevType.SERVER, true , "100.9.102.108");
        TopologyState state10 = new TopologyState(TopologyState.DevType.SERVER, true , "100.9.102.109");
        TopologyState state11 = new TopologyState(TopologyState.DevType.SERVER, true , "100.9.102.110");
        TopologyState state12 = new TopologyState(TopologyState.DevType.SERVER, true , "100.9.102.111");

        stateList.add(state1);
        stateList.add(state2);
        stateList.add(state3);
        stateList.add(state4);
        stateList.add(state5);
        stateList.add(state6);
        stateList.add(state7);
        stateList.add(state8);
        stateList.add(state9);
        stateList.add(state10);
        stateList.add(state11);
        stateList.add(state12);

        topologyStateRepo.saveAll(stateList);

        List<TopologySpeed> speedList = new ArrayList<TopologySpeed>();
        TopologySpeed speed1 = new TopologySpeed(10, "1","2");
        TopologySpeed speed2 = new TopologySpeed(10, "2","3");

        TopologySpeed speed3 = new TopologySpeed(10, "4","1");
        TopologySpeed speed4 = new TopologySpeed(10, "5","1");
        TopologySpeed speed5 = new TopologySpeed(10, "6","1");

        TopologySpeed speed6 = new TopologySpeed(10, "7","2");
        TopologySpeed speed7 = new TopologySpeed(10, "8","2");

        TopologySpeed speed8 = new TopologySpeed(10, "9","3");
        TopologySpeed speed9 = new TopologySpeed(10, "10","3");
        TopologySpeed speed10 = new TopologySpeed(10, "11","3");
        TopologySpeed speed11 = new TopologySpeed(10, "12","3");

        speedList.add(speed1);
        speedList.add(speed2);
        speedList.add(speed3);
        speedList.add(speed4);
        speedList.add(speed5);
        speedList.add(speed6);
        speedList.add(speed7);
        speedList.add(speed8);
        speedList.add(speed9);
        speedList.add(speed10);
        speedList.add(speed11);

        topologySpeedRepo.saveAll(speedList);
    }
}
