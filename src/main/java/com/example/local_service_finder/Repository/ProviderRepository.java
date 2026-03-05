package com.example.local_service_finder.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.local_service_finder.Entity.Provider;

public interface ProviderRepository extends JpaRepository<Provider, Long> {
}
