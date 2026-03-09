package repository;
import org.springframework.data.jpa.repository.JpaRepository;
import model.CourierPackage;

public interface CourierPackageRepository extends JpaRepository<CourierPackage, Long>  {

}
