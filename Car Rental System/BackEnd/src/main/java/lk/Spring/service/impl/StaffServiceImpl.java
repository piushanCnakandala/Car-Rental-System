package lk.Spring.service.impl;

import lk.Spring.dto.StaffDTO;
import lk.Spring.service.StaffService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class StaffServiceImpl implements StaffService {
    @Override
    public void saveStaffMember(StaffDTO staffDTO) {

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
