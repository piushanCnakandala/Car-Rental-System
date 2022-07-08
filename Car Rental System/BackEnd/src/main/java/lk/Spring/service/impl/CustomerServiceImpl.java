package lk.Spring.service.impl;

import lk.Spring.dto.CustomerDTO;
import lk.Spring.entity.Customer;
import lk.Spring.repo.CustomerRepo;
import lk.Spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        if (!customerRepo.existsById(customerDTO.getId())){
            customerRepo.save(modelMapper.map(customerDTO, Customer.class));
        }else {
            throw new RuntimeException("Customer  Already Saved");
        }
    }

    @Override
    public void deleteCustomer(String id) {
         if (customerRepo.existsById(id)){
             customerRepo.deleteById(id);
         }else {
             throw new RuntimeException("Customer delete failed");
         }
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
if(customerRepo.existsById(customerDTO.getId())){
    customerRepo.save(modelMapper.map(customerDTO,Customer.class));
        }else{

        }
    }

    @Override
    public CustomerDTO searchCustomer(String id) {
       if (customerRepo.existsById(id)){
           return  modelMapper.map(customerRepo.findById(id).get(),CustomerDTO.class);
       }else {
           throw new RuntimeException("Invalid search");
       }
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return modelMapper.map(customerRepo.findAll(),new TypeToken<List<CustomerDTO>>(){
        }.getType());
    }
}