package cn.com.taiji.service.Impl;

import cn.com.taiji.domain.state.BaseNormType;
import cn.com.taiji.domain.state.NormOfScheme;
import cn.com.taiji.repository.state.NormOfSchemeRepo;
import cn.com.taiji.service.BaseNormTypeService;
import cn.com.taiji.service.NormOfSchemeService;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NormOfSchemeServiceImpl implements NormOfSchemeService {

    @Autowired
    private NormOfSchemeRepo normOfSchemeRepo;
    @Autowired
    private BaseNormTypeService baseNormTypeService;

    @Override
    public void add() {

    }

    @Override
    public Map<String, Float> getBaseNormWeight(Long id, String catalogInfo) {
        Map<String, Float> weight = new HashMap<String, Float>();
        List<NormOfScheme> normOfSchemes = normOfSchemeRepo.findByScheme(id);
        List<BaseNormType> baseNormTypes = baseNormTypeService.findTypesByCatalog(catalogInfo);
        for (BaseNormType ba : baseNormTypes){
            for(NormOfScheme scheme : normOfSchemes){
                if (ba.getId().equals(scheme.getId())){
                    // 直接将百分比转化为float
                    weight.put(ba.getInfo(), scheme.getWeight()*0.01f);
                }
            }
        }
        return weight;
    }
}
