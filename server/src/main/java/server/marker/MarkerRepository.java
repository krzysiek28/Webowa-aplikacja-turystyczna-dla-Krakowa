package server.marker;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MarkerRepository extends JpaRepository<MarkerEntity, Integer> {
}
