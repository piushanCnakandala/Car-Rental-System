package lk.Spring.service.impl;

import lk.Spring.dto.StaffDTO;
import lk.Spring.entity.Staff;
import lk.Spring.repo.StaffRepo;
import lk.Spring.service.StaffService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepo staffRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveStaffMember(StaffDTO staffDTO) {
        if (! staffRepo.existsById(staffDTO.getStaff_Id())){
            staffRepo.save(modelMapper.map(staffDTO, Staff.class));
        }else {
            throw new RuntimeException("Staff Member  Already Saved");
        }

    }

    @Override
    public void deleteStaffMember(String id) {

    }

    @Override
    public void updateStaffMember(StaffDTO staffDTO) {

    }

    @Override
    public StaffDTO searchStaffMember(String id) {
        return null;
    }

    @Override
    public List<StaffDTO> getAllStaffMembers() {
        return null;
    }
}
