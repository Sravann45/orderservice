package sravan.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sravan.java.models.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}
