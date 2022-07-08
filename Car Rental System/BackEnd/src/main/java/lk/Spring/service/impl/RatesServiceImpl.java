package lk.Spring.service.impl;

import lk.Spring.dto.RatesDTO;
import lk.Spring.repo.RatesRepo;
import lk.Spring.service.RatesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class RatesServiceImpl implements RatesService {
    @Autowired
    private RatesRepo ratesRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void SaveRates(RatesDTO ratesDTO) {

    }

    @Override
    public void deleteRates(String id) {

    }

    @Override
    public void updateRates(RatesDTO ratesDTO) {

    }

    @Override
    public RatesDTO searchRates(String id) {
        return null;
    }

    @Override
    public List<RatesDTO> getAllRates() {
        return null;
    }
}
