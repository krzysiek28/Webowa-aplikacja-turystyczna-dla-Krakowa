package server.monument;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MonumentRepository extends JpaRepository<MonumentEntity, Integer> {
    List<MonumentEntity> findMonumentEntitiesByKind(String kind);
}
