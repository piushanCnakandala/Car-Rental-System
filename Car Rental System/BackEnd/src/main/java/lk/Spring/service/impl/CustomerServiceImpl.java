package lk.Spring.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import lk.Spring.dto.CustomerDTO;
import lk.Spring.dto.CustomerImgDTO;
import lk.Spring.entity.Customer;
import lk.Spring.repo.CustomerRepo;
import lk.Spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
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
             throw new RuntimeException("Customer Update failed");
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
        return modelMapper.map(customerRepo.findAll(),new TypeToken<List<CustomerDTO>>(){}.getType());
    }

    @Override
    public long countUsers() {
        return customerRepo.count();
    }

    @Override
    public void saveCustomerWithImg(String customer, MultipartFile file) {
        CustomerDTO userDTO = null;
        String path = null;
        try {
            userDTO = objectMapper.readValue(customer, CustomerDTO.class);
            System.out.println(userDTO);
        } catch (JsonProcessingException e) {
            e.printStackTrace();

        }
        if (!customerRepo.existsById(userDTO.getCusId())){

            try {
                String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
                File uploadDir = new File(projectPath + "/uploads");
                uploadDir.mkdir();
                file.transferTo(new File(uploadDir.getAbsolutePath()+"/"+userDTO.getCusId()+"_"+file.getOriginalFilename()));
                path="uploads/"+userDTO.getCusId()+"_"+file.getOriginalFilename();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            CustomerImgDTO imgDTO = new CustomerImgDTO();
            imgDTO.setPath(path);
            ArrayList<CustomerImgDTO> arrayList = new ArrayList<>();
            arrayList.add(imgDTO);
            System.out.println(imgDTO.getPath());
            userDTO.setImgs(arrayList);
            customerRepo.save(modelMapper.map(userDTO,Customer.class));
        }else {
            throw new RuntimeException("Customer Already Exist");
        }
    }

}
