package lk.Spring.repo;

import lk.Spring.entity.Vehicle;
import lk.Spring.entity.Vehicle_IMG;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleIMGRepo extends JpaRepository<Vehicle_IMG,String> {
}
