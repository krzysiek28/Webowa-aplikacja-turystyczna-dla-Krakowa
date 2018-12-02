package server.marker;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarkerRepository extends JpaRepository<MarkerEntity, Integer> {
    List<MarkerEntity> findAllByOwner(Integer ownerId);
}
