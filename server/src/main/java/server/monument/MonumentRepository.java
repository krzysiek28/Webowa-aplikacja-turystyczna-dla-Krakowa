package server.monument;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MonumentRepository extends JpaRepository<MonumentEntity, Integer> {
}
