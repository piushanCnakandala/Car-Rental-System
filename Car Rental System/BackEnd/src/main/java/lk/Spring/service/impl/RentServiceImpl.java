package lk.Spring.service.impl;

import lk.Spring.dto.CustomerDTO;
import lk.Spring.dto.RentDTO;
import lk.Spring.entity.Customer;
import lk.Spring.entity.Rent;
import lk.Spring.repo.RentRepo;
import lk.Spring.service.RentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.ws.soap.Addressing;
import java.util.List;
@Service
@Transactional
public class RentServiceImpl implements RentService {

    @Autowired
    private RentRepo rentRepo;

   @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveRent(RentDTO rentDTO) {
        if (!rentRepo.existsById(rentDTO.getRent_Id())){
            rentRepo.save(modelMapper.map(rentDTO, Rent.class));
        }else {
            throw new RuntimeException("Rent  Already Saved");
        }
    }

    @Override
    public void deleteRent(String id) {

    }

    @Override
    public void updateRent(RentDTO rentDTO) {

    }

    @Override
    public RentDTO searchRent(String id) {
        return null;
    }

    @Override
    public List<RentDTO> getAllRent() {
            return modelMapper.map(rentRepo.findAll(),new TypeToken<List<RentDTO>>(){}.getType());
    }
}
