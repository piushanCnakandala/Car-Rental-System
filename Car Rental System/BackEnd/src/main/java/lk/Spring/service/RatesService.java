package lk.Spring.service;

import lk.Spring.dto.CustomerDTO;
import lk.Spring.dto.RatesDTO;

import java.util.List;

public interface RatesService {

    void SaveRates(RatesDTO ratesDTO);
    void deleteRates(String id);
    void updateRates(RatesDTO ratesDTO);
    RatesDTO searchRates(String id);
    List<RatesDTO> getAllRates();

}
