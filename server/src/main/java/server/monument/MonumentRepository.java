package server.monument;

import org.springframework.data.jpa.repository.JpaRepository;
import server.monument.model.MonumentKind;

import java.util.List;

public interface MonumentRepository extends JpaRepository<MonumentEntity, Integer> {
    List<MonumentEntity> findMonumentEntitiesByKind(MonumentKind kind);
}
