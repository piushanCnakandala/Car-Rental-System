package lk.Spring.service;

import lk.Spring.dto.StaffDTO;

import java.util.List;

public interface StaffService {
    void saveStaffMember(StaffDTO staffDTO);
    void deleteStaffMember(String id);
    void updateStaffMember(StaffDTO staffDTO);
    StaffDTO searchStaffMember(String id);
    List<StaffDTO> getAllStaffMembers();
}
