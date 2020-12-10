package cn.com.taiji.service.Impl;

import cn.com.taiji.domain.state.NormOfScheme;
import cn.com.taiji.domain.state.Scheme;
import cn.com.taiji.repository.state.SchemeRepo;
import cn.com.taiji.service.NormOfSchemeService;
import cn.com.taiji.service.SchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SchemeServiceImpl implements SchemeService {

    @Autowired
    private SchemeRepo schemeRepo;
    @Autowired
    private NormOfSchemeService normOfSchemeService;

    @Override
    public void add() {

    }

    @Override
    public Map<String, Float> getBaseNormWeight(String catalogInfo) {
        boolean bool = true;
        Scheme scheme = schemeRepo.findByUseFlag(bool);
        Map<String, Float> weight = normOfSchemeService.getBaseNormWeight(scheme.getId(), catalogInfo);
        return weight;
    }
}
