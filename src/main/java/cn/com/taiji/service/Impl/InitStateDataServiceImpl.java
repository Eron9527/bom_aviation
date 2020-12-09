package cn.com.taiji.service.Impl;

import cn.com.taiji.domain.state.AwosState;
import cn.com.taiji.domain.state.MessageState;
import cn.com.taiji.domain.state.RadarState;
import cn.com.taiji.domain.state.SatelState;
import cn.com.taiji.repository.state.AwosStateRepo;
import cn.com.taiji.repository.state.MessageStateRepo;
import cn.com.taiji.repository.state.RadarStateRepo;
import cn.com.taiji.repository.state.SatelStateRepo;
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

    @Override
    public void initStateData() {
        this.initAwosStateData();
        this.initMessageStateData();
        this.initRadarStateData();
        this.initSatelStateData();
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
}
