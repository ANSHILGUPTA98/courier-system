package model;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data

public class CourierPackage {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String trackingNumber;
	    private Long userId;
	    private Long deliveryPersonId;
	    private String receiverName;
	    private String receiverAddress;
	    private String receiverPhone;
	    private String status;

}
