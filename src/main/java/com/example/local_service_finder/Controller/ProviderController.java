package com.example.local_service_finder.Controller;

import com.example.local_service_finder.Entity.Provider;
import com.example.local_service_finder.Repository.ProviderRepository;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/providers")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ProviderController {

    private final ProviderRepository providerRepository;

    @GetMapping
    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

    @PostMapping("/add")
    public Provider addProvider(@RequestBody Provider provider) {
        return providerRepository.save(provider);
    }

    // ADD THIS
    @GetMapping("/{id}")
    @DeleteMapping("/{id}")
    public String deleteProvider(@PathVariable Long id){

        providerRepository.deleteById(id);

        return "Provider Deleted Successfully";
    }
    public Provider getProviderById(@PathVariable Long id) {
        return providerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Provider not found"));
    }
}