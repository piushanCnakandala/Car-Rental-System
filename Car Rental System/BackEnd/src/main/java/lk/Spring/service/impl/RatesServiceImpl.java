package lk.Spring.service.impl;

import lk.Spring.dto.CustomerDTO;
import lk.Spring.dto.RatesDTO;
import lk.Spring.entity.Customer;
import lk.Spring.entity.Rates;
import lk.Spring.repo.RatesRepo;
import lk.Spring.service.RatesService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
    public void saveRates(RatesDTO ratesDTO) {
        if (!ratesRepo.existsById(ratesDTO.getRate_Id())) {
            ratesRepo.save(modelMapper.map(ratesDTO, Rates.class));
        } else {
            throw new RuntimeException("Rate  Already Saved");
        }
    }

    @Override
    public void deleteRates(String id) {
        if (ratesRepo.existsById(id)) {
            ratesRepo.deleteById(id);
        } else {
            throw new RuntimeException("Rate delete failed");
        }
    }

    @Override
    public void updateRates(RatesDTO ratesDTO) {
        if (ratesRepo.existsById(ratesDTO.getRate_Id())) {
            ratesRepo.save(modelMapper.map(ratesDTO, Rates.class));
        } else {
            throw new RuntimeException("Rater Update failed");
        }

    }

    @Override
    public RatesDTO searchRates(String id) {
        if (ratesRepo.existsById(id)) {
            return modelMapper.map(ratesRepo.findById(id).get(), RatesDTO.class);
        } else {
            throw new RuntimeException("Invalid search");
        }

    }

    @Override
    public List<RatesDTO> getAllRates() {
        return modelMapper.map(ratesRepo.findAll(),new TypeToken<List<RatesDTO>>(){
        }.getType());
    }

}